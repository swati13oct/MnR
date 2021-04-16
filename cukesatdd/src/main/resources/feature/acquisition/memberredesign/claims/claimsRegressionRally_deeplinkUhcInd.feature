@claims @thePredetors
Feature: 1.12.5 Member Rally claims deeplink - UHC Individual

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on test env
      | Feature           | ClaimsMicroApp |

  #----- beginning of bookmark or deeplink validation for UHC INDIVIDUAL
  @rallyClaims06a @deeplink_uhcInd @preAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - PreAuthorization - To validate using old claims overview page bookmark without hastag to reach Rally Claims page
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.com/medicare/member/claims.html |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MA       | UHC_Individual      | COSMOS_CLAIMS   |

  @rallyClaims06b @deeplink_uhcInd @preAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - PreAuthorization - To validate using old claims overview page bookmark to reach Rally Claims page
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.com/medicare/member/claims.html#/overview |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MA       | UHC_Individual      | COSMOS_CLAIMS   |

  @rallyClaims06c @deeplink_uhcInd @preAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - PreAuthorization - To validate using old claims detail page bookmark to reach Rally Claims page
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
      | Deeplink     | https://www.stage-medicare.uhc.com/medicare/member/claims.html#/details |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MA       | UHC_Individual      | COSMOS_CLAIMS   |

  @rallyClaims06d @deeplink_uhcInd @postAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - PostAuthorization - To validate using old claims overview page bookmark without hastag to reach Rally Claims page
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    Then the user navigates to EOB page
    Then user invokes bookmark URL
      | Deeplink     | https://www.stage-medicare.uhc.com/medicare/member/claims.html |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MA       | UHC_Individual      | COSMOS_CLAIMS   |

  @rallyClaims06e @deeplink_uhcInd @postAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - PostAuthorization - To validate using old claims overview page bookmark to reach Rally Claims page
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    Then the user navigates to EOB page
    Then user invokes bookmark URL
      | Deeplink     | https://www.stage-medicare.uhc.com/medicare/member/claims.html#/overview |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MA       | UHC_Individual      | COSMOS_CLAIMS   |

  @rallyClaims06f @deeplink_uhcInd @postAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - PostAuthorization - To validate using old claims detail page bookmark to reach Rally Claims page
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    Then the user navigates to EOB page
    Then user invokes bookmark URL
      | Deeplink     | https://www.stage-medicare.uhc.com/medicare/member/claims.html#/details |
    Then user validates landing on Rally Claims Page

    Examples: 
      | TID   | planType | memberType          | claimSystem     |         
      | xxxxx | MA       | UHC_Individual      | COSMOS_CLAIMS   |


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
  #    | xxxxx | MA       | UHC_Individual      | COSMOS_CLAIMS   |
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
  #    | xxxxx | MA       | UHC_Individual      | COSMOS_CLAIMS   |
  #----- end of bookmark or deeplink validation for UHC INDIVIDUAL