@smokeTest
Feature: 1.12-VBF-MemRedesign-To test Locate a Pharmacy tool
@smokeTest_PharmacyLocatorMem @rallyDashboard @testharness
Scenario Outline: Verify all available pharmacies for default zipcode in Redesign site
Given registered member to verify locate a pharmacy in Redesign Site
	| Plan Type | <planType> |
  | Member Type  | <memberType> |
When the user navigates to pharmacy search page in Redesign site
And the user enters distance details in Redesign site
	| Distance | <distance>  |
Then the user validates the pharmacies available in Redesign site
Then the user Validates show on map link in Redesign Site
Then the user validate more information content based on plan type in Redesign Site

Examples:
	| planType | memberType | distance |
	| MAPD	   | UhcIndOrderPlan  |   25      |
#	| MAPD	   | AARPIndOrderPlan  |   25      |
#	| MAPD	   | GrpRetireeOrderPlan  |   25      |   