@claims @thePredetors
Feature: 1.12.2 Member Rally claims - Member Auth

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | ClaimsMicroApp |

  #----- beginning of Non Regression claims scenarios section ------------------------
  # note: if run on team env, the click MyClaims and landing on Rally Claims page will be skipped
  @nonReg_rallyClaims01 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate the MEDICAL/SHIP claims Summary and details page E2E Scenario
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <username> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then the user navigates to EOB page
    Then the user validate MyClaims top menu sub option
    Then the user click MyClaims top menu sub option
    Then user validates landing on Rally Claims Page
    
    @memAuth_rallyClaims01_ma
    Examples: 
      | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     |
      | 15234 | qavgogine  | qavgogine | q1_uhc_ma001 | MA       | UHC_Individual      | COSMOS_CLAIMS   |
      | xxxxx | qavgogine  | qavgogine | q3_sep_UAT4_Group289 | MA | UHC_GROUP         | COSMOS_CLAIMS   |

    @memAuth_rallyClaims01_medica_pcp
    Examples: 
      | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     | 
      | 15268 | qavgogine  | qavgogine | q2_jun_sofl0002| PCP    | Individual          | COSMOS_CLAIMS   | 

    @memAuth_rallyClaims01_mapd
    Examples: 
      | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     | 
      | 15230 | qavgogine  | qavgogine | q2_apr_aarp0250 | MAPD  | AARP_Individual     | COSMOS_CLAIMS   | 
      | xxxxx | qavgogine  | qavgogine | Dream_EOB_MAPD_007 | MAPD  | UHC_GROUP        | COSMOS_CLAIMS   | 

    @memAuth_rallyClaims01_ship
    Examples: 
      | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     | 
      | 15236 | qavgogine  | qavgogine | PaidInFullShip0011 | SHIP | Individual       | COMPASS_CLAIMS  | 

    @memAuth_rallyClaims01_pdp
    Examples: 
      | TID   | username   | password  | MemUserName    | planType | memberType        | claimSystem     | 
      | 15299 | qavgogine  | qavgogine | q3_sep_UAT4_AARP057 | PDP | Individual        | RX_CLAIMS       | 
      | 15300 | qavgogine  | qavgogine | q2_jun_grp0070 | PDP      | GROUP             | RX_CLAIMS       | 
  #----- end of Non Regression claims scenarios section ------------------------