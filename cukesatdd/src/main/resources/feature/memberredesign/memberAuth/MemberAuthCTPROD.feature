Feature: S1.1 To test Member Auth Sign for SSO Micro App.

  @regressionMemberPROD
  Scenario Outline: Scenario -<Scenario> - Test Case_To test single signon using member auth - Search with Username
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select

    Examples: 
      | username | password | member                               | Scenario                                                                        |
      | jkuma14  | Brock@02 | skho@roadrunner.com                  | Scenario 1:  Search with member username : Federal Individual MAPD Member- NICE |
      | jkuma14  | Brock@02 | Pramila1946                          | Scenario 2a: Search using username – SHIP Member                                |
      | jkuma14  | Brock@02 | marylamb823                          | Scenario 3: Search using username – PCP Plan Member                             |
      | jkuma14  | Brock@02 | SUSICHAPMAN@GMAIL.COM                | Scenario 4: Search using username – Medica Plan Member                          |
      | jkuma14  | Brock@02 | erbenoit56                           | Scenario 5: Search using username – Terminated<12                               |
      | jkuma14  | Brock@02 | Insaarp73                            | Scenario 6: Search using username – Pre-effective                               |
      | jkuma14  | Brock@02 | 6b8691ed-7b30-4673-9dd6-54a8acc66129 | Scenario 7: Search using username – UUID                                        |
      | jkuma14  | Brock@02 | sandrakaye86                         | Scenario 8: Search using legacy username                                        |

  @regressionMemberPROD
  Scenario Outline: Scenario - <Scenario> - Test Case_To test single signon using member auth - Search using memberid and dob
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
      | username | password | memberid     | month | day | year | Scenario                                                                   |
      | jkuma14  | Brock@02 | 970530542-1  |    01 |  28 | 1952 | Scenario 2b: Search using member id and DOB – Group MAPD Member-COSMOS     |
      | jkuma14  | Brock@02 | 063246454-11 |    07 |  07 | 1949 | Scenario 2c: Search using member id and DOB – COMBO Member (PDP + MedSupp) |
      | jkuma14  | Brock@02 | 307825058-11 |    10 |  20 | 1917 | Scenario 2d: Search using legacy user member id and DOB                    |

  @memAuthProdOnetimeCreditCardPayment @CodeTransformers
  Scenario Outline: Plan Type: <planType>, Member Type: <memberType> - Verify MakeOne time Payment submission for Credit card
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <memUserName> |
    And user clicks on member to select
    And the user navigates to payments overview page
    And user clicks on Make one time payment on payment overview page
    And user selects other amount and enters "1.00" and selects credit card and click on Next button

    Examples: 
      | UID     | username | password | memUserName | planType | claimPeriod    | dateRange      |
      | F243897 | ashah120 | Mnrqa002 | DSOADY17    | MAPD     | Last 24 months | Last 18 months |
