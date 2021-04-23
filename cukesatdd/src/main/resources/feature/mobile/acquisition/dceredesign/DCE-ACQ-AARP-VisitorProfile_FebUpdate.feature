@dce_redesign_VP
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Visitor Profile to NEW DCE Flows

  @DCE_VisitorProfile
  Scenario Outline: To verify DCE REDESIGN flow from Ulayer home page
    Given the user is on medicare acquisition site landing page
    		|Site| <site>|
    And the user clicks on the shopping cart icon
    And the user clicks on the add drugs button to navigate to DCE Redesign on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user selects plan year
    And user clicks on continue button in Zip Entry Page

		@DCE_VisitorProfile_AARP
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode |site|
      | Orkambi | Fanapt | Humalog | Adderall |   80002 |AARP|
      
      @DCE_VisitorProfile_UHC
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode |site|
      | Orkambi | Fanapt | Humalog | Adderall |   80002 |UHC|


	@DCEShopperProfileAddDrugsGlobally @decRelease
  Scenario Outline: To verify DCE REDESIGN shopper profile flow when adding and editing drugs globally
  Given the user is on medicare acquisition site landing page
    		|Site| <site>|
    When the user navigate to Visitor profile page
    And the user clicks on the add drugs button globally on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
      Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see Return to profile link on summary page
    And Back to profile button should be displayed for each plan card
    When user clicks on Back to profile button
    Then user should be navigated to shopper profile page
    When user clicks on Edit Drug and Pharmacy on visitor profile page
    Then user should be navigated to build drug list page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
      Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see Return to profile link on summary page
    And Back to profile button should be displayed for each plan card
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then user should be able to see Return to profile link on details page
    
    @DCEShopperProfileAddDrugsGlobally_AARP @regressionAARP
    Examples: 
      | drug1   | zipCode |site|drug2|planType|planName|
      | Orkambi | 80002 |AARP|Fanapt|MAPD|AARP Medicare Advantage SecureHorizons Plan 2 (HMO)|
      
      @DCEShopperProfileAddDrugsGlobally_UHC
      Examples: 
      | drug1   | zipCode |site|drug2|planType|planName|
      | Orkambi | 80002 |UHC|Fanapt|MAPD|AARP Medicare Advantage SecureHorizons Plan 2 (HMO)|
      
      
      @DCEShopperProfileAddDrugsPlancard @decRelease
  Scenario Outline: To verify DCE REDESIGN shopper profile flow when adding and editing drugs from plan card
   Given the user is on medicare acquisition site landing page
    		|Site| <site>|
    When the user performs plan search using following information
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type
    	| Plan Type  | <plantype>  |
    Then user saves two plans as favorite
      | Plan Type  | <plantype>  |
      | Test Plans | <testPlans> |
    Then user gets a create profile prompt
    Then user click on view saved plans button
    And user validates the added plans on new visitor profile page
      | Test Plans | <testPlans> |
    And the user clicks on the enter drug information button from plan card on Visitor Profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
		And clicks on Review drug cost button
    Then user should be able to see Return to profile link on details page
    When user clicks on Return to profile link on details page
    Then user should be navigated to shopper profile page
    And user should see back to drug cost estimator link on visitor profile page
    When user clicks on edit drugs button from plan card
    Then user should be navigated to build drug list page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    And clicks on Review drug cost button
    Then user should be able to see Return to profile link on details page
    
    @DCEShopperProfileAddDrugsPlancard_AARP @regressionAARP
    Examples: 
      |site| drug1   | drug2|plantype|testPlans|zipcode | isMultiCounty | county|    
      |AARP| Orkambi | Fanapt|MAPD|AARP Medicare Advantage Plan 1 (HMO),AARP Medicare Advantage Plan 2 (HMO)|10001 | NO            | New York County|
      
      @DCEShopperProfileAddDrugsPlancard_UHC
      Examples: 
      |site| drug1   | drug2|plantype|testPlans|zipcode | isMultiCounty | county|    
      |UHC| Orkambi | Fanapt|MAPD|AARP Medicare Advantage Plan 1 (HMO),AARP Medicare Advantage Plan 2 (HMO)|10001 | NO            | New York County|
      
      
      @DCEShopperProfileAddDrugsGloballyAuthenticatedUser @decRelease
  Scenario Outline: To verify DCE REDESIGN shopper profile flow when adding and editing drugs globally for authenticated user
  	Given the user is on medicare acquisition site landing page
    		|Site| <site>|
    When the user navigate to Visitor profile page
    And the user login with optum Id credentials
      | User Name | <userName> |
      | Password  | <password> |
    And user clears the existing drugs in Visitor profile
    And user clears the provider in visitor profile page
    #And user removed existing saved plans
    And the user clicks on the add drugs button globally on the profile page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
      Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see Return to profile link on summary page
    And Back to profile button should be displayed for each plan card
    When user clicks on Back to profile button
    Then user should be navigated to shopper profile page
    When user clicks on edit drugs button globally
    Then user should be navigated to build drug list page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
      Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see Return to profile link on summary page
    And Back to profile button should be displayed for each plan card
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then user should be able to see Return to profile link on details page
    
    @DCEShopperProfileAddDrugsGloballyAuthenticatedUser_AARP123
    Examples: 
      |site| drug1   | zipCode |drug2|planType|planName|userName| password|
      |AARP| Orkambi | 80002 |Fanapt|MAPD|AARP Medicare Advantage SecureHorizons Plan 2 (HMO)|chargersdev@1 | Password@1 |
      
      @DCEShopperProfileAddDrugsGloballyAuthenticatedUser_UHC
      Examples: 
      |site| drug1   | zipCode |drug2|planType|planName|userName| password|
      |UHC| Orkambi | 80002 |Fanapt|MAPD|AARP Medicare Advantage SecureHorizons Plan 2 (HMO)|chargersdev@1 | Password@1 |