@dce_redesign_home
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Home to NEW DCE Flows

  @DCE_DirectLanding
  Scenario Outline:  To verify DCE REDESIGN flow from Ulayer home page
     Given the user is on AARP medicare acquisition site landing page
    Given the user navigates to following AARP medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Step 2

    Examples: 
      | path                     | pageName                   |
      | drug-cost-estimator.html | DCE Redesign - Get Started |
