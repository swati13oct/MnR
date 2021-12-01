@pharmacyLocator
Feature: 1.11.b ACQ-Pharmacy Locator Test Scripts

  Scenario Outline: TID: <TID> - To verify VPP details to Pharmacy page for Chinese, Spanish and English Language Pharmacy Directory Link
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    Given the user navigates to following medicare acquisition site page
      | PageName | <pageName> |
      | PagePath | <path>     |
    Then the user clicks on the following language Pharmacy Directory Link
      | Language | <language>             |
      | County   | <countyForPlanDetails> |
    #	Then the user validates following language Pharmacy page is displayed
    #		| Language | <language> |
    And the user validates header section content on site
    When the user enters following details for the pharmacy search
      | Zip Code | [blank]    |
      | Distance | <distance> |
    Then the user verify error messages in Pharmacy locator page
      | Language | <language> |
    When the user enters following details for the pharmacy search
      | Zip Code |       9999 |
      | Distance | <distance> |
    Then the user verify error messages in Pharmacy locator page
      | Language | <language> |
    And the user enters following details for the pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown list
      | Current Year Plan Name | <cy_planName> |
      | Current Year Plan Year | <cy_planYear> |
      | Next Year Plan Name    | <ny_planName> |
      | Next Year Plan Year    | <ny_planYear> |
    #Then the user validates the pharmacies available
    #  | Language | <language> |
    And the user validates map section contents
    And the user validate show on map link
    And the user validate more information content based on plan type
    And the user validate view search PDF link
    And the user validates Front Matter PDF link
    And the user validates pharmacy widgets
      | Has Preferred Retail Pharmacy network plan | <hasPrefRetailPharPlan> |
      | Has Walgreens plan                         | <hasWalgreensPlan>      |
      | Has Preferred Mail Service Pharmacy plan   | <hasPrefdMailServPlan>  |
    And the user selects Pharmacy Types to Filter
      | Pharmacy Type | <pharmacyType> |
      | Language      | <language>     |
    #    Then the user validates the Pharmacies available
    #      | Language | <language> |
    Then the user validate error message displayed when filter results in no match
    Then the user validates the question widget

    @Pharmacy_FromVPP_PharmacyDirectory_English_AARP @regressionAARP 
    Examples: 
      | TID                | site | language | countyForPlanDetails | path                                                                                                                                                                                                                                                                                                                          | pageName               | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | English - Pharmacy | AARP | English  | None                 | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2021&planId=H0543168000&planYear=2021&systemYear=2021&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2022 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |

    @Pharmacy_FromVPP_PharmacyDirectory_Chinese_AARP @regressionAARP
    Examples: 
      | TID                | site | language | countyForPlanDetails | path                                                                                                                                                                                                                                                                                                                          | pageName               | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | Chinese - Pharmacy | AARP | Chinese  | None                 | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2021&planId=H0543168000&planYear=2021&systemYear=2021&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2022 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |

    @Pharmacy_FromVPP_PharmacyDirectory_Spanish_AARP @regressionAARP
    Examples: 
      | TID                | site | language | countyForPlanDetails | path                                                                                                                                                                                                                                                                                                                          | pageName               | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | Spanish - Pharmacy | AARP | Spanish  | None                 | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2021&planId=H0543168000&planYear=2021&systemYear=2021&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2022 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |

    @Pharmacy_FromVPP_PharmacyDirectory_English_UHC @regressionUHC
    Examples: 
      | TID                | site | language | countyForPlanDetails | path                                                                                                                                                                                                                                                                                                                          | pageName               | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | English - Pharmacy | UHC  | English  | None                 | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2021&planId=H0543168000&planYear=2021&systemYear=2021&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2022 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |

    @Pharmacy_FromVPP_PharmacyDirectory_Chinese_UHC @regressionUHC
    Examples: 
      | TID                | site | language | countyForPlanDetails | path                                                                                                                                                                                                                                                                                                                          | pageName               | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | Chinese - Pharmacy | UHC  | Chinese  | None                 | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2021&planId=H0543168000&planYear=2021&systemYear=2021&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2022 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |

    @Pharmacy_FromVPP_PharmacyDirectory_Spanish_UHC @regressionUHC
    Examples: 
      | TID                | site | language | countyForPlanDetails | path                                                                                                                                                                                                                                                                                                                          | pageName               | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType  | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | Spanish - Pharmacy | UHC  | Spanish  | None                 | health-plans.html?zipcode=90210&deepLink=favPlansDeepLink&plantype=MA&year=2021&planId=H0543168000&planYear=2021&systemYear=2021&zipcode=90210&fipsCode=037&product=MAPD&yearDisclaimer=undefined&month=2&yearToggle=undefined&deepLink=plandetail&WT.mc_id=8016371&mrcid=em:Acq:MR%7cFederal%7cEGEM3011%7c::8016371!/details | VPP: Plan Details MAPD |   10980 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2022 | AARP MedicareRx Preferred (PDP) | E-Prescribing | True                  | False            | True                 |

  @Pharmacy_Locator_ITU_HI_LTC_Messaging
  Scenario Outline: <Scenario> : To verify language dropdown removal for pharmacy locator page on acquisition <site> site
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    And the user navigate to pharmacy search page from the navigation bar
    And the user validates header section content on site
    And the user enters following details for the pharmacy search
      | Zip Code    | <zipcode>    |
      | Distance    | <distance>   |
      | County Name | <countyName> |
    And the user chooses a plan from dropdown list
      | Current Year Plan Name | <cy_planName> |
    	| Current Year Plan Year | <cy_planYear> |
    	| Next Year Plan Name    | <ny_planName> |
    	| Next Year Plan Year    | <ny_planYear> |
    And the user selects Pharmacy Types to Filter
      | Pharmacy Type | <pharmacyType> |
      | Language      | English        |
    Then the user validate error message displayed when filter results in no match

    @Pharmacy_Locator_ITU_HI_LTC_Messaging_AARP @regressionAARP
    Examples: 
      | Scenario                   | site | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType   | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | Language Drop Down Removal | AARP |   14143 |       15 | None       | 2021        | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | Long-term care | True                  | False            | True                 |

    @Pharmacy_Locator_ITU_HI_LTC_Messaging_UHC @regressionUHC
    Examples: 
      | Scenario                   | site | zipcode | distance | countyName | cy_planYear | cy_planName                     | ny_planYear | ny_planName                     | pharmacyType   | hasPrefRetailPharPlan | hasWalgreensPlan | hasPrefdMailServPlan |
      | Language Drop Down Removal | UHC  |   14143 |       15 | None       |        2021 | AARP MedicareRx Preferred (PDP) |        2021 | AARP MedicareRx Preferred (PDP) | Long-term care | True                  | False            | True                 |
