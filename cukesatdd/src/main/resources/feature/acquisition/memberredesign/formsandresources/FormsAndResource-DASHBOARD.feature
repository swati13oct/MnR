@formsAndResources @dashBoardFormsAndResources @gladiators
Feature: 1.06 Member Plans and Documents Page

		# Regression Runner devided into 2 runs with 2 runner, One runner with @Regression Member, next one with @Part2of2Regression, it devided the scenarios 17 each

	@smokeTest_FNR @FormsandResources 
   Scenario Outline: VBF- Forms and Resources
   Given login with following details logins in the member portal and validate elements
	  | Plan Type      | <planType>      |
	  | Member Type    | <memberType>    |
    And user clicks on the view document and resources link and navigate to forms and resource page
	  | Plan Type      | <planType>      |
	  | Member Type    | <memberType>    |
	Then validate that the plan material section is displayed
	  | Member Type | <memberType> |
	And validate that english is default language in the dropdown
	  | Member Type | <memberType> |
	And then user verifies that the correct pdfs are coming in the plan material section
      | Benefit Highlights            			 | <benefithighlight>       |
      | Summary of Benefits          			 | <summaryofbenefits>      |
      | Evidence of Coverage         			 | <evidenceofcoverage>     |
      | Comprehensive Formulary                  | <FormularyDrugListComprehensive> |
      | Alternative Drug List        		 |<additionaldrugcoverage>  |
      | Prior Authorization Criteria 			 | <priorauth>              |
      | Step Therapy Criteria         			 | <steptherapy>            |
      | Formulary Additions         		     | <formularyadd>           |
      | Formulary Deletions         		     | <formularydel>           |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed 
      | Member Type | <memberType> |
    And validate that the view temporary id card link is displayed
      | Member Type | <memberType> |
    Then validate that the AnocSection is displayed for MAPD
	Then validate that annual directory section is displayed
      | Member Type | <memberType> |
    And both Pharmacy and provider search links are displayed
      | Member Type | <memberType> |
    Then validate that My Document section is displayed
    Then validate that the EOB Section is displayed
    And both the drug and medical EOB links are displayed
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for MAPD
    
    Examples: 
         | planType  | memberType                | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | certificateofcoverage   |FormularyDrugListComprehensive     | additionaldrugcoverage | priorauth           | steptherapy  | formularyadd        | formularydel        |
         | MAPD      | Individual_FormsResources | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | Certificate of Coverage | Comprehensive Formulary           | Alternative Drug List  | Prior Authorization | Step Therapy | Formulary Additions | Formulary Deletions | 
	
		 
