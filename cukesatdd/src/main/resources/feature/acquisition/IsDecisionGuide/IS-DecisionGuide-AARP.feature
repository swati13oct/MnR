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
    Then the user enters valid information for the pre entry form on AARP site    	
      | DOB							|	<DOB>								|
    Then the user clicks on Request a Free Decision Guide on the Raight Rail on VPP PLan Summary Page for Med Supp Plans on AARP site
    #Then the user validates all the required fields for blank validation on Step1 on AARP site
    #Then the user validated all fields for invalid validation on Step1 on AARP site
    Then the user enters valid information for the following fields on AARP site
      | FirstName          | <firstname>          |
      | LastName           | <lastname>           |
      | DistributionMethod | <distributionmethod> |
      | Email              | <email>              |
    #Then the user validated invalid address error message for next button on Step1 on AARP site
    Then the user validates address autocomplete on Step1 on AARP site
    Then user clicks Next to Navigate to Second Step on AARP site
    Then the user validates all the required fields for blank validation on Second Step on AARP site
    #Then the user validated all fields for invalid validation on Second Step on AARP site
    Then the user provides all valid information for Second Step on AARP site
      | DOB        | dob        |
      | PartBMonth | partBmonth |
      | PartBYear  | partByear  |
      | StartDate  | startDate  |
      | AARPno     | aarpNo     |
      | PhNo       | phNo       |
      | MobileFlag | mobileFlag |
    Then the user clicks Submit to submit Decision Guide on AARP site
    Then the user validates Thank You Page on AARP site

    Examples: 
      | UID | zipcode | isMultutiCounty | county             | plantype | firstname      | lastname      | distributionmethod | email         | DOB      | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth| partAyear| startdate   | gender| 
      |     |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | mail               |               | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February  | 2020     |   June    | male  |
      |     |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | email              | test@test.com | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February  | 2020     |   June    | male  |
