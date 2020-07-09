@IS_InsuranceAgent_AARP
Feature: 1.14 Med Supp Plans (IS) Insurance Agent  flow in AARP site

  @IS_InsuranceAgent_AARP
  Scenario Outline: UID: <UID> - To Test IS Decision Guide E2E on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> | 
    Then the user enters and  saves the entered information in Pre-entry page for validation on Licensed InsuranceAgent forms for AARP
      | DOB							|	<dob>								|
    Then the user clicks on Request a Free Insurance Agent on the Raight Rail on VPP PLan Summary Page for Med Supp Plans on AARP site
    Then the user enters valid information on Licensed Insurance Agentfor the following fields on AARP site
      | FirstName          | <firstname>          |
      | LastName           | <lastname>           |
      | DistributionMethod | <distributionmethod> |
      | Email              | <email>              |
    Then the user validates address autocomplete on Licensed Agent on AARP site
    Then the user provides DOB and Phone Number on AARP site
    | DOB        | <dob>        |
     | PhNo       | <phNo>       |
    Then the user clicks Submit to submit Licensed Insurance Agent on AARP site and validates Thank You Page
    #Then the user validates Thank You Page on Licensed Insurance Agent AARP site

    Examples: 
      | UID | zipcode | isMultutiCounty | county             | plantype | firstname      | lastname      | distributionmethod | email         | dob        | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth| partAyear| startDate | gender| 
      |     |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | mail               |               | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February  | 2020     |   June    | male  |
      #|     |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | email              | test@test.com | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February  | 2020     |   June    | male  |
