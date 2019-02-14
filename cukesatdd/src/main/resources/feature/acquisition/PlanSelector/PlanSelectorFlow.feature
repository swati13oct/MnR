Feature: Plan Selector Tool flow - Verify back to plan options navigation to plan selector page
@blayerPST @Spartans @acquisitionRegression
Scenario Outline: TID: 15471 -To validate Plan selector flow in UHC site
Given the user is on UHC medicare acquisition site landing page
When user goes to ours plan tab and click on Take the Quiz button 
And clicks on get started button and runs questionnaire
 |Zip Code| <zipcode> |
 | Is Multi County|  <isMultutiCounty> |
And I select my Response and go to Next Questionnaire
And I select my second Response and go directly to results page	
And I click plan detail button
Then the user clicks on both top and bottom back to plan options link and validates its redirection

Examples:
|zipcode|isMultutiCounty |
|90210  | NO             |


@UlayerPST @Spartans @acquisitionRegression
Scenario Outline: TID: 15474 - To validate Plan selector flow in AARP site
Given the user is on Acquisition AARP medicare site landing page
When user goes to ours plan tab and click on Take the Quiz button 
And clicks on get started button and runs questionnaire
 |Zip Code| <zipcode> |
 | Is Multi County|  <isMultutiCounty> |
And I select my Response and go to Next Questionnaire
And I select my second Response and go directly to results page	
And I click plan detail button
Then the user clicks on both top and bottom back to plan options link and validates its redirection

Examples:
|zipcode|isMultutiCounty |
|90210  | NO             |


@blayerPSTPlanSummary @Spartans @acquisitionRegression
Scenario Outline: TID: 15472 -To validate Plan selector flow from Plan Summary Page in UHC site
Given the user is on UHC medicare acquisition site landing page
When the user performs plan search using following information in UMS site
 | Zip Code    | <zipcode> |
 | County Name | <county>  |
 | Is Multi County|  <isMultutiCounty> | 
When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
When user scrolls down to Plan selector on VPP page on right rail widget
And clicks on get started button and runs questionnaire
 |Zip Code| <zipcode> |
 | CountyDropDown | <countyDropDown>  |
 | Is Multi County|  <isMultutiCounty> |
And I select my Response and go to Next Questionnaire
And I select my second Response and go directly to results page	
And I click plan detail button
Then the user clicks on both top and bottom back to plan options link and validates its redirection

Examples:
| zipcode |isMultutiCounty | county       | plantype | countyDropDown |
|78006    | YES            | Bexar County | MA   |Bexar, TX|