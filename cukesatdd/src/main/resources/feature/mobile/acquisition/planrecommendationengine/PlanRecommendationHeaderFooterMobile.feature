@PlanSelectorHeaderFooterMobile
Feature: Plan Selector Tool flow - Verify Header and Footer on medicare mobile page

  @PREmobile @planrecommandonationmobile @headerfootermobile @headerelements
  Scenario: - To validate mobile header elements in medicare page
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page mobile
    Then user validate presence of Header elements on landing page mobile
    
  @PREmobile @planrecommandonationmobile @headerfootermobile @footerelements
  Scenario: - To validate mobile footer elements in medicare page
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page mobile
    Then user validate presence of Footer elements on landing page mobile

  @PREmobile @planrecommandonationmobile @headerfootermobile @headermobilefunctionalities
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

  @PREmobile @planrecommandonationmobile @headerfootermobile @footermobilefunctionalities
  Scenario Outline: - To validate mobile footer functionalities in medicare page
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page mobile
    Then user validate Footer Functionality of Plan Recommendation Engine mobile

  @PREmobile @planrecommandonationmobile @headerfootermobile @headerlinksvalidation
  Scenario: - To validate mobile header links validation in medicare page
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page mobile
    Then user validates all Links from header mobile

@PREmobile @planrecommandonationmobile @headerfootermobile @footerlinksvalidation
  Scenario: - To validate mobile footer links validation in medicare page
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page mobile
    Then user validates all Links from footer mobile