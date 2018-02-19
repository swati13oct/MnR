@test123
Feature:Drug Cost Estimator (DCE)  (Secondary/Tertiary Page) - HTML/CSS - Drug List - Edit/Delete Functionality
#Scenario Outline: To Verify MR portal members using DCE on a desktop device will be able to edit their drug list to add drugs up to a total of 25, subtract drugs, change dosages, change packaging and change frequency at any time while using the tool
#Given I am a registered member using the new M&R member portal on a desktop computer ulayer dce
#| Plan Type   | <planType>   |
#       | Member Type	  | <memberType> |
#When plantype user logs in mobile in UHC Site  ulayer dce
#When I use the DCE tool to enter one or more drugs to my drug list
#Then I should be able to edit that list by either adding drugs up to a total of 25 or subtracting drugs at any time while using the tool
#Examples:
#
# | planType  | memberType  | startDate | endDate |
# | PDP   | Group  | 01/01/2016 | 12/30/2016 |
 
 #----------------------------------
#q1_feb_combo031  018378074-1
@drug_cost_estimator6
Scenario Outline: Drug Cost Estimator verifies to see which pharmacies in the network associated with my plan are Preferred Retail Pharmacy 
Given I am a registered member using the new M&R member portal on a desktop computer ulayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in AARP Site Desktop ulayer dce
And I access the page containing the DCE tool ulayer dce
And I navigate to step2 page ulayer dce
Then I should see pharmacy type radio button is selected ulayer dce
|Pharmacy Type|<pharmacytype1>|
And I should see preferred retail pharmacies as per the filter ulayer dce
When I select the pharmacy type ulayer dce
|Pharmacy Type|<pharmacytype2>|
Then I should see pharmacy type radio button is selected ulayer dce
|Pharmacy Type|<pharmacytype2>|
When I select the pharmacy type ulayer dce
|Pharmacy Type|<pharmacytype1>|
Then I should see pharmacy type radio button is selected ulayer dce
|Pharmacy Type|<pharmacytype1>|

 Examples:
| planType | memberType|pharmacytype1|pharmacytype2|
| PDP     |Individual_pharmacy_retail |Preferred Retail|Standard Network|


#----------------------------------
#q1_feb_ulayer001 006745945-1

@drug_cost_estimator7u
Scenario Outline: Drug Cost Estimator verifies to see which pharmacies in the network associated with my plan are Preferred Retail Pharmacy - Negative test
Given I am a registered member using the new M&R member portal on a desktop computer ulayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in AARP Site Desktop ulayer dce
And I access the page containing the DCE tool ulayer dce
And I navigate to step2 page ulayer dce
Then I should not see pharmacy button radio button under pharmacy type ulayer dce
|Pharmacy Type|<pharmacytype>|

 Examples:
| planType | memberType|pharmacytype|
| MAPD     |Individual_pharmacy_saver |Preferred Retail|
 
 
  #--------------------------------------
  #Ciba Vision Saline ampicillin sodium Exelon default pharmacy saver q1_apr_ulayer125
