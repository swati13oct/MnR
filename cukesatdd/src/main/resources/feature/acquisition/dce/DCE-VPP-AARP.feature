@fixedTestCaseDCEVPP
Feature: To test DCE to VPP plan Summary flow  in AARP site

@dceThroughPlanSummaryNonAepAARP @aarp @regressionMember @dce1 @aarpDce
Scenario Outline: To Verify the drug cost estimator flow for <planName> for non AEP periodthrough plan summary
Given the user is on the AARP medicare site landing page
When user performs plan search using following information in the AARP site
               | Zip Code    | <zipcode>  |
               | County      | <county>   |
And user access DCE tool on aarp site
	|Plan Type | <plantype> |
	| PlanName       | <planName>      |
Then user adds drug to drug cost estimator flow for the given plan name in AARP site
	  | PlanName       | <planName>      |
      | Drug Name1     | <drugName1>     |
And selects drug details in ums site
	  | Drug Name1     | <drugName1>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
When user successfully adds drug in the ums site
	  | Drug Name1     | <drugName1>     |
Then user adds drug to drug cost estimator flow for the given plan name in AARP site
	  | PlanName       | <planName>      |
      | Drug Name2     | <drugName2>     |
And selects drug details for other drugs in ums site
	  | Drug Name2     | <drugName2>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
Then user adds drug to drug cost estimator flow for the given plan name in AARP site
	  | PlanName       | <planName>      |
      | Drug Name3     | <drugName3>     |	  
And selects drug details in ums site
	  | Drug Name3     | <drugName3>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
When user successfully adds drug in the ums site
	  | Drug Name3     | <drugName3>     |  
Then user adds drug to drug cost estimator flow for the given plan name in AARP site
	  | PlanName       | <planName>      |
      | Drug Name4     | <drugName4>     |
And selects drug details for other drugs in ums site
	  | Drug Name4     | <drugName4>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
Then user adds drug to drug cost estimator flow for the given plan name in AARP site
	  | PlanName       | <planName>      |
      | Drug Name5     | <drugName5>     |	
And selects drug details for other drugs in ums site
	  | Drug Name5     | <drugName5>     |	
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|  
Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
When the user selects the pharmacy type and distance in AARP site
       | Pharmacy Type | <pharmacyType> |
       | Distance      | <distance>     |
Then the user selects a pharmacy from the list of pharmacies in AARP site
             | Pharmacy Name | <pharmacyName> |
Then the user validates the added drugs on See your Estimated Costs page in AARP site
	  | Drug Name1     | <drugName1>     |
      | Drug Name2     | <drugName2>     |
      | Drug Name3     | <drugName3>     |
      | Drug Name4     | <drugName4>     |
      | Drug Name5     | <drugName5>     |
When the user clicks on Edit Drug List link in AARP site
Then Enter your drugs page is displayed to the user in AARP site
Then User click on Switch now to select the Generic of the Brand drug added in AARP site
Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
Then the user change the pharmacy type and select new pharmacy in AARP site
               | New Pharmacy Type | <newPharmacyType> |
Then the user validates the added drugs on See your Estimated Costs page in AARP site
	  | Drug Name1     | <genericName1>     |
      | Drug Name2     | <drugName2>     |
      | Drug Name3     | <genricName3>     |
      | Drug Name4     | <drugName4>     |
      | Drug Name5     | <drugName5>     |
And the user clicks on Back to Plans button in AARP site
Then user validates Drug information is reflected on plan summary page in AARP site
 | PlanName       | <planName>      |
