@browsercheckGR
Feature: To test Browser check on GR site
Scenario Outline: To Verify the Pages of group templates in the browser
Given the user is on the GR site landing page
When the user select a group to launch group home page
| <group>   |
Then the user validates the error message on the browser

Examples:
	| group | 
    | ASRS  |

Scenario Outline: To Verify the Pages of templates in the browser
Given the user is on the GR site landing page
When the user is on the drug lookup page
Then the user validates the error message on the browser
