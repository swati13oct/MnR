@PlanSelectorHeaderFooterMobile
Feature: Plan Selector Tool flow - Verify Headerlanding page in plan selector mobile page

  @PREmobile @planrecommandonationmobile @landingpagemobile @headerfootermobile
  Scenario Outline: - To validate mobile landing Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page mobile
      | Device Name | <DeviceName> |
    When user validate presence of Header and Footer elements on landing page mobile

    Examples: 
      | DeviceName |
      | Samsung s9 |
      #| iphonex    |
      #| S8         |
      #| air pad 2  |
      #| iphone 8   |
      #| iphone 7+  |
      #| s8+        |
      #| ipad       |
      #|Nokia 7.2|
