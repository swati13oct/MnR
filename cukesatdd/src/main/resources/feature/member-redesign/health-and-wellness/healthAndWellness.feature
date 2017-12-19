@member_redesign_H&W
Feature:Header/Navigation for Member Site Redesign

@member_redesign_H&W @IncrediblesH&W
Scenario Outline:As an authenticated member on the new Member site, I want to check health and wellness and its Lifestyle, Learning and Rewards tabs
Given I am a authenticated member on the member redesign site
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And I view the global navigation
And then click the health and wellness tab 
And I should see the H&W Generic dashboard and lifestyle,learning and rewards L2 tabs
And then click the Lifestyle tab and I should be directed to Lifestyle Page
And then click the Learning tab and I should be directed to Learning Page
And then click the Rewards tab and I should be directed to Rewards Page

Examples:
 | planType  | memberType  |
 | MAPD      |RewardsMember |