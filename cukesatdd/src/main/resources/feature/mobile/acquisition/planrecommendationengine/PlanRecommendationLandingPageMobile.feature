@PlanSelectorMobile
Feature: Plan Selector Tool flow - Verify landing page in plan selector mobile page

  @PREmobile @planrecommandonationmobile @landingpagemobile
  Scenario Outline: - To validate mobile landing Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site mobile
      | Device Name | <DeviceName> |
    When user navigates to PRE landing page mobile
    Then user validate elements on landing page of Plan Recommendation Engine mobile

    Examples: 
      | DeviceName |
      | Samsung s9 |
      #| S8|
      #|Samsung|
      #|galaxy|
      #|Nokia 7.2|
