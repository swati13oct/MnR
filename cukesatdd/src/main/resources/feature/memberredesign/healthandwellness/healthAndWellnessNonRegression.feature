@healthAndWellness @regressionMember
Feature: 1.09 Member Health and Wellness Page

  #----- beginning of test for offline prod - local run only ------------------
  # DO NOT REMOVE this scenario
  # This scenario is not part of the regular regression run BUT is for aiding the team to do offline prod testing if needed
  # note: this setup is for the case when we need to validate on offline-prod environment
  # note: this is intended for local run where you can put in your own member auth username/password and offline username
  # note: run with environment variable set to offline. -Denvironment="prod"
  # note: *** DO NOT save your login or test username to github ***
  # note: replace the following fields with valid value -
  # note:   username = your memAuth page login username
  # note:   password = your memAuth page login password
  # note:   MemUsername =  username of the user on offline prod that you want to test
  Scenario Outline: To validate via member authorization access for health and wellness
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    #-------------- navigate to the target test page for testing
    And I navigate to the Health and Wellness page
    And I should see the H&W Generic dashboard
    And I should see GET REWARD tile if available and be able to click it
      | Has Reward   | <hasReward>   |
    And I should see RENEW ACTIVE tile if available and be able to click it
      | Has RenewActive | <hasRenewActive>   |
      

    Examples: 
      | index | username   | password   | MemUserName  | planType | memberType        | hasReward | hasRenewActive |
      |    01 | myUsername | myPassword | testUsername | MAPD     | RewardsMember     | true      | true           |
 
 