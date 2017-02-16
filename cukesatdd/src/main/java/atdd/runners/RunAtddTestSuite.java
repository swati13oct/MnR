/**
 * 
 * Optum CONFIDENTIAL
 * __________________
 * 
 *  [2015] - [2017] Optum 
 *  All Rights Reserved.
 * 
 * NOTICE:  All information contained herein is, and remains
 * the property of Optum and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Optum
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Optum.
 */
package atdd.runners;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 * This class is used to invoke automated tests for the Sign In feature 
 * in Jarvis. 
 *
 * @author gladiatorsqa
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework", "acceptancetests" }, features = { "feature" }, format = {
		"pretty", "html:reports/test-report" ,"json:target/cucumber.json"}, tags = { "@globalAARP, @password-expired-error-messages-jarvis, @password-expiring-flow-jarvis, @password-expiring-error-messages-jarvis, @signin-jarvis, @signin-error-messages-jarvis, @registration-step-one-jarvis, @registration-step-two-jarvis, @registration-step-one-error-messages-jarvis, @registration-step-two-error-messages-jarvis, @password-reset-step-one-jarvis, @password-reset-step-two-jarvis, @password-reset-step-one-error-messages-jarvis, @password-reset-step-two-error-messages-jarvis, @browser-check-jarvis, @commission-search-messages-jarvis, @commission-search-error-messages-jarvis" })
public class RunAtddTestSuite {

}
