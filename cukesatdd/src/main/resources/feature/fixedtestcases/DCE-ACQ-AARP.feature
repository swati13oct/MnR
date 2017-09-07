@acq_drug_cost_estimator
Feature:Drug Cost Estimator (DCE) - To test DCE flows on aarp acq site

@acq_drug_cost_estimator_ulayer_flow
Scenario Outline: To verify DCE flow from Ulayer home page
Given the user is on ulayer medicare acq site landing page
When I access the acquisition DCE tool from home page
And I have added a drug to my drug list
	|Drug|<drug>|
And I navigate to step2 page
And the user selects the pharmacy tab information like miles, zipcode and pharmacy type 
	| Zipcode	  | <zipcode> |
	| Radius  | <radius>   |
And I select the first pharmacy
And I navigate to step3 page and validate
	|Drug|<drug>|

 Examples:
| drug|zipcode| radius|
| Lipitor TAB 10MG| 90210 | 15miles |


@dceVppUlayer
Scenario Outline: To verify DCE flow from Ulayer Plan Summary page 
Given the user is on ulayer medicare acq site landing page
When I access the acquisition DCE tool from vpp page using below zipcode
	| Zip Code    | <zipcode>  |
And I have added a drug to my drug list
	|Drug|<drug>|
And I navigate to step2 page
And I select the first pharmacy
And I navigate to step3 page and validate
	|Drug|<drug>|
	
Examples:
| zipcode  |   drug   | 
| 90210    | Lipitor TAB 10MG|


@switchNowStep3
Scenario Outline: To test the switch now option in step 3
Given the user is on ulayer medicare acq site landing page
When I access the acquisition DCE tool from vpp page using below zipcode
	| Zip Code    | <zipcode>  |
And I have added a drug to my drug list
	|Drug|<drug>|
And I navigate to step2 page
And I select the first pharmacy
And I navigate to step3 page and validate
	|Drug|<drug>|
Then I switch to generic drug and validate
	
Examples:
| zipcode  |   drug          | 
| 90210    | Lipitor TAB 10MG| 