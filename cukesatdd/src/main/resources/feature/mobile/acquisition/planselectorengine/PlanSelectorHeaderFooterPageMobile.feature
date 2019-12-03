@PlanSelectorHeaderFooterMobile
Feature: Plan Selector Tool flow - Verify Headerlanding page in plan selector mobile page

  @PREmobile @planrecommandonationmobile @landingpagemobile @headerfootermobile
  Scenario Outline: - To validate mobile landing Page in Plan Recommendation Engine
    Given the user is on UHC medicare acquisition site landing page mobile
      | Device Name | <DeviceName> |
    When user validate presence of Header and Footer elements on landing page mobile

    Examples: 
      | DeviceName |
      | iphonex    |
      #| Samsung s9|
      #| S8|
      #|Samsung|
      #|galaxy|
      #|Nokia 7.2|
