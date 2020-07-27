@benefitsAndCoverage @thePredators @codeMonkeys
Feature: 1.01 Member  benefits and Coverage page  - Member Auth

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPBenefits |

###############################Regression Scenarios Begin Here ########################################
  #TC01_OutpatientSurgeryCentervisits_withprovidertiering
  @memAuth_benefitsAndCoverage6 @outpatientcenterwithprovidertier @thepredators @regressionoutpatient @BnC_Part1_memAuth 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the outpatient widget for a member withprovidertiering
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user with providerTier validates the Outpatient Surgery Center Visits section

    Examples: 
      | TID   | username  | password  | MemUserName     | planType  | memberType       |
      | 15084 | qavgogine | qavgogine | q2_jun_aarp00042| MAPD      | providerTier_BNC |
      
   #TC02_Primarycareprovider_specialist_withprovidertiering
  @benefitsAndCoverage7 @primarycareproviderspecialist @thepredators @regressionprimarycareprovider @BnC_Part1_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Office visits widget for a member witprovidertiering
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigate to Benefits and Coverage page
    And user validates the Office Visits section widgets

    Examples: 
      | TID   | username  | password  | MemUserName     | planType | memberType            |
      | 15085 |qavgogine | qavgogine |q3_sept_UAT4_AARP_001| MAPD  | COSMOSOfficevisit_BnC |

  #TC04_OutpatientSurgeryCentervisits_withoutprovidertiering
  @memAuth_benefitsAndCoverage8 @outpatientcenterwithoutprovidertier @thepredators @regressionoutpatientwithoutprovider @BnC_Part1_memAuth 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the outpatient widget for a member withoutprovidertiering
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user without providertier validates the Outpatient Surgery Center Visits section

    Examples: 
      
      | TID   | username  | password  | MemUserName      | planType  | memberType     | copayCategory |
      | 15087 | qavgogine | qavgogine | q3_sept_UAT4_AARP_001 | MAPD | Individual_BnC |  NON LIS      |
      
      #TC05_Primarycareprovider_specialist_withoutprovidertiering
  @benefitsAndCoverage4 @OfficeVisitswithoutprovidertiering @regression @BnC_Part2_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Office visits widget for a member withoutprovidertiering
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Office Visits section

    Examples: 
      | TID   |username  | password  | MemUserName | planType | memberType       |
      | 15088 |qavgogine | qavgogine |ucpaarpmapd01| MAPD     | memberWithoutProviderTiering_BnC |
      
      #TC07_Copay_Coinsurance_in_DrugCostsTable
  @benefitsAndCoverage11 @CopayCoinsuranceInDrugCostTable @regression @BnC_Part2_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the copay coinsurance in drugcosts table
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigate to Benefits and Coverage page
    And the user validates the copay coinsurance in drug costs table
   
    Examples: 
      | TID   |username  | password  | MemUserName  |  planType | memberType     | copayCategory |
      | 15090 |qavgogine | qavgogine|q3_sept_UAT4_AARP_001| MAPD| Individual_BnC | NON LIS       |
      
   #TC08_BenefitsFor_ComboMembers
  @benefitsAndCoverage12 @BenefitsForCombo @regression @BnC_Part2_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Benefits for a combo member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigate to Benefits and Coverage page
    And the user validates the benefits for a combo member

    Examples: 
      | TID   |username  | password  | MemUserName | planType | memberType       |
      | 15091 |qavgogine | qavgogine| q3_SEP_2020SHIP_001|SHIP_HIP    | ComboFEDShip_BnC |
      
    #TC10_Benefits_for_TexasERSMember
  @benefitsAndCoverage3 @BenefitsforTexasERSMember @regression @BnC_Part3_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Benefits for TexasERSMember
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Drug costs Section
    Then the user verifies the Retail Cost sharing table
    Then the user verifies the Mail Order Cost sharing table
    
    Examples: 
      | TID   |username  | password  | MemUserName | planType | memberType        |
      | 15093 |qavgogine | qavgogine|ucpgrouppdptxers01| PDP | TEXASERSGroup_BnC |

  #TC11_Benefits_for_Ship_member
  #note: this scenario covers multiple testcases TID 15094,15240
  @memAuth_benefitsAndCoverage22 @CMShip @BnC_Part3_memAuth 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify that Page Headers are in place on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
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
   # And the user verifies that the correct pdfs are coming in the plan material section
      #| Plan Benefits Table | <PlanBenefitsTable> |
    #note: moved to footer feature
    #And the user validates ship the need help section
    And the user validates for ship see more ways to contact us section
    And the user validates for ship member on clicking contact us link it should route to contact us page
    And the user clicks on More Information link for ship
    Then the user validate Value Add Service page comes on clicking additional info button
    And the user validate vas tiles on vas page

    Examples: 
      |TID  |username |password |MemUserName        |planType|memberType|language|numberOfBenefitCards|Identifier          | count| rider   |
      |15094|qavgogine|qavgogine|q3_sep_UAT4_AARP013| SHIP   |SHIP_BnC  | ENGLISH| 6                  |EffectiveShipMedSupp|   3  | NoRider |
      
 #TC12_Benefits_for_MedicaMember
  @memAuth_benefitsAndCoverage12_1 @CMFedDrugNonLis  @BnC_Part3_memAuth 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -language: <language> - Verify all sections for Ind NonLIS member on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
      | Copay Category | <copayCategory> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates Ind plan overview
      | Name            | <name>           |
      | Member ID       | <memberid>       |
      | Effective Date  | <effectivedate>  |
      | Monthly premium | <monthlypremium> |
    And the user validates headers on Bnc page for indi members
      | Plan Type       | <planType>       |
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
    And the user clicks on More Information link
    And the user validates contactus section

    Examples:  
      | TID   |username |password |MemUserName        | planType|memberType    |copayCategory|language|SummaryofBenefits  | EvidenceofCoverage  |ComprehensiveFormularyDrug List    |AlternativeDrug List |language1| SummaryofBenefitsSpanish | EvidenceofCoverageSpanish  | ComprehensiveFormularyDrug ListSpanish | AlternativeDrug ListSpanish 	| language2 | SummaryofBenefitsChinies | EvidenceofCoverageChinies | ComprehensiveFormularyDrug ListChinies | AlternativeDrug ListChinies | name        | memberid     | effectivedate| monthlypremium|UpdatedLanguage| DisplayFlag|Identifier | count| rider|
      | 15095 |qavgogine|qavgogine|q3_Sep_UAT4_Sofl020| Medica  |Individual_BnC|NON LIS      |ENGLISH |Summary of Benefits| Evidence of Coverage|Comprehensive Formulary - Drug List|Alternative Drug List| 1  | Resumen de Beneficios    | Comprobante de Cobertura  | Formulario Completo                    | Lista de Medicamentos Alternativos | 2   |                          |                           |                                      |                             | AADECDC FEDFACEDBACBB | 954283936-00 | 04/01/2018 | Not Available | Tier 2        | true       |IndEffectiveMedica| 6| NoRider |

