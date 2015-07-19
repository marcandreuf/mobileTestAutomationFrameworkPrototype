/*
 * The MIT License
 *
 * Copyright 2015 marcandreuf.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package org.mandfer.mobile.automation.framework.commons.driver;

import io.appium.java_client.AppiumDriver;
import java.util.Properties;

/**
 *
 * @author marcandreuf
 */
public class DriverAppiumImpl extends DriverWrapper {
    
    private AppiumDriver appiumDriver;

    
    public DriverAppiumImpl(Properties config) {
        super(config);        
    }
    
   
    @Override
    protected void instantiateExternalDriver() {
        //TODO: instantiate appium driver.
        this.appiumDriver = null;
    }

    @Override
    public void installApplication(String appIdentifier, String... options) {
        mapDriverSettingsValuesToMemberAttributes(options);
        appiumDriver.installApp(appIdentifier); 
    }

    @Override
    public void unInstallApplication(String appIdentifier, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void launch(String appIdentifier, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void reLaunch(String deviceUrl, String activityIdentifier, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void closeApplication(String appIdentifier, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void click(String clickableItem, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void waitElemToAppear(String elemIdentifier, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void waitElemToVanish(String elemIdentifier, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getElementText(String elemIdentifier, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getElementHtmlContent(String elemIdentifier, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getElementProperty(String elemIdentifier, String propertyIdentifier, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void verifyElementFound(String elemIdentifier, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void verifyElementNotFound(String elemIdentifier, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isElementFound(String elemIdentifier, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sendText(String text, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void sendTextTo(String elemIdentifier, String text, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void swipe(String direction, int offset, int time, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void swipeElement(String elemIdentifier, String direction, int offset, int time, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void dragElement(String elemIdentifier, int xOffset, int yOffset, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void runCommand(String command, String... options) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


    
}
