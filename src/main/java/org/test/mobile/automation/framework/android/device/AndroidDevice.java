package org.test.mobile.automation.framework.android.device;

import java.util.Properties;

import org.test.mobile.automation.framework.commons.device.GenericDevice;
import org.test.mobile.automation.framework.commons.driver.Driver;


/**
 * Top class for android device abstraction.
 * 
 * @author marcandreuf
 *
 */
public class AndroidDevice extends GenericDevice  {
	
	public AndroidDevice(Properties config, Driver driver) {
		super(config, driver);
	}


}
