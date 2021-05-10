@planRecommendationEngine @PRERegression
Feature: Plan Recommendation Engine flow - Verify landing page in plan Recommendation Engine

  @PRE @planrecommendation @PRENavigationViaGetHelpChoosing @landingpage @F372697 @F388910 @PRERegression3
  Scenario: - To validate user able to navigate to Plan Recommendation Engine via Shop For a Plan-shop-->Get Help Choosing in Tools and Validate Landing Page Elements
    Given the user is on UHC medicare acquisition site landing page
    When user navigate Plan Recommendation Engine Using Shop From Home in Find Your Plan
    Then user validate elements on landing page of Plan Recommendation Engine

  @PRE @planrecommendation @PRENavigationViaMedicareArticles @landingpage @PRERegression3
  Scenario: - To validate user able to navigate to Plan Recommendation Engine via Shop For a Plan-shop-->Get Help Choosing in Tools and Validate Landing Page Elements
    Given the user is on UHC medicare acquisition site landing page
    When user navigate Plan Recommendation Engine Using Get Started From Medicare Articles
    Then user validate elements on landing page of Plan Recommendation Engine

  @PRE @planrecommendation @PRENavigationViaGetPlanRecommendationEngine @landingpage @F372697 @F500238 @PRERegression3 @F524066
  Scenario: - To validate user able to navigate to Plan Recommendation Engine via Shop For a Plan-->Get a Plan Recommendations and Validate Landing Page Elements
    Given the user is on UHC medicare acquisition site landing page
    When user navigate to Plan Recommendation Engine and Checking Breadcrumbs
    Then user validate elements on landing page of Plan Recommendation Engine
