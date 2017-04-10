@drug_cost_estimator
Feature:Drug Cost Estimator

@467875
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
 | MAPD      |IndividualDCEmember |
 
 
@US502131
Scenario Outline: To Verify MR portal members using DCE on a desktop device , Pharmacy search tab validation
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
Then I should see the Pharmacy search tab as a clickable element within the DCE tool
And I should be able to move forward or backward in the tool flow 
Examples:
 | planType  | memberType  |
 | MAPD       |IndividualDCEmember |

@drug_cost_estimatorstep5
Scenario Outline: Pharmacy saver results
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And I access the page containing the DCE tool
And I navigate to step2 page
Then I should not see pharmacy saver radio button under pharmacy type

 Examples:
| planType | memberType|
| MA     |Group_non_pharmacy_saver |

 
@drug_cost_estimatorstep4
Scenario Outline: Pharmacy saver results
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And I access the page containing the DCE tool
And I navigate to step2 page
And we search the pharmacy within miles zipcode and pharmacy type
| Zipcode| <zipcode> |
| Radius | <radius>  |
|Pharmacy Type|<pharmacytype>| 
Then I should see pharmacy results as per the filter
And I should see pharmacy saver pharmacies in results

 Examples:
| planType | memberType| zipcode| radius|pharmacytype|
| MAPD     |IndividualDCEmember | 06450  | 25 miles|Pharmacy Saver|


@drug_cost_estimatorstep5
Scenario Outline: Pharmacy saver results
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And I access the page containing the DCE tool
And I navigate to step2 page
Then I should not see pharmacy saver radio button under pharmacy type


 Examples:
| planType | memberType|
| MA     |Group_non_pharmacy_saver |
 
 
 @drug_cost_estimator_with_cost_savings
Scenario Outline: To Verify MR portal members using DCE on a desktop device, I want to be able to see the estimated cost savings that are available to me after I have entered one or more drugs on my drug list and have selected a pharmacy so I can be aware of my potential savings if I were to select a different drug or pharmacy.
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And I access the page containing the DCE tool
And I add lipitor generic and branded drug
And I navigate to step2 page
And I select first pharmacy from standard network pharmacy type
And I navigate to step3 page
Then I should see that total estimated annual drug costs in summary section matches with left rail value
|totalAnnualDrugCost | <totalAnnualDrugCost> |
And I should see that total available savings in summary section matches with left rail value
|totalAvailableSavings | <totalAvailableSavings> |
And I should see this value for drug cost savings by switching to generics
|drugSavings | <drugSavings> |
And I should see this value for pharmacy cost savings by switching to recommended pharmacies
|pharmacySavings | <pharmacySavings> |
And I should see this value for initial coverage stage, Coverage Gap stage, Catastrophic Coverage Stage
|drugCoverage | <drugCoverage> |
And I should be able to switch to drugs or pharmacy that the tool has recommended
 
 Examples:
 | planType| memberType|totalAnnualDrugCost|totalAvailableSavings|drugSavings|pharmacySavings|drugCoverage|
 | MAPD|IndividualwithCostSavings|$3,562.56|$3,539.20|Save $3,514.56|Save $24.64|$294.88|
 
 
@drug_cost_estimator_without_mail_service
Scenario Outline: To Verify MR portal members using DCE on a desktop device, if it is a PEEHIP member, then preferred mail service option will not be available.
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And I access the page containing the DCE tool
And I navigate to step2 page
Then I should not see preferred mail service radio button under pharmacy type 

Examples:
 | planType  | memberType  |
 | MAPD      |ALPEEHIP|
 
 @drug_cost_estimator_with_mail_service
Scenario Outline: To Verify MR portal members using DCE on a desktop device, will have preferred mail services option available depending on its member type.
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And I access the page containing the DCE tool
And I navigate to step2 page
Then I should see preferred mail service radio button under pharmacy type 
And I enter a US other territory zip code and click select
| USOTZipcode | <USOTZipcode> |
Then I should see preferred mail service radio button under pharmacy type
And I should be able to select the preferred mail service radio button
And I should be able to select the preferred mail service pharmacy

Examples:
 | planType  | memberType  | USOTZipcode |
 | MA       |IndividualwithMailService|96923 |
 
 #-----------------------------------------------------------------
 #MAPD Grp q1_apr_grp091 (918084105-1, DOB - 1946-03-03)  US529088
 
@drug_cost_estimator_switch_to_generic_case_1
Scenario Outline: To Verify MR portal members using DCE on a desktop device, I want to be able to switch from branded to generic drug, given that no pharmacy is selected and it suggests the user with an appropriate save money message.
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And I access the page containing the DCE tool
And I have added a drug to my drug list and a generic equivalent is available for the drug I have selected
 	|Drug|<drug>|
And I have not yet selected pharmacy
Then I should be presented the option to switch to the generic option
And I will see a SWITCH NOW link in the drug tile with appropriate save message
And I will see a modal appear upon clicking on SWITCH NOW
And when I click on the button to accept the generic
Then the drug name will automatically update within the Drug List

Examples:
 | planType| memberType| drug |
 | MAPD|Individualwithoutpharmacy|lipitor|
 
 
  #---------------------------------------------
 #MAPD Grp q1_apr_grp357(971691002-1 / DOB- 5/29/1945)  US529088
 
@drug_cost_estimator_switch_to_generic_case_2
Scenario Outline: To Verify MR portal members using DCE on a desktop device, I want to be able to switch from branded to generic drug, given that a pharmacy is selected and it suggests the user with an appropriate save money message and cost savings are also updated
Given I am a registered member using the new M&R member portal on a desktop computer
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop
And I access the page containing the DCE tool
And I have added a drug to my drug list and a generic equivalent is available for the drug I have selected
 	|Drug|<drug>|
And I have selected pharmacy
Then I should be presented the option to switch to the generic option
And I will see a SWITCH NOW link in the drug tile with a pharmacy savings cost value
And I will see a modal appear upon clicking on SWITCH NOW 
And when I click on the button to accept the generic
Then the drug name will automatically update within the Drug List
And any cost savings will be applied to my total cost savings in Step3

Examples:
 | planType| memberType| drug |
 | MAPD|IndividualDCEmember|lipitor|
 