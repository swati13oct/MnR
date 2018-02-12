@acq_drug_cost_estimator_blayer
Feature: Drug Cost Estimator (DCE) - To test DCE flows on UMS acq site

@UHC_DCEVPP_ZipcodeRadius
Scenario Outline: To verify DCE flow from Blayer home page
Given the user is on blayer medicare acq site landing page
When I access the acquisition DCE tool from home page on ums site
And I have added a drug to my drug list on ums site
	|Drug|<drug>|
And I navigate to step2 page on ums site
And the user selects the pharmacy tab information
	| Zipcode	  | <zipcode> |
	| Radius  | <radius>   |
And I select the first pharmacy on there
And I navigate to step3 page and validate the drug info
	|Drug|<drug>|
Examples:
| drug|zipcode| radius|
| Lipitor TAB 10MG| 90210 | 15miles |

@UHC_DCEVPP_Zipcode
Scenario Outline: To test the dce vpp flow
Given the user is on blayer medicare acq site landing page
When I access the vpp page using below zipcode on ums site
	| Zip Code    | <zipcode>  |
And I access the DCE tool
	|Plan Type | <plantype> |
And I have added a drug to my drug list on ums site
	|Drug|<drug>|
And I navigate to step2 page on ums site
And I select the first pharmacy on there
And I navigate to step3 page and validate the drug info
	|Drug|<drug>|	
Then I switch to generic drug and validate on ums site
Examples:
| zipcode  |plantype |   drug   | 
| 90210    | MA 	 |Lipitor TAB 10MG|

@UHC_DCEVPP_PrefRetail
Scenario Outline: To test Preferred Retail pharmacy type is there for Walgreens plan
Given the user is on blayer medicare acq site landing page
When I access the vpp page using below zipcode on ums site
	| Zip Code    | <zipcode>  |
And I choose the 2017 plan and go to DCE page
	|Plan Type | <plantype> |
And I have added a drug to my drug list on ums site
	|Drug|<drug>|
And I navigate to step2 page on ums site
Then I validate preferred retail pharmacy type is displayed

Examples:
| zipcode  | plantype |  drug   | 
| 90210    | PDP	  |Lipitor TAB 10MG|

@UHC_DCEVPP_PrefSaver
Scenario Outline: To test Pharmacy Saver pharmacy type is displayed
Given the user is on blayer medicare acq site landing page
When I access the vpp page using below zipcode on ums site
	| Zip Code    | <zipcode>  |
And I choose the 2017 plan and go to DCE page
	|Plan Type | <plantype> |
And I have added a drug to my drug list on ums site
	|Drug|<drug>|
And I navigate to step2 page on ums site
Then I validate pharmacy saver pharmacy type is displayed	

Examples:
| zipcode  | plantype |  drug   | 
| 90210    | MA	  |Lipitor TAB 10MG|

@UHC_DCEGeneric
Scenario Outline: To go through dce from homepage and validate drug is still there when going to dce from vpp
Given the user is on blayer medicare acq site landing page
When I access the acquisition DCE tool from home page on ums site
And I have added a drug to my drug list on ums site
	|Drug|<drug>|
And the user selects the pharmacy tab information
	| Zipcode	  | <zipcode> |
	| Radius  | <radius>   |
And I select the first pharmacy on there
And I click on the return link
When I access the vpp page using below zipcode on ums site
	| Zip Code    | <zipcode>  |
And I access the DCE tool after adding drug
	|Plan Type | <plantype> |
Then I verify that the drug is still there
	|Drug|<drug>|

 Examples:
| drug|zipcode| radius|	plantype |
| Lipitor TAB 10MG| 90210 | 15miles | MA |