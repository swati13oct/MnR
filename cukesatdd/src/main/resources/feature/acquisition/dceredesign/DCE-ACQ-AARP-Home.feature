@dce_redesign_home
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Home to NEW DCE Flows


  @DCE_HomeIcon
  Scenario Outline: To verify DCE REDESIGN flow from <site> home page 
    #Given the user is on AARP medicare acquisition site landing page
    Given the user is on medicare acquisition site landing page
   		|Site| <site>|
    When I access the acquisition DCE Redesign from home page
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
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Important information section
    #Then the user validates Disclaimers section
		Then the user validates link to Drug Summary Page

    @DCE_HomeIcon_AEP_AARP
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode | planType | planName                                            |site|
      | Orkambi | Fanapt | Humalog | Adderall |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |AARP|

	 @DCE_HomeIcon_AEP_UHC
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode | planType | planName                                            |site|
      | Orkambi | Fanapt | Humalog | Adderall |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |UHC|
  
  
  
  
  @DCE_HomeSubNav @DCE_HomeSubNav_AEP
  Scenario Outline: To verify DCE REDESIGN flow from Ulayer home page
    Given the user is on medicare acquisition site landing page
   		|Site| <site>|
    When I access the acquisition DCE Redesign from home page
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
    And user clicks on continue button in Zip Entry Page
    
		@DCE_HomeSubNav_AEP_AARP
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode |site|
      | Orkambi | Fanapt | Humalog | Adderall |   80002 |AARP|
		
		@DCE_HomeSubNav_AEP_UHC
		Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode |site|
      | Orkambi | Fanapt | Humalog | Adderall |   80002 |UHC|
      
      
      @drugSummary_DefaultPlanType @F504721
  Scenario Outline: To verify default plan type on drug summary page when no MAPD plans available -home page -DCE
    Given the user is on medicare acquisition site landing page
   		|Site| <site>|
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county 
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user should be able to see "Medicare Prescription Drug Plans" by default
    
		@drugSummary_DefaultPlanType_AARP
    Examples: 
      | drug1   |zipCode |site|
      | Orkambi | 74562 |AARP|
		
		@drugSummary_DefaultPlanType_UHC
		Examples: 
      | drug1   | zipCode |site|
      | Orkambi | 74562 |UHC|