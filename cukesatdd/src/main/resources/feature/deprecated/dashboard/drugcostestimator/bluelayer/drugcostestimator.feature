@drug_cost_estimator
Feature:Drug Cost Estimator- Pharmacy 
Scenario Outline: To Verify MR portal members using DCE-Pharmacy on a desktop device 
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And the user selects the pharmacy tab information like miles, zipcode and pharmacy type blayer dce 
| Zipcode	  | <zipcode> |
| Radius  | <radius>   |
Then the user should be able to validate the pharmacy information blayer dce
Examples:

 | planType  | memberType  | zipcode| radius|
 | MA       |Individual | | 90002 | 25miles |

@US425298_desktop
Scenario Outline: To Verify MR portal members using DCE on a desktop device will be able to edit their drug list to add drugs up to a total of 25, subtract drugs, change dosages, change packaging and change frequency at any time while using the tool
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I should see Drug List as an active tab in the DCE tool upon click blayer dce
And I should be able to add up to 25 drugs to my drug list blayer dce
|drug|
And I should have the ability to advance to the next step in the DCE flow after successfully creating a drug list with at least one drug blayer dce 
Examples:
 | planType  | memberType  |
 | MAPD      |IndividualDCEmember |
 
 #US425298_02
Scenario Outline: To Verify MR portal members using DCE enter at least four characters of the drug name
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I should see Drug List as an active tab in the DCE tool upon click blayer dce
And I should be able to click on Add a Drug blayer dce
And the Add a Drug search modal should launch blayer dce
And I enter at least four characters of the drug name in the Enter Drug Name field but not the exact drug name blayer dce
|drug|
|Lipi|
Then I should see a list of approximate search results to choose from blayer dce
|drug|
|Lipitor|
And I should be able to select a drug from the list blayer dce
And the modal should refresh to the next step in the flow if I select one of the suggested results blayer dce

Examples:
 | planType  | memberType  |
 | MAPD       |IndividualDCEmember |
 
 #@US425298_03
Scenario Outline: To Verify MR portal members using DCE see a default system error message
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I should see Drug List as an active tab in the DCE tool upon click blayer dce
And I should be able to click on Add a Drug blayer dce
And the Add a Drug search modal should launch blayer dce
And I fail to enter at least four characters of the drug name when attempting to advance in the flow blayer dce
|drug|
|Lip|
Then I should see a default system error message from the current state error messages in the portal database blayer dce
Examples:
 | planType  | memberType  |
 | MA       |Individual |
 
 #@467875
Scenario Outline: To Verify MR portal members using DCE on a desktop device will be able to edit drugs
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
When I use the DCE tool to enter one or more drugs to my drug list blayer dce
|drug|
|Lipi|
When I should be see dosage, package and frequency options returned from the DCE web service blayer dce
And I should be able to change those options at any time blayer dce
And I should have the ability to advance to the next step in the flow blayer dce
Examples:
 | planType  | memberType  |
 | MAPD      |IndividualDCEmember |
	
#@US502131
Scenario Outline: To Verify MR portal members using DCE on a desktop device , Pharmacy search tab validation
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
Then I should see the Pharmacy search tab as a clickable element within the DCE tool blayer dce
And I should be able to move forward or backward in the tool flow blayer dce 
Examples:
 | planType  | memberType  |
 | MAPD       |IndividualDCEmember |
 
 #---------------------------------------------------------------------
 @drug_cost_estimator11
Scenario Outline: To Verify MR portal members using DCE on a desktop device will be able to edit their drug list , subtract drugs, change dosages, change packaging and change frequency at any time while using the tool
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I add the drug with Dosage and Quantity and frequency to the list blayer dce
|Drug|<drug>|
|Dosage|<dosage>|
|Quantity|<quantity>|
|Frequency|<frequency>|
Then I should see drug with Dosage and Quantity and frequency added to the list blayer dce
|Drug|<drug>|
|Dosage|<dosage>|
|Quantity|<quantity>|
|Frequency|<frequency>|
When I edit the drug with Dosage and Quantity and frequency blayer dce
|Drug|<drug>|
|EditDosage|<editdosage>|
|EditQuantity|<editquantity>|
|EditFrequency|<editfrequency>|
Then I should validate drug with Dosage and Quantity and frequency edited to the list blayer dce
|EditDosage|<editdosage>|
|EditQuantity|<editquantity>|
|EditFrequency|<editfrequency>|
When I delete the drug with Dosage blayer dce
|EditDosage|<editdosage>|
Then I should not see the drug with Dosage in the list blayer dce 
|EditDosage|<editdosage>|
 
