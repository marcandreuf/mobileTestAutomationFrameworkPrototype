package org.test.mobile.automation.framework.commons.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class encapsulates the configuration loading from any source.
 * 
 * @author marcandreuf
 *
 */
public interface ConfigLoader {
	
	public Properties loadConfig(String fileName) 
      throws IOException;
    
}
