@pharmacylocator @gladiators
Feature: P1.6To test Locate a Pharmacy Locator tool on member site

  #-------------------------
  # note: need to fix the VBF to run on stage also
  #----- beginning of VBF member pharmacy locator scenarios section ------------------------
  @smokeTest @MemberVBF @smokeTest_PharmacyLocatorMem @rallyDashboard @testharness
  Scenario Outline: VBF -plan: <planType> -memberType: <memberType> - Verify all available pharmacies for default zipcode in Redesign site
	Given login with following details logins in the member portal and validate elements
		| Plan Type     | <planType>   	 |
		| Member Type   | <memberType> 	 |
	When the user navigates to pharmacy search page in Redesign site
	And the user enters following details for pharmacy search in Redesign Site
		| Zip Code 	  |	<zipcode> 	 |
		| Distance 	  |	<distance> 	 |
    Then the user Validates show on map link in Redesign Site
    Then the user validate more information content based on plan type in Redesign Site

    Examples: 
  	  | planType | memberType       | distance | zipcode |
	  | MAPD     | UhcMapdInd       | 25       | 90210   |
	# | MAPD     | AARPMapdInd      | 25       | 90210   |
	# | MAPD     | GroupRetireeMapd | 25       | 90210   |
		
  @smokeTest @MemberVBF @pharmacyLocator_Performance
  Scenario Outline: VBF -plan: <planType> -memberType: <memberType> - Verify all available pharmacies for default zipcode in Redesign site for performance
	Given login with following details logins in the member portal and validate elements
		| Plan Type     | <planType>   	 |
		| Member Type   | <memberType> 	 |
	When the user navigates to pharmacy search page in Redesign site
	And the user enters following details for pharmacy search in Redesign Site
		| Zip Code 	  |	<zipcode> 	 |
		| Distance 	  |	<distance> 	 |

    Examples: 
	  | planType | memberType | distance | zipcode |
	  | PDP        | grpPerf  | 25       | 90210   |
  #----- end of VBF member pharmacy locator scenarios section ------------------------

  #-------------------------
  # note: member pharmacy locator ALM cases
  # TID: 15272 - TC01_MA_Pharmacy locator_Negative
  # TID: 15273 - TC02_AARP MAPD_Individual_E2E Scenario_Pharmacy locator
  # TID: 15279 - TC03_Medica_E2E Scenario_Pharmacy locator
  # TID: 15280 - TC04_PCP_E2E Scenario_Pharmacy locator
  # TID: 15274 - TC05_Texas_PDP Group_Pharmacy locator
  # TID: 15294 - TC06_UHC MAPD_Individual_E2E Scenario_Pharmacy locator
  # TID: 15295 - TC07_AARP PDP_E2E Scenario_Pharmacy locator
  # TID: 15296 - TC08_Group MAPD_E2E Scenario_Pharmacy locator
  #-------------------------
  @pharmacylocator1 @PharmacyDistanceDefaultZip @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To verify for default zipcode, filters, Show on map, View PDF, More Info in Redesign site
	Given login with following details logins in the member portal and validate elements
		| Plan Type     | <planType>   	 |
		| Member Type   | <memberType> 	 |
	When the user navigates to pharmacy search page in Redesign site
	And the user enters distance details in Redesign site
		| Distance 	    | <distance> 	 |
	And the user selects Pharmacy Types to Filter in Redesign Site
		| Pharmacy Type | <pharmacyType> |
	Then the user validates the pharmacies available in Redesign site
	And the user Validates show on map link in Redesign Site
	And the user validate more information content based on plan type in Redesign Site
	And the user Validates view search PDF link in Redesign Site
	Examples: 
		| TID 	| planType | memberType         		 | distance | pharmacyType                |
		| 15273	| MAPD     | IndAARPMAPD_Pharmacylocator | 25       | Open 24 hours               |
		| 15295	| PDP      | IndAARPPDP_Pharmacylocator	 | 25       | E-Prescribing               |
		| 15296	| MAPD     | GroupMAPD_Pharmacylocator	 | 25       | Long-term care              |
		| 15279	| MAPD     | Medica_Pharmacylocator		 | 25       | Home Infusion and Specialty |
		| 15280	| MAPD     | PCP_Pharmacylocator		 | 25       | Retail Pharmacy (90-day)    |
		| 15274	| PDP      | TexasRx_Pharmacylocator	 | 25       | Long-term care              |
		| 15294	| MAPD     | IndMAPDUHC_Pharmacylocator	 | 25       | E-Prescribing               |

  @pharmacylocator2 @ValidateLanguageandZIPcode @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To verify pharmacy Locator ZIP code entry and for Chinese and Spanish Language in Redesign site
	Given login with following details logins in the member portal and validate elements
		| Plan Type   | <planType>   |
		| Member Type |	<memberType> |
	When the user navigates to pharmacy search page in Redesign site
	And the user enters following details for pharmacy search in Redesign Site
		| Zip Code 	  |	<zipcode> 	 |
		| Distance 	  |	<distance> 	 |
	Then the user validates the pharmacies available in Redesign site
	When the user Selects Chinese Language in Redesign Site
	Then the user searches multi lang for pharmacy search results available in Redesign site
	When the user Selects Spanish Language in Redesign site
	Then the user searches multi lang for pharmacy search results available in Redesign site

	Examples: 
		| TID	| planType | memberType        			 | zipcode | distance |
		| 15273	| MAPD     | IndAARPMAPD_Pharmacylocator | 10980   | 10       |
		| 15295	| PDP      | IndAARPPDP_Pharmacylocator  | 10980   | 10       |
		| 15296	| MAPD     | GroupMAPD_Pharmacylocator   | 61443   | 10       |
		| 15279	| MAPD     | Medica_Pharmacylocator  	 | 33321   | 10       |
		| 15280	| MAPD     | PCP_Pharmacylocator     	 | 33174   | 10       |
		| 15274	| PDP      | TexasRx_Pharmacylocator 	 | 14867   | 25       |
		| 15294	| MAPD     | IndMAPDUHC_Pharmacylocator  | 29148   | 10       |

  @pharmacylocator3 @ZipCodeErrorMessages @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -zipcode: <zipcode> - To verify error messages for invalid Zipcode in pharmacy locator page in Redesign site
	Given login with following details logins in the member portal and validate elements
		| Plan Type   |	<planType>   |
		| Member Type |	<memberType> |
	When the user navigates to pharmacy search page in Redesign site
	When the user enters following details for pharmacy search in Redesign Site
		| Zip Code 	  |	<zipcode>    |
		| Distance 	  |	<distance>   |
	Then the user verify error messages in pharmacy locator page in Redesign site

	Examples: 
	  | TID	  | planType | memberType        			| zipcode | distance |
	  | 15273 | MAPD     | IndAARPMAPD_Pharmacylocator	|         | 5        |
	  | 15273 | MAPD     | IndAARPMAPD_Pharmacylocator 	| 9999    | 10       |
	  | 15295 | PDP      | IndAARPPDP_Pharmacylocator	|         | 5        |
	  | 15295 | PDP      | IndAARPPDP_Pharmacylocator 	| 9999    | 10       |
	  | 15296 | MAPD     | GroupMAPD_Pharmacylocator   	|         | 5        |
	  | 15296 | MAPD     | GroupMAPD_Pharmacylocator  	| 9999    | 10       |
	  | 15279 | MAPD     | Medica_Pharmacylocator  		|         | 5        |
	  | 15279 | MAPD     | Medica_Pharmacylocator 		| 9999    | 10       |
	  | 15280 | MAPD     | PCP_Pharmacylocator     		|         | 5        |
	  | 15280 | MAPD     | PCP_Pharmacylocator    		| 9999    | 10       |
	  | 15274 | PDP      | TexasRx_Pharmacylocator 		|         | 5        |
	  | 15274 | PDP      | TexasRx_Pharmacylocator 		| 9999    | 10       |
	  | 15294 | MAPD     | IndMAPDUHC_Pharmacylocator   |         | 5        |
	  | 15294 | MAPD     | IndMAPDUHC_Pharmacylocator   | 9999    | 10       |

  @pharmacylocator4 @NegativeScenario @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To verify pharmacy link is not displayed to MA/SHIP member in Redesign site
	Given login with following details logins in the member portal and validate elements
	  | Plan Type   | <planType>   |
	  | Member Type | <memberType> |
	Then the user will not be able to see the locate a pharmacy on home page

	Examples: 
	  | TID   | planType | memberType        		  |
	  | 15272 | MA       | IndAARPMA_Pharmacylocator |
	  | 15272 | SHIP     | IndSHIP_Pharmacylocator   |
	  | 15272 | MA       | IndUHCMA_Pharmacylocator  |
