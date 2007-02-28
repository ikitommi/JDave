/*
 * Copyright 2007 the original author or authors.
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
package jdave;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author Joni Freeman
 */
public class InPartialOrderContainment extends CollectionContainment {
    public InPartialOrderContainment(Collection<?> elements) {
        super(elements);
    }
    
    public InPartialOrderContainment(Iterator<?> elements) {
        super(elements);
    }
    
    public InPartialOrderContainment(Iterable<?> elements) {
        super(elements);
    }
    
    public boolean isIn(Collection<?> actual) {
        List<?> retained = new ArrayList<Object>(actual);
        retained.retainAll(elements);
        InOrderContainment inOrderContainment = new InOrderContainment(elements);
        return inOrderContainment.isIn(retained);
    }
}