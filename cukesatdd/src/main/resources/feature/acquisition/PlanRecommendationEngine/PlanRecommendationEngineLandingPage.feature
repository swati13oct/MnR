@PlanRecommandonationEngine
Feature: plan Recommendation Engie flow - Verify landing page in plan Recommendation Engie

  @PRE @planrecommandonation @landingpage
  Scenario: - To validate landing Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page
    When user validate elements on landing page of Plan Recommendation Engine
    Then user validate Header and Footer elements of Plan Recommendation Engine