Examples:
 | planType |memberType |drug|dosage|quantity|frequency|editdosage|editquantity|editfrequency|
 | MAPD     |IndividualDCEmember |Lipitor|Lipitor TAB 10MG|30|Every 1 month|Lipitor TAB 10MG|60|Every 3 months|
 
 #----------------------------------------------------------
Scenario Outline: To Verify MR portal members using DCE on a Mobile device will be able to edit their drug list , subtract drugs, change dosages, change packaging and change frequency at any time while using the tool
Given I am an UHC Individual member on the Dashboard site SmartPhone blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site blayer dce
And I access the page containing the DCE tool blayer dce
And I add the drug with Dosage and Quantity and frequency to the list blayer dce
|Drug|<drug>|
|Dosage|<dosage>|
|Quantity|<quantity>|
|Frequency|<frequency>|
Then I should see drug with Dosage and Quantity and frequency added to the list blayer dce
|Drug|<drug>|
|Dosage|<dosage>|
|Quantity|<quantity>|
|Frequency|<frequency>|
When I edit the drug with Dosage and Quantity and frequency blayer dce
|Drug|<drug>|
|EditDosage|<editdosage>|
|EditQuantity|<editquantity>|
|EditFrequency|<editfrequency>|
Then I should see drug with Dosage and Quantity and frequency added to the list blayer dce
|EditDosage|<editdosage>|
|EditQuantity|<editquantity>|
|EditFrequency|<editfrequency>|
When I delete the drug with Dosage blayer dce
|EditDosage|<editdosage>|
Then I should not see the drug with Dosage in the list blayer dce 
|EditDosage|<editdosage>|
 
Examples:
 | planType |memberType |drug|dosage|quantity|frequency|editdosage|editquantity|editfrequency|
 | MAPD     |IndividualDCEmember |Lipitor|Lipitor TAB 10MG|30|Every 1 month|Lipitor TAB 20MG|60|Every 3 months|
 
 
#------------------------------------------------------------ 
Scenario Outline: To Verify MR portal members using DCE on a desktop device heading, Drugs text and x other(s).
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
Then I will see introductory text that will display the summary header blayer dce
And the drug list tab will display drugs heading blayer dce
And I should see enter your drugs text blayer dce
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list blayer dce
|Drug|<drug1>|
|Dosage|<dosage1>|
|Quantity|<quantity1>|
|Frequency|<frequency1>|
Then I should see drug with Dosage and Quantity and frequency added to the list blayer dce
|Drug|<drug1>|
|Dosage|<dosage1>|
|Quantity|<quantity1>|
|Frequency|<frequency1>|
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list blayer dce
|Drug|<drug2>|
|Dosage|<dosage2>|
|Quantity|<quantity2>|
|Frequency|<frequency2>|
Then I should see drug with Dosage and Quantity and frequency added to the list blayer dce
|Drug|<drug2>|
|Dosage|<dosage2>|
|Quantity|<quantity2>|
|Frequency|<frequency2>|
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list blayer dce
|Drug|<drug3>|
|Dosage|<dosage3>|
|Quantity|<quantity3>|
|Frequency|<frequency3>|
Then I should see drug with Dosage and Quantity and frequency added to the list blayer dce
|Drug|<drug3>|
|Dosage|<dosage3>|
|Quantity|<quantity3>|
|Frequency|<frequency3>|
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list blayer dce
|Drug|<drug4>|
|Dosage|<dosage4>|
|Quantity|<quantity4>|
|Frequency|<frequency4>|
Then I should see drug with Dosage and Quantity and frequency added to the list blayer dce
|Drug|<drug4>|
|Dosage|<dosage4>|
|Quantity|<quantity4>|
|Frequency|<frequency4>|

