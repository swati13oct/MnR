Feature: Drug Lookup CTA Tile on P&P page
  To validate Drug lookup CTA Tile on P&P page

  @Sanity @Regression
  Scenario Outline: To verify Drug Lookup CTA Tile position,Image,Title,Description on P&P page and Redirection to Rally Page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | kjadha10 |
      | Password | Free@123 |
    And Member Enters the Username he wants to search
      | Member   |
      | Berniewb |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user view Drug Lookup Call To Action
    Then user validates the Drug Lookup text content displayed first within that section
    Then user validates an image for Drug Lookup Call To Action
    Then user validates a title for Drug Lookup Call To Action
    Then user validates a description for Drug Lookup Call To Action
    When user clicks on Drug Lookup a Medication Call To Action
    Then user will be directed to the Drug Estimator tool developed by Rally in the same window
