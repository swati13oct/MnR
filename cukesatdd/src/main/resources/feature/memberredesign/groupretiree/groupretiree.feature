@aprilRelease2018
@groupretireecustomgroup
Feature:CTTest all group retiree member pages for sign in and registration.Make sure links are working to go to external hsid page to preform the action member needs.

@groupretireecustom
Scenario Outline:Verify custom group retiree for sign and registration are redirecting to external hsid page.
Given the user is on group retiree acquisition home page
When I find groups dropdown populated with different retiree group name
And I select a group from list of group
| Group Name   | <groupName>   |
And selected group page is loaded
And click on Sign in or Register Now button
Then user is redirected to external hsid page 

Examples:
 | groupName |
 | ASRS      |
