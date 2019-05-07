@fastandfurious @IS_DecisionGuide_UHC
Feature: Med Supp Plans (IS) Decision Guide flow in AARP site

@IS_DecisionGuide_UHC
  Scenario Outline: UID: <TID> - To Test IS Decision Guide E2E on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user clicks on Request a Free Decision Guide on the Raight Rail on VPP PLan Summary Page for Med Supp Plans on UHC site

    Examples: 
   | UID       | zipcode | isMultutiCounty | county           | plantype | planName                                   | 
   |  |   90210 | NO              | Los Angeles County | MS     | AARP MedicareComplete SecureHorizons (HMO) |
   