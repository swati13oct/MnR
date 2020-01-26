@PlanRecommandonationEngine
Feature: plan Recommendation Engie flow - Verify header and footer page in plan Recommendation Engie

  @PRE @planrecommandonation @PRENavigationViaGetHelpChoosing @regression
  Scenario: - To validate user able to navigate to Plan Recommendation Engie via Shop For a Plan-shop-->Get Help Choosing in Tools 
  Given the user is on UHC medicare acquisition site landing page
  When user navigate Plan Recommendation Engine Using Get Help Choosing in Tools
  
  @PRE @planrecommandonation @headervalidation @regression
  Scenario: - To validate user able to navigate to Plan Recommendation Engie via Shop For a Plan-->Get a Plan Recommendations
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    Then user validate Header elements and Link Validation of Plan Recommendation Engine
      
@PRE @planrecommandonation @footervalidation @regression
  Scenario: - To validate user able to navigate to Plan Recommendation Engie via Shop For a Plan-->Get a Plan Recommendations
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    Then user validate Footer elements and Link Validation of Plan Recommendation Engine

      
  @PRE @planrecommandonation @headerfooterfunctionality @regression
  Scenario Outline: - To validate user able to navigate to Plan Recommendation Engie via Shop For a Plan-->Get a Plan Recommendations
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    Then user validate Header and Footer Functionality of Plan Recommendation Engine
    | Zip Code        | <Zipcode>    |
    | EMail           | <EMail>      |
    | Search Key      | <SearchKey>  |		   
    		   
    Examples: 
      | Zipcode | EMail 		|SearchKey |
      |   90201 | abc@domain.com|plan for recommandations|