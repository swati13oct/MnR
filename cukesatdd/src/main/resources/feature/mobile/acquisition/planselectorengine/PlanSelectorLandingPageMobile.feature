@PlanSelectorMobile
Feature: Plan Selector Tool flow - Verify landing page in plan selector mobile page

  @PREmobile @planrecommandonationmobile @landingpagemobile
  Scenario Outline: - To validate mobile landing Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page mobile
      | Device Name | <DeviceName> |
    When user validate elements on landing page of Plan Recommendation Engine mobile

    Examples: 
      | DeviceName |
      | Samsung S9 |
      #| iphonex    |
