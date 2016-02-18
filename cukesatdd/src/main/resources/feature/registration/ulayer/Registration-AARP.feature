@registrationAARP
Feature:To test registration flow in AARP site
Scenario Outline:To verify registration for three plan combo member in AARP site
Given the details of user to be registered in AARP site
	| Plan Member ID         | <planMemberId> |	
	| Date of birth          | <dateOfBirth>  |
When the user confirms plan details of the first plan in AARP site
And the user adds second plan in AARP site
	| Additional Plan Member ID | <secondMemberId> |
And the user confirms personal and plan information for both plans in AARP site
And the user registers with the following details in AARP site
	| Create a username     | <userName>        |
	| Create a password     | <password>        |
	| Confirm password      | <confirmPassword> |
	| Email address         | <email>           |
	| Confirm email address | <confirmEmail>    |
Then the user registers successfully in AARP site

	
Examples:
	| planMemberId | dateOfBirth | shipMemberId | userName    | password   | confirmPassword | email                   | confirmEmail            |
#	| 0016550251   | 10-21-1939  | 373563187-11   | q2ulayer_14 | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |
#	| 014946795-1  | 3/1/1946    | 386372942-11 | q2combo_026 | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |
#   | 0019015191   | 12-03-1935  | 362548886-11 | q2combo_031 | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |
##	| 935608413-01 | 07-05-1935  | 935608413-11 | q4combo_001 | Password@1 | Password@1	     | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM |



Scenario Outline:To verify registration for Ship member in AARP site
Given the details of user to be registered in AARP site
	| Plan Member ID | <planMemberId> |	
	| Date of birth  | <dateOfBirth>  |
When the user confirms personal and plan information in AARP site
And the user registers with the following details in AARP site
	| Create a username     | <userName>        |
	| Create a password     | <password>        |
	| Confirm password      | <confirmPassword> |
	| Email address         | <email>           |
	| Confirm email address | <confirmEmail>    |
And the user views go green and selects from the available documents in AARP site
	| Claims | <claims> |
Then the user registers successfully in AARP site

Examples:
	| planMemberId | dateOfBirth | userName   | password  | confirmPassword | email                   | confirmEmail            | claims |
#	| 352764589-11 | 9/1/1943    | q2ship_024 | password1 | password1       | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM | yes    |
#	| 377726446-11 | 12/1/1958   | q2ship_029 | password1 | password1       | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM | yes    |
#	| 355345364-11 | 12/1/1958   | q2ship_031 | password1 | password1       | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM | yes    |




Scenario Outline:To verify registration for federal member without perks in AARP site
Given the details of user to be registered in AARP site
	| Plan Member ID | <planMemberId> |
	| Date of birth  | <dateOfBirth>  |
When the user confirms plan details in AARP site
And the user registers with the following details in AARP site
	|  Create a username     | <userName>        |
	|  Create a password     | <password>        |
	|  Confirm password      | <confirmPassword> |
	|  Email address         | <email>           |
	|  Confirm email address | <confirmEmail>    |
	| available documents    | <availableDocs>   |
Then the user registers successfully in AARP site

Examples:
	| planMemberId | dateOfBirth | userName     | password   | confirmPassword | email                   | confirmEmail            | availableDocs		                         |
#	| 0117044081   | 05-07-1925  | regtest01    | Password@1 | Password@1      | TEST@OPTUM.COM          | TEST@OPTUM.COM          | Prescription Drug Explanation of Benefits (EOB) |               
#	| 870421270    | 11/16/1938  | q2ulayer_048 | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM | Annual Directory Mailing                        |
#	| 001536912    | 05/4/1921   | q2ulayer_021 | Password@1 | Password@1      | UHCMNRPORTALS@GMAIL.COM | UHCMNRPORTALS@GMAIL.COM | Prescription Drug Explanation of Benefits       |
#	| 0118702071   | 07-27-1947  | q3aarp_001   | Password@1 | Password@1      | DANIEL.WILSON@OPTUM.COM | DANIEL.WILSON@OPTUM.COM | Prescription                                    |






Scenario Outline:To verify registration for federal member with perks in AARP site
Given the details of user to be registered in AARP site
	| Plan Member ID | <planMemberId> |
	| Date of birth  | <dateOfBirth>  |
When the user confirms personal and plan details in AARP site
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
When the user confirms the personal and plan information for the first plan in AARP site
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
	| 950298748    | 10-21-1953  | 950298748-11           | q4combo_008 | Password@1 | Password@1      | TEST@OPTUM.COM          | TEST@OPTUM.COM   |