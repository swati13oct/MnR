@PlanRecommandonationEngine
Feature: Plan Recommendation Engine flow - Verify special needs page in plan Recommendation Engine

  @PRE @planrecommandonation @specialneedspage @elementValidation
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , - To validate special needs page Elements in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultiCounty> 	|
    And user selects plan type in coverage options page  
      | Plan Type       |<isCoverageOpt>	|
	Then user validate elements in Special Needs page
	
	Examples: 
      | Zipcode | isMultiCounty   |isCoverageOpt |
      |   90201 | NO              |MAPD 		 |
  
  @PRE @planrecommandonation @specialneedspage @positive 
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , - To validate special needs page positive scenarios in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultiCounty> 	|
      | CountyDropDown	| <county>			|
    And user selects plan type in coverage options page  
      | Plan Type       |<isCoverageOpt>	|
	And user selects SNP options in Special Needs Page 
	  | SNP Options 	|<specialNeeds>		|

    Examples: 
      | Zipcode | isMultiCounty   | county		  |isCoverageOpt | specialNeeds 				 |
      |   90201 | NO              | 			  |MAPD 		 | Medicaid,condition,facility	 |
      |   78006 | YES             | Bexar County  |MA	 		 | Medicaid,condition,facility	 |
      |   45634 | NO              | 			  |PDP 		 	 | condition,facility	 		 |
      |   10001 | NO              | 			  |NA 		 	 | facility	 					 |
      |   12345 | NO              | 			  |MAPD		 	 | None		 					 |
      
  @PRE @planrecommandonation @specialneedspage @errorscenario
  Scenario Outline: <Zipcode>, <isMultiCounty> , <isCoverageOpt> , <specialNeeds> , - To validate special needs page error scenarios in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultiCounty> 	|
      | CountyDropDown	| <county>			|
    And user selects plan type in coverage options page  
      | Plan Type       |<isCoverageOpt>	|
	And user validating error scenario in Special Needs Page 
	  | SNP Options 	|<specialNeeds>		|

    Examples: 
      | Zipcode | isMultiCounty   | county		   |isCoverageOpt | specialNeeds 				    |
      |   90201 | NO              | 			   |MAPD 		  | Medicaid,condition,facility,None |
#      |   21212 | YES             |Baltimore County|MA	 		  | 	 |