@fastandfurious
Feature: IS VPP Header/Footer Integration - Plan Compare

Scenario Outline: To validate MedSupp Header and Footer
  Given the user is on the vpp portfolio page 
    Then the user performs plan serach using zipcode
      | Zip Code | <zipCode> |
      | County   | <county>  |
 Then the user navigates to the following plan type
      | Plan Type | <planType> |
 And  the user selects plan to compare and validates header and footer
|First Plan Name	|<firstPlan>|
|Second Plan Name	|<secondPlan>|

Examples:
		|zipCode|county						 |planType |firstPlan|secondPlan|
		|35004  |St. Clair County  |MS       |plan-F	 |plan-G		|
		
		
		