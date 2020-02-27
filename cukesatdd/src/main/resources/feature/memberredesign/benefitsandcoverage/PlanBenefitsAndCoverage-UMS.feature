@benefitsAndCoverage @thePredators @codeMonkeys @regression_06_06_18
Feature: 1.01 Member  benefits and Coverage page

#  Background: If run on stage then feature security flag needs to be true
#     Given feature security flag must set to true when testing on stage env
#      | Feature           | UCPBenefits |

###############################Regression Scenarios Begin Here ########################################
  #TC01_OutpatientSurgeryCentervisits_withprovidertiering
  @benefitsAndCoverage6 @outpatientcenterwithprovidertier @thepredators @regressionoutpatient @BnC_Part1_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the outpatient widget for a member withprovidertiering
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user with providerTier validates the Outpatient Surgery Center Visits section

    @devRegression
    Examples: 
      | TID   | planType | memberType   |
      | 15084 | MAPD      | providerTier_BNC |

  #TC02_Primarycareprovider_specialist_withprovidertiering
  @benefitsAndCoverage7 @primarycareproviderspecialist @thepredators @regressionprimarycareprovider @BnC_Part1_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Office visits widget for a member witprovidertiering
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And user validates the Office Visits section widgets

    Examples: 
      | TID   | planType | memberType            |
      | 15085 | MAPD     | COSMOSOfficevisit_BnC |

  #TC04_OutpatientSurgeryCentervisits_withoutprovidertiering
  @benefitsAndCoverage8 @outpatientcenterwithoutprovidertier @thepredators @regressionoutpatientwithoutprovider @BnC_Part1_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the outpatient widget for a member withoutprovidertiering
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user without providertier validates the Outpatient Surgery Center Visits section

    Examples: 
      | TID   | planType | memberType     |copayCategory |
      | 15087 | MAPD     | Individual_BnC | NON LIS       |

  #TC05_Primarycareprovider_specialist_withoutprovidertiering
  @benefitsAndCoverage4 @OfficeVisitswithoutprovidertiering @regression @BnC_Part2_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Office visits widget for a member withoutprovidertiering
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Office Visits section

    Examples: 
      | TID   | planType | memberType                       |
      | 15088 | MAPD     | memberWithoutProviderTiering_BnC |

  #TC07_Copay_Coinsurance_in_DrugCostsTable
  @benefitsAndCoverage11 @CopayCoinsuranceInDrugCostTable @regression @BnC_Part2_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the copay coinsurance in drugcosts table
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the copay coinsurance in drug costs table
    
   @devRegression
    Examples: 
      | TID   | planType | memberType     | copayCategory |
      | 15090 | MAPD     | Individual_BnC | NON LIS       |

  #TC08_BenefitsFor_ComboMembers
  @benefitsAndCoverage12 @BenefitsForCombo @regression @BnC_Part2_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Benefits for a combo member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the benefits for a combo member

    Examples: 
      | TID   | planType | memberType       |
      | 15091 | Combo    | ComboFEDShip_BnC |

  #TC09_Benefits_for_ALPeehipMember
  #Peehip members are discontinued from PROD. None of the available members are Active .Terminated members dont have the BNC page display.
  @benefitsAndCoverage9 @BenefitsForAlPeehipMember @regression 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the benefits for an AL peehip member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Benefits for Peehip member

    Examples: 
      | TID   | planType | memberType |
      | 15092 | Peehip   | Group_BnC  |

  #TC10_Benefits_for_TexasERSMember
  @benefitsAndCoverage3 @BenefitsforTexasERSMember @regression @BnC_Part3_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Benefits for TexasERSMember
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Drug costs Section
    Then the user verifies the Retail Cost sharing table
    Then the user verifies the Mail Order Cost sharing table
   @devRegression
    Examples: 
      | TID   | planType | memberType        |
      | 15093 | PDP      | TEXASERSGroup_BnC |

  #TC11_Benefits_for_Ship_member
  #note: this scenario covers multiple testcases TID 15094,15240
  @benefitsAndCoverage22 @CMShip @BnC_Part3_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify that Page Headers are in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    Then verify ancillary benefit section is not displayed
    And the user validates plan overview and summary on Bnc page for ship members
     | Benefits Expected | <numberOfBenefitCards> |
    And the user validates hand image under discount and services section
    And the user validates the Vas section on benefits and coverage page
    And the user validates additional information on Bnc page for ship members
    And the user validates view and document label
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are coming in the plan material section
      | Plan Benefits Table | <PlanBenefitsTable> |
    And the user validates ship the need help section
    And the user validates for ship see more ways to contact us section
    And the user validates for ship member on clicking contact us link it should route to contact us page
    And the user clicks on More Information link for ship
    Then the user validate Value Add Service page comes on clicking additional info button
    And the user validate vas tiles on vas page

    Examples: 
      | TID   | planType | memberType        | language | PlanBenefitsTable   | numberOfBenefitCards |  
      | 15094 | HIP      | SHIP_BnC          | ENGLISH  | Plan Benefits Table |  7                  |

 #TC12_Benefits_for_MedicaMember
  @benefitsAndCoverage12_1 @CMFedDrugNonLis  @BnC_Part3_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -language: <language> - Verify all sections for Ind NonLIS member on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates Ind plan overview
      | Name            | <name>           |
      | Member ID       | <memberid>       |
      | Effective Date  | <effectivedate>  |
      | Monthly premium | <monthlypremium> |
    And the user validates headers on Bnc page for indi members
      | Plan Type       | <planType>       |
   # And the user validates the Primarycare Provider section
      | Plan Type | <planType> |
   And the user validates the Out of Pocket Max section
   And the user view the Drug Copays & Discounts header
    And the Individual user validates Default drug cost drop down value
    And the Medica user able to see drug table and values in it
    And the user validates the Learn More section for stage and tier
   And the user validates dropdown selection functionality
    And the user validates Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates Look Up Drugs button should be visible
      | Plan Type | <planType> |
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
      | Plan Type | <planType> |
    And the user should see drug copay and discount table
      | Updated Language | <UpdatedLanguage> |
      | Display Flag     | <DisplayFlag>     |
    And the user validates the user click on the link it expands and when user clicks it again it should collapse
    And the user validates view and document label
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are there in the plan material section of benefits page
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
      | Alternative Drug List               | <AlternativeDrug List>            |
    And the user select the documents language
      | Language | <language1> |
    And the user verifies that the correct pdfs are there in the plan material section of benefits page
      | Summary of Benefits                 | <SummaryofBenefitsSpanish>               |
      | Evidence of Coverage                | <EvidenceofCoverageSpanish>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug ListSpanish> |
      | Alternative Drug List               | <AlternativeDrug ListSpanish>            |
    And the user select the documents language
      | Language | <language2> |
    And the user verifies that the correct pdfs are there in the plan material section of benefits page
      | Summary of Benefits                 | <SummaryofBenefitsChinies>               |
      | Evidence of Coverage                | <EvidenceofCoverageChinies>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug ListChinies> |
      | Alternative Drug List               | <AlternativeDrug ListChinies>            |
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   | planType | memberType             | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | AlternativeDrug List  | language1 | SummaryofBenefitsSpanish | EvidenceofCoverageSpanish  | ComprehensiveFormularyDrug ListSpanish | AlternativeDrug ListSpanish        			| language2 | SummaryofBenefitsChinies | EvidenceofCoverageChinies | ComprehensiveFormularyDrug ListChinies | AlternativeDrug ListChinies | name        | memberid     | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
       | 15095 | Medica   | Individual_BnC | NON LIS       | ENGLISH  | Summary of Benefits   | Evidence of Coverage      | Comprehensive Formulary - Drug List | Alternative Drug List | 1  | Resumen de Beneficios    | Comprobante de Cobertura  | Formulario Completo                    | Lista de Medicamentos Alternativos | 2   |                          |                           |                                      |                             | AADECDC FEDFACEDBACBB | 954283936-00 | 04/01/2018    | Not Available  | Tier 2          | true        |

