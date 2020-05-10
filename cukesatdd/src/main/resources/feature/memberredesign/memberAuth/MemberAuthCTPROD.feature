@regressionMember
Feature: S1.1 To test Member Auth SSO Micro App.

  @regressionMemberPROD
  Scenario Outline: TC01_To test single signon using member auth - Search with Username
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select

    Examples: 
      | username | password | member                               | Scenario                                                        |
      | jkuma14  | Brock@02 | skho@roadrunner.com                  | Scenario 1:  Search with member username : Federal Member- NICE |
      | jkuma14  | Brock@02 | Pramila1946                          | Scenario 2a: Search using username – SHIP Member                |
      | jkuma14  | Brock@02 | marylamb823                          | Scenario 3: Search using username – PCP Plan Member             |
      | jkuma14  | Brock@02 | SUSICHAPMAN@GMAIL.COM                | Scenario 4: Search using username – Medica Plan Member          |
      | jkuma14  | Brock@02 | erbenoit56                           | Scenario 5: Search using username – Terminated<12               |
      | jkuma14  | Brock@02 | Ralltj                               | Scenario 6: Search using username – Pre-effective               |
      | jkuma14  | Brock@02 | 6b8691ed-7b30-4673-9dd6-54a8acc66129 | Scenario 7: Search using username – UUID                        |
      | jkuma14  | Brock@02 | sandrakaye86                         | Scenario 8: Search using legacy username                        |

  @regressionMemberPROD
  Scenario Outline: TC02_To test single signon using member auth - Search using memberid and dob
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
      | username | password | memberid     | month | day | year | Scenario                                                             |
      | jkuma14  | Brock@02 | 970530542-1  |    01 |  28 | 1952 | Scenario 2b: Search using member id and DOB – Fedral Member - COSMOS |
      | jkuma14  | Brock@02 | 063246454-11 |    07 |  07 | 1949 | Scenario 2c: Search using member id and DOB – COMBO Member           |
      | jkuma14  | Brock@02 | 307825058-11 |    10 |  20 | 1917 | Scenario 2d: Search using legacy user member id and DOB              |
