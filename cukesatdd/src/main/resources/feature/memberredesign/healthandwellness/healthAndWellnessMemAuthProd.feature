@healthAndWellness
Feature: 1.09.1 Member Health and Wellness Page - Member Auth - PROD

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on test env
      | Feature           | UCPHealthWellness |

  #----- beginning of sanity ------------------
  #note: look for scenarios w/ sanity tag
  
  #----- beginning of test for regression------------------
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - As an authenticated member on the new Member site, I want to validate health and wellness page content
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
    And I navigate to the Health and Wellness page
    And I should see the H&W Generic dashboard
    And I should see GET REWARD tile if available and be able to click it
      | Has Reward   | <hasReward>   |
    And I should see RENEW ACTIVE tile if available and be able to click it
      | Has RenewActive | <hasRenewActive>   |
      
    @prod_healthAndWellness01_ma_mapd @prod_sanity
    Examples: 
      | TID   | username  | password  | MemUserName     | planType | memberType        | hasReward | hasRenewActive |
      | 15340 | kkumard   | tnps459#  | BILL.ROSNER123# | MAPD     | RewardsMember     | true      | true           |

    @prod_healthAndWellness01_ma_mapd
    Examples: 
      | TID   | username  | password  | MemUserName     | planType | memberType        | hasReward | hasRenewActive |
      | 15341 | kkumard   | tnps459#  | haradaty32      | MA       | AARP_RewardsMember| true      | true           |
      | 15341 | kkumard   | tnps459#  | ExDesertrat     | MA       | UHC_RewardsMember | true      | false          |

    @prod_healthAndWellness01_pdp_ship
    Examples: 
      | TID   | username  | password  | MemUserName     | planType | memberType        | hasReward | hasRenewActive |
      | 15342 | kkumard   | tnps459#  | nawal1215       | PDP      | RewardsMember     | false     | false          |

    @prod_healthAndWellness01_pdp_ship @prod_sanity
    Examples: 
      | TID   | username  | password  | MemUserName     | planType | memberType        | hasReward | hasRenewActive |
      | xxxxx | kkumard   | tnps459#  | vernajohnson19651 | SHIP   | RewardsMember     | false     | false          |

    @prod_healthAndWellness01_fedShipCombo_shipFedCombo
    Examples: 
      | TID   | username  | password  | MemUserName     | planType | memberType        | hasReward | hasRenewActive |
      | 15343 | kkumard   | tnps459#  | rldf1942        | FED_SHIP_COMBO | RewardsMember | false   | true           |
	#note: can't find a prod combo user w/ SHIP priority yet
    # | 15343 | kkumard   | tnps459#  | testuserTBD     | SHIP_FED_COMBO | RewardsMember | false   | true           |
 
 