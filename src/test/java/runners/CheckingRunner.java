package runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@ConfigurationParameter(key = "cucumber.plugin", value = "rerun:target/checking/cucumber_rerun.txt")
@SelectClasspathResource("features/account_creating.feature")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "steps, hooks")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, " + "html:target/checking/cucumber-reports.html, " + "json:target/checking/cucumber-reports.json")
//@ConfigurationParameter(key = "cucumber.filter.tags", value = "@unsuccessful_account_creation")
public class CheckingRunner {}
