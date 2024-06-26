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
import org.apache.camel.RollbackExchangeException;
import org.apache.camel.RuntimeCamelException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RollbackDefaultErrorHandlerTest extends ContextTestSupport {

    @Test
    public void testOk() throws Exception {
        MockEndpoint mock = getMockEndpoint("mock:result");
        mock.expectedMessageCount(1);

        template.requestBody("direct:start", "ok");

        assertMockEndpointsSatisfied();
    }

    @Test
    public void testRollback() {
        try {
            template.requestBody("direct:start", "bad");
            fail("Should have thrown a RollbackExchangeException");
        } catch (RuntimeCamelException e) {
            boolean b = e.getCause() instanceof RollbackExchangeException;
            assertTrue(b);
        }
    }

    @Test
    public void testRollbackWithExchange() {
        Exchange out = template.request("direct:start", new Processor() {
            public void process(Exchange exchange) {
                exchange.getIn().setBody("bad");
            }
        });
        assertNotNull(out.getException());
        assertIsInstanceOf(RollbackExchangeException.class, out.getException());
        assertTrue(out.isRollbackOnly(), "Should be marked as rollback");
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:start").choice().when(body().isNotEqualTo("ok")).process(new Processor() {
                    public void process(Exchange exchange) {
                        assertFalse(exchange.isRollbackOnly(), "Rollback flag should have been cleared on redelivery");
                    }
                }).to("mock:rollback").rollback("That do not work").otherwise().to("mock:result").end();
            }
        };
    }
}