And I should see at most 3 drugs under drugs heading blayer dce
|Dosage1|<dosage1>|
|Dosage2|<dosage2>|
|Dosage3|<dosage3>|
And I should see some others text on the page blayer dce
|OthersCount|<othercount>|

Examples:
 | planType |memberType |drug1|dosage1|quantity1|frequency1|drug2|dosage2|quantity2|frequency2|drug3|dosage3|quantity3|frequency3|drug4|dosage4|quantity4|frequency4|othercount|
 | MAPD     |Individual |Life Pack Womens|Life Pack Womens MIS WOMENS|30|Every 1 month|Lipistart|Lipistart POW|60|Every 1 month|Microclens Wipes|Microclens Wipes PAD WIPES|10|Every 1 month|Life Pack Mens|Life Pack Mens MIS MENS|70|Every 3 months|1 other|
 
#------------------------------------------------------------------------ 
Scenario Outline: To Verify MR portal members using DCE on a desktop device heading, Drugs text and x other(s).
Given I am an UHC Individual member on the Dashboard site SmartPhone blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site blayer dce
And I access the page containing the DCE tool blayer dce
Then I will see introductory text that will display the summary header blayer dce
And the drug list tab will display drugs heading blayer dce
And I should see enter your drugs text blayer dce
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list blayer dce
|Drug|<drug1>|
|Dosage|<dosage1>|
|Quantity|<quantity1>|
|Frequency|<frequency1>|
Then I should see drug with Dosage and Quantity and frequency added to the list blayer dce
|Drug|<drug1>|
|Dosage|<dosage1>|
|Quantity|<quantity1>|
|Frequency|<frequency1>|
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list blayer dce
|Drug|<drug2>|
|Dosage|<dosage2>|
|Quantity|<quantity2>|
|Frequency|<frequency2>|
Then I should see drug with Dosage and Quantity and frequency added to the list blayer dce
|Drug|<drug2>|
|Dosage|<dosage2>|
|Quantity|<quantity2>|
|Frequency|<frequency2>|
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list blayer dce
|Drug|<drug3>|
|Dosage|<dosage3>|
|Quantity|<quantity3>|
|Frequency|<frequency3>|
Then I should see drug with Dosage and Quantity and frequency added to the list blayer dce
|Drug|<drug3>|
|Dosage|<dosage3>|
|Quantity|<quantity3>|
|Frequency|<frequency3>|
When I add the drug which does not have its generic with Dosage and Quantity and frequency to the list blayer dce
|Drug|<drug4>|
|Dosage|<dosage4>|
|Quantity|<quantity4>|
|Frequency|<frequency4>|
Then I should see drug with Dosage and Quantity and frequency added to the list blayer dce
|Drug|<drug4>|
|Dosage|<dosage4>|
|Quantity|<quantity4>|
|Frequency|<frequency4>|

And I should see at most 3 drugs under drugs heading blayer dce
|Dosage1|<dosage1>|
|Dosage2|<dosage2>|
|Dosage3|<dosage3>|
And I should see some others text on the page blayer dce
|OthersCount|<othercount>|

Examples:
 | planType |memberType |drug1|dosage1|quantity1|frequency1|drug2|dosage2|quantity2|frequency2|drug3|dosage3|quantity3|frequency3|drug4|dosage4|quantity4|frequency4|othercount|
 | MAPD     |Individual |Life Pack Womens|Life Pack Womens MIS WOMENS|30|Every 1 month|Lipistart|Lipistart POW|60|Every 1 month|Microclens Wipes|Microclens Wipes PAD WIPES|10|Every 1 month|Life Pack Mens|Life Pack Mens MIS MENS|70|Every 3 months|1 other|
 
 
 #--------------------------------
 
 
 Scenario Outline: To Verify MR portal members using DCE on a desktop device will be able to edit their drug list to add drugs up to a total of 25, subtract drugs, change dosages, change packaging and change frequency at any time while using the tool