#Test ID: 15616,15617,15618
Examples:
             	| zipcode | county             | drugInitials1       | drugName1     | drugInitials2 | drugName2  | drugInitials3 | drugName3     | drugInitials4 | drugName4 | drugInitials5 | drugName5             | pharmacyType                 | distance   |  pharmacyName               | plantype | planName                                           | quantity | frequency   |newPharmacyType|genericName1|genricName3|
              	| 90210   | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network             | 15 miles   |  MEN'S HEALTH FOUNDATION    | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | 30       |Every 1 month|Mail Service   |atorvastatin |fluticasone|
                | 90210   | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network             | 15 miles   |  Men's Health Foundation    | PDP      | AARP MedicareRx Walgreens (PDP)                    | 30       |Every 1 month|Mail Service   |atorvastatin |fluticasone|
                | 78002    | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network             | 15 miles   |  HEB PHARMACY 019    | SNP      | UnitedHealthcare Chronic Complete (HMO SNP)        | 30       |Every 1 month|Mail Service   |atorvastatin |fluticasone|
               
@dceThroughPlanDetailsAARP @aarp @regressionMember @dce2 @aarpDce
Scenario Outline: To Verify the drug cost estimator flow for <plantype> through plan details page's Prescription Drug Benefits tab
Given the user is on the AARP medicare site landing page
When user performs plan search using following information in the AARP site
               | Zip Code    | <zipcode>  |
               | County      | <county>   |
Then the user navigates to the plan details for the given plan type in AARP site
               | Plan Type | <plantype> |
               |Plan Name  |<planName>  |
Then the user navigates to Presciption Drug Benefits tab in AARP site
Then user adds drug to drug cost estimator flow for the given plan name in AARP site
	  | PlanName       | <planName>      |
      | Drug Name1     | <drugName1>     |
And selects drug details in ums site
	  | Drug Name1     | <drugName1>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
When user successfully adds drug in the ums site
	  | Drug Name1     | <drugName1>     |
Then user adds drug to drug cost estimator flow for the given plan name in AARP site
	  | PlanName       | <planName>      |
      | Drug Name2     | <drugName2>     |
And selects drug details for other drugs in ums site
	  | Drug Name2     | <drugName2>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
Then user adds drug to drug cost estimator flow for the given plan name in AARP site
	  | PlanName       | <planName>      |
      | Drug Name3     | <drugName3>     |	  
And selects drug details in ums site
	  | Drug Name3     | <drugName3>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
When user successfully adds drug in the ums site
	  | Drug Name3     | <drugName3>     |  
Then user adds drug to drug cost estimator flow for the given plan name in AARP site
	  | PlanName       | <planName>      |
      | Drug Name4     | <drugName4>     |
And selects drug details for other drugs in ums site
	  | Drug Name4     | <drugName4>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
Then user adds drug to drug cost estimator flow for the given plan name in AARP site
	  | PlanName       | <planName>      |
      | Drug Name5     | <drugName5>     |	
And selects drug details for other drugs in ums site
	  | Drug Name5     | <drugName5>     |	
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|  
Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
When the user selects the pharmacy type and distance in AARP site
       | Pharmacy Type | <pharmacyType> |
       | Distance      | <distance>     |
Then the user selects a pharmacy from the list of pharmacies in AARP site
             | Pharmacy Name | <pharmacyName> |
Then the user validates the added drugs on See your Estimated Costs page in AARP site
	  | Drug Name1     | <drugName1>     |
      | Drug Name2     | <drugName2>     |
      | Drug Name3     | <drugName3>     |
      | Drug Name4     | <drugName4>     |
      | Drug Name5     | <drugName5>     |
When the user clicks on Edit Drug List link in AARP site
Then Enter your drugs page is displayed to the user in AARP site
Then User click on Switch now to select the Generic of the Brand drug added in AARP site
Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
Then the user change the pharmacy type and select new pharmacy in AARP site
               | New Pharmacy Type | <newPharmacyType> |
Then the user validates the added drugs on See your Estimated Costs page in AARP site
	  | Drug Name1     | <genericName1>  |
      | Drug Name2     | <drugName2>     |
      | Drug Name3     | <genricName3>   |
      | Drug Name4     | <drugName4>     |
      | Drug Name5     | <drugName5>     |
And the user clicks on Back to Plans button on See Your Estimated Costs page in AARP site
And user verifies annual drug cost in the prescription drug tab of AARP site
	| Plan Type | <plantype> |
