@claims @thePredetors
Feature: 1.12.1 Member Rally claims

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on test env
  #    | Feature           | ClaimsMicroApp |

  #----- beginning of Regression claims scenarios section ------------------------
  # note: if run on team env, the click MyClaims and landing on Rally Claims page will be skipped
  @rallyClaims01 @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -claimSystem: <claimSystem> - To validate navigation onto MyClaims page
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Claim System | <claimSystem> |
    Then the user navigates to EOB page
    Then the user validate MyClaims top menu sub option
    Then the user click MyClaims top menu sub option
    Then user validates landing on Rally Claims Page
    
    @rallyClaims01_ma @devRegression
    Examples: 
      | TID   | planType | memberType          | claimSystem     |
      | xxxxx | MA       | UHC_GROUP           | COSMOS_CLAIMS   |

	@rallyClaims01_ma   @devRegression         @Stage_Sanity_rallyClaimsMA
    Examples: 
      | TID   | planType | memberType          | claimSystem     |
      | 15234 | MA       | UHC_Individual      | COSMOS_CLAIMS   |
      
    @rallyClaims01_medica_pcp @Stage_Sanity_rallyClaimsPcp
    Examples: 
      | TID   | planType | memberType          | claimSystem     | 
      | 15268 | PCP      | Individual          | COSMOS_CLAIMS   | 

    @rallyClaims01_mapd @devRegression @Stage_Sanity_rallyClaims_MapdIndividual 
    Examples: 
      | TID   | planType | memberType          | claimSystem     | 
      | 15230 | MAPD     | AARP_Individual     | COSMOS_CLAIMS   | 

    @rallyClaims01_mapd @Stage_Sanity_rallyClaims_MapdGroup
    Examples: 
      | TID   | planType | memberType          | claimSystem     | 
      | xxxxx | MAPD     | UHC_GROUP           | COSMOS_CLAIMS   | 

    @rallyClaims01_ship @devRegression @Stage_Sanity_rallyClaims_Ship
    Examples: 
      | TID   | planType | memberType          | claimSystem     | 
      | 15236 | SHIP     | Individual          | COMPASS_CLAIMS  | 

    @rallyClaims01_pdp
    Examples: 
      | TID   | planType | memberType          | claimSystem     | 
      | 15300 | PDP      | GROUP               | RX_CLAIMS       | 
      
     @rallyClaims01_pdp        @Stage_Sanity_rallyClaims_PdpIndividual
    Examples: 
      | TID   | planType | memberType          | claimSystem     | 
      | 15299 | PDP      | Individual          | RX_CLAIMS       | 
  #----- end of Regression claims scenarios section ------------------------