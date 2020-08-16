Feature: 2.14 Med Supp Plans (IS) Insurance Agent flow in UHC site

@IS_InsuranceAgent_UHC
  Scenario Outline: UID: <UID> - To Test IS Insurance Agent flow E2E on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views plans of the below plan type in UMS site
      | Plan Type       | <plantype>        |
     Then the user enters and  saves the entered information in Pre entry page for validation on IS Insurance Agent forms on UHC site	
      | DOB							|	<dob>							|
    Then the user clicks on Request a Free Insurance Agent on the Raight Rail on VPP PLan Summary Page for Med Supp Plans on UHC site
    Then the user enters valid information for the following fields on UMS site for Insurance Agent
      | FirstName          | <firstname>          |
      | LastName           | <lastname>           |
      | DistributionMethod | <distributionmethod> |
      | Email              | <email>              |
    Then the user validates address autocomplete on Licensed Agent on UHC site
     Then the user provides DOB and Phone Number on uhc site
     | DOB        | <dob>        |
     | PhNo       | <phNo>       |
  Then the user clicks Submit to submit Licensed Insurance Agent on UHC site and validates Thank You Page
    #Then the user validates Thank You Page on Licensed Insurance Agent UHC site

    Examples: 
      | UID | zipcode | isMultutiCounty | county             | plantype | firstname      | lastname      | distributionmethod | email         | dob        | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth| partAyear| startDate | gender| 
      |     |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | mail               |               | 04/07/1932 | January    |      2020 | 0321323215 | 3216549871 | N          | February  | 2020     |   June    | male  |
      |     |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | email              | test@test.com | 08/09/1940 | January    |      2020 | 0321323215 | 3216549871 | N          | February  | 2020     |   June    | male  |

    
   