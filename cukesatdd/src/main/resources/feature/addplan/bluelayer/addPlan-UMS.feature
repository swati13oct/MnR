@addPlan
Feature: To test the addPlan flow in UMS site
Scenario Outline: Verify plans added with existing plans in UMS site
Given the details of user to be registered in UMS site
	| Plan Member ID         | <planMemberId> |	
	| Date of birth          | <dateOfBirth>  |
When the user confirms the plan details in UMS site
And the user performs add no other plan in UMS site
And the user registers with following details in UMS site
	| Create a username     | <userName>        |
	| Create a password     | <password>        |
	| Confirm password      | <confirmPassword> |
	| Email address         | <email>           |
	| Confirm email address | <confirmEmail>    |
And the user navigates to homepage in UMS site
And the user navigates to myplans in UMS site
And the user adds the plan with following details in UMS site
   | <newPlanMemberId> |
Then the user validates the plan names of both the plan added in UMS site

Examples:
| planMemberId  | dateOfBirth | userName       | password    | confirmPassword | email              | confirmEmail       | newPlanMemberId   |
#| 0110425671   | 08-05-1932  | q4blgroup_049  | Password@1  | Password@1      | GPS_UHC@OPTUM.COM  | GPS_UHC@OPTUM.COM  | 923552129-11      |
| 1007370881    | 01-16-1940  | q4blgroup_045  | Password@1  | Password@1      | TEST@OPTUM.COM	    | TEST@OPTUM.COM     | 968734859-01      |
| 970541165-01  | 02-01-1931  | q4blgroup_046  | Password@1  | Password@1      | VSJ-YW@JQGADLA.ULD | VSJ-YW@JQGADLA.ULD | 1007339271        |