#TC13_Benefits_for_MA_SSUP_MEDSUPMember
  @benefitsAndCoverage10 @BenefitsForMAMedsupSSUPMember @regression  @BnC_Part4_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Benefits for a  MA Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Benefits for MA member
      | Plan Type | <planType> |

    Examples: 
      | TID   | planType | memberType     |
      | 15096 | MA       | Individual_BnC |
      | 15098 | SSUP     | Group_BnC      |

  #TC14_Benefits_for_PCPMember
  @benefitsAndCoverage14_2 @CMFedDrugNonLis  @BnC_Part4_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -language: <language> - Verify all sections for Ind NonLIS member on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
       And the user validates Ind plan overview
      | Name            | <name>           |
      | Member ID       | <memberid>       |
      | Effective Date  | <effectivedate>  |
      | Monthly premium | <monthlypremium> |
     And the user validates headers on Bnc page for indi members
      | Plan Type       | <planType>       |
    #And the user validates the Primarycare Provider section
      | Plan Type | <planType> |
    And the user validates the Out of Pocket Max section
   And the user view the Drug Copays & Discounts header
   And the Individual user validates Default drug cost drop down value
    And the PCP user able to see drug table and values in it
    And the user validates the Learn More section for stage and tier
    And the user validates dropdown selection functionality
    And the user validates Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates Look Up Drugs button should be visible
      | Plan Type | <planType> |
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
      | Plan Type | <planType> |
    And the user validates the user click on the link it expands and when user clicks it again it should collapse
    And the user validates view and document label
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are there in the plan material section of benefits page
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
      | Alternative Drug List               | <AlternativeDrug List>            |
    And the user select the documents language
      | Language | <language1> |
    And the user verifies that the correct pdfs are there in the plan material section of benefits page
      | Summary of Benefits                 | <SummaryofBenefitsSpanish>               |
      | Evidence of Coverage                | <EvidenceofCoverageSpanish>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug ListSpanish> |
      | Alternative Drug List               | <AlternativeDrug ListSpanish>            |
    And the user select the documents language
      | Language | <language2> |
    And the user verifies that the correct pdfs are there in the plan material section of benefits page
      | Summary of Benefits                 | <SummaryofBenefitsChinies>               |
      | Evidence of Coverage                | <EvidenceofCoverageChinies>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug ListChinies> |
      | Alternative Drug List               | <AlternativeDrug ListChinies>            |
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   | planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   |  ComprehensiveFormularyDrug List     | AlternativeDrug List  | language1 | SummaryofBenefitsSpanish | EvidenceofCoverageSpanish | ComprehensiveFormularyDrug ListSpanish | AlternativeDrug ListSpanish        | language2 | SummaryofBenefitsChinies | EvidenceofCoverageChinies |  ComprehensiveFormularyDrug ListChinies | AlternativeDrug ListChinies | name        | memberid     | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
       | 15097 | PCP      | Individual_BnC | NON LIS      | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List  | Alternative Drug List | 1  | Resumen de Beneficios    | Comprobante de Cobertura   | Formulario Completo                    | Lista de Medicamentos Alternativos       | 2      |                          |                           |                                        |                           | BDFAEC CBADEADF | 945007888-00 | 01/01/2018    | Not Available  | Tier 2          | true        |

  #TC15_Ancilliary Benefits for Group member(MA,MAPD)
  @benefitsAndCoverage21 @CMAncillarysection2  @BnC_Part4_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify CMAncillarysection2 section is in place on Benefits and Coverage page for nonLis member
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigate to Benefits and Coverage page
    Then user validates ADDITIONAL BENEFITS Section
    Then user validates and clicks on Disclaimers link under Exclusive hearing
    Then the user validates Hearing section
    Then the user validates the Hearing Aid section
    Then the user validates the Vision section
    Then the user validates the Dental section
    Then the user validates chiropractic section
    Then user validates and clicks on Learn More button under Exclusive hearing section
    @devRegression
    Examples:  
      | TID   | planType | memberType          | copayCategory |
      | 15238 | MAPD     | Group_BnC_Ancillary | NON LIS       |

  #TC16-Part1_Ancilliary Benefits for Group member(PDP and other than Group members)
  @benefitsAndCoverage32_1 @ancillarybenefitnegativescenarioscodemonkeys @BnC_Part5_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify ancillary benefits are not displayed other than Group nonLis memnbers
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    Then verify ancillary benefit section is not displayed
    And the user validates the Vas section on benefits and coverage page is not displayed

    Examples: 
      | TID   | planType | memberType     | copayCategory |
      | 15239 | PDP      | Group_BnC      | NON LIS       |
      | 15238 | MAPD     | Individual_BnC | NON LIS       |

    #TC19_Ways To Save should come only for PDP members (Saver,Walgreen,Preferred, Symphonix)
  @benefitsAndCoverage5 @WaystoSaveforPdp @regression  @BnC_Part5_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the ways to save  widget for a PDP member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the ways to save section
  
  @devRegression
    Examples: 
      | TID   | planType | memberType             |
      | 15242 | PDP      | Wallgreens_BnC         |
      | 15243 | PDP      | MailOrderPharamacy_BnC |
      | 15249 | MAPD     | withoutWaysToSave_BnC  |
      
    #TC20_Rider for Fed MA,MAPD plans only  
        # note: Due to timing that it takes for GPS to do the update (add or remove),
  # this testcase result will not be stable. Since can't predict time for GPS to finish the update,
  # so the add or remove button does't always show up within the time the code expects it to.
  @benefitsAndCoverage13 @BenefitsRiderFunctionality @regression
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Benefits for a combo member with Rider
     Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Add Rider functionality
    Then the user validates the remove Rider functionality

    Examples: 
    
    | TID   | planType | memberType     | copayCategory |
      | 15090 | MAPD     | Individual_BnC | NON LIS       |
    
      
  #TC21_PDP_LIS(3,4)- Retail Drug Cost Table
  @benefitsAndCoverage1  @PDPLIS3member @BnC_Part5_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Group LIS 3/4 on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigate to Benefits and Coverage page
    And the user validates plan overview section for individual
    And the user view the LIS Drug Copays & Discounts header
   And the user validates the Learn More section link for stage
    And the user validates tier link should not display
    And the user view the Drug Cost header and text
    And the user validated the Look up Drugs link
    And the user validates Locate a Pharmacy button should be visible
      | Plan Type | <planType> |
    And the drugcost dropdown should not display
    And the user validates tier link should not display
    And the PDP individual user should see drug cost table for Lis members
    And the user verifies that the correct pdfs are there in the plan material section of benefits page
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
      | Alternative Drug List               | <AlternativeDrugList>             |
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates view and document label
    And the user validates spanish and chinese should not display in dropdown
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   | planType | memberType | copayCategory | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | AlternativeDrugList   |
      | 15248 | PDP     | PDPLIS_Bnc  | LIS 3         | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary         | Alternative Drug List |
      
  #TC25_Group members_MAPD_LIS(3,4)
  @benefitsAndCoverage1 @BnC_Part6_regressionMember @CMGroupmembersTC25 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Group LIS 3/4 on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigate to Benefits and Coverage page
    And the user validates plan overview section for group
    And the user view the LIS Drug Copays & Discounts header
    And the user validates the Learn More section link for stage
    And the user validates tier link should not display
    And the user view the Drug Cost header and text
    And the user validated the Look up Drugs link
    And the user validates Locate a Pharmacy button should be visible
      | Plan Type | <planType> |
    And the drugcost dropdown should not display
    And the user validates tier link should not display
    And the MAPD group user should see drug cost table for Lis members
    And the user verifies that the correct pdfs are there in the plan material section of benefits page
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates view and document label
    And the user validates spanish and chinese should not display in dropdown
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   | planType | memberType | copayCategory | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List |
      | 15247 | MAPD     | Group_BnC  | LIS 4         | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         |

  #TC26_Group members_PDP_LIS(1,2)
  @benefitsAndCoverage2 @BnC_Part6_regressionMember @CMGroupmembersPDPLIS_TC26
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Group LIS 1/2 values on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigate to Benefits and Coverage page
    And the user validates plan overview section for group
    And the user validates the Learn More section link for stage
    And the user validates tier link should not display
    And the user view the Drug Cost header and text
    And the user validated the Look up Drugs link
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
      | Plan Type | <planType> |
    And the Group PDP LIS1 user should see drug cost table for Lis members
    And the user verifies that the correct pdfs are there in the plan material section of benefits page
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
    # | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates spanish and chinese should not display in dropdown
    And the user validates Needhelp section
    And the drugcost dropdown should not display
    And the user validates view and document label
    And the user clicks on More Information link
    And the user validates contactus section
    
    @devRegression
    Examples: 
      | TID   | planType | memberType | copayCategory | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List |
      | 15369 | PDP      | Group_BnC  | LIS 1         | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         |

  #TC23_Group NON LIS_MAPD
  @benefitsAndCoverage23 @CMMapdGroupNonLis @BnC_Part6_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify all sections for Group NonLIS member on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigate to Benefits and Coverage page
    And the NON LIS user validates plan overview section for group
    And the user validates headers on Bnc page for group members
    And the user validates the Group Primarycare Provider section
    And the user view the Drug Copays & Discounts header
    And the user validates dropdown selection functionality
    And the user validates the Learn More section for stage and tier
    And the user validates group Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates group Look Up Drugs button should be visible
    And the user validates text for the Locate a Pharmacy section
    And the MAPD NON-LIS group user should see drug cost table for Lis members
    And the user validates Locate a Pharmacy button should be visible
      | Plan Type | <planType> |
    And the user should see drug copay and discount table
      | Updated Language | <UpdatedLanguage> |
      | Display Flag     | <DisplayFlag>     |
    And the user validates the user click on the link it expands and when user clicks it again it should collapse
    And the user validates view and document label
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates spanish and chinese should not display in dropdown
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are coming in the plan material section
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
     # | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   | planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | name             | memberid     | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
     | 15246 | MAPD     | Group_BnC  | NON LIS       | ENGLISH  | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         | EFADDB CDEEFFCDC | 978095497-00 | 01/01/2018    | Not Available  | Tier 2          | true        |

  #TC24_Group NON LIS_PDP
  @benefitsAndCoverage27 @CMPDPGroupNonLis @BnC_Part7_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify all sections for PDP Group NonLIS member on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the NON LIS user validates plan overview section for group
    And the user view the Drug Copays & Discounts header
    And the user validates the Learn More section for stage and tier
    And the user validates dropdown selection functionality
    And the user validates text for the Look Up Drugs section
    And the user validates group Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates group Look Up Drugs button should be visible
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
      | Plan Type | <planType> |
    And the NON-LIS PDP group user should see drug cost table for Lis members
    And the user should see drug copay and discount table
      | Updated Language | <UpdatedLanguage> |
      | Display Flag     | <DisplayFlag>     |
    And the user validates the user click on the link it expands and when user clicks it again it should collapse
    And the user validates view and document label
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are there in the plan material section of benefits page
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
     # | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   | planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | name           | memberid   | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | 15366 | PDP      | Group_BnC  | NON LIS       | ENGLISH  | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         | BBBCCB FFAAFAD | 0191976081 | 01/01/2019    | Not Available  | Tier 2          | true        |


