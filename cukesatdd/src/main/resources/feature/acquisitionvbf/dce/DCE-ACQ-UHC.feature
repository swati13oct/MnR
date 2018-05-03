@acq_dce_UHC
Feature:1.24-VBF-Acq-Drug Cost Estimator (DCE) - To test DCE flows on UMS acq site

@acq_drug_cost_estimator_blayer_flow
Scenario Outline: To verify DCE flow from Blayer home page
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
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


@dceVppBlayer
Scenario Outline: To test the dce vpp flow
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
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
	
Examples:
| zipcode  |plantype |   drug   | 
| 90210    | MA 	 |Lipitor TAB 10MG|

@switchNowStep3Blayer
Scenario Outline: To test the dce vpp flow with switch now option
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
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
| zipcode  | plantype |   drug   | 
| 90210    |  MA 	  | Lipitor TAB 10MG|

@defect3312
Scenario Outline: To test Preferred Retail pharmacy type is there for Walgreens plan
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
When I access the vpp page using below zipcode on ums site
	| Zip Code    | <zipcode>  |
And I access the DCE tool
	|Plan Type | <plantype> |
And I have added a drug to my drug list on ums site
	|Drug|<drug>|
And I navigate to step2 page on ums site
Then I validate preferred retail pharmacy type is displayed

Examples:
| zipcode  | plantype |  drug   | 
| 90210    | PDP	  |Lipitor TAB 10MG|

#AEP period scenario that requires changing the year to 2017
@defect3255
Scenario Outline: To test Pharmacy Saver pharmacy type is displayed
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
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
#| 90210    | MA	  |Lipitor TAB 10MG|

@defect1662
Scenario Outline: To go through dce from homepage and validate drug is still there when going to dce from vpp
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
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

@dcevppblayer
Scenario Outline: To Verify the drugs and plan summary for non AEP period
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
When the user performs drug search using the following information in UMS site
	| Zip Code    | <zipcode>  |
	| County      | <county>   |
When the user search the drug using drug initials in UMS site
	| <drugInitials> |
Then the user validates the drug list that has above mentioned drug initials in UMS site
When the user selects following drug in UMS site
	| <drugName> |
Then the user validates the available drug information in UMS site
When the user selects the following dosage information in UMS site
	| Drug Dosage    | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And the user selects low cost options for above selected drug in UMS site
	| Generic Available | <genericAvailable> |
	| Brand or Generic  | <brand/generic>    |
Then the user validates all the drugs added in dce flow in UMS site
When the user search for pharmacies in dce flow in UMS site
Then the user validates the available pharmacies in the selected zipcode in UMS site
When the user selects the pharmacy type and distance in UMS site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
Then the user validates the available pharmacies based on selection made above in UMS site
When the user selects a pharmacy from the list of pharmacies in UMS site
	| <pharmacyName> |
Then the user validates the selected drug and selected pharmacy on manage drug list page in UMS site
And the user clicks Edit Pharmacy and validates Edit zipcode functionality and selects the pharmacy
And the user clicks Switch to generic and validates the drug page
When the user views plan results after selecting drug and pharmacy in UMS site
Then user validates plan count for all plan types on plan summary page in UMS site
When the user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in UMS site
And the user validates the plan summary for the below plan in UMS site
	| Plan Name | <planName> |
	
Examples:
	| zipcode | county              | drugInitials	|  drugName      |  drugDosage	       | quantity	| drugFrequency  | packages | genericAvailable	| brand/generic								| pharmacyType				| distance	| pharmacyName					| plantype	| planName						|
#	| 90210   |  Los Angeles County	| lipi       	| Lipitor        |  Lipitor TAB 20MG   |   40		| Every 3 Months | null     |	yes				| Lipitor TAB 20MG (Qty 40 Every 3 Months)	| Available Pharmacies		| 15 miles	| Garfield Pharmacy  			| MAPD		| AARP MedicareComplete SecureHorizons Plan 2 (HMO)	|
#	| 80002   |   Adams County      | lipi		    | Lipitor        |  Lipitor TAB 20MG   |   40		| Every 3 Months | null     |	yes				| Lipitor TAB 20MG (Qty 40 Every 3 Months)	| Available Pharmacies		| 15 miles	| Costco Pharmacy				| PDP		| AARP MedicareRx Preferred (PDP) | 

@dceVPPDrugsPlanAEP
Scenario Outline: To Verify the drugs and plan summary for AEP period 
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
When the user performs drug search using the following information in UMS site
	| Zip Code    | <zipcode>  |
	| County      | <county>   |
	| Plan Year   | <planYear> |
When the user search the drug using drug initials in UMS site
	| <drugInitials> |
Then the user validates the drug list that has above mentioned drug initials in UMS site
When the user selects following drug in UMS site
	| <drugName> |
Then the user validates the available drug information in UMS site
When the user selects the following dosage information in UMS site
	| Drug Dosage    | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And the user selects low cost options for above selected drug in UMS site
	| Generic Available | <genericAvailable> |
	| Brand or Generic  | <brand/generic>    |
