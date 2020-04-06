@claims @thePredetors
Feature: 1.12.2 Member Rally claims deeplink - Federal AARP and SHIP

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | ClaimsMicroApp |

  #----- beginning of bookmark or deeplink validation for Fed-AARP INDIVIDUAL and Ship
  @rallyClaims02 @deeplink_fedAarpIndAndShip
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims overview page bookmark
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

  @rallyClaims03 @deeplink_fedAarpIndAndShip
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims detail page bookmark
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

  @rallyClaims04 @deeplink_fedAarpIndAndShip
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims overview page deeplink
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.com/?TARGET=SMSR/member/claims.html%3fdeeplink=true#/overview |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MAPD     | AARP_Individual     | COSMOS_CLAIMS   | 
      | xxxxx | SHIP     | Individual          | COMPASS_CLAIMS  | 

  @rallyClaims05 @deeplink_fedAarpIndAndShip
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims detail page deeplink
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.com/?TARGET=SMSR/member/claims.html%3fdeeplink=true#/details |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MAPD     | AARP_Individual     | COSMOS_CLAIMS   | 
      | xxxxx | SHIP     | Individual          | COMPASS_CLAIMS  | 
  #----- end of bookmark or deeplink validation for Fed-AARP INDIVIDUAL and Ship
