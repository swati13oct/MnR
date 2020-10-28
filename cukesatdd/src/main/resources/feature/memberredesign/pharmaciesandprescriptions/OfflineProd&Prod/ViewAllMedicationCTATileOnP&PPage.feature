Feature: View All Medication CTA Tile on P&P page
  To validate View All Medication CTA Tile on P&P page

  @Sanity @Regression
  Scenario Outline: To verify View All Medication CTA Tile position,Image,Title,Description on P&P page and Redirection to My Medication Page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user view MedCab load successfully on PnP page
    Then user view View All Medication Call To Action
    Then user validates the View All Medication text content displayed third within that section
    Then user validates an image for View All Medication Call To Action
    Then user validates a title for View All Medication Call To Action
    Then user validates a description for View All Medication Call To Action
    And user clicks on View All Medication call to action displayed Third within that section
    Then user will be directed to My Medications page

    Examples: 
      | username | password | memUserName |
      | kjadha10 | Free@123 | Berniewb    |