Then the user validates all the drugs added in dce flow in UMS site
When the user search for pharmacies in dce flow in UMS site
Then the user validates the available pharmacies in the selected zipcode in UMS site
When the user selects the pharmacy type and distance in UMS site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
Then the user validates the available pharmacies based on selection made above in UMS site
When the user selects a pharmacy from the list of pharmacies in UMS site
	| <pharmacyName> |
Then the user validates the selected drug and selected pharmacy on manage drug list page in UMS site
When the user views plan results after selecting drug and pharmacy in UMS site
Then user validates plan count for all plan types on plan summary page in UMS site
When the user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in UMS site
And the user validates the plan summary for the below plan in UMS site
	| Plan Name | <planName> |

Examples:
	| zipcode | county              | drugInitials| drugName      |  drugDosage	      | drugQuantity | drugFrequency | packages | brand/generic                   | pharmacyType	 	 		  | distance   | pharmacyName        		| planName 					                           | planYear |
#	| 90210   |  Los Angeles County	| lipi	    |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 Month | null     | Lipitor TAB 10MG         | Available Pharmacies 	 | 15 miles	       |  CVS PHARMACY  		        | AARP MedicareComplete SecureHorizons Plan 2 (HMO)    | 2015     |
#	| 80002   |  Adams County       | lipi	    |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 Month | null     | Lipitor TAB 10MG         | Available Pharmacies 	 | 15 miles	       |  COSTCO PHARMACY 676 		    | AARP MedicareRx Preferred (PDP)    				   | 2015     | 

@dceVPPDrugsPlanNonAEP
Scenario Outline: To Verify the drugs and plan details for non AEP period 
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
When the user performs drug search using the following information in UMS site
	| Zip Code    | <zipcode>  |
	| County      | <county>   |
When the user search the drug using drug initials in UMS site
	| <drugInitials> |
Then the user validates the drug list that has above mentioned drug initials in UMS site
When the user selects following drug in UMS site
	| <drugName> |
Then the user validates the available drug information in UMS site
When the user selects the following dosage information in UMS site
	| Drug Dosage    | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And the user selects low cost options for above selected drug in UMS site
	| Generic Available | <genericAvailable> |
	| Brand or Generic  | <brand/generic>    |
Then the user validates all the drugs added in dce flow in UMS site
When the user search for pharmacies in dce flow in UMS site
Then the user validates the available pharmacies in the selected zipcode in UMS site
When the user selects the pharmacy type and distance in UMS site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
Then the user validates the available pharmacies based on selection made above in UMS site
When the user selects a pharmacy from the list of pharmacies in UMS site
	| <pharmacyName> |
Then the user validates the selected drug and selected pharmacy on manage drug list page in UMS site
When the user views plan results after selecting drug and pharmacy in UMS site
Then user validates plan count for all plan types on plan summary page in UMS site
When the user views plans of the below plan type in UMS site
	| Plan Type | <plantype> |
Then the user validates the available plans for selected plan types in UMS site
And the user validates the plan summary for the below plan in UMS site
	| Plan Name | <planName> |
When the user view plan details of the above selected plan in UMS site
Then the user validates the details of the selected plan in UMS site

Examples:
	| zipcode | county              | drugInitials	| drugName      |  drugDosage	      | quantity	| drugFrequency		| packages | genericAvailable	| brand/generic					| pharmacyType				| distance	| pharmacyName			| plantype	| planName						|
#	| 90210   |  Los Angeles County	| lipi       	| Lipitor        |  Lipitor TAB 20MG   |   40		| Every 3 Months | null     |	yes				| Lipitor TAB 20MG (Qty 40 Every 3 Months)	| Available Pharmacies		| 15 miles	| Garfield Pharmacy  			| MAPD		| AARP MedicareComplete SecureHorizons Plan 2 (HMO)	|
#	| 75244   |  Dallas County	| lipi       	| Lipitor        |  Lipitor TAB 20MG   |   40		| Every 3 Months | null     |	yes				| Lipitor TAB 20MG (Qty 40 Every 3 Months)	| Available Pharmacies		| 15 miles	| Downing Labs  			| MAPD		| AARP MedicareComplete SecureHorizons Plan 1 (HMO)	|
#	| 76270   | Montague County    | lipi	      |  Lipitor      |  Lipitor TAB 20MG   | 40       | Every 3 Months | null | yes              | Lipitor TAB 20MG (Qty 40 Every 3 Months) | Available Pharmacies  | 15 miles   |  CVS Pharmacy     | PDP      |    AARP MedicareRx Preferred (PDP)        |
#	| 80002   |  Adams County       | lipi		|  Lipitor      |  Lipitor TAB 20MG   |   40		| Every 3 Months	| null     |	yes		| Lipitor TAB 20MG (Qty 40 Every 3 Months)	| Available Pharmacies 		| 15 miles	| Costco Pharmacy		| PDP		| AARP MedicareRx Preferred (PDP) 	| 

