@US459522
Feature:To test Locate a Pharmacy tool in UMS site
Scenario Outline: Verify Pharmacy Locator Search page in UMS site
Given registered member to verify locate a pharmacy in UMS Site
| Plan Type    | <plantype>   |
| Member Type  | <memberType> |
When the user navigates to pharmacy search page in UMS site
And the user searches for get direcion available in UMS site

Examples:
|plantype    |memberType    | 
|MAPD        |Individual   | 
   	