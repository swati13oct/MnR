Feature: Pharmacy Locator CTA Tile on P&P page
  To validate Pharmacy Locator CTA Tile on P&P page

  @Sanity @Regression
  Scenario Outline: To verify Pharamcy Locator CTA Tile position,Image,Title,Description on P&P page and Redirection to Pharmacy Locator Page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | kjadha10 |
      | Password | Free@123 |
    And Member Enters the Username he wants to search
      | Member   |
      | Berniewb |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Pharmacy Locator Call To Action
    Then user validates the Pharmacy Locator text content displayed second within that section
    Then user validates an image for Pharmacy Locator Call To Action
    Then user validates a title for Pharmacy Locator Call To Action
    Then user validates a description for Pharmacy Locator Call To Action
    And user clicks on Pharmacy Locator call to action displayed second within that section
    Then user will be directed to the Choose a plan year page