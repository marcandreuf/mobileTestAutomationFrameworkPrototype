package org.mandfer.mobile.automation.framework.commons.guice;

import org.mandfer.mobile.automation.framework.commons.app.App;
import org.mandfer.mobile.automation.framework.commons.device.Device;
import org.mandfer.mobile.automation.framework.commons.exceptions.AppFactoryException;

/**
 * @author marcandreuf
 */
public interface AppFactory {

    public App create(String configFileName, Device device) throws AppFactoryException;
}
