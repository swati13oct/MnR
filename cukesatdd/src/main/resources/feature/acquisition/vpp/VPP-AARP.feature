@fixedTestCaseTest @vppUlayer
Feature: 1.02-Plan summary in vpp flow AARP

  @vppUlayerSmoke @vppUlayerNextYrSmoke #@vbfGate
  Scenario Outline: Verify plan summary in AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    #And the user views the plans of the below plan type in AARP site
    Then the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user validates plan summary for the below plan in the AARP site
      | Plan Name | <planName> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    And the user validates the pdf section

    Examples: 
      | zipcode | isMultutiCounty | county       | plantype | planName                                            |
      |   80002 | YES             | Adams County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

  @vppUlayerCurrentYrSmoke
  Scenario Outline: Verify plan summary in AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    #And the user views the plans of the below plan type in AARP site
    Then the user views the plans of the below plan type in AARP site and select Current year
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user validates plan summary for the below plan in the AARP site
      | Plan Name | <planName> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    And the user validates the pdf section

    Examples: 
      | zipcode | isMultutiCounty | county       | plantype | planName                                          |
      |   80002 | YES             | Adams County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @vppPlanDetailsAarp
  Scenario Outline: Verify plan details in AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |

    Examples: 
      | zipcode | isMultiCounty | county       | plantype | planName                                          |
      |   90002 | NO            | Adams County | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO) |

  @defect3281
  Scenario Outline: To check all 3 MA plans and go to estimate drug costs page and return to vpp to verify they're still selected
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code | <zipcode> |
    And I select all 3 plans to compare in MA and click on compare plan link
    Then I click back to all plans button and verify that all 3 plans are still selected

    Examples: 
      | zipcode |
      |   80007 |

  @theSpartans @aprilRelease2018 @vppbacktoallplans @US987466 @US987470
  Scenario Outline: To click Back to all plans from Top and bottom of the page and verify redirection back to the VPP-Summary page AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    #Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    #And the user validates the available plans for selected plan types in the AARP site
    Then the user view plan details of the above selected plan in AARP site vpp
      | Plan Name | <planName> |
      | Plan Type | <plantype> |
    Then the user clicks on both top and bottom back to plans link and validates its redirection AARP

    Examples: 
      | zipcode | isMultiCounty | county             | plantype | planName                                          |
      |   90210 | NO            | Los Angeles County | MA       | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @snpplansulayer @september_release_2018 @predators
  Scenario Outline: Verify plan summary in AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      #| County Name | <county>  |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user validates plan summary for the below plan in the AARP site
      | Plan Name | <planName> |

    Examples: 
      | zipcode | isMultiCounty | county             | plantype | planName                                     |
      |   80001 | NO            | Los Angeles County | SNP      | UnitedHealthcare Nursing Home Plan (PPO SNP) |

  @F229349 @validateEyeWearCredit @fastandfurious @Mar_release_2019
  Scenario Outline: UserStory: <UID> -plan type: <plantype> - Verify Eyewear Credit Benefits in Plan Details for provided plan
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user validates the following Additional Benefits Plan details for the plan
      | Benefit Type  | <benefitType>  |
      | Expected Text | <expectedText> |

    Examples: 
      | UID                                        | zipcode | isMultutiCounty | county              | plantype | planName                                                 | benefitType | expectedText                                                       |
      | US1580456 - AARP - Single Eyewear Credit   |   53503 | No              | Iowa County         | MAPD     | UnitedHealthcare MedicareComplete Open (PPO)             | Eyewear     | limit up to $100 per year                                          |
      | US1580456 - AARP - Single Eyewear Credit   |   96701 | No              | Honolulu County     | MAPD     | AARP MedicareComplete Choice Plan 1 (PPO)                | Eyewear     | limit up to $70 per every 2 years                                  |
      | US1580456 - AARP - Single Eyewear Credit   |   53533 | No              | Iowa County         | MA       | UnitedHealthcare MedicareComplete Open Essential (PPO)   | Eyewear     | limit up to $100 per year                                          |
      | US1580456 - AARP - Single Eyewear Credit   |   96701 | No              | Honolulu County     | MA       | AARP MedicareComplete Choice Essential (PPO)             | Eyewear     | limit up to $70 per every 2 years                                  |
      | US1580456 - AARP - Single Eyewear Credit   |   33880 | No              | Polk County         | SNP      | UnitedHealthcare Assisted Living Plan (PPO SNP)          | Eyewear     | limit up to $150 per year                                          |
      | US1580456 - AARP - Single Eyewear Credit   |   12202 | No              | Albany County       | SNP      | UnitedHealthcare Nursing Home Plan 1 (PPO SNP)           | Eyewear     | limit up to $150 per every 2 years                                 |
      | US1580458 - AARP - Multiple Eyewear Credit |   80210 | No              | Denver County       | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)        | Eyewear     | limit up to $70 for frames or $105 for contacts per every 2 years  |
      | US1580458 - AARP - Multiple Eyewear Credit |   92660 | No              | Orange County       | MA       | AARP MedicareComplete SecureHorizons Essential (HMO)     | Eyewear     | limit up to $130 for frames or $125 for contacts per year          |
      | US1580458 - AARP - Multiple Eyewear Credit |   80920 | No              | El Paso County      | MA       | AARP MedicareComplete SecureHorizons Essential (HMO)     | Eyewear     | limit up to $70 for frames or $105 for contacts per every 2 years  |
      | US1580458 - AARP - Multiple Eyewear Credit |   33880 | No              | Polk County         | SNP      | UnitedHealthcare Dual Complete RP (Regional PPO SNP)     | Eyewear     | limit up to $70 for frames or $105 for contacts per year           |
      | US1580458 - AARP - Multiple Eyewear Credit |   80210 | No              | Denver County       | SNP      | UnitedHealthcare Dual Complete (HMO SNP)                 | Eyewear     | limit up to $200 for frames or $200 for contacts per every 2 years |
      | US1580458 - AARP - No Eyewear Credit       |   78006 | Yes             | Kendall County      | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO SNP) | Eyewear     | No Coverage                                                        |
      | US1580458 - AARP - No Eyewear Credit       |   03033 | No              | Hillsborough County | MAPD     | UnitedHealthcare MedicareComplete Assure (PPO)           | Eyewear     | No Coverage                                                        |

  @F250062 @HomeMultiCOunty @fastandfurious @Feb_release_2019 @F250062
  Scenario Outline: Validate Cancel button for Multi Cunty Pop-up on Home Page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following MultiCounty Zip information in the AARP site
      | Zip Code | <MultiCOuntyzipcode> |
    Then the user validates the Cancel button for Multi COunty Pop-up lands on enter Zip code Page

    Examples: 
      | MultiCOuntyzipcode |
      |              78006 |

  @F250062 @SubNavMultiCOunty @fastandfurious @Feb_release_2019 @F250062
  Scenario Outline: Validate Cancel button for Multi Cunty Pop-up on Sub-nav Plan Search
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following MultiCounty Zip in Header Sun Nav in the AARP site
      | Zip Code | <MultiCOuntyzipcode> |
    Then the user validates the Cancel button for Multi COunty Pop-up lands on enter Zip code Page

    Examples: 
      | MultiCOuntyzipcode |
      |              78006 |

  @F250062 @VPPChangeLocationMultiCOunty @fastandfurious @Feb_release_2019 @F250062
  Scenario Outline: Validate Cancel button for Multi Cunty Pop-up on VPP for Change Location
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user performs Change Location on Plan Summary Page using following MultiCounty Zip information in the AARP site
      | Zip Code | <MultiCOuntyzipcode> |
    Then the user validates the Cancel button for Multi COunty Pop-up lands on enter Zip code Page

    Examples: 
      | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode |
      |   90210 | No              | Los Angeles County |              80002 |

  @VppPromoWidjetaarp
  Scenario Outline: To check VPP for specific plans
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    Then User validates the VPP promowidjet for specifc plans
      | Plan Name | <planName> |

    Examples: 
      | zipcode | isMultutiCounty | plantype | planName                    |
      |   55344 | NO              | MA       | UnitedHealthcare Sync (PPO) |

  @F251983 @validatePCPandSpecialistTiering @fastandfurious @Apr_release_2019
  Scenario Outline: UserStory: <UID> -plan type: <plantype> - Verify PCP and Specialist Benefits Tiering in Plan Details for provided plan on AARP
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user validates the following Medical Benefits Plan details for the plan
      | Benefit Type  | <benefitType>  |
      | Expected Text | <expectedText> |

    Examples: 
      | UID                                      | zipcode | isMultutiCounty | county          | plantype | planName                                          | benefitType                 | expectedText                          |
      | US1497183 - AARP - Specialist Tiering    |   27021 | YES             | Stokes County   | MA       | AARP MedicareComplete Essential (HMO)             | Specialist Copay            | Tier 1: $30 copay / Tier 2: $50 copay |
      | US1497183 - AARP - Specialist Tiering    |   27021 | YES             | Stokes County   | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Specialist Copay            | Tier 1: $30 copay / Tier 2: $50 copay |
      | US1497183 - AARP - Specialist Tiering    |   28616 | NO              | Avery County    | MAPD     | AARP MedicareComplete Plan 2 (HMO)                | Specialist Copay            | Tier 1: $35 copay / Tier 2: $50 copay |
      | US1497183 - AARP - Specialist Tiering    |   28701 | NO              | Buncombe County | MAPD     | AARP MedicareComplete Plan 3 (HMO)                | Specialist Copay            | Tier 1: $40 copay / Tier 2: $50 copay |
      | US1497183 - AARP - No Specialist Tiering |   06280 | NO              | Windham County  | MA       | UnitedHealthcare MedicareComplete Essential (HMO) | Specialist Copay            | $35 copay                             |
      | US1497183 - AARP - No Specialist Tiering |   35618 | NO              | Lawrence County | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Specialist Copay            | $40 copay                             |
      | US1497179 - AARP - PCP Tiering           |   27021 | YES             | Stokes County   | MA       | AARP MedicareComplete Essential (HMO)             | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $10 copay  |
      | US1497179 - AARP - PCP Tiering           |   27021 | YES             | Stokes County   | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $10 copay  |
      | US1497179 - AARP - PCP Tiering           |   28616 | NO              | Avery County    | MAPD     | AARP MedicareComplete Plan 2 (HMO)                | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $20 copay  |
      | US1497179 - AARP - PCP Tiering           |   28701 | NO              | Buncombe County | MAPD     | AARP MedicareComplete Plan 3 (HMO)                | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $20 copay  |
      | US1497179 - AARP - No PCP Tiering        |   06280 | NO              | Windham County  | MA       | UnitedHealthcare MedicareComplete Essential (HMO) | Primary Care Provider Copay | $5 copay                              |
      | US1497179 - AARP - No PCP Tiering        |   35618 | NO              | Lawrence County | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Primary Care Provider Copay | $5 copay                              |

  @F251983 @validatePCPnSpecialistTieringPlanCompare @fastandfurious @Apr_release_2019
  Scenario Outline: UserStory: <UID> -plan type: <plantype> - Verify PCP and Specialist Benefits Tiering in Plan Compare Page for provided plan on AARP
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user selects plans to add to plan compare and navigates to Plan compare page
      | Plan Name | <planName> |
    Then the user validates the following Medical Benefits for the plan in Plan Compare Page
      | Benefit Type  | <benefitType>  |
      | Expected Text | <expectedText> |
      | Plan Name     | <planName>     |

    Examples: 
      | UID                                                   | zipcode | isMultutiCounty | county          | plantype | planName                                          | benefitType                 | expectedText                          |
      | US1625234 - AARP Plan Compare - PCP Tiering           |   27021 | YES             | Stokes County   | MA       | AARP MedicareComplete Essential (HMO)             | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $10 copay  |
      | US1625234 - AARP Plan Compare - PCP Tiering           |   27021 | YES             | Stokes County   | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $10 copay  |
      | US1625234 - AARP Plan Compare - PCP Tiering           |   28616 | NO              | Avery County    | MAPD     | AARP MedicareComplete Plan 2 (HMO)                | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $20 copay  |
      | US1625234 - AARP Plan Compare - PCP Tiering           |   28701 | NO              | Buncombe County | MAPD     | AARP MedicareComplete Plan 3 (HMO)                | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $20 copay  |
      | US1625234 - AARP Plan Compare - PCP No Tiering        |   06280 | NO              | Windham County  | MA       | UnitedHealthcare MedicareComplete Essential (HMO) | Primary Care Provider Copay | $5 copay                              |
      | US1625234 - AARP Plan Compare - PCP No Tiering        |   35618 | NO              | Lawrence County | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Primary Care Provider Copay | $5 copay                              |
      | US1653894 - AARP Plan Compare - Specialist Tiering    |   27021 | YES             | Stokes County   | MA       | AARP MedicareComplete Essential (HMO)             | Specialist Copay            | Tier 1: $30 copay / Tier 2: $50 copay |
      | US1653894 - AARP Plan Compare - Specialist Tiering    |   27021 | YES             | Stokes County   | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Specialist Copay            | Tier 1: $30 copay / Tier 2: $50 copay |
      | US1653894 - AARP Plan Compare - Specialist Tiering    |   28616 | NO              | Avery County    | MAPD     | AARP MedicareComplete Plan 2 (HMO)                | Specialist Copay            | Tier 1: $35 copay / Tier 2: $50 copay |
      | US1653894 - AARP Plan Compare - Specialist Tiering    |   28701 | NO              | Buncombe County | MAPD     | AARP MedicareComplete Plan 3 (HMO)                | Specialist Copay            | Tier 1: $40 copay / Tier 2: $50 copay |
      | US1653894 - AARP Plan Compare - No Specialist Tiering |   06280 | NO              | Windham County  | MA       | UnitedHealthcare MedicareComplete Essential (HMO) | Specialist Copay            | $35 copay                             |
      | US1653894 - AARP Plan Compare - No Specialist Tiering |   35618 | NO              | Lawrence County | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Specialist Copay            | $40 copay                             |

  @F251983 @validateOutPatientHospitalServices @fastandfurious @Apr_release_2019
  Scenario Outline: UserStory: <UID> -plan type: <plantype> - Verify Out Patient Hospital Visit Benefits vakues in Plan Details for provided plan on AARP
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user validates the following Medical Benefits Plan details for the plan
      | Benefit Type  | <benefitType>  |
      | Expected Text | <expectedText> |

    Examples: 
      | UID                                             | zipcode | isMultutiCounty | county             | plantype | planName                                          | benefitType                  | expectedText    |
      | US1533310 - AARP - OutPatient Hospital Services |   06280 | NO              | Windham County     | MA       | UnitedHealthcare MedicareComplete Essential (HMO) | Outpatient Hospital Services | $250 copay      |
      | US1533310 - AARP - OutPatient Hospital Services |   99210 | NO              | Spokane County     | MA       | AARP MedicareComplete Essential (HMO)             | Outpatient Hospital Services | 20% of the cost |
      | US1533310 - AARP - OutPatient Hospital Services |   35650 | NO              | Lawrence County    | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Outpatient Hospital Services | $295 copay      |
      | US1533310 - AARP - OutPatient Hospital Services |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | Outpatient Hospital Services | $0 copay        |
      | US1533310 - AARP - OutPatient Hospital Services |   33002 | NO              | Miami-Dade County  | SNP      | Preferred Special Care Miami-Dade (HMO SNP)       | Outpatient Hospital Services | $75 copay       |
      | US1533310 - AARP - OutPatient Hospital Services |   36688 | NO              | Mobile County      | SNP      | UnitedHealthcare Dual Complete (HMO SNP)          | Outpatient Hospital Services | $0 copay        |

  @F251983 @validateAmbulatorySurgicalCenterPackage @fastandfurious @Apr_release_2019
  Scenario Outline: UserStory: <UID> - plan type: <plantype> - Verify Ambulatory Surgical Centre Benefit on Plan Details Page for the provided plan on AARP
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type in AARP site
      | Plan Type | <plantype> |
    And the user validates the available plans for selected plan types in the AARP site
    Then the user view plan details of the above selected plan in AARP site and validates
      | Plan Name | <planName> |
    Then the user validates the following Medical Benefits Plan details for the plan
      | Benefit Type  | <benefitType>  |
      | Expected Text | <expectedText> |

    Examples: 
      | UID                                                   | zipcode | isMultutiCounty | county              | plantype | planName                                               | benefitType                | expectedText               |
      | US1641966 - AARP - Ambulatory Surgical Center Package |   35616 | NO              | Colbert County      | MAPD     | AARP MedicareComplete Plan 1 (HMO)                     | Ambulatory Surgical Center | $245 copay                 |
      | US1641966 - AARP - Ambulatory Surgical Center Package |   33413 | NO              | Palm Beach County   | MAPD     | UnitedHealthcare Sync (PPO)                            | Ambulatory Surgical Center | $150 copay                 |
      | US1641966 - AARP - Ambulatory Surgical Center Package |   84301 | NO              | Box Elder County    | MA       | AARP MedicareComplete Essential (HMO)                  | Ambulatory Surgical Center | $290 copay                 |
      | US1641966 - AARP - Ambulatory Surgical Center Package |   83616 | YES             | Ada County          | MAPD     | UnitedHealthcare MedicareComplete Assure (PPO)         | Ambulatory Surgical Center | $0 copay - 20% of the cost |
      | US1641966 - AARP - Ambulatory Surgical Center Package |   33002 | NO              | Miami-Dade County   | SNP      | Preferred Special Care Miami-Dade (HMO SNP)            | Ambulatory Surgical Center | $25 copay                  |
      | US1641966 - AARP - Ambulatory Surgical Center Package |   53920 | YES             | Adams County        | SNP      | UnitedHealthcare MedicareComplete Assist (PPO SNP)     | Ambulatory Surgical Center | $295 copay                 |
      | US1641966 - AARP - Ambulatory Surgical Center Package |   92220 | NO              | Riverside County    | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)      | Ambulatory Surgical Center | $0 copay                   |
      | US1641966 - AARP - Ambulatory Surgical Center Package |   98601 | YES             | Clark County        | SNP      | UnitedHealthcare Nursing Home Plan (PPO SNP)           | Ambulatory Surgical Center | 10% of the cost            |
      | US1641966 - AARP - Ambulatory Surgical Center Package |   53910 | NO              | Adams County        | MA       | UnitedHealthcare MedicareComplete Open Essential (PPO) | Ambulatory Surgical Center | $250 copay                 |
      | US1641966 - AARP - Ambulatory Surgical Center Package |   32960 | NO              | Indian River County | MAPD     | AARP MedicareComplete Focus (HMO)                      | Ambulatory Surgical Center | $150 copay                 |

  @feature-F265872 @us1598162 @vppFavoritePlanRegressionUlayer @vppFavoritePlanInSession @vppFavoritePlanInSessionAarp @thePredators @Apr_release_2019
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can save and unsave favorite plans on view plan preview page on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    Then user validates selected plans can be saved as favorite on AARP site
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |
    Then user validates saved favorite plans will be stored within same session after zipcode change from Home on AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates saved favorite plans will be stored within same session after zipcode change from Shop For a Plan on AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates saved favorite plans will be stored within same session after zipcode change within VPP page on AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates ability to unsave a saved plan on AARP site
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |
    Then user validates unsave favorite plans will be stored within same session after zipcode change from Home on AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates unsave favorite plans will be stored within same session after zipcode change from Shop For a Plan on AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates unsave favorite plans will be stored within same session after zipcode change within VPP page on AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |

    Examples: 
      | UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                               | PDP_testPlans                                                    | SNP_testPlans                              |
      | 1598162 |   80001 | NO            | Jefferson County | AARP Medicare Advantage SecureHorizons Essential (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) |

  @feature-F265872 @us1598162 @vppFavoritePlanRegressionUlayer @vppFavoritePlanInSessionCloseTab @vppFavoritePlanInSessionCloseTabAarp @thePredators @Apr_release_2019
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can favorite plans will be saved within session on view plan preview page on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the AARP site
    Then user validates selected plans can be saved as favorite on AARP site
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |
    Then user closes the original tab and open new tab for AARP site
    Then the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plans remain saved within same session for AARP site
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |

    Examples: 
      | UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                               | PDP_testPlans                                                    | SNP_testPlans                              |
      | 1598162 |   80001 | NO            | Jefferson County | AARP Medicare Advantage SecureHorizons Essential (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) |

  @F322478 @us1603378 @UlayerSAMCall
  Scenario Outline: UID: <UID>  - Verify Call sticky action menu on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When verify Call SAM icon is visible or not
    And verify Call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then user verify the popup and content

    Examples: 
      | UID     |
      | F322478 |

  @F322478 @us1603378 @UlayerSAMChat
  Scenario Outline: UID: <UID>  - Verify Chat sticky action menu on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When verify Chat SAM icon is visible or not
    And verify Chat SAM roll out and contain the text Call a Licensed Insurance Agent
    Then user verify the Chat original state

    Examples: 
      | UID     |
      | F322478 |
