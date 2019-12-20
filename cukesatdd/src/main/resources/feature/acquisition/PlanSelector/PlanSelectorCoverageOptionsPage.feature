@PlanSelector
Feature: Plan Selector Tool flow - Verify coverage options page in plan selector page

  @PRE @planrecommandonation @coveragepage @regression 
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> -CoverageOptions: <isCoverageOpt> - To validate coverage options page using Single County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engie
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
    And user validate elements in coverage options page
    And user selects plan type in coverage options page  
      | Plan Type       |<isCoverageOpt>	|

    Examples: 
      | Zipcode | isMultutiCounty | isCoverageOpt |
      |   90201 | NO              | MAPD 		  |
      |   10001 | NO              | MA	  		  |
      |   12345 | NO              | PDP	  		  |
      |   90210 | NO              | NA	  		  |
      
    @PRE @planrecommandonation @coveragepage @regression @errorScenario
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> -CoverageOptions: <isCoverageOpt> - To validate coverage options page using Single County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engie
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
    And user validate elements in coverage options page
    And user selects plan type in coverage options page  
      | Plan Type       |<isCoverageOpt>	|

    Examples: 
      | Zipcode | isMultutiCounty | isCoverageOpt |
      |   45634 | NO              | 	  		  |
          
  @PRE @planrecommandonation @coveragepage @previousfunctionafterplanselection
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> -CoverageOptions: <isCoverageOpt> - To validate coverage options page using Single County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engie
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | CountyDropDown	| <county>			|
	And user select planType and continous the page back to previous page  
      | Plan Type       |<isCoverageOpt>	|

    Examples: 
      | Zipcode | isMultutiCounty | county		   | isCoverageOpt  |
	  |   78006 | YES             | Bexar County   |  MAPD 		    |
	  
	@PRE @planrecommandonation @coveragepage @previousfunctionbeforeplanselection
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultutiCounty> -CoverageOptions: <isCoverageOpt> - To validate coverage options page using Single County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engie
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | CountyDropDown	| <county>			|
	And user select planType and Click previous button to check previous page  
      | Plan Type       |<isCoverageOpt>	|

    Examples: 
      | Zipcode | isMultutiCounty | county		   | isCoverageOpt  |
	  |   78006 | YES             | Bexar County   |  MAPD 		    |
	  |   45634 | NO              | 	   		   |  PDP			|