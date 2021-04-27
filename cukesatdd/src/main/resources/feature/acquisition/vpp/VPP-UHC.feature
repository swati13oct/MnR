@fixedTestCaseTest @vppBlayer
Feature: 2.02-Plan summary in vpp flow UMS

  @planDetailsUMS @vppBlayerSmoke @vppBlayerNextYrSmoke #@vbfGate
  Scenario Outline: Verify plan details in UMS site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    # When user views plans of the below plan type in UMS site
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    And the user validates the pdf section for uhc
    Then User clicks on Back to Plans link and navigate back to plan summary in UMS site
    Then User click on add to compare checkbox and click on view details link on UMS
    Then I uncheck and go back to the vpp page to validate

    Examples: 
      | zipcode | isMultutiCounty | county       | plantype | planName                                            |
      |   80002 | YES             | Adams County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) |

  @vppBlayerCurrentYrSmoke
  Scenario Outline: Verify plan details in UMS site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    # When user views plans of the below plan type in UMS site
    When user views plans of the below plan type in UMS site for current year
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    And the user validates the pdf section for uhc
    Then User clicks on Back to Plans link and navigate back to plan summary in UMS site
    Then User click on add to compare checkbox and click on view details link on UMS
    Then I uncheck and go back to the vpp page to validate

    Examples: 
      | zipcode | isMultutiCounty | county       | plantype | planName                                          |
      |   80002 | YES             | Adams County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |

  @defect1964
  Scenario Outline: To verify correct message shows on view details page after checking compare plans box
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    And I click on add to compare checkbox and click on view details link
    Then I uncheck and recheck the compare box and verify the message and link exists
    Then I uncheck and go back to the vpp page to validate

    Examples: 
      | zipcode |
      |   33012 |

  @defect1803
  Scenario Outline: To test checkbox is unchecked on vpp after unchecking it on view details page
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    And I click on add to compare checkbox and click on view details link
    Then I uncheck and go back to the vpp page to validate

    Examples: 
      | zipcode |
      |   33012 |

  @defect1970
  Scenario Outline: To test correct message is displayed for PDP plans after checking compare plans box
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    And I select pdp plans and go to view details page
    Then I check compare box and verify right info is shown

    Examples: 
      | zipcode |
      |   33012 |

  @defect1363
  Scenario Outline: To test two plans are added when clicked on compare plans on Plan details page
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    And the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    Then the user clicks on add to compare box and validates that info shows 2 plans added

    Examples: 
      | zipcode | planName                                           | plantype |
      |   33012 | AARP MedicareComplete Choice Plan 2 (Regional PPO) | MAPD     |

  @theSpartans @aprilRelease2018 @vppbacktoallplans @US987469 @US987465
  Scenario Outline: TO click Back to all plans from Top and bottom of the page and verify redirection back to the VPP-Summary page UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    And the user view plan details of the above selected plan in UMS site vpp
      | Plan Name | <planName> |
    Then the user clicks on both top and bottom back to plans link and validates its redirection

    Examples: 
      | zipcode | planName                                           | plantype |
      |   33012 | AARP MedicareComplete Choice Plan 2 (Regional PPO) | MAPD     |

  @F229349 @validateEyeWearCredit @fastandfurious @Mar_release_2019
  Scenario Outline: UserStory: <UID> -plan type: <plantype> - Verify specific Additional Benefits in Plan Details for provided plan
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    Then the user validates the following Additional Benefits Plan details for the plan in UMS
      | Benefit Type  | <benefitType>  |
      | Expected Text | <expectedText> |

    Examples: 
      | UID                                       | zipcode | isMultutiCounty | county              | plantype | planName                                                 | benefitType | expectedText                                                       |
      | US1580455 - UHC - Single Eyewear Credit   |   53503 | No              | Iowa County         | MAPD     | UnitedHealthcare MedicareComplete Open (PPO)             | Eyewear     | limit up to $100 per year                                          |
      | US1580455 - UHC - Single Eyewear Credit   |   96701 | No              | Honolulu County     | MAPD     | AARP MedicareComplete Choice Plan 1 (PPO)                | Eyewear     | limit up to $70 per every 2 years                                  |
      | US1580455 - UHC - Single Eyewear Credit   |   53533 | No              | Iowa County         | MA       | UnitedHealthcare MedicareComplete Open Essential (PPO)   | Eyewear     | limit up to $100 per year                                          |
      | US1580455 - UHC - Single Eyewear Credit   |   96701 | No              | Honolulu County     | MA       | AARP MedicareComplete Choice Essential (PPO)             | Eyewear     | limit up to $70 per every 2 years                                  |
      | US1580455 - UHC - Single Eyewear Credit   |   33880 | No              | Polk County         | SNP      | UnitedHealthcare Assisted Living Plan (PPO SNP)          | Eyewear     | limit up to $150 per year                                          |
      | US1580455 - UHC - Single Eyewear Credit   |   12202 | No              | Albany County       | SNP      | UnitedHealthcare Nursing Home Plan 1 (PPO SNP)           | Eyewear     | limit up to $150 per every 2 years                                 |
      | US1580459 - UHC - Multiple Eyewear Credit |   80210 | No              | Denver County       | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)        | Eyewear     | limit up to $70 for frames or $105 for contacts per every 2 years  |
      | US1580459 - UHC - Multiple Eyewear Credit |   92660 | No              | Orange County       | MA       | AARP MedicareComplete SecureHorizons Essential (HMO)     | Eyewear     | limit up to $130 for frames or $125 for contacts per year          |
      | US1580459 - UHC - Multiple Eyewear Credit |   80920 | No              | El Paso County      | MA       | AARP MedicareComplete SecureHorizons Essential (HMO)     | Eyewear     | limit up to $70 for frames or $105 for contacts per every 2 years  |
      | US1580459 - UHC - Multiple Eyewear Credit |   33880 | No              | Polk County         | SNP      | UnitedHealthcare Dual Complete RP (Regional PPO SNP)     | Eyewear     | limit up to $70 for frames or $105 for contacts per year           |
      | US1580459 - UHC - Multiple Eyewear Credit |   80210 | No              | Denver County       | SNP      | UnitedHealthcare Dual Complete (HMO SNP)                 | Eyewear     | limit up to $200 for frames or $200 for contacts per every 2 years |
      | US1580459 - UHC - No Eyewear Credit       |   78006 | Yes             | Kendall County      | SNP      | UnitedHealthcare Dual Complete Choice (Regional PPO SNP) | Eyewear     | No Coverage                                                        |
      | US1580459 - UHC - No Eyewear Credit       |   03033 | No              | Hillsborough County | MAPD     | UnitedHealthcare MedicareComplete Assure (PPO)           | Eyewear     | No Coverage                                                        |

  @F250062 @HomeMultiCOunty @fastandfurious @Feb_release_2019
  Scenario Outline: Validate Cancel button for Multi Cunty Pop-up on Home Page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following MultiCounty Zip information in the UHC site
      | Zip Code | <MultiCOuntyzipcode> |
    Then the user validates the Cancel button for Multi COunty Pop-up lands on enter Zip code Page in UHC

    Examples: 
      | MultiCOuntyzipcode |
      |              78006 |

  @F250062 @SubNavMultiCOunty @fastandfurious @Feb_release_2019
  Scenario Outline: Validate Cancel button for Multi Cunty Pop-up on Sub-nav Plan Search
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following MultiCounty Zip in Header Sub Nav in the UHC site
      | Zip Code | <MultiCOuntyzipcode> |
    Then the user validates the Cancel button for Multi COunty Pop-up lands on enter Zip code Page in UHC

    Examples: 
      | MultiCOuntyzipcode |
      |              78006 |

  @F250062 @VPPChangeLocationMultiCOunty @fastandfurious @Feb_release_2019
  Scenario Outline: Validate Cancel button for Multi Cunty Pop-up on VPP for Change Location
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When the user performs Change Location on Plan Summary Page using following MultiCounty Zip information in the UHC site
      | Zip Code | <MultiCOuntyzipcode> |
    Then the user validates the Cancel button for Multi COunty Pop-up lands on enter Zip code Page in UHC

    Examples: 
      | zipcode | isMultiCounty | county             | MultiCOuntyzipcode |
      |   90210 | NO            | Los Angeles County |              80002 |

  @F225721 @VPPPromoWidget @Predetors @Feb_release_2019
  Scenario Outline: Vaidate the Right Rail Promo Widget
    Given the user is on the uhcmedicaresolutions site landing page
    When I access the vpp page
      | Zip Code | <zipcode> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user validates the VPP Promo right rail widjet
      | Plan Name | <planName> |

    Examples: 
      | zipcode | plantype | planName                    |
      |   55344 | MA       | UnitedHealthcare Sync (PPO) |

  @F251983 @validatePCPandSpecialistTiering @fastandfurious @Apr_release_2019
  Scenario Outline: UserStory: <UID> -plan type: <plantype> - Verify PCP and Specialist Benefits Tiering in Plan Details for provided plan on UHC
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    Then the user validates the following Medical Benefits Plan details for the plan in UMS
      | Benefit Type  | <benefitType>  |
      | Expected Text | <expectedText> |

    Examples: 
      | UID                                     | zipcode | isMultutiCounty | county          | plantype | planName                                          | benefitType                 | expectedText                          |
      | US1497184 - UHC - Specialist Tiering    |   27021 | YES             | Stokes County   | MA       | AARP MedicareComplete Essential (HMO)             | Specialist Copay            | Tier 1: $30 copay / Tier 2: $50 copay |
      | US1497184 - UHC - Specialist Tiering    |   27021 | YES             | Stokes County   | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Specialist Copay            | Tier 1: $30 copay / Tier 2: $50 copay |
      | US1497184 - UHC - Specialist Tiering    |   28616 | NO              | Avery County    | MAPD     | AARP MedicareComplete Plan 2 (HMO)                | Specialist Copay            | Tier 1: $35 copay / Tier 2: $50 copay |
      | US1497184 - UHC - Specialist Tiering    |   28701 | NO              | Buncombe County | MAPD     | AARP MedicareComplete Plan 3 (HMO)                | Specialist Copay            | Tier 1: $40 copay / Tier 2: $50 copay |
      | US1497184 - UHC - No Specialist Tiering |   06280 | NO              | Windham County  | MA       | UnitedHealthcare MedicareComplete Essential (HMO) | Specialist Copay            | $35 copay                             |
      | US1497184 - UHC - No Specialist Tiering |   35618 | NO              | Lawrence County | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Specialist Copay            | $40 copay                             |
      | US1497180 - UHC - PCP Tiering           |   27021 | YES             | Stokes County   | MA       | AARP MedicareComplete Essential (HMO)             | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $10 copay  |
      | US1497180 - UHC - PCP Tiering           |   27021 | YES             | Stokes County   | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $10 copay  |
      | US1497180 - UHC - PCP Tiering           |   28616 | NO              | Avery County    | MAPD     | AARP MedicareComplete Plan 2 (HMO)                | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $20 copay  |
      | US1497180 - UHC - PCP Tiering           |   28701 | NO              | Buncombe County | MAPD     | AARP MedicareComplete Plan 3 (HMO)                | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $20 copay  |
      | US1497180 - UHC - No PCP Tiering        |   06280 | NO              | Windham County  | MA       | UnitedHealthcare MedicareComplete Essential (HMO) | Primary Care Provider Copay | $5 copay                              |
      | US1497180 - UHC - No PCP Tiering        |   35618 | NO              | Lawrence County | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Primary Care Provider Copay | $5 copay                              |

  @F251983 @validatePCPTieringPlanCompare @fastandfurious @Apr_release_2019
  Scenario Outline: UserStory: <UID> -plan type: <plantype> - Verify PCP and Specialist Benefits Tiering in Plan Compare Page for provided plan on UHC
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user selects plans to add to plan compare and navigates to Plan compare page in UHC site
      | Plan Name | <planName> |
    Then the user validates the following Medical Benefits for the plan in Plan Compare Page on UHC
      | Benefit Type  | <benefitType>  |
      | Expected Text | <expectedText> |
      | Plan Name     | <planName>     |

    Examples: 
      | UID                                                  | zipcode | isMultutiCounty | county          | plantype | planName                                          | benefitType                 | expectedText                          |
      | US1625235 - UHC Plan Compare - PCP Tiering           |   27021 | YES             | Stokes County   | MA       | AARP MedicareComplete Essential (HMO)             | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $10 copay  |
      | US1625235 - UHC Plan Compare - PCP Tiering           |   27021 | YES             | Stokes County   | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $10 copay  |
      | US1625235 - UHC Plan Compare - PCP Tiering           |   28616 | NO              | Avery County    | MAPD     | AARP MedicareComplete Plan 2 (HMO)                | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $20 copay  |
      | US1625235 - UHC Plan Compare - PCP Tiering           |   28701 | NO              | Buncombe County | MAPD     | AARP MedicareComplete Plan 3 (HMO)                | Primary Care Provider Copay | Tier 1: $0 copay / Tier 2: $20 copay  |
      | US1625235 - UHC Plan Compare - PCP No Tiering        |   06280 | NO              | Windham County  | MA       | UnitedHealthcare MedicareComplete Essential (HMO) | Primary Care Provider Copay | $5 copay                              |
      | US1625235 - UHC Plan Compare - PCP No Tiering        |   35618 | NO              | Lawrence County | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Primary Care Provider Copay | $5 copay                              |
      | US1653895 - UHC Plan Compare - Specialist Tiering    |   27021 | YES             | Stokes County   | MA       | AARP MedicareComplete Essential (HMO)             | Specialist Copay            | Tier 1: $30 copay / Tier 2: $50 copay |
      | US1653895 - UHC Plan Compare - Specialist Tiering    |   27021 | YES             | Stokes County   | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Specialist Copay            | Tier 1: $30 copay / Tier 2: $50 copay |
      | US1653895 - UHC Plan Compare - Specialist Tiering    |   28616 | NO              | Avery County    | MAPD     | AARP MedicareComplete Plan 2 (HMO)                | Specialist Copay            | Tier 1: $35 copay / Tier 2: $50 copay |
      | US1653895 - UHC Plan Compare - Specialist Tiering    |   28701 | NO              | Buncombe County | MAPD     | AARP MedicareComplete Plan 3 (HMO)                | Specialist Copay            | Tier 1: $40 copay / Tier 2: $50 copay |
      | US1653895 - UHC Plan Compare - No Specialist Tiering |   06280 | NO              | Windham County  | MA       | UnitedHealthcare MedicareComplete Essential (HMO) | Specialist Copay            | $35 copay                             |
      | US1653895 - UHC Plan Compare - No Specialist Tiering |   35618 | NO              | Lawrence County | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Specialist Copay            | $40 copay                             |

  @F251983 @validateOutPatientHospitalServices @fastandfurious @Apr_release_2019
  Scenario Outline: UserStory: <UID> -plan type: <plantype> - Verify Out Patient Hospital Visit Benefits vakues in Plan Details for provided plan on UHC
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    Then the user validates the following Medical Benefits Plan details for the plan in UMS
      | Benefit Type  | <benefitType>  |
      | Expected Text | <expectedText> |

    Examples: 
      | UID                                            | zipcode | isMultutiCounty | county             | plantype | planName                                          | benefitType                  | expectedText    |
      | US1533323 - UHC - OutPatient Hospital Services |   06280 | NO              | Windham County     | MA       | UnitedHealthcare MedicareComplete Essential (HMO) | Outpatient Hospital Services | $250 copay      |
      | US1533323 - UHC - OutPatient Hospital Services |   99210 | NO              | Spokane County     | MA       | AARP MedicareComplete Essential (HMO)             | Outpatient Hospital Services | 20% of the cost |
      | US1533323 - UHC - OutPatient Hospital Services |   35650 | NO              | Lawrence County    | MAPD     | AARP MedicareComplete Plan 1 (HMO)                | Outpatient Hospital Services | $295 copay      |
      | US1533323 - UHC - OutPatient Hospital Services |   90210 | NO              | Los Angeles County | MAPD     | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | Outpatient Hospital Services | $0 copay        |
      | US1533323 - UHC - OutPatient Hospital Services |   33002 | NO              | Miami-Dade County  | SNP      | Preferred Special Care Miami-Dade (HMO SNP)       | Outpatient Hospital Services | $75 copay       |
      | US1533323 - UHC - OutPatient Hospital Services |   36688 | NO              | Mobile County      | SNP      | UnitedHealthcare Dual Complete (HMO SNP)          | Outpatient Hospital Services | $0 copay        |

  @F251983 @validateAmbulatorySurgicalCenterPackage @fastandfurious @Apr_release_2019
  Scenario Outline: UserStory: <UID> - plan type: <plantype> - Verify Ambulatory Surgical Centre Benefit on Plan Details Page for the provided plan on UHC
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site
      | Plan Type | <plantype> |
    Then the user view plan details of the above selected plan in UMS site and validates
      | Plan Name | <planName> |
    Then the user validates the following Medical Benefits Plan details for the plan in UMS
      | Benefit Type  | <benefitType>  |
      | Expected Text | <expectedText> |

    Examples: 
      | UID                                                  | zipcode | isMultutiCounty | county              | plantype | planName                                               | benefitType                | expectedText               |
      | US1641967 - UHC - Ambulatory Surgical Center Package |   35616 | NO              | Colbert County      | MAPD     | AARP MedicareComplete Plan 1 (HMO)                     | Ambulatory Surgical Center | $245 copay                 |
      | US1641967 - UHC - Ambulatory Surgical Center Package |   33413 | NO              | Palm Beach County   | MAPD     | UnitedHealthcare Sync (PPO)                            | Ambulatory Surgical Center | $150 copay                 |
      | US1641967 - UHC - Ambulatory Surgical Center Package |   84301 | NO              | Box Elder County    | MA       | AARP MedicareComplete Essential (HMO)                  | Ambulatory Surgical Center | $290 copay                 |
      | US1641967 - UHC - Ambulatory Surgical Center Package |   83616 | YES             | Ada County          | MAPD     | UnitedHealthcare MedicareComplete Assure (PPO)         | Ambulatory Surgical Center | $0 copay - 20% of the cost |
      | US1641967 - UHC - Ambulatory Surgical Center Package |   33002 | NO              | Miami-Dade County   | SNP      | Preferred Special Care Miami-Dade (HMO SNP)            | Ambulatory Surgical Center | $25 copay                  |
      | US1641967 - UHC - Ambulatory Surgical Center Package |   53920 | YES             | Adams County        | SNP      | UnitedHealthcare MedicareComplete Assist (PPO SNP)     | Ambulatory Surgical Center | $295 copay                 |
      | US1641967 - UHC - Ambulatory Surgical Center Package |   92220 | NO              | Riverside County    | MAPD     | AARP MedicareComplete SecureHorizons Plan 2 (HMO)      | Ambulatory Surgical Center | $0 copay                   |
      | US1641967 - UHC - Ambulatory Surgical Center Package |   98601 | YES             | Clark County        | SNP      | UnitedHealthcare Nursing Home Plan (PPO SNP)           | Ambulatory Surgical Center | 10% of the cost            |
      | US1641967 - UHC - Ambulatory Surgical Center Package |   53910 | NO              | Adams County        | MA       | UnitedHealthcare MedicareComplete Open Essential (PPO) | Ambulatory Surgical Center | $250 copay                 |
      | US1641967 - UHC - Ambulatory Surgical Center Package |   32960 | NO              | Indian River County | MAPD     | AARP MedicareComplete Focus (HMO)                      | Ambulatory Surgical Center | $150 copay                 |

  @feature-F265872 @us1598162 @vppFavoritePlanRegressionBlayer @vppFavoritePlanInSession @vppFavoritePlanInSessionUhc @thePredators @Apr_release_2019
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can save and unsave favorite plans on view plan preview page on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    Then user validates selected plans can be saved as favorite on UHC site
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |
    Then user validates saved favorite plans will be stored within same session after zipcode change from Home on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates saved favorite plans will be stored within same session after zipcode change from Shop For a Plan on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates saved favorite plans will be stored within same session after zipcode change within VPP page on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates ability to unsave a saved plan on UHC site
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |
    Then user validates unsave favorite plans will be stored within same session after zipcode change from Home on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates unsave favorite plans will be stored within same session after zipcode change from Shop For a Plan on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |
    Then user validates unsave favorite plans will be stored within same session after zipcode change within VPP page on UHC site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
      | MA Test Plans   | <MA_testPlans>  |
      | PDP Test Plans  | <PDP_testPlans> |
      | SNP Test Plans  | <SNP_testPlans> |

    Examples: 
      | UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                           | PDP_testPlans                                                    | SNP_testPlans                              |
      | 1598162 |   80001 | NO            | Jefferson County | AARP MedicareComplete SecureHorizons Essential (HMO),AARP MedicareComplete SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) |

  @feature-F265872 @us1598162 @vppFavoritePlanRegressionBlayer @vppFavoritePlanInSessionCloseTab @vppFavoritePlanInSessionCloseTabUhc @thePredators @Apr_release_2019
  Scenario Outline: UID: <UID> -zipcode: <zipcode> - Verify user can favorite plans will be saved within session on view plan preview page on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plan count for all plan types on plan summary page in the UMS site
    Then user validates selected plans can be saved as favorite on UHC site
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |
    Then user closes the original tab and open new tab for UHC site
    Then the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user validates plans remain saved within same session for UHC site
      | MA Test Plans  | <MA_testPlans>  |
      | PDP Test Plans | <PDP_testPlans> |
      | SNP Test Plans | <SNP_testPlans> |

    Examples: 
      | UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                           | PDP_testPlans                                                    | SNP_testPlans                              |
      | 1598162 |   80001 | NO            | Jefferson County | AARP MedicareComplete SecureHorizons Essential (HMO),AARP MedicareComplete SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) |

  @F322478 @us1603378 @BlayerSAMCall
  Scenario Outline: UID: <UID>  - Verify Call sticky action menu on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When verify Call sticky action menu icon is visible or not
    And verify Call sticky action menu roll out and contain the text Call a Licensed Insurance Agent
    Then user verify the popup and content in popup

    Examples: 
      | UID     |
      | F322478 |

  @F322478 @us1603378 @BlayerSAMChat
  Scenario Outline: UID: <UID>  - Verify Chat sticky action menu on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When verify Chat sticky action menu icon is visible or not
    And verify Chat sticky action menu roll out and contain the text Call a Licensed Insurance Agent
    Then user verify the Chat at its original state

    Examples: 
      | UID     |
      | F322478 |
