@dashBoardFormsAndResources @gladiators
Feature: G1.1 To validate forms and resources page in dashboard site

  @fnrmapdaarpindividualvalidation
  Scenario Outline: 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And validate that english is default language in dropdown
    And the user verifies that the correct pdfs are coming in the plan material section
      | BENEFIT-HIGHLIGHT              | <benefithighlight>            |
      | SUMMARY-OF-BENEFIT             | <summaryofbenefits>           |
      | EVIDENCE OF COVERAGE           | <evidenceofcoverage>          |
      | UNITED HEALTH PASSPORT PROGRAM | <unitedhealthpassportprogram> |
      | COMPREHENSIVE FORMULARY        | <comprehensiveformulary>      |
      | PRIOR AUTHORIZATION            | <priorauth>                   |
      | STEP THERAPY                   | <steptherapy>                 |
      | FORMULARY ADDITIONS            | <formularyadd>                |
      | FORMULARY DELETIONS            | <formularydel>                |
    And the user changes the laguage in the language dropdown
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    Then validate that the anoc section is displayed
    Then validate that the annual directories section is displayed
    And the user verifies that the correct pdfs are coming in the anoc and annual directories section
    | ANNUAL NOTICE OF CHANGES       | <anoc>                        |
    | EVIDENCE OF COVERAGE           | <evidenceofcoverage>          |
    | COMPREHENSIVE FORMULARY        | <comprehensiveformulary>      |
    | PROVIDER DIRECTORY             | <providerdirectory>           |
    | PHARMACY DIRECTORY             | <pharmacydirectory>           |
    And both the Pharmacy locator and provider search links are displayed
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And both the Drug and Medical EOB links are displayed
    Then validate that the forms and resources section is displayed
    Then validate that the renew magazine section is displayed

    Examples: 
      | planType | memberType         | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | unitedhealthpassportprogram   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        |  anoc                    |providerdirectory  |pharmacy directory|
      | MAPD     | IndAARPPharmacyFnR | Benefit Highlights | Summary of Benefits | Evidence of Coverage | UnitedHealth Passport Program | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Annual Notice of changes |Provider Directory |Pharmacy Directory|

  @fnrmapdgroupvalidation
  Scenario Outline: 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    And validate that english is default language in dropdown
    #  And the user verifies that the correct pdfs are coming in the plan material section for MAPD group member
    #   | BENEFIT-HIGHLIGHT | <benefithighlight> |
    #  | SUMMARY-OF-BENEFIT |  <summaryofbenefits> |
    #  | EVIDENCE OF COVERAGE |  <evidenceofcoverage> |
    #  |  UNITED HEALTH PASSPORT PROGRAM | <unitedhealthpassportprogram>  |
    #  |  COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
    #   |  PRIOR AUTHORIZATION | <priorauth> |
    #   |   STEP THERAPY |  <steptherapy> |
    #  |  FORMULARY ADDITIONS| <formularyadd> |
    #   |   FORMULARY DELETIONS| <formularydel> |
    And the user changes the laguage in the language dropdown
    Then validate that the anoc section is displayed for group
    Then validate that the annual directories section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And both the Drug and Medical EOB links are displayed
    Then validate that the forms and resources section is displayed
    Then validate that the renew magazine section is displayed

    Examples: 
      | planType | memberType       | #    benefithighlight                | summaryofbenefits                   | evidenceofcoverage                         | unitedhealthpassportprogram                   | comprehensiveformulary                  | priorauth                          | steptherapy                  | formularyadd                        | formularydel                        |
      | MAPD     | GroupPharmacyFnR | # Benefit Highlights (PDF, 99.79 KB) | Summary of Benefits (PDF, 99.79 KB) | Evidence of Coverage (EOC) (PDF, 99.79 KB) | UnitedHealth Passport Program (PDF, 99.79 KB) | Comprehensive Formulary (PDF, 99.79 KB) | Prior Authorization (PDF, 1.61 MB) | Step Therapy (PDF, 53.78 KB) | Formulary Additions (PDF, 60.69 KB) | Formulary Deletions (PDF, 99.42 KB) |

  @fnrpdpindividualvalidation
  Scenario Outline: 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
    # And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    And validate that english is default language in dropdown
    And the user verifies that the correct pdfs are coming in the plan material section
      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT      | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
      | PRIOR AUTHORIZATION     | <priorauth>              |
      | STEP THERAPY            | <steptherapy>            |
      | FORMULARY ADDITIONS     | <formularyadd>           |
      | FORMULARY DELETIONS     | <formularydel>           |
    And the user changes the laguage in the language dropdown
    Then validate that the anoc section is displayed
    Then validate that the annual directories section is displayed
    And the Pharmacy locator link is displayed for PDP
    And the provider search link is not displayed for PDP
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms and resources section is displayed
    Then validate that the renew magazine section is displayed

    Examples: 
      | planType | memberType | benefithighlight   | summaryofbenefits   | evidenceofcoverage         | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        |
      | PDP      | IndAARPFnR | Benefit Highlights | Summary of Benefits | Evidence of Coverage       | Comprehensive Formulary  | Prior Authorization  | Step Therapy  | Formulary Additions  | Formulary Deletions  |

  @fnrpdptexasgroupvalidation
  Scenario Outline: 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    And validates the pdp texas logo
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
    # And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    And validate that english is default language in dropdown
    # And the user verifies that the correct pdfs are coming in the plan material section for MAPD group member
    #  | BENEFIT-HIGHLIGHT              | <benefithighlight>            |
    #  | SUMMARY-OF-BENEFIT             | <summaryofbenefits>           |
    # | EVIDENCE OF COVERAGE           | <evidenceofcoverage>           |
    #  | UNITED HEALTH PASSPORT PROGRAM | <unitedhealthpassportprogram> |
    #  | COMPREHENSIVE FORMULARY        | <comprehensiveformulary>      |
    #  | PRIOR AUTHORIZATION            | <priorauth>                   |
    #  | STEP THERAPY                   | <steptherapy>                 |
    #  | FORMULARY ADDITIONS            | <formularyadd>                |
    #  | FORMULARY DELETIONS            | <formularydel>                |
    And the user changes the laguage in the language dropdown
    Then validate that the anoc section is displayed for group
    Then validate that the annual directories section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms and resources section is displayed
    Then validate that the renew magazine section is not displayed

    Examples: 
      | planType | memberType         |# benefithighlight                   | summaryofbenefits                   | evidenceofcoverage                         | unitedhealthpassportprogram                   | comprehensiveformulary                  | priorauth                          | steptherapy                  | formularyadd                        | formularydel                        |
      | PDP     | TexasRxPharmacyFnR |# Benefit Highlights (PDF, 99.79 KB) | Summary of Benefits (PDF, 99.79 KB) | Evidence of Coverage (EOC) (PDF, 99.79 KB) | UnitedHealth Passport Program (PDF, 99.79 KB) | Comprehensive Formulary (PDF, 99.79 KB) | Prior Authorization (PDF, 1.61 MB) | Step Therapy (PDF, 53.78 KB) | Formulary Additions (PDF, 60.69 KB) | Formulary Deletions (PDF, 99.42 KB) |

 @fnrpdpgroupvalidation
  Scenario Outline: 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
    # And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    And validate that english is default language in dropdown
    # And the user verifies that the correct pdfs are coming in the plan material section for MAPD group member
    #  | BENEFIT-HIGHLIGHT              | <benefithighlight>            |
    #  | SUMMARY-OF-BENEFIT             | <summaryofbenefits>           |
    # | EVIDENCE OF COVERAGE           | <evidenceofcoverage>           |
    #  | UNITED HEALTH PASSPORT PROGRAM | <unitedhealthpassportprogram> |
    #  | COMPREHENSIVE FORMULARY        | <comprehensiveformulary>      |
    #  | PRIOR AUTHORIZATION            | <priorauth>                   |
    #  | STEP THERAPY                   | <steptherapy>                 |
    #  | FORMULARY ADDITIONS            | <formularyadd>                |
    #  | FORMULARY DELETIONS            | <formularydel>                |
    And the user changes the laguage in the language dropdown
    Then validate that the anoc section is displayed for group
    Then validate that the annual directories section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms and resources section is displayed
    Then validate that the renew magazine section is not displayed

    Examples: 
      | planType | memberType         |# benefithighlight                   | summaryofbenefits                   | evidenceofcoverage                         | unitedhealthpassportprogram                   | comprehensiveformulary                  | priorauth                          | steptherapy                  | formularyadd                        | formularydel                        |
      | PDP     | TexasRxPharmacyFnR |# Benefit Highlights (PDF, 99.79 KB) | Summary of Benefits (PDF, 99.79 KB) | Evidence of Coverage (EOC) (PDF, 99.79 KB) | UnitedHealth Passport Program (PDF, 99.79 KB) | Comprehensive Formulary (PDF, 99.79 KB) | Prior Authorization (PDF, 1.61 MB) | Step Therapy (PDF, 53.78 KB) | Formulary Additions (PDF, 60.69 KB) | Formulary Deletions (PDF, 99.42 KB) |

 
 @fnrmaindividualvalidation
  Scenario Outline: 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
    # And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    And validate that english is default language in dropdown
    # And the user verifies that the correct pdfs are coming in the plan material section for MAPD group member
    #  | BENEFIT-HIGHLIGHT              | <benefithighlight>            |
    #  | SUMMARY-OF-BENEFIT             | <summaryofbenefits>           |
    #  | EVIDENCE OF COVERAGE           | <evidenceofcoverage>          |
    #  | UNITED HEALTH PASSPORT PROGRAM | <unitedhealthpassportprogram> |
    #  | COMPREHENSIVE FORMULARY        | <comprehensiveformulary>      |
    #  | PRIOR AUTHORIZATION            | <priorauth>                   |
    #  | STEP THERAPY                   | <steptherapy>                 |
    #  | FORMULARY ADDITIONS            | <formularyadd>                |
    #  | FORMULARY DELETIONS            | <formularydel>                |
    And the user changes the laguage in the language dropdown
    Then validate that the anoc section is displayed for group
    Then validate that the annual directories section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms and resources section is displayed
    Then validate that the renew magazine section is not displayed

    Examples: 
      | planType | memberType         |# benefithighlight                   | summaryofbenefits                   | evidenceofcoverage                         | unitedhealthpassportprogram                   | comprehensiveformulary                  | priorauth                          | steptherapy                  | formularyadd                        | formularydel                        |
      | PDP     | TexasRxPharmacyFnR |# Benefit Highlights (PDF, 99.79 KB) | Summary of Benefits (PDF, 99.79 KB) | Evidence of Coverage (EOC) (PDF, 99.79 KB) | UnitedHealth Passport Program (PDF, 99.79 KB) | Comprehensive Formulary (PDF, 99.79 KB) | Prior Authorization (PDF, 1.61 MB) | Step Therapy (PDF, 53.78 KB) | Formulary Additions (PDF, 60.69 KB) | Formulary Deletions (PDF, 99.42 KB) |

   
   @fnrmapdalpeehipgroupvalidation
   Scenario Outline: 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
   # And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    And validate that english is default language in dropdown
    #  And the user verifies that the correct pdfs are coming in the plan material section
    # | GETTING-STARTED-GUIDE | <getstartedguide> |
    #   | BENEFIT-HIGHLIGHT | <benefithighlight> |
    #  | SUMMARY-OF-BENEFIT |  <summaryofbenefits> |
    #  | EVIDENCE OF COVERAGE |  <evidenceofcoverage> |
    #  |  RxSupplement Coverage | <rxsupcoverage>  |RxSupplement Certificate of Coverage (PDF, 99.79 KB)
    # |  ABRIDGED FORMULARY | <abridgedformulary>  |  Formulary/Drug List (Abridged) (PDF, 99.79 KB)
    #  |  COMPREHENSIVE FORMULARY | <comprehensiveformulary> |Formulary/Drug List - Comprehensive (PDF, 99.79 KB)
    #   |  PRIOR AUTHORIZATION | <priorauth> |  Additional Drug Coverage (PDF, 99.79 KB)
    #   |   STEP THERAPY |  <steptherapy> |Doctor Flyer (PDF, 99.79 KB)
    #  |  FORMULARY ADDITIONS| <formularyadd> |Provider Directory Insert (PDF, 99.79 KB)
    #   |   FORMULARY DELETIONS| <formularydel> |
    And the user changes the laguage in the language dropdown
    Then validate that the anoc section is displayed for group
    Then validate that the annual directories section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And both the Drug and Medical EOB links are displayed
    Then validate that the forms and resources section is displayed
    And validates that the Alpeehip doc is present
    Then validate that the renew magazine section is displayed

    Examples: 
      | planType | memberType       | #    benefithighlight                | summaryofbenefits                   | evidenceofcoverage                         | unitedhealthpassportprogram                   | comprehensiveformulary                  | priorauth                          | steptherapy                  | formularyadd                        | formularydel                        |
      | MAPDALPeehip     | GroupAlPeehipFnR | # Benefit Highlights (PDF, 99.79 KB) | Summary of Benefits (PDF, 99.79 KB) | Evidence of Coverage (EOC) (PDF, 99.79 KB) | UnitedHealth Passport Program (PDF, 99.79 KB) | Comprehensive Formulary (PDF, 99.79 KB) | Prior Authorization (PDF, 1.61 MB) | Step Therapy (PDF, 53.78 KB) | Formulary Additions (PDF, 60.69 KB) | Formulary Deletions (PDF, 99.42 KB) |
   

  @terminatedmembervalidation
  Scenario Outline: 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And for terminated member order plan materials link is not displayed
    Then validate that the annual directories section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    Then validate that the renew magazine section is not displayed

    Examples: 
      | planType | memberType      |
      # uhc
      | MA       | TerminatedGroup |

  @shipscenario
  Scenario Outline: 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate plan materials section
    And for active member both the links are displayed
    And validate that the EOB statemnets section is displayed
    And validate that the forms and resources section is displayed

    Examples: 
      | userId         | password   |
      # uhc
      | q1_ship_feb239 | Password@1 |
