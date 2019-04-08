@pdpInquiryKit
@fixedTestCaseTest
Feature: 2.06-VBF-Acq-To test PDP inquiry flow in AARP site (GATED)
@pdpInquiryKitULayerSmoke
Scenario Outline:To verify PDP inquiry flow in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user navigates to request more help and information in AARP site
And the user accesses the Request Plan Information and Enrollment Materials in AARP site
And user validates error messages when blank form is selected on AARP site
#And user enters the invalid values in blank form on AARP site	
#And user validates error message for invalid values on AARP site	
Then the user submits by entering following details in Order Enrollment Information page in AARP Site
	| Plan guide		|<planGuide> |
	| First name		| <firstName>		|
	| Last name		| <lastName>		|
	| Date of Birth		| <dob>			|
	| Relationship		| <relationShip>	|
	| Email address		| <emailAddress>	|
	| Confirm email address	| <confirmEmailAddress>	|
	| Email updates		| <emailUpdates>	|
	| Gender		| <gender>		|
	| Medicare		| <medicare>		|
	| Address line 1	| <addressLine1>	|
	| Address line 2	| <addressLine2>	|
	| City			| <city>		|
	| State			| <state>		|
	| Zip Code		| <zipCode>		|
	| Daytime phone number	| <dayTimePhNumber>	|

Examples:
	|planGuide                      | firstName	| lastName | dob	| relationShip				| emailAddress | confirmEmailAddress	| emailUpdates	| gender | medicare	| addressLine1  | addressLine2	| city		| state		| zipCode | dayTimePhNumber	|
	|AARP MedicareRx Walgreens (PDP)|FirstName	| LastName | 01/01/1990	| Self - I have a Medicare number	| test@uhc.com | test@uhc.com		| Yes		| Male	 | 111111111A	| California	| California	| California	| CALIFORNIA	| 90210	  | 111-111-1111	|

	

@pdpInquiryKitULayerRegression
Scenario Outline:To verify PDP inquiry flow in AARP site
Given the user is on AARP medicare acquisition site landing page
When the user navigates to request more help and information in AARP site
And the user accesses the Request Plan Information and Enrollment Materials in AARP site
And user validates error messages when blank form is selected on AARP site
And user enters the invalid values in blank form on AARP site	
And user validates error message for invalid values on AARP site	
Then the user submits by entering following details in Order Enrollment Information page in AARP Site
	| Plan guide		|<planGuide> |
	| First name		| <firstName>		|
	| Last name		| <lastName>		|
	| Date of Birth		| <dob>			|
	| Relationship		| <relationShip>	|
	| Email address		| <emailAddress>	|
	| Confirm email address	| <confirmEmailAddress>	|
	| Email updates		| <emailUpdates>	|
	| Gender		| <gender>		|
	| Medicare		| <medicare>		|
	| Address line 1	| <addressLine1>	|
	| Address line 2	| <addressLine2>	|
	| City			| <city>		|
	| State			| <state>		|
	| Zip Code		| <zipCode>		|
	| Daytime phone number	| <dayTimePhNumber>	|

Examples:
	|planGuide                      | firstName	| lastName | dob	| relationShip				| emailAddress | confirmEmailAddress	| emailUpdates	| gender | medicare	| addressLine1  | addressLine2	| city		| state		| zipCode | dayTimePhNumber	|
	|AARP MedicareRx Walgreens (PDP)|FirstName	| LastName | 01/01/1990	| Self - I have a Medicare number	| test@uhc.com | test@uhc.com		| Yes		| Male	 | 111111111A	| California	| California	| California	| CALIFORNIA	| 90210	  | 111-111-1111	|
	|AARP MedicareRx Preferred (PDP) and Saver Plus (PDP) (combined)|FirstName	| LastName | 01/01/1990	| Self - I have a Medicare number	| test@uhc.com | test@uhc.com		| Yes		| Male	 | 111111111A	| Guam	| Guam	| Guam	| GUAM	| 96910	  | 111-111-1111	|
	|Both							|FirstName	| LastName | 01/01/1990	| Self - I have a Medicare number	| test@uhc.com | test@uhc.com		| Yes		| Male	 | 111111111A	| California	| California	| California	| CALIFORNIA	| 90210	  | 111-111-1111	|
