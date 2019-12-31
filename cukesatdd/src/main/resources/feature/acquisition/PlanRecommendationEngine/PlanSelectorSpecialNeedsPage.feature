@PlanRecommandonationEngine
Feature: Plan Recommendation Engie flow - Verify coverage options page in plan Recommendation Engie

  @PRE @planrecommandonation @specialneedspage @regression 
  Scenario Outline: Zipcode: <Zipcode> -MultiCountyOptions: <isMultiCounty> -CoverageOptions: <isCoverageOpt> -SNP: <specialNeeds> -Status:<status> - To validate coverage options page using Single County and CoverageOptions: <isCoverageOpt> in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    And clicks on get started button and runs questionnaire
      | Zip Code        | <Zipcode>         |
      | Is Multi County | <isMultiCounty> |
    And user validate elements in coverage options page
    And user selects plan type in coverage options page  
      | Plan Type       |<isCoverageOpt>	|
	Then user validate elements in Special Needs page
	And user selects SNP options in Special Needs Page 
	  | SNP Options 	|<specialNeeds>		|
	  | Status 			|<status>	     	|

    Examples: 
      | Zipcode | isMultiCounty   | isCoverageOpt | specialNeeds         | status	|
      |   90201 | NO              | MAPD 		  |	 |Negative|