@dceGenericFlow
Scenario Outline: To Verify the drugs and pharmacy model for new generic flow
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
When the user performs drug search using the following information in UMS site
	| Zip Code    | <zipcode>  |
	| County      | <county>   |
When the user search the drug using drug initials in UMS site
	| <drugInitials> |
Then the user validates the drug list that has above mentioned drug initials in UMS site
When the user selects following drug in UMS site
	| <drugName> |
Then the user validates the available drug information in UMS site
When the user selects the following dosage information in UMS site
	| Drug Dosage    | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And the user selects low cost options for above selected drug in UMS site
	| Generic Available | <genericAvailable> |
	| Brand or Generic  | <brand/generic>    |
Then the user validates all the drugs added in dce flow in UMS site
When the user search for pharmacies in dce flow in UMS site
Then the user validates the available pharmacies in the selected zipcode in UMS site
When the user selects the pharmacy type and distance in UMS site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
Then the user validates the available pharmacies based on selection made above in UMS site
When the user selects a pharmacy from the list of pharmacies in UMS site
	| <pharmacyName> |
Then the user validates the selected drug and selected pharmacy on manage drug list page in UMS site
When the user views plan results after selecting drug and pharmacy in UMS site
Then user validates plan count for all plan types on plan summary page in UMS site
Examples:
	| zipcode | county              | drugInitials	| drugName      |  drugDosage	      | quantity	| drugFrequency  | packages | genericAvailable	| brand/generic					| pharmacyType				| distance	| pharmacyName			| 
#	| 80002   | Adams County       | lipi		|  Lipitor      |  Lipitor TAB 20MG   |   40		| Every 3 Months | null     |	yes		| Lipitor TAB 20MG (Qty 40 Every 3 Months)	| Available Pharmacies 		| 15 miles	|  Costco Pharmacy		| 
	
@dceVppDrugsListPlanCost
Scenario Outline: To Verify the drug list and plan cost sections in View Plan Details page 
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
When the user performs drug search using the following information in UMS site
	| Zip Code    | <zipcode>  |
	| County      | <county>   |
And the user search for the drug in UMS site
	| <drugInitials> |
And the user selects the drug from the dropdown in UMS site
	| <drugName> |
And the user selects the following dosage information in UMS site
	| Drug Dosage    | <drugDosage>    |
	| Quantity       | <quantity>      |
	| Drug Frequency | <drugFrequency> |
	| Packages       | <packages>      |
And the user selects low cost options for the selected drug in UMS site
	| Generic Available | <genericAvailable> |
	| Brand or Generic  | <brand/generic>    |
And the user search for pharmacies in UMS site
And the user selects the type of pharmacy and distance in UMS site
	| Pharmacy Type | <pharmacyType> |
	| Distance      | <distance>     |
And the user selects a pharmacy in UMS site
	| <pharmacyName> |
And the user navigates to VPP page in UMS site
And the user selects the plan in UMS site
	| Plan Type | <plantype> |
Then the user view plan details of the selected plan in UMS site
	| Plan Name    | <planName> |
	|Error Message | <errorMessage> |
Examples:
	| zipcode | county             | drugInitials | drugName      |  drugDosage	        | packages | quantity | drugFrequency  | genericAvailable | brand/generic                            | pharmacyType	 	 	 | distance   |  pharmacyName       | plantype |planYear| planName 					            |errorMessage                                                                                                                                   |
#	| 76270   | Montague County    | lipi	      |  Lipitor      |  Lipitor TAB 20MG   | null     | 40       | Every 3 Months | yes              | Lipitor TAB 20MG (Qty 40 Every 3 Months) | Available Pharmacies  | 15 miles   |  CVS Pharmacy     | PDP      | 2016   |AARP MedicareRx Preferred (PDP)        |The pharmacy selected is not part of this plan's pharmacy network. Please edit your current pharmacy to estimate your drug costs for this plan.|
#	| 80002   |   Adams County      | lipi		    | Lipitor        |  Lipitor TAB 20MG   |  null | 40		| Every 3 Months |    	yes				| Lipitor TAB 20MG (Qty 40 Every 3 Months)	| Available Pharmacies		| 15 miles	| Costco Pharmacy				| PDP |2017		| AARP MedicareRx Preferred (PDP) | The pharmacy selected is not part of this plan's pharmacy network. Please edit your current pharmacy to estimate your drug costs for this plan.|

@dceOurPlansHover @US953320 @aprilRelease2018
Scenario Outline: To verify DCE flow from Blayer home page
Given the user is on the UHC medicare solutions site landing page
When fetch the data attributes in map form
When fetch the data attributes in row form
When I access the acquisition DCE tool from home page on ums site
And I hover or click on Our Plans in the top navigation and enter zipcode Blayer
| Zip Code    | <zipcode>  |
Then I should be directed to the VPP Plan Summary Page Blayer and I should see the Plan Count Overlay populated appropriately
Examples:
	| zipcode |
  | 90210   |
#| 30210   |
#| 10002   |
	