Given I am an UHC Individual member on the Dashboard site SmartPhone blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site blayer dce
And I should see Drug List as an active tab in the DCE tool upon click blayer dce
And I should be able to add up to 25 drugs to my drug list blayer dce
|drug|
|lipitor|

And I should have the ability to advance to the next step in the DCE flow after successfully creating a drug list with at least one drug blayer dce 
Examples:
 | planType  | memberType  |
 | MA       |Individual |
 
Scenario Outline: To Verify MR portal members using DCE enter at least four characters of the drug name
Given I am an UHC Individual member on the Dashboard site SmartPhone blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site blayer dce
And I should see Drug List as an active tab in the DCE tool upon click blayer dce
And I should be able to click on Add a Drug blayer dce
And the Add a Drug search modal should launch blayer dce
And I enter at least four characters of the drug name in the Enter Drug Name field but not the exact drug name blayer dce
Then I should see a list of approximate search results to choose from blayer dce
And I should be able to select a drug from the list blayer dce
And the modal should refresh to the next step in the flow if I select one of the suggested results blayer dce

Examples:
 | planType  | memberType  |
 | MA       |Individual |
 
Scenario Outline: To Verify MR portal members using DCE see a default system error message
Given I am an UHC Individual member on the Dashboard site SmartPhone blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site blayer dce
And I should see Drug List as an active tab in the DCE tool upon click blayer dce
And I should be able to click on Add a Drug blayer dce
And the Add a Drug search modal should launch blayer dce
And I fail to enter at least four characters of the drug name when attempting to advance in the flow blayer dce
|drug|
|Lip|
Then I should see a default system error message from the current state error messages in the portal database blayer dce
Examples:
 | planType  | memberType  |
 | MA       |Individual |
 
Scenario Outline: To Verify MR portal members using DCE on a Mobile device will be able to edit their drug list
Given I am an UHC Individual member on the Dashboard site SmartPhone blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site blayer dce
When I use the DCE tool to enter one or more drugs to my drug list blayer dce
When I should be see dosage, package and frequency options returned from the DCE web service blayer dce
Examples:

 | planType  | memberType  |
 | MA       |Individual |
 
Scenario Outline: To Verify MR portal members using DCE on a Mobile device, Pharmacy search tab validation
Given I am an UHC Individual member on the Dashboard site SmartPhone blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site blayer dce
And I should see Drug List as an active tab in the DCE tool upon click blayer dce
Then I should see the Pharmacy search tab as a clickable element within the DCE tool blayer dce
And I should be able to move forward or backward in the tool flow blayer dce 
Examples:
 | planType  | memberType  |
 | MA       |Individual |
 
 #----------------------------
@drug_cost_estimatorstep2
Scenario Outline: Pharmacy Results List 
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I navigate to step2 page blayer dce
Then I should see default miles zipcode and pharmacy type blayer dce
| Zipcode| <zipcode> |
| Radius | <radius>  |
|Pharmacy Type|<pharmacytype>| 
Then I should able to select all miles option from dropdown blayer dce
And I should able to select all the pharmacy type blayer dce
And we search the pharmacy within miles zipcode and pharmacy type blayer dce
| Zipcode| <zipcode1> |
| Radius | <radius1>  |
|Pharmacy Type|<pharmacytype1>| 
Then I should see pharmacy results as per the filter blayer dce 
 
 Examples:
| planType | memberType| zipcode| radius|pharmacytype|zipcode1|radius1|pharmacytype1|
| MAPD     |Individual | 14826  | 15 miles|Pharmacy Saver|47834|25 miles|Standard Network|
 
 
 
  #----------------------------
@drug_cost_estimatorstep3
Scenario Outline: Pharmacy cost saving
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I navigate to step2 page blayer dce
#And I select the first pharmacy blayer dce
And I select the pharmacy type blayer dce
|Pharmacy Type|<pharmacytype1>|
Then I should not see cost saving message for this pharmacy blayer dce
When I select the pharmacy type blayer dce
|Pharmacy Type|<pharmacytype2>|
Then I should see cost saving message for this pharmacy blayer dce
|Pharmacy Type|<pharmacytype2>|
When I select the pharmacy type blayer dce
|Pharmacy Type|<pharmacytype3>|
Then I should see cost saving message for this pharmacy blayer dce
|Pharmacy Type|<pharmacytype3>|
When I select the pharmacy type blayer dce
|Pharmacy Type|<pharmacytype4>|
Then I should not see cost saving message for this pharmacy blayer dce

 
 Examples:
