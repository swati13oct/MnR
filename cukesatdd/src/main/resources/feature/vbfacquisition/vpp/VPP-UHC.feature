@fixedTestCaseTest
@vppBlayer
Feature:1.09-VBF-Acq-To test plan summary in vpp flow UMS site (GATED)
@planDetailsUMS
@vppBlayerSmoke
Scenario Outline: Verify plan details in UMS site 
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
Then user validates plan count for all plan types on plan summary page in the UMS site
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
Then the user view plan details of the above selected plan in UMS site and validates
	| Plan Name | <planName> |

    Examples: 
      | zipcode | county       | plantype |               planName                            |
      | 80002   | Adams County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |
	
@defect1964
Scenario Outline: To verify correct message shows on view details page after checking compare plans box
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
And I click on add to compare checkbox and click on view details link
Then I uncheck and recheck the compare box and verify the message and link exists

Examples:
|zipcode| plantype |
|80001| MA |

@defect1803
Scenario Outline: To test checkbox is unchecked on vpp after unchecking it on view details page
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode>|
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
And I click on add to compare checkbox and click on view details link
Then I uncheck and go back to the vpp page to validate

Examples:
|zipcode| plantype |
|80001 | MA |
	
@defect1970
Scenario Outline: To test correct message is displayed for PDP plans after checking compare plans box
Given the user is on the uhcmedicaresolutions site landing page
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode>|
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
When I click on add to compare checkbox for pdp plan and click on view details link
Then I check compare box and verify right info is shown for pdp

Examples:
|zipcode| plantype |
|80001 | PDP |

@defect1363
Scenario Outline: To test two plans are added when clicked on compare plans on Plan details page
Given the user is on the uhcmedicaresolutions site landing page
When I access the vpp page
	|Zip Code| <zipcode> |
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
And the user view plan details of the above selected plan in UMS site and validates 
	| Plan Name | <planName> |
Then the user clicks on add to compare box and validates that info shows 2 plans added

Examples:
|zipcode| planName | plantype |
#|33012 | AARP MedicareComplete Choice Plan 2 (Regional PPO) | MAPD |
