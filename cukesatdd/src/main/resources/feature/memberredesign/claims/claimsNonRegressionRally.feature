@claims @thePredetors
Feature: 1.12.3 Member Rally claims - Non Regression

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
    
    @nonReg_rallyClaims01a
    Examples: 
      | TID   | username   | password   | MemUserName  | planType | memberType          | claimSystem     |
      | 15234 | myUsername | myPassword | testUsername | MA       | UHC_Individual      | COSMOS_CLAIMS   |
      | xxxxx | myUsername | myPassword | testUsername | MA       | UHC_GROUP           | COSMOS_CLAIMS   |

    @nonReg_rallyClaims01b
    Examples: 
      | TID   | username   | password   | MemUserName  | planType | memberType          | claimSystem     | 
      | 15268 | myUsername | myPassword | testUsername | PCP      | Individual          | COSMOS_CLAIMS   | 

    @nonReg_rallyClaims01c @devRegression
    Examples: 
      | TID   | username   | password   | MemUserName  | planType | memberType          | claimSystem     | 
      | 15230 | myUsername | myPassword | testUsername | MAPD     | AARP_Individual     | COSMOS_CLAIMS   | 

    @nonReg_rallyClaims01c
    Examples: 
      | TID   | username   | password   | MemUserName  | planType | memberType          | claimSystem     | 
      | xxxxx | myUsername | myPassword | testUsername | MAPD     | UHC_GROUP           | COSMOS_CLAIMS   | 

    @nonReg_rallyClaims01d @devRegression
    Examples: 
      | TID   | username   | password   | MemUserName  | planType | memberType          | claimSystem     | 
      | 15236 | myUsername | myPassword | testUsername | SHIP     | Individual          | COMPASS_CLAIMS  | 

    @nonReg_rallyClaims01e
    Examples: 
      | TID   | username   | password   | MemUserName  | planType | memberType          | claimSystem     | 
      | 15299 | myUsername | myPassword | testUsername | PDP      | Individual          | RX_CLAIMS       | 
      | 15300 | myUsername | myPassword | testUsername | PDP      | GROUP               | RX_CLAIMS       | 
  #----- end of Non Regression claims scenarios section ------------------------