| planType | memberType|pharmacytype1|pharmacytype2|pharmacytype3|pharmacytype4|
| MAPD     |Individual |Standard Network|Pharmacy Saver|Preferred Mail Service|Preferred Retail|



#----------------------------------

@drug_cost_estimatorstep4
Scenario Outline: Pharmacy saver results
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I navigate to step2 page
And we search the pharmacy within miles zipcode and pharmacy type blayer dce
| Zipcode| <zipcode> |
| Radius | <radius>  |
|Pharmacy Type|<pharmacytype>| 
Then I should see pharmacy results as per the filter blayer dce
And I should see pharmacy saver pharmacies in results blayer dce

 Examples:
| planType | memberType| zipcode| radius|pharmacytype|
| MAPD     |IndividualDCEmember | 06450  | 25 miles|Pharmacy Saver|


#----------------------------------
#q1_apr_grp010   #001620498-1 

@drug_cost_estimatorstep5
Scenario Outline: Pharmacy saver results
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I navigate to step2 page blayer dce
Then I should not see pharmacy saver radio button under pharmacy type blayer dce


 Examples:
| planType | memberType|
| MA     |Group_non_pharmacy_saver |
 
 
 
 #----------------------------------
#q1_feb_combo031  018378074-1
@drug_cost_estimatorstep6
Scenario Outline: Drug Cost Estimator verifies to see which pharmacies in the network associated with my plan are Preferred Retail Pharmacy 
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I navigate to step2 page blayer dce
Then I should see pharmacy type radio button is selected blayer dce
|Pharmacy Type|<pharmacytype1>|
And I should see preferred retail pharmacies as per the filter blayer dce
When I select the pharmacy type blayer dce
|Pharmacy Type|<pharmacytype2>|
Then I should see pharmacy type radio button is selected blayer dce
|Pharmacy Type|<pharmacytype2>|
When I select the pharmacy type blayer dce
|Pharmacy Type|<pharmacytype1>|
Then I should see pharmacy type radio button is selected blayer dce
|Pharmacy Type|<pharmacytype1>|

 Examples:
| planType | memberType|pharmacytype1|pharmacytype2|
| PDP     |Individual_pharmacy_retail |Preferred Retail|Standard Network|


#----------------------------------
#q1_feb_ulayer001 006745945-1

@drug_cost_estimatorstep7
Scenario Outline: Drug Cost Estimator verifies to see which pharmacies in the network associated with my plan are Preferred Retail Pharmacy - Negative test
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I navigate to step2 page blayer dce
Then I should not see pharmacy button radio button under pharmacy type blayer dce
|Pharmacy Type|<pharmacytype1>|

 Examples:
| planType | memberType|pharmacytype|
| MAPD     |Individual_pharmacy_saver |Preferred Retail|


#-----------------------------------------
#q1_apr_blayer015 926485538-1  US425354

@drug_cost_estimator_with_mail_service
Scenario Outline: To Verify MR portal members using DCE on a desktop device, will have preferred mail services option available depending on its member type.
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I navigate to step2 page blayer dce
Then I should see preferred mail service radio button under pharmacy type blayer dce 
And I enter a US other territory zip code and click select blayer dce
| USOTZipcode | <USOTZipcode> |
Then I should see preferred mail service radio button under pharmacy type blayer dce
And I should be able to select the preferred mail service radio button blayer dce
And I should be able to select the preferred mail service pharmacy blayer dce

Examples:
 | planType  | memberType  | USOTZipcode |
 | MA       |IndividualwithMailService|96923 |
 
 #------------------------------------------
 #q1_feb_grp043 957440822-1 US425354

@drug_cost_estimator_without_mail_service
Scenario Outline: To Verify MR portal members using DCE on a desktop device, if it is a PEEHIP member, then preferred mail service option will not be available.
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I navigate to step2 page blayer dce
Then I should not see preferred mail service radio button under pharmacy type blayer dce 

