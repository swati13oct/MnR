@PlanRecommandonationEngineMobile
Feature: Plan Selector Tool flow - Verify landing page in plan recommendation engine using mobile

  @PRE @planrecommandonationmobile @landingpagemobile @landingpageelementsmobile @F385612 @PRERegressionMobile
  Scenario: - To validate mobile landing Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site mobile
   	When user navigates to PRE landing page mobile
    Then user validate elements on landing page of Plan Recommendation Engine mobile
    
  @PRE @planrecommandonationmobile @landingpagemobile @landingpageshoptools @F385612
  Scenario: - To validate mobile landing Page in Plan Recommendation Engine through Shop tools option
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page via shop tool mobile
    Then user validate elements on landing page of Plan Recommendation Engine mobile