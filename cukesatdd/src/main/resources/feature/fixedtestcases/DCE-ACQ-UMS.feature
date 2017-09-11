@acq_drug_cost_estimator_blayer
Feature:Drug Cost Estimator (DCE) - To test DCE flows on UMS acq site

@acq_drug_cost_estimator_blayer_flow
Scenario Outline: To verify DCE flow from Blayer home page
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
Scenario Outline: To test the dce vpp flow with switch now option
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

@defect1964
Scenario Outline: To test the compare plans message for MA plans
Given the user is on blayer medicare acq site landing page
When I access the vpp page
	|Zip Code| <zipcode> |
And I click on add to compare checkbox and click on view details link
Then I uncheck and recheck the compare box and verify the message and link exists

Examples:
|zipcode| 
|33012 | 

@defect1803
Scenario Outline: To test the compare plans message for MA plans
Given the user is on blayer medicare acq site landing page
When I access the vpp page
	|Zip Code| <zipcode> |
And I click on add to compare checkbox and click on view details link
Then I uncheck and go back to the vpp page to validate

Examples:
|zipcode| 
|33012 | 

@defect1970
Scenario Outline: To test the compare plans message for MA plans
Given the user is on blayer medicare acq site landing page
When I access the vpp page
	|Zip Code| <zipcode> |
And I select pdp plans and go to view details page
Then I check compare box and verify right info is shown

Examples:
|zipcode| 
|33012 | 