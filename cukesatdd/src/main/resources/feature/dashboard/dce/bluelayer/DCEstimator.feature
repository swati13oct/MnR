@test123
Feature:Drug Cost Estimator (DCE)  (Secondary/Tertiary Page) - HTML/CSS - Drug List - Edit/Delete Functionality
Scenario Outline: To Verify MR portal members using DCE on a desktop device will be able to edit their drug list to add drugs up to a total of 25, subtract drugs, change dosages, change packaging and change frequency at any time while using the tool
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
When I use the DCE tool to enter one or more drugs to my drug list
When I should be able to edit that list by either adding drugs up to a total of 25 or subtracting drugs at any time while using the tool
Examples:

 | planType  | memberType  |
 | PDP   | Group  |
 