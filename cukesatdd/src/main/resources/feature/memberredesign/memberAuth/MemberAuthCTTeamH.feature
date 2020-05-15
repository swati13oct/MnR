@regressionMember
Feature: S1.1 To test Member Auth SSO Micro App.

  @regressionMember
  Scenario Outline: Scenario: <Scenario> - Test Case_To test single signon using member auth - Search with Username
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select

    Examples: 
      | username | password | member                               | Scenario                                                        |
      | jkuma14  | Brock@01 | Auto20191121091814_4                 | Scenario 1:  Search with member username : Federal Member- NICE |
      | jkuma14  | Brock@01 | Q1_feb_2020SHIP_001                  | Scenario 2a: Search using username – SHIP Member                |
      | jkuma14  | Brock@01 | q3_Sep_UAT4_Sofl022                  | Scenario 3: Search using username – PCP/Medica Member           |
      | jkuma14  | Brock@01 | q2_jun_aarp0065                      | Scenario 4: Search using username – Terminated<12               |
      | jkuma14  | Brock@01 | PreeffectiveFEDMA_001                | Scenario 5: Search using username – Pre-effective               |
      | jkuma14  | Brock@01 | 2e9f4a8f-c2e0-4de2-b5ad-330bc63232b7 | Scenario 6: Search using username – UUID                        |
      | jkuma14  | Brock@01 | legacyid001                          | Scenario 7: Search using legacy username                        |

  @regressionMember
  Scenario Outline: Scenario: <Scenario> - Test Case_To test single signon using member auth - Search using memberid and dob
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the memberid and dob he wants to search
      | Member ID | <memberid> |
      | Month     | <month>    |
      | Day       | <day>      |
      | Year      | <year>     |
    And user clicks on member to select

    Examples: 
      | username | password | memberid    | month | day | year | Scenario                                                             |
      | jkuma14  | Brock@01 | 928908861-1 |    02 |  28 | 1962 | Scenario 2b: Search using member id and DOB – Fedral Member - COSMOS |
      | jkuma14  | Brock@01 | 001893654-1 |    04 |  06 | 1940 | Scenario 2c: Search using member id and DOB – COMBO Member           |
      | jkuma14  | Brock@01 | 917514052-1 |    10 |  13 | 1931 | Scenario 2d: Search using legacy user member id and DOB              |
