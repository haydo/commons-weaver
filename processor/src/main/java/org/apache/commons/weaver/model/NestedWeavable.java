/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.commons.weaver.model;

public abstract class NestedWeavable<SELF extends NestedWeavable<SELF, TARGET, PARENT, PARENT_TARGET>, TARGET, PARENT extends Weavable<PARENT, PARENT_TARGET>, PARENT_TARGET>
    extends Weavable<SELF, TARGET> {

    private final PARENT parent;

    protected NestedWeavable(TARGET target, PARENT parent) {
        super(target);
        this.parent = parent;
    }

    public PARENT getParent() {
        return parent;
    }

    @Override
    public final int compareTo(SELF o) {
        int result = getParent().compareTo(o.getParent());
        return result == 0 ? localCompareTo(o) : result;
    }

    protected abstract int localCompareTo(SELF o);
}