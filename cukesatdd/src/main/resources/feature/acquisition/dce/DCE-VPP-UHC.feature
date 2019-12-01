@fixedTestCaseDCEVPP
Feature: To test DCE to VPP plan Summary flow  in UMS site
@dceThroughPlanSummaryNonAepUHC @uhc @regressionMember @dce1 @uhcDce1
Scenario Outline: To Verify the drug cost estimator flow for <planName> for non AEP periodthrough plan summary
Given user is on blue layer landing page
When user performs plan search using following information in the UMS site
       | Zip Code    | <zipcode>  |
       | County      | <county>   |
       |aep | <aep>|
	   |currentyear|<currentyear>|
And user access DCE tool on UMS site
	|Plan Type | <plantype> |
	| PlanName       | <planName>  |
Then user adds drug to drug cost estimator flow for the given plan name in UMS site
	  | PlanName       | <planName>      |
      | Drug Name1     | <drugName1>     |
And selects drug details in UMS site
	  | Drug Name1     | <drugName1>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
When user successfully adds drug in the UMS site
	  | Drug Name1     | <drugName1>     |
Then user adds drug to drug cost estimator flow for the given plan name in UMS site
	  | PlanName       | <planName>      |
      | Drug Name2     | <drugName2>     |
And selects drug details for other drugs in UMS site
	  | Drug Name2     | <drugName2>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
Then user adds drug to drug cost estimator flow for the given plan name in UMS site
	  | PlanName       | <planName>      |
      | Drug Name3     | <drugName3>     |	  
And selects drug details in UMS site
	  | Drug Name3     | <drugName3>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
When user successfully adds drug in the UMS site
	  | Drug Name3     | <drugName3>     |  
Then the user clicks on the Pick a pharmacy button in the DCE flow in UMS site
When the user selects the pharmacy type and distance in UMS site
       | Pharmacy Type | <pharmacyType> |
       | Distance      | <distance>     |
Then the user selects a pharmacy from the list of pharmacies in UMS site
             | Pharmacy Name | <pharmacyName> |
Then the user validates the added drugs on See your Estimated Costs page in UMS site
	  | Drug Name1     | <drugName1>     |
      | Drug Name2     | <drugName2>     |
      | Drug Name3     | <drugName3>     |
When the user clicks on Edit Drug List link in UMS site
Then Enter your drugs page is displayed to the user in UMS site
Then User click on Switch now to select the Generic of the Brand drug added in UMS site
Then the user clicks on the Pick a pharmacy button in the DCE flow in UMS site
Then the user change the pharmacy type and select new pharmacy in UMS site
               | New Pharmacy Type | <newPharmacyType> |
Then the user validates the added drugs on See your Estimated Costs page in UMS site
	  | Drug Name1     | <genericName1>  |
      | Drug Name2     | <drugName2>     |
      | Drug Name3     | <genricName3>   |
And the user clicks on Back to Plans button in UMS site
Then user validates Drug information is reflected on plan summary page in UMS site
| PlanName       | <planName>      |
#Test ID: 15487,15490,15494
Examples:
| zipcode | county             | drugInitials1       | drugName1     | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType                 | distance   |  pharmacyName               | plantype | planName                                           | quantity | frequency   |newPharmacyType|genericName1|genricName3|aep|currentyear|
| 90002   | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Standard Network             | 15 miles   |  CVS PHARMACY   | MAPD     | AARP Medicare Advantage SecureHorizons Focus (HMO)| 30       |Every 1 month|Mail Order   |atorvastatin |fluticasone| no | no |
       
@dceThroughPlanDetailsUHC @uhc @regressionMember @dce2 @uhcDce
Scenario Outline: To Verify the drug cost estimator flow for <plantype> through plan details page's Prescription Drug Benefits tab
Given user is on blue layer landing page
When user performs plan search using following information in the UMS site
               | Zip Code    | <zipcode>  |
               | County      | <county>   |
