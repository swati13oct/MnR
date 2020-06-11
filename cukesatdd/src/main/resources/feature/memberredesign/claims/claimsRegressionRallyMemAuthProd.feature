@claims @thePredetors
Feature: 1.12.2 Member Rally claims - Member Auth - PROD

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
    
    @prod_rallyClaims01a
    Examples: 
      | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     |
      | 15234 | ashah120   | Mnrqa002  | haradaty32   | MA       | UHC_Individual      | COSMOS_CLAIMS   |
      | xxxxx | ashah120   | Mnrqa002  | 1GIRL4DEAN   | MA       | UHC_GROUP           | COSMOS_CLAIMS   |

    @prod_rallyClaims01b
    Examples: 
      | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     | 
      | 15268 | ashah120   | Mnrqa002  | BATLLOT@AOL.COM | PCP   | Individual          | COSMOS_CLAIMS   | 

    @prod_rallyClaims01c
    Examples: 
      | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     | 
      | 15230 | ashah120   | Mnrqa002  | BILL.ROSNER123# | MAPD  | AARP_Individual     | COSMOS_CLAIMS   | 

    @prod_rallyClaims01d
    Examples: 
      | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     | 
      | xxxxx | ashah120   | Mnrqa002  | Andersonga1@Bellsouth.Net | MAPD  | UHC_GROUP | COSMOS_CLAIMS   | 
      | 15236 | ashah120   | Mnrqa002  | Pramila1946  | SHIP     | Individual          | COMPASS_CLAIMS  | 

    @prod_rallyClaims01e
    Examples: 
      | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     | 
      | 15299 | ashah120   | Mnrqa002  | nawal1215    | PDP      | Individual          | RX_CLAIMS       | 
      | 15300 | ashah120   | Mnrqa002  | MON48DA      | PDP      | GROUP               | RX_CLAIMS       | 
  #----- end of Non Regression claims scenarios section ------------------------