Examples:
 | planType  | memberType  |
 | MAPD      |ALPEEHIP|
 
 
@drug_cost_estimator_savings
Scenario Outline: M&R portal members using DCE on a desktop device will be able to see their calculated drug cost savings options after entering at least one or more drugs to their drug list and selecting a pharmacy.
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
	| Plan Type   | <planType>   |
	| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I use the DCE tool to enter one or more drugs to my drug list and complete the flow blayer dce
 	|Drug|<drug1>|
And I navigate to step2 page and I have selected a pharmacy blayer dce
And I navigate to step3 page blayer dce
Then I should be able to view the section on the left rail regarding drug cost saving with the link blayer dce 
And I should be able to click on the link to go back to step 1 blayer dce
Examples: 
	|planType | memberType | drug1 |
	|MAPD     | Individual_savings | Lipitor |  
 
 
#------------------------------------------
 #q1_feb_blayer023  US419083 
 
 @drug_cost_estimator_with_cost_savings
Scenario Outline: To Verify MR portal members using DCE on a desktop device, I want to be able to see the estimated cost savings that are available to me after I have entered one or more drugs on my drug list and have selected a pharmacy so I can be aware of my potential savings if I were to select a different drug or pharmacy.
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I add lipitor generic and branded drug blayer dce
And I navigate to step2 page blayer dce
And I select first pharmacy from standard network pharmacy type blayer dce
And I navigate to step3 page blayer dce
Then I should see that total estimated annual drug costs in summary section matches with left rail value blayer dce
|totalAnnualDrugCost | <totalAnnualDrugCost> |
And I should see that total available savings in summary section matches with left rail value blayer dce
|totalAvailableSavings | <totalAvailableSavings> |
And I should see this value for drug cost savings by switching to generics blayer dce
|drugSavings | <drugSavings> |
And I should see this value for pharmacy cost savings by switching to recommended pharmacies blayer dce
|pharmacySavings | <pharmacySavings> |
And I should see this value for initial coverage stage, Coverage Gap stage, Catastrophic Coverage Stage blayer dce
|drugCoverage | <drugCoverage> |
And I should be able to switch to drugs or pharmacy that the tool has recommended blayer dce
 
 Examples:
 | planType| memberType|totalAnnualDrugCost|totalAvailableSavings|drugSavings|pharmacySavings|drugCoverage|
 | MAPD|IndividualwithCostSavings|$3,562.56|$3,539.20|Save $3,514.56|Save $24.64|$294.88|
 
 
  @drug_cost_estimator_with_cost_savings_smart_phone
Scenario Outline: To Verify MR portal members using DCE on a desktop device, I want to be able to see the estimated cost savings that are available to me after I have entered one or more drugs on my drug list and have selected a pharmacy so I can be aware of my potential savings if I were to select a different drug or pharmacy.
Given I am an UHC Individual member on the Dashboard site SmartPhone blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site blayer dce
And I access the page containing the DCE tool blayer dce
And I add lipitor generic and branded drug blayer dce
And I navigate to step2 page blayer dce
And I select first pharmacy from standard network pharmacy type blayer dce
And I navigate to step3 page blayer dce
Then I should see that total estimated annual drug costs in summary section matches with left rail value blayer dce
|totalAnnualDrugCost | <totalAnnualDrugCost> |
And I should see that total available savings in summary section matches with left rail value blayer dce
|totalAvailableSavings | <totalAvailableSavings> |
And I should see this value for drug cost savings by switching to generics blayer dce
|drugSavings | <drugSavings> |
And I should see this value for pharmacy cost savings by switching to recommended pharmacies blayer dce
|pharmacySavings | <pharmacySavings> |
And I should see this value for initial coverage stage, Coverage Gap stage, Catastrophic Coverage Stage blayer dce
|drugCoverage | <drugCoverage> |
And I should be able to switch to drugs or pharmacy that the tool has recommended blayer dce
 
 Examples:
 | planType| memberType|totalAnnualDrugCost|totalAvailableSavings|drugSavings|pharmacySavings|drugCoverage|
 | MAPD|IndividualwithCostSavings|$3,562.56|$3,539.20|Save $3,514.56|Save $24.64|$294.88|
 
 #-------------------------------------
 #q1_apr_grp357   US419083
 
 @drug_cost_estimator_without_drug_cost_savings
