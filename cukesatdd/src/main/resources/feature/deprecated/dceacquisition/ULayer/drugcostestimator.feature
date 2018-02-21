@acq_drug_cost_estimator
Feature:Drug Cost Estimator (DCE) - HTML/CSS - Drug List - Edit/Delete Functionality

@acq_drug_cost_estimator_switch_to_generic_home_flow
Scenario Outline: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on AARP medicare site landing page DCE ulayer acq
When I access the acquisition DCE tool from home page DCE ulayer acq
And I have added a drug to my drug list and a generic equivalent is available for the drug I have selected DCE ulayer acq
 	|Drug|<drug>|
Then I should be presented the option to switch to the generic option DCE ulayer acq
And I have not yet selected pharmacy DCE ulayer acq
And I will see a SWITCH NOW link in the drug tile with appropriate save message DCE ulayer acq
And I have selected pharmacy in generic flow DCE ulayer acq
And I will see a SWITCH NOW link in the drug tile with appropriate save message DCE ulayer acq
And I will see a modal appear upon clicking on SWITCH NOW DCE ulayer acq
And when I click on the button to accept the generic DCE ulayer acq
Then the drug name will automatically update within the Drug List DCE ulayer acq

Examples:
 | drug |
 |lipitor|
 
@acq_drug_cost_estimator_switch_to_generic_vpp_flow
Scenario Outline: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on AARP medicare site landing page DCE ulayer acq
When I access the acquisition DCE tool from vpp page using below zipcode DCE ulayer acq
| Zip Code    | <zipcode>  |
And I have added a drug to my drug list and a generic equivalent is available for the drug I have selected DCE ulayer acq
 	|Drug|<drug>|
Then I should be presented the option to switch to the generic option DCE ulayer acq
And I have not yet selected pharmacy DCE ulayer acq
And I will see a SWITCH NOW link in the drug tile with appropriate save message DCE ulayer acq
And I have selected pharmacy DCE ulayer acq
And I will see a SWITCH NOW link in the drug tile with a pharmacy savings cost value DCE ulayer acq
And I will see a modal appear upon clicking on SWITCH NOW DCE ulayer acq
And when I click on the button to accept the generic DCE ulayer acq
Then the drug name will automatically update within the Drug List DCE ulayer acq
#And any cost savings will be applied to my total cost savings in Step3 DCE ulayer acq

Examples:
|zipcode| drug |
|90210|lipitor|

@acq_drug_cost_estimator1
Scenario Outline: As a prospective member using the DCE tool on the M&R portal site, I want to be able to choose my dosage, package and frequency when assembling a drug list on either a desktop or mobile device so I can eventually choose a pharmacy and accurately estimate the cost of my drugs.
Given the user is on AARP medicare site landing page DCE ulayer acq
When I access the acquisition DCE tool from home page DCE ulayer acq
And I delete the existing drug if present DCE ulayer acq
And I add the drug with Dosage and Quantity and frequency to the list DCE ulayer acq
|Drug|<drug>|
|Dosage|<dosage>|
|Quantity|<quantity>|
|Frequency|<frequency>|
Then I should see drug with Dosage and Quantity and frequency added to the list DCE ulayer acq
|Drug|<drug>|
|Dosage|<dosage>|
|Quantity|<quantity>|
|Frequency|<frequency>|
When I edit the drug with Dosage and Quantity and frequency DCE ulayer acq
|Drug|<drug>|
|EditDosage|<editdosage>|
|EditQuantity|<editquantity>|
|EditFrequency|<editfrequency>|
Then I should validate drug with Dosage and Quantity and frequency edited to the list DCE ulayer acq
|EditDosage|<editdosage>|
|EditQuantity|<editquantity>|
|EditFrequency|<editfrequency>|
When I delete the drug with Dosage DCE ulayer acq
|EditDosage|<editdosage>|
Then I should not see the drug with Dosage in the list DCE ulayer acq
|EditDosage|<editdosage>|
 
Examples:
 |drug|dosage|quantity|frequency|editdosage|editquantity|editfrequency|
 |Lipito|Lipitor TAB 10MG|30|Every 1 month|Lipitor TAB 20MG|60|Every 3 months|
 
 
 
##--------------------------------------------------------------------
@acq_drug_cost_estimator_disclaimer
Scenario: As a prospective member using the DCE tool on the M&R portal site, I want to be able to choose my dosage, package and frequency when assembling a drug list on either a desktop or mobile device so I can eventually choose a pharmacy and accurately estimate the cost of my drugs.
Given the user is on AARP medicare site landing page DCE ulayer acq
When I access the acquisition DCE tool from home page DCE ulayer acq
Then I should see all generic headers and elements DCE ulayer acq
And I should see step 1 disclaimers link at the bottom DCE ulayer acq
And I navigate to step2 page DCE ulayer acq
And I should see step 2 disclaimers link at the bottom DCE ulayer acq

@acq_drug_cost_estimator_pharmacy1
Scenario: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on AARP medicare site landing page DCE ulayer acq
When I access the acquisition DCE tool from home page DCE ulayer acq
Then I should see the Pharmacy search tab as a clickable element within the DCE tool DCE ulayer acq
And I should be able to move forward or backward in the tool flow DCE ulayer acq