And the user clicks on Back to All Plans button present on details page in AARP site
Then user validates Drug information is reflected on plan summary page in AARP site
 | PlanName       | <planName>      |

#Test ID: 15619,15620,15621
Examples:
               | zipcode | county             | drugInitials1       | drugName1     | drugInitials2 | drugName2  | drugInitials3 | drugName3     | drugInitials4 | drugName4 | drugInitials5 | drugName5             | pharmacyType                 | distance   |  pharmacyName               | plantype | planName                                           | quantity | frequency   |newPharmacyType|genericName1|genricName3|
               | 90210   | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network             | 15 miles   |  MEN'S HEALTH FOUNDATION    | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | 30       |Every 1 month|Mail Service   |atorvastatin |fluticasone|
               | 90210   | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network             | 15 miles   |  Men's Health Foundation    | PDP      | AARP MedicareRx Walgreens (PDP)                    | 30       |Every 1 month|Mail Service   |atorvastatin |fluticasone|
               | 78002  | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network             | 15 miles   |  HEB PHARMACY 019   | SNP      | UnitedHealthcare Chronic Complete (HMO SNP)        | 30       |Every 1 month|Mail Service   |atorvastatin |fluticasone|
               

               
@dceThroughPlanDetailsAARP @aarp @regressionMember @dce3 @aarpDce
Scenario Outline: To Verify the drug cost estimator flow for <plantype> through plan details page's Plan Costs tab
Given the user is on the AARP medicare site landing page
When user performs plan search using following information in the AARP site
               | Zip Code    | <zipcode>  |
               | County      | <county>   |
Then the user navigates to the plan details for the given plan type in AARP site
               | Plan Type | <plantype> |
               |Plan Name  |<planName>  |
Then the user navigates to Plan Costs tab in AARP site
Then user adds drug to drug cost estimator flow for the given plan name in AARP site
	  | PlanName       | <planName>      |
      | Drug Name1     | <drugName1>     |
And selects drug details in ums site
	  | Drug Name1     | <drugName1>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
When user successfully adds drug in the ums site
	  | Drug Name1     | <drugName1>     |
Then user adds drug to drug cost estimator flow for the given plan name in AARP site
	  | PlanName       | <planName>      |
      | Drug Name2     | <drugName2>     |
And selects drug details for other drugs in ums site
	  | Drug Name2     | <drugName2>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
Then user adds drug to drug cost estimator flow for the given plan name in AARP site
	  | PlanName       | <planName>      |
      | Drug Name3     | <drugName3>     |	  
And selects drug details in ums site
	  | Drug Name3     | <drugName3>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
When user successfully adds drug in the ums site
	  | Drug Name3     | <drugName3>     |  
Then user adds drug to drug cost estimator flow for the given plan name in AARP site
	  | PlanName       | <planName>      |
      | Drug Name4     | <drugName4>     |
And selects drug details for other drugs in ums site
	  | Drug Name4     | <drugName4>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
Then user adds drug to drug cost estimator flow for the given plan name in AARP site
	  | PlanName       | <planName>      |
      | Drug Name5     | <drugName5>     |	
And selects drug details for other drugs in ums site
	  | Drug Name5     | <drugName5>     |	
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|  
Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
When the user selects the pharmacy type and distance in AARP site
       | Pharmacy Type | <pharmacyType> |
       | Distance      | <distance>     |
Then the user selects a pharmacy from the list of pharmacies in AARP site
             | Pharmacy Name | <pharmacyName> |
Then the user validates the added drugs on See your Estimated Costs page in AARP site
	  | Drug Name1     | <drugName1>     |
      | Drug Name2     | <drugName2>     |
      | Drug Name3     | <drugName3>     |
      | Drug Name4     | <drugName4>     |
      | Drug Name5     | <drugName5>     |
When the user clicks on Edit Drug List link in AARP site
Then Enter your drugs page is displayed to the user in AARP site
Then User click on Switch now to select the Generic of the Brand drug added in AARP site
Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
Then the user change the pharmacy type and select new pharmacy in AARP site
               | New Pharmacy Type | <newPharmacyType> |