Then the user navigates to the plan details for the given plan type in UMS site
               | Plan Type | <plantype> |
               |Plan Name  |<planName>  |
Then the user navigates to Presciption Drug Benefits tab in UMS site
Then user adds drug to drug cost estimator flow for the given plan name in UMS site
	  | PlanName       | <planName>      |
      | Drug Name1     | <drugName1>     |
And selects drug details in UMS site
	  | Drug Name1     | <drugName1>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
When user successfully adds drug in the UMS site
	  | Drug Name1     | <drugName1>     |
Then user adds drug to drug cost estimator flow for the given plan name in UMS site
	  | PlanName       | <planName>      |
      | Drug Name2     | <drugName2>     |
And selects drug details for other drugs in UMS site
	  | Drug Name2     | <drugName2>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
Then user adds drug to drug cost estimator flow for the given plan name in UMS site
	  | PlanName       | <planName>      |
      | Drug Name3     | <drugName3>     |	  
And selects drug details in UMS site
	  | Drug Name3     | <drugName3>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
When user successfully adds drug in the UMS site
	  | Drug Name3     | <drugName3>     |  
Then user adds drug to drug cost estimator flow for the given plan name in UMS site
	  | PlanName       | <planName>      |
      | Drug Name4     | <drugName4>     |
And selects drug details for other drugs in UMS site
	  | Drug Name4     | <drugName4>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
Then user adds drug to drug cost estimator flow for the given plan name in UMS site
	  | PlanName       | <planName>      |
      | Drug Name5     | <drugName5>     |	
And selects drug details for other drugs in UMS site
	  | Drug Name5     | <drugName5>     |	
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|  
Then the user clicks on the Pick a pharmacy button in the DCE flow in UMS site
When the user selects the pharmacy type and distance in UMS site
       | Pharmacy Type | <pharmacyType> |
       | Distance      | <distance>     |
Then the user selects a pharmacy from the list of pharmacies in UMS site
             | Pharmacy Name | <pharmacyName> |
Then the user validates the added drugs on See your Estimated Costs page in UMS site
	  | Drug Name1     | <drugName1>     |
      | Drug Name2     | <drugName2>     |
      | Drug Name3     | <drugName3>     |
      | Drug Name4     | <drugName4>     |
      | Drug Name5     | <drugName5>     |
When the user clicks on Edit Drug List link in UMS site
Then Enter your drugs page is displayed to the user in UMS site
Then User click on Switch now to select the Generic of the Brand drug added in UMS site
Then the user clicks on the Pick a pharmacy button in the DCE flow in UMS site
Then the user change the pharmacy type and select new pharmacy in UMS site
               | New Pharmacy Type | <newPharmacyType> |
Then the user validates the added drugs on See your Estimated Costs page in UMS site
	  | Drug Name1     | <genericName1>     |
      | Drug Name2     | <drugName2>     |
      | Drug Name3     | <genricName3>     |
      | Drug Name4     | <drugName4>     |
      | Drug Name5     | <drugName5>     |
And the user clicks on Back to Plans button on See Your Estimated Costs page in UMS site
And user verifies annual drug cost in the prescription drug tab of UMS site
| Plan Type | <plantype> |
And the user clicks on Back to All Plans button present on details page in UMS site
Then user validates Drug information is reflected on plan summary page in UMS site
| PlanName       | <planName>      |

#Test ID: 15495,15541,15608
Examples:
       | zipcode | county             | drugInitials1       | drugName1     | drugInitials2 | drugName2  | drugInitials3 | drugName3     | drugInitials4 | drugName4 | drugInitials5 | drugName5             | pharmacyType                 | distance   |  pharmacyName               | plantype | planName                                           | quantity | frequency   |newPharmacyType|genericName1|genricName3|
       | 90210   | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network             | 15 miles   |  MEN'S HEALTH FOUNDATION    | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | 30       |Every 1 month|Mail Service   |atorvastatin |fluticasone|
       | 90210   | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network             | 15 miles   |  Men's Health Foundation    | PDP      | AARP MedicareRx Walgreens (PDP)                    | 30       |Every 1 month|Mail Service   |atorvastatin |fluticasone|
       | 78002  | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network             | 15 miles   |  HEB PHARMACY 019    | SNP      | UnitedHealthcare Chronic Complete (HMO SNP)        | 30       |Every 1 month|Mail Service   |atorvastatin |fluticasone|
       

               
