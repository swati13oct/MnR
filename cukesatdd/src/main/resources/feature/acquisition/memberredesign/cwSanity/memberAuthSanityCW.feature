Feature: S1.1 To test Member Auth Sign for Sanity check.

  @regressionMember
  Scenario Outline: Scenario: <Scenario> - Test Case_To test single signon using member auth - Search with Username
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And I click on logout and validate the login page

    Examples: 
      | username  | password  | member                               | Scenario                                                        |
      | qavgogine | qavgogine | Auto20191121091814_4                 | Scenario 1:  Search with member username : Federal Member- NICE |
      | qavgogine | qavgogine | Q1_feb_2020SHIP_001                  | Scenario 2a: Search using username – SHIP Member                |