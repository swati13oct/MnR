@dce_redesign_home
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Home to NEW DCE Flows

  @DCE_ErrorMessages
  Scenario Outline: To verify DCE REDESIGN flow from Ulayer home page
    Given the user is on AARP medicare acquisition site landing page
    Given the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user validates error message for blank search
    Then the user validates No Drug found error message for search
    Then user enter the following drug info and validates drug autocomplete
      | DrugNameAutoComplete | <drugnameAutocomplete> |
    Then the user selects the following Brand Name drug from the dropdown
      | BrandDrugName | <brandDrugName> |
    #Then the user validates Tell Us About Drug - Brand page for the Drug
    #  | GenericName | <CheckGeneric> |
    #Then the user validates Blank Drug Quantity error message
    #Then the user selects following Drug Details
    Then the user clicks on Add Drug to add drug to drug list
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page in AARP
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP

    Examples: 
      | path                                  | pageName                   | drugnameAutocomplete | brandDrugName | CheckGeneric | drug1         | zipCode | planType | planName                                            |
      | health-plans/estimate-drug-costs.html | DCE Redesign - Get Started | ativ                 | Ativan        | Lorazepam    | buprenorphine |   90210 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |

  @DCE_HomeIcon
  Scenario Outline: To verify DCE REDESIGN flow from Ulayer home page
    Given the user is on AARP medicare acquisition site landing page
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
    #Then the user validates Disclaimers section
		Then the user validates link to Drug Summary Page

    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode | planType | planName                                            |
      | Orkambi | Fanapt | Humalog | Adderall |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |

  @DCE_HomeSubNav
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
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county in AARP
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page in AARP

    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode |
      | Orkambi | Fanapt | Humalog | Adderall |   80002 |