#TC21_MAPD_LIS(1,2)- Retail Drug Cost Table
 @benefitsAndCoverage23Indi @CMmapdindlis @BnC_Part7_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify PDF section is in place on Benefits and Coverage page for Lis user
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates Lis member plan overview section
      | Name            | <name>           |
      | Member ID       | <memberid>       |
      | Effective Date  | <effectivedate>  |
      | Monthly premium | <monthlypremium> |
      | Extra Help      | <extrahelp>      |
    And the user validates headers on Bnc page for indi members
      | Plan Type | <planType> |
  #  And the user validates the Primarycare Provider section
      | Plan Type | <planType> |
    And the user validates the Out of Pocket Max section
    And the user view the LIS Drug Copays & Discounts header
    And the user MAPD LIS should see drug cost table for Lis members
    And the user validates Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates Look Up Drugs button should be visible
      | Plan Type | <planType> |
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
      | Plan Type | <planType> |
    And the drugcost dropdown should not display
    And the user validates the Learn More section link for stage
    And the user validates tier link should not display
    And the user validates view and document label
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are there in the plan material section of benefits page
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
      | UnitedHealth Passport Program       | <UnitedHealthPassportProgram>     |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
      | Alternative Drug List               | <AlternativeDrugList>             |
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   | planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | UnitedHealthPassportProgram   | ComprehensiveFormularyDrug List     | AlternativeDrugList   | name       | memberid     | effectivedate | monthlypremium | extrahelp            |
      | 15245 | MAPD     | Individual_BnC | LIS 1         | ENGLISH  | Summary of Benefits | Evidence of Coverage | UnitedHealth Passport Program | Comprehensive Formulary - Drug List | Alternative Drug List | DBAD ADFED | 919744565-00 | 01/01/2019    | Not Available  | Extra Help Level : 1 |

  #TC22_NON LIS Ind plan member(MAPD)- Drug Cost table
  @benefitsAndCoverage14 @CMFedDrugNonLis @BnC_Part7_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -language: <language> - Verify all sections for Ind NonLIS member on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigate to Benefits and Coverage page
    And the user validates Ind plan overview
      | Name            | <name>           |
      | Member ID       | <memberid>       |
      | Effective Date  | <effectivedate>  |
      | Monthly premium | <monthlypremium> |
     And the user validates headers on Bnc page for indi members
      | Plan Type       | <planType>       |
   # And the user validates the Primarycare Provider section
      | Plan Type | <planType> |
    And the user validates the Out of Pocket Max section
    And the user view the Drug Copays & Discounts header
    And the Individual user validates Default drug cost drop down value
    And the indi MAPD user able to see drug table and values in it
    And the user validates the Learn More section for stage and tier
    And the user validates dropdown selection functionality
    And the user validates Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates Look Up Drugs button should be visible
      | Plan Type | <planType> |
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
      | Plan Type | <planType> |
    And the user should see drug copay and discount table
      | Updated Language | <UpdatedLanguage> |
      | Display Flag     | <DisplayFlag>     |
    And the user validates the user click on the link it expands and when user clicks it again it should collapse
    And the user validates view and document label
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are there in the plan material section of benefits page
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
      | UnitedHealth Passport Program       | <UnitedHealth Passport Program>   |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
      | Alternative Drug List               | <AlternativeDrug List>            |
    And the user select the documents language
      | Language | <language1> |
    And the user verifies that the correct pdfs are there in the plan material section of benefits page
      | Summary of Benefits                 | <SummaryofBenefitsSpanish>               |
      | Evidence of Coverage                | <EvidenceofCoverageSpanish>              |
      | UnitedHealth Passport Program       | <UnitedHealth Passport ProgramSpanish>   |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug ListSpanish> |
      | Alternative Drug List               | <AlternativeDrug ListSpanish>            |
    And the user select the documents language
      | Language | <language2> |
    And the user verifies that the correct pdfs are there in the plan material section of benefits page
      | Summary of Benefits                 | <SummaryofBenefitsChinies>               |
      | Evidence of Coverage                | <EvidenceofCoverageChinies>              |
      | UnitedHealth Passport Program       | <UnitedHealth Passport ProgramChinies>   |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug ListChinies> |
      | Alternative Drug List               | <AlternativeDrug ListChinies>            |
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section
    
   @devRegression
    Examples: 
      | TID   | planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | UnitedHealth Passport Program | ComprehensiveFormularyDrug List     | AlternativeDrug List  | language1 | SummaryofBenefitsSpanish | EvidenceofCoverageSpanish | UnitedHealth Passport ProgramSpanish | ComprehensiveFormularyDrug ListSpanish | AlternativeDrug ListSpanish        | language2 | SummaryofBenefitsChinies | EvidenceofCoverageChinies | UnitedHealth Passport ProgramChinies | ComprehensiveFormularyDrug ListChinies | AlternativeDrug ListChinies | name        | memberid     | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | 15378 | MAPD     | Individual_BnC | NON LIS       | ENGLISH  | Summary of Benefits | Evidence of Coverage | UnitedHealth Passport Program | Comprehensive Formulary - Drug List | Alternative Drug List | 1  | Resumen de Beneficios    | Comprobante de Cobertura  | Programa UnitedHealth Passport       | Formulario Completo                    | Lista de Medicamentos Alternativos | 2      |                          |                           |                                      |                                        |                             | DDCEE DAADF | 954016383-00 | 01/01/2018    | Not Available  | Tier 2          | true        |
  
  #TC22_NON LIS Ind plan member(PDP)- Drug Cost table
  @benefitsAndCoverage15 @CMFedPDPNonLis @BnC_Part8_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -language: <language> - Verify all sections for PDP Ind NonLIS member on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigate to Benefits and Coverage page
    And the user validates Ind plan overview
      | Name            | <name>           |
      | Member ID       | <memberid>       |
      | Effective Date  | <effectivedate>  |
      | Monthly premium | <monthlypremium> |
    And the user view the Drug Copays & Discounts header
    And the user validates Drug coverage header and text under the section
    And the user validates dropdown selection functionality
    And the user validates Default drug cost drop down value
    And the user validates the Learn More section for stage and tier
    And the user validates the user click on the link it expands and when user clicks it again it should collapse
    And the pdp lis user validates Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates Look Up Drugs button should be visible
      | Plan Type | <planType> |
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
      | Plan Type | <planType> |
    And the user should see drug copay and discount table
      | Updated Language | <UpdatedLanguage> |
      | Display Flag     | <DisplayFlag>     |
    And the PDP individual NON-LIS  user should see drug cost table for Lis members
    And the user validates view and document label
    And the user validates links for pdp in pdf section
      | Plan Type | <planType> |
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are there in the plan material section of benefits page
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
      | Alternative Drug List               | <AlternativeDrugList>             |
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   | planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | AlternativeDrugList   | name        | memberid   | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | 15377 | PDP      | Individual_BnC | NON LIS       | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | Alternative Drug List | ECADEA DCAA | 0197331001 | 05/01/2018    | Not Available  | Tier 2          | true        |


  @benefitsAndCoverage30  @hartfordprescriptionDrugBenefit @BnC_Part8_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify city of Hartford Prescription Drug Benefits
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates City of Hartford prescription Drug Benefits table

    Examples: 
      | TID   | planType | memberType   |
      | 15367 | MAPD     | Hartford_BnC |

  # | 15367 | PDP      | Hartford_BnC |
  @benefitsAndCoverage31 @TownOfGreenwichprescriptionDrugBenefit @BnC_Part8_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify town of greenwich Prescription Drug Benefits
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates Town Of Greenwich table

    Examples: 
      | TID   | planType | memberType    |
      | 15367 | MAPD     | Greenwich_BnC |
      
    @benefitsAndCoverage24 @CMpdpindlis @BnC_Part8_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify all sections for Ind LIS1 member on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates Lis member plan overview section
      | Name            | <name>           |
      | Member ID       | <memberid>       |
      | Effective Date  | <effectivedate>  |
      | Monthly premium | <monthlypremium> |
      | Extra Help      | <extrahelp>      |
    And the user validates headers on Bnc page for indi members
      | Plan Type | <planType> |
    And the user view the LIS Drug Copays & Discounts header
    And the user should see drug cost table for Lis members
    And the pdp lis user validates Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates Look Up Drugs button should be visible
      | Plan Type | <planType> |
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
      | Plan Type | <planType> |
    And the drugcost dropdown should not display
    And the user validates the Learn More section link for stage
    And the user validates tier link should not display
    #And the lis user validates the user click on the link it expands and when user clicks it again it should collapse
    And the user validates view and document label
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are coming in the plan material section
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
      | Alternative Drug List               | <AlternativeDrugList>             |
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   | planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | AlternativeDrugList   | name        | memberid   | effectivedate | monthlypremium | extrahelp            |
      | 15244 | PDP      | Individual_BnC | LIS 1         | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | Alternative Drug List | ECADEA DCAA | 0197331001 | 05/01/2018    | Not Available  | Extra Help Level : 1 |
    
      #TC22_NON LIS Ind Village_member_ Drug Cost table
  @benefitsAndCoverage18 @CMFedNonLisVillage  @BnC_Part8_regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Village nonLis member validates text in table
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigate to Benefits and Coverage page
    And the user validates Ind plan overview
      | Name            | <name>           |
      | Member ID       | <memberid>       |
      | Effective Date  | <effectivedate>  |
      | Monthly premium | <monthlypremium> |
    And the user validates Drug coverage header and text under the section
    And the user validates copay and CoInsurance section
    Then the Village user validates text in table
    Then user validates the Optum Rx link in Benefits and Coverage page

    Examples: 
      | TID   | planType | memberType     | copayCategory | name                | memberid     | effectivedate | monthlypremium |
      | 15367 | MAPDVill | Individual_BnC | NON LIS       | FDABEAAA  EAFDBEAAA | 973055947-00 | 01/01/2019    | Not Available  |  
      

 ###############################Regression Scenarios END Here ########################################
 
 
