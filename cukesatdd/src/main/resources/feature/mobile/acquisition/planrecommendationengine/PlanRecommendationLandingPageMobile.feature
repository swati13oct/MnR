@PlanSelectorMobile
Feature: Plan Selector Tool flow - Verify landing page in plan recommendation engine using mobile

  @PREmobile @planrecommandonationmobile @landingpagemobile
  Scenario: - To validate mobile landing Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page mobile
    Then user validate elements on landing page of Plan Recommendation Engine mobile
    
  @PREmobile @planrecommandonationmobile @landingpagemobile @landingpageshoptools
  Scenario: - To validate mobile landing Page in Plan Recommendation Engine through Shop tools option
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page via shop tool mobile
    Then user validate elements on landing page of Plan Recommendation Engine mobile