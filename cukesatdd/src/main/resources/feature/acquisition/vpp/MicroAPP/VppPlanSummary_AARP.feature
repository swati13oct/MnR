@vppPlanSummaryAARP
Feature: Vpp to plan Summary AARP Scenarios

  @vppPlanSummaryAARP01
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify plan cards on plan summary page in AARP site
    Given the user is on the AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    #    And the user validates available plans for selected plan types in the AARP site
    And the user validates plan summary for the below plan in AARP site
      | Plan Name | <planName> |
    Then the user validates marketing bullets of the plan in AARP site
    Then the user validates and clicks Add to compare checkbox for the above selected plan in the AARP site for MA, MAPD , PDP Plans
    Then the user view plan details of the above selected plan in AARP site and validate
      | Plan Name | <planName> |
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary in AARP site
    Then the user validates below plan benefit values for the above selected plan in AARP site for MA , DSNP and MAPD Plans
      | Monthly Premium            | <monthlyPremium>         |
      | Primary Care Physician     | <primaryCarePhysician>   |
      | Specialist                 | <specialist>             |
      | Referral Required          | <referralRequired>       |
      | Out Of Pocket Maximum      | <outOfPocketMaximum>     |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
      | Plan Type                  | <plantype>               |
    Then the user validates below plan benefit values for the above selected plan in AARP site for PDP  Plans
      | Monthly Premium            | <monthlyPremium>         |
      | Annual Deductible          | <annualDeductible>       |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
    Then the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in AARP Site
    Then the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in AARP Site
    Then the user clicks on enter drug information link in the benefits table and validate the DCE Home Page for MAPD, PDP , DSNP Plan in AARP site
    Then the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in AARP Site
    #    Then the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in AARP site
    #    Then the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in AARP site
    Then the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans
    Then the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans
    Then the user clicks on Enroll Now for AARP site and validates the Welcome to OLE Page

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype | planName                                            | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                     | annualDeductible |  |
      | 15545 |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | $0             | $0  copay            | $0  copay  | Yes              | $3,400.00          | $4  copay                                  |                  |  |
      | 15546 |   28105 | YES             | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO-POS D-SNP)      | $0             | $0  copay            | $0  copay  | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance |                  |  |

  @vppPlanSummaryAARP02
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify right rail on plan summary page in AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    Then the user validates the right rail in AARP Site
    Then the user validates the Need Help Section in the right rail in aarp Site
    Then the user validates the TFN in the Need Help Section in aarp Site
    And the user validates and clicks on Find an agent in your area link in aarp Site
    Then the user validates Get a free medicare Guide section in the right rail in aarp Site
    Then the user enters the following information in the Get a free medicare Guide section in aarp Site
      | First Name    | <firstName>    |
      | Last Name     | <lastName>     |
      | Email Address | <emailAddress> |
    # Then the user validates Need More Information section in the right rail in aarp Site
    # Then the user validates Medicare Plans Video Guide Page after clicking Choose a video link in aarp Site
    Then the user validates Plan Selector Tool section in the right rail in aarp Site
    Then the user validates Plan Selector Page after clicking on Start Plan Selector button in aarp Site

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype | firstName | lastName | emailAddress  |
      | 15550 |   90210 | NO              | Los Angeles County | MAPD     | test      | test     | test@test.com |

  @vppPlanSummaryAARP03
  Scenario Outline: 7UID: <UID> -zipcode: <zipcode> - Verify user can save and unsave favorite plans on view plan preview page on AARP site
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

  @vppPlanSummaryAARP04
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

  @vppPlanSummaryAARP05
  Scenario Outline: Verify plan summary for SNP plan types in AARP site
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
      | zipcode | isMultiCounty | county             | plantype | planName                                       |
      |   80001 | NO            | Los Angeles County | SNP      | UnitedHealthcare Nursing Home Plan (PPO I-SNP) |

  @vppPlanSummaryAARP06
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

  @vppPlanSummaryAARP07
  Scenario Outline: To check Plan Summary for specific to sync plan
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

  @vppPlanSummaryAARP08
  Scenario Outline: UID: <UID>  - Verify Call sticky action menu on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When verify Call SAM icon is visible or not
    And verify Call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then user verify the popup and content

    Examples: 
      | UID     |
      | F322478 |

  @vppPlanSummaryAARP09
  Scenario Outline: UID: <UID>  - Verify Chat sticky action menu on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When verify Chat SAM icon is visible or not
    And verify Chat SAM roll out and contain the text Call a Licensed Insurance Agent
    Then user verify the Chat original state

    Examples: 
      | UID     |
      | F322478 |

  @vppPlanSummaryAARP10
  Scenario Outline: To verify links displayed in the global footer of AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    #When user accesses global footer of the AARP Medicare Plans home page
    And user clicks on Aboutus link from footer of the AARP Medicare Plans home page
    And user clicks on contactus link of aboutus page
    And user clicks on sitemap link of contactus page
    And user clicks on privacypolicy link of sitemap page
    #And user clicks on termsOfuse link of privacypolicy page
    And user clicks on disclaimers link of terms&conditions page
    And user clicks on agents&brokers link of disclaimers page
    #And user clicks on Request Assistance and validates modal window ulayer
    And user verifies home link of agents&brokers page ulayer

    Examples: 
      | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode |
      |   90210 | No              | Los Angeles County |              80002 |
