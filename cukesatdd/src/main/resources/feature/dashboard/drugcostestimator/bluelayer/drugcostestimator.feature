@drug_cost_estimator
Feature:Drug Cost Estimator- Pharmacy 
Scenario Outline: To Verify MR portal members using DCE-Pharmacy on a desktop device 
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And the user selects the pharmacy tab information like miles, zipcode and pharmacy type 
| Zipcode	  | <zipcode> |
| Radius  | <radius>   |
Then the user should be able to validate the pharmacy information
Examples:

 | planType  | memberType  | zipcode| radius|
 | MA       |Individual | | 90002 | 25miles |

Scenario Outline: To Verify MR portal members using DCE on a desktop device will be able to edit their drug list to add drugs up to a total of 25, subtract drugs, change dosages, change packaging and change frequency at any time while using the tool
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And I should see Drug List as an active tab in the DCE tool upon click
And I should be able to add up to 25 drugs to my drug list
|drug|
|lipitor|

And I should have the ability to advance to the next step in the DCE flow after successfully creating a drug list with at least one drug 
Examples:
 | planType  | memberType  |
 | MA       |Individual |
 
mmm
Scenario Outline: To Verify MR portal members using DCE enter at least four characters of the drug name
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And I should see Drug List as an active tab in the DCE tool upon click
And I should be able to click on Add a Drug
And the Add a Drug search modal should launch
And I enter at least four characters of the drug name in the Enter Drug Name field but not the exact drug name
|drug|
|Lipi|
Then I should see a list of approximate search results to choose from
|drug|
|Lipitor|
And I should be able to select a drug from the list
And the modal should refresh to the next step in the flow if I select one of the suggested results

Examples:
 | planType  | memberType  |
 | MA       |Individual |
 
Scenario Outline: To Verify MR portal members using DCE see a default system error message
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And I should see Drug List as an active tab in the DCE tool upon click
And I should be able to click on Add a Drug
And the Add a Drug search modal should launch
And I fail to enter at least four characters of the drug name when attempting to advance in the flow
Then I should see a default system error message from the current state error messages in the portal database
Examples:
 | planType  | memberType  |
 | MA       |Individual |
 
Scenario Outline: To Verify MR portal members using DCE on a desktop device will be able to edit drugs
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
When I use the DCE tool to enter one or more drugs to my drug list
|drug|
|Lipi|
When I should be see dosage, package and frequency options returned from the DCE web service
And I should be able to change those options at any time
And I should have the ability to advance to the next step in the flow
Examples:
 | planType  | memberType  |
 | MA       |Individual |
	
Scenario Outline: To Verify MR portal members using DCE on a desktop device , Pharmacy search tab validation
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
Then I should see the Pharmacy search tab as a clickable element within the DCE tool
|drug|
|Lipistart|
And I should be able to move forward or backward in the tool flow 
Examples:
 | planType  | memberType  |
 | MA       |Individual |
 
 #---------------------------------------------------------------------
Scenario Outline: To Verify MR portal members using DCE on a desktop device will be able to edit their drug list , subtract drugs, change dosages, change packaging and change frequency at any time while using the tool
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And I access the page containing the DCE tool
And I add the drug with Dosage and Quantity and frequency to the list
|Drug|<drug>|
|Dosage|<dosage>|
|Quantity|<quantity>|
|Frequency|<frequency>|
Then I should see drug with Dosage and Quantity and frequency added to the list
|Drug|<drug>|
|Dosage|<dosage>|
|Quantity|<quantity>|
|Frequency|<frequency>|
When I edit the drug with Dosage and Quantity and frequency
|Drug|<drug>|
|EditDosage|<editdosage>|
|EditQuantity|<editquantity>|
|EditFrequency|<editfrequency>|
Then I should see drug with Dosage and Quantity and frequency added to the list
|EditDosage|<editdosage>|
|EditQuantity|<editquantity>|
|EditFrequency|<editfrequency>|
When I delete the drug with Dosage
|EditDosage|<editdosage>|
Then I should not see the drug with Dosage in the list 
|EditDosage|<editdosage>|
 
Examples:
 | planType |memberType |drug|dosage|quantity|frequency|editdosage|editquantity|editfrequency|
 | MAPD     |Individual |Lipitor|Lipitor TAB 10MG|30|Every 1 month|Lipitor TAB 20MG|60|Every 3 months|
 
 #----------------------------------------------------------
Scenario Outline: To Verify MR portal members using DCE on a Mobile device will be able to edit their drug list , subtract drugs, change dosages, change packaging and change frequency at any time while using the tool
Given I am an UHC Individual member on the Dashboard site SmartPhone
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site
And I access the page containing the DCE tool
And I add the drug with Dosage and Quantity and frequency to the list
|Drug|<drug>|
|Dosage|<dosage>|
|Quantity|<quantity>|
|Frequency|<frequency>|
Then I should see drug with Dosage and Quantity and frequency added to the list
|Drug|<drug>|
|Dosage|<dosage>|
|Quantity|<quantity>|
|Frequency|<frequency>|
When I edit the drug with Dosage and Quantity and frequency
|Drug|<drug>|
|EditDosage|<editdosage>|
|EditQuantity|<editquantity>|
|EditFrequency|<editfrequency>|
Then I should see drug with Dosage and Quantity and frequency added to the list
|EditDosage|<editdosage>|
|EditQuantity|<editquantity>|
|EditFrequency|<editfrequency>|
When I delete the drug with Dosage
|EditDosage|<editdosage>|
Then I should not see the drug with Dosage in the list 
|EditDosage|<editdosage>|
 
