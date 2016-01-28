package common.objects;

import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = org.junit.runners.Suite.class)
@SuiteClasses(value = { TestActivity.class, TestAlarm.class,
		TestAuthenticator.class, TestCommonObject.class,
		TestConfiguration.class, TestConfigurationGroup.class,
		TestConfigurationItem.class, TestConfigurationItemFactory.class,
		TestConfigurationOption.class, TestConnectorConfig.class, TestLogTransaction.class,
		TestPermission.class, TestRole.class, TestLoggingConfiguration.class,
		TestFileContents.class, TestLinkConfig.class, TestInputConfig.class, TestInventoryItem.class })
public class TestSuite {

}
