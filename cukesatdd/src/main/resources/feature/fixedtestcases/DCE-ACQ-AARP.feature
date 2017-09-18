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
When I access the vpp page using below zipcode on aarp site
	| Zip Code    | <zipcode>  |
And I access the DCE tool on aarp site
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
When I access the vpp page using below zipcode on aarp site
	| Zip Code    | <zipcode>  |
And I access the DCE tool on aarp site
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

@defect3235
Scenario Outline: To go through dce flow from prescription drugs tab and verify right message when clicked on add to compare
Given the user is on ulayer medicare acq site landing page
When I access the vpp page using below zipcode on aarp site
	|Zip Code| <zipcode> |
And I go to the view plan details page and access DCE flow from prescription drugs tab
	|Plan Name | <planname> |
	|Plan Type | <plantype> |
And I have added a drug to my drug list
	|Drug|<drug>|
And I navigate to step2 page
And I select the first pharmacy
And I navigate back to plan summary page
Then I navigate to view plan details page and click on add to compare box under prescription drugs tab and verify correct message
	|Plan Name | <planname> |
	|Plan Type | <plantype> |
Examples:
| zipcode  |   drug          | planname 										| plantype | 
| 33021    | Lipitor TAB 10MG|AARP MedicareComplete SecureHorizons Plan 1 (HMO) | MA	|

