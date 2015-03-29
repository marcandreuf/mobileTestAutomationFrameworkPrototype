package org.test.mobile.automation.framework.commons.app;

import java.util.List;

/**
 * This is the top interface to operate with mobile applications.
 *
 * @author marcandreuf
 *
 */
public interface App {

    public static final String PROP_KEY_APP_IDENTIFIER = "applicationId";
    public static final String PROP_KEY_APPLICATION_NAME = "applicationName";
    public static final String PROP_KEY_PATH = "path";
    public static final String PROP_KEY_TIMEOUT = "timeout";
    public static final String PROP_KEY_REPORT_PATH = "reportPath";

    public String getAppIdentifier();

    public String getName();

    public String getAppFullPath();

    public int getTimeout();

    public String getReportPath();

    public String getLiteral(String literalKey);

    public String getTestData(String testDataKey);

    public List<String> getTestDataList(String testDataKey);

}
