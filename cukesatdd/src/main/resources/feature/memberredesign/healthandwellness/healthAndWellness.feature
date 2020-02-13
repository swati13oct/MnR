@healthAndWellness @member_redesign_H&W
Feature: 1.09 Member Health and Wellness Page

  @healthAndWellness1 @member_redesign_H&W @regressiongenericpagesH&W @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - As an authenticated member on the new Member site, I want to check health and wellness and its Lifestyle, Learning and Rewards tabs
    #Given I am a authenticated member on the member redesign site HW
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And I view the global navigation HW
    And then click the health and wellness tab HW
    And I should see the H&W Generic dashboard
    And I should see GET REWARD tile if available and be able to click it
      | Plan Type   | <planType>   |

    Examples: 
      | TID   | planType | memberType    |
      | 15340 | MAPD     | RewardsMember |
      | 15341 | MA       | RewardsMember |
      | 15342 | PDP      | RewardsMember |
      | 15343 | COMBO    | RewardsMember |
      | xxxxx | SHIP     | RewardsMember |
