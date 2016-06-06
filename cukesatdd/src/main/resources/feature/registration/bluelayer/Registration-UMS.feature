@registration
Feature:To test registration flow in UMS site
Scenario Outline: To verify registration for two plan combo member with out perks in UMS site
Given the user is on registration page of UMS site 
When the user registers with below details in UMS site
	| Plan Member ID         | <planMemberId> |	
	| Date of birth          | <dateOfBirth>  |
Then the user validates the plan information on plan confirmation page in UMS site
When the user confirms the personal and plan information in UMS site
And the user adds second plan with below information in UMS site
	| Additional Plan Member ID | <secondMemberId> |
Then the user validates the the plan information for both plans in UMS site
When the user confirms personal and plan information for both plans in UMS site
And the user registers with the following details in UMS site
	| Create a username     | <userName>        |
	| Create a password     | <password>        |
	| Confirm password      | <confirmPassword> |
	| Email address         | <email>           |
	| Confirm email address | <confirmEmail>    |
Then the user registers successfully in UMS site	
Examples:
	| planMemberId | dateOfBirth | secondMemberId | userName       | password   | confirmPassword | email                   | confirmEmail            |
#	| 0177005451   | 11-18-1948  | 901846789      | apr_blgroup268 | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |
	
Scenario Outline: Verify registration for individual or group members in UMS site
Given the user is on registration page of UMS site 
When the user registers with below details in UMS site
	| Plan Member ID         | <planMemberId> |	
	| Date of birth          | <dateOfBirth>  |
Then the user validates the plan information on plan confirmation page in UMS site
When the user confirms the personal and plan information in UMS site
And the user registers with the following details in UMS site
	| Create a username     | <userName>        |
	| Create a password     | <password>        |
	| Confirm password      | <confirmPassword> |
	| Email address         | <email>           |
	| Confirm email address | <confirmEmail>    |
Then the user registers successfully in UMS site

Examples:
	 | planMemberId | dateOfBirth | userName           | password   | confirmPassword | email                   | confirmEmail            |
#	 | 006916255    | 08-13-1931  | apr_blayer069      | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |