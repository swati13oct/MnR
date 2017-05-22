@acq_drug_cost_estimator
Feature:Drug Cost Estimator (DCE) - HTML/CSS - Drug List - Edit/Delete Functionality

@acq_drug_cost_estimator_switch_to_generic1
Scenario Outline: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on AARP medicare site landing page
When I access the acquisition DCE tool from home page
And I have added a drug to my drug list and a generic equivalent is available for the drug I have selected
 	|Drug|<drug>|
And I have not yet selected pharmacy
Then I should be presented the option to switch to the generic option
And I will see a SWITCH NOW link in the drug tile with appropriate save message
And I will see a modal appear upon clicking on SWITCH NOW
And when I click on the button to accept the generic
Then the drug name will automatically update within the Drug List

Examples:
 | drug |
 |lipitor|
 
@acq_drug_cost_estimator_switch_to_generic
Scenario Outline: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on AARP medicare site landing page
When I access the acquisition DCE tool from home page
And I have added a drug to my drug list and a generic equivalent is available for the drug I have selected
 	|Drug|<drug>|
And I have selected pharmacy
Then I should be presented the option to switch to the generic option
And I will see a SWITCH NOW link in the drug tile with a pharmacy savings cost value
And I will see a modal appear upon clicking on SWITCH NOW 
And when I click on the button to accept the generic
Then the drug name will automatically update within the Drug List
#And any cost savings will be applied to my total cost savings in Step3

Examples:
| drug |
|lipitor|

@acq_drug_cost_estimator1
Scenario Outline: As a prospective member using the DCE tool on the M&R portal site, I want to be able to choose my dosage, package and frequency when assembling a drug list on either a desktop or mobile device so I can eventually choose a pharmacy and accurately estimate the cost of my drugs.
Given the user is on AARP medicare site landing page
When I access the acquisition DCE tool from home page
And I delete the existing drug if present
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
Then I should validate drug with Dosage and Quantity and frequency edited to the list
|EditDosage|<editdosage>|
|EditQuantity|<editquantity>|
|EditFrequency|<editfrequency>|
When I delete the drug with Dosage
|EditDosage|<editdosage>|
Then I should not see the drug with Dosage in the list 
|EditDosage|<editdosage>|
 
Examples:
 |drug|dosage|quantity|frequency|editdosage|editquantity|editfrequency|
 |Lipitor|Lipitor TAB 10MG|30|Every 1 month|Lipitor TAB 20MG|60|Every 3 months|
 
 
 
##--------------------------------------------------------------------
@acq_drug_cost_estimator_disclaimer
Scenario: As a prospective member using the DCE tool on the M&R portal site, I want to be able to choose my dosage, package and frequency when assembling a drug list on either a desktop or mobile device so I can eventually choose a pharmacy and accurately estimate the cost of my drugs.
Given the user is on AARP medicare site landing page
When I access the acquisition DCE tool from home page
Then I should see all generic headers and elements
And I should see step 1 disclaimers link at the bottom
And I navigate to step2 page
And I should see step 2 disclaimers link at the bottom

@acq_drug_cost_estimator_pharmacy1
Scenario: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on AARP medicare site landing page
When I access the acquisition DCE tool from home page
Then I should see the Pharmacy search tab as a clickable element within the DCE tool
And I should be able to move forward or backward in the tool flow 


@acq_drug_cost_estimator_flow
Scenario Outline: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on AARP medicare site landing page
When I access the acquisition DCE tool from home page
And I have added a drug to my drug list
|Drug|<drug>|
And I navigate to step2 page
And the user selects the pharmacy tab information like miles, zipcode and pharmacy type 
| Zipcode	  | <zipcode> |
| Radius  | <radius>   |
And I select the first pharmacy
And I navigate to step3 page

 Examples:
| drug|zipcode| radius|
| Lipitor TAB 10MG| 90002 | 15miles |

@step3genericFlow 
Scenario Outline: To verify the Step 3 of DCE tool in AARP site from the generic flow
Given the user is on AARP medicare site landing page
When I access the acquisition DCE tool from home page
Then I navigate to step3 page 
And user validates the Summary
And user validates the Drugs link
And user validates the Pharmacy link
And user validates the Find a Plan link
And user validates the disclaimers
And user searches with multi county zipcode and navigates to VPP page
| Zip Code    | <zipcode>  |
| County      | <county>   |

Examples:
	| zipcode | county        |
	| 80516   | Weld County   |

@acq_drug_cost_estimator_pharmacy2
Scenario Outline: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on AARP medicare site landing page
#When I access the acquisition DCE tool from home page
When I access the acquisition DCE tool from vpp page using below zipcode
| Zip Code    | <zipcode>  |
#And I have added a drug to my drug list
#|Drug|<drug>|
And I navigate to step2 page
And I select the Pharmacy type
|Pharmacy Type1|<pharmacytype1>|
Then I should see pharmacy type radio button is selected
|Pharmacy Type1|<pharmacytype1>|
And I select the Pharmacy type
|Pharmacy Type2|<pharmacytype2>|
Then I should see pharmacy type radio button is selected
|Pharmacy Type2|<pharmacytype2>|
And I select the Pharmacy type
|Pharmacy Type3|<pharmacytype3>|
And I select the first pharmacy

 Examples:
| zipcode|pharmacytype1|pharmacytype2|pharmacytype3|
| 90210 |Pharmacy Saver|Mail Service|Standard Network|


@acq_drug_cost_estimator_US628083
Scenario Outline: As a prospect who is using the DCE tool on the ULAYER, I want to be able to see the pharmacies that are available to me based on my zip code so I can choose a pharmacy to help me estimate my annual drug costs.
Given the user is on AARP medicare site landing page
When I access the acquisition DCE tool from home page
And I add the drug with Dosage and Quantity and frequency to the list
|Drug|<drug>|
|Dosage|<dosage>|
|Quantity|<quantity>|
|Frequency|<frequency>|
And I navigate to step2 page
#And I navigate to step2 page
And the user selects the pharmacy tab information like miles, zipcode and pharmacy type 
| Zipcode	  | <zipcode> |
| Radius  | <radius>   |
Then I should see pharmacy list in nearest order
And I should see map icons with index
When I click on AtoZ tab
Then I should see pharmacy in AtoZ order
When I click on ZtoA tab
Then I should see pharmacy in ZtoA order

 Examples:
|drug|dosage|quantity|frequency|zipcode| radius|
 |Lipitor|Lipitor TAB 10MG|30|Every 1 month| 90210 | 25miles |

#--------------------------------------------------
@acq_drug_cost_estimator_US580719
Scenario Outline: As a prospect who is using the DCE tool on the ULAYER, I want to be able to see the pharmacies that are available to me based on my zip code so I can choose a pharmacy to help me estimate my annual drug costs.
Given the user is on AARP medicare site landing page
When I access the acquisition DCE tool from home page
And I add the drug with Dosage and Quantity and frequency to the list
|Drug|<drug>|
|Dosage|<dosage>|
|Quantity|<quantity>|
|Frequency|<frequency>|
And I navigate to step2 page
And the user selects the pharmacy tab information like miles, zipcode and pharmacy type 
| Zipcode	  | <zipcode> |
| Radius  | <radius>   |
Then I should see Pagination under pharmacy list
And I should able to move right and left using pagination

 Examples:
 |drug|dosage|quantity|frequency|zipcode| radius|
 |Lipitor|Lipitor TAB 10MG|30|Every 1 month|90210 | 25miles |
 


