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
package org.apache.webbeans.arquillian.test;

import javax.inject.Inject;

import org.apache.webbeans.arquillian.test.beans.SampleUser;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


/**
 * This test verifies the deployment of a JAR packaging.
 */
@RunWith(Arquillian.class)
public class OwbArquillianWebJarDeploymentTest
{

    @Inject
    private SampleUser sampleUser;


    @Deployment
    public static Archive deploy()
    {
        JavaArchive testJar = ShrinkWrap
                .create(JavaArchive.class, "sampleUserTest.jar")
                .addClass(OwbArquillianWebJarDeploymentTest.class)
                .addPackage(SampleUser.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");


        WebArchive testWar = ShrinkWrap
                .create(WebArchive.class, "sampleUserTest.war")
                .addAsLibrary(testJar);

        return testWar;
    }

    @Test
    public void testOwbArqContainerStartup()
    {
        Assert.assertNotNull(sampleUser);
        Assert.assertEquals("Hans", sampleUser.getFirstName());

        sampleUser.setFirstName("Karl");
        Assert.assertEquals("Karl", sampleUser.getFirstName());
    }
}