@dceThroughPlanDetailsUHC @uhc @regressionMember @dce3 @uhcDce
Scenario Outline: To Verify the drug cost estimator flow for <plantype> through plan details page's Plan Costs tab
Given user is on blue layer landing page
When user performs plan search using following information in the UMS site
               | Zip Code    | <zipcode>  |
               | County      | <county>   |
Then the user navigates to the plan details for the given plan type in UMS site
               | Plan Type | <plantype> |
               |Plan Name  |<planName>  |
Then the user navigates to Plan Costs tab in UMS site
Then user adds drug to drug cost estimator flow for the given plan name in UMS site
	  | PlanName       | <planName>      |
      | Drug Name1     | <drugName1>     |
And selects drug details in UMS site
	  | Drug Name1     | <drugName1>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
When user successfully adds drug in the UMS site
	  | Drug Name1     | <drugName1>     |
Then user adds drug to drug cost estimator flow for the given plan name in UMS site
	  | PlanName       | <planName>      |
      | Drug Name2     | <drugName2>     |
And selects drug details for other drugs in UMS site
	  | Drug Name2     | <drugName2>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
Then user adds drug to drug cost estimator flow for the given plan name in UMS site
	  | PlanName       | <planName>      |
      | Drug Name3     | <drugName3>     |	  
And selects drug details in UMS site
	  | Drug Name3     | <drugName3>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
When user successfully adds drug in the UMS site
	  | Drug Name3     | <drugName3>     |  
Then user adds drug to drug cost estimator flow for the given plan name in UMS site
	  | PlanName       | <planName>      |
      | Drug Name4     | <drugName4>     |
And selects drug details for other drugs in UMS site
	  | Drug Name4     | <drugName4>     |
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|
Then user adds drug to drug cost estimator flow for the given plan name in UMS site
	  | PlanName       | <planName>      |
      | Drug Name5     | <drugName5>     |	
And selects drug details for other drugs in UMS site
	  | Drug Name5     | <drugName5>     |	
	  |Quantity|<quantity>|
	  |Frequency|<frequency>|  
Then the user clicks on the Pick a pharmacy button in the DCE flow in UMS site
When the user selects the pharmacy type and distance in UMS site
       | Pharmacy Type | <pharmacyType> |
       | Distance      | <distance>     |
Then the user selects a pharmacy from the list of pharmacies in UMS site
             | Pharmacy Name | <pharmacyName> |
Then the user validates the added drugs on See your Estimated Costs page in UMS site
	  | Drug Name1     | <drugName1>     |
      | Drug Name2     | <drugName2>     |
      | Drug Name3     | <drugName3>     |
      | Drug Name4     | <drugName4>     |
      | Drug Name5     | <drugName5>     |
When the user clicks on Edit Drug List link in UMS site
Then Enter your drugs page is displayed to the user in UMS site
Then User click on Switch now to select the Generic of the Brand drug added in UMS site
Then the user clicks on the Pick a pharmacy button in the DCE flow in UMS site
Then the user change the pharmacy type and select new pharmacy in UMS site
               | New Pharmacy Type | <newPharmacyType> |
Then the user validates the added drugs on See your Estimated Costs page in UMS site
	  | Drug Name1     | <genericName1>     |
      | Drug Name2     | <drugName2>     |
      | Drug Name3     | <genricName3>     |
      | Drug Name4     | <drugName4>     |
      | Drug Name5     | <drugName5>     |