###############################Scenarios to be Removed ########################################

  ####Already covered as part of  benefitsAndCoverage15
  @benefitsAndCoverage17 @CMPdpFedTable @toBeRemoved
  Scenario Outline: Verify fed table data on Benefits and Coverage page for PDP nonLis member
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user able to see drug table for pdp and values in it

    Examples: 
      | TID   | planType | memberType     | copayCategory |
      | 15366 | PDP      | Individual_BnC | NON LIS       |

#####Already covered in E2e Scenarios
  @benefitsAndCoverage19 @CMvalidatePdfsectiongroupenglish @toBeRemoved
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify PDF section is in place on Benefits and Coverage page for nonLis member
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates view and document label
    And the user validates the language dropdown and the value displayed by default should be English
    And the user validates spanish and chinese should not display in dropdown

    Examples: 
      | TID   | planType | memberType | copayCategory |
      | 15368 | PDP      | Group_BnC  | NON LIS       |
      | 15246 | MAPD     | Group_BnC  | NON LIS       |
      | 15246 | MA       | Group_BnC  | NON LIS       |

 #####Already covered in  @benefitsAndCoverage21 
  @benefitsAndCoverage20 @CMAncillarysection1 @toBeRemoved
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify CMAncillarysection1 section is in place on Benefits and Coverage page for nonLis member
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    Then the user validates Header section
    Then the user validates Hearing section
    Then the user validates the Hearing Aid section
    Then the user validates the Vision section
    Then the user validates the Dental section
    Then the user validates chiropractic section

    Examples: 
      | TID   | planType | memberType | copayCategory |
      | 15238 | MAPD     | Group_BnC  | NON LIS       |
      | 15238 | MA       | Group_BnC  | NON LIS       |

 