Then the user validates the added drugs on See your Estimated Costs page in AARP site
	  | Drug Name1     | <genericName1>     |
      | Drug Name2     | <drugName2>     |
      | Drug Name3     | <genricName3>     |
      | Drug Name4     | <drugName4>     |
      | Drug Name5     | <drugName5>     |
And the user clicks on Back to Plans button on See Your Estimated Costs page in AARP site
And user verifies annual drug cost in the Plan Cost tab of AARP site
	  | Plan Type | <plantype> |
And the user clicks on Back to All Plans button present on details page in AARP site
Then user validates Drug information is reflected on plan summary page in AARP site
 | PlanName       | <planName>      |
#Test ID: 15623, 15624, 15625 : Few scenario's are left to be covered
Examples:
               | zipcode | county             | drugInitials1       | drugName1     | drugInitials2 | drugName2  | drugInitials3 | drugName3     | drugInitials4 | drugName4 | drugInitials5 | drugName5             | pharmacyType                 | distance   |  pharmacyName               | plantype | planName                                           | quantity | frequency   |newPharmacyType|genericName1|genricName3|
               | 90210   | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network             | 15 miles   |  MEN'S HEALTH FOUNDATION    | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | 30       |Every 1 month|Mail Service   |atorvastatin |fluticasone|
               | 90210   | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network             | 15 miles   |  Men's Health Foundation    | PDP      | AARP MedicareRx Walgreens (PDP)                    | 30       |Every 1 month|Mail Service   |atorvastatin |fluticasone|
               | 78002    | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network             | 15 miles   |  HEB PHARMACY 019   | SNP      | UnitedHealthcare Chronic Complete (HMO SNP)        | 30       |Every 1 month|Mail Service   |atorvastatin |fluticasone|
               
######################################################################################################
######################################################################################################



