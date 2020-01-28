@PlanRecommandonationEngineMobile
Feature: Plan Selector Tool flow - Verify Header and Footer in plan recommendation engine using mobile

  @PREm @planrecommandonationmobile @headerfootermobile @headerelements @F383639
  Scenario: - To validate mobile header elements in medicare page
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page mobile
    Then user validate presence of Header elements on landing page mobile
    
  @PRE @planrecommandonationmobile @headerfootermobile @footerelements @F383639
  Scenario: - To validate mobile footer elements in medicare page
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page mobile
    Then user validate presence of Footer elements on landing page mobile

  @PRE @planrecommandonationmobile @headerfootermobile @headermobilefunctionalities @F383639
  Scenario Outline: - To validate mobile header functionalities in medicare page
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page mobile
    Then user validate Header Functionality of Plan Recommendation Engine mobile
      | Zip Code   | <Zipcode>   |
      | EMail      | <EMail>     |
      | Search Key | <SearchKey> |

    Examples: 
      | Zipcode | EMail          | SearchKey                |
      |   90201 | abc@domain.com | plan for recommandations |

  @PRE @planrecommandonationmobile @headerfootermobile @footermobilefunctionalities @F383639
  Scenario: - To validate mobile footer functionalities in medicare page
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page mobile
    Then user validate Footer Functionality of Plan Recommendation Engine mobile

  @PRE @planrecommandonationmobile @headerfootermobile @headerlinksvalidation @F383639
  Scenario: - To validate mobile header links in medicare page
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page mobile
    Then user validates all Links from header mobile

@PRE @planrecommandonationmobile @headerfootermobile @footerlinksvalidation @F383639
  Scenario: - To validate mobile footer links in medicare page
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page mobile
    Then user validates all Links from footer mobile