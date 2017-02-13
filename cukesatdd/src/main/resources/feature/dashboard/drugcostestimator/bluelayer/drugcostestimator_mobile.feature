@drug_cost_estimator_mobile
Feature:Drug Cost Estimator- Pharmacy 
Scenario Outline: To Verify MR portal members using DCE on a desktop device will be able to edit their drug list to add drugs up to a total of 25, subtract drugs, change dosages, change packaging and change frequency at any time while using the tool
Given I am an UHC Individual member on the Dashboard site SmartPhone
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site
And I should see Drug List as an active tab in the DCE tool upon click
And I should be able to add up to 25 drugs to my drug list
|drug|
|lipitor|

And I should have the ability to advance to the next step in the DCE flow after successfully creating a drug list with at least one drug 
Examples:
 | planType  | memberType  |
 | MA       |Individual |
 
Scenario Outline: To Verify MR portal members using DCE enter at least four characters of the drug name
Given I am an UHC Individual member on the Dashboard site SmartPhone
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site
And I should see Drug List as an active tab in the DCE tool upon click
And I should be able to click on Add a Drug
And the Add a Drug search modal should launch
And I enter at least four characters of the drug name in the Enter Drug Name field but not the exact drug name
Then I should see a list of approximate search results to choose from
And I should be able to select a drug from the list
And the modal should refresh to the next step in the flow if I select one of the suggested results

Examples:
 | planType  | memberType  |
 | MA       |Individual |
 
Scenario Outline: To Verify MR portal members using DCE see a default system error message
Given I am an UHC Individual member on the Dashboard site SmartPhone
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site
And I should see Drug List as an active tab in the DCE tool upon click
And I should be able to click on Add a Drug
And the Add a Drug search modal should launch
And I fail to enter at least four characters of the drug name when attempting to advance in the flow
Then I should see a default system error message from the current state error messages in the portal database
Examples:
 | planType  | memberType  |
 | MA       |Individual |
 
Scenario Outline: To Verify MR portal members using DCE on a Mobile device will be able to edit their drug list
Given I am an UHC Individual member on the Dashboard site SmartPhone
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site
When I use the DCE tool to enter one or more drugs to my drug list
When I should be see dosage, package and frequency options returned from the DCE web service
Examples:

 | planType  | memberType  |
 | MA       |Individual |
 
Scenario Outline: To Verify MR portal members using DCE on a Mobile device, Pharmacy search tab validation
Given I am an UHC Individual member on the Dashboard site SmartPhone
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site
And I should see Drug List as an active tab in the DCE tool upon click
Then I should see the Pharmacy search tab as a clickable element within the DCE tool
And I should be able to move forward or backward in the tool flow 
Examples:
 | planType  | memberType  |
 | MA       |Individual |
 