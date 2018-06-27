@dashBoardFormsAndResources @gladiators @regression_06_06_18
Feature: G1.1 To validate forms and resources page in dashboard site

  @fnrmapdaarpindividualvalidation
  Scenario Outline: 
    Given login with following details logins in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    Then validate that the plan materials section is displayed
    And validate that english is default language in dropdown
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are coming in the plan material section
      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT      | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
      | PRIOR AUTHORIZATION     | <priorauth>              |
      | STEP THERAPY            | <steptherapy>            |
      | FORMULARY ADDITIONS     | <formularyadd>           |
      | FORMULARY DELETIONS     | <formularydel>           |
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    Then validate that the anoc section is displayed
    Then validate that the annual directories section is displayed
    And the user verifies that the correct pdfs are coming in the anoc and annual directories section
      #| ANNUAL NOTICE OF CHANGES    | <anoc>                       |
      | EVIDENCE OF COVERAGEANOC    | <evidenceofcoverageanoc>     |
      | COMPREHENSIVE FORMULARYANOC | <comprehensiveformularyanoc> |
    # | PROVIDER DIRECTORY       | <providerdirectory>      |
    # | PHARMACY DIRECTORY       | <pharmacydirectory>      |
    And both the Pharmacy locator and provider search links are displayed
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And both the Drug and Medical EOB links are displayed
    Then validate that the forms and resources section is displayed
    Then validate that the renew magazine section is displayed

    Examples: 
      | planType | memberType         | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        | anoc                     | evidenceofcoverageanoc | comprehensiveformularyanoc |
      | MAPD     | IndAARPPharmacyFnR | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Annual Notice of Changes | Evidence Of Coverage   | Comprehensive Formulary    |

  @fnrpdpuhcindividual
  Scenario Outline: 
    Given login with following details logins in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    Then validate that the plan materials section is displayed
    And validate that english is default language in dropdown
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are coming in the plan material section
      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT      | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
      | PRIOR AUTHORIZATION     | <priorauth>              |
      | STEP THERAPY            | <steptherapy>            |
      | FORMULARY ADDITIONS     | <formularyadd>           |
      | FORMULARY DELETIONS     | <formularydel>           |
    Then validate that the anoc section is not displayed
    Then validate that the annual directories section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms and resources section is displayed
    Then validate that the renew magazine section is displayed

    Examples: 
      | planType | memberType          | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        | anoc                     | evidenceofcoverageanoc | comprehensiveformularyanoc |
      | PDP      | PdpuhcindividualFnR | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Annual Notice of Changes | Evidence Of Coverage   | Comprehensive Formulary    |

  @fnrmapdgroupvalidation
  Scenario Outline: 
    Given login with following details logins in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    And validate that english is default language in dropdown
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are coming in the plan material section
      | GETTING STARTED GUIDE                | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT                    | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT                   | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE                 | <evidenceofcoverage>     |
      | RxSUPPLEMENT CERTIFICATE OF COVERAGE | <rxsupcoverage>          |
      | FORMULARY DRUG LIST ABRIDGED         | <abridgedformulary>      |
      | FORMULARY DRUG LIST COMPREHENSIVE    | <comprehensiveformulary> |
      | ADDITIONAL DRUG COVERAGE             | <additionaldrug>         |
      | PRIOR AUTHORIZATION                  | <priorauth>              |
      | STEP THERAPY                         | <steptherapy>            |
      | FORMULARY ADDITIONS                  | <formularyadd>           |
      | FORMULARY DELETIONS                  | <formularydel>           |
      | CERTIFICATE OF COVERAGE              | <certificateofcoverage>  |
    Then validate that the anoc section is displayed for group
    And the user verifies that the correct pdfs are coming in the anoc and annual directories section
      | ANNUAL NOTICE OF CHANGES                 | <anoc>                       |
      | EVIDENCE OF COVERAGEANOC                 | <evidenceofcoverageanoc>     |
      | COMPREHENSIVE FORMULARYANOC              | <comprehensiveformularyanoc> |
      | RxSUPPLEMENT CERTIFICATE OF COVERAGEANOC | <rxsupcoverageanoc>          |
      | ADDITIONAL DRUG COVERAGEANOC             | <additionaldruganoc>         |
    # | PROVIDER DIRECTORY       | <providerdirectory>      |
    Then validate that the annual directories section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And both the Drug and Medical EOB links are displayed
    Then validate that the forms and resources section is displayed
    Then validate that the renew magazine section is displayed

    Examples: 
      | planType | memberType       | language | gettingstartedguide   | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | rxsupcoverage                        | abridgedformulary   | comprehensiveformulary              | additionaldrug           | priorauth           | steptherapy  | formularyadd        | formularydel        | certificateofcoverage   | anoc                     | evidenceofcoverageanoc | comprehensiveformularyanoc | rxsupcoverageanoc                    | additionaldruganoc       |
      | MAPD     | GroupPharmacyFnR | ENGLISH  | Getting Started Guide | Benefit Highlights | Summary of Benefits | Evidence of Coverage | RxSupplement Certificate of Coverage | Formulary/Drug List | Formulary/Drug List - Comprehensive | Additional Drug Coverage | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Certificate of Coverage | Annual Notice of Changes | Evidence of Coverage   | Comprehensive Formulary    | RxSupplement Certificate of Coverage | Additional Drug Coverage |

  # |MAPD     | GroupPharmacyFnR  | SPANISH           |Beneficios Importantes |Resumen de Beneficios |Comprobante de Cobertura |Comprehensive Formulary-Spanish |
  @fnrpdpindividualvalidation
  Scenario Outline: 
    Given login with following details logins in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    And validate that english is default language in dropdown
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
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
    And the user verifies that the correct pdfs are coming in the anoc and annual directories section
      | ANNUAL NOTICE OF CHANGES    | <anoc>                       |
      | EVIDENCE OF COVERAGEANOC    | <evidenceofcoverageanoc>     |
      | COMPREHENSIVE FORMULARYANOC | <comprehensiveformularyanoc> |
    And the Pharmacy locator link is displayed for PDP
    And the provider search link is not displayed for PDP
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms and resources section is displayed
    Then validate that the renew magazine section is displayed

    Examples: 
      | planType | memberType | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        | anoc                     | evidenceofcoverageanoc | comprehensiveformularyanoc |
      | PDP      | IndAARPFnR | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Annual Notice of Changes | Evidence Of Coverage   | Comprehensive Formulary    |

  @fnrpdptexasgroupvalidation
  Scenario Outline: 
    Given login with following details logins in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    And validates the pdp texas logo
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    And validate that english is default language in dropdown
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are coming in the plan material section
      | GETTING STARTED GUIDE             | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT                 | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT                | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE              | <evidenceofcoverage>     |
      | FORMULARY DRUG LIST ABRIDGED      | <abridgedformulary>      |
      | FORMULARY DRUG LIST COMPREHENSIVE | <comprehensiveformulary> |
      | ADDITIONAL DRUG COVERAGE          | <additionaldrug>         |
      | PRIOR AUTHORIZATION               | <priorauth>              |
      | STEP THERAPY                      | <steptherapy>            |
      | FORMULARY ADDITIONS               | <formularyadd>           |
      | FORMULARY DELETIONS               | <formularydel>           |
    Then validate that the anoc section is displayed for group
    And the user verifies that the correct pdfs are coming in the anoc and annual directories section
      | EVIDENCE OF COVERAGEANOC    | <evidenceofcoverageanoc>     |
      | COMPREHENSIVE FORMULARYANOC | <comprehensiveformularyanoc> |
      | ADDITIONAL DRUG COVERAGE    | <additionaldrug>             |
    Then validate that the annual directories section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And the Drug EOB link is displayed for PDP
    And Medical EOB link is not displayed for PDP
    Then validate that the forms and resources section is displayed
    Then validate that the PDPTexas document is present
    Then validate that the renew magazine section is not displayed

    Examples: 
      Examples:

      | planType | memberType         | gettingstartedguide   | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | abridgedformulary   | comprehensiveformulary              | additionaldrug           | priorauth           | steptherapy  | formularyadd        | formularydel        | evidenceofcoverageanoc | comprehensiveformularyanoc | additionaldruganoc       |  |
      | PDP      | TexasRxPharmacyFnR | Getting Started Guide | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Formulary/Drug List | Formulary/Drug List - Comprehensive | Additional Drug Coverage | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Evidence of Coverage   | Comprehensive Formulary    | Additional Drug Coverage |  |

  @fnrpdpgroupvalidation
  Scenario Outline: 
    Given login with following details logins in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    And validate that english is default language in dropdown
    And the user verifies that the correct pdfs are coming in the plan material section
      | GETTING STARTED GUIDE             | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT                 | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT                | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE              | <evidenceofcoverage>     |
      | FORMULARY DRUG LIST ABRIDGED      | <abridgedformulary>      |
      | FORMULARY DRUG LIST COMPREHENSIVE | <comprehensiveformulary> |
      | ADDITIONAL DRUG COVERAGE          | <additionaldrug>         |
      | PRIOR AUTHORIZATION               | <priorauth>              |
      | STEP THERAPY                      | <steptherapy>            |
      | FORMULARY ADDITIONS               | <formularyadd>           |
      | FORMULARY DELETIONS               | <formularydel>           |
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
      | planType | memberType  | # benefithighlight                   | summaryofbenefits                   | evidenceofcoverage                         | unitedhealthpassportprogram                   | comprehensiveformulary                  | priorauth                          | steptherapy                  | formularyadd                        | formularydel                        |
      | PDP      | UHCGroupFnR | # Benefit Highlights (PDF, 99.79 KB) | Summary of Benefits (PDF, 99.79 KB) | Evidence of Coverage (EOC) (PDF, 99.79 KB) | UnitedHealth Passport Program (PDF, 99.79 KB) | Comprehensive Formulary (PDF, 99.79 KB) | Prior Authorization (PDF, 1.61 MB) | Step Therapy (PDF, 53.78 KB) | Formulary Additions (PDF, 60.69 KB) | Formulary Deletions (PDF, 99.42 KB) |

  @fnrmaindividualvalidation
  Scenario Outline: 
    Given login with following details logins in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    And validate that english is default language in dropdown
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are coming in the plan material section
      | BENEFIT-HIGHLIGHT              | <benefithighlight>            |
      | SUMMARY-OF-BENEFIT             | <summaryofbenefits>           |
      | EVIDENCE OF COVERAGE           | <evidenceofcoverage>          |
      | UNITED HEALTH PASSPORT PROGRAM | <unitedhealthpassportprogram> |
    Then validate that the anoc section is displayed
    Then validate that the annual directories section is displayed
    And the user verifies that the correct pdfs are coming in the anoc and annual directories section
      | ANNUAL NOTICE OF CHANGES  | <anoc>                   |
      | EVIDENCE OF COVERAGE ANOC | <evidenceofcoverageanoc> |
    And the Pharmacy locator link is not displayed for MA
    And the Provider Search link is displayed for MA
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And the Drug EOB link is not displayed for MA
    And Medical EOB link is displayed for MA
    Then validate that the forms and resources section is displayed
    Then validate that the renew magazine section is displayed

    Examples: 
      | planType | memberType | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage         | unitedhealthpassportprogram   | anoc                     | evidenceofcoverageanoc |
      | MA       | AARPIndFnR | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage (EOC) | UnitedHealth Passport Program | Annual Notice of Changes | Evidence Of Coverage   |

  @fnralpeehipgroupvalidation
  Scenario Outline: 
    Given login with following details logins in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    And validate that english is default language in dropdown
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are coming in the plan material section
      | GETTING-STARTED-GUIDE    | <getstartedguide>         |
      | BENEFIT-HIGHLIGHT        | <benefithighlight>        |
      | SUMMARY-OF-BENEFIT       | <summaryofbenefits>       |
      | EVIDENCE OF COVERAGE     | <evidenceofcoverage>      |
      | RxSupplement Coverage    | <rxsupcoverage>           |
      | ABRIDGED FORMULARY       | <abridgedformulary>       |
      | COMPREHENSIVE FORMULARY  | <comprehensiveformulary>  |
      | ADDITIONAL DRUG COVERAGE | <additionaldrugcoverage>  |
      | DOCTOR FLYER             | <doctorflyer>             |
      | PROVIDERDIRECTORYINSERT  | <providerdirectoryinsert> |
      | PRIOR AUTHORIZATION      | <priorauth>               |
      | STEP THERAPY             | <steptherapy>             |
      | FORMULARY ADDITIONS      | <formularyadd>            |
      | FORMULARY DELETIONS      | <formularydel>            |
    Then validate that the anoc section is displayed for group
    And the user verifies that the correct pdfs are coming in the anoc and annual directories section
      | EVIDENCE OF COVERAGEANOC                 | <evidenceofcoverageanoc>     |
      | COMPREHENSIVE FORMULARYANOC              | <comprehensiveformularyanoc> |
      | RxSUPPLEMENT CERTIFICATE OF COVERAGEANOC | <rxsupcoverageanoc>          |
      | ADDITIONAL DRUG COVERAGEANOC             | <additionaldruganoc>         |
    Then validate that the annual directories section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And both the Drug and Medical EOB links are displayed
    Then validate that the forms and resources section is displayed
    And validates that the Alpeehip doc is present
    Then validate that the renew magazine section is displayed

    Examples: 
      | planType     | memberType       | language | getstartedguide       | benefithighlight   | summaryofbenefits   | evidenceofcoverage         | rxsupcoverage                        | abridgedformulary              | comprehensiveformulary              | additionaldrug           | doctorflyer  | providerdirectoryinsert   | priorauth           | steptherapy  | formularyadd        | formularydel        | evidenceofcoverageanoc | comprehensiveformularyanoc | rxsupcoverageanoc                    | additionaldruganoc       |
      | MAPDALPeehip | GroupAlPeehipFnR | ENGLISH  | Getting Started Guide | Benefit Highlights | Summary of Benefits | Evidence of Coverage (EOC) | RxSupplement Certificate of Coverage | Formulary/Drug List (Abridged) | Formulary/Drug List - Comprehensive | Additional Drug Coverage | Doctor Flyer | Provider Directory Insert | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Evidence of Coverage   | Comprehensive Formulary    | RxSupplement Certificate of Coverage | Additional Drug Coverage |

  @pcpfnrvalidation
  Scenario Outline: 
    Given login with following details logins in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    And validate that english is default language in dropdown
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are coming in the plan material section
      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT      | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
      | PRIOR AUTHORIZATION     | <priorauth>              |
      | STEP THERAPY            | <steptherapy>            |
      | FORMULARY ADDITIONS     | <formularyadd>           |
      | FORMULARY DELETIONS     | <formularydel>           |
    Then validate that the anoc section is not displayed
    Then validate that the annual directories section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My document section is displayed
    Then validate that the EOB section is displayed
    And both the Drug and Medical EOB links are displayed
    Then validate that the forms and resources section is displayed
    Then validate that the renew magazine section is displayed

    Examples: 
      | planType | memberType | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        |
      | MAPD     | PCPFnR     | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions |

  # | MAPD     | PCPFnR | SPANISH | Benefit Highlights  | Summary of Benefits  | Evidence of Coverage  | Comprehensive Formulary  | Prior Authorization  | Step Therapy  | Formulary Additions  | Formulary Deletions  |
  @ssupfnrvalidation
  Scenario Outline: 
    Given login with following details logins in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    And validate that english is default language in dropdown
    Then validate that the anoc section is not displayed
    Then validate that the annual directories section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My document section is displayed
    Then validate that the EOB section and both the type of Eobs are not displayed
    Then validate that the forms and resources section is displayed
    Then validate that the renew magazine section is not displayed

    Examples: 
      | planType | memberType | # language | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        |
      | UHC      | SSUPFnR    | # ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions |

  #  | MAPD     | PCPFnR |  #SPANISH | Benefit Highlights  | Summary of Benefits  | Evidence of Coverage  | Comprehensive Formulary  | Prior Authorization  | Step Therapy  | Formulary Additions  | Formulary Deletions  |
  @combovalidation
  Scenario Outline: 
    Given login with following details logins in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    And user is on the forms and resources page for first plan tab
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And the user scrolls till the end of the page to check the My Document and forms and resources section
    And the user changes the plan tab to view the forms and resources page for second plan
    Then validate that the plan materials section is displayed
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And the user scrolls till the end of the page to check the My Document and forms and resources section

    Examples: 
      | planType | memberType |
      | Combo    | ComboFnR   |

  @terminatedmembervalidation
  Scenario Outline: 
    Given login with following details logins in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    Then validate that the plan materials section is displayed
    And for terminated member order plan materials link is not displayed
    Then validate that the anoc section is not displayed
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
    Given login with following details logins in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    Then validate that the plan materials section is displayed
    And validate that english is default language in dropdown
    Then the user verifies the error message for ship if particular pdf is not present
    Then validate that the forms and resources section is displayed
    Then verifies that Electronic Funds pdf for ship is displayed

    Examples: 
      | planType | memberType     |
      # uhc
      | SHIP     | IndPharmacyFnR |

  @memberauthfnrpagevalidation
  Scenario Outline: To validate the forms and resources page through Member auth.
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And User Clicks on the Pop up displayed
    And user clicks on the view document and resources link and navigate to forms and resource page from member auth page
    And for active member Temporary Id Card and Plan Order Material links are displayed
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validates the view temporary id card link
    Then validate that the plan materials section is displayed
    And validate that english is default language in dropdown
    Then the user verifies the error message for ship if particular pdf is not present
    Then validate that the forms and resources section is displayed
    Then verifies that Electronic Funds pdf for ship is displayed

    Examples: 
      | username  | password  | member          |
      | qavgogine | qavgogine | q2_jun_ship0001 |
