@dce_redesign_home_Mobile
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Home to NEW DCE Flows Mobile

  @DCE_DirectLanding_Mobile
  Scenario Outline:  To verify DCE REDESIGN flow from Ulayer home page Mobile
     Given the user is on AARP medicare acquisition site landing page Mobile
    Given the user navigates to following AARP medicare acquisition site page Mobile
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user validates Get Started Page Mobile
    Then the user clicks on Build Drug List to navigate to Step 2 Mobile

    Examples: 
      | path                     | pageName                   |
      | drug-cost-estimator.html | DCE Redesign - Get Started |
