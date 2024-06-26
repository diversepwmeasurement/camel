/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.component.fastjson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import org.apache.camel.CamelContext;
import org.apache.camel.CamelContextAware;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.spi.DataFormat;
import org.apache.camel.spi.DataFormatContentTypeHeader;
import org.apache.camel.spi.DataFormatName;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.annotations.Dataformat;
import org.apache.camel.support.service.ServiceSupport;

/**
 * Marshal POJOs to JSON and back using <a href="https://github.com/alibaba/fastjson">Fastjson</a>
 */
@Dataformat("fastjson")
@Metadata(includeProperties = "unmarshalType,unmarshalTypeName,prettyprint,contentTypeHeader")
public class FastjsonDataFormat extends ServiceSupport
        implements DataFormat, DataFormatName, DataFormatContentTypeHeader, CamelContextAware {

    private CamelContext camelContext;
    private FastJsonConfig config;
    private Class<?> unmarshalType;
    private String unmarshalTypeName;
    private Type unmarshalGenericType;
    private boolean serializeNulls;
    private boolean prettyPrint;
    private String dateFormatPattern;
    private boolean contentTypeHeader = true;

    public FastjsonDataFormat() {
        this(Object.class);
    }

    public FastjsonDataFormat(Class<?> unmarshalType) {
        this(null, unmarshalType);
    }

    public FastjsonDataFormat(FastJsonConfig config, Class<?> unmarshalType) {
        this.config = config;
        this.unmarshalType = unmarshalType;
    }

    public FastjsonDataFormat(Type unmarshalGenericType) {
        this(null, unmarshalGenericType);
    }

    public FastjsonDataFormat(FastJsonConfig config, Type unmarshalGenericType) {
        this.config = config;
        this.unmarshalGenericType = unmarshalGenericType;
    }

    @Override
    public CamelContext getCamelContext() {
        return camelContext;
    }

    @Override
    public void setCamelContext(CamelContext camelContext) {
        this.camelContext = camelContext;
    }

    @Override
    public String getDataFormatName() {
        return "fastjson";
    }

    @Override
    public void marshal(final Exchange exchange, final Object graph, final OutputStream stream) throws Exception {
        int len = JSON.writeJSONString(stream,
                config.getCharset(),
                graph,
                config.getSerializeConfig(),
                config.getSerializeFilters(),
                config.getDateFormat(),
                JSON.DEFAULT_GENERATE_FEATURE,
                config.getSerializerFeatures());

        if (contentTypeHeader) {
            Message message = exchange.getMessage();
            message.setHeader(Exchange.CONTENT_TYPE, "application/json");
            message.setHeader(Exchange.CONTENT_LENGTH, len);
        }
    }

    @Override
    public Object unmarshal(Exchange exchange, InputStream stream) throws Exception {
        return unmarshal(exchange, (Object) stream);
    }

    @Override
    public Object unmarshal(Exchange exchange, Object body) throws Exception {
        if (body instanceof String str) {
            if (unmarshalGenericType == null) {
                return JSON.parseObject(str, unmarshalType, config.getFeatures());
            } else {
                return JSON.parseObject(str, unmarshalGenericType, config.getFeatures());
            }
        } else if (body instanceof byte[] arr) {
            if (unmarshalGenericType == null) {
                return JSON.parseObject(arr, unmarshalType, config.getFeatures());
            } else {
                return JSON.parseObject(arr, unmarshalGenericType, config.getFeatures());
            }
        } else {
            // fallback to input stream
            InputStream is = exchange.getContext().getTypeConverter().mandatoryConvertTo(InputStream.class, exchange, body);
            if (unmarshalGenericType == null) {
                return JSON.parseObject(is, config.getCharset(), unmarshalType, config.getFeatures());
            } else {
                return JSON.parseObject(is, config.getCharset(), unmarshalGenericType, config.getFeatures());
            }
        }
    }

    @Override
    protected void doInit() throws Exception {
        if (unmarshalTypeName != null && (unmarshalType == null || unmarshalType == Object.class)) {
            unmarshalType = camelContext.getClassResolver().resolveClass(unmarshalTypeName);
        }
    }

    @Override
    protected void doStart() throws Exception {
        if (config == null) {
            List<SerializerFeature> serializerFeatureList = new ArrayList<>();
            config = new FastJsonConfig();
            if (prettyPrint) {
                serializerFeatureList.add(SerializerFeature.PrettyFormat);
            }
            if (serializeNulls) {
                serializerFeatureList.add(SerializerFeature.WriteMapNullValue);
                serializerFeatureList.add(SerializerFeature.WriteNullBooleanAsFalse);
                serializerFeatureList.add(SerializerFeature.WriteNullListAsEmpty);
                serializerFeatureList.add(SerializerFeature.WriteNullNumberAsZero);
                serializerFeatureList.add(SerializerFeature.WriteNullStringAsEmpty);
            }
            if (this.dateFormatPattern != null) {
                serializerFeatureList.add(SerializerFeature.WriteDateUseDateFormat);
                config.setDateFormat(this.dateFormatPattern);
            }
            config.setSerializerFeatures(serializerFeatureList.toArray(new SerializerFeature[0]));
        }
    }

    @Override
    protected void doStop() throws Exception {
        // noop
    }

    // Properties
    // -------------------------------------------------------------------------

    public Class<?> getUnmarshalType() {
        return this.unmarshalType;
    }

    public void setUnmarshalType(Class<?> unmarshalType) {
        this.unmarshalType = unmarshalType;
    }

    public String getUnmarshalTypeName() {
        return unmarshalTypeName;
    }

    public void setUnmarshalTypeName(String unmarshalTypeName) {
        this.unmarshalTypeName = unmarshalTypeName;
    }

    public Type getUnmarshalGenericType() {
        return this.unmarshalGenericType;
    }

    public void setUnmarshalGenericType(Type unmarshalGenericType) {
        this.unmarshalGenericType = unmarshalGenericType;
    }

    public boolean isSerializeNulls() {
        return serializeNulls;
    }

    public void setSerializeNulls(boolean serializeNulls) {
        this.serializeNulls = serializeNulls;
    }

    public boolean isPrettyPrint() {
        return prettyPrint;
    }

    public void setPrettyPrint(boolean prettyPrint) {
        this.prettyPrint = prettyPrint;
    }

    public String getDateFormatPattern() {
        return dateFormatPattern;
    }

    public void setDateFormatPattern(String dateFormatPattern) {
        this.dateFormatPattern = dateFormatPattern;
    }

    public boolean isContentTypeHeader() {
        return contentTypeHeader;
    }

    /**
     * If enabled then JSON will set the Content-Type header to <tt>application/json</tt> when marshalling.
     */
    public void setContentTypeHeader(boolean contentTypeHeader) {
        this.contentTypeHeader = contentTypeHeader;
    }

    public FastJsonConfig getConfig() {
        return this.config;
    }

}
