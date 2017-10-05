/*
 *  Copyright (c) 2017, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 *
 */
package org.wso2.carbon.inbound.twitter.poll;

import org.apache.synapse.SynapseException;
import org.apache.synapse.config.SynapseConfiguration;
import org.apache.synapse.core.SynapseEnvironment;
import org.apache.synapse.core.axis2.Axis2SynapseEnvironment;
import org.powermock.reflect.Whitebox;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

public class TwitterStramDataTestCase {
    public TwitterStreamData twitterStreamData;
    public SynapseEnvironment enviornment;

    @BeforeMethod
    public void setUp() {
        SynapseConfiguration config = new SynapseConfiguration();
        this.enviornment = new Axis2SynapseEnvironment(config);
    }

    /**
     * Test case to set properties for retrieving statuses that match one or more filter predicates
     */
    @Test
    public void testTwitterStreamDataOperationFilter() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("connection.twitter.consumerKey", "KCHme1tyBln7L9E0zVte1PzFs");
        properties.setProperty("connection.twitter.consumerSecret", "zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a");
        properties.setProperty("connection.twitter.accessToken", "3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz");
        properties.setProperty("connection.twitter.accessSecret", "56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU");
        properties.setProperty("twitter.operation", "filter");
        properties.setProperty("twitter.track", "happy,wonderful");
        properties.setProperty("twitter.follow", "111871312,136479128");
        properties.setProperty("twitter.locations", "-122.75:36.8,-121.75:37.8");
        properties.setProperty("twitter.language", "en");
        properties.setProperty("twitter.filterLevel", "medium");
        twitterStreamData = new TwitterStreamData(properties, "test", enviornment, 10, "reqSequence",
                "reqErrorSequence", true, true);
        twitterStreamData.poll();
        twitterStreamData.destroy();
        Assert.assertTrue((Boolean) Whitebox.getInternalState(twitterStreamData, "isPolled"));
    }

    /**
     * Test case to set properties for retrieving a sample of all public statuses
     */
    @Test
    public void testTwitterStreamDataOperationSample() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("connection.twitter.consumerKey", "KCHme1tyBln7L9E0zVte1PzFs");
        properties.setProperty("connection.twitter.consumerSecret", "zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a");
        properties.setProperty("connection.twitter.accessToken", "3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz");
        properties.setProperty("connection.twitter.accessSecret", "56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU");
        properties.setProperty("twitter.operation", "sample");
        properties.setProperty("twitter.language", "en");
        twitterStreamData = new TwitterStreamData(properties, "test", enviornment, 10, "reqSequence",
                "reqErrorSequence", true, true);
        twitterStreamData.poll();
        twitterStreamData.destroy();
        Assert.assertTrue((Boolean) Whitebox.getInternalState(twitterStreamData, "isPolled"));
    }

    /**
     * Test case to set properties for retrieving a stream of data and events specific to a user
     */
    @Test
    public void testTwitterStreamDataOperationUser() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("connection.twitter.consumerKey", "KCHme1tyBln7L9E0zVte1PzFs");
        properties.setProperty("connection.twitter.consumerSecret", "zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a");
        properties.setProperty("connection.twitter.accessToken", "3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz");
        properties.setProperty("connection.twitter.accessSecret", "56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU");
        properties.setProperty("twitter.operation", "user");
        properties.setProperty("twitter.track", "happy,wonderful");
        twitterStreamData = new TwitterStreamData(properties, "test", enviornment, 10, "reqSequence",
                "reqErrorSequence", true, true);
        twitterStreamData.poll();
        twitterStreamData.destroy();
        Assert.assertTrue((Boolean) Whitebox.getInternalState(twitterStreamData, "isPolled"));
    }

    /**
     * Test case to set properties for retrieving firehose statuses
     */
    @Test
    public void testTwitterStreamDataOperationfirehose() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("connection.twitter.consumerKey", "KCHme1tyBln7L9E0zVte1PzFs");
        properties.setProperty("connection.twitter.consumerSecret", "zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a");
        properties.setProperty("connection.twitter.accessToken", "3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz");
        properties.setProperty("connection.twitter.accessSecret", "56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU");
        properties.setProperty("twitter.operation", "firehose");
        twitterStreamData = new TwitterStreamData(properties, "test", enviornment, 10, "reqSequence",
                "reqErrorSequence", true, true);
        twitterStreamData.poll();
        twitterStreamData.destroy();
        Assert.assertTrue((Boolean) Whitebox.getInternalState(twitterStreamData, "isPolled"));
    }

    /**
     * Test case to set properties for retrieving messages for a set of users
     */
    @Test
    public void testTwitterStreamDataOperationSite() throws Exception {
        Properties properties = new Properties();
        properties.setProperty("connection.twitter.consumerKey", "KCHme1tyBln7L9E0zVte1PzFs");
        properties.setProperty("connection.twitter.consumerSecret", "zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a");
        properties.setProperty("connection.twitter.accessToken", "3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz");
        properties.setProperty("connection.twitter.accessSecret", "56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU");
        properties.setProperty("twitter.operation", "site");
        properties.setProperty("twitter.track", "happy");
        twitterStreamData = new TwitterStreamData(properties, "test", enviornment, 10, "reqSequence",
                "reqErrorSequence", true, true);
        twitterStreamData.poll();
        twitterStreamData.destroy();
        Assert.assertTrue((Boolean) Whitebox.getInternalState(twitterStreamData, "isPolled"));
    }

    /**
     * Test case to set invalid operation
     */
    @Test(expectedExceptions = SynapseException.class)
    public void testTwitterStreamDataOperationInvalid() {
        Properties properties = new Properties();
        properties.setProperty("connection.twitter.consumerKey", "KCHme1tyBln7L9E0zVte1PzFs");
        properties.setProperty("connection.twitter.consumerSecret", "zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a");
        properties.setProperty("connection.twitter.accessToken", "3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz");
        properties.setProperty("connection.twitter.accessSecret", "56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU");
        properties.setProperty("twitter.operation", "test");
        twitterStreamData = new TwitterStreamData(properties, "test", enviornment, 10, "reqSequence",
                "reqErrorSequence", true, true);
        twitterStreamData.poll();
    }

    /**
     * Test case to set invalid data type for count
     */
    @Test(expectedExceptions = SynapseException.class)
    public void testTwitterStreamDataCountInvalid() {
        Properties properties = new Properties();
        properties.setProperty("connection.twitter.consumerKey", "KCHme1tyBln7L9E0zVte1PzFs");
        properties.setProperty("connection.twitter.consumerSecret", "zQPn5OlMDcV0AFBC6MxhnNaLXMJCUGRIyeE1XogTwUou5tgC4a");
        properties.setProperty("connection.twitter.accessToken", "3250392756-WLKUJstoqy2WL9HLMuvenpiZRkLOPayi8ca82uz");
        properties.setProperty("connection.twitter.accessSecret", "56q7Fi4AEMy6xMJ4PTOuu7f3VcAYvO7PuSUHGSs9trWJU");
        properties.setProperty("twitter.count", "test");
        twitterStreamData = new TwitterStreamData(properties, "test", enviornment, 10, "reqSequence",
                "reqErrorSequence", true, true);
    }
}
