@learnaboutplans
Feature: To test plan summary in AARP site	
Scenario Outline: To Verify the learn more widget for AARP site
Given the user is on the AARP medicare site landing page
When the user picks a topic in learn more widget for AARP site
    | picktopic | <picktopic> |        
Then the user validates the content on the page in AARP site  
Examples:
  | picktopic |
  | Learn about Medicare	|
  | Prepare for Initial Enrollment |