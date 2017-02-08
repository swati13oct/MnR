@redesignClaims
Feature: To validate the new changes related to claims page on the member redesigned site
Scenario Outline: To verify header for MA/MAPD member on new UHC Claims page 
Given I am an UHC member on the redesigned member site
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When I navigate to the Claims Summary page
Then I should be able to validate the header
Examples:

 | planType  | memberType  |
 | SSUP   | Group  |
 