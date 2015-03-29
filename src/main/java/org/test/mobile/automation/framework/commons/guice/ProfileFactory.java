package org.test.mobile.automation.framework.commons.guice;

import org.test.mobile.automation.framework.commons.exceptions.ProfileFactoryException;
import org.test.mobile.automation.framework.commons.profile.Profile;

/**
 * @author marcandreuf
 */
public interface ProfileFactory {

    public Profile create(String configFileName) throws ProfileFactoryException;
}
