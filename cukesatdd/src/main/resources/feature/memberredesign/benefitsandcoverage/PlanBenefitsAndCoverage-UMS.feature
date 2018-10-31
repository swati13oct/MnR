@codeMonkeys @regression_06_06_18 @thePredators
Feature: C1.1 To test plan benefits and Coverage on UMS site

  @CMFedDrugNonLis
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
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | name        | memberid     | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | MAPD     | Individual | NON LIS       | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | DDCEE DAADF | 954016383-00 | 01/01/2018    | Not Available  | Tier 2          | true        |
      | MAPD    |  Individual  |  NON LIS      | ESPAÃOL  | Resumen de Beneficios| Comprobante de Cobertura | Formulario Completo                 | DDCEE DAADF | 954016383-00 | 01/01/2018    | Not Available  | Tier 2            | true       |
      | MAPD    |  Individual  |  NON LIS      | ä¸­æ  |                      |                          |                                     | DDCEE DAADF | 954016383-00 | 01/01/2018    | Not Available  | Tier 2            | true       |
      | Medica  |  Individual  |  NON LIS      | ENGLISH  | Summary of Benefits  | Evidence of Coverage     | Comprehensive Formulary - Drug List | AADECDC FEDFACEDBACBB|954283936-00    | 04/01/2018    | Not Available  | Tier 2            | true       |
      | Medica  |  Individual  |  NON LIS      | ESPAÃOL  | Resumen de Beneficios| Comprobante de Cobertura | Formulario Completo                 | AADECDC FEDFACEDBACBB|954283936-00    | 04/01/2018    | Not Available  | Tier 2            | true       |
      | PCP     |  Individual  |  NON LIS      | ENGLISH  | Summary of Benefits  | Evidence of Coverage     | Comprehensive Formulary - Drug List | BDFAEC CBADEADF|945007888-00 | 01/01/2018 | Not Available  | Tier 2            | true       |
      | PCP     |  Individual  |  NON LIS      | ESPAÃOL  | Resumen de Beneficios| Comprobante de Cobertura | Formulario Completo                 | BDFAEC CBADEADF|945007888-00 | 01/01/2018 | Not Available  | Tier 2            | true       |
  @CMFedPDPNonLis
  Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
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
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | planType | memberType | copayCategory | language | SummaryofBenefits     | EvidenceofCoverage       | ComprehensiveFormularyDrug List     | name      | memberid   | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
   		 | PDP      | Individual | NON LIS       | ENGLISH  | Summary of Benefits   | Evidence of Coverage     | Comprehensive Formulary - Drug List | EACBD BEF | 0182297421 | 01/01/2017    | Not Available  | Tier 2          | true        |
      | PDP      | Individual | NON LIS       | ESPAÃOL  | Resumen de Beneficios | Comprobante de Cobertura | Formulario Completo                 | EACBD BEF | 0182297421 | 01/01/2017    | Not Available  | Tier 2          | true        |
     | PDP      | Individual | NON LIS       | ä¸­æ  |                       |                          |                                     | EACBD BEF | 0182297421 | 01/01/2017    | Not Available  | Tier 2          | true        |

  @CMMapdFedTable
  Scenario Outline: Verify fed table data on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user able to see drug table for fed and values in it

    Examples: 
      | planType | memberType | copayCategory |
      | MAPD     | Individual | NON LIS       |

  @CMPdpFedTable
  Scenario Outline: Verify fed table data on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user able to see drug table for pdp and values in it

    Examples: 
      | planType | memberType | copayCategory |
      | PDP      | Individual | NON LIS       |

  @CMFedNonLisVillage
  Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    Then the user validates text in table

    Examples: 
      | planType | memberType | copayCategory |
      | MAPDVill | Individual | NON LIS       |

  @CMvalidatePdfsectiongroupenglish
  Scenario Outline: Verify PDF section is in place on Benefits and     Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates view and document label
    And the user validates the language dropdown and the value displayed by default should be English

    Examples: 
      | planType | memberType | copayCategory |
      | PDP      | Group      | NON LIS       |
      | MAPD     | Group      | NON LIS       |
      | MA       | Group      | NON LIS       |

  @CMvalidatePdfsectiongroupspanishchinese
  Scenario Outline: Verify PDF section is in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates view and document label
    And the user validates spanish and chinese should not display in dropdown

    Examples: 
      | planType | memberType | copayCategory |
      | PDP      | Group      | NON LIS       |
      | MAPD     | Group      | NON LIS       |
      | MA       | Group      | NON LIS       |

  @CMAncillarysection1
  Scenario Outline: Verify Ancilliary section is in place on Benefits and Coverage page
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
      | MAPD     | Group      | NON LIS       |
      | MA       | Group      | NON LIS       |

  @CMAncillarysection2
  Scenario Outline: Verify Ancilliary section is in place on Benefits and Coverage page
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
      | MAPD     | Group      | NON LIS       |

  @regression_06_06_18 @CMPlanOverviewIndividualNonLisPDP
  Scenario Outline: Verify that Plan Overview  is in place on Benefits and Coverage page for Non LIS Members
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
    And the user validates Ind plan overview  section

    Examples: 
      | planType | memberType | copayCategory |
      | PDP      | Individual | NON LIS       |

  @regression_06_06_18 @CMGroupmembersTC25
  Scenario Outline: Verify Group LIS 3/4 on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then user navigates to Benefits coverage page
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
    And the user view the LIS Drug Copays & Discounts header
    And the user view the Drug Cost header and text
    And the drugcost dropdown should not display
    And the user validates the Learn More section link for stage
    And the user validates tier link should not display
    And the user validated the Look up Drugs link
    And the user validates text for the Locate a Pharmacy section
    And user validates Locate a Pharmacy button should be visible
      | Plan Type | <na> |
    And the user validates Locate a Pharmacy button should be visible
    And the user should see drug cost table for Lis members
    And the user validates view and document label
    And the user validates spanish and chinese should not display in dropdown
    And the user validates Needhelp header
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | planType | memberType | copayCategory |
      | MAPD     | Group      | LIS 4         |

  @regression_06_06_18 @CMGroupmembersPDPLIS_TC26
  Scenario Outline: Verify Group LIS 1/2 values on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then the user navigates to Benefits coverage page
    And the user view the LIS Drug Copays & Discounts header
    And the user view the Drug Cost header and text
    And the drugcost dropdown should not display
    And the user validates the Learn More section link for stage
    And the user validates tier link should not display
    And the user validated the Look up Drugs link
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
    And the user should see drug cost table for Lis members
    And the user validates view and document label
    And the user validates spanish and chinese should not display in dropdown
    And the user validates Needhelp header
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | planType | memberType | copayCategory |
      | PDP      | Group      | LIS 1         |

  @regression_06_06_18 @CMPlanOverviewIndividualLEP
  Scenario Outline: Verify that LEP amount & Payment Due is in place on Benefits and Coverage page for Non LIS Members
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates Ind plan overview LEP amount and payment due

    Examples: 
      | planType | memberType | copayCategory |
      | MAPD     | Individual | NON LIS       |

  @CMShip
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
    And the user verifies that the correct pdfs are coming in the plan material section for ship
      | Plan Benefits Table | <PlanBenefitsTable> |
      | Plan Overview       | <PlanOverview>      |
    And the user validates ship the need help section
    And the user validates for ship see more ways to contact us section
    And the user validates for ship member on clicking contact us link it should route to contact us page
    And the user clicks on More Information link for ship

    Examples: 
      | planType | memberType | language | PlanBenefitsTable   | PlanOverview  |
      | HIP      | SHIP       | ENGLISH  | Plan Benefits Table | Plan Overview |

  @CMShipVAS
  Scenario Outline: Verify that Page Headers are in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    Then the user validate Value Add Service page comes on clicking additional info button
    And the user validate vas tiles on vas page

    Examples: 
      | planType | memberType |
      | HIP      | SHIP       |

  @aprilRelease2018Fnf @regressiontestcase-ATDDtags
  Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    When The user navigates to Benefits and Coverage page
    And the user can see the values for catastrophic values

    Examples: 
      | planType | memberType | copayCategory |
      | MAPD     | Group      | wotCMSValue   |

  @fastandfurious @regressiontestcase-ATDDtags @aprilRelease2018 @CatastrophicStageLanguage
  Scenario Outline: Verify Updated Language in Catastrophic Coverage Stage for Drug Copays and Discounts in Redesign site
    Given registered Redesign member for EOB with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    And the user navigates to Benefits and Coverage page
    Then the user validates Catastrophic Stage language for the member
      | Updated Language | <UpdatedLanguage> |
      | Display Flag     | <DisplayFlag>     |

    Examples: 
      | planType | memberType    | UpdatedLanguage                                    | DisplayFlag |
      | PDP      | Group_LIS     | -either- coinsurance of 5% of the cost of the drug | false       |
      | MAPD     | Group_Non_LIS | -either- coinsurance of 5% of the cost of the drug | true        |
      | PDP      | Group_Non_LIS | -either- coinsurance of 5% of the cost of the drug | false       |

  @CMmapdindlis
  Scenario Outline: Verify PDF section is in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
    And the user validates Lis member plan overview section
      | Name            | <name>           |
      | Member ID       | <memberid>       |
      | Effective Date  | <effectivedate>  |
      | Monthly premium | <monthlypremium> |
      | Extra Help      | <extrahelp>      |
    And the user validates headers on Bnc page for indi members
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
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | name            | memberid     | effectivedate | monthlypremium | extrahelp            |
      | MAPD     | Individual | LIS           | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | DABDCAE CFCFFCF | 910114420-00 | 01/01/2018    | Not Available  | Extra Help Level : 1 |

  @CMpdpindlis
  Scenario Outline: Verify PDF section is in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
    And the user validates Lis member plan overview section
      | Name            | <name>           |
      | Member ID       | <memberid>       |
      | Effective Date  | <effectivedate>  |
      | Monthly premium | <monthlypremium> |
      | Extra Help      | <extrahelp>      |
    And the user validates headers on Bnc page for indi members
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
    And the lis user validates the user click on the link it expands and when user clicks it again it should collapse
    And the user validates view and document label
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    And the user verifies that the correct pdfs are there in the plan material section
      | Summary of Benefits                 | <SummaryofBenefits>               |
      | Evidence of Coverage                | <EvidenceofCoverage>              |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | name            | memberid     | effectivedate | monthlypremium | extrahelp            |
      | PDP      | Individual | LIS           | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | DABDCAE CFCFFCF | 910114420-00 | 01/01/2018    | Not Available  | Extra Help Level : 1 |

  @CMMapdGroupNonLis
  Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
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
      | planType | memberType | copayCategory | language | SummaryofBenefits   | Evidenceof Coverage  | ComprehensiveFormularyDrug List     | name          | memberid     | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | MAPD     | Group      | NON LIS       | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | EACD BEBFFFAF | 921836941-00 | 08/01/2018    | Not Available  | Tier 2          | true        |

  @CMGroupTable
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
      | MAPD     | Group      | NON LIS       |
      | MAPDRX   | Group      | NON LIS       |

  @TableTest
  Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validate table

    Examples: 
      | planType | memberType | copayCategory |
      | MAPD     | Group      | NON LIS       |

  @CMPDPGroupNonLis
  Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
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
      | planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | name            | memberid    | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | PDP      | Group      | NON LIS       | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | DDCCFD ADFFCCFB | 002058600-1 | 04/01/2013    | Not Available  | Tier 2          | true        |

  @CMvasnegativescenario
  Scenario Outline: Verify that DisocuntServices section is visible on Benefits and coverage page
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
      | planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | name            | memberid    | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | PDP      | Group      | NON LIS       | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | DDCCFD ADFFCCFB | 002058600-1 | 04/01/2013    | Not Available  | Tier 2          | true        |

  @CMvasnegativescenario
  Scenario Outline: Verify that DisocuntServices section is visible on Benefits and coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    When the user navigates to Benefits and coverage page
    And the user validates the Vas section on benefits and coverage page is not displayed

    Examples: 
      | planType | memberType | copayCategory |
      | PDP      | Group      | NON LIS       |
      | MAPD     | Individual | NON LIS       |
      | MA       | Group      | NON LIS       |

  @thePredators @juneRelease2018 @hartfordprescriptionDrugBenefit
  Scenario Outline: Verify city of Hartford Prescription Drug Benefits
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to Benefits coverage page
    And the user validates City of Hartford prescription Drug Benefits table

    Examples: 
      | planType | memberType |
      | MAPD     | Hartford   |
      | PDP      | Hartford   |

  @thePredators @juneRelease2018 @TownOfGreenwichprescriptionDrugBenefit
  Scenario Outline: Verify town of greenwich Prescription Drug Benefits
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to Benefits coverage page
    And the user validates Town Of Greenwich table

    Examples: 
      | planType | memberType |
      | PDP      | Greenwich  |

  @BenefitsforTexasERSMember @regression @regression_06_06_18 @benefitsAndCoverage
  Scenario Outline: Verify the Benefits for TexasERSMember
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to Benefits coverage page
    And the user validates the Drug costs Section
    Then the user verifies the Retail Cost sharing table
    Then the user verifies the Mail Order Cost sharing table

    Examples: 
      | planType | memberType    |
      | PDP      | TEXASERSGroup |

  @OfficeVisitswithoutprovidertiering @regression @regression_06_06_18 @benefitsAndCoverage
  Scenario Outline: Verify the Office visits widget for a member withoutprovidertiering
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to Benefits coverage page
    And the user validates the Office Visits section

    Examples: 
      | planType | memberType                   |
      | MAPD     | memberWithoutProviderTiering |

  @WaystoSaveforPdp @regression @regression_06_06_18 @benefitsAndCoverage
  Scenario Outline: Verify the ways to save  widget for a PDP member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to Benefits coverage page
    And the user validates the ways to save section

    Examples: 
      | planType | memberType         |
      | PDP      | Wallgreens         |
      | PDP      | MailOrderPharamacy |
      | MAPD     | withoutWaysToSave  |

  @outpatientcenterwithprovidertier @thepredators @regressionoutpatient @regression_06_06_18
  Scenario Outline: Verify the outpatient widget for a member withprovidertiering
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to Benefits coverage page
    And the user validates the Outpatient Surgery Center Visits section

    Examples: 
      | planType | memberType |
      | MAPD     | MAPDCOSMOS |

  @primarycareproviderspecialist @thepredators @regressionprimarycareprovider @regression_06_06_18
  Scenario Outline: Verify the Office visits widget for a member withprovidertiering
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to Benefits coverage page
    And user validates the Office Visits section widgets

    Examples: 
      | planType | memberType        |
      | MAPD     | COSMOSOfficevisit |

  @outpatientcenterwithoutprovidertier @thepredators @regressionoutpatientwithoutprovider @regression_06_06_18
  Scenario Outline: Verify the outpatient widget for a member withoutprovidertiering
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to Benefits coverage page
    And the user validates the Outpatient Surgery Center Visits section

    Examples: 
      | planType | memberType   |
      | MAPD     | NICEBenefits |

  @BenefitsForAlPeehipMember @regression @regression_06_06_18 @benefitsAndCoverage
  Scenario Outline: Verify the benefits for an AL peehip member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to Benefits coverage page
    And the user validates the Benefits for Peehip member

    Examples: 
      | planType | memberType |
      | Peehip   | Group      |

  @BenefitsForMAMedsupSSUPMember @regression @regression_06_06_18 @benefitsAndCoverage
  Scenario Outline: Verify the Benefits for a  MA Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to Benefits coverage page
    And the user validates the Benefits for MA member

    Examples: 
      | planType | memberType |
      | MA       | Individual |

  #| SSUP     |Group  |
  @CopayCoinsuranceInDrugCostTable @regression @regression_06_06_18 @benefitsAndCoverage
  Scenario Outline: Verify the copay coinsurance in drugcosts table
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to Benefits coverage page
    And the user validates the copay coinsurance in drug costs table

    Examples: 
      | planType | memberType |
      | MAPD     | Individual |

  @BenefitsForCombo @regression @regression_06_06_18 @benefitsAndCoverage
  Scenario Outline: Verify the Benefits for a combo member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to Benefits coverage page
    And the user validates the benefits for a combo member

    Examples: 
      | planType | memberType  |
      | Combo    | MAPDANDSHIP |

  @BenefitsRiderFunctionality @regression @regression_06_06_18
  Scenario Outline: Verify the Benefits for a combo member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then the user navigates to Benefits coverage page
    And the user validates the Add Rider functionality
    Then the user validates the remove Rider functionality

    Examples: 
      | planType | memberType |
      | MAPD     | withRider  |

  @ancillarybenefitnegativescenarioscodemonkeys
  Scenario Outline: Verify ancillary benefits are not displayed other than Group memnbers
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then the user navigates to Benefits and coverage page
    Then verify ancillary benefit section is not displayed

    Examples: 
      | planType | memberType | copayCategory |
      #| PDP     |  Group       |  NON LIS      |
      | MAPD     | Individual | NON LIS       |
