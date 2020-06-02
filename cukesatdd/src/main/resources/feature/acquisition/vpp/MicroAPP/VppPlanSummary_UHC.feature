@vppPlanSummaryUHC
Feature: 2.01.1-Vpp to plan Summary UHC Scenarios

  @vppPlanSummaryUHC01 @vppPlanSummaryUHCRun01 @vppPlanSummaryUHCRegression
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify plan cards on plan summary page in UMS site
    Given the user is on uhcmedicaresolutions site landing page
    When the user does plan search using the following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    And the user validates plan summary for the below plan in UMS site
      | Plan Name | <planName> |
    Then the user validates and clicks Add to compare checkbox for the above selected plan in the UMS site for MA, MAPD , PDP Plans
    Then the user validates Add to compare checkbox is not present for DSNP Plans in UMS
    Then the user validates marketing bullets of the plan in UMS Site
    Then the user view plan details of the above selected plan in UMS site and validate
      | Plan Name | <planName> |
    Then the user clicks on back to all plans link and validates its redirection to Plan Summary in UMS site
    Then the user validates below plan benefit values for the above selected plan in UMS site for MA , DSNP and MAPD Plans
      | Monthly Premium            | <monthlyPremium>         |
      | Primary Care Physician     | <primaryCarePhysician>   |
      | Specialist                 | <specialist>             |
      | Referral Required          | <referralRequired>       |
      | Out Of Pocket Maximum      | <outOfPocketMaximum>     |
      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
    #    Then the user validates below plan benefit values for the above selected plan in UMS site for PDP  Plans
    #      | Monthly Premium | <monthlyPremium> |
    #      | Annual Deductible | <annualDeductible> |
    #      | Prescription Drugs, Tier 1 | <prescriptionDrugsTier1> |
    Then the user hover overs the tool tip for Why is my premium 0 and validates the text for MAPD Plan , MA Plan in UMS Site
    #   Then the user hovers over the tool tip for Annual Deductible and validates the ext for PDP Plan in UMS Site
    Then the user clicks on enter drug information link in the benefits table and validates the DCE Home Page for MAPD, PDP , DSNP Plan in UMS Site
    Then the user clicks on Return to Plan Summary link and validates its redirection to Plan Summary Page for MAPD, PDP , DSNP Plan in UMS Site
    #   Then the user validates and clicks learn more about Extra help link for MAPD , PDP , DSNP Plans and it should not be displayed for MA Plans in UMS site
    #    Then the user validates the modal pop up for learn more about Extra help link for MAPD, PDP,DSNP Plans in UMS site
    Then the user validates Is my provider covered link for MA , MAPD and DSNP Plans and it should not be displayed for PDP Plans in UMS Site
    Then the user clicks on Is my provider covered link and validates Provider Search Page for MA , MAPD and DSNP Plans in UMS Site
    Then the user clicks on Enroll Now for UMS site and validates the Welcome to OLE Page

    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype | planName                                       | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1                     | annualDeductible |
      #| 15553 |   90210 | NO              | Los Angeles County | MAPD     | AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | $0             | $0  copay            | $0  copay  | Yes              | $3,400.00          | $4  copay                                  |                  |
      | 15554 |   28105 | YES             | Mecklenburg County | SNP      | UnitedHealthcare Dual Complete (HMO-POS D-SNP) | $0             | $0  copay            | $0  copay  | No               | $0 - $6,700.00     | $0, $1.25, $3.40 copay, or 15% coinsurance |                  |

    @prodRegression
    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype | planName                                               | monthlyPremium | primaryCarePhysician | specialist | referralRequired | outOfPocketMaximum | prescriptionDrugsTier1 | annualDeductible                                      |
      | 15542 |   90210 | NO              | Los Angeles County | MA       | AARP Medicare Advantage SecureHorizons Essential (HMO) | $0             | $5  copay            | $10  copay | Yes              | $4,900.00          | No drug coverage       |                                                       |
      | 15543 |   90210 | NO              | Los Angeles County | PDP      | AARP MedicareRx Walgreens (PDP)                        | $0             |                      |            |                  |                    | $0  copay              | $0 for Tier 1, Tier 2 $415 for Tier 3, Tier 4, Tier 5 |

  @vppPlanSummaryUHC02 @vppPlanSummaryUHCRun01 @vppPlanSummaryUHCRegression
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify right rail on plan summary page in UMS site
    Given the user is on uhcmedicaresolutions site landing page
    When the user does plan search using the following information in UMS site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    When user views plans of the below plan type in UMS site for current year
      | Plan Type | <plantype> |
    Then the user validates the right rail in UMS Site
    Then the user validates the Need Help Section in the right rail in ums Site
    Then the user validates the TFN in the Need Help Section in ums Site
    And the user validates and clicks on Find an agent in your area link in ums Site
    Then the user validates Get a free medicare Guide section in the right rail in ums Site
    Then the user enters the following information in the Get a free medicare Guide section in ums Site
      | First Name    | <firstName>    |
      | Last Name     | <lastName>     |
      | Email Address | <emailAddress> |
    Then the user validates Plan Selector Tool section in the right rail in ums Site
    Then the user validates Plan Selector Page after clicking on Start Plan Selector button in ums Site

    # Then the user validates Need More Information section in the right rail in ums Site
    # Then the user validates Medicare Plans Video Guide Page after clicking Choose a video link in ums Site
    Examples: 
      | TID   | zipcode | isMultutiCounty | county             | plantype | firstName | lastName | emailAddress  |
      | 15549 |   90210 | NO              | Los Angeles County | MAPD     | test      | test     | test@test.com |

  @vppPlanSummaryUHC03 @vppPlanSummaryUHCRun01 @vppPlanSummaryUHCRegression
  Scenario Outline: UD: <UID> -zipcode: <zipcode> - Verify user can save and unsave favorite plans on view plan preview page on UHC site
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

  @vppPlanSummaryUHC04
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
      | UID     | zipcode | isMultiCounty | county           | MA_testPlans                                                                                               | PDP_testPlans                                                    | SNP_testPlans                              |
      | 1598162 |   80001 | NO            | Jefferson County | AARP Medicare Advantage SecureHorizons Essential (HMO),AARP Medicare Advantage SecureHorizons Plan 1 (HMO) | AARP MedicareRx Preferred (PDP),AARP MedicareRx Saver Plus (PDP) | UnitedHealthcare Dual Complete (HMO D-SNP) |

  @vppPlanSummaryUHC05 @vppPlanSummaryUHCRun01 @vppPlanSummaryUHCRegression
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

  #@vppPlanSummaryUHC06
  #Scenario Outline: Vaidate the Right Rail Promo Widget
  #Given the user is on the uhcmedicaresolutions site landing page
  #When I access the vpp page
  #| Zip Code | <zipcode> |
  #When user views plans of the below plan type in UMS site
  #| Plan Type | <plantype> |
  #Then the user validates the VPP Promo right rail widjet
  #| Plan Name | <planName> |
  #
  #Examples:
  #| zipcode | plantype | planName                    |
  #|   55344 | MA       | UnitedHealthcare Sync (PPO) |
  @vppPlanSummaryUHC07 @vppPlanSummaryUHCRun02 @vppPlanSummaryUHCRegression
  Scenario Outline: UID: <UID>  - Verify Call sticky action menu on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When verify Call sticky action menu icon is visible or not
    And verify Call sticky action menu roll out and contain the text Call a Licensed Insurance Agent
    Then user verify the popup and content in popup

    Examples: 
      | UID     | zipcode | isMultiCounty | county           |
      | F322478 |   80001 | NO            | Jefferson County |

  @vppPlanSummaryUHC08 @vppPlanSummaryUHCRun02
  Scenario Outline: UI8: <UID>  - Verify Chat sticky action menu on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When verify Chat sticky action menu icon is visible or not
    And verify Chat sticky action menu roll out and contain the text Call a Licensed Insurance Agent
    Then user verify the Chat at its original state

    Examples: 
      | UID     | zipcode | isMultiCounty | county           |
      | F322478 |   80001 | NO            | Jefferson County |

  @vppPlanSummaryUHC09 @vppPlanSummaryUHCRun02 @vppPlanSummaryUHCRegression
  Scenario Outline: To verify links displayed in Global footer section in UMS site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>       |
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    #When user accesses global footer UHC Medicaresolutions Site
    And the user clicks on Aboutus link from home page footer UHC Medicaresolutions Site
    And the user clicks on Contactus link from about us page footer UHC Medicaresolutions Site
    And the user clicks on Sitemap link from home page footer UHC Medicaresolutions Site
    And the user clicks on Privacy Policy link from Contactus page footer UHC Medicaresolutions Site
    #And the user clicks on Terms of use link from Privacy Policy page footer UHC Medicaresolutions Site
    And the user clicks on Disclaimers link from Terms of use page footer UHC Medicaresolutions Site
    #And the user clicks on Agents & Brokers link from Disclaimers page footer UHC Medicaresolutions Site
    #And user clicks on Request Assistance and validates modal window bluelayer
    And user verifies home link of agents&brokers page bluelayer

    Examples: 
      | zipcode | isMultutiCounty | county             | MultiCOuntyzipcode |
      |   90210 | No              | Los Angeles County |              80002 |

  @vppPlanSummaryUHC10 @vppPlanSummaryUHCRun02 @vppPlanSummaryUHCRegression
  Scenario Outline: UID: <UID> -plantype: <plantype> - Verify user can invoke the email button and the print button on view plan summary page on UHC site
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
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
      | 1598166 | Blayer | PDP      |   80001 | NO            | Jefferson County |
      | 1598166 | Blayer | SNP      |   80001 | NO            | Jefferson County |

  @vppPlanSummaryUHC11 @vppPlanSummaryUHCRun02 @vppPlanSummaryUHCRegression
  Scenario Outline: Verify Provider Search  in UHC site from plan summary page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    When user Click on Is my Provider covered link ums
      | PlanName | <planName> |
    When user selects a provider and retuns to VPP page in ums
    Then Verify X out of Y provider covered information is displayed on Plan Summary page ums
      | PlanName | <planName> |

    Examples: 
      | zipcode | isMultutiCounty | county             | plantype | planName                                            |
      |   90210 | NO              | Los Angeles County | MA       | AARP Medicare Advantage SecureHorizons Plan 2 (HMO) |

  @vppPlanSummaryUHC12 @vppPlanSummaryUHCRun02 @vppPlanSummaryUHCRegression
  Scenario Outline: To Verify the drug cost estimator flow for <plantype> through plan details page's Plan Costs tab
    Given user is on blue layer landing page
    When user performs plan search using following information in the UMS site
      | Zip Code    | <zipcode>     |
      | County      | <county>      |
      | aep         | <aep>         |
      | currentyear | <currentyear> |
    Then the user navigates to the plan details for the given plan type in UMS site
      | Plan Type | <plantype> |
      | Plan Name | <planName> |
    Then the user navigates to Plan Costs tab in UMS site
    Then user adds drug to drug cost estimator flow for the given plan name in UMS site
      | PlanName   | <planName>  |
      | Drug Name1 | <drugName1> |
    And selects drug details in UMS site
      | Drug Name1 | <drugName1> |
      | Quantity   | <quantity>  |
      | Frequency  | <frequency> |
    When user successfully adds drug in the UMS site
      | Drug Name1 | <drugName1> |
    Then the user clicks on the Pick a pharmacy button in the DCE flow in UMS site
    When the user selects the pharmacy type and distance in UMS site
      | Pharmacy Type | <pharmacyType> |
      | Distance      | <distance>     |
    Then the user selects a pharmacy from the list of pharmacies in UMS site
      | Pharmacy Name | <pharmacyName> |
    Then the user validates the added drugs on See your Estimated Costs page in UMS site
      | Drug Name1 | <drugName1> |
    When the user clicks on Edit Drug List link in UMS site
    Then Enter your drugs page is displayed to the user in UMS site
    Then User click on Switch now to select the Generic of the Brand drug added in UMS site
    Then the user clicks on the Pick a pharmacy button in the DCE flow in UMS site
    Then the user change the pharmacy type and select new pharmacy in UMS site
      | New Pharmacy Type | <newPharmacyType> |
    Then the user validates the added drugs on See your Estimated Costs page in UMS site
      | Drug Name1 | <genericName1> |
    And the user clicks on Back to Plans button on See Your Estimated Costs page in UMS site
    And user verifies annual drug cost in the Plan Cost tab of UMS site
      | Plan Type | <plantype> |
    And the user clicks on Back to All Plans button present on details page in UMS site
    Then user validates Drug information is reflected on plan summary page in UMS site
      | PlanName | <planName> |

    Examples: 
      | zipcode | county             | drugInitials1 | drugName1 | drugInitials2 | drugName2  | drugInitials3 | drugName3     | pharmacyType     | distance | pharmacyName                    | plantype | planName                        | quantity | frequency     | newPharmacyType | genericName1 | genricName3 | aep | currentyear |
      |   90210 | Los Angeles County | lipi          | Lipitor   | dron          | dronabinol | Adva          | Advair Diskus | Preferred Retail | 15 miles | COMMUNITY, A WALGREENS PHARMACY | PDP      | AARP MedicareRx Walgreens (PDP) |       30 | Every 1 month | Mail Order      | atorvastatin | fluticasone | no  | no          |

  @vppPlanSummaryUHC13 @vppPlanSummaryUHCRun02 @vppPlanSummaryUHCRegression
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify Loopup Zipcode is navigation to VPP page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user clicks on Lookup zipcode on UHC
    Then verify find a zipcode popup displpayed and Enter values and click on LookupZipcode on uhc
      | Address | <address> |
      | City    | <city>    |
      | State   | <state>   |
    When the user performs plan search using following information in the uhc site
      | County Name     | <county>        |
      | Is Multi County | <isMultiCounty> |
    When user views plans of the below plan type in UMS site for current year
      | Plan Type | <plantype> |
    Then the user validates the right rail in UMS Site
    Then the user validates the Need Help Section in the right rail in ums Site
    Then the user validates the TFN in the Need Help Section in ums Site
    And the user validates and clicks on Find an agent in your area link in ums Site
    Then the user validates Get a free medicare Guide section in the right rail in ums Site
    Then the user enters the following information in the Get a free medicare Guide section in ums Site
      | First Name    | <firstName>    |
      | Last Name     | <lastName>     |
      | Email Address | <emailAddress> |
    Then the user validates Plan Selector Tool section in the right rail in ums Site
    Then the user validates Plan Selector Page after clicking on Start Plan Selector button in ums Site

    Examples: 
      | TID   | zipcode | isMultiCounty | county             | plantype | address                    | city      | state       | firstName | lastName | emailAddress  |
      | 15550 |   90210 | NO            | Los Angeles County | MAPD     | 584 MAIN AVE NORWALK       | FAIRFIELD | CONNECTICUT | test      | test     | test@test.com |
      | 15550 |   30606 | YES           | Clarke County      | MAPD     | 1750 EPPS BRIDGE RD ATHENS | OCONEE    | GEORGIA     | test      | test     | test@test.com |

  @vppPlanSummaryUHC14 @vppPlanSummaryUHCRun02 @vppPlanSummaryUHCRegression
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify Change Zipcode on VPP using Search By Address
    Given the user is on uhcmedicaresolutions site landing page
    When the user does plan search using the following information in UMS site
      | Zip Code        | <zipcode>         |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    Then user clicks on Change Zip code link in UMS site
    Then user clicks on Select by Address and Enter fileds in UMS Site
      | Address | <address> |
      | City    | <city>    |
      | State   | <state>   |
    When the user clicks on Find plans on vpp using following information in the UMS site
      | County Name2     | <county2>        |
      | Is Multi County2 | <isMultiCounty2> |
    When user views plans of the below plan type in UMS site for current year
      | Plan Type | <plantype> |
    Then the user validates the right rail in UMS Site
    Then the user validates the Need Help Section in the right rail in ums Site
    Then the user validates the TFN in the Need Help Section in ums Site
    And the user validates and clicks on Find an agent in your area link in ums Site
    Then the user validates Get a free medicare Guide section in the right rail in ums Site
    Then the user enters the following information in the Get a free medicare Guide section in ums Site
      | First Name    | <firstName>    |
      | Last Name     | <lastName>     |
      | Email Address | <emailAddress> |
    Then the user validates Plan Selector Tool section in the right rail in ums Site
    Then the user validates Plan Selector Page after clicking on Start Plan Selector button in ums Site

    Examples: 
      | TID   | zipcode | isMultiCounty | county             | plantype | address                    | city      | state       | firstName | lastName | emailAddress  | isMultiCounty2 | county2          |
      | 15550 |   90210 | NO            | Los Angeles County | MAPD     | 584 MAIN AVE NORWALK       | FAIRFIELD | CONNECTICUT | test      | test     | test@test.com | NO             | Fairfield County |
      | 15550 |   78006 | YES           | Bexar County       | MAPD     | 1750 EPPS BRIDGE RD ATHENS | OCONEE    | GEORGIA     | test      | test     | test@test.com | YES            | Clarke County    |

  @vppPlanSummaryUHC15 @vppPlanSummaryUHCRun02 @vppPlanSummaryUHCRegression
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify Rocky Mountain Health Learn More lands on Correct site from UHC site from plan summary page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    And the user validates plan summary for the below plan in UMS site
      | Plan Name | <planName> |
    Then the user clicks on Learn More UMS for Rocky Mountain plans
      | Plan Name | <planName> |

    Examples: 
      | TID       | zipcode | isMultutiCounty | county      | plantype | planName                                              |
      | US2567142 |   81501 | NO              | Mesa County | SNP      | Rocky Mountain Health Plans DualCare Plus (HMO D-SNP) |

  @vppPlanSummaryUHC16 @vppPlanSummaryUHCRun02 @vppPlanSummaryUHCRegression
  Scenario Outline: TID: <TID> -plan type: <plantype> - Verify People Health plans Learn More lands on Correct site from UHC site from plan summary page
    Given the user is on the uhcmedicaresolutions site landing page
    When the user performs plan search using following information in UMS site
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    When user views plans of the below plan type in UMS site for next year
      | Plan Type | <plantype> |
    And the user validates plan summary for the below plan in UMS site
      | Plan Name | <planName> |
    Then the user clicks on Learn More UMS for people Health plans
      | Plan Name | <planName> |

    Examples: 
      | TID       | zipcode | isMultutiCounty | county        | plantype | planName                                 |
      | US2567133  |   70515 | YES             | Acadia Parish | MAPD     | Peoples Health Choices Gold (HMO-POS)    |
      | US2567133 |   70515 | YES             | Acadia Parish | MAPD     | Peoples Health Choices Value (HMO)       |
      | US2567133 |   70515 | YES             | Acadia Parish | SNP      | Peoples Health Secure Health (HMO D-SNP) |
      #| US2567133 |   70718 | YES             | Ascension Parish | MAPD     | Peoples Health Choices 65 "#14 (HMO)"    |
      #| US2567133 |   70420 | YES             | Ascension Parish | MAPD     | Peoples Health Choices 65 "#14 (HMO)"    |
      
