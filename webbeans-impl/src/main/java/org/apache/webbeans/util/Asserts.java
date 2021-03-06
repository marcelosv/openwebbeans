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
package org.apache.webbeans.util;

import java.lang.reflect.Method;

/**
 * Simple utility classes with some assertions methods.
 * 
 * @author <a href="mailto:gurkanerdogdu@yahoo.com">Gurkan Erdogdu</a>
 * @since 1.0
 */
public final class Asserts
{
    public static final String PARAM_NAME_WEBBEANSCONTEXT = "WebBeansContetx";
    public static final String PARAM_NAME_ANNOTATION = "Annotation";

    /*
     * Private constructor
     */
    private Asserts()
    {
        throw new UnsupportedOperationException();
    }

    /**
     * Check the object is null or not
     * 
     * @param obj null check object
     * @param parameterName name of parameter which may not be null
     */
    public static void assertNotNull(Object obj, String parameterName)
    {
        if (obj == null)
        {
            throw new NullPointerException(parameterName + " may not be null");
        }
    }

    /**
     * Check the object is null or not
     * 
     * @param obj null check object
     */
    public static void assertNotNull(Object obj)
    {
        if (obj == null)
        {
            throw new NullPointerException();
        }
    }

    /**
     * Null check for class parameter.
     * 
     * @param clazz parameter
     */
    public static void nullCheckForClass(Class<?> clazz)
    {
        Asserts.assertNotNull(clazz, "clazz argument");
    }

    /**
     * Null check for class parameter.
     * 
     * @param clazz parameter
     */
    public static void nullCheckForClass(Class<?> clazz, String message)
    {
        Asserts.assertNotNull(clazz, message);
    }

    /**
     * Null check for method parameter.
     * 
     * @param method parameter
     */
    public static void nullCheckForMethod(Method method)
    {
        Asserts.assertNotNull(method, "method argument can not be null");
    }

}
