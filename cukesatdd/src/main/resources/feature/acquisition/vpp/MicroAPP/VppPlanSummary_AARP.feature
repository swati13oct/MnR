@vppPlanSummaryAARP
Feature: 1.01.1-Vpp to plan Summary AARP Scenarios

  @vppPlanSummaryAARP01 @vppPlanSummaryAARPRun01 @vppPlanSummaryAARPRegression
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

  @vppPlanSummaryAARP02 @vppPlanSummaryAARPRun01 @vppPlanSummaryAARPRegression
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

  @vppPlanSummaryAARP03 @vppPlanSummaryAARPRun01 @vppPlanSummaryAARPRegression
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

  @vppPlanSummaryAARP05 @vppPlanSummaryAARPRun01 @vppPlanSummaryAARPRegression
  Scenario Outline: Verify plan summary for SNP plan ty pes in AARP site
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

  @vppPlanSummaryAARP06 @vppPlanSummaryAARPRun02 @vppPlanSummaryAARPRegression
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

  #@vppPlanSummaryAARP07
  #Scenario Outline: To check Plan Summary for specific to sync plan
  #Given the user is on AARP medicare acquisition site landing page
  #When the user performs plan search using following information in the AARP site
  #| Zip Code        | <zipcode>         |
  #| Is Multi County | <isMultutiCounty> |
  #And the user views the plans of the below plan type in AARP site
  #| Plan Type | <plantype> |
  #Then User validates the VPP promowidjet for specifc plans
  #| Plan Name | <planName> |
  #
  #Examples:
  #| zipcode | isMultutiCounty | plantype | planName                    |
  #|   55344 | NO              | MA       | UnitedHealthcare Sync (PPO) |
  @vppPlanSummaryAARP08 @vppPlanSummaryAARPRun02 @vppPlanSummaryAARPRegression
  Scenario Outline: UID: <UID>  - Verify Call sticky action menu on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When verify Call SAM icon is visible or not
    And verify Call SAM roll out and contain the text Call a Licensed Insurance Agent
    Then user verify the popup and content

    Examples: 
      | UID     | zipcode | isMultutiCounty | county             |
      | F322478 |   90210 | NO              | Los Angeles County |

  @vppPlanSummaryAARP09 @vppPlanSummaryAARPRun02
  Scenario Outline: UID: <UID>  - Verify Chat sticky action menu on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When verify Chat SAM icon is visible or not
    And verify Chat SAM roll out and contain the text Call a Licensed Insurance Agent
    Then user verify the Chat original state

    Examples: 
      | UID     | zipcode | isMultutiCounty | county             |
      | F322478 |   90210 | NO              | Los Angeles County |

  @vppPlanSummaryAARP10 @vppPlanSummaryAARPRun02 @vppPlanSummaryAARPRegression
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

  @vppPlanSummaryAARP11 @vppPlanSummaryAARPRun02
  Scenario Outline: UID: <UID> -plantype: <plantype> - Verify user can invoke the email button and the print button on view plan preview page on AARP site
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    And the user views the plans of the below plan type on test site
      | Plan Type | <plantype> |
      | Site      | <site>     |
    Then user saves first plan on plan summary page on test site
    Then user validates print option for selected plan on plan summary page on test site
    Then user validates print functionality for selected plan on plan summary page on test site
    Then user validates email option for selected plan on plan summary page on test site
    Then user validates email functionality with invalid and valid email address for selected plan on plan summary page on test site
    Then user loads page using email deeplink for plan and validate vpp summary page content on test site

    Examples: 
      | UID     | site   | plantype | zipcode | isMultiCounty | county           |
      | 1598166 | Ulayer | PDP      |   80001 | NO            | Jefferson County |
      | 1598166 | Ulayer | SNP      |   80001 | NO            | Jefferson County |

  @vppPlanSummaryAARP12 @vppPlanSummaryAARPRun02 @vppPlanSummaryAARPRegression
  Scenario Outline: Verify Provider Search  in AARP site from plan summary page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    When the user Click on Is my Provider covered link Ulayer
      | PlanName | <planname> |
   When user selects a provider and retuns to VPP page in ulayer
    Then Verify X out of Y provider covered information is displayed on Plan Summary page Ulayer
      | PlanName | <planname> |

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planname                                            |
      |   90210 | NO              | Los Angeles County | MA       | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |

  @vppPlanSummaryAARP13 @vppPlanSummaryAARPRun02 @vppPlanSummaryAARPRegression
  Scenario Outline: To Verify the drug cost estimator flow for <plantype> through plan details page's Plan Costs tab
    Given the user is on the AARP medicare site landing page
    When user performs plan search using following information in the AARP site
      | Zip Code    | <zipcode>     |
      | County      | <county>      |
      | aep         | <aep>         |
      | currentyear | <currentyear> |
    Then the user navigates to the plan details for the given plan type in AARP site
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
    Then the user navigates to Plan Costs tab in AARP site
    Then user adds drug to drug cost estimator flow for the given plan name in AARP site
      | PlanName   | <planName>  |
      | Drug Name1 | <drugName1> |
    And selects drug details in ums site
      | Drug Name1 | <drugName1> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    When user successfully adds drug in the ums site
      | Drug Name1 | <drugName1> |
    Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
    When the user selects the pharmacy type and distance in AARP site
      | Pharmacy Type | <pharmacyType> |
      | Distance      | <distance>     |
    Then the user selects a pharmacy from the list of pharmacies in AARP site
      | Pharmacy Name | <pharmacyName> |
    Then the user validates the added drugs on See your Estimated Costs page in AARP site
      | Drug Name1 | <drugName1> |
    When the user clicks on Edit Drug List link in AARP site
    Then Enter your drugs page is displayed to the user in AARP site
    Then User click on Switch now to select the Generic of the Brand drug added in AARP site
    Then the user clicks on the Pick a pharmacy button in the DCE flow in AARP site
    Then the user change the pharmacy type and select new pharmacy in AARP site
      | New Pharmacy Type | <newPharmacyType> |
    Then the user validates the added drugs on See your Estimated Costs page in AARP site
      | Drug Name1 | <genericName1> |
    And the user clicks on Back to Plans button on See Your Estimated Costs page in AARP site
    And user verifies annual drug cost in the Plan Cost tab of AARP site
      | Plan Type | <plantype> |
    And the user clicks on Back to All Plans button present on details page in AARP site
    Then user validates Drug information is reflected on plan summary page in AARP site
      | PlanName | <planName> |

    Examples: 
      | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName                    | plantype | planName                        | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear |
      |   90210 | Los Angeles County | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Preferred Retail | 15 miles | COMMUNITY, A WALGREENS PHARMACY | PDP      | AARP MedicareRx Walgreens (PDP) |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |

  @vppPlanSummaryAARP14 @vppPlanSummaryAARPRun02
  Scenario Outline: TID: <TID> -plan type: <plantype> - TID: <TID> -plan type: <plantype> - Verify Loopup Zipcode is navigation to VPP page
    Given the user is on AARP medicare acquisition site landing page
    When the user clicks on Lookup zipcode on AARP
    Then verify find a zipcode popup displpayed and Enter values and click on LookupZipcode on AARP
      | Address | <address> |
      | City    | <city>    |
      | State   | <state>   |
    When the user performs plan search using following information in the aarp site
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
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
      | TID   | zipcode | isMultiCounty | county             | plantype | address                    | city      | state       | firstName | lastName | emailAddress  |
      | 15550 |   90210 | NO            | Los Angeles County | MAPD     | 584 MAIN AVE NORWALK       | FAIRFIELD | CONNECTICUT | test      | test     | test@test.com |
      | 15550 |   30606 | YES           | Clarke County      | MAPD     | 1750 EPPS BRIDGE RD ATHENS | OCONEE    | GEORGIA     | test      | test     | test@test.com |

  @vppPlanSummaryAARP15 @vppPlanSummaryAARPRun02
  Scenario Outline: TID: <TID> -plan type: <plantype> - TID: <TID> -plan type: <plantype> - Verify Loopup Zipcode is navigation to VPP page
    Given the user is on AARP medicare acquisition site landing page
    When the user performs plan search using following information in the AARP site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    Then user clicks on Change Zip code link in AARP site
    Then user clicks on Select by Address and Enter fileds in AARP Site
      | Address | <address> |
      | City    | <city>    |
      | State   | <state>   |
    When the user clicks on Find plans on vpp using following information in the AARP site
      | County Name2     | <county2>        |
      | Is Multi County2 | <isMultiCounty2> |
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
      | TID   | zipcode | isMultiCounty | county             | plantype | address                    | city      | state       | firstName | lastName | emailAddress  | isMultiCounty2 | county2          |
      | 15550 |   90210 | NO            | Los Angeles County | MAPD     | 584 MAIN AVE NORWALK       | FAIRFIELD | CONNECTICUT | test      | test     | test@test.com | NO             | Fairfield County |
      | 15550 |   78006 | YES           | Bexar County       | MAPD     | 1750 EPPS BRIDGE RD ATHENS | OCONEE    | GEORGIA     | test      | test     | test@test.com | YES            | Clarke County    |

  @vppPlanSummaryAARP16 @vppPlanSummaryAARPRun02 @vppPlanSummaryAARPRegression
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify plan cards on plan summary page in AARP site
    Given the user is on the AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    #And the user validates available plans for selected plan types in the AARP site
    And the user validates plan summary for the below plan in AARP site
      | Plan Name | <planName> |
    Then the user clicks on Learn More AARP for Rocky Mountain plans
      | Plan Name | <planName> |

    Examples: 
      | TID       | zipcode | isMultutiCounty | county      | plantype | planName                                              |
      | US2567142 |   81501 | NO              | Mesa County | SNP      | Rocky Mountain Health Plans DualCare Plus (HMO D-SNP) |

  @vppPlanSummaryAARP17 @vppPlanSummaryAARPRun02 @vppPlanSummaryAARPRegression
  Scenario Outline: TID: <TID> -plan type: <plantype> - plan name: -<planName> - Verify People Health plans Learn More lands on Correct site from UHC site from plan summary page
    Given the user is on the AARP medicare acquisition site landing page
    When the user does plan search using the following information in the AARP site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type in AARP site and select Next year
      | Plan Type | <plantype> |
    #And the user validates available plans for selected plan types in the AARP site
    And the user validates plan summary for the below plan in AARP site
      | Plan Name | <planName> |
    Then the user clicks on Learn More AARP for people Health plans
      | Plan Name | <planName> |

    Examples: 
      | TID       | zipcode | isMultutiCounty | county        | plantype | planName                                 |
      | US2567133 |   70515 | YES             | Acadia Parish | MAPD     | Peoples Health Choices Gold (HMO-POS)    |
      | US2567133 |   70515 | YES             | Acadia Parish | MAPD     | Peoples Health Choices Value (HMO)       |
      | US2567133 |   70515 | YES             | Acadia Parish | SNP      | Peoples Health Secure Health (HMO D-SNP) |
      #| US2567133 |   70718 | YES             | Ascension Parish | MAPD     | Peoples Health Choices 65 "#14 (HMO)"    |
      #| US2567133 |   70420 | YES             | Ascension Parish | MAPD     | Peoples Health Choices 65 "#14 (HMO)"    |
