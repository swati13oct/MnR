@PlanSelectorHeaderFooterMobile
Feature: Plan Selector Tool flow - Verify Header and Footer on medicare mobile page

  @PREmobile @planrecommandonationmobile @headerfootermobile @headerfooterelements
  Scenario Outline: - To validate mobile header and footer in medicare page
    Given the user is on UHC medicare acquisition site mobile
      | Device Name | <DeviceName> |
    When user navigates to PRE landing page mobile
    Then user validate presence of Header and Footer elements on landing page mobile

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
  @PREmobile @planrecommandonationmobile @headerfootermobile @headerfootermobilefunctionalities
  Scenario Outline: - To validate mobile header and footer in medicare page
    Given the user is on UHC medicare acquisition site mobile
      | Device Name | <DeviceName> |
      | Zip Code    | <Zipcode>    |
      | EMail       | <EMail>      |
      | Search Key  | <SearchKey>  |
    When user navigates to PRE landing page via shop tool mobile
    Then user validate Header and Footer Functionality of Plan Recommendation Engine mobile

    Examples: 
      | DeviceName |  | Zipcode | EMail          | SearchKey                |
      | Samsung s9 |  |   90201 | abc@domain.com | plan for recommandations |

  @PREmobile @planrecommandonationmobile @headerfootermobile @headerfooterlinksvalidation
  Scenario Outline: - To validate mobile header and footer in medicare page
    Given the user is on UHC medicare acquisition site mobile
      | Device Name | <DeviceName> |
    When user navigates to PRE landing page mobile
    Then user validates all Links from header and footer mobile

    Examples: 
      | DeviceName |
      | Samsung s9 |
