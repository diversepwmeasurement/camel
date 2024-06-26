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
package org.apache.camel.component.leveldb;

import java.io.File;

import org.apache.camel.Exchange;
import org.apache.camel.support.DefaultExchange;
import org.apache.camel.test.junit5.params.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.apache.camel.test.junit5.TestSupport.deleteDirectory;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisabledOnOs({ OS.AIX, OS.OTHER })
public class LevelDBAggregationRepositoryAlotDataTest extends LevelDBTestSupport {

    private LevelDBFile levelDBFile;

    @Override
    public void doPostSetup() {
        deleteDirectory("target/data");
        File file = new File("target/data/leveldb.dat");
        levelDBFile = new LevelDBFile();
        levelDBFile.setFile(file);
        levelDBFile.start();
    }

    @Override
    public void doPostTearDown() {
        levelDBFile.stop();
    }

    @Test
    public void testWithAlotOfDataSameKey() {
        LevelDBAggregationRepository repo = getRepo();
        repo.setLevelDBFile(levelDBFile);
        repo.setRepositoryName("repo1");

        for (int i = 0; i < 100; i++) {
            Exchange exchange1 = new DefaultExchange(context);
            exchange1.getIn().setBody("counter:" + i);
            repo.add(context, "foo", exchange1);
        }

        // Get it back..
        Exchange actual = repo.get(context, "foo");
        assertEquals("counter:99", actual.getIn().getBody());
    }

    @Test
    public void testWithAlotOfDataTwoKesy() {
        LevelDBAggregationRepository repo = getRepo();
        repo.setLevelDBFile(levelDBFile);
        repo.setRepositoryName("repo1");

        for (int i = 0; i < 100; i++) {
            Exchange exchange1 = new DefaultExchange(context);
            exchange1.getIn().setBody("counter:" + i);
            String key = i % 2 == 0 ? "foo" : "bar";
            repo.add(context, key, exchange1);
        }

        // Get it back..
        Exchange actual = repo.get(context, "foo");
        assertEquals("counter:98", actual.getIn().getBody());

        actual = repo.get(context, "bar");
        assertEquals("counter:99", actual.getIn().getBody());
    }

    @Test
    public void testWithAlotOfDataWithDifferentKesy() {
        LevelDBAggregationRepository repo = getRepo();
        repo.setLevelDBFile(levelDBFile);
        repo.setRepositoryName("repo1");

        for (int i = 0; i < 100; i++) {
            Exchange exchange1 = new DefaultExchange(context);
            exchange1.getIn().setBody("counter:" + i);
            String key = "key" + i;
            repo.add(context, key, exchange1);
        }

        // Get it back..
        for (int i = 0; i < 100; i++) {
            Exchange actual = repo.get(context, "key" + i);
            assertEquals("counter:" + i, actual.getIn().getBody());
        }
    }

}
