@claims @thePredetors
Feature: 1.12.1 Member Rally claims deeplink - RETIREE

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | ClaimsMicroApp |

  #----- beginning of bookmark or deeplink validation for RETIREE aka GROUP
  @rallyClaims18 @deeplink_retireeGrp
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims overview page bookmark
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.com/retiree/member/claims.html#/overview |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MAPD     | UHC_GROUP           | COSMOS_CLAIMS   | 

  @rallyClaims19 @deeplink_retireeGrp
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims detail page bookmark
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.comretiree/member/claims.html#/details |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MAPD     | UHC_GROUP           | COSMOS_CLAIMS   | 

  @rallyClaims20 @deeplink_retireeGrp
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims overview page deeplink
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.com/?TARGET=SMSR/member/claims.html%3fdeeplink=true#/overview |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MAPD     | UHC_GROUP           | COSMOS_CLAIMS   | 

  @rallyClaims21 @deeplink_retireeGrp
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - https://www.stage-medicare.uhc.com/?TARGET=SMSR/member/claims.html%3fdeeplink=true#/details
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.com/?TARGET=SMSR/member/claims.html%3fdeeplink=true#/details |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MAPD     | UHC_GROUP           | COSMOS_CLAIMS   | 
  #----- end of bookmark or deeplink validation for RETIREE aka GROUP