Examples:
 | planType |memberType |drug|dosage|quantity|frequency|editdosage|editquantity|editfrequency|
 | MAPD     |Individual |Lipitor|Lipitor TAB 10MG|30|Every 1 month|Lipitor TAB 20MG|60|Every 3 months|
 
 
#------------------------------------------------------------ 
Scenario Outline: To Verify MR portal members using DCE on a desktop device heading, Drugs text and x other(s).
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And I access the page containing the DCE tool
Then I will see introductory text that will display the summary header
And the drug list tab will display drugs heading
And I should see enter your drugs text
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list
|Drug|<drug1>|
|Dosage|<dosage1>|
|Quantity|<quantity1>|
|Frequency|<frequency1>|
Then I should see drug with Dosage and Quantity and frequency added to the list
|Drug|<drug1>|
|Dosage|<dosage1>|
|Quantity|<quantity1>|
|Frequency|<frequency1>|
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list
|Drug|<drug2>|
|Dosage|<dosage2>|
|Quantity|<quantity2>|
|Frequency|<frequency2>|
Then I should see drug with Dosage and Quantity and frequency added to the list
|Drug|<drug2>|
|Dosage|<dosage2>|
|Quantity|<quantity2>|
|Frequency|<frequency2>|
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list
|Drug|<drug3>|
|Dosage|<dosage3>|
|Quantity|<quantity3>|
|Frequency|<frequency3>|
Then I should see drug with Dosage and Quantity and frequency added to the list
|Drug|<drug3>|
|Dosage|<dosage3>|
|Quantity|<quantity3>|
|Frequency|<frequency3>|
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list
|Drug|<drug4>|
|Dosage|<dosage4>|
|Quantity|<quantity4>|
|Frequency|<frequency4>|
Then I should see drug with Dosage and Quantity and frequency added to the list
|Drug|<drug4>|
|Dosage|<dosage4>|
|Quantity|<quantity4>|
|Frequency|<frequency4>|

And I should see at most 3 drugs under drugs heading
|Dosage1|<dosage1>|
|Dosage2|<dosage2>|
|Dosage3|<dosage3>|
And I should see some others text on the page
|OthersCount|<othercount>|

Examples:
 | planType |memberType |drug1|dosage1|quantity1|frequency1|drug2|dosage2|quantity2|frequency2|drug3|dosage3|quantity3|frequency3|drug4|dosage4|quantity4|frequency4|othercount|
 | MAPD     |Individual |Life Pack Womens|Life Pack Womens MIS WOMENS|30|Every 1 month|Lipistart|Lipistart POW|60|Every 1 month|Microclens Wipes|Microclens Wipes PAD WIPES|10|Every 1 month|Life Pack Mens|Life Pack Mens MIS MENS|70|Every 3 months|1 other|
 
#------------------------------------------------------------------------ 
Scenario Outline: To Verify MR portal members using DCE on a desktop device heading, Drugs text and x other(s).
Given I am an UHC Individual member on the Dashboard site SmartPhone
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site
And I access the page containing the DCE tool
Then I will see introductory text that will display the summary header
And the drug list tab will display drugs heading
And I should see enter your drugs text
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list
|Drug|<drug1>|
|Dosage|<dosage1>|
|Quantity|<quantity1>|
|Frequency|<frequency1>|
Then I should see drug with Dosage and Quantity and frequency added to the list
|Drug|<drug1>|
|Dosage|<dosage1>|
|Quantity|<quantity1>|
|Frequency|<frequency1>|
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list
|Drug|<drug2>|
|Dosage|<dosage2>|
|Quantity|<quantity2>|
|Frequency|<frequency2>|
Then I should see drug with Dosage and Quantity and frequency added to the list
|Drug|<drug2>|
|Dosage|<dosage2>|
|Quantity|<quantity2>|
|Frequency|<frequency2>|
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list
|Drug|<drug3>|
|Dosage|<dosage3>|
|Quantity|<quantity3>|
|Frequency|<frequency3>|
Then I should see drug with Dosage and Quantity and frequency added to the list
|Drug|<drug3>|
|Dosage|<dosage3>|
|Quantity|<quantity3>|
|Frequency|<frequency3>|
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list
|Drug|<drug4>|
|Dosage|<dosage4>|
|Quantity|<quantity4>|
|Frequency|<frequency4>|
Then I should see drug with Dosage and Quantity and frequency added to the list
|Drug|<drug4>|
|Dosage|<dosage4>|
|Quantity|<quantity4>|
|Frequency|<frequency4>|

And I should see at most 3 drugs under drugs heading
|Dosage1|<dosage1>|
|Dosage2|<dosage2>|
|Dosage3|<dosage3>|
And I should see some others text on the page
|OthersCount|<othercount>|

Examples:
 | planType |memberType |drug1|dosage1|quantity1|frequency1|drug2|dosage2|quantity2|frequency2|drug3|dosage3|quantity3|frequency3|drug4|dosage4|quantity4|frequency4|othercount|
 | MAPD     |Individual |Life Pack Womens|Life Pack Womens MIS WOMENS|30|Every 1 month|Lipistart|Lipistart POW|60|Every 1 month|Microclens Wipes|Microclens Wipes PAD WIPES|10|Every 1 month|Life Pack Mens|Life Pack Mens MIS MENS|70|Every 3 months|1 other|
 
 
 #--------------------------------
 
 
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
 
 
 