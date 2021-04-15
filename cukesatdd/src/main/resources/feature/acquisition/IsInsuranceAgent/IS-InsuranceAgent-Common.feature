Feature: 1.14 Med Supp Plans (IS) Insurance Agent  flow

  #@IS_InsuranceAgent_AARP1
  Scenario Outline: UID: <UID> - To Test IS Insurance Agent E2E on <site> site
    Given the user is on medicare acquisition site landing page
	| Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> | 
    Then the user enters and  saves the entered information in Pre-entry page for validation on Licensed InsuranceAgent forms
      | DOB							|	<dob>								|
    Then the user clicks on Request a Free Insurance Agent on the Raight Rail on VPP PLan Summary Page for Med Supp Plans
    Then the user enters valid information on Licensed Insurance Agentfor the following fields
      | FirstName          | <firstname>          |
      | LastName           | <lastname>           |
      | DistributionMethod | <distributionmethod> |
      | Email              | <email>              |
    Then the user validates address autocomplete on Licensed Agent
    Then the user provides DOB and Phone Number
    | DOB        | <dob>        |
     | PhNo       | <phNo>       |
    Then the user clicks Submit to submit Licensed Insurance Agent and validates Thank You Page
    
		#@IS_InsuranceAgent_Common_AARP1
    Examples: 
      |site| UID | zipcode | isMultutiCounty | county             | plantype | firstname      | lastname      | distributionmethod | email         | dob        | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth| partAyear| startDate | gender| 
      |AARP|     |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | mail               |               | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February  | 2020     |   June    | male  |
      |AARP|     |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | email              | test@test.com | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February  | 2020     |   June    | male  |
	
	#@IS_InsuranceAgent_Common_UHC1
     Examples: 
      |site| UID | zipcode | isMultutiCounty | county             | plantype | firstname      | lastname      | distributionmethod | email         | dob        | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth| partAyear| startDate | gender| 
      |UHC|     |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | mail               |               | 04/07/1932 | January    |      2020 | 0321323215 | 3216549871 | N          | February  | 2020     |   June    | male  |
      |UHC|     |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | email              | test@test.com | 08/09/1940 | January    |      2020 | 0321323215 | 3216549871 | N          | February  | 2020     |   June    | male  |

       #@IS_InsuranceAgent_AARP
     Scenario Outline: UID: <UID> - To Test IS Insurance Agent E2E on <site> site
    Given the user is on medicare acquisition site landing page
	| Site | <site> |
    Given the user clicks on Request a Free Insurance Agent
      | PagePath | <path>     |
      Then the user enters valid information on Licensed Insurance Agentfor the following fields
      | FirstName          | <firstname>          |
      | LastName           | <lastname>           |
      | DistributionMethod | <distributionmethod> |
      | Email              | <email>              |
    Then the user validates address autocomplete on Licensed Agent
    Then the user provides DOB and Phone Number
    | DOB        | <dob>        |
     | PhNo       | <phNo>       |
    Then the user clicks Submit to submit Licensed Insurance Agent and validates Thank You Page
    
	#@IS_InsuranceAgent_Common_AARP
    Examples: 
      |site| UID | zipcode | isMultutiCounty | county             | plantype | firstname      | lastname      | distributionmethod | email         | dob        | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth| partAyear| startDate | gender|path                                | 
      |AARP| 11112    |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | mail               |               | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February  | 2020     |   June    | male  |health-plans/medicare-supplement-plans/agent-appointment.html| 
    #  |AARP|     |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | email              | test@test.com | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February  | 2020     |   June    | male  |health-plans/medicare-supplement-plans/agent-appointment.html| 
    
	#@IS_InsuranceAgent_Common_UHC
	Examples: 
      |site| UID | zipcode | isMultutiCounty | county             | plantype | firstname      | lastname      | distributionmethod | email         | dob        | partBmonth | partByear | aarpNo     | phNo       | mobileFlag | partAmonth| partAyear| startDate | gender|path                                | 
      |UHC| 11111    |   90210 | NO              | Los Angeles County | MS       | test-mnr-first | test-mnr-last | mail               |               | 01/01/1945 | January    |      2020 | 0321323215 | 3216549871 | N          | February  | 2020     |   June    | male  |health-plans/medicare-supplement-plans/agent-appointment.html| 
    