Feature: Need Help Phone Numbers on PnP Page
  To validate Need Help Phone Numbers on PnP Page

  @Regression
  Scenario Outline: To verify Need Help sections on PnP Page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    When user navigates to the pharmacies and prescriptions page from testharness page
    Then user validates Need Help section phone numbers
    Then user validates Need Help section hours of operations

    Examples: 
      | username | password | memUserName |
      | yaihemai | Yusufu6$ | Berniewb    |
