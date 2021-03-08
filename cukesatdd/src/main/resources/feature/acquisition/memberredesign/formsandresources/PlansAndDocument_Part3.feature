 @PlansAndDocument_Part3 @PlansAndDocuments @VelocityDasher @regressionMember
Feature: 1.06.3 Member Plans and Documents Page Part 3

						# This feature File consist of Scenario 9 to 14.
						
   @PlansAndDocument9 @fnrmapdaarpindividualvalidation  @PD_Part3_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page MAPD AARP Individual
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
      | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
      | Member Type | <memberType> |
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And validate that english is default language in the dropdown
      | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    And then user verifies that the correct pdfs are coming in the plan material section
      | Getting Started Guide               | <gettingstartedguide>            |
      | Benefit Highlights                  | <benefithighlight>               |
      | Summary of Benefits                 | <summaryofbenefits>              |
      | Evidence of Coverage                | <evidenceofcoverage>             |
      | Certificate of Coverage             | <certificateofcoverage>          |
      | Formulary/Drug List - Comprehensive | <FormularyDrugListComprehensive> |
      | Additional Drug Coverage            | <additionaldrugcoverage>         |
      | Doctor Flyer                        | <doctorflyer>                    |
      | Prior Authorization Criteria        | <priorauth>                      |
      | Step Therapy Criteria               | <steptherapy>                    |
      | Formulary Additions                 | <formularyadd>                   |
      | Formulary Deletions                 | <formularydel>                   ||
    Then validate that the AnocSection is displayed for MAPD
    Then validate that annual directory section is displayed
      | Member Type | <memberType> |
    And both Pharmacy and provider search links are displayed
      | PlanType | <planType> |
    Then validate that My Document section is displayed
    And both the drug and medical EOB links are displayed
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for MAPD
    And the user verifies that the correct pdfs are coming in the anoc section
      | Member Type              | <memberType>                 |
      | Annual Notice of Changes | <anoc>                       |
      | Evidence Of Coverage     | <evidenceofcoverageanoc>     |
      | Certificate of Coverage  | <certificateofcoverageanoc>  |
      | Comprehensive Formulary  | <comprehensiveformularyanoc> |
      | Additional Drug Coverage | <additionaldrugcoverageanoc> |

    Examples: 
      | TID   | planType            | memberType         | language | gettingstartedguide   | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | certificateofcoverage   | FormularyDrugListComprehensive      | additionaldrugcoverage   | doctorflyer  | priorauth           | steptherapy  | formularyadd        | formularydel        | anoc                     | evidenceofcoverageanoc | certificateofcoverageanoc | comprehensiveformularyanoc | additionaldrugcoverageanoc | unitedhealthpassportprogram   | alternativedruglist   | providerdirectory  | vendorInformationsheet   | pharmacydirectoryinformation   |
      | 15108 | MAPD_FormsResources | IndAARPPharmacyFnR | ENGLISH  | Getting Started Guide | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Certificate of Coverage | Formulary/Drug List - Comprehensive | Additional Drug Coverage | Doctor Flyer | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Annual Notice of Changes | Evidence of Coverage   | Certificate of Coverage   | Comprehensive Formulary    | Additional Drug Coverage   | UnitedHealth Passport Program | Alternative Drug List | Provider Directory | Vendor Information Sheet | Pharmacy Directory Information |

  @PlansAndDocument10 @fnrpdpuhcindividual @PD_Part3_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page PDP UHC Individual
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
      | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
      | Member Type | <memberType> |
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And validate that english is default language in the dropdown
      | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    And then user verifies that the correct pdfs are coming in the plan material section
      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT      | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
      | Alternative Drug List   | <alternativedruglist>    |
      | PRIOR AUTHORIZATION     | <priorauth>              |
      | STEP THERAPY            | <steptherapy>            |
      | FORMULARY ADDITIONS     | <formularyadd>           |
      | FORMULARY DELETIONS     | <formularydel>           |
    Then the member validate the correct Membership Materials section is coming
      | GETTING STARTED GUIDE   | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
      | Alternative Drug List   | <alternativedruglist>    |
      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
    Then validate that the anoc section is not displayed
    Then validate that annual directory section is displayed
      | Member Type | <memberType> |
    And the Pharmacy locator link is displayed
      | Member Type | <memberType> |
    And the provider search link is not displayed for PDP
    Then validate that My Document section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for PDP UHC
    And the user verifies that the correct pdfs are coming in the anoc section
      | Member Type                 | <memberType>                 |
      | ANNUAL NOTICE OF CHANGES    | <anoc>                       |
      | EVIDENCE OF COVERAGEANOC    | <evidenceofcoverageanoc>     |
      | COMPREHENSIVE FORMULARYANOC | <comprehensiveformularyanoc> |
    Then validate pdf's in annual directory section
      | Member Type                    | <memberType>                   |
      | Pharmacy Directory Information | <pharmacydirectoryinformation> |

    Examples: 
      | TID   | planType           | memberType          | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        | anoc                     | evidenceofcoverageanoc | comprehensiveformularyanoc | alternativedruglist   | gettingstartedguide   | pharmacydirectoryinformation   |
      | 15127 | PDP_FormsResources | PdpuhcindividualFnR | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Annual Notice of Changes | Evidence Of Coverage   | Comprehensive Formulary    | Alternative Drug List | Getting Started Guide | Pharmacy Directory Information |

  @PlansAndDocument11 @fnrmapdgroupvalidation @PD_Part3_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page MAPD group
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
      | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
      | Member Type | <memberType> |
    And validate that english is default language in the dropdown
      | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language                          | <language>               |
    Then validate that the anoc section is displayed for group
    Then validate that annual directory section is displayed
      | Member Type | <memberType> |
    Then validate that My Document section is displayed
    And the medical EOB link is displayed for MADP Group
    And the Drug EOB link is displayed for MAPD Group
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for uhc grp
    And the user verifies that the correct pdfs are coming in the anoc section
      | Member Type                  | <memberType>                |
      | ANNUAL NOTICE OF CHANGES     | <anoc>                      |
      | EVIDENCE OF COVERAGEANOC     | <evidenceofcoverageanoc>    |
      | CERTIFICATE OF COVERAGE      | <certificateofcoverage>     |
      | COMPREHENSIVE FORMULARY      | <comprehensiveformularymem> |
      | ADDITIONAL DRUG COVERAGEANOC | <additionaldruganoc>        |
    And the provider search link is displayed
      | Member Type | <memberType> |
    And the Pharmacy locator link is displayed for MAPD Group
      | Member Type | <memberType> |

    Examples: 
      | TID   | planType            | memberType           | language | gettingstartedguide   | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | certificateofcoverage   | abridgedformulary   | comprehensiveformulary              | additionaldrug           | priorauth           | steptherapy  | formularyadd        | formularydel        | certificateofcoverage   | anoc                     | evidenceofcoverageanoc | comprehensiveformularymem | additionaldruganoc       | evidenceofcoveragemem |
      | 15303 | MAPD_FormsResources | GroupMAPDPharmacyFnR | ENGLISH  | Getting Started Guide | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Certificate of Coverage | Formulary/Drug List | Formulary/Drug List - Comprehensive | Additional Drug Coverage | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Certificate of Coverage | Annual Notice of Changes | Evidence of Coverage   | Comprehensive Formulary   | Additional Drug Coverage | Evidence Of Coverage  |


  @PlansAndDocument12 @fnrpdpaarpindividualvalidation @PD_Part3_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page PDP AARP Individual
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    #And validates that PEEHIP logo is not displayed
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
      | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
      | Member Type | <memberType> |
    And validate that english is default language in the dropdown
      | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    # Then the member validate the correct Welcome Guide section is coming
    # | BENEFIT-HIGHLIGHT        | <benefithighlight>       |
    #  | COMPREHENSIVE FORMULARY  | <comprehensiveformulary> |
    # | ADDITIONAL DRUG COVERAGE | <additionaldrugcoverage> |
    #  | EVIDENCE OF COVERAGE     | <evidenceofcoverage>     |
    Then validate that the AnocSection is displayed
    Then validate that annual directory section is displayed
      | Member Type | <memberType> |
    And the Pharmacy locator link is displayed
      | Member Type | <memberType> |
    And the provider search link is not displayed for PDP
    Then validate that My Document section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for PDP
    And then user verifies that the correct pdfs are coming in the plan material section
      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT      | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
      | Alternative Drug List   | <alternativedruglist>    |
      | PRIOR AUTHORIZATION     | <priorauth>              |
      | STEP THERAPY            | <steptherapy>            |
      | FORMULARY ADDITIONS     | <formularyadd>           |
      | FORMULARY DELETIONS     | <formularydel>           |
    And the user verifies that the correct pdfs are coming in the anoc section
      | Member Type                 | <memberType>                 |
      | ANNUAL NOTICE OF CHANGES    | <anoc>                       |
      | EVIDENCE OF COVERAGEANOC    | <evidenceofcoverageanoc>     |
      | COMPREHENSIVE FORMULARYANOC | <comprehensiveformularyanoc> |
    Then validate pdf's in annual directory section
      | Member Type                    | <memberType>                   |
      | Pharmacy Directory Information | <pharmacydirectoryinformation> |

    Examples: 
      | TID   | planType           | memberType | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        | anoc                     | evidenceofcoverageanoc | comprehensiveformularyanoc | alternativedruglist   | pharmacydirectoryinformation   |
      | 15126 | PDP_FormsResources | IndAARPFnR | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Annual Notice of Changes | Evidence Of Coverage   | Comprehensive Formulary    | Alternative Drug List | Pharmacy Directory Information |

  @PlansAndDocument13 @fnrpdptexasgroupvalidation @PD_Part3_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page PDP Texas group
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And validates the pdp texas logo
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
      | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
      | Member Type | <memberType> |
    And validate that english is default language in the dropdown
      | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    Then validate that the anoc section is displayed for group
    Then validate that annual directory section is displayed
      | Member Type | <memberType> |
    And the Pharmacy locator link is displayed texas
      | Member Type | <memberType> |
    And the provider search link is not displayed for PDP
    Then validate that My Document section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is not displayed
    And the user verifies that the correct pdfs are coming in the anoc section
      | Member Type                  | <memberType>                 |
      | ANNUAL NOTICE OF CHANGES     | <anoc>                       |
      | EVIDENCE OF COVERAGEANOC     | <evidenceofcoverageanoc>     |
      | COMPREHENSIVE FORMULARYANOC  | <comprehensiveformularyanoc> |
      | ADDITIONAL DRUG COVERAGEANOC | <additionaldruganoc>         |
    And then user verifies that the correct pdfs are coming in the plan material section
      #| GETTING STARTED GUIDE             | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT                 | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT                | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE              | <evidenceofcoverage>     |
      #| FORMULARY DRUG LIST ABRIDGED      | <abridgedformulary>      |
      | FORMULARY DRUG LIST COMPREHENSIVE | <comprehensiveformulary> |
      | ADDITIONAL DRUG COVERAGE          | <additionaldrug>         |
      | PRIOR AUTHORIZATION               | <priorauth>              |
      | STEP THERAPY                      | <steptherapy>            |
      | FORMULARY ADDITIONS               | <formularyadd>           |
      | FORMULARY DELETIONS               | <formularydel>           |

    Examples: 
      | TID   | planType           | memberType             | language | gettingstartedguide   | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | abridgedformulary   | comprehensiveformulary              | additionaldrug           | priorauth           | steptherapy  | formularyadd        | formularydel        | evidenceofcoverageanoc | comprehensiveformularyanoc | additionaldruganoc       | anoc                     |
      | 15373 | PDP_FormsResources | TexasRxPharmacyFnRPage | ENGLISH  | Getting Started Guide | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Formulary/Drug List | Formulary/Drug List - Comprehensive | Additional Drug Coverage | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Evidence of Coverage   | Comprehensive Formulary    | Additional Drug Coverage | Annual Notice of Changes |

  @PlansAndDocument14 @fnrpdpgroupvalidation @PD_Part3_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page PDP UHC group
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
      | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
      | Member Type | <memberType> |
    And validate that english is default language in the dropdown
      | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    And then user verifies that the correct pdfs are coming in the plan material section
      #| GETTING STARTED GUIDE             | <gettingstartedguide>    |
      | BENEFIT HIGHLIGHTS                  | <benefithighlight>       |
      | SUMMARY OF BENEFIT                  | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE                | <evidenceofcoverage>     |
      | CERTIFICATE 0F COVERAGE             | <certificateofcoverage>  |
      | Formulary/Drug List - Comprehensive | <comprehensiveformulary> |
      #| FORMULARY DRUG LIST ABRIDGED      | <abridgedformulary>      |
      | ADDITIONAL DRUG COVERAGE            | <additionaldrug>         |
      | PRIOR AUTHORIZATION CRITERIA        | <priorauth>              |
      | STEP THERAPY CRITERIA               | <steptherapy>            |
      | FORMULARY ADDITIONS                 | <formularyadd>           |
      | FORMULARY DELETIONS                 | <formularydel>           |
    Then validate that the anoc section is displayed for group
    And the user verifies that the correct pdfs are coming in the anoc section
      | Member Type              | <memberType>                 |
      | ANNUAL NOTICE OF CHANGES | <anoc>                       |
      | EVIDENCE OF COVERAGE     | <evidenceofcoverageanoc>     |
      | CERTIFICATE 0F COVERAGE  | <certificateofcoverage>      |
      | COMPREHENSIVE FORMULARY  | <comprehensiveformularyanoc> |
      | ADDITIONAL DRUG COVERAGE | <additionaldruganoc>         |
    Then validate that annual directory section is displayed
      | Member Type | <memberType> |
    Then validate that My Document section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is not displayed
    And the provider search link is not displayed for PDP
    And the Pharmacy locator link is displayed PDP UHC Group
      | Member Type | <memberType> |

    Examples: 
      | TID   | planType           | memberType  | language | gettingstartedguide   | benefithighlight   | evidenceofcoverage   | certificateofcoverage   | summaryofbenefits  | abridgedformulary   | comprehensiveformulary              | additionaldrug           | anoc                     | evidenceofcoverageanoc | comprehensiveformularyanoc | additionaldruganoc       | priorauth                    | steptherapy           | formularyadd        | formularydel        |
      | 15131 | PDP_FormsResources | UHCGroupFnR | ENGLISH  | Getting Started Guide | Benefit Highlights | Evidence of Coverage | Certificate of Coverage | Summary of Benefit | Formulary/Drug List | Formulary/Drug List - Comprehensive | Additional Drug Coverage | Annual Notice of Changes | Evidence of Coverage   | Comprehensive Formulary    | Additional Drug Coverage | Prior Authorization Criteria | Step Therapy Criteria | Formulary Additions | Formulary Deletions |
 