#TC13_Benefits_for_MA_SSUP_MEDSUPMember
  @memAuth_benefitsAndCoverage10 @BenefitsForMAMedsupSSUPMember @regression  @BnC_Part4_memAuth 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Benefits for a  MA Member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
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
      | TID   |username |password  |MemUserName   | planType| memberType  |Identifier      | count | rider   |
      | 15096 |qavgogine| qavgogine|q2_jun_uhc0050|MA      | Individual_BnC| IndEffectiveUHC| 5     | Rider   |
      | 15098 |qavgogine| qavgogine|q2_jun_grp0255| SSUP   | COMBO_Group_BnC|GrpEffectiveSSUP| 4     | NoRider |

  #TC14_Benefits_for_PCPMember
  @memAuth_benefitsAndCoverage14_2 @CMFedDrugNonLis @BnC_Part4_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -language: <language> - Verify all sections for Ind NonLIS member on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
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
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   |username |password  |MemUserName   | planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   |  ComprehensiveFormularyDrug List     | AlternativeDrug List  | language1 | SummaryofBenefitsSpanish | EvidenceofCoverageSpanish | ComprehensiveFormularyDrug ListSpanish | AlternativeDrug ListSpanish        | language2 | SummaryofBenefitsChinies | EvidenceofCoverageChinies |  ComprehensiveFormularyDrug ListChinies | AlternativeDrug ListChinies | name        | memberid     | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |Identifier      | count | rider   |
      | 15097 |qavgogine| qavgogine|q3_Sep_UAT4_Sofl022| PCP      | Individual_BnC | NON LIS      | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List  | Alternative Drug List | 1  | Resumen de Beneficios    | Comprobante de Cobertura   | Formulario Completo                    | Lista de Medicamentos Alternativos       | 2      |                          |                           |                                        |                           | BDFAEC CBADEADF | 945007888-00 | 01/01/2018    | Not Available  | Tier 2          | true  |IndEffectivePCP | 6     | NoRider |

  #TC15_Ancilliary Benefits for Group member(MA,MAPD)
  @memAuth_benefitsAndCoverage21 @CMAncillarysection2  @BnC_Part4_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify CMAncillarysection2 section is in place on Benefits and Coverage page for nonLis member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigate to Benefits and Coverage page
    Then user validates ADDITIONAL BENEFITS Section
    Then user validates and clicks on Disclaimers link under Exclusive hearing
    Then the user validates Hearing section
    Then the user validates the Hearing Aid section
    Then the user validates the Vision section
    Then the user validates the Dental section
    Then the user validates chiropractic section
    Then user validates and clicks on Learn More button under Exclusive hearing section
    
    Examples:  
      | TID   |username |password  |MemUserName |  planType | memberType          | copayCategory |
      | 15238 |qavgogine| qavgogine| mapd_group_user|MAPD     | Group_BnC_Ancillary | NON LIS       |

  #TC16-Part1_Ancilliary Benefits for Group member(PDP and other than Group members)
  @memAuth_benefitsAndCoverage32_1 @ancillarybenefitnegativescenarioscodemonkeys @BnC_Part5_memAuth 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify ancillary benefits are not displayed other than Group nonLis memnbers
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
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
      | TID   |username |password  |MemUserName| planType| memberType| copayCategory |Identifier      | count | rider   |
      | 15239 | qavgogine| qavgogine|q4_grp_dec204|PDP    | Group_BnC  | NON LIS     |GrpEffectiveUHC | 3     | NoRider |
      | 15238 | qavgogine| qavgogine| EPMP_Enabled_087|MAPD| Individual_BnC | NON LIS |IndEffectiveAARP | 7   | Rider |

    #TC19_Ways To Save should come only for PDP members (Saver,Walgreen,Preferred, Symphonix)
  @benefitsAndCoverage5 @WaystoSaveforPdp @regression  @BnC_Part5_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the ways to save  widget for a PDP member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigate to Benefits and Coverage page
    And the user validates the ways to save section
  
    Examples: 
      | TID   |username |password  |MemUserName| planType | memberType  |
      | 15242 |qavgogine| qavgogine| q3_sep_UAT4_AARP209|PDP | Wallgreens_BnC  |
      | 15243 | qavgogine| qavgogine|q3_sep_UAT4_AARP171|PDP | MailOrderPharamacy_BnC |
      | 15249 |qavgogine| qavgogine| q2_jun_aarp00042|MAPD  | withoutWaysToSave_BnC  |
        
  #TC21_PDP_LIS(3,4)- Retail Drug Cost Table
  @memAuth_benefitsAndCoverage1  @PDPLIS3member @BnC_Part5_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Group LIS 3/4 on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
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
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   |username |password  |MemUserName| planType| memberType| copayCategory | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | AlternativeDrugList   |
      | 15248 | qavgogine| qavgogine|q2_jun_aarp0179|PDP | PDPLIS_Bnc | LIS 3  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary         | Alternative Drug List |
      
  #TC25_Group members_MAPD_LIS(3,4)
  @memAuth_benefitsAndCoverage1 @BnC_Part6_memAuth @CMGroupmembersTC25 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Group LIS 3/4 on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
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
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   | username |password  |MemUserName|planType|memberType | copayCategory | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List |
      | 15247 |qavgogine| qavgogine|q2_jun_grp0019| MAPD|Group_BnC| LIS 4|Summary Of Benefits|Evidence of Coverage| Comprehensive Formulary         |

  #TC26_Group members_PDP_LIS(1,2)
  @memAuth_benefitsAndCoverage2 @BnC_Part6_memAuth @CMGroupmembersPDPLIS_TC26
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Group LIS 1/2 values on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
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
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates spanish and chinese should not display in dropdown
    And the drugcost dropdown should not display
    And the user validates view and document label
    And the user clicks on More Information link
    And the user validates contactus section
   
    Examples: 
      | TID   |username |password  |MemUserName| planType | memberType| copayCategory | SummaryofBenefits | EvidenceofCoverage   | ComprehensiveFormularyDrug List |
      | 15369 | qavgogine| qavgogine|Auto20200408191555_3|PDP | Group_BnC | LIS 1 | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary |

  #TC23_Group NON LIS_MAPD
  @memAuth_benefitsAndCoverage23 @CMMapdGroupNonLis @BnC_Part6_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify all sections for Group NonLIS member on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
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
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   |username |password  |MemUserName| planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | name             | memberid     | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
     | 15246 |qavgogine| qavgogine| q3_sep_UAT4_Group224|MAPD     | Group_BnC  | NON LIS       | ENGLISH  | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         | EFADDB CDEEFFCDC | 978095497-00 | 01/01/2018    | Not Available  | Tier 2  | true        |

  #TC24_Group NON LIS_PDP
  @memAuth_benefitsAndCoverage27 @CMPDPGroupNonLis @BnC_Part7_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify all sections for PDP Group NonLIS member on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
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
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   |username |password  |MemUserName| planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | name           | memberid   | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | 15366 |qavgogine| qavgogine| q4_grp_dec204|PDP      | Group_BnC  | NON LIS       | ENGLISH  | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         | BBBCCB FFAAFAD | 0191976081 | 01/01/2019    | Not Available  | Tier 2          | true        |


