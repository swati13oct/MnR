@dce_redesign_home_mobile
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Home to NEW DCE Flows on Mobile

  @DCE_DirectLanding_Mobile
  Scenario Outline: To verify DCE REDESIGN flow from Ulayer home page
    Given the user is on AARP medicare acquisition site landing page Mobile
    Given the user navigates to following AARP medicare acquisition site page Mobile
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page Mobile
    Then the user clicks on Build Drug List to navigate to Step 2
    Then the user validates error message for blank search
    Then the user validates No Drug found error message for search
    Then user enter the following drug info and validates drug autocomplete
      | DrugNameAutoComplete | <drugnameAutocomplete> |
    Then the user selects the following drug from the dropdown
    | DrugName | <drugName> | 

    Examples: 
      | path                                  | pageName                   | drugnameAutocomplete | drugName |
      | health-plans/estimate-drug-costs.html | DCE Redesign - Get Started | lipi                 | Lipitor  |
