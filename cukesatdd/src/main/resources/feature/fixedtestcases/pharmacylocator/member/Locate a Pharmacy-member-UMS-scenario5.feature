@fixedTestCaseTest
@memberpharmacylocatorblayerscenario5
Feature:20.5-Tier-1.20.5-To test Locate a Pharmacy tool in UMS site for all pharmacy types for default zipcode in UMS site-test5
Scenario Outline:To verify espanol and chinese contents
Given registered member to verify locate a pharmacy in UMS Site
	| Plan Type    | <plantype>   |
	| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user clicks below Language Link in UMS site
	|<language>|
And the user enters zipcode and distance details for UMS site
    | Zip Code    | <zipCode>   |
	| Distance    | <distance>  |
	| County      | <countyName>|
And the user chooses a plan from dropdown in UMS site
	| <planName>  |
And the user searches for pharmacies available in UMS site
Then the user validates the pharmacies available for the above selected language in UMS site

Examples:
  | plantype | memberType  | zipCode     | distance | countyName        | planName 		           	           | language						     |
  | MAPD    | 	Group	 | 90210       | 2        |       | UnitedHealthcare Group Medicare Advantage (PPO)  |Spanish |
 # | MAPD    | 	Group	 | 90210       | 2        |       | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |Chinese |
