package atdd.framework;

import org.springframework.test.context.ContextConfiguration;
import io.cucumber.spring.CucumberContextConfiguration;

/**
 * CucumberSpringIntegration class and context configuration class - BaseTestConfig, are needed 
 * since we are using Spring annotations in our framework 
 */

@CucumberContextConfiguration
@ContextConfiguration(classes = { BaseTestConfig.class })
public class CucumberSpringIntegration {

}