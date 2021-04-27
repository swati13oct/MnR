#file name: VppPlanSummary_Common.feature
Feature: 1.01.1-Vpp to plan Summary Scenarios

  # @vppPlanSummaryAARP01 @vppPlanSummaryAARPRun01 @vppPlanSummaryAARPRegression @regressionAARP @vppPlanSummaryUHC01 @vppPlanSummaryUHCRun01 @vppPlanSummaryUHCRegression
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify plan cards on plan summary page in <site> site
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
    #    And the user validates available plans for selected plan types in the AARP site
    And the user validates plan summary for the below plan
      | Plan Name | <planName> |
    Then the user validates marketing bullets of the plan
    Then the user validates and clicks Add to compare checkbox for the above selected plan for MA, MAPD , PDP Plans
    Then the user views plan details of the above selected plan and validates
      | Plan Name | <planName> |
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary
    Then the user validates below plan benefit values for the above selected plan
      | Monthly Premium            | <monthlyPremium>         |
      | Primary Care Physician     | <primaryCarePhysician>   |
      | Specialist                 | <specialist>             |
      | Referral Required          | <referralRequired>       |
      | Out Of Pocket Maximum      | <outOfPocketMaximum>     |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
      | Plan Type                  | <plantype>               |
      | Annual Deductible          | <annualDeductible>       |
    Then the user hover overs the tool tip for Why is my premium 0 and validates the text
    # New steps for DCE Redesign
    And I access the DCE Redesign from Plan Summary for mentioned plan
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
    Then the user validates Get Started Page
    Then the user click on return to plan summary from Get Started Page to return to VPP Plan Summary
    #Then the user clicks on enter drug information link in the benefits table and validate the DCE Home Page for MAPD, PDP , DSNP Plan in AARP site
    #Then the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in AARP Site
    #    Then the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site
    #    Then the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in AARP site
    Then the user validates Is my provider covered link
    Then the user clicks on Enroll Now and validates the Welcome to OLE Page

    @vppPlanSummaryCommonAARP01
    Examples: 
      | TID   | zipcode | site | isMultutiCounty | county             | plantype | planName                                               | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1 | annualDeductible                                      | planyear |
      | 15545 |   90210 | AARP | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)    | $0             | $0  copay            | $0  copay  | Yes              | $3,400.00          | $2  copay              | [blank]                                               | future   |
      | 15546 |   28105 | AARP | YES             | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete RP (Regional PPO D-SNP) | $0             | $0  copay            | $0  copay  | No               | $0                 | [blank]                | [blank]                                               | future   |
      | 15543 |   90210 | AARP | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                        | $41.60         | [blank]              | [blank]    | [blank]          | [blank]            | $0  copay              | $0 for Tier 1, Tier 2 $445 for Tier 3, Tier 4, Tier 5 | future   |

    @prodRegression_AARP
    Examples: 
      | TID   | zipcode | site | isMultutiCounty | county             | plantype | planName                                            | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1 | annualDeductible | planyear |
      | 15545 |   90210 | AARP | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | $0             | $0  copay            | $0  copay  | Yes              | $3,400.00          | $2  copay              | [blank]          | future   |

    @vppPlanSummaryCommonUHC01
    Examples: 
      | TID   | zipcode | site | isMultutiCounty | county             | plantype | planName                                               | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1 | annualDeductible                                      | planyear |
      | 15545 |   90210 | UHC  | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO)    | $0             | $0  copay            | $0  copay  | Yes              | $3,400.00          | $2  copay              | [blank]                                               | future   |
      | 15546 |   28105 | UHC  | YES             | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete RP (Regional PPO D-SNP) | $0             | $0  copay            | $0  copay  | No               | $0                 | [blank]                | [blank]                                               | future   |
      | 15543 |   90210 | UHC  | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                        | $41.60         | [blank]              | [blank]    | [blank]          | [blank]            | $0  copay              | $0 for Tier 1, Tier 2 $445 for Tier 3, Tier 4, Tier 5 | future   |

    @prodRegression_UHC
    Examples: 
      | TID   | zipcode | site | isMultutiCounty | county             | plantype | planName                                            | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1 | annualDeductible | planyear |
      | 15545 |   90210 | UHC  | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | $0             | $0  copay            | $0  copay  | Yes              | $3,400.00          | $2  copay              | [blank]          | future   |

  #@vppPlanSummaryAARP02 @vppPlanSummaryAARPRun01 @vppPlanSummaryAARPRegression @regressionAARP @vppPlanSummaryUHC02 @vppPlanSummaryUHCRun01 @vppPlanSummaryUHCRegression
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify right rail on plan summary page in <site> site
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
    Then the user validates the right rail
    Then the user validates the Need Help Section in the right rail
    Then the user validates the TFN in the Need Help Section
    And the user validates and clicks on Find an agent
    Then the user validates Get a free medicare Guide section in the right rail
    Then the user enters the following information in the Get a free medicare Guide section
      | First Name    | <firstName>    |
      | Last Name     | <lastName>     |
      | Email Address | <emailAddress> |
    # Then the user validates Need More Information section in the right rail in aarp Site
    # Then the user validates Medicare Plans Video Guide Page after clicking Choose a video link in aarp Site
    Then the user validates Plan Selector Tool section in the right rail
    Then the user validates Plan Selector Page after clicking on Start Plan Selector button

    @vppPlanSummaryCommonAARP01 @prodRegression_AARP
    Examples: 
      | TID   | site | zipcode | isMultutiCounty | county             | plantype | firstName | lastName | emailAddress  | planyear |
      | 15550 | AARP |   90210 | NO              | Los Angeles County | MAPD     | test      | test     | test@test.com | future   |

    @vppPlanSummaryCommonUHC01 @prodRegression_UHC
    Examples: 
      | TID   | site | zipcode | isMultutiCounty | county             | plantype | firstName | lastName | emailAddress  | planyear |
      | 15549 | UHC  |   90210 | NO              | Los Angeles County | MAPD     | test      | test     | test@test.com | future   |

  #@vppPlanSummaryAARP06 @vppPlanSummaryAARPRun02 @vppPlanSummaryAARPRegression @regressionAARP @vppPlanSummaryUHC05 @vppPlanSummaryUHCRun01 @vppPlanSummaryUHCRegression
  Scenario Outline: Validate Cancel button for Multi Cunty Pop-up on VPP for Change Location in <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When the user performs Change Location on Plan Summary Page using following MultiCounty Zip information
      | Zip Code | <MultiCOuntyzipcode> |
    Then the user validates the Cancel button for Multi County Pop-up lands on enter Zip code Page

    @vppPlanSummaryCommonAARP02
    Examples: 
      | site | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode |
      | AARP |   90210 | No              | Los Angeles County |              80002 |

    @vppPlanSummaryCommonUHC02
    Examples: 
      | site | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode |
      | UHC  |   90210 | No              | Los Angeles County |              80002 |

  # @vppPlanSummaryAARP08 @vppPlanSummaryAARPRun02 @vppPlanSummaryAARPRegression @regressionAARP @vppPlanSummaryUHC08 @vppPlanSummaryUHCRun02
  Scenario Outline: UID: <UID>  - Verify Call sticky action menu on <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When verify Call SAM icon is visible
    And verify call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then user verify the popup and content on the site

    @vppPlanSummaryCommonAARP02
    Examples: 
      | UID     | site | zipcode | isMultutiCounty | county             |
      | F322478 | AARP |   90210 | NO              | Los Angeles County |

    @vppPlanSummaryCommonUHC02
    Examples: 
      | UID     | site | zipcode | isMultiCounty | county           |
      | F322478 | UHC  |   80001 | NO            | Jefferson County |

  #@vppPlanSummaryAARP10 @vppPlanSummaryAARPRun02 @vppPlanSummaryAARPRegression @regressionAARP @vppPlanSummaryUHC09 @vppPlanSummaryUHCRun02 @vppPlanSummaryUHCRegression
  Scenario Outline: To verify links displayed in the global footer of <site> site on vpp
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    #When user accesses global footer of the AARP Medicare Plans home page
    And user clicks on About us link from footer of the Medicare Plans home page
    And user clicks on contact us link of aboutus page
    And user clicks on sitemap link of contact us page
    And user clicks on privacy policy link of sitemap page
    #And user clicks on termsOfuse link of privacypolicy page
    And user clicks on disclaimers link of terms & conditions page
    And user clicks on agents & brokers link of disclaimers page
    #And user clicks on Request Assistance and validates modal window ulayer
    And user verifies home link of agents & brokers page

    @vppPlanSummaryCommonAARP02
    Examples: 
      | site | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode |
      | AARP |   90210 | No              | Los Angeles County |              80002 |

    @vppPlanSummaryCommonUHC02
    Examples: 
      | site | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode |
      | UHC  |   90210 | No              | Los Angeles County |              80002 |

  #@vppPlanSummaryAARP12 @vppPlanSummaryAARPRun02 @vppPlanSummaryAARPRegression @regressionAARP @vppPlanSummaryUHC11 @vppPlanSummaryUHCRun02 @vppPlanSummaryUHCRegression
  Scenario Outline: Verify Provider Search  in <site> site from plan summary page
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
    When the user Click on Is my Provider covered link
      | PlanName | <planname> |
    When user selects a provider and retuns to VPP page
    Then Verify X out of Y provider covered information is displayed on Plan Summary page
      | PlanName | <planname> |
    Then Verify provider name is displayed on Plan Summary page
      | PlanName | <planname> |

    @vppPlanSummaryCommonAARP02 @prodRegression_AARP
    Examples: 
      | site | zipcode | isMultutiCounty | county             | plantype | planname                                            | planyear |
      | AARP |   90210 | NO              | Los Angeles County | MA       | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | future   |

    @vppPlanSummaryCommonUHC02 @prodRegression_UHC
    Examples: 
      | site | zipcode | isMultutiCounty | county             | plantype | planname                                            | planyear |
      | UHC  |   90210 | NO              | Los Angeles County | MA       | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) | future   |

  #@vppPlanSummaryAARP16 @vppPlanSummaryAARPRun02 @vppPlanSummaryAARPRegression @regressionAARP @vppPlanSummaryUHC15 @vppPlanSummaryUHCRun02 @vppPlanSummaryUHCRegression
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify Rocky Mountain Health Learn More lands on Correct site from <site> site from plan summary page
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
    #And the user validates available plans for selected plan types in the AARP site
    And the user validates plan summary for the below plan
      | Plan Name | <planName> |
    Then the user clicks on Learn More for Rocky Mountain plans
      | Plan Name | <planName> |

    @vppPlanSummaryCommonAARP02
    Examples: 
      | TID       | site | zipcode | isMultutiCounty | county      | plantype | planName                                              | planyear |
      | US2567142 | AARP |   81501 | NO              | Mesa County | SNP      | Rocky Mountain Health Plans DualCare Plus (HMO D-SNP) | future   |

    @vppPlanSummaryCommonUHC02
    Examples: 
      | TID       | site | zipcode | isMultutiCounty | county      | plantype | planName                                              | planyear |
      | US2567142 | UHC  |   81501 | NO              | Mesa County | SNP      | Rocky Mountain Health Plans DualCare Plus (HMO D-SNP) | future   |

  #@vppPlanSummaryAARP17 @vppPlanSummaryAARPRun02 @vppPlanSummaryAARPRegression @regressionAARP @vppPlanSummaryUHC16 @vppPlanSummaryUHCRun02 @vppPlanSummaryUHCRegression
  Scenario Outline: TID: <TID> -plan type: <plantype> - plan name: -<planName> - Verify People Health plans Learn More lands on Correct site from <site> site from plan summary page
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
    #And the user validates available plans for selected plan types in the AARP site
    And the user validates plan summary for the below plan
      | Plan Name | <planName> |
    Then the user clicks on Learn More for people Health plans
      | Plan Name | <planName> |

    @vppPlanSummaryCommonAARP02
    Examples: 
      | TID       | site | zipcode | isMultutiCounty | county        | plantype | planName                          | planyear |
      | US2567133 | AARP |   70515 | YES             | Acadia Parish | MAPD     | Peoples Health Choices Gold (HMO) | future   |

    @vppPlanSummaryCommonUHC02
    Examples: 
      | TID       | site | zipcode | isMultutiCounty | county        | plantype | planName                          | planyear |
      | US2567133 | UHC  |   70515 | YES             | Acadia Parish | MAPD     | Peoples Health Choices Gold (HMO) | future   |
