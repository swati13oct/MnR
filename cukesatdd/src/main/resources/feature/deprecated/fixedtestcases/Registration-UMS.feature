@fixedTestCaseTest
@Registration
Feature:1.07-To test registration flow in UMS site	
Scenario Outline:To Verify registration for individual or group members in UMS site
Given the user is on registration page of UMS site
	|	User Name	|	<userName>	| 
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
	 | planMemberId  | dateOfBirth | userName           | password   | confirmPassword | email                   | confirmEmail            |
	 | 836904327-01  | 12-06-1942  | q3_sep_blayer152   | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |
	#| 866635641-01  | 11-17-1933  | q3_sep_blayer151   | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |
	#| 0162904141    | 01-09-1946  | ATDD_REG_BLAYER_02 | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |