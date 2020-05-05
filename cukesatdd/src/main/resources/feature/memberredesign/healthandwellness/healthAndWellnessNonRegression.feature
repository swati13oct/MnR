@healthAndWellness
Feature: 1.09.2 Member Health and Wellness Page - Non Regression

  #----- beginning of test for non-regression ------------------
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
      
    @nonReg__healthAndWellness01a
    Examples: 
      | TID   | username   | password   | MemUserName  | planType | memberType        | hasReward | hasRenewActive |
      | 15340 | myUsername | myPassword | testUsername | MAPD     | RewardsMember     | true      | true           |
      | 15341 | myUsername | myPassword | testUsername | MA       | AARP_RewardsMember| true      | true           |
      | 15341 | myUsername | myPassword | testUsername | MA       | UHC_RewardsMember | true      | true           |

    @nonReg__healthAndWellness01b
    Examples: 
      | TID   | username   | password   | MemUserName  | planType | memberType        | hasReward | hasRenewActive |
      | 15342 | myUsername | myPassword | testUsername | PDP      | RewardsMember     | false     | false          |
      | xxxxx | myUsername | myPassword | testUsername | SHIP     | RewardsMember     | false     | true           |

    @nonReg__healthAndWellness01c
    Examples: 
      | TID   | username   | password   | MemUserName  | planType | memberType        | hasReward | hasRenewActive |
      | 15343 | myUsername | myPassword | testUsername | FED_SHIP_COMBO | RewardsMember     | false    | false   |
      | 15343 | myUsername | myPassword | testUsername | SHIP_FED_COMBO | RewardsMember     | false    | true    |
 
  