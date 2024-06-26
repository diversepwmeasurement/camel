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
package org.apache.camel.impl;

import org.apache.camel.CamelContext;
import org.apache.camel.Service;
import org.apache.camel.TestSupport;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LifecycleStrategyServiceTest extends TestSupport {

    private final MyLifecycleStrategy dummy1 = new MyLifecycleStrategy();

    protected CamelContext createCamelContext() {
        CamelContext context = new DefaultCamelContext();
        context.addLifecycleStrategy(dummy1);
        return context;
    }

    @Test
    public void testLifecycleStrategyService() throws Exception {
        assertFalse(dummy1.isStarted());

        CamelContext context = createCamelContext();
        context.start();
        assertTrue(dummy1.isStarted());
        context.stop();
        assertFalse(dummy1.isStarted());
    }

    private static class MyLifecycleStrategy extends DummyLifecycleStrategy implements Service {

        private volatile boolean started;

        @Override
        public void start() {
            started = true;
        }

        @Override
        public void stop() {
            started = false;
        }

        public boolean isStarted() {
            return started;
        }
    }

}
