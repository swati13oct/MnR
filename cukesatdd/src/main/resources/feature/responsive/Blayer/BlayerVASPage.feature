@BLayerVASPageFnF
Feature: IS VPP Header/Footer Integration - B Layer VAS Page

Scenario Outline: To validate MedSupp Header and Footer on B Layer VAS Page
Given the user is on the vpp portfolio page
Then the user performs plan search using zipcode
              | Zip Code |<zipCode>|
              | County   |<county> |
Then the user navigates to the following plan type
| PlanType | <planType> |
And the user selects B Layer VAS Page and validates header and footer
|First Plan Name	|<firstPlan>|
|Second Plan Name	|<secondPlan>|

Examples:
		|zipCode|county						 |planType |firstPlan|secondPlan|
		|35004  |St. Clair County  |MS       |plan-A	 |plan-G		|
		|35006  |Walker County	   |MS       |plan-A	 |plan-G		|
		|36925  |Sumter County		 |MS       |plan-A	 |plan-G		|