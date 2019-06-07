@fastandfurious @IS_DecisionGuide_AARP
Feature: Med Supp Plans (IS) Decision Guide flow in AARP site

  @IS_DecisionGuide_AARP @E2E_Submission
  Scenario Outline: UID: <UID> - To Test IS Decision Guide E2E on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user clicks on Request a Free Decision Guide on the Raight Rail on VPP PLan Summary Page for Med Supp Plans on AARP site
		Then the user validates all the required fields for blank validation on Step1
		Then the user validated all fields for invalid validation on Step1
		Then the user validated invalid address error message for next button on Step1
		Then the user enters valid information for the following fields
		| FirstName | <firstname> |
		| LastName | <lastname> |
	  | DistributionMethod | <distributionmethod> |
	  Then the user validates address autocomplete on Step1
	  
    Examples: 
      | UID | zipcode | isMultutiCounty | county             | plantype |
      |     |   90210 | NO              | Los Angeles County | MS       |
