@UATRegression @DCE
Feature: 1.10.4 UAT-DCE-To test UAT DCE E2E Regression Scenarios

  @dce_ShopPDP_E2E_Scenario2_UAT
  Scenario Outline: <Scenario> : To verify DCE REDESIGN flow from Shop PDP page on
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user navigates to Shop plans for PDP Page and clicks on DCE link fto land on DCE Redesign
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    And user click on Switch To Generic
    And user clicks on change pharmacy link from details page
    And the user selects Mail Pharmacy and returns to DCE Details page
    And the user clicks Edit Drug on Drug Details Page and validates user navigates to Build your drug list Page
    And the user clicks on Edit button on Drug List page on DCE
      | DrugName | <drug2> |
    And the user changes the supply length
      | Supply Length | <supplyLength> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user Captures Drug costs on Drug Details Page
    And the user validates link to Drug Summary Page
    And the user Captures Drug costs on Drug Summary Page for the given plan
      | Plan Name | <planName> |
    And the user compares drug costs for drug details and drug summary pages
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    And the user verifies the drug information on prescription drug tab
      | DrugName | <drug2> |
    And the user verifies the added pharmacy on prescription drug tab

    @dce_ShopPDP_E2E_Scenario2_UAT_AARP @regressionAARP
    Examples: 
      | Scenario           | site | drug1   | drug2                | zipCode | planType | planName                        | supplyLength   |
      | E2E Scenario 2_AMP | AARP | Lipitor | atorvastatin calcium |   80002 | PDP      | AARP MedicareRx Walgreens (PDP) | Every 3 Months |

    @dce_ShopPDP_E2E_Scenario2_UAT_UHC @regressionUHC
    Examples: 
      | Scenario           | site | drug1   | drug2                | zipCode | planType | planName                        | supplyLength   |
      | E2E Scenario 2_UMS | UHC  | Lipitor | atorvastatin calcium |   80002 | PDP      | AARP MedicareRx Walgreens (PDP) | Every 3 Months |

  @DCE_MedEdPage_E2E_Scenario4_UAT
  Scenario Outline: <Scenario> : To verify DCE REDESIGN flow from Med Ed page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Then the user navigates to Med Ed - Prescription Drugs Page
    Then the uset clicks on Estimate Drug Costs Link to land on DCE Redesign
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then the user validates PLan Toggle on Drug Summary Page
    And user clicks on change pharmacy link from summary page
    Then the user validates distance dropdown and Zipcode change on Summary page - Change Pharmacy Page
      | PharmacyZipCode | <pharmacyZipCode> |
    Then the user selects following pharmacy and returns to DCE Summary page
      | SelectPharmacy | <SelectPharmacy> |
    And the user Captures Drug costs on Drug Summary Page for the given plan
      | Plan Name | <planName> |
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user Captures Drug costs on Drug Details Page
    And the user compares drug costs for drug details and drug summary pages

    @DCE_MedEdPage_E2E_Scenario4_UAT_AARP @regressionAARP
    Examples: 
      | Scenario           | site | drug1   | drug2  | zipCode | pharmacyZipCode | SelectPharmacy | planType | planName                        |
      | E2E Scenario 4_AMP | AARP | Orkambi | Fanapt |   80002 |           10001 | CVS PHARMACY   | PDP      | AARP MedicareRx Walgreens (PDP) |

    @DCE_MedEdPage_E2E_Scenario4_UAT_UHC @regressionUHC
    Examples: 
      | Scenario           | site | drug1   | drug2  | zipCode | pharmacyZipCode | SelectPharmacy | planType | planName                        |
      | E2E Scenario 4_UMS | UHC  | Orkambi | Fanapt |   80002 |           10001 | CVS PHARMACY   | PDP      | AARP MedicareRx Walgreens (PDP) |

  @DCE_E2E_Scenario6_UAT
  Scenario Outline: <Scenario> : To verify DCE REDESIGN flow from External Link
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following Campaign acquisition site page
      | PagePath | <path> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And I access the DCE Redesign from Plan Summary for mentioned plan
      | Plan Type | <plantype> |
      | Plan Name | <planname> |
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
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug5> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug6> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug7> |
    Then the user edits supply length to three months for following drug
      | EditDrug | <drug5> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user validates planName matches plan Name in VPP
    # Then the user Captures Drug costs on Drug Details Page
    Then the user validates Switch to generic for following Brand Drug and validate Generic drug on Details Page
      | Brand Drug   | <brandDrug1>   |
      | Generic Drug | <genericDrug1> |
    Then the user validates Switch to generic for following Brand Drug and validate Generic drug on Details Page
      | Brand Drug   | <brandDrug2>   |
      | Generic Drug | <genericDrug2> |
    Then the user validates following expected Premium on DCE Details Page
      | Premium | <premium> |
    Then the user verify the Retail chain pharmacy on detail page
    Then the user Captures Drug costs on Drug Details Page
    And the user validates link to Drug Summary Page
    And the user validates functional tool tips for the given plan
      | Plan Name | <planname> |
    Then the user validates View Drug Pricing modal for the given plan
      | Plan Name | <planname> |
    And the user Captures Drug costs on Drug Summary Page for the given plan
      | Plan Name | <planname> |
    And the user compares drug costs for drug details and drug summary pages
    Then the user verifies NBA modal for creating profile on drug summary page
    Then the user click on return to plan summary on DCE summary page
    Then user changes zipcode within VPP page
      | Zip Code        | <NewZipCode>      |
      | Is Multi County | <isMultutiCounty> |
      | County Name     | <county>          |
    And the user views the plans of the below plan type
      | Plan Type | <newplantype> |
    And the user clicks on drug dropdown on plan summary page and navigates to DCE
      | Plan Type | <newplantype> |
      | Plan Name | <newplanname> |
    Then the user validates correct Copay section view and LIS message for LIS Buydown Plan on DCE details Page
    Then the user validates Monthly Costs are not displayed for LIS Buydown plan on DCE details Page
    Then the user validates zero costs for following Covered generic drug for LIS Buydown on DCE details Page
      | CoveredDrug | <drug4> |
    Then the user validates zero costs for following Covered generic drug for LIS Buydown on DCE details Page
      | CoveredDrug | <genericDrug1> |
    Then the user validates zero costs for following Covered generic drug for LIS Buydown on DCE details Page
      | CoveredDrug | <genericDrug2> |
    Then the user validates non zero costs for Not covered Drugs for LIS Buydown on DCE details Page
      | NotCoveredDrug | <drug2> |
    Then the user validates non zero costs for Not covered Drugs for LIS Buydown on DCE details Page
      | NotCoveredDrug | <drug3> |
    Then the user validates non zero costs for Not covered Drugs for LIS Buydown on DCE details Page
      | NotCoveredDrug | <drug7> |
    Then the user validates non zero costs for Not covered Drugs for LIS Buydown on DCE details Page
      | NotCoveredDrug | <drug6> |
    And the user validates link to Drug Summary Page
    And user should verify the Extra help on SNP plan type
    And user click on View Drug Pricing Modal
    And user should verify the drug extra qualification in drug pricing popup
    Then the user validates the LIS Banner for the below LIS Buydown plan on Drug Summary Page
      | Plan Name | <newplanname> |
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <plantype>       |
      | Plan Name | <updateplanname> |
    Then the user clicks Edit Drug on Drug Details Page and validates user navigates to Build your drug list Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <insulinDrug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <insulinDrug2> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user validates Insulin savings on Copay section, Your Drugs and Important Information Section
      | InsulinCopay | <insulinCopay> |
      | Insulin Drug | <insulinDrug1> |
    Then the user validates Insulin savings on Copay section, Your Drugs and Important Information Section
      | InsulinCopay | <insulinCopay> |
      | Insulin Drug | <insulinDrug2> |
    Then user save the plan on drug detail page
    When the user navigate to Visitor profile page
    And user validates the plans on new visitor profile page of AARP site
      | Test Plans | <updateplanname> |
    Then the user clicks on Drug cost estimator link and validates Drug Details Page
    Then the user clicks on site logo on drug detail Page and returns back to Acquisition Home Page
      | Site | <site> |

    @DCE_E2E_Scenario6_UAT_AARP @regressionAARP
    Examples: 
      | Scenario            | site | path                                                                               | plantype | planname                                         | drug1   | drug2     | drug3    | drug4  | drug5 | drug6      | drug7           | brandDrug1 | genericDrug1         | brandDrug2 | genericDrug2 | premium | NewZipCode | newplantype | newplanname                                       | isMultutiCounty | county            | updateplanname                       | insulinDrug1   | insulinDrug2                                    | insulinCopay |
      | E2E Scenario 6_AARP | AARP | health-plans.html?zipcode=90210&WT.mc_id=8000158&county=200&state=06#/plan-summary | MAPD     | UnitedHealthcare Medicare Advantage Assure (HMO) | Lipitor | Ibuprofen | Nicomide | Fanapt | Xanax | Alprazolam | Methylphenidate | Lipitor    | atorvastatin calcium | Xanax      | alprazolam   | $0 - $  |      33111 | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | NO              | Miami-Dade County | AARP Medicare Advantage Choice (PPO) | insulin lispro | insulin lispro protamine/insulin lispro kwikpen | $35          |

    @DCE_E2E_Scenario6_UAT_UHC @regressionUHC
    Examples: 
      | Scenario           | site | path                                                                               | plantype | planname                                         | drug1   | drug2     | drug3    | drug4  | drug5 | drug6      | drug7           | brandDrug1 | genericDrug1         | brandDrug2 | genericDrug2 | premium | NewZipCode | newplantype | newplanname                                       | isMultutiCounty | county            | updateplanname                       | insulinDrug1   | insulinDrug2                                    | insulinCopay |
      | E2E Scenario 6_UMS | UHC  | health-plans.html?zipcode=90210&WT.mc_id=8000158&county=200&state=06#/plan-summary | MAPD     | UnitedHealthcare Medicare Advantage Assure (HMO) | Lipitor | Ibuprofen | Nicomide | Fanapt | Xanax | Alprazolam | Methylphenidate | Lipitor    | atorvastatin calcium | Xanax      | alprazolam   | $0 - $  |      33111 | SNP         | UnitedHealthcare Dual Complete Choice (PPO D-SNP) | NO              | Miami-Dade County | AARP Medicare Advantage Choice (PPO) | insulin lispro | insulin lispro protamine/insulin lispro kwikpen | $35          |

  @DCE_E2E_Scenario1_UAT
  Scenario Outline: <Scenario> : To verify that user navigates VPP Compare to DCE Add drug, then Drugin modal to DCE details, verify the drug costs and enroll in plan
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And I select "<plantype>" plans to compare and click on compare plan link
    And I access the DCE Redesign from Plan compare page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug4> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug5> |
    Then the user edits supply length to three months for following drug
      | EditDrug | <drug3> |
    Then the user validates all added drugs in DrugList
    Then the user clicks on return to compare link on build drug list page to returns to plan compare
    Then the user validates all added Drugs on Plan Compare
    Then the user clicks on View Drug Information link for the following Plan and lands on DCE details
      | PlanName | <planname> |
    Then the user validates planName matches plan Name in VPP
    Then the user Validates Drug you pay on DCE details page to Compare page Drug Info Modal
    Then the user Captures Drug costs on Drug Details Page
    And the user clicks Edit Drug on Drug Details Page and validates user navigates to Build your drug list Page
    Then the user deletes the following drug from Drug list
      | DrugName | <drug4> |
    And the user clicks on Edit button on Drug List page on DCE
      | DrugName | <drug2> |
    And the user changes the supply length
      | Supply Length | <supplyLength> |
    Then the user clicks on Review Drug Costs to Land on Drug Details Page
    Then the user validates Switch to generic for following Brand Drug and validate Generic drug on Details Page
      | Brand Drug   | <brandDrug1>   |
      | Generic Drug | <genericDrug1> |
    Then the user validates Drug Costs section
    Then the user validates Your Drugs sections
    Then the user validates Monthly Drug Costs by Stage Section
    Then the user validates Monthly Drug Costs by Stage Info Modals
    Then the user validates Monthly Drug Costs
    Then the user validates Important information section
    Then the user Captures Drug costs on Drug Details Page
    Then the user clicks on Back to Compare link and validates Plan Compare page, Drug Info Modal
    Then the user closes the Drug Info Modal on Plan Compare page
    Then the user validates Estimated Drug Cost for the following plan to DCE details page estimated Drug Costs
      | PlanName | <planname> |
    Then the user validates all added Drugs on Plan Compare
    Then the user clicks on back on all plan linnk in Plan Compare page
    Then the user clicks on Enroll Now for AARP site to start the OLE flow
      | Plan Name | <planname> |
    Then the user validates the Plan details on OLE
    Then the user validates TFN in Welcome OLE Right Rail
    Then the user validates Learn more modal for Welcome OLE
    Then the user validates Leave OLE modal for Welcome OLE
    Then the user validates cancellation modal for Welcome OLE
    Then the user navigates to Personal Information Page
    And the user cancels enrollment and navigates to homepage

    @DCE_E2E_Scenario1_UAT_AARP @regressionAARP
    Examples: 
      | Scenario           | site | zipcode | county          | isMultutiCounty | plantype | drug1   | drug2     | drug3    | drug4          | drug5  | planname                        | supplyLength   | brandDrug1 | genericDrug1         |
      | E2E Scenario 1_AMP | AARP |   85001 | Maricopa County | NO              | PDP      | Lipitor | Ibuprofen | Nicomide | insulin lispro | Fanapt | AARP MedicareRx Walgreens (PDP) | Every 3 Months | Lipitor    | atorvastatin calcium |

    @DCE_E2E_Scenario1_UAT_UHC @regressionUHC
    Examples: 
      | Scenario           | site | zipcode | county          | isMultutiCounty | plantype | drug1   | drug2     | drug3    | drug4          | drug5  | planname                        | supplyLength   | brandDrug1 | genericDrug1         |
      | E2E Scenario 1_UMS | UHC  |   85001 | Maricopa County | NO              | PDP      | Lipitor | Ibuprofen | Nicomide | insulin lispro | Fanapt | AARP MedicareRx Walgreens (PDP) | Every 3 Months | Lipitor    | atorvastatin calcium |

  @DCE_E2E_Scenario3_UAT
  Scenario Outline: <Scenario> : Verify that user get started from home page and can search for a plan, verify the drug summary page  and change pharmacy on drug summary and navigate back to vpp plan details page
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
    When user enter invalid zipcode
      | inValidzipCode | <invalidzipcode2> |
    Then error message should be displayed
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then the user validates OptumRx consistently displays on DCE Summary - Pharmacy Page
    When user clicks on change pharmacy link from summary page
    Then the user selects Mail Pharmacy and returns to DCE Summary page
    When user clicks on change pharmacy link from summary page
    Then the user validates distance dropdown and Zipcode change on Summary page - Change Pharmacy Page
      | PharmacyZipCode | <pharmacyZipCode> |
    Then the user validates distance dropdown and Zipcode change on Summary page - Change Pharmacy Page
      | PharmacyZipCode | <pharmacyZipCode2> |
    When user clicks on Keep Using This Pharmacy link on change pharmacy modal
    When user verify the drug summary page
    And user should be able to see Medicare Advantage plan by default
    And user click on View Drug Pricing Modal
    Then the user validates Switch to generic for following Brand Drug to Generic from Drug Summary - Drug Pricing Modal
      | Brand Drug   | <drug4>        |
      | Generic Drug | <genericDrug1> |
    #And user click on PDP plan to view drug pricing
    And the user Captures Drug costs on Drug Summary Page for the given plan
      | Plan Name | <planName> |
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user Captures Drug costs on Drug Details Page
    And the user compares drug costs for drug details and drug summary pages
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    And verify the default tab displayed on VPP details page
      | TabName | <tabName> |
    Then the user verify the drug cost estimator and view plan summary on VPP detail page in AARP
    #Then the user validates Estimated Annual Drug Costs on Prescription Drug Costs Tab on Plan Details Page
    Then the user click on drug cost estimator on vpp plan detail page in AARP
    Then the user validates link to Drug Summary Page
    When user clicks on change pharmacy link from summary page
    Then change pharmacy modal should be displayed
    And user verify change pharmacy modal
    Then the message "OptumRx Home Delivery only provides 90-day refill for your drugs." should be displayed on change pharmacy modal
    And user verify the default distance on change pharmacy modal
    When user sort the pharmacy list by "A to Z"
    Then pharmacy list should be displayed in ascending order
    When user sort the pharmacy list by "Z to A"
    Then pharmacy list should be displayed in descending order
    When user clicks on next button on change pharmacy modal
    Then user should be navigated to second page of pharmacy list
    When user clicks on back button on change pharmacy modal
    Then user should be navigated to first page of pharmacy list
    When user search with incorrect zipcode
      | ZipCode | <zipCode2> |
    Then error message "Please enter a valid ZIP code." should be displayed on change pharmacy modal
    When user search with correct zipcode
      | ZipCode | <zipCode3> |
    When user saves and updates pharmacy from list
    Then the pharmacy name should be updated on summary page
    When user clicks on change pharmacy link from summary page
    When user clicks on Keep Using This Pharmacy link on change pharmacy modal
    When user clicks on change pharmacy link from summary page
    When user selects Preferred mail order pharmacy
    Then the message "OptumRx Home Delivery only provides 90-day refill for your drugs." should be displayed on change pharmacy modal
    And user verify the default distance on change pharmacy modal
    Then the user selects Mail Pharmacy and returns to DCE Summary page
    When user clicks on change pharmacy link from summary page
    When user search with zipcode with no pharamacies
      | ZipCode | <zipCode4> |
    Then no results message should be displayed
      | NoResultsMessage | <message> |
    Then user clicks on Keep Using This Pharmacy link on change pharmacy modal
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType2> |
      | Plan Name | <planName2> |
    And user clicks on change pharmacy link from details page
    Then the user selects following Standard pharmacy and returns to DCE Details page
      | SelectStandardPharmacy | <SelectStandardPharmacy> |
    Then the user Captures Drug costs on Drug Details Page
    And the user validates link to Drug Summary Page
    When user verify the drug summary page
    And the user Captures Drug costs on Drug Summary Page for the given plan
      | Plan Name | <planName2> |
    And the user compares drug costs for drug details and drug summary pages
    And user click on return to home on drug summary in AARP site

    @DCE_E2E_Scenario3_UAT_AARP @regressionAARP
    Examples: 
      | Scenario           | site | zipCode | county          | invalidzipcode2 | isMultutiCounty | pharmacyZipCode | pharmacyZipCode2 | SelectPharmacy                  | SelectStandardPharmacy | planType | drug1   | drug2   | drug3 | drug4   | planName                                 | planType2 | planName2                       | zipCode2 | zipCode3 | zipCode4 | brandDrug1 | genericDrug1         | message                                                                                                                                            | tabName                       |
      | E2E Scenario 3_AMP | AARP |   55344 | Hennepin County |           00000 | NO              |           99619 |            55344 | Preferred Mail Service Pharmacy | CVS PHARMACY           | MAPD     | Orfadin | Humalog | Emsam | Lipitor | AARP Medicare Advantage Headwaters (PPO) | PDP       | AARP MedicareRx Walgreens (PDP) |    78456 |    12345 |    96799 | Lipitor    | atorvastatin calcium | Broadening your search criteria (for example, changing the pharmacy type, search radius and/or your ZIP code) may help you get a different result. | Medical Benefits and Programs |

    @DCE_E2E_Scenario3_UAT_UHC @regressionUHC
    Examples: 
      | Scenario           | site | zipCode | county          | invalidzipcode2 | isMultutiCounty | pharmacyZipCode | pharmacyZipCode2 | SelectPharmacy                  | SelectStandardPharmacy | planType | drug1   | drug2   | drug3 | drug4   | planName                                 | planType2 | planName2                       | zipCode2 | zipCode3 | zipCode4 | brandDrug1 | genericDrug1         | message                                                                                                                                            | tabName                       |
      | E2E Scenario 3_UMS | UHC  |   55344 | Hennepin County |           00000 | NO              |           99619 |            55344 | Preferred Mail Service Pharmacy | CVS PHARMACY           | MAPD     | Orfadin | Humalog | Emsam | Lipitor | AARP Medicare Advantage Headwaters (PPO) | PDP       | AARP MedicareRx Walgreens (PDP) |    78456 |    12345 |    96799 | Lipitor    | atorvastatin calcium | Broadening your search criteria (for example, changing the pharmacy type, search radius and/or your ZIP code) may help you get a different result. | Medical Benefits and Programs |
