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
package atdd.runners.dashboard;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

/**
 
 *
 * @author akuma103
 */
@RunWith(Cucumber.class)
@Cucumber.Options(glue = { "atdd.framework","acceptancetests.dashboard.registration" }, features = { "feature/registrationMemberRedesign" }, format = { "pretty", "html:reports/test-report","json:target/RunJarvisCloaking-cucumber.json" }, tags = { "@pffsMemberErrorPage, @existingMemberErrorPage ,@futureEffectivePlanError,@inactiveTerminatedPlanError ,@memberInfoNotFoundError" })
public class RunMRAtddTestRegistrationErrorsDashboard {

}
