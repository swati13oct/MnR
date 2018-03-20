@smokeTest
Feature: 1.07-VBF-MemRedesign-To test Health and Wellness functionality
@smokeTest__H&W @rallyDashboard @testharness
Scenario Outline:Validate that member can check health and wellness and its Lifestyle, Learning tabs
Given I am a authenticated member on the member redesign site
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in member area to validate HW
When then click the health and wellness tab
When I should see the H&W Generic dashboard and lifestyle,learning and rewards L2 tabs
When then click the Lifestyle tab and I should be directed to Lifestyle Page
When then click the Learning tab and I should be directed to Learning Page

Examples:
 | planType  | memberType  |
 | MAPD      | UhcIndOrderPlan |
 #| MAPD      | AARPIndOrderPlan |
 #| MAPD      | GrpRetireeOrderPlan |