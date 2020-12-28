@healthAndWellness @regressionMember
Feature: 1.09 Member Health and Wellness Page

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on test env
      | Feature           | UCPHealthWellness |
      
  #----- beginning of sanity ------------------
  #note: look for scenarios w/ sanity tag
  
  #----- beginning of test for regression------------------
  @healthAndWellness01  @regressiongenericpagesH&W @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - As an authenticated member on the new Member site, I want to validate health and wellness page content
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And I navigate to the Health and Wellness page
    And I should see the H&W Generic dashboard
    And I should see GET REWARD tile if available and be able to click it
      | Has Reward   | <hasReward>   |
    And I should see RENEW ACTIVE tile if available and be able to click it
      | Has RenewActive | <hasRenewActive>   |
      
    @devRegression @healthAndWellness01_ma_mapd @sanity
    Examples: 
      | TID   | planType | memberType        | hasReward | hasRenewActive |
      | 15340 | MAPD     | RewardsMember     | true      | true           |

    @healthAndWellness01_ma_mapd
    Examples: 
      | TID   | planType | memberType        | hasReward | hasRenewActive |
      | 15341 | MA       | AARP_RewardsMember| true      | true           |
      | 15341 | MA       | UHC_RewardsMember | true      | true           |

    @healthAndWellness01_pdp_ship
    Examples: 
      | TID   | planType | memberType        | hasReward | hasRenewActive |
      | 15342 | PDP      | RewardsMember     | false     | false          |

    @healthAndWellness01_pdp_ship @sanity
    Examples: 
      | TID   | planType | memberType        | hasReward | hasRenewActive |
      | xxxxx | SHIP     | RewardsMember     | false     | false          |

    @healthAndWellness01_fedShipCombo_shipFedCombo
    Examples: 
      | TID   | planType          | memberType        | hasReward | hasRenewActive |
      | 15343 | FED_SHIP_COMBO    | RewardsMember     | false     | false          |
      | 15343 | SHIP_FED_COMBO    | RewardsMember     | true      | true           |
 
  @healthAndWellness02_uhcDeeplink
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - As an authenticated UHC member on the new Member site, I want to validate health and wellness page content via UHC deeplink
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Deeplink     | https://stage-myuhcmedicare.uhc.com/rewards/program-overview?utm_campaign=website&utm_source=sendgrid.com&utm_medium=email |
    And I navigate to the Health and Wellness page from Rally
    And I should see the H&W Generic dashboard
    And I should see GET REWARD tile if available and be able to click it
      | Has Reward   | <hasReward>   |
    And I should see RENEW ACTIVE tile if available and be able to click it
      | Has RenewActive | <hasRenewActive>   |

    Examples: 
      | TID   | planType  | memberType        | hasReward | hasRenewActive |
      | 15341 | MA        | UHC_RewardsMember | true      | true           |
      
  @healthAndWellness03_aarpDeeplink    
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - As an authenticated AARP member on the new Member site, I want to validate health and wellness page content via AARP deeplink
    Given login with a deeplink in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Deeplink     | https://stage-myaarpmedicare.uhc.com/rewards/program-overview?utm_campaign=website&utm_source=sendgrid.com&utm_medium=email |
    And I navigate to the Health and Wellness page from Rally
    And I should see the H&W Generic dashboard
    And I should see GET REWARD tile if available and be able to click it
      | Has Reward   | <hasReward>   |
    And I should see RENEW ACTIVE tile if available and be able to click it
      | Has RenewActive | <hasRenewActive>   |

    Examples: 
      | TID   | planType  | memberType         | hasReward | hasRenewActive |
      | 15341 | MA        | AARP_RewardsMember | true      | true           |