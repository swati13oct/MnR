@pdpInquiryKit
@fixedTestCaseTest
Feature:2.06-VBF-Acq-To test PDP inquiry flow in AARP site
@pdpInquiryKitAARP
Scenario Outline:To verify PDP inquiry flow in AARP site
Given the user is on the AARP acquisition Site home page
When the user navigates to Request More Help and Information page under pdp section in AARP Site
And the user accesses the Request Plan Information and Enrollment Materials in AARP site
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
	
@fastandfurious 
@aprilRelease2018 @HicnMBI_Validations
Scenario Outline:To Validate HICN and MBI formats are accepted for Medicare ID in PDP inquiry flow in AARP site

Given the user is on the AARP acquisition Site home page
When the user navigates to Request More Help and Information page under pdp section in AARP Site
And the user accesses the Request Plan Information and Enrollment Materials in AARP site
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
Then the user validates the correct formatting for Medicare ID field
|  Valid Format	| <validFormat>	|

Examples:
	|planGuide                      | firstName	| lastName | dob	| relationShip				| emailAddress | confirmEmailAddress	| emailUpdates	| gender | medicare	| addressLine1  | addressLine2	| city		| state		| zipCode | dayTimePhNumber	| validFormat |
	|AARP MedicareRx Walgreens (PDP)|FirstName	| LastName | 01/01/1990	| Self - I have a Medicare number	| test@uhc.com | test@uhc.com		| Yes		| Male	 | 111111111	| California	| California	| California	| CALIFORNIA	| 90210	  | 111-111-1111	| false |
	|AARP MedicareRx Walgreens (PDP)|FirstName	| LastName | 01/01/1990	| Self - I have a Medicare number	| test@uhc.com | test@uhc.com		| Yes		| Male	 | 2A22C22YK22	| California	| California	| California	| CALIFORNIA	| 90210	  | 111-111-1111	| true |
|AARP MedicareRx Walgreens (PDP)|FirstName	| LastName | 01/01/1990	| Self - I have a Medicare number	| test@uhc.com | test@uhc.com		| Yes		| Male	 | 123456789a1B	| California	| California	| California	| CALIFORNIA	| 90210	  | 111-111-1111	| true |
	|AARP MedicareRx Walgreens (PDP)|FirstName	| LastName | 01/01/1990	| Self - I have a Medicare number	| test@uhc.com | test@uhc.com		| Yes		| Male	 | A123456	| California	| California	| California	| CALIFORNIA	| 90210	  | 111-111-1111	| true |
	|AARP MedicareRx Walgreens (PDP)|FirstName	| LastName | 01/01/1990	| Self - I have a Medicare number	| test@uhc.com | test@uhc.com		| Yes		| Male	 | Uex123456	| California	| California	| California	| CALIFORNIA	| 90210	  | 111-111-1111	| true |
	|AARP MedicareRx Walgreens (PDP)|FirstName	| LastName | 01/01/1990	| Self - I have a Medicare number	| test@uhc.com | test@uhc.com		| Yes		| Male	 | Utx123456789	| California	| California	| California	| CALIFORNIA	| 90210	  | 111-111-1111	| true |
	|AARP MedicareRx Walgreens (PDP)|FirstName	| LastName | 01/01/1990	| Self - I have a Medicare number	| test@uhc.com | test@uhc.com		| Yes		| Male	 | A1234567890	| California	| California	| California	| CALIFORNIA	| 90210	  | 111-111-1111	| true |
	|AARP MedicareRx Walgreens (PDP)|FirstName	| LastName | 01/01/1990	| Self - I have a Medicare number	| test@uhc.com | test@uhc.com		| Yes		| Male	 | 2at2Cu2YK22	| California	| California	| California	| CALIFORNIA	| 90210	  | 111-111-1111	| true |
	|AARP MedicareRx Walgreens (PDP)|FirstName	| LastName | 01/01/1990	| Self - I have a Medicare number	| test@uhc.com | test@uhc.com		| Yes		| Male	 | by1234567	| California	| California	| California	| CALIFORNIA	| 90210	  | 111-111-1111	| false |
	|AARP MedicareRx Walgreens (PDP)|FirstName	| LastName | 01/01/1990	| Self - I have a Medicare number	| test@uhc.com | test@uhc.com		| Yes		| Male	 | 2ab2Ci2Yz22	| California	| California	| California	| CALIFORNIA	| 90210	  | 111-111-1111	| false |
	