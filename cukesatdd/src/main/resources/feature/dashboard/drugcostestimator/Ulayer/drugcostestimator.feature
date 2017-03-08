@test123
Feature:Drug Cost Estimator (DCE)  (Secondary/Tertiary Page) - HTML/CSS - Drug List - Edit/Delete Functionality
Scenario Outline: To Verify MR portal members using DCE on a desktop device will be able to edit their drug list to add drugs up to a total of 25, subtract drugs, change dosages, change packaging and change frequency at any time while using the tool
Given I am an UHC Individual member on the Dashboard site Desktop
| Plan Type   | <planType>   |
       | Member Type	  | <memberType> |
When plantype user logs in mobile in UHC Site
When I use the DCE tool to enter one or more drugs to my drug list
Then I should be able to edit that list by either adding drugs up to a total of 25 or subtracting drugs at any time while using the tool
Examples:

 | planType  | memberType  | startDate | endDate |
 | PDP   | Group  | 01/01/2016 | 12/30/2016 |
 
 #----------------------------------
#q1_feb_combo031  018378074-1
@drug_cost_estimator6
Scenario Outline: Drug Cost Estimator verifies to see which pharmacies in the network associated with my plan are Preferred Retail Pharmacy 
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in AARP Site Desktop
And I access the page containing the DCE tool
And I navigate to step2 page
Then I should see pharmacy type radio button is selected
|Pharmacy Type|<pharmacytype1>|
And I should see preferred retail pharmacies as per the filter
When I select the pharmacy type
|Pharmacy Type|<pharmacytype2>|
Then I should see pharmacy type radio button is selected
|Pharmacy Type|<pharmacytype2>|
When I select the pharmacy type
|Pharmacy Type|<pharmacytype1>|
Then I should see pharmacy type radio button is selected
|Pharmacy Type|<pharmacytype1>|

 Examples:
| planType | memberType|pharmacytype1|pharmacytype2|
| PDP     |Individual_pharmacy_retail |Preferred Retail|Standard Network|


#----------------------------------
#q1_feb_ulayer001 006745945-1

@drug_cost_estimator7u
Scenario Outline: Drug Cost Estimator verifies to see which pharmacies in the network associated with my plan are Preferred Retail Pharmacy - Negative test
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in AARP Site Desktop
And I access the page containing the DCE tool
And I navigate to step2 page
Then I should not see pharmacy button radio button under pharmacy type
|Pharmacy Type|<pharmacytype>|

 Examples:
| planType | memberType|pharmacytype|
| MAPD     |Individual_pharmacy_saver |Preferred Retail|
 