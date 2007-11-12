/*
 * Copyright 2006 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package jdave.containment;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Joni Freeman
 */
public class AllContainmentTest extends ContainmentTest {
    @Before
    public void setUp() throws Exception {
        containment = new AllContainment(new Iterable<Integer>() {
            public Iterator<Integer> iterator() {
                return Arrays.asList(1, 2, 3).iterator();
            }
        });
    }
    
    @Test
    public void testIsInEqualList() {
        assertTrue(containment.matches(Arrays.asList(1, 2, 3)));
    }
        
    @Test
    public void testIsNotInPartialList() {
        assertFalse(containment.matches(Arrays.asList(1, 2)));
    }
}
