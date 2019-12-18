@PlanSelectorHeaderFooterMobile
Feature: Plan Selector Tool flow - Verify Header and Footer on medicare mobile page

  @PREmobile @planrecommandonationmobile @headerfootermobile @headerfooterelements
  Scenario: - To validate mobile header and footer in medicare page
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page mobile
    Then user validate presence of Header and Footer elements on landing page mobile

  @PREmobile @planrecommandonationmobile @headerfootermobile @headerfootermobilefunctionalities
  Scenario Outline: - To validate mobile header and footer in medicare page
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page via shop tool mobile
    Then user validate Header and Footer Functionality of Plan Recommendation Engine mobile
      | Zip Code   | <Zipcode>   |
      | EMail      | <EMail>     |
      | Search Key | <SearchKey> |

    Examples: 
      | Zipcode | EMail          | SearchKey                |
      |   90201 | abc@domain.com | plan for recommandations |

  @PREmobile @planrecommandonationmobile @headerfootermobile @headerfooterlinksvalidation
  Scenario: - To validate mobile header and footer in medicare page
    Given the user is on UHC medicare acquisition site mobile
    When user navigates to PRE landing page mobile
    Then user validates all Links from header and footer mobile