#####Already covered in  @CMGroupmembersTC25  @CMGroupmembersPDPLIS_TC26
  @benefitsAndCoverage26 @CMGroupTable @toBeRemoved
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Group table data on Benefits and Coverage page for nonLis member
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user able to see table and values in it
      | Plan Type | <planType> |

    Examples: 
      | TID   | planType | memberType | copayCategory |
      | 15246 | MAPD     | Group_BnC  | NON LIS       |
      | 15246 | MAPDRX   | Group_BnC  | NON LIS       |
      
 #####Already covered in @benefitsAndCoverage27
  @benefitsAndCoverage28 @CMvasnegativescenario @toBeRemoved
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify that DisocuntServices section is visible on Benefits and coverage page for PDP nonLis member
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates the Vas section on benefits and coverage page is not displayed
    And the user should see drug copay and discount table
      | Updated Language | <UpdatedLanguage> |
      | Display Flag     | <DisplayFlag>     |
    And the user validates the user click on the link it expands and when user clicks it again it should collapse
    And the user validates view and document label
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are coming in the plan material section
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   | planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | name           | memberid   | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | 15241 | PDP      | Group_BnC  | NON LIS       | ENGLISH  | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         | BBBCCB FFAAFAD | 0191976081 | 01/01/2019    | Not Available  | Tier 2          | true        |

 #####Already covered in  @benefitsAndCoverage18 

  #note: Feature - F230250, User story -  US1410989
  @benefitsAndCoverage33 @optumRxWidget @Feb_release_2019 @toBeRemoved
  Scenario Outline: UID: <UID> -plan: <planType> -memberType: <memberType> - Verify link to Optum Rx in Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    Then user validates the Optum Rx link in Benefits and Coverage page

    Examples: 
      | UID     | planType | memberType     |
      | 1410989 | MAPDVill_BnC | Individual_BnC |
      
     @benefitsAndCoverage39 @UpdatedTextDocumentsAndResources @dec_release_2018 @toBeRemoved
  Scenario Outline: FID: <FID> -plan: <planType> -memberType: <memberType> - Verify updated text for Pdfs in Documents and Resources
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the UpdatedText

    Examples: 
      | FID    | planType | memberType                |
      | 231151 | MAPD     | IndividualUHCPayments_BnC |
      
        @benefitsAndCoverage43 @F276093 @Apr_release_2019 @toBeRemoved
  Scenario Outline: UserStory: <UID> -plan: <planType> -memberType: <memberType> - Verify Access your drug beneifts block for Univ. Of Kentucky Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the access your drug benefits block
    And the user validates the site leaving pop up and click cancel
    And the user validates the site leaving pop up and click proceed

    Examples: 
      | UID       | planType | memberType           |
      | US1615721 | MAPD     | Group_UnivOfKentucky |
