@pharmacylocator @gladiators
Feature: 1.11 Member Pharmacy Locator tool Page

  #-------------------------
  @memAuth_pharmacylocator1 @E2E @English @PharmacyDistanceDefaultZip @ValidateLanguageandZIPcode @ZipCodeErrorMessages
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator English page on member site
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
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

	@memAuth_pharmacylocator1a
	Examples: 
	  | TID 	| username  | password  | MemUserName     | planType | memberType         		   | zipcode | distance | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
	  | 15273	| qavgogine | qavgogine | q2_apr_aarp0250 | MAPD     | IndAARPMAPD_Pharmacylocator | 85215   | 15       | Open 24 hours               | False                 | False            | True                 |
	  | 15296	| qavgogine | qavgogine | q4_grp_dec0075    | MAPD     | GroupMAPD_Pharmacylocator   | 61443   | 15       | E-Prescribing               | False                 | False            | False                |
	  | 15279	| qavgogine | qavgogine | q2_oct_uhc0001    | MAPD     | Medica_Pharmacylocator	   | 33321   | 10       | Home Infusion and Specialty | False                 | False            | True                 |
	  | 15280	| qavgogine | qavgogine | q3_sep_aarp00982    | MAPD     | PCP_Pharmacylocator		   | 33174   | 10       | Retail Pharmacy             | False                 | False            | True                 |

	@memAuth_pharmacylocator1b
	Examples: 
	  | TID 	| username  | password  | MemUserName     | planType | memberType         		   | zipcode | distance | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
	  | 15295	| qavgogine | qavgogine | q2_jun_aarp0179    | PDP      | IndAARPPDP_Pharmacylocator  | 10980   | 15       | E-Prescribing               | True                  | False            | True                 |

	@memAuth_pharmacylocator1b
	Examples: 
	  | TID 	| username  | password  | MemUserName     | planType | memberType         		   | zipcode | distance | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
	  | 15294	| qavgogine | qavgogine | q1_apr_uhc002    | MAPD     | IndMAPDUHC_Pharmacylocator  | 29148   | 10       | E-Prescribing               | False                 | False            | True                 |
	  | 15274	| qavgogine | qavgogine | q3_sep_UAT4_Group130    | MA       | TexasRx_Pharmacylocator	   | 14867   | 25       | E-Prescribing               | False                 | False            | False                |
	  | 15274	| qavgogine | qavgogine | q3_sep_aarp0272    | PDP      | Walgreen_Pharmacylocator    | 80001   | 10       | Long-term care              | True                  | True             | True                 |
	#note: PEEHIP terminated group plan w/ UHC, no longer a valid active plan case
	# | 15273	| qavgogine | qavgogine | testusername    | MAPD     | Peehip_Pharmacylocator  	   | 29148   | 15       | E-Prescribing               | False                 | False            | False                |

  @memAuth_pharmacylocator2 @E2E @English @PharmacyDistanceDefaultZip @ValidateLanguageandZIPcode @ZipCodeErrorMessages
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Part 2 of 2 - To verify end-to-end behavior for pharmacy locator English page on member site
   Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
	When the user navigates to pharmacy search page
    #------ English -----------------------------------
	And the user enters following details for pharmacy search
	  | Zip Code 	  | <zipcode>      |
	  | Distance 	  | <distance>     |
	And the user selects Pharmacy Types to Filter
	  | Pharmacy Type | <pharmacyType> |
	  | Language      | English        |
	Then the user validates the pharmacies available
	  | Language      | English        |
    And the user validates pharmacy widgets
	  | Language      | English        |
	  | Plan Type     | <planType>     |
	  | Member Type   | <memberType>   |
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	  | Has Walgreens plan                         | <hasWalgreensPlan>      |
	  | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |

	@memAuth_pharmacylocator2a
	Examples: 
	  | TID 	| username  | password  | MemUserName     | planType | memberType         		   | zipcode | distance | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
	  | 15273	| qavgogine | qavgogine | q2_apr_aarp0250 | MAPD     | IndAARPMAPD_Pharmacylocator | 85215   | 15       | Open 24 hours               | False                 | False            | True                 |
	  | 15296	| qavgogine | qavgogine | q4_grp_dec0075    | MAPD     | GroupMAPD_Pharmacylocator   | 61443   | 15       | E-Prescribing               | False                 | False            | False                |
	  | 15279	| qavgogine | qavgogine | q2_oct_uhc0001    | MAPD     | Medica_Pharmacylocator	   | 33321   | 10       | Home Infusion and Specialty | False                 | False            | True                 |
	  | 15280	| qavgogine | qavgogine | q3_sep_aarp00982    | MAPD     | PCP_Pharmacylocator		   | 33174   | 10       | Retail Pharmacy             | False                 | False            | True                 |

	@memAuth_pharmacylocator2b
	Examples: 
	  | TID 	| username  | password  | MemUserName     | planType | memberType         		   | zipcode | distance | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
	  | 15295	| qavgogine | qavgogine | q2_jun_aarp0179    | PDP      | IndAARPPDP_Pharmacylocator  | 10980   | 15       | E-Prescribing               | True                  | False            | True                 |

	@memAuth_pharmacylocator2b
	Examples: 
	  | TID 	| username  | password  | MemUserName     | planType | memberType         		   | zipcode | distance | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
	  | 15294	| qavgogine | qavgogine | q1_apr_uhc002    | MAPD     | IndMAPDUHC_Pharmacylocator  | 29148   | 10       | E-Prescribing               | False                 | False            | True                 |
	  | 15274	| qavgogine | qavgogine | q3_sep_UAT4_Group130    | MA       | TexasRx_Pharmacylocator	   | 14867   | 25       | E-Prescribing               | False                 | False            | False                |
	  | 15274	| qavgogine | qavgogine | q3_sep_aarp0272    | PDP      | Walgreen_Pharmacylocator    | 80001   | 10       | Long-term care              | True                  | True             | True                 |
	#note: PEEHIP terminated group plan w/ UHC, no longer a valid active plan case
	# | 15273	| qavgogine | qavgogine | testusername    | MAPD     | Peehip_Pharmacylocator  	   | 29148   | 15       | E-Prescribing               | False                 | False            | False                |


  @memAuth_pharmacylocator3 @E2E @Chinese @PharmacyDistanceDefaultZip @ValidateLanguageandZIPcode @ZipCodeErrorMessages
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator Chinese page on member site
   Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
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

	Examples: 
	  | TID 	| username  | password  | MemUserName     | planType | memberType         		 | zipcode | distance | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
	  | 15273	| qavgogine | qavgogine | q2_apr_aarp0250    | MAPD     | IndAARPMAPD_Pharmacylocator | 85215   | 15       | Open 24 hours               | False                 | False            | True                 |
	  | 15295	| qavgogine | qavgogine | q3_sep_aarp0272    | PDP      | Walgreen_Pharmacylocator  	 | 80001   | 10       | Long-term care              | True                  | True             | True                 |

  @memAuth_pharmacylocator4 @E2E @Chinese @PharmacyDistanceDefaultZip @ValidateLanguageandZIPcode @ZipCodeErrorMessages
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Part 2 of 2 - To verify end-to-end behavior for pharmacy locator Chinese page on member site
	   Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
	When the user navigates to pharmacy search page
    #------ Chinese -----------------------------------
    When the user selects Chinese Language
	And the user enters following details for pharmacy search
	  | Zip Code 	  | <zipcode>      |
	  | Distance 	  | <distance>     |
	And the user selects Pharmacy Types to Filter
	  | Pharmacy Type | <pharmacyType> |
	  | Language      | Chinese        |
	Then the user validates the pharmacies available
	  | Language      | Chinese        |
    And the user validates pharmacy widgets
	  | Language      | Chinese        |
	  | Plan Type     | <planType>     |
	  | Member Type   | <memberType>   |
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	  | Has Walgreens plan                         | <hasWalgreensPlan>      |
	  | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |

	Examples: 
	  | TID 	| username  | password  | MemUserName     | planType | memberType         		 | zipcode | distance | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
	  | 15273	| qavgogine | qavgogine | q2_apr_aarp0250    | MAPD     | IndAARPMAPD_Pharmacylocator | 85215   | 15       | Open 24 hours               | False                 | False            | True                 |
	  | 15295	| qavgogine | qavgogine | q3_sep_aarp0272    | PDP      | Walgreen_Pharmacylocator  	 | 80001   | 10       | Long-term care              | True                  | True             | True                 |


  @memAuth_pharmacylocator5 @E2E @Spanish @PharmacyDistanceDefaultZip @ValidateLanguageandZIPcode @ZipCodeErrorMessages
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator Spanish page on member site
   Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
	When the user navigates to pharmacy search page
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

	Examples: 
	  | TID 	| username  | password  | MemUserName     | planType | memberType         		 | zipcode | distance | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
	  | 15273	| qavgogine | qavgogine | q2_apr_aarp0250    | MAPD     | IndAARPMAPD_Pharmacylocator | 85215   | 15       | Open 24 hours               | False                 | False            | True                 |
	  | 15295	| qavgogine | qavgogine | q3_sep_aarp0272    | PDP      | Walgreen_Pharmacylocator  	 | 80001   | 10       | Long-term care              | True                  | True             | True                 |


  @memAuth_pharmacylocator6 @E2E @Spanish @PharmacyDistanceDefaultZip @ValidateLanguageandZIPcode @ZipCodeErrorMessages
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Part 2 of 2 - To verify end-to-end behavior for pharmacy locator Spanish page on member site
	   Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
	When the user navigates to pharmacy search page
    #------ Spanish -----------------------------------
    When the user selects Spanish Language
	And the user selects Pharmacy Types to Filter
	  | Pharmacy Type | <pharmacyType> |
	  | Language      | Spanish        |
	Then the user validates the pharmacies available
	  | Language      | Spanish        |
	And the user enters following details for pharmacy search
	  | Zip Code 	  | <zipcode>      |
	  | Distance 	  | <distance>     |
    And the user validates pharmacy widgets
	  | Language      | Spanish        |
	  | Plan Type     | <planType>     |
	  | Member Type   | <memberType>   |
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	  | Has Walgreens plan                         | <hasWalgreensPlan>      |
	  | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |

	Examples: 
	  | TID 	| username  | password  | MemUserName     | planType | memberType         		 | zipcode | distance | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
	  | 15273	| qavgogine | qavgogine | q2_apr_aarp0250    | MAPD     | IndAARPMAPD_Pharmacylocator | 85215   | 15       | Open 24 hours               | False                 | False            | True                 |
	  | 15295	| qavgogine | qavgogine | q3_sep_aarp0272    | PDP      | Walgreen_Pharmacylocator  	 | 80001   | 10       | Long-term care              | True                  | True             | True                 |


  @memAuth_pharmacylocator7 @NegativeScenario 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To verify pharmacy link is not displayed to MA/SHIP member in member site
   Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    #-------------- navigate to the target test page for testing
	Then the user will not be able to see the locate a pharmacy on home page

	Examples: 
	  | TID   | username  | password  | MemUserName     | planType | memberType        		 |
	  | 15272 | qavgogine | qavgogine | q3_sept_UAT4_AARP_016    | MA       | IndAARPMA_Pharmacylocator |
	  | 15272 | qavgogine | qavgogine | q1_uhc_ma001    | MA       | IndUHCMA_Pharmacylocator  |
	  | 15272 | qavgogine | qavgogine | q2_jun_ship0190    | SHIP     | IndSHIP_Pharmacylocator   |

