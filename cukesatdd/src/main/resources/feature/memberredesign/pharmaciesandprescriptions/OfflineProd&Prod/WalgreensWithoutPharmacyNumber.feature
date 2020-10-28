Feature: Walgreen without Pharmacy Number (Contact Pharmacy)
  To validate Walgreen without Pharmacy Number

  @Regression
  Scenario Outline: To verify Walgreen without Pharmacy Number has Contact Pharmacy
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    When user has a Walgreens drug without store numbers
    Then user sees the contact pharmacy button if it has no store number

    Examples: 
      | username | password | memUserName |
      | yaihemai | Yusufu6$ | Berniewb    |
