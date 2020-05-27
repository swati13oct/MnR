@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify header and footer page in plan Recommendation Engine

  @PRE @planrecommendation @headervalidation @HFlinkvalidation @F383639
  Scenario: - To validate Header elements and Links Verification in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    Then user validate Header elements and Link Validation of Plan Recommendation Engine

  @PRE @planrecommendation @footervalidation @HFlinkvalidation @F383639
  Scenario: - To validate Footer elements and Links Verification in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    Then user validate Footer elements and Link Validation of Plan Recommendation Engine

  @PRE @planrecommendation @headerfooterfunctionality @F383639
  Scenario Outline: - To validate Header and Footer Functionalities in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    Then user validate Header and Footer Functionality of Plan Recommendation Engine
      | Zip Code   | <Zipcode>   |
      | EMail      | <EMail>     |
      | Search Key | <SearchKey> |

    Examples: 
      | Zipcode | EMail          | SearchKey                |
      |   90201 | abc@domain.com | plan for recommandations |