@formsAndResources @F&RJMPLinks @Feb_release_2019 @gladiators
 Scenario Outline:  TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -Rider: <rider>-To verify quicklinks for a MAPD member
   	Given login with following details logins in the member portal and validate elements
   	  | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | identifier     | <Identifier>    |
      | Rider          | <rider>         |
	And user clicks on the view document and resources link and navigate to forms and resource page
	| Plan Type   | <planType>   |
	| Member Type    | <memberType>    |
	Then user verifies presence of jump links on F&R page
      | Plan Type | <planType> |
      |Rider|<rider>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|

  # Regression Runner devided into 2 runs with 2 runner, One runner with @Regression Member, next one with @Part2of2Regression, it devided the scenarios 17 each
  @formsAndResources1 @F&RJMPLinks @Feb_release_2019 @gladiators @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -Rider: <rider>-To verify quicklinks for a MAPD member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
      | Rider       | <rider>      |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then user verifies presence of jump links on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |

    And user clicks on the jump links and checks respective sections on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And verifies links irrelevant to the plan type are not displayed on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | Count      | <count>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |

    #Membership material comes dynamically based on the logic
    # EOB Header xpath is not working Need to fix it
    Examples: 
      | TID   | planType | memberType                 | Identifier         | language | count | rider   |
      | 15108 | MAPD     | Individual_FormsResources  | IndEffectiveAARP   | ENGLISH  |     7 | NoRider |
      | 15108 | MAPD     | Individual_FormsResources  | IndEffectiveAARP   | ENGLISH  |     7 | Rider   |
      | 15303 | MAPD     | Group_FormsResources       | GrpEffectiveUHC    | ENGLISH  |     7 | NoRider |
      | 15108 | MAPD     | Individual_FormsResources  | IndEffectiveUHC    | ENGLISH  |     6 | NoRider |
      | 15108 | MAPD     | Individual_FormsResourcesl | IndEffectiveUHC    | ENGLISH  |     6 | Rider   |
      | 00000 | PCP      | Individual_FormsResources  | IndEffectivePCP    | ENGLISH  |     6 | NoRider |
      | 15128 | MEDICA   | Individual_FormsResourcesl | IndEffectiveMedica | ENGLISH  |     6 | NoRider |

  @formsAndResources2 @F&RJMPLinks @Feb_release_2019 @gladiators @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - Verify jump links for individual MA member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
      | Rider       | <rider>      |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then user verifies presence of jump links on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And user clicks on the jump links and checks respective sections on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And verifies links irrelevant to the plan type are not displayed on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | Count      | <count>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |

    Examples: 
      | TID   | planType | memberType                 | Identifier          | language | count | rider   |
      | 15130 | MA       | Group_FormsResources       | GrpEffectiveUHC     | ENGLISH  |     7 | NoRider |
      | 00000 | MA       | Individual_FormsResourcesl | IndEffectiveUHC     | ENGLISH  |     7 | Rider   |
      | 00001 | MA       | Individual_FormsResources  | IndEffectiveAARP    | ENGLISH  |     7 | Rider   |
      | 00002 | MA       | Individual_FormsResources  | IndEffectiveAARP_NR | ENGLISH  |     7 | NoRider |

  @formsAndResources3 @F&RJMPLinks @Feb_release_2019 @gladiators @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -Verify jump links for a MedSupp member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
      | Rider       | <rider>      |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then user verifies presence of jump links on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And user clicks on the jump links and checks respective sections on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And verifies links irrelevant to the plan type are not displayed on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | Count      | <count>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |

    Examples: 
      | TID   | planType | memberType                 | Identifier           | language | count | rider   |
      | 15304 | MedSupp  | Individual_FormsResourcesl | EffectiveShipMedSupp | ENGLISH  |     3 | NoRider |

  @formsAndResources4 @F&RJMPLinks @Feb_release_2019 @gladiators @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - Verify jump links for individual PDP member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
      | Rider       | <rider>      |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then user verifies presence of jump links on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And user clicks on the jump links and checks respective sections on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And verifies links irrelevant to the plan type are not displayed on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | Count      | <count>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |

    Examples: 
      | TID   | planType | memberType                | Identifier       | language | count | rider   |
      | 15126 | PDP      | Individual_FormsResources | EffectivePDPAARP | ENGLISH  |     8 | NoRider |
      # | 15127  | PDP      | Individual_FormsResources	    |EffectivePDPUHC  | ENGLISH  | 8   |NoRider|  # it was already hashtagged by Kamal
      | 15131 | PDP      | Group_FormsResources      | EffectivePDPUHC  | ENGLISH  |     7 | NoRider |

  @formsAndResources5 @F&RJMPLinks @Feb_release_2019 @gladiators @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - Verify jump links for a SSUP member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
      | Rider       | <rider>      |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then user verifies presence of jump links on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And user clicks on the jump links and checks respective sections on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And verifies links irrelevant to the plan type are not displayed on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | Count      | <count>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |

    Examples: 
      | TID   | planType | memberType           | Identifier       | language | count | rider   |
      | 15304 | SSUP     | Group_FormsResources | GrpEffectiveSSUP | ENGLISH  |     4 | NoRider |

  # Pre-Effective Federal Cases
  @formsAndResources6 @pre-effectivefnrmapdaarpindividualvalidation @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page MAPD AARP Individual Pre-Effective
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And validates that PEEHIP logo is not displayed
    And validates that plan material section is not displayed
    And validate that english is default language in the dropdown
      | Member Type | <memberType> |
    Then the member validate the correct Membership Materials section is coming
      | GETTING STARTED GUIDE   | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
      | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
      | Alternative Drug List   | <alternativedruglist>    |
      | EVIDENCE OF COVERAGEMEM | <evidenceofcoverage>     |
      | PASSPORT                | <passport>               |
      | OVER THE COUNTER        | <overthecounter>         |
    Then validate that annual directory section is displayed
      | Member Type | <memberType> |
    Then validate pdf's in annual directory section
      | Member Type                    | <memberType>                   |
      | ProviderDirectory              | <providerdirectory>            |
      | Vendor Information Sheet       | <vendorInformationsheet>       |
      | Pharmacy Directory Information | <pharmacydirectoryinformation> |
    Then validate that My Document section is displayed
    And both Pharmacy and provider search links are displayed
      | PlanType | <planType> |

    Examples: 
      | TID   | planType            | memberType              | language | gettingstartedguide   | benefithighlight   | comprehensiveformulary  | alternativedruglist   | evidenceofcoverage   | passport                      | overthecounter              | comprehensiveformularymem | providerdirectory  | vendorInformationsheet   | pharmacydirectoryinformation   |
      | 15108 | MAPD_FormsResources | IndAARPPre-EffectiveFnR | ENGLISH  | Getting Started Guide | Benefit Highlights | Comprehensive Formulary | Alternative Drug List | Evidence of Coverage | UnitedHealth Passport Program | OVER THE COUNTER ESSENTIALS | Comprehensive Formulary   | Provider Directory | Vendor Information Sheet | Pharmacy Directory Information |

  @formsAndResources7 @IndAARPMAPre-EffectiveFnR @regressionMember
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page MA AARP Individual Pre-Effective
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And validates that PEEHIP logo is not displayed
    And validates that plan material section is not displayed
    Then the member validate the correct Membership Materials section is coming
      | GETTING STARTED GUIDE       | <gettingstartedguide>       |
      | BENEFIT-HIGHLIGHT           | <benefithighlight>          |
      | EVIDENCE OF COVERAGEMEM     | <evidenceofcoverage>        |
      | PASSPORT                    | <passport>                  |
      | linkHEALTH PRODUCTS BENEFIT | <linkhealthproductsbenefit> |
    Then validate that annual directory section is displayed
      | Member Type | <memberType> |
    Then validate pdf's in annual directory section
      | Member Type              | <memberType>             |
      | ProviderDirectory        | <providerdirectory>      |
      | Vendor Information Sheet | <vendorInformationsheet> |
    Then validate that My Document section is displayed
    And the Pharmacy locator link is not displayed for MA
    And the Provider Search link is displayed for MA
      | Member Type | <memberType> |

    Examples: 
      | TID   | planType          | memberType                | language | gettingstartedguide   | benefithighlight   | evidenceofcoverage   | providerdirectory  | vendorInformationsheet   | passport                      | linkhealthproductsbenefit   |
      | 00000 | MA_FormsResources | IndAARPMAPre-EffectiveFnR | ENGLISH  | Getting Started Guide | Benefit Highlights | Evidence of Coverage | Provider Directory | Vendor Information Sheet | UnitedHealth Passport Program | linkHEALTH PRODUCTS BENEFIT |

  @formsAndResources8 @fnrpdpaarpindividualvalidationPre-Effective @Part2of2
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page PDP AARP Individual Pre-Effective
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And validates that PEEHIP logo is not displayed
    Then validate pdf's in the welcome guide section
      | Benefit Highlights                 | <benefithighlight>                |
      | Comprehensive Formulary            | <comprehensiveformulary>          |
      | Additional Drug Coverage           | <additionaldrugcoverage>          |
      | linkHOME SERVICE DELIVERY BROCHURE | <linkhomeservicedeliverybrochure> |
      | Certificate of Coverage            | <certificateofcoverage>           |
    And validate that english is default language in the dropdown
      | Member Type | <memberType> |
    And the user validates the language dropdown and selects new value in dropdown successfully
      | Language | <language> |
    Then validate that annual directory section is displayed
      | Member Type      | <memberType>      |
      #Then validate pdf's in annual directory section  (Annual Directory doesn't show for Pre-Effective member)
      | MemberType       | <memberType>      |
      | Pharmacy Locator | <pharmacylocator> |
    Then validate that My Document section is displayed
    And the provider search link is not displayed for PDP
    And the Pharmacy locator link is displayed
      | Member Type | <memberType> |

    Examples: 
      | TID   | planType           | memberType                 | language | benefithighlight   | comprehensiveformulary  | additionaldrugcoverage   | linkhomeservicedeliverybrochure    | certificateofcoverage   | pharmacylocator  |
      | 15126 | PDP_FormsResources | IndAARPPre-EffectivePDPFnR | ENGLISH  | Benefit Highlights | Comprehensive Formulary | Additional Drug Coverage | linkHOME SERVICE DELIVERY BROCHURE | Certificate of Coverage | Pharmacy Locator |

  #Effective Users
  @formsAndResources9 @fnrmapdaarpindividualvalidation @Part2of2
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page MAPD AARP Individual
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    # And validates that PEEHIP logo is not displayed
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
      | Formulary Deletions                 | <formularydel>                   |
    # Then the member validate the correct Membership Materials section is coming
    #  | BENEFIT-HIGHLIGHT       | <benefithighlight>       |
    #  | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
    #  | EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
    Then validate that the AnocSection is displayed for MAPD
    Then validate that annual directory section is displayed
      | Member Type | <memberType> |
    And both Pharmacy and provider search links are displayed
      | PlanType | <planType> |
    Then validate that My Document section is displayed
    And both the drug and medical EOB links are displayed
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed for MAPD
    # Then validate pdf's in annual directory section
    #|Member Type|<memberType>|
    #| ProviderDirectory     		  | <providerdirectory>    |
    #| Vendor Information Sheet       | <vendorInformationsheet> |
    #|Pharmacy Directory Information  |<pharmacydirectoryinformation>|
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

  @formsAndResources10 @fnrpdpuhcindividual @Part2of2
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page PDP UHC Individual
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    # And validates that PEEHIP logo is not displayed
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

  @formsAndResources11 @fnrmapdgroupvalidation @Part2of2
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page MAPD group
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    # And validates that PEEHIP logo is not displayed
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
      #Pdf's aren't coming
      #And then user verifies that the correct pdfs are coming in the plan material section
      #| GETTING STARTED GUIDE             | <gettingstartedguide>    |
      | BENEFIT-HIGHLIGHT                 | <benefithighlight>       |
      | SUMMARY-OF-BENEFIT                | <summaryofbenefits>      |
      | EVIDENCE OF COVERAGE              | <evidenceofcoverage>     |
      | CERTIFICATE OF COVERAGE           | <certificateofcoverage>  |
      #| FORMULARY DRUG LIST ABRIDGED      | <abridgedformulary>      |
      | FORMULARY DRUG LIST COMPREHENSIVE | <comprehensiveformulary> |
      | ADDITIONAL DRUG COVERAGE          | <additionaldrug>         |
      | PRIOR AUTHORIZATION               | <priorauth>              |
      | STEP THERAPY CRITERIA             | <steptherapy>            |
      | FORMULARY ADDITIONS               | <formularyadd>           |
      | FORMULARY DELETIONS               | <formularydel>           |
    # Membership Materials is based on continued plan flag & year logic. It appears when flage is true,displays only for a year from the day of enrollment.
    #Then the member validate the correct Membership Materials section is coming
    # | GETTING STARTED GUIDE    | <gettingstartedguide>    |
    # | BENEFIT-HIGHLIGHT        | <benefithighlight>       |
    # | COMPREHENSIVE FORMULARY  | <comprehensiveformularymem> |
    # | ADDITIONAL DRUG COVERAGE | <additionaldrug> |
    # | EVIDENCE OF COVERAGEMEM     | <evidenceofcoveragemem>     |
    # | CERTIFICATE OF COVERAGE  | <certificateofcoverage>  |
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

  # |MAPD     | GroupPharmacyFnR  | SPANISH           |Beneficios Importantes |Resumen de Beneficios |Comprobante de Cobertura |Comprehensive Formulary-Spanish |
  @formsAndResources12 @fnrpdpaarpindividualvalidation @Part2of2
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

  @formsAndResources13 @fnrpdptexasgroupvalidation @Part2of2
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page PDP Texas group
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    #And validates that PEEHIP logo is not displayed
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
    #  Then the member validate the correct Membership Materials section is coming
    #    | GETTING STARTED GUIDE    | <gettingstartedguide>    |
    #    | BENEFIT-HIGHLIGHT        | <benefithighlight>       |
    #   | COMPREHENSIVE FORMULARY  | <comprehensiveformulary> |
    #   | ADDITIONAL DRUG COVERAGE | <additionaldrugcoverage> |
    #   | EVIDENCE OF COVERAGE     | <evidenceofcoverage>     |
    #   | CERTIFICATE OF COVERAGE  | <certificateofcoverage>  |
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

  @formsAndResources14 @fnrpdpgroupvalidation @Part2of2
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page PDP UHC group
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
    #Then the member validate the correct Membership Materials section is coming
    #| GETTING STARTED GUIDE    | <gettingstartedguide>    |
    #| BENEFIT-HIGHLIGHT        | <benefithighlight>       |
    #| COMPREHENSIVE FORMULARY  | <comprehensiveformulary> |
    #| ADDITIONAL DRUG COVERAGE | <additionaldrugcoverage> |
    #| EVIDENCE OF COVERAGE     | <evidenceofcoverage>     |
    #| CERTIFICATE OF COVERAGE  | <certificateofcoverage>  |
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

  @formsAndResources15 @fnrmaindividualvalidation @Part2of2
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page  MA AARP Individual
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    # And validates that PEEHIP logo is not displayed
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
    #   Then the member validate the correct Membership Materials section is coming
    #    | GETTING STARTED GUIDE          | <gettingstartedguide>         |
    #    | BENEFIT-HIGHLIGHT              | <benefithighlight>            |
    #    | EVIDENCE OF COVERAGE           | <evidenceofcoverage>          |
    #    | UNITED HEALTH PASSPORT PROGRAM | <unitedhealthpassportprogram> |
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
    # And then user verifies that the correct pdfs are coming in the plan material section
    #| BENEFIT-HIGHLIGHT              | <benefithighlight>            |
    # | SUMMARY-OF-BENEFIT             | <summaryofbenefits>           |
    # | EVIDENCE OF COVERAGE           | <evidenceofcoverage>          |
    # | UNITED HEALTH PASSPORT PROGRAM | <unitedhealthpassportprogram> |
    Then validate pdf's in annual directory section
      | Member Type              | <memberType>             |
      | ProviderDirectory        | <providerdirectory>      |
      | Vendor Information Sheet | <vendorInformationsheet> |

    Examples: 
      | TID   | planType          | memberType | language | benefithighlight   | summaryofbenefits   | evidenceofcoverage   | unitedhealthpassportprogram   | anoc                     | evidenceofcoverageanoc | providerdirectory  | vendorInformationsheet   |
      | 15129 | MA_FormsResources | AARPIndFnR | ENGLISH  | Benefit Highlights | Summary of Benefits | Evidence of Coverage | UnitedHealth Passport Program | Annual Notice of Changes | Evidence Of Coverage   | Provider Directory | Vendor Information Sheet |

  @formsAndResources16 @fnralpeehipgroupvalidation @Part2of2
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page alpeehip group
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    # And the user verifies the alpeehip logo
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
    #Then the member validate the correct Membership Materials section is coming
    #  | GETTING STARTED GUIDE    | <gettingstartedguide>    |
    #  | BENEFIT-HIGHLIGHT        | <benefithighlight>       |
    #  | COMPREHENSIVE FORMULARY  | <comprehensiveformulary> |
    #  | ADDITIONAL DRUG COVERAGE | <additionaldrugcoverage> |
    #  | EVIDENCE OF COVERAGE     | <evidenceofcoverage>     |
    #  | CERTIFICATE OF COVERAGE  | <certificateofcoverage>  |
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

  @formsAndResources17 @pcpfnrvalidation @Part2of2
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for PCP
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
    Then validate that the anoc section is not displayed
    Then validate that annual directory section is displayed
      | Member Type | <memberType> |
    And both the Pharmacy locator & provider search links are displayed for PCP
    Then validate that My Document section is displayed
    Then validate that the EOB Section is displayed
    And both the drug and medical EOB links are displayed
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is displayed
    #Then the member validate the correct Membership Materials section is coming
    #| BENEFIT-HIGHLIGHT       | <benefithighlight>       |
    # | COMPREHENSIVE FORMULARY | <comprehensiveformulary> |
    #| EVIDENCE OF COVERAGE    | <evidenceofcoverage>     |
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

  # | MAPD     | PCPFnR | SPANISH | Benefit Highlights  | Summary of Benefits  | Evidence of Coverage  | Comprehensive Formulary  | Prior Authorization  | Step Therapy  | Formulary Additions  | Formulary Deletions  |
  @formsAndResources18 @ssupfnrvalidation @Part2of2
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
    # Then the member validate the correct Membership Materials section is coming
    #   | YOUR_PLAN_GETTING_STARTED | <yourplangettingstarted> |
    #   | SCHEDULE_OF_BENEFITS      | <scheduleofbenefits>     |
    ##   | CERTIFICATE_OF_COVERAGE   | <certificateofcoverage>  |
    #   | PRIVACY_NOTICE            | <privacynotice>          |
    Then validate that the anoc section is not displayed
    Then validate that the annual directories section is not displayed for ssupFnr
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My Document section is displayed
    Then validate that the EOB section and both the type of Eobs are not displayed
    Then validate that the forms & resources section is displayed
    Then validate that the renew magazine section is not displayed

    #And then user verifies that the correct pdfs are coming in the plan material section
    # | SCHEDULE_OF_BENEFITS      | <scheduleofbenefits>     |
    # | CERTIFICATE_OF_COVERAGE   | <certificateofcoverage>  |
    # | YOUR_PLAN_GETTING_STARTED | <yourplangettingstarted> |
    # | PRIVACY_NOTICE            | <privacynotice>          |
    # | CDI_NOTICE                | <cdinotice>              |
    Examples: 
      | TID   | planType           | memberType | language | scheduleofbenefits   | certificateofcoverage   | yourplangettingstarted    | privacynotice  | cdinotice       | Identifier | type  |
      | 15304 | UHC_FromsResources | SSUPFnR    | ENGLISH  | Schedule of Benefits | Certificate of Coverage | Your Plan Getting Started | Privacy Notice | CDI Long Notice | SSUP_DCE   | Group |

  #  | 00000   | MAPD     | PCPFnR |  #SPANISH | Benefit Highlights  | Summary of Benefits  | Evidence of Coverage  | Comprehensive Formulary  | Prior Authorization  | Step Therapy  | Formulary Additions  | Formulary Deletions  |
  @formsAndResources19 @combovalidation @Part2of2
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for combo members
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    #And validates that PEEHIP logo is not displayed
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

  @formsAndResources20 @terminatedmembervalidation @Part2of2
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for Terminated Members
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    # And validates that PEEHIP logo is not displayed
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

  # uhc
  @formsAndResources21 @shipscenario @Part2of2
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for SHIP members
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    # And validates that PEEHIP logo is not displayed
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
      | Member Type | <memberType> |
    And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    And validate that the view temporary id card link is displayed
      | Member Type | <memberType> |
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And validate that english is default language in the dropdown
      | Member Type | <memberType> |
    Then validate that the forms & resources section is displayed
    Then verifies that Electronic Funds pdf for ship is displayed

    # Then the user verifies the pdfs for ship if particular pdf is not present
    #	| Member Type | <memberType> |
    #	| BENEFIT HIGHLIGHTS  |<benefitstable>    |
    #	| PLAN OVERVIEW | <planoverview>  |
    #	| OUTLINE OF COVERAGE    |<outlineofcoverage>|
    Examples: 
      | TID   | planType            | memberType         | benefitstable  | planoverview  | outlineofcoverage   |
      # uhc
      | 15119 | SHIP_FromsResources | IndPharmacyShipFnR | Benefits Table | Plan Overview | Outline of Coverage |

  @formsAndResources22 @memberauthfnrpagevalidation @Part2of2
  Scenario Outline: TID: <TID> -Username: <username> - To validate the forms and resources page through Member auth.
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user Clicks on the Pop up displayed and checks payment link

    #And user clicks on the view document and resources link and navigate to forms and resource page from member auth page
    #And validates that PEEHIP logo is not displayed
    #And validate for active member Temporary Id Card and Plan Order Material links are displayed
    #And clicking on the order plan materials link the user is navigated to the Order Plan Material Page
    #And validate that the view temporary id card link is displayed
    #Then validate that the plan material section is displayed
    #Then validate that the AnocSection is displayed
    #Then validate that annual directory section is displayed
    Examples: 
      | TID   | username  | password  | member          |
      | 00000 | qavgogine | qavgogine | q2_jun_aarp0055 |

  @formsAndResources23 @pcpMedicaValidationOfProviderSearch @Part2of2
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for PCP medica members Provider search link
    Given login with following details in the member redesign portal
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And User clicks on Provider search link and checks if the find care page opens up

    Examples: 
      | TID   | planType | memberType               |
      | 00001 | MAPD     | PCP_FromsandResources    |
      | 00002 | MAPD     | MEDICA_FromsandResources |

  #Need a ship Active member with New pre effective plan
  @formsAndResources24 @ShipActiveShipPre @regressionMember @release_june_2019 @Part2of2
  Scenario Outline: FID: <FID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for SHIP members
    Given login with following details logins in the member portal and validate elements
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
    Then validate that the forms & resources section is displayed
    Then verifies that Electronic Funds pdf for ship is displayed
    Then verifies Ship EOB field is displayed for effecitve plan
    Then verify Preeffective plan name and Coverage Date for preeffective plan
      | ShipPreEffe PlanName | <ShipPreEffePlan> |
      | Coverge Date         | <CoverageDate>    |
    Then verify orderPlan Material link is not displayed preeffective plan

    Examples: 
      | FID     | planType | memberType           | benefitstable  | planoverview  | outlineofcoverage   | ShipPreEffePlan               | CoverageDate               |
      | F282605 | SHIP     | ShipActievNewPreShip | Benefits Table | Plan Overview | Outline of Coverage | AARP MEDICARE SELECT PLAN CS1 | Coverage Starts 08/01/2019 |

  #Need a ship Active member with New pre effective plan
  @formsAndResources25 @ShipTerminatedShipPre @regressionMember @release_june_2019 @Part2of2
  Scenario Outline: FID: <FID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for SHIP members
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And validate that english is default language in the dropdown
      | Member Type | <memberType> |
    Then validate that the forms & resources section is displayed
    Then verifies that Electronic Funds pdf for ship is displayed
    Then verifies Ship EOB field is displayed for effecitve plan
    Then verify Preeffective plan name and Coverage Date for preeffective plan
      | ShipPreEffe PlanName | <ShipPreEffePlan> |
      | Coverge Date         | <CoverageDate>    |
    Then verify orderPlan Material link is not displayed preeffective plan

    Examples: 
      | FID     | planType | memberType        | benefitstable  | planoverview  | outlineofcoverage   | ShipPreEffePlan                   | CoverageDate               |
      | F282605 | SHIP     | ShipTerNewPreShip | Benefits Table | Plan Overview | Outline of Coverage | AARP MEDICARE SUPPLEMENT PLAN K01 | Coverage Starts 08/01/2019 |

  #Need a Fed Active member with New pre effective plan
  @formsAndResources26 @FedActiveShipPre @regressionMember @release_june_2019 @Part2of2
  Scenario Outline: FID: <FID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for SHIP members
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user is on the forms and resources page for Selected plan tab
      | PlanName | <FirstPlanName> |
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And validate for active member Temporary Id Card and Plan Order Material links are displayed
      | Member Type | <memberType> |
    And the user scrolls till the end of the page to check the forms and resources section
    And user is on the forms and resources page for Selected plan tab
      | PlanName | <SecondPlanName> |
    Then verify Preeffective plan name and Coverage Date for preeffective plan for Combo
      | ShipPreEffe PlanName | <ShipPreEffePlan> |
      | Coverge Date         | <CoverageDate>    |
    Then verify orderPlan Material link is not displayed preeffective plan for Combo

    Examples: 
      | FID     | planType | memberType          | FirstPlanName          | SecondPlanName                     | ShipPreEffePlan               | CoverageDate               |
      | F282605 | Combo    | FedActiveNewPreShip | Prescription Drug Plan | Medicare Supplement Insurance Plan | AARP MEDICARE SUPPLEMENT PLAN | Coverage Starts 08/01/2019 |

  #Need a Fed Terminated member with New pre effective plan
  @formsAndResources27 @FedTerminatedShipPre @regressionMember @release_june_2019 @Part2of2
  Scenario Outline: FID: <FID> -Plan Type: <planType> -Member Type: <memberType> - To validate the forms and resources page for SHIP members
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user is on the forms and resources page for Selected plan tab
      | PlanName | <FirstPlanName> |
    Then validate that the plan material section is displayed
      | Member Type | <memberType> |
    And for terminated member order plan materials link is not displayed
    Then validate that the anoc section is not displayed
    And both the Pharmacy locator and provider search links are not displayed
    Then validate that My Document section is displayed
    Then validate that the renew magazine section is not displayed
    Then validate that the annual directories section is not displayed
    Then validate that the EOB Section is displayed
    And the user scrolls till the end of the page to check the forms and resources section
    And user is on the forms and resources page for Selected plan tab
      | PlanName | <SecondPlanName> |
    Then verify Preeffective plan name and Coverage Date for preeffective plan for Combo
      | ShipPreEffe PlanName | <ShipPreEffePlan> |
      | Coverge Date         | <CoverageDate>    |
    Then verify orderPlan Material link is not displayed preeffective plan for Combo

    Examples: 
      | FID     | planType | memberType       | FirstPlanName                                          | SecondPlanName                     | ShipPreEffePlan               | CoverageDate               |
      | F282605 | Combo    | FedTerNewPreShip | Medicare Advantage Prescription Drug Plan (Terminated) | Medicare Supplement Insurance Plan | AARP MEDICARE SUPPLEMENT PLAN | Coverage Starts 08/01/2019 |

  #----- begin segmentID and pdf code related validation
  # note: will kill the test if page load time takes longer than 5 min to load
  # note: example table values may need to be adjust when year changes and pdf codes change
  @formsAndResources28 @F318679_ANOC @regressionMember @Part2of2 @Predators
  Scenario Outline: FID: F<FID> -Plan Type: <planType> -Member Type: <memberType> - To validate the segment ID and ANOC component code 
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And user navigate to plan documents and resources page for segment ID validation
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then I can validate the segment ID value in localStorage on forms and resources page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | Segment ID  | <segmentId>  |
    Then I can validate Annual Notice of Changes Documents section content
      | Plan Type                        | <planType>             |
      | Member Type                      | <memberType>           |
      | Expect Whole ANOC Section        | <expectWholeAnocSect>  |
      | Expect Current Year ANOC Section | <cy_expectAnocSubSect> |
      | Current Year ANOC PDF Code       | <cy_anocPdfCode>       |
      | Current Year EOC PDF Code        | <cy_eocPdfCode>        |
      | Current Year CF PDF Code         | <cy_cfPdfCode>         |
      | Expect Next Year ANOC Section    | <ny_expectAnocSubSect> |
      | Next Year ANOC PDF Code          | <ny_anocPdfCode>       |
      | Next Year EOC PDF Code           | <ny_eocPdfCode>        |
      | Next Year CF PDF Code            | <ny_cfPdfCode>         |

    Examples: 
      | FID    | planType | memberType      | segmentId    | expectWholeAnocSect | cy_expectAnocSubSect | cy_anocPdfCode      | cy_eocPdfCode       | cy_cfPdfCode        | ny_expectAnocSubSect | ny_anocPdfCode      | ny_eocPdfCode       | ny_cfPdfCode        | 
    # note: no working data for these comment out cases yet
    # | 318679 | MAPD     | IndEff_AARP_FnR | 000          | true                | true                 | AAPA19HM4283769_001 | AAPA19HM4283717_003 | AAEX19HM4310605_011 | true                 | AAPA20HM4515155_000 | AAPA20HM4536734_000 | AAEX20HM4540614_000 |
    # | 318679 | MAPD     | IndEff_UHC_FnR  | 000          | true                | true                 | AAFL19RP4284175_001 | AAFL19RP4284870_003 | AAEX19PP4310531_011 | true                 | AAFL20RP4515715_000 | AAFL20RP4537629_000 | AAEX20PP4540533_000 |
      | 318679 | PDP      | IndEff_AARP_FnR | 000          | true                | true                 | PDEX----4284318_002 | AAEX----4285044_004 | PDEX----4310625_013 | true                 | PDEX----4512102_000 | PDEX----4512066_000 | PDEX----4540654_000 |
      | 318679 | SHIP     | IndEff_FnR      | 000          | false               | false                | NA                  | NA                  | NA                  | false                | NA                  | NA                  | NA                  |
    # | 318679 | MAPD     | PreEff_FnR      | 000          | false               | false                | NA                  | NA                  | NA                  | false                | NA                  | NA                  | NA                  |
      | 318679 | PDP      | PreEff_FnR      | 000          | false               | false                | NA                  | NA                  | NA                  | false                | NA                  | NA                  | NA                  |
      | 318679 | MAPD     | Terminated_FnR  | 000          | false               | false                | NA                  | NA                  | NA                  | false                | NA                  | NA                  | NA                  |
  #----- end segmentID and pdf code related validation
      