And the user clicks on Back to Plans button on See Your Estimated Costs page in UMS site
And user verifies annual drug cost in the Plan Cost tab of UMS site
| Plan Type | <plantype> |
And the user clicks on Back to All Plans button present on details page in UMS site
Then user validates Drug information is reflected on plan summary page in UMS site
| PlanName       | <planName>      |
#Test ID: 15610, 15612, 15613 : Few scenario's are left to be covered
Examples:
               | zipcode | county             | drugInitials1       | drugName1     | drugInitials2 | drugName2  | drugInitials3 | drugName3     | drugInitials4 | drugName4 | drugInitials5 | drugName5             | pharmacyType                 | distance   |  pharmacyName               | plantype | planName                                           | quantity | frequency   |newPharmacyType|genericName1|genricName3|
               | 90210   | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network             | 15 miles   |  MEN'S HEALTH FOUNDATION    | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)  | 30       |Every 1 month|Mail Service   |atorvastatin |fluticasone|
               | 90210   | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network             | 15 miles   |  Men's Health Foundation    | PDP      | AARP MedicareRx Walgreens (PDP)                    | 30       |Every 1 month|Mail Service   |atorvastatin |fluticasone|
               | 78002    | Los Angeles County | lipi                |  Lipitor      | dron          | dronabinol | Adva          | Advair Diskus | Orfa          | Orfadin   | Fana          | Fanapt Titration Pack | Standard Network             | 15 miles   |  HEB PHARMACY 019    | SNP      | UnitedHealthcare Chronic Complete (HMO SNP)        | 30       |Every 1 month|Mail Service   |atorvastatin |fluticasone|
               
@dcevppnonaep
Scenario Outline: To Verify the drugs and plan summary for non AEP period
Given the user is on the UHC medicare solutions site landing page
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
Examples:
| zipcode | county              | drugInitials	| drugName      |  drugDosage	      | quantity	| drugFrequency  | packages | genericAvailable	| brand/generic					| pharmacyType				| distance	| pharmacyName			| plantype	| planName						|
| 90210   |  Los Angeles County	| lipi		|  Lipitor      |  Lipitor TAB 20MG   |   40		| Every 3 months | null     |	yes		| Lipitor TAB 20MG (Qty 40 Every 3 Months)	| Standard Network Pharmacy 		| 15 miles	|  Horton And Converse Pharmacy	| MAPD		| AARP MedicareComplete SecureHorizons Plan 2 (HMO)	|
	| 80002   |  Adams County       | lipi		|  Lipitor      |  Lipitor TAB 20MG   |   40		| Every 3 months | null     |	yes		| Lipitor TAB 20MG (Qty 40 Every 3 Months)	| Standard Network Pharmacy 		| 15 miles	|  Costco Pharmacy		| MAPD		| AARP MedicareComplete SecureHorizons Plan 2 (HMO)	| 

 
@dceVppnonAepDrugPlanDetails
Scenario Outline: To Verify the drugs and plan details for non AEP period 
Given the user is on the UHC medicare solutions site landing page
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
| 80002   |  Adams County       | lipi		|  Lipitor      |  Lipitor TAB 20MG   |   40		| Every 3 months	| null     |	yes		| Lipitor TAB 20MG (Qty 40 Every 3 Months)	| Standard Network Pharmacy 		| 15 miles	| Costco Pharmacy		| MAPD		| AARP MedicareComplete SecureHorizons Plan 2 (HMO)	| 

@dceGenericFlowDrugsPharmacy
Scenario Outline: To Verify the drugs and pharmacy model for new generic flow
Given the user is on the UHC medicare solutions site landing page
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
| 80002   | Adams County       | lipi		|  Lipitor      |  Lipitor TAB 20MG   |   40		| Every 3 months | null     |	yes		| Lipitor TAB 20MG (Qty 40 Every 3 Months)	| Standard Network Pharmacy 		| 15 miles	|  Costco Pharmacy		| 

