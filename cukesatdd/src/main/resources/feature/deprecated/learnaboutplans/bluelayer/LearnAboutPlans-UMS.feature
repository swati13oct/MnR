@learnaboutplans
Feature: To test plan summary in UMS site	
Scenario Outline: To Verify the learn more widget for UMS site
Given the user is on the UMS medicare site landing page
When the user picks a topic in learn more widget for UMS site
    | picktopic | <picktopic> |        
Then the user validates the content on the page in UMS site  
Examples:
  | picktopic |
  | Learn about Medicare	|
  | Prepare for Initial Enrollment |