@fastandfurious @IS_DecisionGuide_AARP
Feature: Med Supp Plans (IS) Decision Guide flow in AARP site

@IS_DecisionGuide_AARP
  Scenario Outline: UID: <UID> - To Test IS Decision Guide E2E on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user clicks on Request a Free Decision Guide on the Raight Rail on VPP PLan Summary Page for Med Supp Plans on AARP site

    Examples: 
      | UID       | zipcode | isMultutiCounty | county           | plantype | 
      |  |   90210 | NO              | Los Angeles County | MS     | 
       