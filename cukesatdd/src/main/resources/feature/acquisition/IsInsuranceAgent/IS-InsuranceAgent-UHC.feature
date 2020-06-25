@IS_InsuranceAgent_UHC
Feature: 2.14 Med Supp Plans (IS) Insurance Agent flow in UHC site

@IS_InsuranceAgent_UHC
  Scenario Outline: UID: <UID> - To Test IS Decision Guide E2E on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views plans of the below plan type in UMS site
      | Plan Type       | <plantype>        |
    #Then the user enters valid information for the pre entry form on UMS site  	
      #| DOB							|	<DOB>							|
    Then the user enters and  saves the entered information in Pre entry page for validation on IS forms on UMS site  	
      | DOB							|	<dob>							|
    Then the user clicks on Request a Free Insurance Agent on the Raight Rail on VPP PLan Summary Page for Med Supp Plans on UHC site
    
    ######Need to check remaining steps ##########
    
	#Then the user validates all the required fields for blank validation on Step1 on UMS site
    #Then the user validated all fields for invalid validation on Step1 on UMS site
    Then the user enters valid information for the following fields on UMS site
      | FirstName          | <firstname>          |
      | LastName           | <lastname>           |
      | DistributionMethod | <distributionmethod> |
      | Email              | <email>              |
    #Then the user validated invalid address error message for next button on Step1 on UMS site
    Then the user validates address autocomplete on Step1 on UMS site
    Then user clicks Next to Navigate to Second Step on UMS site
    Then the user validates Decision Guide Step 2 page info is same as the saved information from Pre-entry page on UMS site
    #Then the user validates all the required fields for blank validation on Second Step on UMS site
    #Then the user validated all fields for invalid validation on Second Step on UMS site
    #Then the user provides all valid information for Second Step on UMS site
      # |DOB        | <DOB>        |
      #| PartBMonth | <partBmonth> |
      #| PartBYear  | <partByear>  |
      #| StartDate  | <startdate>  |
      #| AARPno     | <aarpNo>     |
      #| PhNo       | <phNo>       |
      #| MobileFlag | <mobileFlag> |
    Then the user clicks Submit to submit Decision Guide on UMS site
    Then the user validates Thank You Page on UMS site

    Examples: 
      | UID | zipcode | isMultutiCounty | county             | plantype | firstname      | lastname      | distributionmethod | email         | dob        | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth| partAyear| startDate | gender| 
      |     |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | mail               |               | 04/07/1932 | January    |      2020 | 0321323215 | 3216549871 | N          | February  | 2020     |   June    | male  |
      |     |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | email              | test@test.com | 08/09/1940 | January    |      2020 | 0321323215 | 3216549871 | N          | February  | 2020     |   June    | male  |

    
   