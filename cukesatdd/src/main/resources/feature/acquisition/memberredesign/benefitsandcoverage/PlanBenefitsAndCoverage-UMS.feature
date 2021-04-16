@benefitsAndCoverage @thePredators @codeMonkeys @regression_06_06_18
Feature: 1.01 Member  benefits and Coverage page

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on test env
      | Feature           | UCPBenefits |

###############################Regression Scenarios Begin Here ########################################
  #TO BE DEPRECATED
  #TC05_Primarycareprovider_specialist_withoutprovidertiering
  #@benefitsAndCoverage02 @OfficeVisitswithoutprovidertiering @regression @BnC_Part1_regressionMember
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Office visits widget for a member withoutprovidertiering
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Office Visits section

    Examples: 
      | index | TID   | planType | memberType                       |
      | 02    | 15088 | MAPD     | memberWithoutProviderTiering_BnC |

  #TC08_BenefitsFor_ComboMembers
  @benefitsAndCoverage03 @BenefitsForCombo @regression @BnC_Part2_regressionMember
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Benefits for a combo member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the benefits for a combo member

    Examples: 
      | index | TID   | planType | memberType       |
      | 03    | 15091 | SHIP     | ComboFEDShip_BnC |

  #TC10_Benefits_for_TexasERSMember
  @benefitsAndCoverage04 @BenefitsforTexasERSMember @regression @BnC_Part2_regressionMember
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Benefits for TexasERSMember
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Drug costs Section
    Then the user verifies the Retail Cost sharing table
    Then the user verifies the Mail Order Cost sharing table

    @devRegression
    Examples: 
      | index | TID   | planType | memberType        |
      | 04    | 15093 | PDP      | TEXASERSGroup_BnC |

  #TC11_Benefits_for_Ship_member
  #note: this scenario covers multiple testcases TID 15094,15240
  @benefitsAndCoverage05 @CMShip @BnC_Part3_regressionMember 
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify that Page Headers are in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
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
    Then verify ancillary benefit section is not displayed
    And the user validates plan overview and summary on Bnc page for ship members
     | Benefits Expected | <numberOfBenefitCards> |
    And the user validates hand image under discount and services section
    And the user validates the Vas section on benefits and coverage page
    And the user validates additional information on Bnc page for ship members
    And the user validates view and document label
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    #And the user verifies that the correct pdfs are coming in the plan material section
    # | Plan Benefits Table | <PlanBenefitsTable> |
    #note: moved to footer feature
    #And the user validates ship the need help section
    And the user validates for ship see more ways to contact us section
    And the user validates for ship member on clicking contact us link it should route to contact us page
    And the user clicks on More Information link for ship
    Then the user validate Value Add Service page comes on clicking additional info button
    And the user validate vas tiles on vas page

    ### note: number of benefits tile may change if swap user
	@bnc_Stage_sanity_ship 
    Examples: 
      | index | TID   | planType | memberType        | language |  numberOfBenefitCards | Identifier           | count | rider   |
      | 05    | 15094 | SHIP      | SHIP_BnC         | ENGLISH  |  7                    | EffectiveShipMedSupp |     3 | NoRider |

  #TC13_Benefits_for_MA_SSUP_MEDSUPMember
  @benefitsAndCoverage06 @BenefitsForMAMedsupSSUPMember @regression  @BnC_Part3_regressionMember
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Benefits for a  MA Member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
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
    And the user validates the Benefits for MA member
      | Plan Type | <planType> |

    Examples: 
      | index | TID   | planType | memberType     | Identifier      | count | rider   |
      | 06    | 15098 | SSUP     | COMBO_Group_BnC| GrpEffectiveSSUP| 4     | NoRider |

  #TC15_Ancilliary Benefits for Group member(MA,MAPD)
  @benefitsAndCoverage07 @CMAncillarysection2  @BnC_Part4_regressionMember
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify CMAncillarysection2 section is in place on Benefits and Coverage page for nonLis member
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
      | index | TID   | planType | memberType          | copayCategory |
      | 07    | 15238 | MAPD     | Group_Ancillary_BnC | NON LIS       |

  #TC16-Part1_Ancilliary Benefits for Group member(PDP and other than Group members)
  @benefitsAndCoverage08 @ancillarybenefitnegativescenarioscodemonkeys @BnC_Part4_regressionMember
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify ancillary benefits are not displayed other than Group nonLis memnbers
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
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
    Then verify ancillary benefit section is not displayed
    And the user validates the Vas section on benefits and coverage page is not displayed

    Examples: 
      | index | TID   | planType | memberType     | copayCategory | Identifier       | count | rider   |
      | 08    | 15239 | PDP      | Group_BnC      | NON LIS       | GrpEffectiveUHC  | 3     | NoRider | 
      
  #TC19_Ways To Save should come only for PDP members (Saver,Walgreen,Preferred, Symphonix)
  @benefitsAndCoverage09 @WaystoSaveforPdp @regression  @BnC_Part5_regressionMember
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the ways to save  widget for a PDP member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the ways to save section
    And user validates to not display pharmacy out-of-pocket maximum beside drug lookup
      | Type   | <type>   |
  
    @devRegression @WaystoSave_walgreens
    Examples: 
      | index | TID   | planType | memberType             | type      |
      | 09    | 15242 | PDP      | Wallgreens_BnC         | Individual|

    @devRegression @WaystoSave_mailOrder
    Examples: 
      | index | TID   | planType | memberType             | type      |
      | 10    | 15243 | PDP      | MailOrderPharamacy_BnC | Individual|

    @devRegression @noWaystoSave
    Examples: 
      | index | TID   | planType | memberType             |
    # | 11    | 15249 | MAPD     | withoutWaysToSave_BnC  |
      
  #TC20_Rider for Fed MA,MAPD plans only  
  # note: Due to timing that it takes for GPS to do the update (add or remove),
  # this testcase result will not be stable. Since can't predict time for GPS to finish the update,
  # so the add or remove button does't always show up within the time the code expects it to.
  @benefitsAndCoverage10 @BenefitsRiderFunctionality @regression
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Benefits for a combo member with Rider
     Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Add Rider functionality
    Then the user validates the remove Rider functionality

    Examples: 
      | index | TID   | planType | memberType     | copayCategory |
      | 12    | 15090 | MAPD     | Individual_BnC | NON LIS       |
    
      
  #TC21_PDP_LIS(3,4)- Retail Drug Cost Table
  @benefitsAndCoverage11  @PDPLIS3member @BnC_Part5_regressionMember
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Group LIS 3/4 on Benefits and Coverage page
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
    And user validates to not display pharmacy out-of-pocket maximum beside drug lookup
      | Type   | <type>   |
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
    #note: moved to footer feature
    #And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | index | TID   | planType | memberType | copayCategory | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | AlternativeDrugList   | type      |
      | 13    | 15248 | PDP      | PDPLIS_BnC | LIS 3         | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary         | Alternative Drug List | Individual|
      
  #TC21_PDP_LIS(3,4)- Retail Drug Cost Table
  @benefitsAndCoverage12  @PDPLIS3member @BnC_Part6_regressionMember  
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Group LIS 3/4 on Benefits and Coverage page
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
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates view and document label
    And the user validates spanish and chinese should not display in dropdown
    #note: moved to footer feature
    #And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    @bnc_Stage_sanity_pdp
    Examples: 
      | index | TID   | planType | memberType | copayCategory |
      | 14    | 15248 | PDP      | PDPLIS_BnC  | LIS 3        |
      
  #TC25_Group members_MAPD_LIS(3,4)
  @benefitsAndCoverage13 @CMGroupmembersTC25 @BnC_Part6_regressionMember 
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Group LIS 3/4 on Benefits and Coverage page
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
    #note: moved to footer feature
    #And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    @bnc_Stage_Sanity_mapd
    Examples: 
      | index | TID   | planType | memberType | copayCategory | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List |
      | 15    | 15247 | MAPD     | Group_BnC  | LIS 4         | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         |

  #TC26_Group members_PDP_LIS(1,2)
  @benefitsAndCoverage14 @CMGroupmembersPDPLIS_TC26 @BnC_Part7_regressionMember 
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Group LIS 1/2 values on Benefits and Coverage page
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
    #note: moved to footer feature
    #And the user validates Needhelp section
    And the drugcost dropdown should not display
    And the user validates view and document label
    And the user clicks on More Information link
    And the user validates contactus section
    
    @devRegression
    Examples: 
      | index | TID   | planType | memberType | copayCategory | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List |
      | 16    | 15369 | PDP      | Group_BnC  | LIS 1         | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         |

  #TC23_Group NON LIS_MAPD
  @benefitsAndCoverage15 @CMMapdGroupNonLis @BnC_Part7_regressionMember
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify all sections for Group NonLIS member on Benefits and Coverage page
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
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | index | TID   | planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | name             | memberid     | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | 17    | 15246 | MAPD     | Group_BnC  | NON LIS       | ENGLISH  | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         | EFADDB CDEEFFCDC | 978095497-00 | 01/01/2018    | Not Available  | Tier 2          | true        |

  #TC24_Group NON LIS_PDP
  @benefitsAndCoverage16 @CMPDPGroupNonLis @BnC_Part8_regressionMember
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify all sections for PDP Group NonLIS member on Benefits and Coverage page
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
     #| Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
    #And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | index | TID   | planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | name           | memberid   | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | 18    | 15366 | PDP      | Group_BnC  | NON LIS       | ENGLISH  | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         | BBBCCB FFAAFAD | 0191976081 | 01/01/2019    | Not Available  | Tier 2          | true        |

  #TC22_NON LIS Ind plan member(PDP)- Drug Cost table
  @benefitsAndCoverage18 @CMFedPDPNonLis @BnC_Part9_regressionMember
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> -language: <language> - Verify all sections for PDP Ind NonLIS member on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
    Then The user navigate to Benefits and Coverage page
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
    And user validates to not display pharmacy out-of-pocket maximum beside drug lookup
      | MemberType   | <memberType>   |
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
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | index | TID   | planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | AlternativeDrugList   | name        | memberid   | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag | Identifier       | count | rider   |
      | 21    | 15377 | PDP      | Individual_BnC | NON LIS       | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | Alternative Drug List | ECADEA DCAA | 0197331001 | 05/01/2018    | Not Available  | Tier 2          | true        | EffectivePDPAARP | 4     | NoRider |


  @benefitsAndCoverage19  @hartfordprescriptionDrugBenefit @BnC_Part9_regressionMember
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify city of Hartford Prescription Drug Benefits
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates City of Hartford prescription Drug Benefits table

    Examples: 
      | index | TID   | planType | memberType   |
      | 22    | 15367 | MAPD     | Hartford_BnC |
    # | xx    | 15367 | PDP      | Hartford_BnC |

  @benefitsAndCoverage20 @TownOfGreenwichprescriptionDrugBenefit @BnC_Part10_regressionMember
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify town of greenwich Prescription Drug Benefits
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates Town Of Greenwich table

    Examples: 
      | index | TID   | planType | memberType    |
      | 23    | 15367 | MAPD     | Greenwich_BnC |
      
  @benefitsAndCoverage21 @CMpdpindlis @BnC_Part10_regressionMember
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify all sections for Ind LIS1 member on Benefits and Coverage page
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
    And user validates to not display pharmacy out-of-pocket maximum beside drug lookup
       | MemberType   | <memberType>   |
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
    #note: moved to footer feature
    #And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | index | TID   | planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | AlternativeDrugList   | name        | memberid   | effectivedate | monthlypremium | extrahelp            |
      | 24    | 15244 | PDP      | Individual_BnC | LIS 1         | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | Alternative Drug List | RABI' MALORY | 0182197901 | 01/01/2019    | Not Available  | Extra Help Level : 1 |

  @benefitsAndCoverage22 @DSNP_CnS
  Scenario Outline: Index: <index> -FID: <FID> -plan: <planType> -memberType: <memberType> - Verify  Medical copays or coinsurance section and Out-of-pocket maximum section for DSNP members
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
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
    And the user validates Lis member plan overview section
      | Name            | <name>           |
      | Member ID       | <memberid>       |
      | Effective Date  | <effectivedate>  |
      | Monthly premium | <monthlypremium> |
      | Extra Help      | <extrahelp>      |
    And the user validates headers on Bnc page for Dsnp indi members
      | Plan Type | <planType> |
    And the user validates the Out of Pocket Max section for Dsnp indi member
    	 | Plan Type | <planType> |
    And validating the LIS Drug Copays, Discounts header and drug table for Dsnp indi member
    	 | Copay Category | copayCategory |
    And the user validates Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates Look Up Drugs button should be visible
      | Plan Type | <planType> |
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
      | Plan Type | <planType> |
    And the user validates the Learn More section link for stage
    And the user validates view and document label
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    And the user clicks on More Information link
    And the user validates contactus section
	
    @DSNP_CnS01 @devRegression
    Examples: 
      | index | FID             | planType   | memberType           | copayCategory | language | name         | memberid     | effectivedate | monthlypremium | extrahelp            | Identifier       | count | H-PBP    | rider  |
      | 25-c1 | F494433,F506320 | DSNP_MAPD  | Individual_CnS01_BnC | LIS 2         | ENGLISH  | DREENA KIMURA| 971949191-00 | 01/01/2020    | Not Available  | Extra Help Level : 2 | IndEffectiveAARP |     4 | H0624-001| NoRider|

    @DSNP_CnS01
    Examples: 
      | index | FID             | planType   | memberType           | copayCategory | language | name         | memberid     | effectivedate | monthlypremium | extrahelp            | Identifier       | count | H-PBP    | rider  |
      | 26-c2 | F494433,F506320 | DSNP_MAPD  | Individual_CnS02_BnC | LIS 1         | ENGLISH  | EBER KRYSTEK| 903010063-00 | 01/01/2020    | Not Available  | Extra Help Level : 1 | IndEffectiveAARP |     4 | H2228-045| NoRider|
    
    @DSNP_CnS02
    Examples:       
      | index | FID             | planType   | memberType           | copayCategory | language | name         | memberid     | effectivedate | monthlypremium | extrahelp            | Identifier       | count | H-PBP    | rider  |
      | 27-c3 | F494433,F506320 | DSNP_MAPD  | Individual_CnS03_BnC | LIS 1         | ENGLISH  | HULDIBERAH KINIRY | 967076552-1 | 01/01/2020 | Not Available  | Extra Help Level : 1 | IndEffectiveAARP |     4 | H3113-110| NoRider|
      | 28-c4 | F494433,F506320 | DSNP_MAPD  | Individual_CnS04_BnC | LIS 1         | ENGLISH  | BLAIS OWEN        | 912002942-1 | 01/01/2020 | Not Available  | Extra Help Level : 1 | IndEffectiveAARP |     4 | H4527-003| NoRider|
      | 29-c5 | F494433,F506320 | DSNP_MAPD  | Individual_CnS05_BnC | LIS 2         | ENGLISH  | KUMARI FROEHNER   | 006644986-1 | 01/01/2020 | Not Available  | Extra Help Level : 2 | IndEffectiveAARP |     4 | H4590-033| NoRider|
    
    @DSNP_CnS03
    Examples: 
      | index | FID    		    | planType   | memberType           | copayCategory | language | name         | memberid     | effectivedate | monthlypremium | extrahelp | Identifier      | count | H-PBP    | rider  |
      | 35-c6 | F494433,F506320 | DSNP_MAPD  | Individual_CnS06_BnC | Non Lis       | ENGLISH  | EBER KRYSTEK| 903010063-00 | 01/01/2020    | Not Available  | 			  |IndEffectiveAARP |     4 | H4527-015| NoRider|
      | 36-c7 | F494433,F506320 | DSNP_MAPD  | Individual_CnS07_BnC | Non Lis       | ENGLISH  | EBER KRYSTEK| 903010063-00 | 01/01/2020    | Not Available  |            | IndEffectiveAARP|     4 | H5322-030| NoRider|
      
      
    @DSNP_MnR01
    Examples:       
       | index | FID             | planType   | memberType           | copayCategory | language | name         | memberid     | effectivedate | monthlypremium | extrahelp            | Identifier       | count | H-PBP    | rider  |
       | 30-m1 | F494433,F506320 | DSNP_MAPD  | Individual_MnR01_BnC | LIS 1         | ENGLISH  | OFER MCLEON  | 937024725-1| 01/01/2020    | Not Available  | Extra Help Level : 1 | IndEffectiveAARP |     4 |  H0271-005 |  NoRider|
       | 31-m2 | F494433,F506320 | DSNP_MAPD  | Individual_MnR02_BnC | LIS 1         | ENGLISH  | DBAD ADFED | 919744565-00 | 01/01/2020    | Not Available  | Extra Help Level : 1 | IndEffectiveAARP |     4 |  H5253-041 | NoRider |

    @DSNP_MnR02
    Examples:      
       | index | FID             | planType   | memberType           | copayCategory | language | name         | memberid     | effectivedate | monthlypremium | extrahelp            | Identifier       | count | H-PBP    | rider  |
       | 32-m3 | F494433,F506320 | DSNP_MAPD  | Individual_MnR03_BnC | LIS 1         | ENGLISH  | DBAD ADFED | 919744565-00 | 01/01/2020   | Not Available   | Extra Help Level : 1 | IndEffectiveAARP |     4 |  R2604-004 | NoRider|
       | 33-m4 | F494433,F506320 | DSNP_MAPD  | Individual_MnR04_BnC | LIS 3         | ENGLISH  | DBAD ADFED | 919744565-00 | 01/01/2020    | Not Available  | Extra Help Level : 3 | IndEffectiveAARP |     4 |  H0271-006 | NoRider|


  @benefitsAndCoverage23 @insulin
  Scenario Outline: Index: <index> -FID: <FID> -plan: <planType> -memberType: <memberType> -copayCategory: <copayCategory> -insulin: <insulin> - Verify Insulin Demo display on drug table for NON-LIS user
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
      | Deductible | <deductible> |
      | Insulin | <insulin> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
	And the user validate drug cost table display behavior
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
      | Deductible | <deductible> |
      | Insulin | <insulin> |
	
    @hasInsulin_mapd_NoD
    Examples: 
      | index  | FID    | planType  | memberType     | copayCategory | deductible   | insulin      |
      | 34-I01 | 478830 | MAPD      | Individual_BnC | NON LIS       | NoD          | hasInsulin   | 

    @hasInsulin_mapd_T12NoD_T345D
    Examples: 
      | index  | FID    | planType  | memberType     | copayCategory | deductible   | insulin      |
      | 34-I02 | 478830 | MAPD      | Individual_BnC | NON LIS       | T12NoD_T345D | hasInsulin   | 

    @hasInsulin_mapd_T123NoD_T45D
    Examples: 
      | index  | FID    | planType  | memberType     | copayCategory | deductible   | insulin      |
      | 34-I03 | 478830 | MAPD      | Individual_BnC | NON LIS       | T123NoD_T45D | hasInsulin   | 
     
    @hasInsulin_pdp_NoD
    Examples: 
      | index  | FID    | planType  | memberType     | copayCategory | deductible   | insulin      |
      | 34-I04 | 478830 | PDP       | Individual_BnC | NON LIS       | NoD          | hasInsulin   | 

    @hasInsulin_csnpPcp_NoD
    Examples: 
      | index  | FID    | planType  | memberType     | copayCategory | deductible   | insulin      |
      | 34-I05 | 478830 | CSNP_PCP  | Individual_BnC | NON LIS       | NoD          | hasInsulin   | 

    @hasInsulin_csnpMapd_T123NoD_T45D
    Examples: 
      | index  | FID    | planType  | memberType     | copayCategory | deductible   | insulin      |
      | 34-I06 | 478830 | CSNP_MAPD | Individual_BnC | NON LIS       | T123NoD_T45D | hasInsulin   | 

    @hasInsulin_isnpMapd_T123NoD_T45D
    Examples: 
      | index  | FID    | planType  | memberType     | copayCategory | deductible   | insulin      |
      | 34-I07 | 478830 | ISNP_MAPD | Individual_BnC | NON LIS       | T123NoD_T45D | hasInsulin   | 

    @nonInsulin_mapd_NoT
    Examples: 
      | index  | FID    | planType  | memberType     | copayCategory | deductible   | insulin      |
      | 34-I08 | 478830 | MAPD      | Individual_BnC | LIS 4         | NoTier       | nonInsulin   | 

    @nonInsulin_mapd_T12345
    Examples: 
      | index  | FID    | planType  | memberType     | copayCategory | deductible   | insulin      |
      | 34-I09 | 478830 | MAPD      | Individual_BnC | NON LIS       | T12345       | nonInsulin   | 

  #note: if FED_SHIP_SHIP_BnC user stop working, replace with any FED+SHIP combo user would do, coverage is for combo with federal priority
  @benefitsAndCoverage24 @api
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify UCPBenefits API not having undefined input value for COMBO user
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the users validate Benefits page has combo tabs for combo users
    And the users validate UCPBenefits related API requests are not having undefined input value

    @comboApi
    Examples: 
      | index | TID   | planType | memberType   |
      | 35    | xxxxx | COMBO    | SHIP_FED_BnC |
      | 36    | xxxxx | COMBO    | FED_SHIP_SHIP_BnC |
      | 37    | xxxxx | COMBO    | FED_FED_BnC  |

    @singleApi
    Examples: 
      | index | TID   | planType | memberType   |
      | 38    | xxxxx | MA       | FED_BnC      |
      | 39    | xxxxx | MAPD     | FED_BnC      |
      | 40    | xxxxx | PDP      | FED_BnC      |
      
  @benefitsAndCoverage25 @api
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify UCPBenefits API not having undefined input value for COMBO user
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user will not be able to navigate to Benefits and Coverage page
      
    @singleApi
    Examples: 
      | index | TID   | planType | memberType   |
      | 41    | xxxxx | TERM     | FED_BnC      |
      
 ###############################Regression Scenarios END Here ########################################