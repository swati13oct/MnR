@fixedTestCaseTest
@memberpharmacylocatorblayerscenario3
Feature:20.3-Tier-1.20.3-To test Locate a Pharmacy tool in UMS site for all pharmacy types for default zipcode in UMS site-test3
Scenario Outline:To verify available pharmacies for particular zipcode in UMS site
Given registered member to verify locate a pharmacy in UMS Site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user enters zipcode and distance details for UMS site
    | Zip Code    | <zipCode>   |
	| Distance    | <distance>  |
	| County      | <countyName>|
And the user chooses a plan from dropdown in UMS site
	| <planName>  |
And the user searches for pharmacies available in UMS site
Then the user validates the pharmacies available in UMS site

Examples:
  | plantype | memberType  | zipCode     | distance | countyName        | planName 		           	           | pharmacyType						     |
  | MAPD    | 	Group	 | 90210       | 2        |       | UnitedHealthcare Group Medicare Advantage (PPO)  | Standard Network Pharmacy |