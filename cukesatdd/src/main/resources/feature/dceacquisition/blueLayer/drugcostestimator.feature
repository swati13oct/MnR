@acq_drug_cost_estimator_blayer
Feature:Drug Cost Estimator (DCE) - HTML/CSS - Drug List - Edit/Delete Functionality

@acq_drug_cost_estimator_flow
Scenario Outline: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on UHC medicare site landing page
When I access the acquisition DCE tool from vpp page using below zipcode
| Zip Code    | <zipcode>  |
And I have added a drug to my drug list
|Drug|<drug>|
And I navigate to step2 page
#And the user selects the pharmacy tab information like miles, zipcode and pharmacy type 
#| Zipcode	  | <zipcode> |
#| Radius  | <radius>   |
And I select the first pharmacy
And I navigate to step3 page
And user validates the Summary, functionality of Drugs link, Costs link and functionality of Return to Plans button

 Examples:
| drug|zipcode| radius|
| Lipitor TAB 10MG| 90210 | 15miles |


@acq_drug_cost_estimator_disclaimer
Scenario: As a prospective member using the DCE tool on the M&R portal site, I want to be able to choose my dosage, package and frequency when assembling a drug list on either a desktop or mobile device so I can eventually choose a pharmacy and accurately estimate the cost of my drugs.
Given the user is on UHC medicare site landing page
When I access the acquisition DCE tool from home page
Then I should see all generic headers and elements
And I should see step 1 disclaimers link at the bottom
And I navigate to step2 page
And I should see step 2 disclaimers link at the bottom
And I navigate to step3 page

@acq_drug_cost_estimator_yearplan
Scenario: As a prospective member using the DCE tool on the M&R portal site, the user will be able to select option for 2017/2018 Plans
Given the user is on UHC medicare site landing page
When I access the acquisition DCE tool from home page
Then I should see plan year options which are clickable


