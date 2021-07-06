@dce_redesign_home @dce
Feature: 1.10.1 DCE-REDISIGN AARP - To test Acq Home to NEW DCE Flows

  @dce_HomeIcon 
  Scenario Outline: To verify DCE REDESIGN flow from <site> home page
    #Given the user is on AARP medicare acquisition site landing page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
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

    @dce_HomeIcon_AEP_AARP @prodRegression_AARP @prodRegression @regressionAARP 
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode | planType | planName                                            | site |
      | Orkambi | Fanapt | Humalog | Adderall |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | AARP |

    @dce_HomeIcon_AEP_UHC @prodRegression_UHC @regressionUHC @sanity @vbfGate2
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode | planType | planName                                            | site |
      | Orkambi | Fanapt | Humalog | Adderall |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | UHC  |

  @dce_HomeSubNav @dce_HomeSubNav_AEP
  Scenario Outline: To verify DCE REDESIGN flow from Ulayer home page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
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

    @dce_HomeSubNav_AEP_AARP @regressionAARP @prodRegression
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode | site |
      | Orkambi | Fanapt | Humalog | Adderall |   80002 | AARP |

    @dce_HomeSubNav_AEP_UHC @regressionUHC
    Examples: 
      | drug1   | drug2  | drug3   | drug4    | zipCode | site |
      | Orkambi | Fanapt | Humalog | Adderall |   80002 | UHC  |

  @searchengine
  Scenario Outline: To verify DCE REDESIGN flow from <site> home page
    Given user is on Yahoo or google and search UHC drug cost estimator and navigate to dce page
      | searchParameter | <searchParameter> |
      | searchengine    | <searchengine>    |
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then user validates the return to home link is visible and clicked
      | homelink | true |

    @dce_HomeIcon_AEP_AARP
    Examples: 
      | drug1   | zipCode | planType | planName                                            | site | searchParameter                          | searchengine |
      | Orkambi |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | AARP | aarpmedicareplans drug cost estimator    | yahoo        |
      | Orkambi |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | uhc  | uhcmedicaresolutions drug cost estimator | yahoo        |
      | Orkambi |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | AARP | aarpmedicareplans drug cost estimator    | google       |
      | Orkambi |   80002 | MAPD     | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | uhc  | uhcmedicaresolutions drug cost estimator | google       |
