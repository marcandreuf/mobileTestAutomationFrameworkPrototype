package org.test.mobile.automation.framework.commons.driver;

/**
 * @author marcandreuf
 *
 * Temporal class to allow testing of the ThirdPartyDriverWrapper driver settings.
 *
 */
public interface SampleThirdPartyDriver {

    public void install(String appIdentifier, int timeout);

    public void click(String elemIdentifier, int clicks);

}
