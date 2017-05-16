@acq_drug_cost_estimator
Feature:Drug Cost Estimator (DCE)  (Secondary/Tertiary Page) - HTML/CSS - Drug List - Edit/Delete Functionality
Scenario Outline: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on AARP medicare site landing page
When I access the acquisition DCE tool
And I have added a drug to my drug list and a generic equivalent is available for the drug I have selected
 	|Drug|<drug>|
#And I have not yet selected pharmacy
Then I should be presented the option to switch to the generic option
And I will see a SWITCH NOW link in the drug tile with appropriate save message
And I will see a modal appear upon clicking on SWITCH NOW
And when I click on the button to accept the generic
Then the drug name will automatically update within the Drug List

Examples:
 | drug |
 |lipitor|
 
#@acq_drug_cost_estimator_switch_to_generic
Scenario Outline: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on AARP medicare site landing page
When I access the acquisition DCE tool
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