@pharmacylocatorblayer
Feature: 1.17-Acq-To test Locate a Pharmacy in acqusition flow UHC site

  #------------------------- BEGINNING OF ACQUISITION SMOKE TESTS----
  @pharmacylocatorBlayerSmoke @pharmacyLocatorPerformanceBlayer
  Scenario Outline: To verify available pharmacies
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page
      | Site Name 	  |	<siteName>     |   
	And the user enters following details for pharmacy search
	  | Zip Code 	  | <zipcode>      |
	  | Distance 	  | <distance>     |
      | County Name   | <countyName>   |
    And the user chooses a plan from dropdown
      | Plan Name     | <planName>     |
      | planyear      | <planYear>     |
	Then the user validates the pharmacies available
	  | Language      | English        |

    Examples: 
      | siteName | zipcode | distance | countyName   | planName                                          | plantype | planYear |
      | Blayer   | 80002   | 25       | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | MA       | 2019     |
   #  | Blayer   | 80002   | 15       | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | MA       | 2019     |


  @pharmacylocatorBlayerSmoke
  Scenario Outline: To verify available pharmacies page for zipcode <zipcode> and county <county>
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page
      | Site Name 	  |	<siteName>     |   
	And the user enters following details for pharmacy search
	  | Zip Code 	  | <zipcode>      |
	  | Distance 	  | <distance>     |
      | County Name   | <countyName>   |
    And the user chooses a plan from dropdown
      | Plan Name     | <planName>     |
      | planyear      | <planYear>     |
	Then the user validates the pharmacies available
	  | Language      | English        |
    Then the user chooses the Pharmacy Type
      | Filter Type   | <pharmacytype> |
    Then the user chooses the Pharmacy Type
      | Filter Type   | <servicetype> |
	Then the user validates the pharmacies available
	  | Language      | English        |
	When the user selects Spanish Language
	And the user enters following details for pharmacy search
	  | Zip Code 	  | <zipcode>      |
	  | Distance 	  | <distance>     |
      | County Name   | <countyName>   |
    And the user chooses a plan from dropdown
      | Plan Name     | <planName>     |
      | planyear      | <planYear>     |
	Then the user validates the pharmacies available
	  | Language      | Spanish        |

    Examples: 
      | siteName | zipcode | distance | countyName   | planName                                          | planYear | pharmacytype              | servicetype   |
      | Blayer   | 80002   | 25       | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | 2019     | Standard Network Pharmacy | Open 24 hours |
      | Blayer   | 90210   | 25       | None         | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | 2019     | Standard Network Pharmacy | Open 24 hours |
  #------------------------- END OF ACQUISITION SMOKE TESTS----

  #-------------------------
  # note: Acq ALM Pharmacy Locator Test cases located in OP regression
  # Blayer
  # TID	: 15586 - TC_001_Locate a pharmacy_header nav PDP
  # TID	: 15587 - TC_002_Locate a pharmacy_header nav MAPD
  # TID	: 15588 - TC_003_Locate a pharmacy_VPP_ MAPD
  # TID : 15589 - TC_004_Locate a pharmacy_VPP_ PDP
  #
  # BYPASS KNOWN ISSUES
  # ticket INC12081940 - Walgreen widget is not showing for Chinese and Spanish page
  #-------------------------
  @pharmacylocatorblayer01 @shopPlan @English @pharmacylocatorAcquisitionE2E @regression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - To verify end-to-end behavior for pharmacy locator page on acquisition site
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page
      | Site Name 	  |	<siteName>     |   
    #------ English -----------------------------------
	And the user validates header section content
	And the user validates default zip is not null
	When the user enters following details for pharmacy search
	  | Zip Code 	  |	               |
	  | Distance 	  |	<distance>     |
	Then the user verify error messages in pharmacy locator page
	  | Language      | English        |
	When the user enters following details for pharmacy search
	  | Zip Code 	  |	9999           |
	  | Distance 	  |	<distance>     |
	Then the user verify error messages in pharmacy locator page
	  | Language      | English        |
	And the user enters following details for pharmacy search
	  | Zip Code 	  | <zipcode>      |
	  | Distance 	  | <distance>     |
      | County Name   | <countyName>   |
    And the user chooses a plan from dropdown
      | Plan Name     | <planName>     |
      | planyear      | <planYear>     |
	Then the user validates the pharmacies available
	  | Language      | English        |
	And the user validates tooltips on filters
	  | Language      | English        |
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	And the user validates map section content
	And the user validates show on map link
    And the user validates get direction link
	And the user validates more information content based on plan type
	And the user validates view search PDF link
    And the user validates pharmacy widgets
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	  | Has Walgreens plan                         | <hasWalgreensPlan>      |
	  | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
	And the user selects Pharmacy Types to Filter
	  | Pharmacy Type | <pharmacyType> |
	  | Language      | English        |
	Then the user validates the pharmacies available
	  | Language      | English        |
	Then the user validates error message displayed when filter results in no match
	Then the user validates the question widget

	Examples: 
	  | TID 	| planName         		                                         | zipcode | distance  | countyName     | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan | planYear | siteName |
	  | 15582	| AARP MedicareRx Preferred (PDP)                                | 10980   | 15        | None           | E-Prescribing               | True                  | False            | True                 | 2019     | Blayer   |
	  | 15582	| AARP MedicareRx Walgreens (PDP)                                | 85215   | 15        | None           | Open 24 hours               | True                  | True             | True                 | 2019     | Blayer   |
	  | 15582	| AARP MedicareRx Walgreens (PDP)                                | 78006   | 15        | Kendall County | Open 24 hours               | True                  | True             | True                 | 2019     | Blayer   |
	  | 15583	| AARP MedicareComplete Choice Plan 1 (PPO)                      | 78006   | 10        | Comal County   | Retail Pharmacy             | False                 | False            | True                 | 2019     | Blayer   |
	  | 15583	| AARP MedicareComplete SecureHorizons Plan 1 (HMO)              | 80002   | 10        | Adams County   | Long-term care              | False                 | False            | True                 | 2019     | Blayer   |
	  | 15583	| UnitedHealthcare MedicareComplete Choice Plan 3 (Regional PPO) | 14867   | 25        | None           | Long-term care              | False                 | False            | True                 | 2019     | Blayer   |     
	  | 15583	| Medica HealthCare Plans MedicareMax (HMO)                      | 33321   | 10        | None           | Home Infusion and Specialty | False                 | False            | True                 | 2019     | Blayer   |


  @pharmacylocatorblayer02 @shopPlan @Spanish @Chinese @pharmacylocatorAcquisitionE2E @regression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - To verify end-to-end behavior for pharmacy locator page on acquisition site
    Given the user is on the Acquisition Site landing page and navigate to pharmacy search page
      | Site Name 	  |	<siteName>     |   
    #------ Chinese -----------------------------------
	When the user selects Chinese Language
	And the user validates header section content
	And the user validates default zip is not null
	When the user enters following details for pharmacy search
	  | Zip Code 	  |	               |
	  | Distance 	  |	<distance>     |
	Then the user verify error messages in pharmacy locator page
	  | Language      | Chinese        |
	When the user enters following details for pharmacy search
	  | Zip Code 	  |	9999           |
	  | Distance 	  |	<distance>     |
	Then the user verify error messages in pharmacy locator page
	  | Language      | Chinese        |
	And the user enters following details for pharmacy search
	  | Zip Code 	  | <zipcode>      |
	  | Distance 	  | <distance>     |
      | County Name   | <countyName>   |
    And the user chooses a plan from dropdown
      | Plan Name     | <planName>     |
      | planyear      | <planYear>     |
	Then the user validates the pharmacies available
	  | Language      | Chinese        |
	And the user validates tooltips on filters
	  | Language      | Chinese        |
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	And the user validates map section content
	And the user validates show on map link
    And the user validates get direction link
	And the user validates more information content based on plan type
	And the user validates view search PDF link
    And the user validates pharmacy widgets
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	  | Has Walgreens plan                         | <hasWalgreensPlan>      |
	  | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
	And the user selects Pharmacy Types to Filter
	  | Pharmacy Type | <pharmacyType> |
	  | Language      | Chinese        |
	Then the user validates the pharmacies available
	  | Language      | Chinese        |
	Then the user validates error message displayed when filter results in no match
	Then the user validates the question widget
    #------ Spanish -----------------------------------
	When the user selects Spanish Language
	And the user validates header section content
	And the user validates default zip is not null
	When the user enters following details for pharmacy search
	  | Zip Code 	  |	               |
	  | Distance 	  |	<distance>     |
	Then the user verify error messages in pharmacy locator page
	  | Language      | Spanish        |
	When the user enters following details for pharmacy search
	  | Zip Code 	  |	9999           |
	  | Distance 	  |	<distance>     |
	Then the user verify error messages in pharmacy locator page
	  | Language      | Spanish        |
	And the user enters following details for pharmacy search
	  | Zip Code 	  | <zipcode>      |
	  | Distance 	  | <distance>     |
      | County Name   | <countyName>   |
    And the user chooses a plan from dropdown
      | Plan Name     | <planName>     |
      | planyear      | <planYear>     |
	Then the user validates the pharmacies available
	  | Language      | Spanish        |
	And the user validates tooltips on filters
	  | Language      | Spanish        |
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	And the user validates map section content
	And the user validates show on map link
    And the user validates get direction link
	And the user validates more information content based on plan type
	And the user validates view search PDF link
    And the user validates pharmacy widgets
	  | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> | 
	  | Has Walgreens plan                         | <hasWalgreensPlan>      |
	  | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
	And the user selects Pharmacy Types to Filter
	  | Pharmacy Type | <pharmacyType> |
	  | Language      | Spanish        |
	Then the user validates the pharmacies available
	  | Language      | Spanish        |
	Then the user validates error message displayed when filter results in no match
	Then the user validates the question widget

	Examples: 
	  | TID 	| planName         		                                         | zipcode | distance  | countyName     | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan| planYear | siteName |
	  | 15582	| AARP MedicareRx Preferred (PDP)                                | 10980   | 15        | None           | E-Prescribing               | True                  | False            | True                | 2019     | Blayer   |
	  | 15582	| AARP MedicareRx Walgreens (PDP)                                | 78006   | 15        | Kendall County | Open 24 hours               | True                  | True             | True                | 2019     | Blayer   |
	  | 15583	| AARP MedicareComplete Choice Plan 1 (PPO)                      | 78006   | 10        | Comal County   | Retail Pharmacy             | False                 | False            | True                | 2019     | Blayer   |


  @pharmacylocatorblayer03 @onlinePharmacyDir @regression
  Scenario Outline: TID: <TID> -plan: <planType> - To verify navigation to pharmacy search page from VPP page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type       | <planType>        |
    And the user selects the first plan to view plan detail
      | Plan Type       | <planType>        |
    And the user navigates to pharmacy locator page using Online pharmacy directory link  
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
	
	Examples: 
	  | TID 	| planType | zipcode | isMultutiCounty | county           | 
	  | 15584	| MA       | 80002   | Yes             | Adams County     | 
	  | 15585	| PDP      | 80001   | No              | Jefferson County | 
	  | xxxxx	| SNP      | 78006   | Yes             | Comal County     | 
