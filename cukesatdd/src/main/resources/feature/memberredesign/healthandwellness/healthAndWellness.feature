@member_redesign_H&W
Feature: I1.4Header/Navigation for Member Site Redesign

@member_redesign_H&W @IncrediblesH&W 
Scenario Outline:As an authenticated member on the new Member site, I want to check health and wellness and its Lifestyle, Learning and Rewards tabs
#Given I am a authenticated member on the member redesign site HW
Given login with following details logins in the member portal and validate elements
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
#When the above plantype user logs in UMS Site Desktop HW
And I view the global navigation HW
And then click the health and wellness tab HW
And I should see the H&W Generic dashboard and lifestyle,learning and rewards L2 tabs HW
And then click the Lifestyle tab and I should be directed to Lifestyle Page HW
And then click the Learning tab and I should be directed to Learning Page HW
And then click the Rewards tab and I should be directed to Rewards Page HW

Examples:
 | planType  | memberType   |
 | MAPD      |RewardsMember |
 #| MA        |RewardsMember |
 #| PDP       |RewardsMember |
 
 @member_redesign_H&W @regressiongenericpagesH&W @regression_06_06_18
Scenario Outline:As an authenticated member on the new Member site, I want to check health and wellness and its Lifestyle, Learning and Rewards tabs
#Given I am a authenticated member on the member redesign site HW
Given login with following details logins in the member portal and validate elements
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
#When the above plantype user logs in UMS Site Desktop HW
And I view the global navigation HW
And then click the health and wellness tab HW
And I should see the H&W Generic dashboard and lifestyle,learning and rewards L2 tabs HW

Examples:
 | planType  | memberType   |
 | MAPD      |RewardsMember |
# | PDP       |RewardsMember |