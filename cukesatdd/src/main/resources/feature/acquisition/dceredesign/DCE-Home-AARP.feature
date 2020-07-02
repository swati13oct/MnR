@dce_redesign_home_mobile
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Home to NEW DCE Flows

  @DCE_DirectLanding
  Scenario Outline: To verify DCE REDESIGN flow from Ulayer home page
    Given the user is on AARP medicare acquisition site landing page
    Given the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Step 2
    Then the user validates error message for blank search
    Then the user validates No Drug found error message for search
    Then user enter the following drug info and validates drug autocomplete
      | DrugNameAutoComplete | <drugnameAutocomplete> |
    Then the user selects the following Brand Name drug from the dropdown
      | DrugName | <drugName> |
    Then the user validates Tell Us About Drug - Brand page for the Drug
      | GenericName | <CheckGeneric> |
      | DrugName    | <drugName>     |
    Then the user selects following Drug Details

    Examples: 
      | path                                  | pageName                   | drugnameAutocomplete | drugName | CheckGeneric         |
      | health-plans/estimate-drug-costs.html | DCE Redesign - Get Started | lipi                 | Lipitor  | Atorvastatin Calcium |
