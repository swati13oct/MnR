@claims @thePredetors
Feature: 1.12.2 Member Rally claims deeplink - Federal AARP and SHIP

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | ClaimsMicroApp |

  #----- beginning of bookmark or deeplink validation for Fed-AARP INDIVIDUAL and Ship
  @rallyClaims02a @deeplink_fedAarpIndAndShip
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - PreAuthorization - To validate using old claims overview page bookmark without hastag to reach Rally Claims page
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.com/aarp/member/claims.html |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MAPD     | AARP_Individual     | COSMOS_CLAIMS   | 
      | xxxxx | SHIP     | Individual          | COMPASS_CLAIMS  | 

  @rallyClaims02b @deeplink_fedAarpIndAndShip
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - PreAuthorization - To validate using old claims overview page bookmark to reach Rally Claims page
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.com/aarp/member/claims.html#/overview |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MAPD     | AARP_Individual     | COSMOS_CLAIMS   | 
      | xxxxx | SHIP     | Individual          | COMPASS_CLAIMS  | 

  @rallyClaims02c @deeplink_fedAarpIndAndShip
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - PreAuthorization - To validate using old claims detail page bookmark to reach Rally Claims page
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.com/aarp/member/claims.html#/details |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MAPD     | AARP_Individual     | COSMOS_CLAIMS   | 
      | xxxxx | SHIP     | Individual          | COMPASS_CLAIMS  | 

  @rallyClaims02d @deeplink_fedAarpIndAndShip
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - PostAuthorization - To validate using old claims overview page bookmark  without hastag to reach Rally Claims page
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    Then the user navigates to EOB page
    Then user invokes bookmark URL
      | Deeplink     | https://www.stage-medicare.uhc.com/aarp/member/claims.html |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MAPD     | AARP_Individual     | COSMOS_CLAIMS   | 
      | xxxxx | SHIP     | Individual          | COMPASS_CLAIMS  | 

  @rallyClaims02e @deeplink_fedAarpIndAndShip
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - PostAuthorization - To validate using old claims overview page bookmark to reach Rally Claims page
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    Then the user navigates to EOB page
    Then user invokes bookmark URL
      | Deeplink     | https://www.stage-medicare.uhc.com/aarp/member/claims.html#/overview |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MAPD     | AARP_Individual     | COSMOS_CLAIMS   | 
      | xxxxx | SHIP     | Individual          | COMPASS_CLAIMS  | 

  @rallyClaims02f @deeplink_fedAarpIndAndShip
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - PostAuthorization - To validate using old claims detail page bookmark to reach Rally Claims page
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    Then the user navigates to EOB page
    Then user invokes bookmark URL
      | Deeplink     | https://www.stage-medicare.uhc.com/aarp/member/claims.html#/details |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MAPD     | AARP_Individual     | COSMOS_CLAIMS   | 
      | xxxxx | SHIP     | Individual          | COMPASS_CLAIMS  | 

  ##### note: deeplink related to SMSR is out of scope for now
  #Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims overview page deeplink
  #  Given login with a deeplink in the member portal and validate elements
  #    | Plan Type    | <planType>    |
  #    | Member Type  | <memberType>  |
  #    | Claim System | <claimSystem> |
  #    | Deeplink     | https://www.stage-medicare.uhc.com/?TARGET=SMSR/member/claims.html%3fdeeplink=true#/overview |
  #  Then user validates landing on Rally Claims Page
  #
  #  Examples: 
  #    | TID   | planType | memberType          | claimSystem     |         
  #    | xxxxx | MAPD     | AARP_Individual     | COSMOS_CLAIMS   | 
  #    | xxxxx | SHIP     | Individual          | COMPASS_CLAIMS  | 
  #
  #Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims detail page deeplink
  #  Given login with a deeplink in the member portal and validate elements
  #    | Plan Type    | <planType>    |
  #    | Member Type  | <memberType>  |
  #    | Claim System | <claimSystem> |
  #    | Deeplink     | https://www.stage-medicare.uhc.com/?TARGET=SMSR/member/claims.html%3fdeeplink=true#/details |
  #  Then user validates landing on Rally Claims Page
  #
  #  Examples: 
  #    | TID   | planType | memberType          | claimSystem     |         
  #    | xxxxx | MAPD     | AARP_Individual     | COSMOS_CLAIMS   | 
  #    | xxxxx | SHIP     | Individual          | COMPASS_CLAIMS  | 
  #----- end of bookmark or deeplink validation for Fed-AARP INDIVIDUAL and Ship
