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
    #Then the user validates all the required fields for blank validation on Step1
    #Then the user validated all fields for invalid validation on Step1
    Then the user enters valid information for the following fields
      | FirstName          | <firstname>          |
      | LastName           | <lastname>           |
      | DistributionMethod | <distributionmethod> |
      | Email              | <email>              |
    #Then the user validated invalid address error message for next button on Step1
    Then the user validates address autocomplete on Step1
    Then user clicks Next to Navigate to Second Step
    Then the user validates all the required fields for blank validation on Second Step
    #Then the user validated all fields for invalid validation on Second Step
    Then the user provides all valid information for Second Step
      | DOB        | dob        |
      | PartBMonth | partBmonth |
      | PartBYear  | partByear  |
      | StartDate  | startDate  |
      | AARPno     | aarpNo     |
      | PhNo       | phNo       |
      | MobileFlag | mobileFlag |
    Then the user clicks Submit to submit Decision Guide on AARP site
    Then the user validates Thank You Page

    Examples: 
      | UID | zipcode | isMultutiCounty | county             | plantype | firstname      | lastname      | distributionmethod | email         | dob      | partBmonth | partByear | aarpNo     | phNo       | mobileFlag |
      |     |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | mail               |               | 01011945 | January    |      2020 | 0321323215 | 3216549871 | N          |
      |     |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | eamil              | test@test.com | 01011945 | January    |      2020 | 0321323215 | 3216549871 | N          |
