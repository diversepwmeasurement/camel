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
package org.apache.camel.processor;

import org.apache.camel.ContextTestSupport;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
public class WireTapOnPrepareTest extends ContextTestSupport {

    @Test
    public void testWireTapOnPrepare() throws Exception {
        getMockEndpoint("mock:a").expectedMessageCount(1);
        getMockEndpoint("mock:a").message(0).body(String.class).isEqualTo("1 Tony the Tiger");
        getMockEndpoint("mock:b").expectedMessageCount(1);
        getMockEndpoint("mock:b").message(0).body(String.class).isEqualTo("1 Tiger");

        final Animal original = new Animal(1, "Tiger");
        template.sendBody("direct:start", original);

        assertMockEndpointsSatisfied();

        final Animal aAnimal = getMockEndpoint("mock:a").getExchanges().get(0).getIn().getBody(Animal.class);
        final Animal bAnimal = getMockEndpoint("mock:b").getExchanges().get(0).getIn().getBody(Animal.class);

        assertSame(original, bAnimal, "Original instance should stay in main route");
        assertNotSame(original, aAnimal, "Copy should go to Wire Tap Endpoint");
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                // START SNIPPET: e1
                from("direct:start").wireTap("direct:a").copy().onPrepare(new AnimalDeepClonePrepare()).to("direct:b");
                // END SNIPPET: e1

                from("direct:a").process(new ProcessorA()).to("mock:a");
                from("direct:b").delay(1000).process(new ProcessorB()).to("mock:b");
            }
        };
    }

    public static class ProcessorA implements Processor {

        @Override
        public void process(Exchange exchange) {
            Animal body = exchange.getIn().getBody(Animal.class);
            assertEquals(1, body.getId());
            assertEquals("Tiger", body.getName());

            // adjust the name
            body.setName("Tony the Tiger");
        }
    }

    public static class ProcessorB implements Processor {

        @Override
        public void process(Exchange exchange) {
            Animal body = exchange.getIn().getBody(Animal.class);
            assertEquals(1, body.getId());
            assertEquals("Tiger", body.getName());
        }
    }

}
