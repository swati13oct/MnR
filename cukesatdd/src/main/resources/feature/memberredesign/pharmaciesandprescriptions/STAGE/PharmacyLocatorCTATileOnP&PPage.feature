Feature: Pharmacy Locator CTA Tile on P&P page
  To validate Pharmacy Locator CTA Tile on P&P page

  @STAGERegression
  Scenario Outline: To verify Pharamcy Locator CTA Tile position,Image,Title,Description on P&P page and Redirection to Pharmacy Locator Page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Pharmacy Locator Call To Action
    Then user validates an image for Pharmacy Locator Call To Action
    Then user validates a title for Pharmacy Locator Call To Action
    Then user validates a description for Pharmacy Locator Call To Action
    And user clicks on Pharmacy Locator call to action displayed second within that section
    Then user will be directed to the Choose a plan year page

    Examples:
      | planType | memberType             |
      | PDP     | Rx_Refill_AutoRefillOff |
