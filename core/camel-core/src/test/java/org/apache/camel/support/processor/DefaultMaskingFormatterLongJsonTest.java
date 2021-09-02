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
package org.apache.camel.support.processor;

import org.apache.camel.util.IOHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DefaultMaskingFormatterLongJsonTest {

    @Test
    @Disabled("TODO: log mask should not use regexp as the pattern is flawed")
    public void testMaskLongJson() throws Exception {
        DefaultMaskingFormatter formatter = new DefaultMaskingFormatter();

        String in = IOHelper.loadText(DefaultMaskingFormatterLongJsonTest.class.getResourceAsStream("long-json.json"));
        String out = formatter.format(in);

        String expected
                = IOHelper.loadText(DefaultMaskingFormatterLongJsonTest.class.getResourceAsStream("long-json-masked.json"));
        Assertions.assertEquals(expected, out);
    }

}