############################### End of Scenarios to be Removed ########################################
  @benefitsAndCoverage34 @PlanBFSJMPLinks @Feb_release_2019 @gladiators
  Scenario Outline: UID: <UID> -plan: <planType> -Identifier: <Identifier> -rider: <rider> - Verify jump links for individual MAPD member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
      | Rider       | <rider>      |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    Then user verifies presence of jump links
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And user clicks on the jump links and checks respective sections
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And verifies links irrelevant to the plan type are not displayed
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | Count      | <count>      |
      | MemberType | <memberType> |

    Examples: 
      | UID     | planType | memberType     | Identifier         | language | count | rider   |
      | 1417780 | MAPD     | Individual_BnC | IndEffectiveAARP   | ENGLISH  |     6 | NoRider |
      | 1417780 | MAPD     | Individual_BnC | IndEffectiveAARP   | ENGLISH  |     7 | Rider   |
      | 1417780 | MAPD     | Group_BnC      | GrpEffectiveUHC    | ENGLISH  |     6 | NoRider |
      | 1417780 | MAPD     | Individual_BnC | IndEffectiveUHC    | ENGLISH  |     6 | NoRider |
      | 1417780 | MAPD     | Individual_BnC | IndEffectiveUHC    | ENGLISH  |     7 | Rider   |
      | 1417780 | PCP      | Individual_BnC | IndEffectivePCP    | ENGLISH  |     6 | NoRider |
      | 1417780 | MEDICA   | Individual_BnC | IndEffectiveMedica | ENGLISH  |     6 | NoRider |

  @benefitsAndCoverage35 @PlanBFSJMPLinks @Feb_release_2019 @gladiators
  Scenario Outline: UID: <UID> -plan: <planType> -Identifier: <Identifier> -rider: <rider> - Verify jump links for individual MA member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
      | Rider       | <rider>      |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    Then user verifies presence of jump links
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And user clicks on the jump links and checks respective sections
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And verifies links irrelevant to the plan type are not displayed
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | Count      | <count>      |
      | MemberType | <memberType> |

    Examples: 
      | UID     | planType | memberType     | Identifier       | language | count | rider   |
      | 1417780 | MA       | Group_BnC      | GrpEffectiveUHC  | ENGLISH  |     4 | NoRider |
      | 1417780 | MA       | Individual_BnC | IndEffectiveUHC  | ENGLISH  |     5 | Rider   |
      | 1417780 | MA       | Individual_BnC | IndEffectiveAARP | ENGLISH  |     5 | Rider   |
      | 1417780 | MA       | Individual_BnC | IndEffectiveAARP | ENGLISH  |     4 | NoRider |

  @benefitsAndCoverage36 @PlanBFSJMPLinks @Feb_release_2019 @gladiators
  Scenario Outline: UID: <UID> -plan: <planType> -Identifier: <Identifier> - Verify jump links for a MedSupp NoRider member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
      | Rider       | <rider>      |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    Then user verifies presence of jump links
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And user clicks on the jump links and checks respective sections
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And verifies links irrelevant to the plan type are not displayed
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | Count      | <count>      |
      | MemberType | <memberType> |

    Examples: 
      | UID     | planType | memberType     | Identifier           | language | count | rider   |
      | 1417780 | MedSupp  | Individual_BnC | EffectiveShipMedSupp | ENGLISH  |     3 | NoRider |

  @benefitsAndCoverage37 @PlanBFSJMPLinks @Feb_release_2019 @gladiators
  Scenario Outline: UID: <UID> -plan: <planType> -Identifier: <Identifier> - Verify jump links for individual PDP NoRider member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
      | Rider       | <rider>      |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    Then user verifies presence of jump links
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And user clicks on the jump links and checks respective sections
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And verifies links irrelevant to the plan type are not displayed
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | Count      | <count>      |
      | MemberType | <memberType> |

    Examples: 
      | UID     | planType | memberType     | Identifier       | language | count | rider   |
      | 1417780 | PDP      | Individual_BnC | EffectivePDPAARP | ENGLISH  |     4 | NoRider |
      | 1417780 | PDP      | Individual_BnC | EffectivePDPUHC  | ENGLISH  |     2 | NoRider |

  #| 1417780 | PDP      | Group      | EffectivePDPUHC | ENGLISH  | 4   | NoRider |
  @benefitsAndCoverage38 @PlanBFSJMPLinks @Feb_release_2019 @gladiators
  Scenario Outline: UID: <UID> -plan: <planType> -Identifier: <Identifier> - Verify jump links for a SSUP NoRider member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
      | Rider       | <rider>      |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    Then user verifies presence of jump links
      | Plan Type   | <planType>   |
      | Rider       | <rider>      |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
    And user clicks on the jump links and checks respective sections
      | Plan Type   | <planType>   |
      | Rider       | <rider>      |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
    And verifies links irrelevant to the plan type are not displayed
      | Plan Type   | <planType>   |
      | Rider       | <rider>      |
      | Count       | <count>      |
      | Member Type | <memberType> |

    Examples: 
      | UID     | planType | memberType | Identifier       | language | count | rider   |
      | 1417780 | SSUP     | Group_BnC  | GrpEffectiveSSUP | ENGLISH  |     4 | NoRider |



  @benefitsAndCoverage40 @F250386 @MedicalDeductibleCards @GroupNoDeductible @Mar_release_2019
  Scenario Outline: UserStory: <UID> -plan: <planType> -memberType: <memberType> - Verify Deductible cards for no deductible
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the deductible card for no deductible member

    Examples: 
      | UID       | planType      | memberType   |
      | US1564217 | MAGroup_BnC   | NoDeductible |
      | US1564217 | MAPDGroup_BnC | NoDeductible |

  @benefitsAndCoverage41 @F250386 @MedicalDeductibleCards @GroupSingleDeductible @Mar_release_2019
  Scenario Outline: UserStory: <UID> -plan: <planType> -memberType: <memberType> -Verify Deductible cards for Single deductible
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the deductible card for Single deductible member
      | DeductibleAmount1 | <deductible1> |

    Examples: 
      | UID       | planType      | memberType       | deductible1 |
      | US1564214 | MAGroup_BnC   | SingleDeductible | $185        |
      | US1564214 | MAPDGroup_BnC | SingleDeductible | $250        |

  @benefitsAndCoverage42 @F250386 @MedicalDeductibleCards @GroupDualDeductible @Mar_release_2019
  Scenario Outline: UserStory: <UID> -plan: <planType> -memberType: <memberType> - Verify Deductible cards for Dual deductible
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the deductible card for Dual deductible member
      | DeductibleAmount1 | <deductible1> |
      | DeductibleAmount2 | <deductible2> |

    Examples: 
      | UID       | planType     | memberType     | deductible1 | deductible2 |
      | US1564213 | MAGroup1_BnC | DualDeductible | $150        | $250        |
      | US1564213 | MAGroup2_BnC | DualDeductible | $1,364      | $185        |


