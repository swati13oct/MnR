 @PlansAndDocument_Part2 @PlansAndDocuments @VelocityDasher @regressionMember
Feature: 1.06.2 Member Plans and Documents Page Part 2

					# This feature File consist of Scenario 3 to 8.

 @PlansAndDocument3 @F&RJMPLinks @Feb_release_2019 @gladiators @PD_Part2_Regression
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

  @PlansAndDocument4 @F&RJMPLinks @Feb_release_2019 @gladiators  @PD_Part2_Regression
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
      | 15131 | PDP      | Group_FormsResources      | EffectivePDPUHC  | ENGLISH  |     7 | NoRider |

  @PlansAndDocument5 @F&RJMPLinks @Feb_release_2019 @gladiators  @PD_Part2_Regression
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
  @PlansAndDocument6 @pre-effectivefnrmapdaarpindividualvalidation  @PD_Part2_Regression
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
 
  @PlansAndDocument7 @IndAARPMAPre-EffectiveFnR  @PD_Part2_Regression
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

  @PlansAndDocument8 @fnrpdpaarpindividualvalidationPre-Effective @PD_Part2_Regression
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
