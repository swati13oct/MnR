@addPlan
Feature: To test the addPlan flow in UMS site
Scenario Outline: Verify plans added with existing plans in UMS site
Given the user is on the UHC medicare site registration page
When the user registers in UHC site with a group plan and following details
	| Plan Member ID         | <planMemberId> |	
	| Date of birth          | <dateOfBirth>  |
Then the user validates the plan information on plan confirmation page in UHC site
When the user confirms the plan details in UHC site
And the user performs add no other plan in UHC site
And the user registers with following details in UHC site
	| Create a username     | <userName>        |
	| Create a password     | <password>        |
	| Confirm password      | <confirmPassword> |
	| Email address         | <email>           |
	| Confirm email address | <confirmEmail>    |
Then the user registers successfully in UHC site
When the user navigates to homepage in UHC site
Then the user validates account home page in UHC site
When the user navigates to myPlans in UHC site
Then the user validates plan summary page in UHC site
And the user adds the plan with following details in UHC site
   | <newPlanMemberId> |
Then the user validates the plan names of both the plan added in UHC site

Examples:
	| planMemberId  | dateOfBirth | userName        | password    | confirmPassword | email                    | confirmEmail             | newPlanMemberId   |
	| 0177005471    | 03-22-1932  | apr_blgroup270  | Password@1  | Password@1      | UHCMNRPORTALS@GMAIL.COM  | UHCMNRPORTALS@GMAIL.COM  | 975134087         |
	| 0177005471    | 03-22-1932  | apr_blgroup270  | Password@1  | Password@1      | UHCMNRPORTALS@GMAIL.COM  | UHCMNRPORTALS@GMAIL.COM  | 975134087         |