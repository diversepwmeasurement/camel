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
package org.apache.camel.builder.endpoint.dsl;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.stream.*;
import javax.annotation.processing.Generated;
import org.apache.camel.builder.EndpointConsumerBuilder;
import org.apache.camel.builder.EndpointProducerBuilder;
import org.apache.camel.builder.endpoint.AbstractEndpointBuilder;

/**
 * Send and receive messages to/from Google Cloud Platform PubSub Lite Service.
 * 
 * Generated by camel build tools - do NOT edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointDslMojo")
public interface GooglePubsubLiteEndpointBuilderFactory {


    /**
     * Builder for endpoint consumers for the Google PubSub Lite component.
     */
    public interface GooglePubsubLiteEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default AdvancedGooglePubsubLiteEndpointConsumerBuilder advanced() {
            return (AdvancedGooglePubsubLiteEndpointConsumerBuilder) this;
        }
        /**
         * Logger ID to use when a match to the parent route required.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param loggerId the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointConsumerBuilder loggerId(String loggerId) {
            doSetProperty("loggerId", loggerId);
            return this;
        }
        /**
         * AUTO = exchange gets ack'ed/nack'ed on completion. NONE = downstream
         * process has to ack/nack explicitly.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.component.google.pubsublite.GooglePubsubLiteConstants.AckMode&lt;/code&gt; type.
         * 
         * Default: AUTO
         * Group: consumer
         * 
         * @param ackMode the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointConsumerBuilder ackMode(
                org.apache.camel.component.google.pubsublite.GooglePubsubLiteConstants.AckMode ackMode) {
            doSetProperty("ackMode", ackMode);
            return this;
        }
        /**
         * AUTO = exchange gets ack'ed/nack'ed on completion. NONE = downstream
         * process has to ack/nack explicitly.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.component.google.pubsublite.GooglePubsubLiteConstants.AckMode&lt;/code&gt; type.
         * 
         * Default: AUTO
         * Group: consumer
         * 
         * @param ackMode the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointConsumerBuilder ackMode(String ackMode) {
            doSetProperty("ackMode", ackMode);
            return this;
        }
        /**
         * The number of parallel streams consuming from the subscription.
         * 
         * The option is a: &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Default: 1
         * Group: consumer
         * 
         * @param concurrentConsumers the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointConsumerBuilder concurrentConsumers(
                Integer concurrentConsumers) {
            doSetProperty("concurrentConsumers", concurrentConsumers);
            return this;
        }
        /**
         * The number of parallel streams consuming from the subscription.
         * 
         * The option will be converted to a
         * &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Default: 1
         * Group: consumer
         * 
         * @param concurrentConsumers the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointConsumerBuilder concurrentConsumers(
                String concurrentConsumers) {
            doSetProperty("concurrentConsumers", concurrentConsumers);
            return this;
        }
        /**
         * Set the maximum period a message ack deadline will be extended. Value
         * in seconds.
         * 
         * The option is a: &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 3600
         * Group: consumer
         * 
         * @param maxAckExtensionPeriod the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointConsumerBuilder maxAckExtensionPeriod(
                int maxAckExtensionPeriod) {
            doSetProperty("maxAckExtensionPeriod", maxAckExtensionPeriod);
            return this;
        }
        /**
         * Set the maximum period a message ack deadline will be extended. Value
         * in seconds.
         * 
         * The option will be converted to a &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Default: 3600
         * Group: consumer
         * 
         * @param maxAckExtensionPeriod the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointConsumerBuilder maxAckExtensionPeriod(
                String maxAckExtensionPeriod) {
            doSetProperty("maxAckExtensionPeriod", maxAckExtensionPeriod);
            return this;
        }
        /**
         * The max number of messages to receive from the server in a single API
         * call.
         * 
         * The option is a: &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Default: 1
         * Group: consumer
         * 
         * @param maxMessagesPerPoll the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointConsumerBuilder maxMessagesPerPoll(
                Integer maxMessagesPerPoll) {
            doSetProperty("maxMessagesPerPoll", maxMessagesPerPoll);
            return this;
        }
        /**
         * The max number of messages to receive from the server in a single API
         * call.
         * 
         * The option will be converted to a
         * &lt;code&gt;java.lang.Integer&lt;/code&gt; type.
         * 
         * Default: 1
         * Group: consumer
         * 
         * @param maxMessagesPerPoll the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointConsumerBuilder maxMessagesPerPoll(
                String maxMessagesPerPoll) {
            doSetProperty("maxMessagesPerPoll", maxMessagesPerPoll);
            return this;
        }
        /**
         * The Service account key that can be used as credentials for the
         * PubSub publisher/subscriber. It can be loaded by default from
         * classpath, but you can prefix with classpath:, file:, or http: to
         * load the resource from different systems.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param serviceAccountKey the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointConsumerBuilder serviceAccountKey(
                String serviceAccountKey) {
            doSetProperty("serviceAccountKey", serviceAccountKey);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint consumers for the Google PubSub Lite
     * component.
     */
    public interface AdvancedGooglePubsubLiteEndpointConsumerBuilder
            extends
                EndpointConsumerBuilder {
        default GooglePubsubLiteEndpointConsumerBuilder basic() {
            return (GooglePubsubLiteEndpointConsumerBuilder) this;
        }
        /**
         * Allows for bridging the consumer to the Camel routing Error Handler,
         * which mean any exceptions (if possible) occurred while the Camel
         * consumer is trying to pickup incoming messages, or the likes, will
         * now be processed as a message and handled by the routing Error
         * Handler. Important: This is only possible if the 3rd party component
         * allows Camel to be alerted if an exception was thrown. Some
         * components handle this internally only, and therefore
         * bridgeErrorHandler is not possible. In other situations we may
         * improve the Camel component to hook into the 3rd party component and
         * make this possible for future releases. By default the consumer will
         * use the org.apache.camel.spi.ExceptionHandler to deal with
         * exceptions, that will be logged at WARN or ERROR level and ignored.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: consumer (advanced)
         * 
         * @param bridgeErrorHandler the value to set
         * @return the dsl builder
         */
        default AdvancedGooglePubsubLiteEndpointConsumerBuilder bridgeErrorHandler(
                boolean bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
        /**
         * Allows for bridging the consumer to the Camel routing Error Handler,
         * which mean any exceptions (if possible) occurred while the Camel
         * consumer is trying to pickup incoming messages, or the likes, will
         * now be processed as a message and handled by the routing Error
         * Handler. Important: This is only possible if the 3rd party component
         * allows Camel to be alerted if an exception was thrown. Some
         * components handle this internally only, and therefore
         * bridgeErrorHandler is not possible. In other situations we may
         * improve the Camel component to hook into the 3rd party component and
         * make this possible for future releases. By default the consumer will
         * use the org.apache.camel.spi.ExceptionHandler to deal with
         * exceptions, that will be logged at WARN or ERROR level and ignored.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: consumer (advanced)
         * 
         * @param bridgeErrorHandler the value to set
         * @return the dsl builder
         */
        default AdvancedGooglePubsubLiteEndpointConsumerBuilder bridgeErrorHandler(
                String bridgeErrorHandler) {
            doSetProperty("bridgeErrorHandler", bridgeErrorHandler);
            return this;
        }
        /**
         * To let the consumer use a custom ExceptionHandler. Notice if the
         * option bridgeErrorHandler is enabled then this option is not in use.
         * By default the consumer will deal with exceptions, that will be
         * logged at WARN or ERROR level and ignored.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.spi.ExceptionHandler&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exceptionHandler the value to set
         * @return the dsl builder
         */
        default AdvancedGooglePubsubLiteEndpointConsumerBuilder exceptionHandler(
                org.apache.camel.spi.ExceptionHandler exceptionHandler) {
            doSetProperty("exceptionHandler", exceptionHandler);
            return this;
        }
        /**
         * To let the consumer use a custom ExceptionHandler. Notice if the
         * option bridgeErrorHandler is enabled then this option is not in use.
         * By default the consumer will deal with exceptions, that will be
         * logged at WARN or ERROR level and ignored.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.spi.ExceptionHandler&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exceptionHandler the value to set
         * @return the dsl builder
         */
        default AdvancedGooglePubsubLiteEndpointConsumerBuilder exceptionHandler(
                String exceptionHandler) {
            doSetProperty("exceptionHandler", exceptionHandler);
            return this;
        }
        /**
         * Sets the exchange pattern when the consumer creates an exchange.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.ExchangePattern&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exchangePattern the value to set
         * @return the dsl builder
         */
        default AdvancedGooglePubsubLiteEndpointConsumerBuilder exchangePattern(
                org.apache.camel.ExchangePattern exchangePattern) {
            doSetProperty("exchangePattern", exchangePattern);
            return this;
        }
        /**
         * Sets the exchange pattern when the consumer creates an exchange.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.ExchangePattern&lt;/code&gt; type.
         * 
         * Group: consumer (advanced)
         * 
         * @param exchangePattern the value to set
         * @return the dsl builder
         */
        default AdvancedGooglePubsubLiteEndpointConsumerBuilder exchangePattern(
                String exchangePattern) {
            doSetProperty("exchangePattern", exchangePattern);
            return this;
        }
    }

    /**
     * Builder for endpoint producers for the Google PubSub Lite component.
     */
    public interface GooglePubsubLiteEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default AdvancedGooglePubsubLiteEndpointProducerBuilder advanced() {
            return (AdvancedGooglePubsubLiteEndpointProducerBuilder) this;
        }
        /**
         * Logger ID to use when a match to the parent route required.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param loggerId the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointProducerBuilder loggerId(String loggerId) {
            doSetProperty("loggerId", loggerId);
            return this;
        }
        /**
         * The Service account key that can be used as credentials for the
         * PubSub publisher/subscriber. It can be loaded by default from
         * classpath, but you can prefix with classpath:, file:, or http: to
         * load the resource from different systems.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param serviceAccountKey the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointProducerBuilder serviceAccountKey(
                String serviceAccountKey) {
            doSetProperty("serviceAccountKey", serviceAccountKey);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint producers for the Google PubSub Lite
     * component.
     */
    public interface AdvancedGooglePubsubLiteEndpointProducerBuilder
            extends
                EndpointProducerBuilder {
        default GooglePubsubLiteEndpointProducerBuilder basic() {
            return (GooglePubsubLiteEndpointProducerBuilder) this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: producer (advanced)
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default AdvancedGooglePubsubLiteEndpointProducerBuilder lazyStartProducer(
                boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option will be converted to a &lt;code&gt;boolean&lt;/code&gt;
         * type.
         * 
         * Default: false
         * Group: producer (advanced)
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default AdvancedGooglePubsubLiteEndpointProducerBuilder lazyStartProducer(
                String lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
        /**
         * Pub/Sub endpoint to use. Required when using message ordering, and
         * ensures that messages are received in order even when multiple
         * publishers are used.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: producer (advanced)
         * 
         * @param pubsubEndpoint the value to set
         * @return the dsl builder
         */
        default AdvancedGooglePubsubLiteEndpointProducerBuilder pubsubEndpoint(
                String pubsubEndpoint) {
            doSetProperty("pubsubEndpoint", pubsubEndpoint);
            return this;
        }
        /**
         * A custom GooglePubsubLiteSerializer to use for serializing message
         * payloads in the producer.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.component.google.pubsublite.serializer.GooglePubsubSerializer&lt;/code&gt; type.
         * 
         * Group: producer (advanced)
         * 
         * @param serializer the value to set
         * @return the dsl builder
         */
        default AdvancedGooglePubsubLiteEndpointProducerBuilder serializer(
                org.apache.camel.component.google.pubsublite.serializer.GooglePubsubSerializer serializer) {
            doSetProperty("serializer", serializer);
            return this;
        }
        /**
         * A custom GooglePubsubLiteSerializer to use for serializing message
         * payloads in the producer.
         * 
         * The option will be converted to a
         * &lt;code&gt;org.apache.camel.component.google.pubsublite.serializer.GooglePubsubSerializer&lt;/code&gt; type.
         * 
         * Group: producer (advanced)
         * 
         * @param serializer the value to set
         * @return the dsl builder
         */
        default AdvancedGooglePubsubLiteEndpointProducerBuilder serializer(
                String serializer) {
            doSetProperty("serializer", serializer);
            return this;
        }
    }

    /**
     * Builder for endpoint for the Google PubSub Lite component.
     */
    public interface GooglePubsubLiteEndpointBuilder
            extends
                GooglePubsubLiteEndpointConsumerBuilder,
                GooglePubsubLiteEndpointProducerBuilder {
        default AdvancedGooglePubsubLiteEndpointBuilder advanced() {
            return (AdvancedGooglePubsubLiteEndpointBuilder) this;
        }
        /**
         * Logger ID to use when a match to the parent route required.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: common
         * 
         * @param loggerId the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointBuilder loggerId(String loggerId) {
            doSetProperty("loggerId", loggerId);
            return this;
        }
        /**
         * The Service account key that can be used as credentials for the
         * PubSub publisher/subscriber. It can be loaded by default from
         * classpath, but you can prefix with classpath:, file:, or http: to
         * load the resource from different systems.
         * 
         * The option is a: &lt;code&gt;java.lang.String&lt;/code&gt; type.
         * 
         * Group: security
         * 
         * @param serviceAccountKey the value to set
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointBuilder serviceAccountKey(
                String serviceAccountKey) {
            doSetProperty("serviceAccountKey", serviceAccountKey);
            return this;
        }
    }

    /**
     * Advanced builder for endpoint for the Google PubSub Lite component.
     */
    public interface AdvancedGooglePubsubLiteEndpointBuilder
            extends
                AdvancedGooglePubsubLiteEndpointConsumerBuilder,
                AdvancedGooglePubsubLiteEndpointProducerBuilder {
        default GooglePubsubLiteEndpointBuilder basic() {
            return (GooglePubsubLiteEndpointBuilder) this;
        }
    }

    public interface GooglePubsubLiteBuilders {
        /**
         * Google PubSub Lite (camel-google-pubsub-lite)
         * Send and receive messages to/from Google Cloud Platform PubSub Lite
         * Service.
         * 
         * Category: cloud,messaging
         * Since: 4.6
         * Maven coordinates: org.apache.camel:camel-google-pubsub-lite
         * 
         * @return the dsl builder for the headers' name.
         */
        default GooglePubsubLiteHeaderNameBuilder googlePubsubLite() {
            return GooglePubsubLiteHeaderNameBuilder.INSTANCE;
        }
        /**
         * Google PubSub Lite (camel-google-pubsub-lite)
         * Send and receive messages to/from Google Cloud Platform PubSub Lite
         * Service.
         * 
         * Category: cloud,messaging
         * Since: 4.6
         * Maven coordinates: org.apache.camel:camel-google-pubsub-lite
         * 
         * Syntax:
         * <code>google-pubsub-lite:projectId:location:destinationName</code>
         * 
         * Path parameter: projectId (required)
         * The Google Cloud PubSub Lite Project Id
         * 
         * Path parameter: location (required)
         * The Google Cloud PubSub Lite location
         * 
         * Path parameter: destinationName (required)
         * The Destination Name. For the consumer this will be the subscription
         * name, while for the producer this will be the topic name.
         * 
         * @param path projectId:location:destinationName
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointBuilder googlePubsubLite(String path) {
            return GooglePubsubLiteEndpointBuilderFactory.endpointBuilder("google-pubsub-lite", path);
        }
        /**
         * Google PubSub Lite (camel-google-pubsub-lite)
         * Send and receive messages to/from Google Cloud Platform PubSub Lite
         * Service.
         * 
         * Category: cloud,messaging
         * Since: 4.6
         * Maven coordinates: org.apache.camel:camel-google-pubsub-lite
         * 
         * Syntax:
         * <code>google-pubsub-lite:projectId:location:destinationName</code>
         * 
         * Path parameter: projectId (required)
         * The Google Cloud PubSub Lite Project Id
         * 
         * Path parameter: location (required)
         * The Google Cloud PubSub Lite location
         * 
         * Path parameter: destinationName (required)
         * The Destination Name. For the consumer this will be the subscription
         * name, while for the producer this will be the topic name.
         * 
         * @param componentName to use a custom component name for the endpoint
         * instead of the default name
         * @param path projectId:location:destinationName
         * @return the dsl builder
         */
        default GooglePubsubLiteEndpointBuilder googlePubsubLite(
                String componentName,
                String path) {
            return GooglePubsubLiteEndpointBuilderFactory.endpointBuilder(componentName, path);
        }
    }

    /**
     * The builder of headers' name for the Google PubSub Lite component.
     */
    public static class GooglePubsubLiteHeaderNameBuilder {
        /**
         * The internal instance of the builder used to access to all the
         * methods representing the name of headers.
         */
        private static final GooglePubsubLiteHeaderNameBuilder INSTANCE = new GooglePubsubLiteHeaderNameBuilder();

        /**
         * The ID of the message, assigned by the server when the message is
         * published.
         * 
         * The option is a: {@code String} type.
         * 
         * Group: common
         * 
         * @return the name of the header {@code GooglePubsubMessageId}.
         */
        public String googlePubsubMessageId() {
            return "CamelGooglePubsubMessageId";
        }

        /**
         * The ID used to acknowledge the received message.
         * 
         * The option is a: {@code String} type.
         * 
         * Group: consumer
         * 
         * @return the name of the header {@code GooglePubsubMsgAckId}.
         */
        public String googlePubsubMsgAckId() {
            return "CamelGooglePubsubMsgAckId";
        }

        /**
         * The time at which the message was published.
         * 
         * The option is a: {@code com.google.protobuf.Timestamp} type.
         * 
         * Group: consumer
         * 
         * @return the name of the header {@code GooglePubsubPublishTime}.
         */
        public String googlePubsubPublishTime() {
            return "CamelGooglePubsubPublishTime";
        }

        /**
         * The attributes of the message.
         * 
         * The option is a: {@code Map<String, String>} type.
         * 
         * Group: common
         * 
         * @return the name of the header {@code GooglePubsubAttributes}.
         */
        public String googlePubsubAttributes() {
            return "CamelGooglePubsubAttributes";
        }

        /**
         * If non-empty, identifies related messages for which publish order
         * should be respected.
         * 
         * The option is a: {@code String} type.
         * 
         * Group: producer
         * 
         * @return the name of the header {@code GooglePubsubOrderingKey}.
         */
        public String googlePubsubOrderingKey() {
            return "CamelGooglePubsubOrderingKey";
        }
    }
    static GooglePubsubLiteEndpointBuilder endpointBuilder(
            String componentName,
            String path) {
        class GooglePubsubLiteEndpointBuilderImpl extends AbstractEndpointBuilder implements GooglePubsubLiteEndpointBuilder, AdvancedGooglePubsubLiteEndpointBuilder {
            public GooglePubsubLiteEndpointBuilderImpl(String path) {
                super(componentName, path);
            }
        }
        return new GooglePubsubLiteEndpointBuilderImpl(path);
    }
}