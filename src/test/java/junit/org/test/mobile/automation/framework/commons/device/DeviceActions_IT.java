package junit.org.test.mobile.automation.framework.commons.device;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.test.mobile.automation.framework.commons.Constants;
import org.test.mobile.automation.framework.commons.device.Device;
import org.test.mobile.automation.framework.commons.exceptions.DeviceException;
import org.test.mobile.automation.framework.commons.guice.DeviceFactoryGuice;
import org.test.mobile.automation.framework.commons.guice.MAF_Module;

import java.net.URL;

import static org.junit.Assert.assertTrue;

/**
 * @author marcandreuf
 */
public class DeviceActions_IT {

    private static Device device;
    private Logger logger = LoggerFactory.getLogger(DeviceActions_IT.class);

    @Before
    public void setUp() throws Exception{
        Injector injector = Guice.createInjector(new MAF_Module());
        DeviceFactoryGuice deviceFactory = injector.getInstance(DeviceFactoryGuice.class);

        device = deviceFactory.create(Constants.IOS_IPHONE_4S);
    }

    @Test
    public void shouldReturnTheHtmlContentOfAUrl() throws Exception {
        URL testUrl = new URL("http://www.google.com");
        String htmlContent = device.getHtmlFromUrl(testUrl);
        assertTrue(!htmlContent.equals(""));
    }

    @Test
    public void shouldReturnTheContentOfAnElementInAUrl() throws Exception {
        String url = "https://news.google.co.uk/";
        String elementIdentifier = ".titletext";

        String result = device.getContentFromUrl(url, elementIdentifier);
        assertTrue(!result.isEmpty());
    }

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void shouldSendAHttpRequest() throws Exception {
        String url = "http://www.google.com";
        device.sendHttpRequest(url);
    }

    @Test
    public void testFailSendHTTPRequest() throws Exception {
        expectedException.expect(DeviceException.class);
        device.sendHttpRequest("worngUrl");
    }

}
