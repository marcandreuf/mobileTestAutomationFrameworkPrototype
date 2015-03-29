package junit.org.test.mobile.automation.framework.commons.config;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import static junit.org.test.mobile.automation.framework.commons.JunitTestConstants.TEST_SAMPLE_PROPS_FILE;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.test.mobile.automation.framework.commons.config.ConfigLoader;
import org.test.mobile.automation.framework.commons.config.ConfigLoaderProperties;


public class ConfigLoaderTest {
	
	private ConfigLoader confLoader;
	
	@Before
	public void setUp(){
        confLoader = new ConfigLoaderProperties();
	}
	
	@Test
	public void loadConfigFileWithDefaults() throws IOException{		
		Properties propsTest = 
          confLoader.loadConfig(TEST_SAMPLE_PROPS_FILE);
        
		assertTrue(propsTest.isEmpty()==false);
        
        assertTrue(propsTest.getProperty("topDefaultKey")
          .equals("topDefaultValue"));
        
        assertTrue(propsTest.getProperty("defaultKey")
          .equals("defaultValue"));
        
        assertTrue(propsTest.getProperty("specificKey")
          .equals("specialValue"));        
	}
            

	@Test(expected=FileNotFoundException.class)
	public void failLoadConfigFile() throws IOException {
        confLoader.loadConfig("notExistentFile.properties");
	}
    
    

}
