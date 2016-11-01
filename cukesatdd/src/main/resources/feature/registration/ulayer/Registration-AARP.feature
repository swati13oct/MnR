#@registration
Feature:To test registration flow in AARP site
Scenario Outline:To verify registration for three plan combo member in AARP site
Given the user is on registration page of AARP site 
When the user registers with below details in AARP site
	| Plan Member ID         | <planMemberId> |	
	| Date of birth          | <dateOfBirth>  |
Then the user validates the plan information on plan confirmation page in AARP site
When the user confirms the personal and plan information in AARP site
And the user adds second plan with below information in AARP site
	| Additional Plan Member ID | <secondMemberId> |
Then the user validates the the plan information for both plans in AARP site
When the user confirms personal and plan information for both plans in AARP site
And the user registers with the following details in AARP site
	| Create a username     | <userName>        |
	| Create a password     | <password>        |
	| Confirm password      | <confirmPassword> |
	| Email address         | <email>           |
	| Confirm email address | <confirmEmail>    |
Then the user registers successfully in AARP site

	
Examples:
	| planMemberId | dateOfBirth | secondMemberId | userName     | password   | confirmPassword | email                   | confirmEmail            |
	| 0176962491   | 01-01-1934  | 017696249-11   | apr_combo002 | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |



Scenario Outline:To verify registration for Ship member in AARP site
Given the user is on registration page of AARP site 
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
	| planMemberId | dateOfBirth | userName   | password   | confirmPassword | email                   | confirmEmail            |
	| 368887784-11 | 03-01-1946  | q2ship_001 | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |


Scenario Outline:To verify registration for federal member without perks in AARP site
Given the user is on registration page of AARP site 
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
	| planMemberId | dateOfBirth | userName      | password   | confirmPassword | email                   | confirmEmail            | availableDocs		                              |
	| 0000443531   | 03-23-1937  | apr_ulayer185 | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM | Prescription Drug Explanation of Benefits (EOB) | 


Scenario Outline:To verify registration for federal member with perks in AARP site
Given the details of user to be registered in AARP site
	| Plan Member ID | <planMemberId> |
	| Date of birth  | <dateOfBirth>  |
When the user confirms the personal and plan information in AARP site
And the user registers with the following details in AARP site
	| Create a username     | <userName>        |
	| Create a password     | <password>        |
	| Confirm password      | <confirmPassword> |
	| Email address         | <email>           |
	| Confirm email address | <confirmEmail>    |

And the user views go green and selects from the available documents in AARP site
	| available documents | <availableDocs> |
And the user views and select member perks in AARP site
	| Member perks | <memberPerks> | 
Then the user registers successfully in AARP site

Examples:
	| planMemberId | dateOfBirth | userName     | password   | confirmPassword | email                   | confirmEmail            | availableDocs			           | memberPerks |
#	| 0000629331   | 11/22/1921  | q2ulayer_034 | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM | Annual Directory Mailing	           | yes	 |
#	| 000353536    | 9/29/1923   | q2ulayer_031 | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM | Prescription Drug Explanation of Benefits | No          |




Scenario Outline:To verify registration for two plan combo member with out perks in AARP site
Given the user is on registration page of AARP site 
When the user registers with below details in AARP site
	| Plan Member ID | <planMemberId> |
	| Date of birth  | <dateOfBirth>  |
Then the user validates the plan information on plan confirmation page in AARP site
When the user confirms the personal and plan information in AARP site
And the user adds second plan with below information in AARP site
	| Additional Plan Member ID | <additionalPlanMemberId> |
Then the user validates the the plan information for both plans in AARP site
When the user confirms personal and plan information for both plans in AARP site
And the user registers with the following details in AARP site
	|  Create a username     | <userName>        |
	|  Create a password     | <password>        |
	|  Confirm password      | <confirmPassword> |
	|  Email address         | <email>           |
	|  Confirm email address | <confirmEmail>    |
#And the user views go green and selects the available documents for Federal plan
#	| Federal documents available | <availableDocsFederal> |
#And the user selects the available documents for Ship plan
#	| Confirm Ship Documents  | <confirmAvailableDocsShip> |
Then the user registers successfully with both the plans in AARP site


Examples:
	| planMemberId | dateOfBirth | additionalPlanMemberId | userName    | password   | confirmPassword | email                   | confirmEmail     |
#	| 0117044081   | 05-07-1925  | 011704408-11           | q3combo_003 | Password@1 | Password@1      | TEST@OPTUM.COM          | TEST@OPTUM.COM   |
#	| 950298748    | 10-21-1953  | 950298748-11           | q4combo_008 | Password@1 | Password@1      | TEST@OPTUM.COM          | TEST@OPTUM.COM   |

Scenario Outline: To verify registration negative scenarios in AARP site
Given the user is on registration page of AARP site 
When the user registers with below details in AARP site
	| Plan Member ID         | <planMemberId> |	
	| Date of birth          | <dateOfBirth>  |
Then the user navigate to registration error page of AARP site
Then the user validate registration error message of AARP site

Examples:
	 | planMemberId | dateOfBirth |
	 | 951498845    | 08-12-1945  |