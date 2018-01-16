@fixedTestCaseTest
@pharmacylocatorUHCMdefaultZip
Feature:1.20.1-VBF-Member-To test Locate a Pharmacy tool in UMS site for all pharmacy types for default zipcode in UMS site-test1
@defaultZip
Scenario Outline:To verify available pharmacies for default zipcode in UMS site
Given registered member to verify locate a pharmacy in UMS Site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user enters distance details in UMS site
	| Distance	| <distance>	|
	| County	| <countyName>	|
And the user chooses a plan from dropdown in UMS site
	| <planName> |
And the user searches for pharmacies available in UMS site
Then the user validates the pharmacies available in UMS site

Examples:
	| plantype | memberType   | distance  | countyName |planName|
	| MAPD      |  Group     |    25      | Cayuga County|UnitedHealthcare Group Medicare Advantage (PPO)|