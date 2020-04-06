@claims @thePredetors
Feature: 1.12.5 Member Rally claims deeplink - UHC Individual

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on stage env
      | Feature           | ClaimsMicroApp |

  #----- beginning of bookmark or deeplink validation for UHC INDIVIDUAL
  @rallyClaims14 @deeplink_uhcInd
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims overview page bookmark
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.com/medicare/member/claims.html#/overview |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MA       | UHC_Individual      | COSMOS_CLAIMS   |

  @rallyClaims15 @deeplink_uhcInd
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims detail page bookmark
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.com/medicare/member/claims.html#/details |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MA       | UHC_Individual      | COSMOS_CLAIMS   |

  @rallyClaims16 @deeplink_uhcInd
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims overview page deeplink
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.com/?TARGET=SMSR/member/claims.html%3fdeeplink=true#/overview |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MA       | UHC_Individual      | COSMOS_CLAIMS   |

  @rallyClaims17 @deeplink_uhcInd
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the Rally Claims page via old claims detail page deeplink
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.com/?TARGET=SMSR/member/claims.html%3fdeeplink=true#/details |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MA       | UHC_Individual      | COSMOS_CLAIMS   |
  #----- end of bookmark or deeplink validation for UHC INDIVIDUAL