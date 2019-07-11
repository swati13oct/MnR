@pharmacylocator @gladiators
Feature: P1.6To test Locate a Pharmacy Locator tool on member site

  #----- beginning of VBF member pharmacy locator scenarios section ------------------------
  @vbfGate @MemberVBF
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

  @smokeTest @MemberVBF @smokeTest_PharmacyLocatorMem @rallyDashboard @testharness
  Scenario Outline: VBF -plan: <planType> -memberType: <memberType> - Verify all available pharmacies for default zipcode in member site
	Given login with following details logins in the member portal and validate elements
	  | Plan Type     | <planType>   	 |
	  | Member Type   | <memberType> 	 |
	When the user navigates to pharmacy search page
	And the user enters following details for pharmacy search
	  | Zip Code 	  |	<zipcode> 	 |
	  | Distance 	  |	<distance> 	 |
    Then the user validates show on map link
    Then the user validates more information content based on plan type

    Examples: 
  	  | planType | memberType       | distance | zipcode |
	  | MAPD     | UhcMapdInd       | 25       | 90210   |
	# | MAPD     | AARPMapdInd      | 25       | 90210   |
	# | MAPD     | GroupRetireeMapd | 25       | 90210   |
		
  @smokeTest @MemberVBF @pharmacyLocator_Performance
  Scenario Outline: VBF -plan: <planType> -memberType: <memberType> - Verify all available pharmacies for default zipcode in member site for performance
	Given login with following details logins in the member portal and validate elements
		| Plan Type     | <planType>   	 |
		| Member Type   | <memberType> 	 |
	When the user navigates to pharmacy search page
	And the user enters following details for pharmacy search
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
  #
  # BYPASS Known issues ticket# INC12081977 
  # walgreens widget dce link is pointing to wrong place for Chinese and Spanish page on offline env
  #-------------------------
  @pharmacylocator1 @E2E @English @PharmacyDistanceDefaultZip @ValidateLanguageandZIPcode @ZipCodeErrorMessages @regressionMember @regressionMember_Testharness
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To verify end-to-end behavior for pharmacy locator page on member site
	Given login with following details logins in the member portal and validate elements
	  | Plan Type     | <planType>     |
	  | Member Type   | <memberType>   |
	When the user navigates to pharmacy search page
    #------ English -----------------------------------
	And the user validates header section content
	  | Member Type   | <memberType>   |
	And the user validates tooltips on filters
	  | Member Type   | <memberType>   |
	  | Language      | English        |
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	And the user validates default zip is used when page first load
	  | Distance 	  |	25             |
	Then the user validates the pharmacies available
	  | Language      | English        |
	When the user enters following details for pharmacy search
	  | Zip Code 	  |	               |
	  | Distance 	  |	<distance>     |
	Then the user verify error messages in pharmacy locator page
	When the user enters following details for pharmacy search
	  | Zip Code 	  |	9999           |
	  | Distance 	  |	<distance>     |
	Then the user verify error messages in pharmacy locator page
	And the user enters following details for pharmacy search
	  | Zip Code 	  | <zipcode>      |
	  | Distance 	  | <distance>     |
	Then the user validates the pharmacies available
	  | Language      | English        |
	And the user validates map section content
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	And the user validates show on map link
    And the user validates get direction link
	And the user validates more information content based on plan type
	And the user validates view search PDF link
    And the user validates pharmacy widgets
	  | Language      | English        |
	  | Plan Type     | <planType>     |
	  | Member Type   | <memberType>   |
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	  | Has Walgreens plan                         | <hasWalgreensPlan>      |
	  | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
	And the user selects Pharmacy Types to Filter
	  | Pharmacy Type | <pharmacyType> |
	  | Language      | English        |
	Then the user validates the pharmacies available
	  | Language      | English        |

	Examples: 
	  | TID 	| planType | memberType         		 | zipcode | distance | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
	  | 15273	| MAPD     | IndAARPMAPD_Pharmacylocator | 85215   | 15       | Open 24 hours               | False                 | False            | False                |
	  | 15295	| PDP      | IndAARPPDP_Pharmacylocator	 | 10980   | 15       | E-Prescribing               | True                  | False            | True                 |
	  | 15296	| MAPD     | GroupMAPD_Pharmacylocator	 | 61443   | 10       | Long-term care              | False                 | False            | False                |
	  | 15279	| MAPD     | Medica_Pharmacylocator		 | 33321   | 10       | Home Infusion and Specialty | False                 | False            | False                |
	  | 15280	| MAPD     | PCP_Pharmacylocator		 | 33174   | 10       | Retail Pharmacy             | False                 | False            | False                |
	  | 15274	| PDP      | TexasRx_Pharmacylocator	 | 14867   | 25       | Long-term care              | False                 | False            | False                |
	  | 15294	| MAPD     | IndMAPDUHC_Pharmacylocator	 | 29148   | 10       | E-Prescribing               | False                 | False            | False                |
	  | 15273	| MAPD     | Peehip_Pharmacylocator  	 | 29148   | 15       | E-Prescribing               | False                 | False            | False                |
	  | 15274	| PDP      | Walgreen_Pharmacylocator  	 | 80001   | 10       | Long-term care              | True                  | True             | True                 |

  @pharmacylocator2 @E2E @Chinese @Spanish @PharmacyDistanceDefaultZip @ValidateLanguageandZIPcode @ZipCodeErrorMessages @regressionMember @regressionMember_Testharness
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To verify end-to-end behavior for pharmacy locator page on member site
	Given login with following details logins in the member portal and validate elements
	  | Plan Type     | <planType>     |
	  | Member Type   | <memberType>   |
	When the user navigates to pharmacy search page
    #------ Chinese -----------------------------------
    When the user selects Chinese Language
	And the user validates header section content
	  | Member Type   | <memberType>   |
	And the user validates tooltips on filters
	  | Member Type   | <memberType>   |
	  | Language      | Chinese        |
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	And the user validates default zip is used when page first load
	  | Distance 	  |	25             |
	Then the user validates the pharmacies available
	  | Language      | Chinese        |
	When the user enters following details for pharmacy search
	  | Zip Code 	  |	               |
	  | Distance 	  |	<distance>     |
	Then the user verify error messages in pharmacy locator page
	When the user enters following details for pharmacy search
	  | Zip Code 	  |	9999           |
	  | Distance 	  |	<distance>     |
	Then the user verify error messages in pharmacy locator page
	And the user enters following details for pharmacy search
	  | Zip Code 	  | <zipcode>      |
	  | Distance 	  | <distance>     |
	Then the user validates the pharmacies available
	  | Language      | Chinese        |
	And the user validates map section content
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	And the user validates show on map link
    And the user validates get direction link
	And the user validates more information content based on plan type
	And the user validates view search PDF link
    And the user validates pharmacy widgets
	  | Language      | Chinese        |
	  | Plan Type     | <planType>     |
	  | Member Type   | <memberType>   |
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	  | Has Walgreens plan                         | <hasWalgreensPlan>      |
	  | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
	And the user selects Pharmacy Types to Filter
	  | Pharmacy Type | <pharmacyType> |
	  | Language      | Chinese        |
	Then the user validates the pharmacies available
	  | Language      | Chinese        |
    #------ Spanish -----------------------------------
    When the user selects Spanish Language
	And the user validates header section content
	  | Member Type   | <memberType>   |
	And the user validates tooltips on filters
	  | Member Type   | <memberType>   |
	  | Language      | Spanish        |
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	And the user validates default zip is used when page first load
	  | Distance 	  |	25             |
	Then the user validates the pharmacies available
	  | Language      | Spanish        |
	When the user enters following details for pharmacy search
	  | Zip Code 	  |	               |
	  | Distance 	  |	<distance>     |
	Then the user verify error messages in pharmacy locator page
	When the user enters following details for pharmacy search
	  | Zip Code 	  |	9999           |
	  | Distance 	  |	<distance>     |
	Then the user verify error messages in pharmacy locator page
	And the user enters following details for pharmacy search
	  | Zip Code 	  | <zipcode>      |
	  | Distance 	  | <distance>     |
	Then the user validates the pharmacies available
	  | Language      | Spanish        |
	And the user validates map section content
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	And the user validates show on map link
    And the user validates get direction link
	And the user validates more information content based on plan type
	And the user validates view search PDF link
    And the user validates pharmacy widgets
	  | Language      | Spanish        |
	  | Plan Type     | <planType>     |
	  | Member Type   | <memberType>   |
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	  | Has Walgreens plan                         | <hasWalgreensPlan>      |
	  | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
	And the user selects Pharmacy Types to Filter
	  | Pharmacy Type | <pharmacyType> |
	  | Language      | Spanish        |
	Then the user validates the pharmacies available
	  | Language      | Spanish        |

	Examples: 
	  | TID 	| planType | memberType         		 | zipcode | distance | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
	  | 15273	| MAPD     | IndAARPMAPD_Pharmacylocator | 85215   | 15       | Open 24 hours               | False                 | False            | False                |
	  | 15295	| PDP      | Walgreen_Pharmacylocator  	 | 80001   | 10       | Long-term care              | True                  | True             | True                 |

  @pharmacylocator3 @NegativeScenario @regressionMember @regressionMember_Testharness
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To verify pharmacy link is not displayed to MA/SHIP member in member site
	Given login with following details logins in the member portal and validate elements
	  | Plan Type   | <planType>   |
	  | Member Type | <memberType> |
	Then the user will not be able to see the locate a pharmacy on home page

	Examples: 
	  | TID   | planType | memberType        		 |
	  | 15272 | MA       | IndAARPMA_Pharmacylocator |
	  | 15272 | SHIP     | IndSHIP_Pharmacylocator   |
	  | 15272 | MA       | IndUHCMA_Pharmacylocator  |


  #-------------------------
  # note: this one below is for local run only - offline env
  # note: update following input and set env for offline
  # yourUsr = your unix username for member auth access offline
  # yourPwd = your unix password for member auth access offline 
  # offlineUsr = offline user that you want to run test with
  # note:
  #-------------------------
  @localOnly
  Scenario Outline: To validate via member authorization access
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    ### note: ----------------------------------------------------------  
    ### note: if step changes below this point, need to make sure @E2E has the same change  
    ### note: ----------------------------------------------------------  
    And user clicks on member to select
	When the user navigates to pharmacy search page
    #------ English -----------------------------------
	And the user validates header section content
	  | Member Type   | <memberType>   |
	And the user validates tooltips on filters
	  | Member Type   | <memberType>   |
	  | Language      | English        |
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	And the user validates default zip is used when page first load
	  | Distance 	  |	25             |
	Then the user validates the pharmacies available
	  | Language      | English        |
	When the user enters following details for pharmacy search
	  | Zip Code 	  |	               |
	  | Distance 	  |	<distance>     |
	Then the user verify error messages in pharmacy locator page
	When the user enters following details for pharmacy search
	  | Zip Code 	  |	9999           |
	  | Distance 	  |	<distance>     |
	Then the user verify error messages in pharmacy locator page
	And the user enters following details for pharmacy search
	  | Zip Code 	  | <zipcode>      |
	  | Distance 	  | <distance>     |
	Then the user validates the pharmacies available
	  | Language      | English        |
	And the user validates map section content
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	And the user validates show on map link
    And the user validates get direction link
	And the user validates more information content based on plan type
	And the user validates view search PDF link
    And the user validates pharmacy widgets
	  | Language      | English        |
	  | Plan Type     | <planType>     |
	  | Member Type   | <memberType>   |
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	  | Has Walgreens plan                         | <hasWalgreensPlan>      |
	  | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
	And the user selects Pharmacy Types to Filter
	  | Pharmacy Type | <pharmacyType> |
	  | Language      | English        |
	Then the user validates the pharmacies available
	  | Language      | English        |

	Examples: 
	  | TID   | username | password | MemUserName | planType | memberType         		   | zipcode | distance | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | xxxx  | yourUsr  | yourPwd  | offlineUsr  | PDP      | IndAARPMAPD_Pharmacylocator | 85215   | 15       | Open 24 hours               | True             | True        | True            |
      | xxxx  | yuorUsr  | yourPwd  | offlineUsr  | MAPD     | IndAARPMAPD_Pharmacylocator | 85215   | 15       | Open 24 hours               | False             | False        | True            |
  #-------------------------
  # this one above is for local run only - offline env
  #-------------------------
