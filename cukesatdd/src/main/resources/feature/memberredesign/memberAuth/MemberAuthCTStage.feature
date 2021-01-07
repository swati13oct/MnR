Feature: S1.1 To test Member Auth Sign for SSO Micro App.

 Background: Feature security flag needs to be true before ATDD script execution
     Given First check if feature security flag is set to true
      | Feature | UCPSSOMemberAuth |
###############################Regression Scenarios Begin Here ########################################

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
      | qavgogine | qavgogine | q3_sep_UAT4_MAPD_009                 | Scenario 1:  Search with member username : Federal Member- NICE |
      | qavgogine | qavgogine | q4_Ship_ANOC_010                     | Scenario 2a: Search using username – SHIP Member                |
      | qavgogine | qavgogine | q3_Sep_UAT4_Sofl022                  | Scenario 3: Search using username – PCP/Medica Member           |
      | qavgogine | qavgogine | q2_jun_aarp0065                      | Scenario 4: Search using username – Terminated<12               |
      | qavgogine | qavgogine | PreeffectiveFEDMA_001                | Scenario 5: Search using username – Pre-effective               |
      | qavgogine | qavgogine | e446b48e-5f7b-4dce-a3c0-c1deac349f8c | Scenario 6: Search using username – UUID                        |
      # commenting legacy name as not a valid scenario 1/7/2021 error will be observed |
      #| qavgogine | qavgogine | legacyid001                          | Scenario 7: Search using legacy username                        |

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
    And I click on logout and validate the login page

    Examples: 
      | username  | password  | memberid    | month | day | year | Scenario                                                             |
      | qavgogine | qavgogine | 928908861-1 |    02 |  28 | 1962 | Scenario 2b: Search using member id and DOB – Fedral Member - COSMOS |
      | qavgogine | qavgogine | 006727987-1 |    05 |  27 | 1941 | Scenario 2c: Search using member id and DOB – COMBO Member           |
      | qavgogine | qavgogine | 917514052-1 |    10 |  13 | 1931 | Scenario 2d: Search using legacy user member id and DOB              |
   
