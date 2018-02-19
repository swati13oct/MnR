@theIncredibles
@acq_dce_UHC
Feature:Drug Cost Estimator (DCE) - HTML/CSS - Drug List - Edit/Delete Functionality


@acq_drug_cost_estimator_switch_to_generic1
Scenario Outline: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on UHC medicare site landing page DCE blayer acq
When I access the acquisition DCE tool from home page DCE blayer acq
And I have added a drug to my drug list and a generic equivalent is available for the drug I have selected DCE blayer acq
 	|Drug|<drug>|
Then I should be presented the option to switch to the generic option DCE blayer acq
And I have not yet selected pharmacy in generic flow DCE blayer acq
And I will see a SWITCH NOW link in the drug tile with appropriate save message DCE blayer acq
And I have selected pharmacy in generic flow DCE blayer acq
And I will see a SWITCH NOW link in the drug tile with appropriate save message DCE blayer acq
And I will see a modal appear upon clicking on SWITCH NOW DCE blayer acq
And when I click on the button to accept the generic DCE blayer acq
Then the drug name will automatically update within the Drug List DCE blayer acq

Examples:
 | drug |
 |lipitor|


@acq_drug_cost_estimator_switch_to_generic
Scenario Outline: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on UHC medicare site landing page DCE blayer acq
When I access the acquisition DCE tool from vpp page using below zipcode DCE blayer acq
| Zip Code    | <zipcode>  |
And I have added a drug to my drug list and a generic equivalent is available for the drug I have selected DCE blayer acq
 	|Drug|<drug>|
Then I should be presented the option to switch to the generic option DCE blayer acq
And I have not yet selected pharmacy DCE blayer acq
And I will see a SWITCH NOW link in the drug tile with appropriate save message DCE blayer acq
And I have selected pharmacy DCE blayer acq
And I will see a SWITCH NOW link in the drug tile with a pharmacy savings cost value DCE blayer acq
And I will see a modal appear upon clicking on SWITCH NOW DCE blayer acq
And when I click on the button to accept the generic DCE blayer acq
Then the drug name will automatically update within the Drug List DCE blayer acq
#And any cost savings will be applied to my total cost savings in Step3 DCE blayer acq

Examples:
|zipcode| drug |
|90210|lipitor|

@acq_drug_cost_estimator_blayer_flow
Scenario Outline: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on UHC medicare site landing page DCE blayer acq
When I access the acquisition DCE tool from vpp page using below zipcode DCE blayer acq
| Zip Code    | <zipcode>  |
And I have added a drug to my drug list DCE blayer acq
|Drug|<drug>|
And I navigate to step2 page DCE blayer acq
And the user selects the pharmacy tab information like miles, zipcode and pharmacy type DCE blayer acq
| Zipcode	  | <zipcode> |
| Radius  | <radius>   |
And I select the first pharmacy DCE blayer acq
And I navigate to step3 page from step 2 DCE blayer acq
And user validates the Summary, functionality of Drugs link, Costs link and functionality of Return to Plans button DCE blayer acq DCE blayer acq

 Examples:
| drug|zipcode| radius|
| Lipitor TAB 10MG| 90210 | 15miles |



@acq_drug_cost_estimator_disclaimer
Scenario: As a prospective member using the DCE tool on the M&R portal site, I want to be able to choose my dosage, package and frequency when assembling a drug list on either a desktop or mobile device so I can eventually choose a pharmacy and accurately estimate the cost of my drugs.
Given the user is on UHC medicare site landing page DCE blayer acq
When I access the acquisition DCE tool from home page DCE blayer acq
Then I should see all generic headers and elements DCE blayer acq
And I should see step 1 disclaimers link at the bottom DCE blayer acq
And I navigate to step2 page DCE blayer acq
And I should see step 2 disclaimers link at the bottom DCE blayer acq
And I navigate to step3 page DCE blayer acq



@acq_drug_cost_estimator_yearplan
Scenario: As a prospective member using the DCE tool on the M&R portal site, the user will be able to select option for 2017/2018 Plans
Given the user is on UHC medicare site landing page DCE blayer acq
When I access the acquisition DCE tool from home page DCE blayer acq
Then I should see plan year options which are clickable DCE blayer acq


