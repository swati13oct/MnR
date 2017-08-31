@fixedTestCaseTest
@Registration
Feature:To test registration flow in AARP site
Scenario Outline:To verify registration for federal member without perks in AARP site
Given the user is on registration page of AARP site 
	|	User Name	|	<userName>	|
When the user registers with below details in AARP site
	| Plan Member ID         | <planMemberId> |	
	| Date of birth          | <dateOfBirth>  |
Then the user validates the plan information on plan confirmation page in AARP site
When the user confirms the personal and plan information in AARP site
And the user registers with the following details in AARP site
	|  Create a username     | <userName>        |
	|  Create a password     | <password>        |
	|  Confirm password      | <confirmPassword> |
	|  Email address         | <email>           |
	|  Confirm email address | <confirmEmail>    |
	| available documents    | <availableDocs>   |
Then the user registers successfully in AARP site

Examples:
	| planMemberId | dateOfBirth | userName      		| password   | confirmPassword | email                   | confirmEmail            | availableDocs		                              |
	| 0162832881   | 06-06-1963  | q3_sep_ulayer389		| Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM | Prescription Drug Explanation of Benefits (EOB) |	
	#| 0041615931   | 02-25-1937  | ATDD_REG_ULAYER_01	| Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM | Prescription Drug Explanation of Benefits (EOB) |
	
	
Scenario Outline:To verify registration for Ship member in AARP site
Given the user is on registration page of AARP site
	|	User Name	|	<userName>	| 
When the user registers with below details in AARP site
	| Plan Member ID         | <planMemberId> |	
	| Date of birth          | <dateOfBirth>  |
Then the user validates the plan information on plan confirmation page in AARP site
When the user confirms the personal and plan information in AARP site
And the user registers with the following details in AARP site
	| Create a username     | <userName>        |
	| Create a password     | <password>        |
	| Confirm password      | <confirmPassword> |
	| Email address         | <email>           |
	| Confirm email address | <confirmEmail>    |
Then the user registers successfully in AARP site

Examples:
	| planMemberId | dateOfBirth | userName   			  | password   | confirmPassword | email                   | confirmEmail            |
	#| 308794789-11 | 09-29-1949  | ATDD_REG_ULAYER_SHIP01 | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |
 