@dce_redesign_home
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Home to NEW DCE Flows

  @DCE_ErrorMessages
  Scenario Outline: To verify DCE REDESIGN flow for Build Drug List Error Scenarios
    #Given the user is on AARP medicare acquisition site landing page
    #Given the user navigates to following AARP medicare acquisition site page
     # | PageName | <pageName> |
      #| PagePath | <path>     |
    Given the user is on medicare acquisition site landing page
   		|Site| <site>|
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user validates error message for blank search
    Then the user validates No Drug found error message for search
    Then user enter the following drug info and validates drug autocomplete
      | DrugNameAutoComplete | <drugnameAutocomplete> |
    Then the user selects the following Brand Name drug from the dropdown
      | BrandDrugName | <brandDrugName> |
    Then the user validates Tell Us About Drug - Brand page for the Drug
      | GenericName | <CheckGeneric> |
    #Then the user validates Blank Drug Quantity error message
    #Then the user selects following Drug Details
    Then the user clicks on Add Drug to add drug to drug list
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP

    #Examples: 
    # | path                                  | pageName                   | drugnameAutocomplete | brandDrugName | CheckGeneric | drug1         | zipCode | planType | planName                                            |
    # | health-plans/estimate-drug-costs.html | DCE Redesign - Get Started | ativ                 | Ativan        | Lorazepam    | buprenorphine |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |
		
		@DCE_ErrorMessages_AEP_AARP
    Examples: 
      | drugnameAutocomplete | brandDrugName | CheckGeneric | drug1         | zipCode | planType | planName                                            |site|
      | ativ                 | Ativan        | Lorazepam    | buprenorphine |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |AARP|
		
		@DCE_ErrorMessages_AEP_UHC
    Examples: 
      | drugnameAutocomplete | brandDrugName | CheckGeneric | drug1         | zipCode | planType | planName                                            |site|
      | ativ                 | Ativan        | Lorazepam    | buprenorphine |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |UHC|

  @DCE_DrugListTiersLimits
  Scenario Outline: To verify DCE REDESIGN Drug Cabinet Limit from Ulayer home page
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
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug5> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug6> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug7> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug8> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug9> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug10> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug11> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug12> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug13> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug14> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug15> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug16> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug17> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug18> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug19> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug20> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug21> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug22> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug23> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug24> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug25> |
    Then the user tries to add following drug over cabinet limit and validates error modal
      | DrugName | <drug26> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    When user selects plan year
    And user clicks on continue button in Zip Entry Page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Drug List in Your Drugs Section on Drug Details Page
    Then the user Validates All Tier info and Drug Limits displayed on Your Drugs Section on Drug Details Page
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Monthly Drug Costs by Stage Info Modals
    Then the user validates Drug List in Monthly Drug Costs by Stage Section on Drug Details Page
    Then the user validates Important information section
    Then the user Validates All Tier info and Drug Limits details displayed in Important Information Section on Drug Details Page
    #Then the user validates Disclaimers section
    Then the user validates link to Drug Summary Page

    @DCE_DrugListTiersLimits_AEP_AARP
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | drug5   | drug6   | drug7     | drug8                | drug9           | drug10    | drug11           | drug12     | drug13        | drug14     | drug15               | drug16        | drug17  | drug18 | drug19 | drug20  | drug21 | drug22     | drug23     | drug24          | drug25  | drug26  | zipCode | planType | planName                                            |site|
      | Orkambi | Fanapt | Humalog | Adderall | Orfadin | Lipitor | meloxicam | diclofenac potassium | codeine sulfate | Duramorph | fentanyl citrate | febuxostat | buprenorphine | vigabatrin | fentanyl transdermal | Advair Diskus | Tylenol | Bumex  | Ativan | Adcirca | Emsam  | droperidol | dronabinol | E.E.S. Granules | Aimovig | Vraylar |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |AARP|

		@DCE_DrugListTiersLimits_AEP_UHC
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | drug5   | drug6   | drug7     | drug8                | drug9           | drug10    | drug11           | drug12     | drug13        | drug14     | drug15               | drug16        | drug17  | drug18 | drug19 | drug20  | drug21 | drug22     | drug23     | drug24          | drug25  | drug26  | zipCode | planType | planName                                            |site|
      | Orkambi | Fanapt | Humalog | Adderall | Orfadin | Lipitor | meloxicam | diclofenac potassium | codeine sulfate | Duramorph | fentanyl citrate | febuxostat | buprenorphine | vigabatrin | fentanyl transdermal | Advair Diskus | Tylenol | Bumex  | Ativan | Adcirca | Emsam  | droperidol | dronabinol | E.E.S. Granules | Aimovig | Vraylar |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |UHC|


  @DCE_AllTiers_DrugLimits_Validation
  Scenario Outline: To verify DCE REDESIGN flow from Ulayer home page
    Given the user is on AARP medicare acquisition site landing page
    When I click on DCE Redesign link from Shop for a plan hover over for AARP site
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
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page in AARP
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Important information section

    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode |
      | Orkambi | Fanapt | Humalog | Adderall |   80002 |
