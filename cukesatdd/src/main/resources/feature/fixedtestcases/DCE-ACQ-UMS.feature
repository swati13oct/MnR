@acq_drug_cost_estimator_blayer
Feature:Drug Cost Estimator (DCE) - To test DCE flows on UMS acq site

@acq_drug_cost_estimator_blayer_flow
Scenario Outline: As a prospective member using redesigned DCE tool on the M&R portal site on either a desktop or mobile device, I want to be able to choose a generic option if it is available from my Drug List and see any cost savings associated with it if I have selected a pharmacy so I can save on the cost of my prescription drugs.
Given the user is on blayer medicare acq site landing page
When I access the acquisition DCE tool from home page on ums site
And I have added a drug to my drug list on ums site
	|Drug|<drug>|
And I navigate to step2 page on ums site
And the user selects the pharmacy tab information
	| Zipcode	  | <zipcode> |
	| Radius  | <radius>   |
And I select the the first pharmacy on there
And I navigate to step3 page and validate the drug info
	|Drug|<drug>|

 Examples:
| drug|zipcode| radius|
| Lipitor TAB 10MG| 90210 | 15miles |


@dceVppBlayer
Scenario Outline: To test the dce vpp flow
Given the user is on blayer medicare acq site landing page
When I access the acquisition DCE tool from vpp page using below zipcode on ums site
	| Zip Code    | <zipcode>  |
And I have added a drug to my drug list on ums site
	|Drug|<drug>|
And I navigate to step2 page on ums site
And I select the first pharmacy on there
And I navigate to step3 page and validate the drug info
	|Drug|<drug>|
	
Examples:
| zipcode  |   drug   | 
| 90210    | Lipitor TAB 10MG|

@switchNowStep3Blayer
Scenario Outline: To test the dce vpp flow
Given the user is on blayer medicare acq site landing page
When I access the acquisition DCE tool from vpp page using below zipcode on ums site
	| Zip Code    | <zipcode>  |
And I have added a drug to my drug list on ums site
	|Drug|<drug>|
And I navigate to step2 page on ums site
And I select the first pharmacy on there
And I navigate to step3 page and validate the drug info
	|Drug|<drug>|
Then I switch to generic drug and validate on ums site
	
Examples:
| zipcode  |   drug   | 
| 90210    | Lipitor TAB 10MG|