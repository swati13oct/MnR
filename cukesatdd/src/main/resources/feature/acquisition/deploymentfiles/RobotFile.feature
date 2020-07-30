@robotTxtFile
Feature: 2.1 ACQ- To test robot txt file is loading correctly
@robotTxtFileAARP
Scenario Outline: To test the robot txt file is loading on AARP
Given the user is on the AARP medicare site landing page
And user opens the page to validate on AARP
 | pagename | <pagename> |
Then the user validates whether page load is loading on AARP
#Then the user validates whether correct content is visible on AARP
#| pagename | <pagename> |
Examples: 
| pagename |
|robot.txt|

@robotTxtFileUHC
Scenario Outline: To test the robot txt file is loading on UHC
Given user is on blue layer landing page
And user opens the page to validate on UHC
 | pagename | <pagename> |
Then the user validates whether page load is loading on UHC
Then the user validates whether correct content is visible on UHC
| pagename | <pagename> |
Examples: 
| pagename |
|robot.txt|