@PlanSelector
Feature: Plan Selector Tool flow - Verify header and footer page in plan selector page

  @PRE @planrecommandonation @headerfooter
  Scenario Outline: - To validate landing Page in Plan Recommendation Engie
    Given the user is on UHC medicare acquisition site landing page
#    When user validate elements on landing page of Plan Recommendation Engine
#    Then user validate Header and Footer elements of Plan Recommendation Engine
    Then user validate Header and Footer Functionality of Plan Recommendation Engine
    | Zip Code        | <Zipcode>    |
    | EMail           | <EMail>      |
    | Search Key      | <SearchKey>  |		   
    		   
    Examples: 
      | Zipcode | EMail 		|SearchKey |
      |   90201 | abc@domain.com|plan for recommandations |