@acq_drug_cost_estimator_ulayer_flow
Scenario Outline: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on AARP medicare site landing page DCE ulayer acq
When I access the acquisition DCE tool from home page DCE ulayer acq
And I have added a drug to my drug list DCE ulayer acq
|Drug|<drug>|
And I navigate to step2 page DCE ulayer acq
And the user selects the pharmacy tab information like miles, zipcode and pharmacy type DCE ulayer acq
| Zipcode	  | <zipcode> |
| Radius  | <radius>   |
And I select the first pharmacy DCE ulayer acq
And I navigate to step3 page DCE ulayer acq

 Examples:
| drug|zipcode| radius|
| Lipitor TAB 10MG| 90002 | 15miles |

@step3genericFlow 
Scenario Outline: To verify the Step 3 of DCE tool in AARP site from the generic flow
Given the user is on AARP medicare site landing page DCE ulayer acq
When I access the acquisition DCE tool from home page DCE ulayer acq
Then I navigate to step3 page DCE ulayer acq
And user validates the Summary DCE ulayer acq
And user validates the functionality of Drugs link DCE ulayer acq
And user validates the disclaimers DCE ulayer acq
And user searches with multi county zipcode and navigates to VPP page DCE ulayer acq
| Zip Code    | <zipcode>  |
| County      | <county>   |
Examples:
	| zipcode | county        |
	| 80516   | Weld County   |
	
@step3VPP
Scenario Outline: To verify the Step 3 of DCE tool in AARP site from VPP
Given the user is on AARP medicare site landing page DCE ulayer acq
When I access the acquisition DCE tool from vpp page using below zipcode DCE ulayer acq
| Zip Code    | <zipcode>  |
Then I navigate to step3 page DCE ulayer acq
And user validates the Summary DCE ulayer acq
And user validates the functionality of Drugs link DCE ulayer acq
And user validates the disclaimers DCE ulayer acq
And user validates the Costs link and functionality of Return to Plans button DCE ulayer acq

 Examples:
| zipcode|
| 90210 |

@acq_drug_cost_estimator_pharmacy2
Scenario Outline: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on AARP medicare site landing page DCE ulayer acq
#When I access the acquisition DCE tool from home page
When I access the acquisition DCE tool from vpp page using below zipcode DCE ulayer acq
| Zip Code    | <zipcode>  |
#And I have added a drug to my drug list DCE ulayer acq
#|Drug|<drug>|
And I navigate to step2 page DCE ulayer acq
And I select the Pharmacy type DCE ulayer acq
|Pharmacy Type1|<pharmacytype1>|
Then I should see pharmacy type radio button is selected DCE ulayer acq
|Pharmacy Type1|<pharmacytype1>|
And I select the Pharmacy type DCE ulayer acq
|Pharmacy Type2|<pharmacytype2>|
Then I should see pharmacy type radio button is selected DCE ulayer acq
|Pharmacy Type2|<pharmacytype2>|
And I select the Pharmacy type DCE ulayer acq
|Pharmacy Type3|<pharmacytype3>|
And I select the first pharmacy DCE ulayer acq

 Examples:
| zipcode|pharmacytype1|pharmacytype2|pharmacytype3|
| 90210 |Pharmacy Saver|Mail Service|Standard Network|


@acq_drug_cost_estimator_US628083
Scenario Outline: As a prospect who is using the DCE tool on the ULAYER, I want to be able to see the pharmacies that are available to me based on my zip code so I can choose a pharmacy to help me estimate my annual drug costs.
Given the user is on AARP medicare site landing page DCE ulayer acq
When I access the acquisition DCE tool from home page DCE ulayer acq
And I add the drug with Dosage and Quantity and frequency to the list DCE ulayer acq
|Drug|<drug>|
|Dosage|<dosage>|
|Quantity|<quantity>|
|Frequency|<frequency>|
And I navigate to step2 page DCE ulayer acq
#And I navigate to step2 page
And the user selects the pharmacy tab information like miles, zipcode and pharmacy type DCE ulayer acq 
| Zipcode	  | <zipcode> |
| Radius  | <radius>   |
Then I should see pharmacy list in nearest order DCE ulayer acq
And I should see map icons with index DCE ulayer acq
When I click on AtoZ tab DCE ulayer acq
Then I should see pharmacy in AtoZ order DCE ulayer acq
When I click on ZtoA tab DCE ulayer acq
Then I should see pharmacy in ZtoA order DCE ulayer acq

 Examples:
|drug|dosage|quantity|frequency|zipcode| radius|
 |Lipito|Lipitor TAB 20MG|30|Every 1 month| 90210 | 15miles |

#--------------------------------------------------
@acq_drug_cost_estimator_US580719
Scenario Outline: As a prospect who is using the DCE tool on the ULAYER, I want to be able to see the pharmacies that are available to me based on my zip code so I can choose a pharmacy to help me estimate my annual drug costs.
Given the user is on AARP medicare site landing page DCE ulayer acq
When I access the acquisition DCE tool from home page DCE ulayer acq
And I add the drug with Dosage and Quantity and frequency to the list DCE ulayer acq
|Drug|<drug>|
|Dosage|<dosage>|
|Quantity|<quantity>|
|Frequency|<frequency>|
And I navigate to step2 page DCE ulayer acq
And the user selects the pharmacy tab information like miles, zipcode and pharmacy type DCE ulayer acq
| Zipcode	  | <zipcode> |
| Radius  | <radius>   |
Then I should see Pagination under pharmacy list DCE ulayer acq
And I should able to move right and left using pagination DCE ulayer acq

 Examples:
 |drug|dosage|quantity|frequency|zipcode| radius|
 |Lipito|Lipitor TAB 20MG|30|Every 1 month|90210 | 15miles |
 


