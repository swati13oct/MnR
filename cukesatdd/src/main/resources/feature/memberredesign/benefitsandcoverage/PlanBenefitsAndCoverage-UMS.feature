@benefitsAndCoverage @thePredators @codeMonkeys @regression_06_06_18
Feature: C1.1 To test plan benefits and Coverage on UMS site


  @benefitsAndCoverage1 @regressionMember @CMGroupmembersTC25 
  Scenario Outline: Verify Group LIS 3/4 on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user view the LIS Drug Copays & Discounts header
    And the user view the Drug Cost header and text
    And the drugcost dropdown should not display
    And the user validates the Learn More section link for stage
    And the user validates tier link should not display
    And the user validated the Look up Drugs link
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
      | Plan Type | <planType> |
    And the user should see drug cost table for Lis members
    And the user validates view and document label
    And the user validates spanish and chinese should not display in dropdown
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | planType | memberType | copayCategory |
      | MAPD     | Group      | LIS 4         |

  @benefitsAndCoverage2 @regressionMember @CMGroupmembersPDPLIS_TC26 
  Scenario Outline: Verify Group LIS 1/2 values on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigate to Benefits and Coverage page
    And the user view the LIS Drug Copays & Discounts header
    And the user view the Drug Cost header and text
    And the drugcost dropdown should not display
    And the user validates the Learn More section link for stage
    And the user validates tier link should not display
    And the user validated the Look up Drugs link
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
          | Plan Type      | <planType>      |
    And the user should see drug cost table for Lis members
    And the user validates view and document label
    And the user validates spanish and chinese should not display in dropdown
    And the user validates Needhelp header
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | planType | memberType | copayCategory |
      | PDP      | Group_BnC  | LIS 1         |


  @benefitsAndCoverage3 @BenefitsforTexasERSMember @regression @regressionMember
  Scenario Outline: Verify the Benefits for TexasERSMember
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Drug costs Section
    Then the user verifies the Retail Cost sharing table
    Then the user verifies the Mail Order Cost sharing table

    Examples: 
      | planType | memberType        |
      | PDP      | TEXASERSGroup_BnC |

  @benefitsAndCoverage4 @OfficeVisitswithoutprovidertiering @regression @regressionMember
  Scenario Outline: Verify the Office visits widget for a member withoutprovidertiering
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Office Visits section

    Examples: 
      | planType | memberType                       |
      | MAPD     | memberWithoutProviderTiering_BnC |

  @benefitsAndCoverage5 @WaystoSaveforPdp @regression @regressionMember
  Scenario Outline: Verify the ways to save  widget for a PDP member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the ways to save section

    Examples: 
      | planType | memberType             |
      | PDP      | Wallgreens_BnC         |
      | PDP      | MailOrderPharamacy_BnC |
      | MAPD     | withoutWaysToSave_BnC  |

  @benefitsAndCoverage6 @outpatientcenterwithprovidertier @thepredators @regressionoutpatient @regressionMember
  Scenario Outline: Verify the outpatient widget for a member withprovidertiering
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Outpatient Surgery Center Visits section

    Examples: 
      | planType | memberType     |
      | MAPD     | MAPDCOSMOS_BnC |

  @benefitsAndCoverage7 @primarycareproviderspecialist @thepredators @regressionprimarycareprovider @regressionMember
  Scenario Outline: Verify the Office visits widget for a member withprovidertiering
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And user validates the Office Visits section widgets

    Examples: 
      | planType | memberType            |
      | MAPD     | COSMOSOfficevisit_BnC |

  @benefitsAndCoverage8 @outpatientcenterwithoutprovidertier @thepredators @regressionoutpatientwithoutprovider @regressionMember
  Scenario Outline: Verify the outpatient widget for a member withoutprovidertiering
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Outpatient Surgery Center Visits section

    Examples: 
      | planType | memberType       |
      | MAPD     | NICEBenefits_BnC |

  @benefitsAndCoverage9 @BenefitsForAlPeehipMember @regression @regressionMember
  Scenario Outline: Verify the benefits for an AL peehip member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Benefits for Peehip member

    Examples: 
      | planType | memberType |
      | Peehip   | Group_BnC      |

  @benefitsAndCoverage10 @BenefitsForMAMedsupSSUPMember @regression @regressionMember
  Scenario Outline: Verify the Benefits for a  MA Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Benefits for MA member
      | Plan Type   | <planType>   |

    Examples: 
      | planType | memberType     |
      | MA       | Individual_BnC |
      | SSUP     | Group_BnC      |
      
  @benefitsAndCoverage11 @CopayCoinsuranceInDrugCostTable @regression @regressionMember
  Scenario Outline: Verify the copay coinsurance in drugcosts table
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the copay coinsurance in drug costs table

    Examples: 
      | planType | memberType      |
      | MAPD     | Individual_BnC2 |


  @benefitsAndCoverage12 @BenefitsForCombo @regression @regressionMember 
  Scenario Outline: Verify the Benefits for a combo member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the benefits for a combo member

    Examples: 
      | planType | memberType       |
      | Combo    | MAPDANDSHIP_BnC2 |

  # note: Due to timing that it takes for GPS to do the update (add or remove), 
  # this testcase result will not be stable. Since can't predict time for GPS to finish the update, 
  # so the add or remove button does't always show up within the time the code expects it to.
  @benefitsAndCoverage13 @BenefitsRiderFunctionality @regression @regressionMember
  Scenario Outline: Verify the Benefits for a combo member with Rider
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Add Rider functionality
    Then the user validates the remove Rider functionality

    Examples: 
      | planType | memberType |
      | MAPD     | withRider  |
      

  @benefitsAndCoverage14 @CMFedDrugNonLis
  Scenario Outline: Verify all sections for Ind NonLIS member on Benefits and Coverage page
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
      | Plan Type | <planType> |
    And the user validates the Primarycare Provider section
      | Plan Type | <planType> |
    And the user validates the Out of Pocket Max section
    And the user view the Drug Copays & Discounts header
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
    And the user verifies that the correct pdfs are there in the plan material section
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
       |Alternative Drug List | <AlternativeDrug List> |
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | planType | memberType      | copayCategory | language | SummaryofBenefits    | EvidenceofCoverage       | ComprehensiveFormularyDrug List     | AlternativeDrug List               | name                 | memberid     | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | MAPD     | Individual_BnC  | NON LIS       | ENGLISH  | Summary of Benefits  | Evidence of Coverage     | Comprehensive Formulary - Drug List | Alternative Drug List              | DDCEE DAADF          | 954016383-00 | 01/01/2018    | Not Available  | Tier 2          | true        |
      | MAPD     |  Individual_BnC |  NON LIS      | ESPAÑOL  | Resumen de Beneficios| Comprobante de Cobertura | Formulario Completo                 | Lista de Medicamentos Alternativos | DDCEE DAADF          | 954016383-00 | 01/01/2018    | Not Available  | Tier 2          | true       |
      | MAPD     |  Individual_BnC |  NON LIS      | 中文             |                      |                          |                                     |                                    | DDCEE DAADF          | 954016383-00 | 01/01/2018    | Not Available  | Tier 2          | true       |
      | Medica   |  Individual_BnC |  NON LIS      | ENGLISH  | Summary of Benefits  | Evidence of Coverage     | Comprehensive Formulary - Drug List | Alternative Drug List              | AADECDC FEDFACEDBACBB| 954283936-00 | 04/01/2018    | Not Available  | Tier 2          | true       |
      | Medica   |  Individual_BnC |  NON LIS      | ESPAÑOL  | Resumen de Beneficios| Comprobante de Cobertura | Formulario Completo                 | Lista de Medicamentos Alternativos | AADECDC FEDFACEDBACBB| 954283936-00 | 04/01/2018    | Not Available  | Tier 2          | true       |
      | PCP      |  Individual_BnC |  NON LIS      | ENGLISH  | Summary of Benefits  | Evidence of Coverage     | Comprehensive Formulary - Drug List | Alternative Drug List              | BDFAEC CBADEADF      | 945007888-00 | 01/01/2018    | Not Available  | Tier 2          | true       |
      | PCP      |  Individual_BnC |  NON LIS      | ESPAÑOL  | Resumen de Beneficios| Comprobante de Cobertura | Formulario Completo                 | Lista de Medicamentos Alternativos | BDFAEC CBADEADF      | 945007888-00 | 01/01/2018    | Not Available  | Tier 2          | true       |
      
  @benefitsAndCoverage15 @CMFedPDPNonLis 
  Scenario Outline: Verify all sections for PDP Ind NonLIS member on Benefits and Coverage page
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
    And the user view the Drug Copays & Discounts header
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
    And the user validates links for pdp in pdf section
      | Plan Type | <planType> |
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are there in the plan material section
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
      | Alternative Drug List               |  <AlternativeDrugList>            | 
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | planType | memberType     | copayCategory | language | SummaryofBenefits     | EvidenceofCoverage       | ComprehensiveFormularyDrug List     | AlternativeDrugList                | name       | memberid  | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | PDP      | Individual_BnC | NON LIS       | ENGLISH  | Summary of Benefits   | Evidence of Coverage     | Comprehensive Formulary - Drug List | Alternative Drug List              | ECADEA DCAA| 0197331001| 05/01/2018    | Not Available  | Tier 2          | true        |
      | PDP      | Individual_BnC | NON LIS       | ESPAÑOL  | Resumen de Beneficios | Comprobante de Cobertura | Formulario Completo                 | Lista de Medicamentos Alternativos | ECADEA DCAA| 0197331001| 05/01/2018    | Not Available  | Tier 2          | true        |
      | PDP      | Individual_BnC | NON LIS       | 中文             |                       |                          |                                     |                                    | ECADEA DCAA| 0197331001| 05/01/2018    | Not Available  | Tier 2          | true        |


  @benefitsAndCoverage16 @CMMapdFedTable
  Scenario Outline: Verify fed table data on Benefits and Coverage page for MAPD user
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user able to see drug table for fed and values in it

    Examples:  
      | planType | memberType     | copayCategory |
      | MAPD     | Individual_BnC | NON LIS       |


  @benefitsAndCoverage17 @CMPdpFedTable 
  Scenario Outline: Verify fed table data on Benefits and Coverage page for PDP user
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user able to see drug table for pdp and values in it

    Examples: 
      | planType | memberType     | copayCategory |
      | PDP      | Individual_BnC | NON LIS       |


  @benefitsAndCoverage18 @CMFedNonLisVillage 
  Scenario Outline: Verify the Village user validates text in table
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    Then the Village user validates text in table

    Examples: 
      | planType | memberType | copayCategory |
      | MAPDVill | Individual_BnC | NON LIS       |


  @benefitsAndCoverage19 @CMvalidatePdfsectiongroupenglish 
  Scenario Outline: Verify PDF section is in place on Benefits and Coverage page
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
      | planType | memberType | copayCategory |
      | PDP      | Group_BnC  | NON LIS       |
      | MAPD     | Group_BnC  | NON LIS       |
      | MA       | Group      | NON LIS       |


  @benefitsAndCoverage20 @CMAncillarysection1 
  Scenario Outline: Verify CMAncillarysection1 section is in place on Benefits and Coverage page
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
      | planType | memberType | copayCategory |
      | MAPD     | Group_BnC  | NON LIS       |
      | MA       | Group_BnC  | NON LIS       |


  @benefitsAndCoverage21 @CMAncillarysection2
  Scenario Outline: Verify CMAncillarysection2 section is in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
   Then user validates and clicks on Disclaimers link under Exclusive hearing
    Then user validates and clicks on Learn More button under Exclusive hearing section
    And user validates the Leaving  popup
    Then user validates and click on Cancel button
    Then user validates and clicks on Proceed button and navigate to heathnavigationpage

    Examples: 
      | planType | memberType | copayCategory |
      | MA       | Group      | NON LIS       |
      | MAPD     | Group_BnC  | NON LIS       |


  @benefitsAndCoverage22 @CMShip 
  Scenario Outline: Verify that Page Headers are in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates plan overview and summary on Bnc page for ship members
    And the user validates hand image under discount and services section
    And the user validates the Vas section on benefits and coverage page
    And the user validates additional information on Bnc page for ship members
    And the user validate Value Add Service page on clicking additional info button
    And the user validates view and document label
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are coming in the plan material section
      | Plan Benefits Table | <PlanBenefitsTable> |
      | Plan Overview       | <PlanOverview>      |
    And the user validates ship the need help section
    And the user validates for ship see more ways to contact us section
    And the user validates for ship member on clicking contact us link it should route to contact us page
    And the user clicks on More Information link for ship
    Then the user validate Value Add Service page comes on clicking additional info button
    And the user validate vas tiles on vas page

    Examples: 
      | planType | memberType | language | PlanBenefitsTable   | PlanOverview  |
      | HIP      | SHIP       | ENGLISH  | Plan Benefits Table | Plan Overview |


  @benefitsAndCoverage23 @CMmapdindlis 
  Scenario Outline: Verify PDF section is in place on Benefits and Coverage page
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
    And the user validates the Primarycare Provider section
      | Plan Type | <planType> |
    And the user validates the Out of Pocket Max section
    And the user view the LIS Drug Copays & Discounts header
    And the user should see drug cost table for Lis members
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
    And the user verifies that the correct pdfs are there in the plan material section
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
      | Alternative Drug List               |  <AlternativeDrugList>            | 
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | AlternativeDrugList   | name            | memberid     | effectivedate | monthlypremium | extrahelp            |
      | MAPD     | Individual_BnC | LIS 1         | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | Alternative Drug List | DBAD ADFED      | 919744565-00 | 01/01/2019    | Not Available  | Extra Help Level : 1 |


  @benefitsAndCoverage24 @CMpdpindlis
  Scenario Outline: Verify all sections for Ind LIS1 member on Benefits and Coverage page
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
      | Alternative Drug List               |  <AlternativeDrugList>            | 
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | AlternativeDrugList    | name        | memberid     | effectivedate | monthlypremium | extrahelp            |
      | PDP      | Individual_BnC | LIS 1         | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | Alternative Drug List  | ECADEA DCAA | 0197331001   | 05/01/2018    | Not Available  | Extra Help Level : 1 |


  @benefitsAndCoverage25 @CMMapdGroupNonLis
  Scenario Outline: Verify all sections for Group NonLIS member on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates plan overview section for group
    And the user validates headers on Bnc page for group members
    And the user validates the Group Primarycare Provider section
    And the user view the Drug Copays & Discounts header
    And the user validates the Learn More section for stage and tier
    And the user validates dropdown selection functionality
    And the user validates plan overview section for group
    And the user validates headers on Bnc page for group members
    And the user view the Drug Copays & Discounts header
    And the user validates the Learn More section for stage and tier
    And the user validates dropdown selection functionality
    And the user validates group Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates group Look Up Drugs button should be visible
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
    And the user verifies that the correct pdfs are coming in the plan material section
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | name             | memberid     | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | MAPD     | Group_BnC  | NON LIS       | ENGLISH  | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         | EFADDB CDEEFFCDC | 978095497-00 | 01/01/2018    | Not Available  | Tier 2          | true        |


  @benefitsAndCoverage26 @CMGroupTable
  Scenario Outline: Verify Group table data on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user able to see table and values in it
      | Plan Type | <planType> |

    Examples: 
      | planType | memberType | copayCategory |
      | MAPD     | Group_BnC  | NON LIS       |
      | MAPDRX   | Group      | NON LIS       |


  @benefitsAndCoverage27 @CMPDPGroupNonLis
  Scenario Outline: Verify all sections for PDP Group NonLIS member on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates plan overview section for group
    And the user view the Drug Copays & Discounts header
    And the user validates the Learn More section for stage and tier
    And the user validates dropdown selection functionality
    And the user validates text for the Look Up Drugs section
    And the user view the Drug Copays & Discounts header
    And the user validates the Learn More section for stage and tier
    And the user validates dropdown selection functionality
    And the user validates group Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates group Look Up Drugs button should be visible
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
    And the user verifies that the correct pdfs are coming in the plan material section
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | name            | memberid      | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | PDP      | Group_BnC  | NON LIS       | ENGLISH  | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         | BBBCCB FFAAFAD  | 0191976081    | 01/01/2019    | Not Available  | Tier 2          | true        |


  @benefitsAndCoverage28 @CMvasnegativescenario
  Scenario Outline: Verify that DisocuntServices section is visible on Benefits and coverage page for PDP user
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
      | planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | name            | memberid      | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | PDP      | Group_BnC  | NON LIS       | ENGLISH  | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         | BBBCCB FFAAFAD  | 0191976081    | 01/01/2019    | Not Available  | Tier 2          | true        |


  @benefitsAndCoverage29 @CMvasnegativescenario
  Scenario Outline: Verify that DiscountServices section is visible on Benefits and coverage page for MAPD user
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
   Then The user navigates to Benefits and Coverage page
      | Plan Type      | <planType>      |
    And the user validates the Vas section on benefits and coverage page is not displayed

    Examples: 
      | planType | memberType     | copayCategory |
      | MAPD     | Individual_BnC | NON LIS       |
      | MA       | Group          | NON LIS       |


  @benefitsAndCoverage30 @thePredators @juneRelease2018 @hartfordprescriptionDrugBenefit
  Scenario Outline: Verify city of Hartford Prescription Drug Benefits
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type   | <planType>   |
    And the user validates City of Hartford prescription Drug Benefits table

    Examples: 
      | planType | memberType   |
      | MAPD     | Hartford_BnC |
    # | PDP      | Hartford_BnC |


  @benefitsAndCoverage31 @thePredators @juneRelease2018 @TownOfGreenwichprescriptionDrugBenefit 
  Scenario Outline: Verify town of greenwich Prescription Drug Benefits
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type   | <planType>   |
    And the user validates Town Of Greenwich table

    Examples: 
      | planType | memberType    |
      | PDP      | Greenwich_BnC |


  @benefitsAndCoverage32 @ancillarybenefitnegativescenarioscodemonkeys
  Scenario Outline: Verify ancillary benefits are not displayed other than Group memnbers
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    Then verify ancillary benefit section is not displayed

    Examples: 
      | planType | memberType | copayCategory |
      | PDP      |  Group_BnC | NON LIS       |
      | MAPD     | Individual_BnC | NON LIS       |
 

  @benefitsAndCoverage33 @optumRxWidget @Feb_release_2019 
  Scenario Outline: Verify link to Optum Rx in Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    Then user validates the Optum Rx link in Benefits and Coverage page

    Examples: 
      | planType | memberType     |
      | MAPDVill | Individual_BnC |
      

  @benefitsAndCoverage34 @PlanBFSJMPLinks @Feb_release_2019 @gladiators
  Scenario Outline: Verify jump links for individual MAPD member
    Given login with following details logins in the member portal and validate elements
      | Plan Type  | <planType>   |
      | Member Type| <memberType> |
      | identifier | <Identifier> |
      | Rider      | <rider>      |
    Then The user navigates to Benefits and Coverage page
      | Plan Type  | <planType>   |
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
       | planType | memberType |Identifier        | language | count| rider   |
       | MAPD     | Individual |IndEffectiveAARP  | ENGLISH  | 6    | NoRider |
       | MAPD     | Individual |IndEffectiveAARP  | ENGLISH  | 7    | Rider   |
       | MAPD     | Group      |GrpEffectiveUHC   | ENGLISH  | 6    | NoRider |
       | MAPD     | Individual |IndEffectiveUHC   | ENGLISH  | 6    | NoRider |
       | MAPD     | Individual |IndEffectiveUHC   | ENGLISH  | 7    | Rider   |
       | PCP      | Individual |IndEffectivePCP   | ENGLISH  | 6   |NoRider|
       | MEDICA   | Individual |IndEffectiveMedica| ENGLISH  | 6   |NoRider|
         
  
  @benefitsAndCoverage35 @PlanBFSJMPLinks @Feb_release_2019 @gladiators
  Scenario Outline: Verify jump links for individual MA member
    Given login with following details logins in the member portal and validate elements
      | Plan Type  | <planType>   |
      | Member Type| <memberType> |
      | identifier | <Identifier> |
      | Rider      | <rider>      |
    Then The user navigates to Benefits and Coverage page
      | Plan Type  | <planType>   |
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
      | planType | memberType | Identifier       | language | count | rider   |
      | MA       | Group      | GrpEffectiveUHC  | ENGLISH  | 4     | NoRider |
      | MA       | Individual | IndEffectiveUHC  | ENGLISH  | 5     | Rider   |
      | MA       | Individual | IndEffectiveAARP | ENGLISH  | 5     | Rider   |
      | MA       | Individual | IndEffectiveAARP | ENGLISH  | 4     | NoRider |
      
       
  @benefitsAndCoverage36 @PlanBFSJMPLinks @Feb_release_2019 @gladiators
  Scenario Outline: Verify jump links for a MedSupp member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
      | Rider       | <rider>      |
    Then The user navigates to Benefits and Coverage page
      | Plan Type   | <planType>   |
    Then user verifies presence of jump links
      | Plan Type   | <planType>   |
      | Rider       | <rider>      |
      | MemberType  | <memberType> |
      | identifier  | <Identifier> |
    And user clicks on the jump links and checks respective sections
      | Plan Type   | <planType>   |
      | Rider       | <rider>      |
      | MemberType  | <memberType> |
      | identifier  | <Identifier> |
    And verifies links irrelevant to the plan type are not displayed
      | Plan Type   | <planType>   |
      | Rider       | <rider>      |
      | Count       | <count>      |
      | MemberType  | <memberType> |
      
   Examples: 
      | planType | memberType | Identifier           | language | count | rider   |
      | MedSupp  | Individual | EffectiveShipMedSupp | ENGLISH  | 3     | NoRider |

      
  @benefitsAndCoverage37 @PlanBFSJMPLinks @Feb_release_2019 @gladiators
  Scenario Outline: Verify jump links for individual PDP member
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      |identifier|<Identifier>|
      |Rider|<rider>|
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    Then user verifies presence of jump links
      | Plan Type | <planType> |
      |Rider|<rider>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
    And user clicks on the jump links and checks respective sections
      | Plan Type | <planType> |
      |Rider|<rider>|
      |MemberType|<memberType>|
      |identifier|<Identifier>|
    And verifies links irrelevant to the plan type are not displayed
      | Plan Type | <planType> |
      |Rider|<rider>|
      |Count|<count>|
      |MemberType|<memberType>|
      
   Examples: 
      | planType | memberType | Identifier      | language |count| rider   |
      | PDP      | Individual | EffectivePDPAARP| ENGLISH  | 4   | NoRider |
      | PDP      | Individual | EffectivePDPUHC | ENGLISH  | 2   | NoRider |
     #| PDP      | Group      | EffectivePDPUHC | ENGLISH  | 4   | NoRider |

    
  @benefitsAndCoverage38 @PlanBFSJMPLinks @Feb_release_2019 @gladiators
  Scenario Outline: Verify jump links for a SSUP member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      |identifier   | <Identifier> |
      |Rider        | <rider>      |
    Then The user navigates to Benefits and Coverage page
      | Plan Type   | <planType>   |
    Then user verifies presence of jump links
      | Plan Type   | <planType>   |
      | Rider       | <rider>      |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
    And user clicks on the jump links and checks respective sections
      | Plan Type   | <planType>   |
      | Rider       | <rider>      |
      | Member Type | <memberType> |
      |identifier   | <Identifier> |
    And verifies links irrelevant to the plan type are not displayed
      | Plan Type   | <planType>   |
      | Rider       | <rider>      |
      | Count       | <count>      |
      | Member Type | <memberType> |
      
   Examples: 
      | planType | memberType | Identifier       | language | count | rider   |
      | SSUP     | Group      | GrpEffectiveSSUP | ENGLISH  | 4     | NoRider |


  @benefitsAndCoverage39 @UpdatedTextDocumentsAndResources @dec_release_2018
  Scenario Outline: Verify updated text for Pdfs in Documents and Resources
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the UpdatedText

   Examples: 
      | planType | memberType            |
      | MAPD     | IndividualUHCPayments |
      
      