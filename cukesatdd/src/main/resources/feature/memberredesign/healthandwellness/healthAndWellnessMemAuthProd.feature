@healthAndWellness
Feature: 1.09.1 Member Health and Wellness Page - Member Auth - PROD

  #----- beginning of test for non-regression------------------
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
      
    @prod_healthAndWellness01a
    Examples: 
      | TID   | username  | password  | MemUserName     | planType | memberType        | hasReward | hasRenewActive |
      | 15340 | ashah120  | Mnrqa002  | BILL.ROSNER123# | MAPD     | RewardsMember     | true      | true           |
      | 15341 | ashah120  | Mnrqa002  | haradaty32      | MA       | AARP_RewardsMember| true      | true           |
      | 15341 | ashah120  | Mnrqa002  | BNCSAUVE2       | MA       | UHC_RewardsMember | true      | true           |

    @prod_healthAndWellness01b
    Examples: 
      | TID   | username  | password  | MemUserName     | planType | memberType        | hasReward | hasRenewActive |
      | 15342 | ashah120  | Mnrqa002  | nawal1215       | PDP      | RewardsMember     | false     | false          |
      | xxxxx | ashah120  | Mnrqa002  | vernajohnson19651 | SHIP   | RewardsMember     | false     | true           |

    @prod_healthAndWellness01c
    Examples: 
      | TID   | username  | password  | MemUserName     | planType | memberType        | hasReward | hasRenewActive |
      | 15343 | ashah120  | Mnrqa002  | rldf1942        | FED_SHIP_COMBO | RewardsMember | false   | true           |
	#note: can't find a prod combo user w/ SHIP priority yet
    # | 15343 | ashah120  | Mnrqa002  | testuserTBD     | SHIP_FED_COMBO | RewardsMember | false   | true           |
 
 