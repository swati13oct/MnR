Feature:Header/Navigation for Member Site Redesign

@Sanity__H&W
Scenario Outline:As an authenticated member on the new Member site, I want to check health and wellness and its Lifestyle, Learning and Rewards tabs
Given I am a authenticated member on the member redesign site
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
When then click the health and wellness tab 
When I should see the H&W Generic dashboard and lifestyle,learning and rewards L2 tabs
When then click the Lifestyle tab and I should be directed to Lifestyle Page
When then click the Learning tab and I should be directed to Learning Page

Examples:
 | planType  | memberType  |
 | MAPD      | UhcIndOrderPlan |
 | MAPD      | AARPIndOrderPlan |
 | MAPD      | GrpRetireeOrderPlan |