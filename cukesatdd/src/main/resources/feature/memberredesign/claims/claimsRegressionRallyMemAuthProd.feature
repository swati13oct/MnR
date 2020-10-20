@claims @thePredetors
Feature: 1.12.2 Member Rally claims - Member Auth - PROD

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | ClaimsMicroApp |

  #----- beginning of Regression claims scenarios section ------------------------
  # note: if run on team env, the click MyClaims and landing on Rally Claims page will be skipped
  @nonReg_rallyClaims01 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate navigation onto MyClaims page
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
    
    @prod_rallyClaims01_ma
    Examples: 
      | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     |
      | 15234 | kkumard   | mnrs786@  | haradaty32   | MA       | UHC_Individual      | COSMOS_CLAIMS   |
      | xxxxx | kkumard   | mnrs786@  | BNCSAUVE2    | MA       | UHC_GROUP           | COSMOS_CLAIMS   |
      
   @claims_prodsanityMA_Group
     Examples: 
      | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     |
      | xxxxx | kkumard   | mnrs786@  | BNCSAUVE2    | MA       | UHC_GROUP           | COSMOS_CLAIMS   | 
   

    @prod_rallyClaims01_medica_pcp @claims_prodsanityPcp
    Examples: 
      | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     | 
      | 15268 | kkumard   | mnrs786@  | BATLLOT@AOL.COM | PCP   | Individual          | COSMOS_CLAIMS   | 

    @prod_rallyClaims01_mapd
    Examples: 
      | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     | 
      | 15230 | kkumard   | mnrs786@  | BILL.ROSNER123# | MAPD  | AARP_Individual     | COSMOS_CLAIMS   | 
      | xxxxx | kkumard   | mnrs786@  | Andersonga1@Bellsouth.Net | MAPD  | UHC_GROUP | COSMOS_CLAIMS   | 
      
   @claims_prodsanityMapd_Individual
     Examples:   
       | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     | 
      | 15230 | kkumard   | mnrs786@  | BILL.ROSNER123# | MAPD  | AARP_Individual     | COSMOS_CLAIMS   |

    @prod_rallyClaims01_ship @claims_prodsanityShip
    Examples: 
      | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     | 
      | 15236 | kkumard   | mnrs786@  | vernajohnson19651  | SHIP     | Individual          | COMPASS_CLAIMS  | 

    @prod_rallyClaims01_pdp
    Examples: 
      | TID   | username   | password  | MemUserName  | planType | memberType          | claimSystem     | 
      | 15299 | kkumard   | mnrs786@  | nawal1215    | PDP      | Individual          | RX_CLAIMS       | 
      | 15300 | kkumard   | mnrs786@  | MON48DA      | PDP      | GROUP               | RX_CLAIMS       | 
  #----- end of Non Regression claims scenarios section ------------------------