#@dceVppNonAepAARP
#Scenario Outline: To Verify the drugs and plan summary for non AEP period 
#Given the user is on the AARP medicare site landing page
#When the user performs plan search using following information in the AARP site
#	| Zip Code    | <zipcode>  |
#	| County      | <county>   |
#When the user search the drug using drug initials in AARP site
#	| <drugInitials> |
#Then the user validates the drug list that has above mentioned drug initials in AARP site
#When the user selects following drug in AARP site
#	| <drugName> |
#Then the user validates the available drug information in AARP site
#When the user selects the following dosage information in AARP site
#	| Drug Dosage    | <drugDosage>    |
#	| Quantity       | <quantity>      |
#	| Drug Frequency | <drugFrequency> |
#	| Packages       | <packages>      |
#And the user selects low cost options for above selected drug in AARP site
#	| Generic Available | <genericAvailable> |
#	| Brand or Generic  | <brand/generic>    |
#Then the user validates all the drugs added in dce flow in AARP site
#When the user search for pharmacies in dce flow in AARP site
#Then the user validates the available pharmacies in the selected zipcode in AARP site
#When the user selects the pharmacy type and distance in AARP site
#	| Pharmacy Type | <pharmacyType> |
#	| Distance      | <distance>     |
#Then the user validates the available pharmacies based on selection made above in AARP site
#When the user selects a pharmacy from the list of pharmacies in AARP site
#	| <pharmacyName> |
#Then the user validates the selected drug and selected pharmacy on manage drug list page in AARP site
#When the user views plan results after selecting drug and pharmacy in AARP site
#Then user validates plan count for all plan types on plan summary page in AARP site
#When the user views plans of the below plan type in the AARP site
#	| Plan Type | <plantype> |
#Then the user validates the available plans for selected plan types in AARP site
#And the user validates the plan summary for the below plan in the AARP site
#	| Plan Name | <planName> |
#Examples:
#	| zipcode | county             | drugInitials | drugName      |  drugDosage	    | packages                                          | quantity | drugFrequency  | genericAvailable | brand/generic                            | pharmacyType	 	| distance   |  pharmacyName		   | plantype | planName 					   |
#	| 90210   | Los Angeles County | lipi	      |  Lipitor      |  Lipitor TAB 20MG   | null                                              | 40       | Every 3 months | yes              | Lipitor TAB 20MG (Qty 40 Every 3 Months) | Available Pharmacies	| 15 miles   |  Men's Health Foundation    | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |
#
#@dceVppAepAARP
#Scenario Outline: To Verify the drugs and plan summary for AEP period 
#Given the zipcode and county information DCE to Vpp Plan summary flow in AARP site
#	| Zip Code    | <Zipcode>  |
#	| County      | <county>   |
#	| Plan Year   | <planYear> |
#When user search the drug using drug initials in AARP site
#	| <drugInitials> |
#And user access the drug list having 5 drugs in AARP site
#And the user selects following drug in AARP site
#	| <drugName> |
#And user selects the following dosage information in AARP site
#	| Drug Dosage    | <drugDosage>    |
#	| Drug Quantity  | <drugQuantity>  |
#	| Drug Frequency | <drugFrequency> |
#	| Packages       | <packages>      |	
#And the user selects the low cost options in AARP site
#	| <brand/generic> |
#And user views all the drugs added in AARP site
#And user performs the pharmacy search in AARP site
#And user selects the pharmacy type and distance in AARP site
#	| Pharmacy Type | <pharmacyType> |
#	| Distance      | <distance>     |
#And user views the list of pharmacies available in AARP site
#And user selects a pharmacy from the list of pharmacies in AARP site
#	| <pharmacyName> |
#And user views the plan results in AARP site
#Then user views the plan summary for the following plan in AARP site
#	| <planName> |
#Examples:
#	| Zipcode | county              | drugInitials| drugName      |  drugDosage	        | drugQuantity | drugFrequency | packages | brand/generic            | pharmacyType	 	 		 	 | distance   | pharmacyName        		| planName 					                           | planYear |
#	| 90210   | Los Angeles County  | lipi	      |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 			| 15 miles	       		|  CVS PHARMACY  				| AARP MedicareComplete SecureHorizons Plan 2 (HMO)    | 2015     |
#	| 80002   | Adams County        | lipi	      |  Lipitor      |  Lipitor TAB 10MG   |    30        | Every 1 month | null     | Lipitor TAB 10MG         | Standard Network Pharmacy 	 			| 15 miles	       		|  COSTCO PHARMACY 676 			| AARP MedicareRx Preferred (PDP)    | 2015     |
#
#@dceVppNonAepDrugsPlanDetailsAARP
#Scenario Outline: To Verify the drugs and plan details for non AEP period 
#Given the user is on the AARP medicare site landing page
#When the user performs drug search using the following information in AARP site
#	| Zip Code    | <zipcode>  |
#	| County      | <county>   |
#When the user search the drug using drug initials in AARP site
#	| <drugInitials> |
#Then the user validates the drug list that has above mentioned drug initials in AARP site
#When the user selects following drug in AARP site
#	| <drugName> |
#Then the user validates the available drug information in AARP site
#When the user selects the following dosage information in AARP site
#	| Drug Dosage    | <drugDosage>    |
#	| Quantity       | <quantity>      |
#	| Drug Frequency | <drugFrequency> |
#	| Packages       | <packages>      |
#And the user selects low cost options for above selected drug in AARP site
#	| Generic Available | <genericAvailable> |
#	| Brand or Generic  | <brand/generic>    |
#Then the user validates all the drugs added in dce flow in AARP site
#When the user search for pharmacies in dce flow in AARP site
#Then the user validates the available pharmacies in the selected zipcode in AARP site
#When the user selects the pharmacy type and distance in AARP site
#	| Pharmacy Type | <pharmacyType> |
#	| Distance      | <distance>     |
#Then the user validates the available pharmacies based on selection made above in AARP site
#When the user selects a pharmacy from the list of pharmacies in AARP site
#	| <pharmacyName> |
#Then the user validates the selected drug and selected pharmacy on manage drug list page in AARP site
#When the user views plan results after selecting drug and pharmacy in AARP site
#Then user validates plan count for all plan types on plan summary page in AARP site
#When the user views plans of the below plan type in the AARP site
#	| Plan Type | <plantype> |
#Then the user validates the available plans for selected plan types in AARP site
#And the user validates the plan summary for the below plan in the AARP site
#	| Plan Name | <planName> |
#When the user view plan details of the above selected plan in the AARP site
#Then the user validates the details of the selected plan in AARP site
#Examples:
#	| zipcode | county             | drugInitials | drugName      |  drugDosage	        | packages                                          | quantity | drugFrequency  | genericAvailable | brand/generic    | pharmacyType	 	 		| distance   |  pharmacyName             | plantype | planName 				|
#	| 80002   | Adams County       | rest	      |  Restasis     |  Restasis EMU 0.05%	| Plastic Container of 1.0(sold in a package of 60) | 2        | Every 3 months | no               | null             | Available Pharmacies			| 15 miles   |  Sams Pharmacy 10-6630    | PDP      | AARP MedicareRx Preferred (PDP)	| 
#
#@dceVppNonAepDrugsWaysToSaveAARP
#Scenario Outline: To Verify the drugs and ways to save options for non AEP period 
#Given the user is on the AARP medicare site landing page
#When the user performs drug search using the following information in AARP site
#	| Zip Code    | <zipcode>  |
#	| County      | <county>   |
#When the user search the drug using drug initials in AARP site
#	| <drugInitials> |
#Then the user validates the drug list that has above mentioned drug initials in AARP site
#When the user selects following drug in AARP site
#	| <drugName> |
#Then the user validates the available drug information in AARP site
#When the user selects the following dosage information in AARP site
#	| Drug Dosage    | <drugDosage>    |
#	| Quantity       | <quantity>      |
#	| Drug Frequency | <drugFrequency> |
#	| Packages       | <packages>      |
#And the user selects low cost options for above selected drug in AARP site
#	| Generic Available | <genericAvailable> |
#	| Brand or Generic  | <brand/generic>    |
#Then the user validates all the drugs added in dce flow in AARP site
#When the user search for pharmacies in dce flow in AARP site
#Then the user validates the available pharmacies in the selected zipcode in AARP site
#When the user selects the pharmacy type and distance in AARP site
#	| Pharmacy Type | <pharmacyType> |
#	| Distance      | <distance>     |
#Then the user validates the available pharmacies based on selection made above in AARP site
#When the user selects a pharmacy from the list of pharmacies in AARP site
#	| <pharmacyName> |
#Then the user validates the selected drug and selected pharmacy on manage drug list page in AARP site
#When the user views plan results after selecting drug and pharmacy in AARP site
#Then user validates plan count for all plan types on plan summary page in AARP site
#When the user views plans of the below plan type in the AARP site
#	| Plan Type | <plantype> |
#Then the user validates the available plans for selected plan types in AARP site
#And the user validates the plan summary for the below plan in the AARP site
#	| Plan Name | <planName> |
#When the user view plan details of the above selected plan in the AARP site
#Then the user validates the details of the selected plan in AARP site
#When the user view available options to save on drugs in AARP site
#Then the user validates the available options to save on drug in AARP site
#When the user views reduce costs on the selected drug in AARP site
#Then the user validates the savings available for generic drug of the selected drug in AARP site
#When the user switches to generic drug in AARP site
#	| <genericDrugName> |
#Then the user validates the updated costs in manage drug page in AARP site
#When the user applies changes made in AARP site
#Then the user validates the plan details of the above selected plan after switching to generic drug in AARP site
# Examples:
#	| zipcode | county             | drugInitials | drugName           |  drugDosage	                  | packages                            | quantity | drugFrequency  | genericAvailable | brand/generic                                           | pharmacyType	 	 	        | distance   |  pharmacyName		| plantype | planName 						| genericDrugName							 |
####	| 30002   | DeKalb County      | depo	      | Depo-Provera 150MG |  Depo-Provera 150MG INJ 150MG/ML | 1.0ML Syringe(sold in a package of 1)	| 10       | Every 3 months | yes              | Depo-Provera 150MG INJ 150MG/ML (Qty 10 Every 3 Months) | Preferred Mail Service Pharmacy	| 15 miles   |  null			| MAPD     | AARP MedicareComplete Plan 2 (HMO)			| medroxyprogesterone acetate IM INJ 150MG_ML (Qty 10 Every 3 Months)	 |
#	| 90210   | Los Angeles County | lipi	      |  Lipitor	   |  Lipitor TAB 20MG			  | null                                | 40       | Every 3 months | yes              | Lipitor TAB 20MG (Qty 40 Every 3 Months)		 | Available Pharmacies			| 15 miles   |  Men's Health Foundation | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | atorvastatin calcium TAB 20MG (Qty 40 Every 3 Months)			 |
#	
#@dceVPPToolTipsAARP
#Scenario Outline: To Verify the manage drug page and verify tooltips for AARP Site 
#Given the user is on the AARP medicare site landing page
#When the user performs drug search using the following information in AARP site
#	| Zip Code    | <zipcode>  |
#	| County      | <county>   |
#When the user search the drug using drug initials in AARP site
#	| <drugInitials> |
#Then the user validates the drug list that has above mentioned drug initials in AARP site
#When the user selects following drug in AARP site
#	| <drugName> |
#Then the user validates the available drug information in AARP site
#When the user selects the following dosage information in AARP site
#	| Drug Dosage    | <drugDosage>    |
#	| Quantity       | <quantity>      |
#	| Drug Frequency | <drugFrequency> |
#	| Packages       | <packages>      |
#And the user selects low cost options for above selected drug in AARP site
#	| Generic Available | <genericAvailable> |
#	| Brand or Generic  | <brand/generic>    |
#Then the user validates all the drugs added in dce flow in AARP site
#When the user search for pharmacies in dce flow in AARP site
#Then the user validates the available pharmacies in the selected zipcode in AARP site
#When the user selects the pharmacy type and distance in AARP site
#	| Pharmacy Type | <pharmacyType> |
#	| Distance      | <distance>     |
#Then the user validates the available pharmacies based on selection made above in AARP site
#When the user selects a pharmacy from the list of pharmacies in AARP site
#	| <pharmacyName> |
#Then the user validates the selected drug and selected pharmacy on manage drug list page in AARP site
#When the user views plan results after selecting drug and pharmacy in AARP site
#Then user validates plan count for all plan types on plan summary page in AARP site
#When the user views plans of the below plan type in the AARP site
#	| Plan Type | <plantype> |
#Then the user validates the available plans for selected plan types in AARP site
#And the user validates the plan summary for the below plan in the AARP site
#	| Plan Name | <planName> |
#When the user click the Edit Drug List link in plan summary page of AARP site
#Then user validated estimated drug cost and tooltip in AARP site
#
#Examples:
#	| zipcode | county             | drugInitials | drugName      |  drugDosage	    | packages | quantity | drugFrequency  | genericAvailable | brand/generic                                           | pharmacyType		| distance   |  pharmacyName		| plantype | planName 					        |
#	| 90210   | Los Angeles County | lipi	      |  Lipitor      |  Lipitor TAB 20MG   | null     | 40       | Every 3 months | yes              | Lipitor TAB 20MG (Qty 40 Every 3 Months)                | Available Pharmacies  | 15 miles   |  Men's Health Foundation	| MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  |
#	
#
#@dceGenericDrugsAndPharmacyAARP
#Scenario Outline: To Verify the drugs and pharmacy model for new generic flow 
#Given the user is on the AARP medicare site landing page
#When the user performs drug search using the following information in AARP site
#	| Zip Code    | <zipcode>  |
#	| County      | <county>   |
#When the user search the drug using drug initials in AARP site
#	| <drugInitials> |
#Then the user validates the drug list that has above mentioned drug initials in AARP site
#When the user selects following drug in AARP site
#	| <drugName> |
#Then the user validates the available drug information in AARP site
#When the user selects the following dosage information in AARP site
#	| Drug Dosage    | <drugDosage>    |
#	| Quantity       | <quantity>      |
#	| Drug Frequency | <drugFrequency> |
#	| Packages       | <packages>      |
#And the user selects low cost options for above selected drug in AARP site
#	| Generic Available | <genericAvailable> |
#	| Brand or Generic  | <brand/generic>    |
#Then the user validates all the drugs added in dce flow in AARP site
#When the user search for pharmacies in dce flow in AARP site
#Then the user validates the available pharmacies in the selected zipcode in AARP site
#When the user selects the pharmacy type and distance in AARP site
#	| Pharmacy Type | <pharmacyType> |
#	| Distance      | <distance>     |
#Then the user validates the available pharmacies based on selection made above in AARP site
#When the user selects a pharmacy from the list of pharmacies in AARP site
#	| <pharmacyName> |
#Then the user validates the selected drug and selected pharmacy on manage drug list page in AARP site
#
#Examples:
#	| zipcode | county             | drugInitials | drugName      |  drugDosage	    | packages | quantity | drugFrequency  | genericAvailable | brand/generic                            | pharmacyType		  | distance   |  pharmacyName               |
#	| 90210   | Los Angeles County | lipi	      |  Lipitor      |  Lipitor TAB 20MG   | null     | 40       | Every 3 months | yes              | Lipitor TAB 20MG (Qty 40 Every 3 Months) |  Available Pharmacies  | 15 miles   |  Men's Health Foundation    | 
#	
#@dceGenericDrugsListPlanCostAARP
#Scenario Outline: To Verify the drug list and plan cost sections in View Plan Details page 
#Given the user is on the AARP medicare site landing page
#When the user performs drug search using the following information in AARP site
#	| Zip Code    | <zipcode>  |
#	| County      | <county>   |
#And the user search for the drug in AARP site
#	| <drugInitials> |
#And the user selects the drug from the dropdown in AARP site
#	| <drugName> |
#And the user selects the following dosage information in AARP site
#	| Drug Dosage    | <drugDosage>    |
#	| Quantity       | <quantity>      |
#	| Drug Frequency | <drugFrequency> |
#	| Packages       | <packages>      |
#And the user selects low cost options for the selected drug in AARP site
#	| Generic Available | <genericAvailable> |
#	| Brand or Generic  | <brand/generic>    |
#And the user search for pharmacies in AARP site
#And the user selects the type of pharmacy and distance in AARP site
#	| Pharmacy Type | <pharmacyType> |
#	| Distance      | <distance>     |
#And the user selects a pharmacy in AARP site
#	| <pharmacyName> |
#And the user navigates to VPP page in AARP site
#And the user selects the plan in AARP site
#	| Plan Type | <plantype> |
#Then the user view plan details of the selected plan in AARP site
#	| Plan Name | <planName> |
#    |Error Message | <errorMessage> |
#
#
#Examples:
#	| zipcode | county             | drugInitials | drugName      |  drugDosage	        | packages                                          | quantity | drugFrequency  | genericAvailable | brand/generic                            | pharmacyType	 	 		| distance   |  pharmacyName               | plantype |planYear| planName 					                       |errorMessage                                                                                                                                   |
#	| 76270   | Montague County    | lipi	      |  Lipitor      |  Lipitor TAB 20MG   | null                                              | 40       | Every 3 months | yes              | Lipitor TAB 20MG (Qty 40 Every 3 Months) | Available Pharmacies        | 25 miles   |  CVS Pharmacy               | PDP      | 2016   |AARP MedicareRx Preferred (PDP)                    |The pharmacy selected is not part of this plan's pharmacy network. Please edit your current pharmacy to estimate your drug costs for this plan.|	 		 