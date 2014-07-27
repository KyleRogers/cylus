package net.cyphoria.cylus.acceptancetest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * @author Stefan Pennndorf <stefan@cyphoria.net>
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = "pretty", features = "src/test/resources/net/cyphoria/cylus/features")
public class RunCucumberTest {
}