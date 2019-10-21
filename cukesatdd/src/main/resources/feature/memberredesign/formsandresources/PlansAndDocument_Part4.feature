 @PlansAndDocument_Part4 @PlansAndDocuments @VelocityDasher @regressionMember
Feature: 1.06.4 Member Plans and Documents Page Part 4

						# This feature File consist of Scenario 15 to 20.
	
	  @PlansAndDocument15 @fnrmaindividualvalidation @PD_Part4_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page  MA AARP Individual
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
    Then validate that the AnocSection is displayed
    Then validate that annual directory section is displayed
      | Member Type | <memberType> |
    And the Provider Search link is displayed for MA
      | Member Type | <memberType> |
    Then validate that My Document section is displayed
    And the Drug EOB link is not displayed for MA
    And Medical EOB link is displayed for MA
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for MAPD
    And the Pharmacy locator link is not displayed for MA
    And the user verifies that the correct pdfs are coming in the anoc section
      | Member Type               | <memberType>             |
      | ANNUAL NOTICE OF CHANGES  | <anoc>                   |
      | EVIDENCE OF COVERAGE ANOC | <evidenceofcoverageanoc> |
    Then validate pdf's in annual directory section
      | Member Type              | <memberType>             |
      | ProviderDirectory        | <providerdirectory>      |
      | Vendor Information Sheet | <vendorInformationsheet> |

    Examples: 
      | TID   | planType          | memberType | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | unitedhealthpassportprogram   | anoc                     | evidenceofcoverageanoc | providerdirectory  | vendorInformationsheet   |
      | 15129 | MA_FormsResources | AARPIndFnR | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | UnitedHealth Passport Program | Annual Notice of Changes | Evidence Of Coverage   | Provider Directory | Vendor Information Sheet |

  @PlansAndDocument16 @fnralpeehipgroupvalidation @PD_Part4_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page alpeehip group
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
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    And then user verifies that the correct pdfs are coming in the plan material section
      # | GETTING STARTED GUIDE             | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT                 | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT                | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE              | <evidenceofcoverage>     |
      | CERTIFICATE OF COVERAGE           | <certificateofcoverage>  |
      | FORMULARY DRUG LIST ABRIDGED      | <abridgedformulary>      |
      | FORMULARY DRUG LIST COMPREHENSIVE | <comprehensiveformulary> |
      | ADDITIONAL DRUG COVERAGE          | <additionaldrug>         |
      # |  DOCTOR FLYER                     | <doctorflyer>            |
      # |PROVIDER DIRECTORY INSERT          | <providerdirectoryinsert>|
      | PRIOR AUTHORIZATION               | <priorauth>              |
      | STEP THERAPY                      | <steptherapy>            |
      | FORMULARY ADDITIONS               | <formularyadd>           |
      | FORMULARY DELETIONS               | <formularydel>           |
    Then validate that the anoc section is displayed for group
    Then validate that annual directory section is displayed
      | Member Type | <memberType> |
    And the user verifies that the correct pdfs are coming in the anoc section
      | Member Type                  | <memberType>                 |
      | ANNUAL NOTICE OF CHANGES     | <anoc>                       |
      | EVIDENCE OF COVERAGEANOC     | <evidenceofcoverageanoc>     |
      | CERTIFICATE OF COVERAGE      | <certificateofcoverage>      |
      | COMPREHENSIVE FORMULARY      | <comprehensiveformularyanoc> |
      | ADDITIONAL DRUG COVERAGEANOC | <additionaldrug>             |
    Then validate that My Document section is displayed
    And the medical EOB link is displayed for MADP Group
    And the Drug EOB link is displayed for MAPD Group
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for uhc grp
    And the provider search link is displayed
      | Member Type | <memberType> |
    And the Pharmacy locator link is displayed for ALPeehip
      | Member Type | <memberType> |

    Examples: 
      | TID   | planType                    | memberType       | language | gettingstartedguide   | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | certificateofcoverage   | abridgedformulary   | comprehensiveformulary              | additionaldrug           | doctorflyer  | providerdirectoryinsert   | priorauth           | steptherapy  | formularyadd        | formularydel        | evidenceofcoverageanoc | comprehensiveformularyanoc | additionaldrug           | anoc                     |
      | 15130 | MAPDALPeehip_FromsResources | GroupAlPeehipFnR | ENGLISH  | Getting Started Guide | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Certificate of Coverage | Formulary/Drug List | Formulary/Drug List - Comprehensive | Additional Drug Coverage | Doctor Flyer | Provider Directory Insert | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | Evidence of Coverage   | Comprehensive Formulary    | Additional Drug Coverage | Annual Notice of Changes |

  @PlansAndDocument17 @pcpfnrvalidation @PD_Part4_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for PCP
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
    Then validate that the anoc section is not displayed
    Then validate that annual directory section is displayed
      | Member Type | <memberType> |
    And both the Pharmacy locator & provider search links are displayed for PCP
    Then validate that My Document section is displayed
    Then validate that the EOB Section is displayed
    And both the drug and medical EOB links are displayed
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed
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
    Then validate pdf's in annual directory section
      | Member Type                    | <memberType>                   |
      | ProviderDirectory              | <providerdirectory>            |
      | Vendor Information Sheet       | <vendorInformationsheet>       |
      | Pharmacy Directory Information | <pharmacydirectoryinformation> |

    Examples: 
      | TID   | planType            | memberType | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | comprehensiveformulary  | priorauth           | steptherapy  | formularyadd        | formularydel        | type    | alternativedruglist   | providerdirectory  | vendorInformationsheet   | pharmacydirectoryinformation   |
      | 15128 | MAPD_FromsResources | PCP        | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | NON LIS | Alternative Drug List | Provider Directory | Vendor Information Sheet | Pharmacy Directory Information |

  @PlansAndDocument18 @ssupfnrvalidation @PD_Part4_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for ssupFnr
    Given login with following details in the member redesign portal
      | Type       | <type>       |
      | identifier | <Identifier> |
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
    Then validate that the anoc section is not displayed
    Then validate that the annual directories section is not displayed for ssupFnr
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My Document section is displayed
    Then validate that the EOB section and both the type of Eobs are not displayed
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is not displayed
    
    Examples: 
      | TID   | planType           | memberType | language | scheduleofbenefits   | certificateofcoverage   | yourplangettingstarted    | privacynotice  | cdinotice       | Identifier | type  |
      | 15304 | UHC_FromsResources | SSUPFnR    | ENGLISH  | Schedule of Benefits | Certificate of Coverage | Your Plan Getting Started | Privacy Notice | CDI Long Notice | SSUP_DCE   | Group |

  @PlansAndDocument19 @combovalidation @PD_Part4_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for combo members
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user is on the forms and resources page for first plan tab
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
      | Member Type | <memberType> |
    And the user scrolls till the end of the page to check the forms and resources section
    And the user changes the plan tab to view the forms and resources page for second plan
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
      | Member Type | <memberType> |
    And the user scrolls till the end of the page to check the forms and resources section

    Examples: 
      | TID   | planType             | memberType |
      | 15233 | Combo_FromsResources | ComboFnR   |

  @PlansAndDocument20 @terminatedmembervalidation @PD_Part4_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for Terminated Members
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And for terminated member order plan materials link is not displayed
    Then validate that the anoc section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My Document section is displayed
    Then validate that the renew magazine section is not displayed
    Then validate that the annual directories section is not displayed
    Then validate that the EOB Section is displayed

    Examples: 
      | TID   | planType          | memberType             |
      | 15129 | MA_FromsResources | IndAARPMATerminatedFnR |
	
			