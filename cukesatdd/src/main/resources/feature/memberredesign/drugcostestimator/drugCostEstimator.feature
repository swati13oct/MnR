@theIncredibles
@drug_cost_estimator
Feature:Drug Cost Estimator
@IncrediblesDCE1
Scenario Outline:I1.1 To Verify MR portal members using DCE on a desktop device , Pharmacy search tab validation
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
Then I should see the Pharmacy search tab as a clickable element within the DCE tool blayer dce
And I should be able to move forward or backward in the tool flow blayer dce 
Examples:
 | planType  | memberType  |
 | MAPD       |IndividualDCEmember |


@IncrediblesDCE2
Scenario Outline: Pharmacy saver results
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I navigate to step2 page blayer dce
And we search the pharmacy within miles zipcode and pharmacy type blayer dce
| Zipcode| <zipcode> |
| Radius | <radius>  |
|Pharmacy Type|<pharmacytype>| 
Then I should see pharmacy results as per the filter blayer dce
And I should see pharmacy saver pharmacies in results blayer dce

 Examples:
| planType | memberType| zipcode| radius|pharmacytype|
| MAPD     |IndividualDCEmember | 06450  | 25 miles|Pharmacy Saver|
 

  
@drug_cost_estimator_switch_to_generic_case_1 @IncrediblesDCE3
Scenario Outline: To Verify MR portal members using DCE on a desktop device, I want to be able to switch from branded to generic drug, given that no pharmacy is selected and it suggests the user with an appropriate save money message.
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I have added a drug to my drug list and a generic equivalent is available for the drug I have selected blayer dce
 	|Drug|<drug>|
And I have not yet selected pharmacy blayer dce
Then I should be presented the option to switch to the generic option blayer dce
And I will see a SWITCH NOW link in the drug tile with appropriate save message blayer dce
And I will see a modal appear upon clicking on SWITCH NOW blayer dce
And when I click on the button to accept the generic blayer dce
Then the drug name will automatically update within the Drug List blayer dce

Examples:
 | planType| memberType| drug |
 | MAPD|Individualwithoutpharmacy|lipitor|
 

 
@drug_cost_estimator_switch_to_generic_case_2 @IncrediblesDCE4
Scenario Outline: To Verify MR portal members using DCE on a desktop device, I want to be able to switch from branded to generic drug, given that a pharmacy is selected and it suggests the user with an appropriate save money message and cost savings are also updated
Given I am a registered member using the new M&R member portal on a desktop computer blayer dce
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When the above plantype user logs in UMS Site Desktop blayer dce
And I access the page containing the DCE tool blayer dce
And I have added a drug to my drug list and a generic equivalent is available for the drug I have selected blayer dce
 	|Drug|<drug>|
And I have selected pharmacy blayer dce
Then I should be presented the option to switch to the generic option blayer dce
And I will see a SWITCH NOW link in the drug tile with a pharmacy savings cost value blayer dce
And I will see a modal appear upon clicking on SWITCH NOW blayer dce 
And when I click on the button to accept the generic blayer dce
Then the drug name will automatically update within the Drug List blayer dce
And any cost savings will be applied to my total cost savings in Step3 blayer dce

Examples:
 | planType| memberType| drug |
 | MAPD|IndividualDCEmember|lipitor|
 
@Member_DCE
Scenario Outline:I1.1 To Verify MR portal DCE flow covering step1 step 2 and step3 .
Given I login with registered user
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When I navigate to drug look up page
When I delete all added drugs
When I add branded drug
| Drug      | <drug1>     |
| Dosage    | <dosage1>   |
| Quantity  | <quantity1> |
| Frequency	| <frequency1>|
When I add branded drug
| Drug      | <drug1>     |
| Dosage    | <dosage2>   |
| Quantity  | <quantity2> |
| Frequency	| <frequency2>|
When I switch to its generic durg
| BrandedDrug      | <dosage2>   |
| GenericDosage    | <genericdosage>  |
| Quantity  | <quantity2> |
| Frequency	| <frequency2>|
When I delete the drug
| Dosage	| <genericdosage>|
When I navigate to Pharmacy tab
| Zipcode	| <zipcode>|
| Radius	| <radius>|
When I select the pharmacy from the list
When I navigate to costs tab
Then I should see cost of the drug
Then I should see learn more about the drug tiers and learn more about the drug payment stages link


Examples:
 | planType  | memberType  |drug1|dosage1|quantity1|frequency1|dosage2|brandeddrug|genericdosage|zipcode|radius|quantity2|frequency2|
 | MAPD      |IndividualDCEmember |Lipitor|Lipitor TAB 10MG|31|Every 1 month|Lipitor TAB 20MG|Lipitor TAB 20MG|atorvastatin calcium TAB 20MG|90210|25 miles|100|Every 3 months|
 
 
@Member_dce_not
Scenario Outline:I1.2 To Verify MR portal members DCE should not come for AARP federal members
Given I login with registered user
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
Then I should not see drug look up on home page
 
 Examples:
 | planType  | memberType|
 | Medsup    | Ship_AARP |
 | Group     | SSUP      |
 
 
@Member_DCE_sso
Scenario Outline:I1.3 To Verify MR portal group members DCE should redirect to optum rx sso landing page. 
Given I login with registered user
| Plan Type   | <planType>   |
| Member Type	  | <memberType> |
When I navigate to drug look up page
Then I should be optum rx sso landing page  
  Examples:
 | planType | memberType |
 | MAPD    | GROUP  |
 