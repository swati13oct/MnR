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
@Cucumber.Options(glue = { "atdd.framework", "acceptancetests.sanity.blayer" }, features = { "feature/sanity_blayer" }, format = {
		"pretty", "html:reports/test-report" ,"json:target/RunMRAtddTestSanityBlayer-cucumber.json"}, tags = { "@sanity" })
public class RunMRAtddTestSanityBlayer {

}
