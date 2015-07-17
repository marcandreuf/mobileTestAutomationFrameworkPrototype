package junit.org.mandfer.mobile.automation.framework.commons.user;

import org.junit.Test;
import org.mandfer.mobile.automation.framework.commons.user.GenericUser;
import org.mandfer.mobile.automation.framework.commons.user.User;

import java.io.IOException;
import java.util.Properties;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mandfer.mobile.automation.framework.commons.dsl.TestScriptDslBuilder.user;

/**
 * @author marcandreuf
 */
public class UserTest {

    @Test
    public void shouldGetTheUserNameFromTheUserConfigFile() {
        Properties mocked_config = mock(Properties.class);
        User user = new GenericUser(mocked_config);
        user.getUserName();
        verify(mocked_config).getProperty("username");
    }

    @Test
    public void shouldGetTheUserPassFromTheUserConfigFile() {
        Properties mocked_config = mock(Properties.class);
        User user = new GenericUser(mocked_config);
        user.getPass();
        verify(mocked_config).getProperty("password");
    }

    @Test
    public void shouldGetTheTestDataFromTheUserConfigFile() {
        String sampleKey = "sampleKey";
        Properties mocked_config = mock(Properties.class);
        User user = new GenericUser(mocked_config);
        user.getTestData(sampleKey);
        verify(mocked_config).getProperty(sampleKey);
    }
    
//    @Test
//    public void shouldBulidAUserFromAConfigFile() throws IOException{
//        User testUser = user(SAMPLE_TEST_USER_1);
//        assertTrue(testUser.getUserName().equals("testUser0001"));
//        assertTrue(testUser.getPass().equals("abcd"));
//
//    }

}
