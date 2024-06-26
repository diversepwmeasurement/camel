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
package org.apache.camel.reifier;

import java.util.Collection;
import java.util.List;

import org.apache.camel.Processor;
import org.apache.camel.Route;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.model.StepDefinition;
import org.apache.camel.processor.StepProcessor;

public class StepReifier extends ProcessorReifier<StepDefinition> {

    public StepReifier(Route route, ProcessorDefinition<?> definition) {
        super(route, StepDefinition.class.cast(definition));
    }

    @Override
    public Processor createProcessor() throws Exception {
        return this.createChildProcessor(true);
    }

    @Override
    protected Processor createOutputsProcessor(Collection<ProcessorDefinition<?>> outputs) throws Exception {
        // do not optimize to force always wrapping in step processor
        return super.createOutputsProcessor(outputs, false);
    }

    @Override
    protected Processor createCompositeProcessor(List<Processor> list) throws Exception {
        String stepId = getId(definition);
        return StepProcessor.newInstance(camelContext, list, stepId);
    }
}