#TC21_MAPD_LIS(1,2)- Retail Drug Cost Table
 @memAuth_benefitsAndCoverage23Indi @CMmapdindlis @BnC_Part7_memAuth 
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify PDF section is in place on Benefits and Coverage page for Lis user
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
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
     # | UnitedHealth Passport Program       | <UnitedHealthPassportProgram>     |
      | Comprehensive Formulary - Drug List | <ComprehensiveFormularyDrug List> |
      | Alternative Drug List               | <AlternativeDrugList>             |
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   |username |password  |MemUserName| planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | AlternativeDrugList   | name       | memberid     | effectivedate | monthlypremium | extrahelp|Identifier | count | rider   |
      | 15245 |qavgogine| qavgogine|q3_sep_UAT4_UHC092| MAPD | Individual_BnC  | LIS 1         | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | Alternative Drug List | DBAD ADFED | 919744565-00 | 01/01/2019    | Not Available  | Extra Help Level : 1 |IndEffectiveAARP |7|Rider |

  #TC22_NON LIS Ind plan member(MAPD)- Drug Cost table
  @memAuth_benefitsAndCoverage14 @CMFedDrugNonLis @BnC_Part7_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -language: <language> - Verify all sections for Ind NonLIS member on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
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
    And the user clicks on More Information link
    And the user validates contactus section
   
    Examples: 
      | TID   |username |password  |MemUserName| planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | UnitedHealth Passport Program | ComprehensiveFormularyDrug List     | AlternativeDrug List  | language1 | SummaryofBenefitsSpanish | EvidenceofCoverageSpanish | UnitedHealth Passport ProgramSpanish | ComprehensiveFormularyDrug ListSpanish | AlternativeDrug ListSpanish        | language2 | SummaryofBenefitsChinies | EvidenceofCoverageChinies | UnitedHealth Passport ProgramChinies | ComprehensiveFormularyDrug ListChinies | AlternativeDrug ListChinies | name        | memberid     | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | 15378 |qavgogine| qavgogine|EPMP_Enabled_087| MAPD| Individual_BnC | NON LIS       | ENGLISH  | Summary of Benefits | Evidence of Coverage | UnitedHealth Passport Program | Comprehensive Formulary - Drug List | Alternative Drug List | 1  | Resumen de Beneficios    | Comprobante de Cobertura  | Programa UnitedHealth Passport       | Formulario Completo                    | Lista de Medicamentos Alternativos | 2      |                          |                           |                                      |                                        |                             | DDCEE DAADF | 954016383-00 | 01/01/2018    | Not Available  | Tier 2          | true        |
  
  #TC22_NON LIS Ind plan member(PDP)- Drug Cost table
  @memAuth_benefitsAndCoverage15 @CMFedPDPNonLis @BnC_Part8_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> -language: <language> - Verify all sections for PDP Ind NonLIS member on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
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
      | TID   |username |password  |MemUserName| planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | AlternativeDrugList   | name        | memberid   | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag | Identifier   | count | rider   |
      | 15377 |qavgogine| qavgogine|q2_jun_aarp0112| PDP      | Individual_BnC | NON LIS       | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | Alternative Drug List | ECADEA DCAA | 0197331001 | 05/01/2018    | Not Available  | Tier 2          | true |EffectivePDPAARP | 4     | NoRider |


  @memAuth_benefitsAndCoverage30  @hartfordprescriptionDrugBenefit @BnC_Part8_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify city of Hartford Prescription Drug Benefits
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates City of Hartford prescription Drug Benefits table

    Examples: 
      | TID   |username |password  |MemUserName| planType | memberType   |
      | 15367 |qavgogine| qavgogine|q3_sep_UAT4_Group233| MAPD | Hartford_BnC |

  @benefitsAndCoverage31 @TownOfGreenwichprescriptionDrugBenefit @BnC_Part8_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify town of greenwich Prescription Drug Benefits
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates Town Of Greenwich table

    Examples: 
      | TID   |username |password  |MemUserName| planType | memberType    |
      | 15367 |qavgogine| qavgogine| q3_sep_UAT4_Group029| MAPD| Greenwich_BnC |
      
    @memAuth_benefitsAndCoverage24 @CMpdpindlis @BnC_Part8_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify all sections for Ind LIS1 member on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
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
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | TID   |username |password  |MemUserName| planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | AlternativeDrugList   | name        | memberid   | effectivedate | monthlypremium | extrahelp            |
      | 15244 |qavgogine| qavgogine|q3_sep_UAT4_AARP163| PDP| Individual_BnC | LIS 1     | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | Alternative Drug List | ECADEA DCAA | 0197331001 | 05/01/2018    | Not Available  | Extra Help Level : 1 |
    
      #TC22_NON LIS Ind Village_member_ Drug Cost table
  @memAuth_benefitsAndCoverage18 @CMFedNonLisVillage  @BnC_Part8_memAuth
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Village nonLis member validates text in table
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
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
      | TID   |username |password  |MemUserName| planType | memberType| copayCategory | name                | memberid     | effectivedate | monthlypremium |
      | 15367 |qavgogine| qavgogine|q4_cosmos_gen_047 |MAPDVill | Individual_BnC | NON LIS | FDABEAAA  EAFDBEAAA | 973055947-00 | 01/01/2019    | Not Available  |   
      
 ######################################################################################################## 
 
  @benefitsAndCoverage40 @F250386 @MedicalDeductibleCards @GroupNoDeductible @Mar_release_2019 @BnC_Part8_memAuth
  Scenario Outline: UserStory: <UID> -plan: <planType> -memberType: <memberType> - Verify Deductible cards for no deductible
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Copay Category | <copayCategory> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the deductible card for no deductible member

    Examples: 
      | UID       |username |password  |MemUserName| planType | memberType   |
     # note: need to find a MA Group user that has the PLAN DEDUCTIBLE tile with content There is no deductible for this plan
      | US1564217 |qavgogine| qavgogine|q2_jun_grp0417  | MAGroup_BnC  | NoDeductible |
      | US1564217 |qavgogine| qavgogine|q1_feb_uhc_eft011| MAPDGroup_BnC | NoDeductible |

  @benefitsAndCoverage41 @F250386 @MedicalDeductibleCards @GroupSingleDeductible @Mar_release_2019 @BnC_Part8_memAuth
  Scenario Outline: UserStory: <UID> -plan: <planType> -memberType: <memberType> -Verify Deductible cards for Single deductible
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Copay Category | <copayCategory> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the deductible card for Single deductible member
      | DeductibleAmount1 | <deductible1> |

    Examples: 
      | UID       |username |password  |MemUserName| planType | memberType | deductible1 |
      | US1564214 | qavgogine| qavgogine|q2_jun_grp0390| MAGroup_BnC   | SingleDeductible | $198|
      | US1564214 |qavgogine| qavgogine| q2_jun_grp0372 |MAPDGroup_BnC | SingleDeductible | $250|

  @benefitsAndCoverage42 @F250386 @MedicalDeductibleCards @GroupDualDeductible @Mar_release_2019 @BnC_Part8_memAuth
  Scenario Outline: UserStory: <UID> -plan: <planType> -memberType: <memberType> - Verify Deductible cards for Dual deductible
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then The user navigate to Benefits and Coverage page
    And the user validates the deductible card for Dual deductible member
      | DeductibleAmount1 | <deductible1> |
      | DeductibleAmount2 | <deductible2> |

    Examples: 
      | UID       |username |password  |MemUserName| planType     | memberType     | deductible1 | deductible2 |
      | US1564213 |qavgogine| qavgogine| q2_jun_grp0376|MAGroup1_BnC | DualDeductible | $150     | $250        |
      | US1564213 |qavgogine| qavgogine|q2_jun_grp0443| MAGroup2_BnC | DualDeductible | $1,408   | $198        |
 