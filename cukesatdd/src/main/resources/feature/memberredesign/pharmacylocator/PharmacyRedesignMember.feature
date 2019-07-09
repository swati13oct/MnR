@pharmacylocator @regressionMember @gladiators @regressionMember_Testharness
Feature: P1.6To test Locate a Pharmacy tool in Redesign site

@pharmacylocator1 @PharmacyDistanceDefaultZip
Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -To verify for default zipcode, filters, Show on map, View PDF, More Info in Redesign site
Given login with following details logins in the member portal and validate elements
	| Plan Type  	  	 | 			<planType>   						|
	| Member Type 	   | 			<memberType> 	    			|
When the user navigates to pharmacy search page in Redesign site
And the user enters distance details in Redesign site
	| Distance 	  	   | 		    <distance> 						|
And the user selects Pharmacy Types to Filter in Redesign Site
	| Pharmacy Type    | 			<pharmacyType>   				|
Then the user validates the pharmacies available in Redesign site
And the user Validates show on map link in Redesign Site
And the user validate more information content based on plan type in Redesign Site
And the user Validates view search PDF link in Redesign Site
Examples: 
	| TID 	| planType | memberType         					| distance | pharmacyType                |
	| 15273	| MAPD     | IndAARPMAPD_Pharmacylocator	|       25 | Open 24 hours               |
	| 15295	| PDP      | IndAARPPDP_Pharmacylocator		|       25 | E-Prescribing               |
	| 15296	| MAPD     | GroupMAPD_Pharmacylocator		|       25 | Long-term care              |
	| 15279	| MAPD     | Medica_Pharmacylocator				|       25 | Home Infusion and Specialty |
	| 15280	| MAPD     | PCP_Pharmacylocator					|       25 | Retail Pharmacy (90-day)    |
	| 15274	| PDP      | TexasRx_Pharmacylocator			|       25 | Long-term care              |
	| 15294	| MAPD     | IndMAPDUHC_Pharmacylocator		|       25 | E-Prescribing               |

@pharmacylocator2 @ValidateLanguageandZIPcode
Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -To verify pharmacy Locator ZIP code entry and for Chinese and Spanish Language in Redesign site
Given login with following details logins in the member portal and validate elements
	| Plan Type  	  	 | 			<planType>   		 			  |
	| Member Type 	   | 			<memberType> 	          |
When the user navigates to pharmacy search page in Redesign site
And the user enters following details for pharmacy search in Redesign Site
	| Zip Code 		  	 | 			<zipcode> 	    				|
	| Distance 			   | 			<distance> 			 				|
Then the user validates the pharmacies available in Redesign site
When the user Selects Chinese Language in Redesign Site
Then the user searches multi lang for pharmacy search results available in Redesign site
When the user Selects Spanish Language in Redesign site
Then the user searches multi lang for pharmacy search results available in Redesign site
Examples: 
	| TID		| planType | memberType        						| zipcode | distance |
	| 15273	| MAPD     | IndAARPMAPD_Pharmacylocator 	|   10980 |       10 |
	| 15295	| PDP      | IndAARPPDP_Pharmacylocator 	|   10980 |       10 |
	| 15296	| MAPD     | GroupMAPD_Pharmacylocator  	|   61443 |       10 |
	| 15279	| MAPD     | Medica_Pharmacylocator  		  |   33321 |       10 |
	| 15280	| MAPD     | PCP_Pharmacylocator     		  |   33174 |       10 |
	| 15274	| PDP      | TexasRx_Pharmacylocator 		  |   14867 |       25 |
	| 15294	| MAPD     | IndMAPDUHC_Pharmacylocator  	|   29148 |       10 |

@pharmacylocator3 @ZipCodeErrorMessages
Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -zipcode: <zipcode>-To verify error messages for invalid Zipcode in pharmacy locator page in Redesign site
Given login with following details logins in the member portal and validate elements
	| Plan Type  	  	 | 			<planType>   		 			  |
	| Member Type 	   | 			<memberType> 	          |
When the user navigates to pharmacy search page in Redesign site
When the user enters following details for pharmacy search in Redesign Site
	| Zip Code 		  	 | 			<zipcode> 	    				|
	| Distance 			   | 			<distance> 			 				|
Then the user verify error messages in pharmacy locator page in Redesign site
Examples: 
	| TID	  | planType | memberType        				  	| zipcode | distance |
  | 15273 | MAPD     | IndAARPMAPD_Pharmacylocator	|         |        5 |
  | 15273	| MAPD     | IndAARPMAPD_Pharmacylocator 	|    9999 |       10 |
  | 15295	|PDP       | IndAARPPDP_Pharmacylocator		|         |        5 |
  | 15295	| PDP      | IndAARPPDP_Pharmacylocator 	|    9999 |       10 |
  | 15296	| MAPD     | GroupMAPD_Pharmacylocator   	|         |        5 |
  | 15296	| MAPD     | GroupMAPD_Pharmacylocator  	|    9999 |       10 |
  | 15279	| MAPD     | Medica_Pharmacylocator  		  |         |        5 |
  | 15279	| MAPD     | Medica_Pharmacylocator 		  |    9999 |       10 |
  | 15280	| MAPD     | PCP_Pharmacylocator     		  |         |        5 |
  | 15280	| MAPD     | PCP_Pharmacylocator    		  |    9999 |       10 |
  | 15274	| PDP      | TexasRx_Pharmacylocator 		  |         |        5 |
  | 15274 |PDP       | TexasRx_Pharmacylocator 		  |    9999 |       10 |
  | 15294	| MAPD     | IndMAPDUHC_Pharmacylocator   |         |        5 |
  | 15294	| MAPD     | IndMAPDUHC_Pharmacylocator   |    9999 |       10 |

@pharmacylocator4 @NegativeScenario
Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -To verify pharmacy link is not displayed to MA/SHIP member in Redesign site
Given login with following details logins in the member portal and validate elements
	| Plan Type  	  	 | 			<planType>   		 			  |
	| Member Type 	   | 			<memberType> 	          |
Then the user will not be able to see the locate a pharmacy on home page
Examples: 
  | TID   | planType  | memberType        			    |
  | 15272 | MA        | IndAARPMA_Pharmacylocator		|
  | 15272 | SHIP      | IndSHIP_Pharmacylocator     |
  | 15272 | MA        | IndUHCMA_Pharmacylocator 		|
  
@vbfGate
Scenario Outline:plan: <planType> -memberType: <memberType> -To verify for default zipcode, filters, Show on map, View PDF, More Info in Redesign site
Given login with following details logins in the member portal and validate elements
	| Plan Type  	  	 | 			<planType>   						|
	| Member Type 	   | 			<memberType> 	    			|
When the user navigates to pharmacy search page in Redesign site
And the user enters distance details in Redesign site
	| Distance 	  	   | 		    <distance> 						|
And the user selects Pharmacy Types to Filter in Redesign Site
	| Pharmacy Type    | 			<pharmacyType>   				|
Then the user validates the pharmacies available in Redesign site
And the user Validates show on map link in Redesign Site
And the user validate more information content based on plan type in Redesign Site
Examples: 
	| planType | memberType  | distance | pharmacyType                |
    | MAPD     | UhcMapdInd	 |       25 | Open 24 hours               |
