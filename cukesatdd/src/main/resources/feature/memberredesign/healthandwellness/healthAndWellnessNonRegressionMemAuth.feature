@healthAndWellness
Feature: 1.09.1 Member Health and Wellness Page - Member Auth

  #----- beginning of test for non-regression------------------
  Scenario Outline: To validate via member authorization access for health and wellness
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
      
    @memAuth_healthAndWellness01a
    Examples: 
      | TID   | username  | password  | MemUserName     | planType | memberType        | hasReward | hasRenewActive |
      | 15340 | qavgogine | qavgogine | q1_feb_nice_019 | MAPD     | RewardsMember     | true      | true           |
#      | 15341 | qavgogine | qavgogine | q2_may_rally002 | MA       | AARP_RewardsMember| true      | true           |
#      | 15341 | qavgogine | qavgogine | q3_sep_UAT4_UHC085 | MA    | UHC_RewardsMember | true      | true           |

    @memAuth_healthAndWellness01b
    Examples: 
      | TID   | username  | password  | MemUserName     | planType | memberType        | hasReward | hasRenewActive |
      | 15342 | qavgogine | qavgogine | q2_jun_aarp0179 | PDP      | RewardsMember     | false     | false          |
#      | xxxxx | qavgogine | qavgogine | q1_feb_2020SHIP_003 | SHIP | RewardsMember     | false     | true           |

    @memAuth_healthAndWellness01c
    Examples: 
      | TID   | username  | password  | MemUserName     | planType | memberType        | hasReward | hasRenewActive |
      | 15343 | qavgogine | qavgogine | q2_june_combo0017 | FED_SHIP_COMBO | RewardsMember     | false    | false   |
#      | 15343 | qavgogine | qavgogine | q3_sep_grp_005  | SHIP_FED_COMBO   | RewardsMember     | false    | true    |
 
 