@fixedTestCaseTest
@vppBlayer
Feature:1.09-VBF-Acq-To test plan summary in vpp flow UMS site
@planDetailsUMS
@vppBlayerSmoke
Scenario Outline: Verify plan details in UMS site 
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in row form
When the user performs plan search using following information in UMS site
	| Zip Code    | <zipcode>|
	| County Name |<county> |
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
Then the user view plan details of the above selected plan in UMS site and validates
	| Plan Name | <planName> |

Examples:
	| zipcode | county             | plantype |  planName                                             |
	| 90210   | Adams County       | MAPD     |  AARP MedicareComplete SecureHorizons Plan 2 (HMO)    |
	
@defect1964
Scenario Outline: To verify correct message shows on view details page after checking compare plans box
Given the user is on the uhcmedicaresolutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
When I access the vpp page
	|Zip Code| <zipcode> |
And I click on add to compare checkbox and click on view details link
Then I uncheck and recheck the compare box and verify the message and link exists

Examples:
|zipcode| 
|33012 | 

@defect1803
Scenario Outline: To test checkbox is unchecked on vpp after unchecking it on view details page
Given the user is on the uhcmedicaresolutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
When I access the vpp page
	|Zip Code| <zipcode> |
And I click on add to compare checkbox and click on view details link
Then I uncheck and go back to the vpp page to validate

Examples:
|zipcode| 
|33012 |
	
@defect1970
Scenario Outline: To test correct message is displayed for PDP plans after checking compare plans box
Given the user is on the uhcmedicaresolutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
When I access the vpp page
	|Zip Code| <zipcode> |
And I select pdp plans and go to view details page
Then I check compare box and verify right info is shown

Examples:
|zipcode| 
|33012 |

@defect1363
Scenario Outline: To test two plans are added when clicked on compare plans on Plan details page
Given the user is on the uhcmedicaresolutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
When I access the vpp page
	|Zip Code| <zipcode> |
When user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
And the user view plan details of the above selected plan in UMS site and validates 
	| Plan Name | <planName> |
Then the user clicks on add to compare box and validates that info shows 2 plans added

Examples:
|zipcode| planName | plantype |
|33012 | AARP MedicareComplete Choice Plan 2 (Regional PPO) | MAPD |
