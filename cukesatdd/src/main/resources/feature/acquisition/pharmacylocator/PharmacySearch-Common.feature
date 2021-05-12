@pharmacylocator
Feature: 1.11.a ACQ-Pharmacy Locator Test Scripts

  # @pharmacylocatorAARP01 @shopPlan @English @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 1 of 2 - To verify end-to-end behavior for pharmacy locator page in English on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigate to pharmacy search page from the navigation bar
    #------ English -----------------------------------
    And the user validates header section content on site
    When the user enters following details for the pharmacy search
      | Zip Code | [blank]    |
      | Distance | <distance> |
    Then the user verify error messages in Pharmacy locator page
      | Language | English |
    When the user enters following details for the pharmacy search
      | Zip Code |       9999 |
      | Distance | <distance> |
    Then the user verify error messages in Pharmacy locator page
      | Language | English |
    And the user enters following details for the pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown list
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    #Then the user validates the Pharmacies available
    #  | Language | English |
    And the user validate tooltips on filters
      | Language                                   | English                 |
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
    And the user validates map section contents
    Then the user validates Selected Plan Name in Results Section on Pharmacy page
    And the user validate show on map link
    And the user validate get direction link
    And the user validate more information content based on plan type
    And the user validate view search PDF link

    #  @pharmacylocatorAARP01a
    @PharmacyLocatorCommonAARP01a @regressionAARP @sanity
    Examples: 
      | TID   | site | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | AARP |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |

    #     | 15582 | AARP |   85215 |       15 | None           |        2021 | AARP MedicareRx Walgreens (PDP) |        2021 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
    #     | 15582 | AARP |   78006 |       15 | Kendall County |        2021 | AARP MedicareRx Walgreens (PDP) |        2021 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
    #     | 15582 | AARP |   00602 |       15 | None           |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | Open 24 hours | True                  | True             | True                 |
    #     | 15582 | AARP |   96950 |       15 | None           |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | Open 24 hours | False                 | True             | True                 |
    @prodRegression @regressionAARP @vbfGate
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | AARP |   78006 |       15 | Kendall County |        2021 | AARP MedicareRx Walgreens (PDP) |        2021 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |

    @PharmacyLocatorCommonAARP01b @regressionAARP
    Examples: 
      | TID   | site | zipcode | distance | countyName      | cy_planYear | cy_planName                                                      | ny_planYear | ny_planName                                                      | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15583 | AARP |   78006 |       10 | Comal County    |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        | Retail Pharmacy             | False                 | False            | True                 |
      | 15583 | AARP |   80002 |       10 | Adams County    |        2021 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              |        2021 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              | Long-term care              | False                 | False            | True                 |
      | 15583 | AARP |   14867 |       25 | Tompkins County |        2021 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) |        2021 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) | Long-term care              | False                 | False            | True                 |
      | 15583 | AARP |   33321 |       10 | None            |        2021 | Medica HealthCare Plans MedicareMax (HMO)                        |        2021 | Medica HealthCare Plans MedicareMax (HMO)                        | Home Infusion and Specialty | False                 | False            | True                 |

    @PharmacyLocatorCommonUHC01a @regressionUHC
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | UHC  |   10980 |       15 | None           |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |
      | 15582 | UHC  |   85215 |       15 | None           |        2021 | AARP MedicareRx Walgreens (PDP) |        2021 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | UHC  |   78006 |       15 | Kendall County |        2021 | AARP MedicareRx Walgreens (PDP) |        2021 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | UHC  |   00602 |       15 | None           |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | UHC  |   96950 |       15 | None           |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | Open 24 hours | False                 | True             | True                 |

    @PharmacyLocatorCommonUHC01b @regressionUHC
    Examples: 
      | TID   | site | zipcode | distance | countyName      | cy_planYear | cy_planName                                                      | ny_planYear | ny_planName                                                      | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15583 | UHC  |   78006 |       10 | Comal County    |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        | Retail Pharmacy             | False                 | False            | True                 |
      | 15583 | UHC  |   80002 |       10 | Adams County    |        2021 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              |        2021 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              | Long-term care              | False                 | False            | True                 |
      | 15583 | UHC  |   14867 |       25 | Tompkins County |        2021 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) |        2021 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) | Long-term care              | False                 | False            | True                 |
      | 15583 | UHC  |   33321 |       10 | None            |        2021 | Medica HealthCare Plans MedicareMax (HMO)                        |        2021 | Medica HealthCare Plans MedicareMax (HMO)                        | Home Infusion and Specialty | False                 | False            | True                 |

  # @pharmacylocatorAARP02 @shopPlan @English @pharmacylocatorAcquisitionE2E @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -zipcode: <zipcode> - Part 2 of 2 - To verify end-to-end behavior for pharmacy locator page in English on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigate to pharmacy search page from the navigation bar
    #------ English -----------------------------------
    And the user validates header section content
    And the user enters following details for the pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown list
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    And the user validates pharmacy widgets on page
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
      | Has Walgreens plan                         | <hasWalgreensPlan>      |
      | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
    And the user selects Pharmacy Types to Filter pharmacies
      | Pharmacy Type | <pharmacyType> |
      | Language      | English        |
    #Then the user validates the Pharmacies available
    #  | Language | English |
    Then the user validate error message displayed when filter results in no match
    Then the user validate the question widget

    #@pharmacylocatorAARP02a\
    @PharmacyLocatorCommonAARP02a @regressionAARP
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | AARP |   10980 |       15 | None           |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |
      | 15582 | AARP |   85215 |       15 | None           |        2021 | AARP MedicareRx Walgreens (PDP) |        2021 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | AARP |   78006 |       15 | Kendall County |        2021 | AARP MedicareRx Walgreens (PDP) |        2021 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |

    #@pharmacylocatorAARP02b
    @PharmacyLocatorCommonAARP02b @regressionAARP
    Examples: 
      | TID   | site | zipcode | distance | countyName      | cy_planYear | cy_planName                                                      | ny_planYear | ny_planName                                                      | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15583 | AARP |   78006 |       10 | Comal County    |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        | Retail Pharmacy             | False                 | False            | True                 |
      | 15583 | AARP |   80002 |       10 | Adams County    |        2021 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              |        2021 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              | Long-term care              | False                 | False            | True                 |
      | 15583 | AARP |   14867 |       25 | Tompkins County |        2021 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) |        2021 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) | Long-term care              | False                 | False            | True                 |
      | 15583 | AARP |   33321 |       10 | None            |        2021 | Medica HealthCare Plans MedicareMax (HMO)                        |        2021 | Medica HealthCare Plans MedicareMax (HMO)                        | Home Infusion and Specialty | False                 | False            | True                 |

    #@pharmacylocatorAARP02a\
    @PharmacyLocatorCommonUHC02a @regressionUHC 
    Examples: 
      | TID   | site | zipcode | distance | countyName     | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | UHC  |   10980 |       15 | None           |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |
      | 15582 | UHC  |   85215 |       15 | None           |        2021 | AARP MedicareRx Walgreens (PDP) |        2021 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |
      | 15582 | UHC  |   78006 |       15 | Kendall County |        2021 | AARP MedicareRx Walgreens (PDP) |        2021 | AARP MedicareRx Walgreens (PDP) | Open 24 hours | True                  | True             | True                 |

    @PharmacyLocatorCommonProd_UHC @prodRegression @sanity @vbfGate
    Examples: 
      | TID   | site | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15582 | UHC  |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |

    #@pharmacylocatorAARP02b
    @PharmacyLocatorCommonUHC02b @regressionUHC
    Examples: 
      | TID   | site | zipcode | distance | countyName      | cy_planYear | cy_planName                                                      | ny_planYear | ny_planName                                                      | pharmacyType                | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | 15583 | UHC  |   78006 |       10 | Comal County    |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        |        2021 | UnitedHealthcare Medicare Advantage Choice (Regional PPO)        | Retail Pharmacy             | False                 | False            | True                 |
      | 15583 | UHC  |   80002 |       10 | Adams County    |        2021 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              |        2021 | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)              | Long-term care              | False                 | False            | True                 |
      | 15583 | UHC  |   14867 |       25 | Tompkins County |        2021 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) |        2021 | UnitedHealthcare Medicare Advantage Choice Plan 3 (Regional PPO) | Long-term care              | False                 | False            | True                 |
      | 15583 | UHC  |   33321 |       10 | None            |        2021 | Medica HealthCare Plans MedicareMax (HMO)                        |        2021 | Medica HealthCare Plans MedicareMax (HMO)                        | Home Infusion and Specialty | False                 | False            | True                 |

  # @pharmacylocatorulayer08 @geoTargeting @pharmacyLocatorRegression
  Scenario Outline: TID: <TID> -state: <state> - To verify pharmacy locator page display for different state
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigate to pharmacy search page with selected state
      | State | <state> |
    #------ English -----------------------------------
    And the user validates header section content on site

    @PharmacyLocatorCommonAARP07 @regressionAARP @vbfGate
    Examples: 
      | TID   | site | state     |
      | xxxxx | AARP | Ohio      |
      | xxxxx | AARP | Minnesota |

    @PharmacyLocatorCommonUHC07 @regressionUHC
    Examples: 
      | TID   | site | state     |
      | xxxxx | UHC  | Ohio      |
      | xxxxx | UHC  | Minnesota |

  ############## Pharmacy search- Breadcrumb validations ##########################
  Scenario Outline: To verify breadcrumbs on pharmacy search page through home page on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigate to pharmacy search page from the navigation bar
    Then user verify breadcrumb "Return to Home Page" displayed on pharmacy search page
    When user clicks on breadcrumb on pharmacy search page
    Then user should be navigated to home page

    @breadcrumbPharmacySearch_AARP_Part1 @regressionAARP
    Examples: 
      | site |
      | AARP |

    @breadcrumbPharmacySearch_UHC_Part1 @regressionUHC @vbfGate
    Examples: 
      | site |
      | UHC  |

  Scenario Outline: To verify breadcrumbs on pharmacy search page through guest profile on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigate to pharmacy search page from the navigation bar
    And the user clicks on the shopping cart icon
    Then user should be navigated to visitor profile page
    Then user verify breadcrumb "Return to Pharmacy Search" on the visitor profile page
    When the user navigate to pharmacy search page from the navigation bar
    Then user verify breadcrumb "Return to Profile" displayed on pharmacy search page
    When user clicks on breadcrumb on pharmacy search page
    Then user should be navigated to visitor profile page

    @breadcrumbPharmacySearch_AARP_Part1 @regressionAARP @sanity
    Examples: 
      | site |
      | AARP |

    @breadcrumbPharmacySearch_UHC_Part1 @regressionUHC @vbfGate
    Examples: 
      | site |
      | UHC  |

  Scenario Outline: To verify breadcrumbs on pharmacy search page through plan compare page on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And I select "<plantype>" plans to compare and click on compare plan link
    Then verify plan compare page is loaded
    When the user navigate to pharmacy search page from the navigation bar
    Then user verify breadcrumb "Return to compare" displayed on pharmacy search page
    When user clicks on breadcrumb on pharmacy search page
    Then verify plan compare page is loaded

    @breadcrumbPharmacySearch_AARP_Part1 @regressionAARP
    Examples: 
      | site | zipcode | county      | isMultutiCounty | plantype |
      | AARP |   19019 | Iowa County | No              | MAPD     |

    @breadcrumbPharmacySearch_UHC_Part1 @regressionUHC
    Examples: 
      | site | zipcode | county      | isMultutiCounty | plantype |
      | UHC  |   19019 | Iowa County | No              | MAPD     |

  Scenario Outline: To verify breadcrumbs on pharmacy search page through VPP page on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    When the user navigate to pharmacy search page from the navigation bar
    Then user verify breadcrumb "Return to plan summary" displayed on pharmacy search page
    When user clicks on breadcrumb on pharmacy search page
    Then user should be navigated to VPP summary page

    @breadcrumbPharmacySearch_AARP_Part1 @regressionAARP
    Examples: 
      | site | zipcode | county      | isMultutiCounty | plantype |
      | AARP |   19019 | Iowa County | No              | MAPD     |

    @breadcrumbPharmacySearch_UHC_Part1 @regressionUHC
    Examples: 
      | site | zipcode | county      | isMultutiCounty | plantype |
      | UHC  |   19019 | Iowa County | No              | MAPD     |

  Scenario Outline: To verify breadcrumbs on pharmacy search page through DCE page on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user navigate to pharmacy search page from the navigation bar
    Then user verify breadcrumb "Return to Drug Cost Estimator" displayed on pharmacy search page
    When user clicks on breadcrumb on pharmacy search page
    Then the user validates Get Started Page
    Then user verify breadcrumb "Return to Pharmacy Search" on get started page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipcode> |
    And user clicks on continue button in Zip Entry Page
    And user verify the drug summary page
    Then user verify breadcrumb "Return to Pharmacy Search" on drug summary page
    When user clicks view drug cost button
    Then user verify breadcrumb "Return to Pharmacy Search" on drug details page

    @breadcrumbPharmacySearch_AARP_Part1 @regressionAARP
    Examples: 
      | site | zipcode | county      | isMultutiCounty | plantype | drug1   |
      | AARP |   19019 | Iowa County | No              | MAPD     | Lipitor |

    @breadcrumbPharmacySearch_UHC_Part1 @regressionUHC
    Examples: 
      | site | zipcode | county      | isMultutiCounty | plantype | drug1   |
      | UHC  |   19019 | Iowa County | No              | MAPD     | Lipitor |

  Scenario Outline: To verify breadcrumbs on pharmacy search page through VPP details page on acquisition <site> site for plan type -<plantype>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    Then the user navigates to the plan details for the given plan type
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
    When the user navigate to pharmacy search page from the navigation bar
    Then user verify breadcrumb "Return to plan details" displayed on pharmacy search page
    When user clicks on breadcrumb on pharmacy search page
    Then user should be navigated to VPP detail page

    @breadcrumbPharmacySearch_AARP_Part2 @regressionAARP
    Examples: 
      | site | zipcode | county          | isMultutiCounty | plantype | planyear | planname                                           |
      | AARP |   90210 | Iowa County     | No              | MAPD     | future   | AARP Medicare Advantage SecureHorizons Focus (HMO) |
      | AARP |   90210 | Iowa County     | No              | PDP      | future   | AARP MedicareRx Walgreens (PDP)                    |
      | AARP |   10001 | New York County | No              | SNP      | future   | UnitedHealthcare Dual Complete (HMO D-SNP)         |

    @breadcrumbPharmacySearch_UHC_Part2 @regressionUHC
    Examples: 
      | site | zipcode | county          | isMultutiCounty | plantype | planyear | planname                                           |
      | UHC  |   90210 | Iowa County     | No              | MAPD     | future   | AARP Medicare Advantage SecureHorizons Focus (HMO) |
      | UHC  |   90210 | Iowa County     | No              | PDP      | future   | AARP MedicareRx Walgreens (PDP)                    |
      | UHC  |   10001 | New York County | No              | SNP      | future   | UnitedHealthcare Dual Complete (HMO D-SNP)         |

  Scenario Outline: To verify breadcrumbs on pharmacy search page through Shop page page on acquisition <site> site for page - <pageName>
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    When the user navigate to pharmacy search page from the navigation bar
    Then user verify breadcrumb "Return to previous page" displayed on pharmacy search page
    When user clicks on breadcrumb on pharmacy search page
    Then user should be navigated to the previous page
      | PagePath | <path> |

    @breadcrumbPharmacySearch_AARP_Part2 @regressionAARP
    Examples: 
      | site | path                              | pageName                                                         |
      | AARP | shop.html                         | ShopPlan: Shop                                                   |
      | AARP | shop/compare/compare-pdp.html     | Compare Medicare Part D Plans                                    |
      | AARP | shop/estimate/pdp-costs.html      | Medicare Prescription Drug (Part D) Plan Costs                   |
      | AARP | shop/prescription-drug-plans.html | Shop AARP Medicare Prescription Drug Plans from UnitedHealthcare |
      | AARP | plan-documents.html               | Plan Documents Search Tool                                       |

    @breadcrumbPharmacySearch_UHC_Part2 @regressionUHC
    Examples: 
      | site | path                              | pageName                                                         |
      | UHC  | shop.html                         | ShopPlan: Shop                                                   |
      | UHC  | shop/compare/compare-pdp.html     | Compare Medicare Part D Plans                                    |
      | UHC  | shop/estimate/pdp-costs.html      | Medicare Prescription Drug (Part D) Plan Costs                   |
      | UHC  | shop/prescription-drug-plans.html | Shop AARP Medicare Prescription Drug Plans from UnitedHealthcare |
      | UHC  | plan-documents.html               | Plan Documents Search Tool                                       |

  Scenario Outline: To verify breadcrumbs on pharmacy search page through OLE page on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And the user validates the available plans for selected plan types
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planName> |
    Then the user validates the Plan details on OLE
    When user clicks on pharmacy link on OLE page
    Then user verify breadcrumb "Return to enroll" displayed on pharmacy search page
    When user clicks on breadcrumb on pharmacy search page
    Then user should be navigated to the previous page
      | PagePath | <path> |

    @breadcrumbPharmacySearch_AARP_Part2 @regressionAARP
    Examples: 
      | site | planyear | zipcode | isMultutiCounty | county             | plantype | planName                        | path                                                                                                      |
      | AARP | future   |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP) | health-plans/prescription-drug-plans/medicare-application/aarp-medicarerx-online-application.html/welcome |

    @breadcrumbPharmacySearch_UHC_Part2 @regressionUHC
    Examples: 
      | site | planyear | zipcode | isMultutiCounty | county             | plantype | planName                        | path                                                                                                                      |
      | UHC  | future   |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP) | health-plans/prescription-drug-plans/medicare-enrollment/medicare-prescription-drug-plans-online-application.html/welcome |

  Scenario Outline: To verify breadcrumbs on pharmacy search page through Preferred Retail Pharmacy on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user navigate to pharmacy search page from the navigation bar
    Then user verify breadcrumb "Return to Home Page" displayed on pharmacy search page
    And the user enters following details for the pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    And click on DCE Link on Pharmacy Page
    Then the user validates Get Started Page
    Then user click on breadcrumb "Return to Pharmacy Search" on get started page
    Then user verify breadcrumb "Return to Drug Cost Estimator" displayed on pharmacy search page

    @breadcrumbPharmacySearch_AARP_Part2 @regressionAARP
    Examples: 
      | site | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     |
      | AARP |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) |

    @breadcrumbPharmacySearch_UHC_Part2 @regressionUHC
    Examples: 
      | site | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     |
      | AARP |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) |
