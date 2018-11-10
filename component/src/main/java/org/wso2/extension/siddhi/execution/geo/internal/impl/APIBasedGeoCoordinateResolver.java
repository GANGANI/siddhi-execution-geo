/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.extension.siddhi.execution.geo.internal.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.extension.siddhi.execution.geo.api.GeoCoordinate;
import org.wso2.extension.siddhi.execution.geo.api.GeoCoordinateResolver;
import org.wso2.siddhi.core.exception.SiddhiAppRuntimeException;
import org.wso2.siddhi.core.util.config.ConfigReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * The default implementation of the GeoCoordinateResolver interface. This is implemented is based on API.
 */
public class APIBasedGeoCoordinateResolver implements GeoCoordinateResolver {
    private static final Log log = LogFactory.getLog(APIBasedGeoCoordinateResolver.class);
    private String temporary = null;

    @Override
    public void init(ConfigReader configReader) {
    }

    @Override
    public GeoCoordinate getGeoCoordinateInfo(String key, String ip) {
        double latitude;
        double longitude;
        ip = ip.trim();
        if (ip.contains(",")) {
            String locationDetails[] = ip.split(",");
            ip = locationDetails[1].trim();
        }
        URL url;
        try {
            url = new URL(key + ip);
        } catch (MalformedURLException e) {
            throw new SiddhiAppRuntimeException ("Error", e);
        }
        try (
            InputStreamReader inputStreamReader = new InputStreamReader(url.openStream(), StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String strTemp = null;
            String locationDetails[] = null;
            while (null != (strTemp = bufferedReader.readLine())) {
                temporary = strTemp;
            }
            locationDetails = temporary.split(";");
            latitude = Double.parseDouble(locationDetails[8]);
            longitude = Double.parseDouble(locationDetails[9]);
        } catch (IOException e) {
            throw new SiddhiAppRuntimeException("Error", e);
        }
        return new GeoCoordinate(latitude, longitude);
    }
}
