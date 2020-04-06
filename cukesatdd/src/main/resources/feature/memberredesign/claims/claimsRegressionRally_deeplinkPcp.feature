@claims @thePredetors
Feature: 1.12.4 Member Rally claims  deeplink - PCP

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | ClaimsMicroApp |

  #----- beginning of bookmark or deeplink validation for PCP
  @rallyClaims10 @deeplink_pcp
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims overview page bookmark
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://stage-mymedicareaccount.uhc.com/pcp/member/claims.html |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | PCP      | Individual          | COSMOS_CLAIMS   | 

  @rallyClaims11 @deeplink_pcp
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims detail page bookmark
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://stage-mymedicareaccount.uhc.com/pcp/member/claims.html#/details |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | PCP      | Individual          | COSMOS_CLAIMS   | 

  @rallyClaims12 @deeplink_pcp
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims overview page deeplink
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://stage-mymedicareaccount.uhc.com/?TARGET=SMSR/member/claims.html%3fdeeplink=true#/overview |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | PCP      | Individual          | COSMOS_CLAIMS   | 

  @rallyClaims13 @deeplink_pcp
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims detail page deeplink
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://stage-mymedicareaccount.uhc.com/?TARGET=SMSR/member/claims.html%3fdeeplink=true#/details |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | PCP      | Individual          | COSMOS_CLAIMS   | 
  #----- end of bookmark or deeplink validation for PCP