Scenario Outline: To Verify MR portal members using DCE on a desktop device, I want to be able to see the estimated cost savings that are available to me after I have entered one or more generic drugs on my drug list and have selected a pharmacy so I can be aware of my potential savings and will not be able select different drug as drug savings are not present.
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I add lipitor generic drug blayer dce
And I navigate to step2 page blayer dce
And I select first pharmacy from standard network pharmacy type blayer dce
And I navigate to step3 page blayer dce
Then I should not see drug savings and be unable to switch the drugs blayer dce

Examples:
 | planType| memberType|
 | MAPD|IndividualDCEmember|
 
 
  #--------------------------------
 #MAPD Grp q1_apr_grp008
 
 @drug_cost_estimatorlearnmore_home_delivery
Scenario Outline: To Verify Members who have access to mail service should be able to see dynamic content related to their plan when using the Pharmacy Search functionality of the DCE tool and selecting the mail service option
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I delete the existing drug if present blayer dce
When I add the drug with Dosage and Quantity and frequency to the list blayer dce
|Drug|Lipitor|
|Dosage|Lipitor TAB 10MG|
|Quantity|60|
|Frequency|Every 1 month|
And I navigate to step2 page blayer dce
And I select the pharmacy type blayer dce
|Pharmacy Type|Preferred Mail Service|
And I select the Preferred Mail Service Pharmacy from the pharmacy result if not selected blayer dce
And I click Learn more about starting home delivery link blayer dce
Then I should see user plan content blayer dce
|Plan|<plan>|

Examples:
 | planType|memberType|plan|
 | MAPD|Group_Inc1|MAPD GROUP CURRENT YEAR|
 
 #-----------------------------------------------------------------
 #MAPD Grp q1_apr_grp091 (918084105-1, DOB - 1946-03-03)  US529088
 
@drug_cost_estimator_switch_to_generic_case_1
Scenario Outline: To Verify MR portal members using DCE on a desktop device, I want to be able to switch from branded to generic drug, given that no pharmacy is selected and it suggests the user with an appropriate save money message.
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I have added a drug to my drug list and a generic equivalent is available for the drug I have selected blayer dce
 	|Drug|<drug>|
And I have not yet selected pharmacy blayer dce
Then I should be presented the option to switch to the generic option blayer dce
And I will see a SWITCH NOW link in the drug tile with appropriate save message blayer dce
And I will see a modal appear upon clicking on SWITCH NOW blayer dce
And when I click on the button to accept the generic blayer dce
Then the drug name will automatically update within the Drug List blayer dce

Examples:
 | planType| memberType| drug |
 | MAPD|Individualwithoutpharmacy|lipitor|
 
 
  #---------------------------------------------
 #MAPD Grp q1_apr_grp357(971691002-1 / DOB- 5/29/1945)  US529088
 
# @drug_cost_estimator_switch_to_generic_case_2
Scenario Outline: To Verify MR portal members using DCE on a desktop device, I want to be able to switch from branded to generic drug, given that a pharmacy is selected and it suggests the user with an appropriate save money message and cost savings are also updated
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I have added a drug to my drug list and a generic equivalent is available for the drug I have selected blayer dce
 	|Drug|<drug>|
And I have selected pharmacy blayer dce
Then I should be presented the option to switch to the generic option blayer dce
And I will see a SWITCH NOW link in the drug tile with a pharmacy savings cost value blayer dce
And I will see a modal appear upon clicking on SWITCH NOW blayer dce 
And when I click on the button to accept the generic blayer dce
Then the drug name will automatically update within the Drug List blayer dce
And any cost savings will be applied to my total cost savings in Step3 blayer dce

Examples:
 | planType| memberType| drug |
 | MAPD|IndividualDCEmember|lipitor|
 