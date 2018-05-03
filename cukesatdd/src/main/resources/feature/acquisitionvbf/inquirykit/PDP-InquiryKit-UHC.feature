@pdpInquiryKit
@fixedTestCaseTest
Feature:2.05-VBF-Acq-To test PDP inquiry flow in UHC site
@pdpInquiryKitUHC
Scenario Outline:To verify PDP inquiry flow in UHC site
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in row form
When the user navigates to Request More Help and Information page under pdp section in UHC Site
And the user accesses the Request Plan Information and Enrollment Materials in UHC site
Then the user submits by entering following details in Order Enrollment Information page in UHC Site
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