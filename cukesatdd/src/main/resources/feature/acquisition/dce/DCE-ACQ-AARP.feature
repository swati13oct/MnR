@acq_drug_cost_estimator
Feature:1.23-VBF-Acq-Drug Cost Estimator (DCE) - To test DCE flows on aarp acq site

@acq_drug_cost_estimator_ulayer_flow @dceVBF
Scenario Outline: To verify DCE flow from Ulayer home page
Given the user is on AARP medicare acquisition site landing page
When I access the acquisition DCE tool from home page
And I have added a drug to my drug list
	|Drug|<drug>|
And I navigate to step2 page
And the user selects the pharmacy tab information like miles, zipcode and pharmacy type 
	| Zipcode	  | <zipcode> |
	| Radius  | <radius>   |
And I select the first pharmacy
And I navigate to step3 page and validate for DCE homepage flow
	|Drug|<drug>|

 Examples:
| drug|zipcode| radius|
| Lipitor TAB 10MG| 90210 | 15miles |


@switchNowStep3 @dceVBF
Scenario Outline: To test the DCE flow from vpp and the switch now option in step 3
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	| Zip Code    | <zipcode>  |
And I access the DCE tool on aarp site
	|Plan Type | <plantype> |
And I have added a drug to my drug list
	|Drug|<drug>|
And I navigate to step2 page
And I select the first pharmacy
And I navigate to step3 page and validate
	|Drug|<drug>|
Then I switch to generic drug and validate
	
Examples:
| zipcode  |   drug          | plantype |
| 90210    | LIPITOR TAB 10MG| MA|

@defect3235
Scenario Outline: To go through dce flow from prescription drugs tab and verify right message when clicked on add to compare
Given the user is on AARP medicare acquisition site landing page
When the user performs plan search using following information in the AARP site
	|Zip Code| <zipcode> |
And I go to the view plan details page and access DCE flow from prescription drugs tab
	|Plan Name | <planname> |
	|Plan Type | <plantype> |
And I have added a drug to my drug list
	|Drug|<drug>|
And I navigate to step2 page
And I select the first pharmacy
Then I navigate back to plan details page and verify correct message shows when clicked on compare check box
	
Examples:
| zipcode  |   drug          | planname 										| plantype | 
| 33021    | Lipitor TAB 10MG|AARP MedicareComplete Choice Plan 2 (Regional PPO) | MA	|

	
@dceMousehoverOurPlans @aprilRelease2018
@regressiontestcase-ATDDtags
Scenario Outline: To Mousehover on Our Plans tab from the DCE Page 
Given the user is on AARP medicare acquisition site landing page
When I access the acquisition DCE tool from home page
And I hover or click on Our Plans in the top navigation and enter zipcode Ulayer
| Zip Code    | <zipcode>  |
Then I should be directed to the VPP Plan Summary Page Ulayer and I should see the Plan Count Overlay populated appropriately
Examples:
	| zipcode |
  | 90210   |
 #| 30210   |
#| 10002   |
