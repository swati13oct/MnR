@PlanRecommendationEngine
Feature: Plan Recommendation Engine flow - Verify landing page in plan Recommendation Engine
    
  @PRE @planrecommendation @PRENavigationViaGetHelpChoosing @landingpage @F372697 @F388910 @F442691
  Scenario: - To validate user able to navigate to Plan Recommendation Engine via Shop For a Plan-shop-->Get Help Choosing in Tools and Validate Landing Page Elements
  Given the user is on UHC medicare acquisition site landing page
  When user navigate Plan Recommendation Engine Using Get Help Choosing in Tools
  Then user validate elements on landing page of Plan Recommendation Engine
  
  @PRE @planrecommendation @PRENavigationViaGetPlanRecommendationEngine @landingpage @F372697
  Scenario: - To validate user able to navigate to Plan Recommendation Engine via Shop For a Plan-->Get a Plan Recommendations and Validate Landing Page Elements
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    Then user validate elements on landing page of Plan Recommendation Engine