@drug_cost_estimatorcost
Scenario Outline: To Verify total annual costs, tier information and any available savings in the left rail of the Drug Costs step of the DCE tool
Given I am a registered member using the new M&R member portal on a desktop computer ulayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in AARP Site Desktop ulayer dce
And I access the page containing the DCE tool ulayer dce
Then I delete the existing drug if present ulayer dce
When I add the drug with Dosage and Quantity and frequency to the list ulayer dce
|Drug|Exelon|
|Dosage|Exelon CAP 1.5MG|
|Quantity|60|
|Frequency|Every 1 month|
And I add the drug which does not have its generic with Dosage and Quantity and frequency to the list ulayer dce
|Drug|ampicillin sodium|
|Dosage|ampicillin sodium INJ 1GM (for IV solution)|
|Quantity|1|
|Frequency|Every 1 month|
And I add the drug which does not have its generic with Dosage and Quantity and frequency to the list ulayer dce
|Drug|Ciba Vision Saline|
|Dosage|Ciba Vision Saline SOL SALINE|
|Quantity|1|
|Frequency|Every 1 month|
And I navigate to step2 page
Then I should see pharmacy type radio button is selected ulayer dce
|Pharmacy Type|Pharmacy Saver|
When I select the pharmacy type ulayer dce
|Pharmacy Type|Standard Network|
And I select the first pharmacy from the list ulayer dce
Then I should see Total cost in cost summary section ulayer dce
|ToTCost|$4,950.84|
And I should see total cost saving in cost summary section ulayer dce
|TotSaving|$4,286.52|
And I navigate to step3 page ulayer dce
Then I should see Total cost on left rail ulayer dce
|ToTCost|$4,950.84|
And I should see total cost saving on left rail ulayer dce
|TotSaving|$4,286.52|
And I should see drug cost saving on left rail ulayer dce
|DrugSaving|Save $4,284.68|
And I should see pharmacy cost saving on left rail ulayer dce
|PharmacySaving|Save $1.84|
And I should see amount deductible on left rail ulayer dce
|deductible|400|
And I navigate to step2 page
When I select the pharmacy type ulayer dce
|Pharmacy Type|Pharmacy Saver|
And I select the first pharmacy from the list ulayer dce
Then I should see Total cost in cost summary section ulayer dce
|ToTCost|$4,954.44|
And I should see total cost saving in cost summary section ulayer dce
|TotSaving|$4,291.00|
And I navigate to step3 page ulayer dce
Then I should see Total cost on left rail ulayer dce
|ToTCost|$4,954.44|
And I should see total cost saving on left rail ulayer dce
|TotSaving|$4,291.00|
And I should see drug cost saving on left rail ulayer dce
|DrugSaving|Save $4,285.56|
And I should see pharmacy cost saving on left rail ulayer dce
|PharmacySaving|Save $5.44|
And I should see amount deductible on left rail ulayer dce
|deductible|400|
 
Examples:
 | planType |memberType|
 | MAPD     |Individual_dce_flow_pharmacy_saver_cost|
 
 
 
   #--------------------------------------
#q1_apr_ulayer161 MAPD q1_feb_ulayer206 PDP
@drug_cost_estimatorlearn
Scenario Outline: To Verify relevant content in the Learn More section of Step 3 so I can understand any limitations or restrictions that may apply to my plan benefits
Given I am a registered member using the new M&R member portal on a desktop computer ulayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in AARP Site Desktop ulayer dce
And I access the page containing the DCE tool ulayer dce
Then I delete the existing drug if present ulayer dce
When I add the drug with Dosage and Quantity and frequency to the list ulayer dce
|Drug|Lipitor|
|Dosage|Lipitor TAB 10MG|
|Quantity|60|
|Frequency|Every 1 month|
And I navigate to step2 page
And I select the pharmacy from the list if not selected ulayer dce
And I navigate to step3 page ulayer dce
And I click on learn more tiers link ulayer dce
Then I should see relevant content for tiers ulayer dce
|Year|<year>|
|Layer|<layer>|
|Plan|<planType>|
When I click on learn more stages link ulayer dce
Then I should see relevant content for stages ulayer dce

Examples:
 | planType |memberType|year|layer|
 | MAPD     |Individual_Inc|CurrentYear|AARP|
 | PDP      |Individual_Inc|Current|AArp|
 
 
 #--------------------------------
 #MAPD q1_apr_ulayer025 PDP q1_feb_ulayer203
 
 @drug_cost_estimatorlearnmore_home_delivery
Scenario Outline: To Verify Members who have access to mail service should be able to see dynamic content related to their plan when using the Pharmacy Search functionality of the DCE tool and selecting the mail service option
Given I am a registered member using the new M&R member portal on a desktop computer ulayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in AARP Site Desktop ulayer dce
And I access the page containing the DCE tool ulayer dce
And I delete the existing drug if present ulayer dce
When I add the drug with Dosage and Quantity and frequency to the list ulayer dce
|Drug|Lipitor|
|Dosage|Lipitor TAB 10MG|
|Quantity|60|
|Frequency|Every 1 month|
And I navigate to step2 page ulayer dce
And I select the pharmacy type ulayer dce
|Pharmacy Type|Preferred Mail Service|
And I select the Preferred Mail Service Pharmacy from the pharmacy result if not selected ulayer dce
And I click Learn more about starting home delivery link ulayer dce
Then I should see user plan content ulayer dce
|Plan|<plan>|

Examples:
 | planType|memberType|plan|
 | PDP|Individual_Inc1|PDP Current Year|
 | MAPD|Individual_Inc1|MAPD Current Year|

 