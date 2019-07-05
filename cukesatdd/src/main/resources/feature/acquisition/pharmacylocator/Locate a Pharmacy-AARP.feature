@fixedTestCaseTest @pharmacylocatorulayer
Feature: 1.17-Acq-To test Locate a Pharmacy in acqusition flow AARP site

  #-------------------------
  # note: Acq ALM Pharmacy Locator Test cases located in OP regression
  # TID	: 15582 - TC_001_Locate a pharmacy_header nav PDP
  # TID	: 15583 - TC_002_Locate a pharmacy_header nav MAPD
  # TID	: 15584 - TC_003_Locate a pharmacy_VPP_ MAPD
  # TID : 15585 - TC_004_Locate a pharmacy_VPP_ PDP
  #-------------------------
  @pharmacylocatorulayerSmoke @pharmacyLocatorPerformanceUlayer
  Scenario Outline: To verify available pharmacies in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user hovers on shop for a Plan and select Request More Help and Information for following plan type in AARP Site
      | plantype |
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses a plan from dropdown in AARP Site
      | Plan Name | <planName> |
    Then the user validates the available pharmacies page in AARP site

    Examples: 
      | zipcode | distance | county       | planName                                          | plantype |
      | 80002   | 25 miles | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | MA       |
   #  | 80002   | 15 miles | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | MA       |


  @pharmacyLocatorUlayerSmoke
  Scenario Outline: To verify available pharmacies in AARP site for zipcode <zipcode> and county <county>
    Given the user is on AARP medicare acquisition site landing page
   When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses a plan from dropdown in AARP Site
      | Plan Name | <planName> |
      | planyear  | <planYear> |
    Then the user validates the available pharmacies page in AARP site
    Then the user chooses the Pharmacy Type
      | <pharmacytype> |
    Then the user chooses the Pharmacy Type
      | <servicetype> |
    Then the user validates the available pharmacies page in AARP site
    When the user selects a language from dropdown in AARP Site
      | <languageName> |
    And the user validates language changes in AARP site
    And the user chooses a plan from dropdown in AARP Site
      | Plan Name | <planName> |
      | planyear  | <planYear> |
    Then the user validates the available pharmacies page in AARP site

    Examples: 
      | zipcode | distance | county       | planName                                          | planYear | pharmacytype              | servicetype   | languageName |
      | 80002   | 25 miles | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | 2019     | Standard Network Pharmacy | Open 24 hours | Spanish      |
      | 90210   | 25 miles | None         | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | 2019     | Standard Network Pharmacy | Open 24 hours | Spanish      |
  #------------------------- END OF ACQUISITION SMOKE TESTS----
  
  @F250062 @PharmacySearchMultiCOunty @fastandfurious @Feb_release_2019
  Scenario Outline: Validate Cancel button for Multi Cunty Pop-up on PharmacySearch Page
    #TDB when I add @regression tag to the e2e Test case
    Given the user is on the AARP Medicare Site landing page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following Multi County details and  validates the Cancel button for Multi COunty Pop-up clears the Zip code text fields in pharmacy search in AARP Site
      | Zip Code | <zipcode> |
    When the user selects a language from dropdown in AARP Site
      | <languageName1> |
    And the user enters following Multi County details and  validates the Cancel button for Multi COunty Pop-up clears the Zip code text fields in pharmacy search in AARP Site
      | Zip Code | <zipcode> |
    When the user selects a language from dropdown in AARP Site
      | <languageName2> |
    And the user enters following Multi County details and  validates the Cancel button for Multi COunty Pop-up clears the Zip code text fields in pharmacy search in AARP Site
      | Zip Code | <zipcode> |

    Examples: 
      | zipcode | languageName1 | languageName2 |
      | 80002   | Chinese       | Spanish       |


  @pharmacyLocatorUlayerTC
  Scenario Outline: TID: <TID> : To verify Pharmacy Locator in AARP site for zipcode <zipcode> and county <county>
    Given the user is on AARP medicare acquisition site landing page
    When the user navigates to pharmacy search page in AARP Site
    And the user enters the invalid zipcode and validates the no results error message
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses a plan from dropdown in AARP Site
      | Plan Name | <planName> |
      | planyear  | <planYear> |
    Then the user validates the available pharmacies page in AARP site
    Then the user chooses the Pharmacy Type
      | <pharmacytype> |
    Then the user chooses the Pharmacy Type
      | <servicetype> |
    Then the user validates the available pharmacies page in AARP site
    Then the user validates the no pharmacies display error message
    When the user selects a language from dropdown in AARP Site
      | <languageName> |
    And the user validates language changes in AARP site
    And the user chooses a plan from dropdown in AARP Site
      | Plan Name | <planName> |
      | planyear  | <planYear> |
    Then the user validates the available pharmacies page in AARP site
   

    Examples: 
      | TID   | zipcode | distance | county       | planName                                          | planYear | pharmacytype                      | servicetype   | languageName |
      | 15583 | 80002   | 25 miles | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | 2019     | Standard Network Pharmacy         | Open 24 hours | Spanish      |
      | 15582 | 90210   | 15 miles | none         | AARP MedicareRx Walgreens (PDP)                   | 2019     | Preferred Retail Pharmacy Network | E-Prescribing | Spanish      |

  @vppPlanDetailsAarpPlE2E
  Scenario Outline: TID: <TID> : To verify the Pharmacy Locator page from the VPP plan details page navigation
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    When the user navigates to Pharmacy locator page from VPP plan details page
    And the user chooses a plan from dropdown in AARP Site
      | Plan Name | <planName> |
      | planyear  | <planYear> |
    Then the user validates the available pharmacies page in AARP site
    Then the user chooses the Pharmacy Type
      | <pharmacytype> |
    Then the user chooses the Pharmacy Type
      | <servicetype> |
    Then the user validates the available pharmacies page in AARP site
    Then the user validates the no pharmacies display error message
    When the user selects a language from dropdown in AARP Site
      | <languageName> |
    And the user validates language changes in AARP site
    And the user chooses a plan from dropdown in AARP Site
      | Plan Name | <planName> |
      | planyear  | <planYear> |
    Then the user validates the available pharmacies page in AARP site
    
    Examples: 
    |TID   | zipcode | isMultutiCounty | county           | plantype | planName                                          | distance  | planYear | pharmacytype              | servicetype   | languageName |
    |15584 | 80002   | Yes             | Adams County     | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO) | 25 miles  | 2019     | Standard Network Pharmacy | Open 24 hours | Spanish      |
    |15585 | 80002   | Yes             | Jefferson County | PDP      | AARP MedicareRx Walgreens (PDP)                   | 15 miles  | 2019     | Standard Network Pharmacy | Open 24 hours | Spanish      |
      
      
  @pharmacylocatorAcquisitionE2E @regression
  Scenario Outline: TID: <TID> -plan: <planType>  - To verify end-to-end behavior for pharmacy locator page on member site
 Given the user is on the Acquisition Site landing page
     | Site Name 	  |	<siteName>     |   
 When the user navigates to pharmacy search page in AARP Site
    #------ English -----------------------------------
	And the user validates header section content
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
    | County Name | <countyName>   |
  And the user chooses a plan from dropdown in AARP Site
      | Plan Name | <planName> |
      | planyear  | <planYear> |
	Then the user validates the pharmacies available
	  | Language      | English        |
	 And the user validates tooltips on filters
	  | Member Type   | <memberType>   |
	  | Language      | Spanish        |
	  | Has Preferred Retail Pharmacy network | <hasPrefRetailPhar> | 
	And the user validates map section content
	And the user validates show on map link
   And the user validates get direction link
	And the user validates more information content based on plan type
	And the user validates view search PDF link
		And the user validates pharmacy widgets
	  | Plan Type     | <planType>     |
	  | Member Type   | <memberType>   |
	  | Plan Name     | <planName> |
	  | Has Preferred Retail Pharmacy network | <hasPrefRetailPhar> | 
	  | Has Walgreens                         | <hasWalgreens>      |
	  | Has Preferred Mail Service Pharmacy   | <hasPrefdMailServ>  |
	And the user selects Pharmacy Types to Filter
	  | Pharmacy Type | <pharmacyType> |
	  | Language      | English        |
	Then the user validates the pharmacies available
	  | Language      | English        |
	Then the user validates the no pharmacies display error message
	Then the user validates the question widget
    #------ Chinese -----------------------------------
	When the user selects Chinese Language
	Then the user searches multi lang for pharmacy search results available
  And the user chooses a plan from dropdown in AARP Site
      | Plan Name | <planName> |
      | planyear  | <planYear> |
	Then the user validates the pharmacies available
	  | Language      | Chinese        |
	And the user validates header section content
	And the user validates tooltips on filters
	  | Member Type   | <memberType>   |
	  | Language      | Spanish        |
	  | Has Preferred Retail Pharmacy network | <hasPrefRetailPhar> | 
	And the user validates show on map link
	And the user validates more information content based on plan type
	And the user validates view search PDF link
    #------ Spanish -----------------------------------
	When the user selects Spanish Language
	Then the user searches multi lang for pharmacy search results available
	And the user chooses a plan from dropdown in AARP Site
      | Plan Name | <planName> |
      | planyear  | <planYear> |
	Then the user validates the pharmacies available
	  | Language      | Spanish          |
	And the user validates header section content
	And the user validates tooltips on filters
	  | Member Type   | <memberType>   |
	  | Language      | Spanish        |
	  | Has Preferred Retail Pharmacy network | <hasPrefRetailPhar> | 
	And the user validates show on map link
	And the user validates more information content based on plan type
	And the user validates view search PDF link

	Examples: 
	  | TID 	| planType | planName         		                                          | zipcode |   distance   | countyName |pharmacyType                | hasPrefRetailPhar | hasWalgreens | hasPrefdMailServ|planYear   |siteName|
	 # | 15583	| PDP      | AARP MedicareRx Walgreens (PDP)                                | 85215   |      15      | None       | Open 24 hours               | False             | True         | True            | 2019     | Ulayer |
	  | 15582	| PDP      | AARP MedicareRx Preferred (PDP)                                | 10980   |     15       | None       | E-Prescribing               | True              | False        | True            | 2019     | Blayer |
	  | 15296	| MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO)              | 80002   |     10       |Adams County| Long-term care              | False             | False        | True            | 2019     | Ulayer |
	  | 15279	| Medica   | Medica HealthCare Plans MedicareMax (HMO)                      | 33321   |     10       |   None     | Home Infusion and Specialty | False             | False        | True            | 2019     | Blayer |
	  | 15280	| PCP      | Preferred Choice Dade (HMO)	                                  | 33174   |     10       |   None     | Retail Pharmacy (90-day)    | False             | False        | True            | 2019     | Ulayer |
	  | 15274	| MAPD     | UnitedHealthcare MedicareComplete Choice Plan 3 (Regional PPO)	| 14867   |     25       |   None     | Long-term care              | False             | False        | True            | 2019     | Blayer |     
