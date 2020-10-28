Feature: Drug Name and Get Pricing
  To validate Drug Name and Get Pricing

  @Sanity @Regression
  Scenario Outline: To verify user has access to Drug Name and Get Pricing
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user views the Current Medications
    When user clicks on the name of a drug
    Then user views the Prices page for that medication
    When user clicks on the back button
    Then user views the Current Medications
    When user select the Get Pricing button on a drug card
    Then user views the Prices page for that medication

    Examples: 
      | username | password | memUserName |
      | kjadha10 | Free@123 | Berniewb    |
