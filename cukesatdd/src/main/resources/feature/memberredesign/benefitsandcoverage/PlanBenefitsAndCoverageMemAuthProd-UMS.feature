@benefitsAndCoverage @thePredators @codeMonkeys
Feature: 1.01 Member  benefits and Coverage page  - Member Auth Prod

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPBenefits |

###############################Regression Scenarios Begin Here ########################################
  #TC01_OutpatientSurgeryCentervisits_withprovidertiering
  @memAuth_benefitsAndCoverage6 @outpatientcenterwithprovidertier @thepredators @regressionoutpatient @prod_BnC_Part1 
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
      | TID   | username  | password  | MemUserName  | planType  | memberType |
      | 15084 | ashah120  | Mnrqa002  |  2jseelin | MAPD   | providerTier_BNC |
      
 #TC02_Primarycareprovider_specialist_withprovidertiering
  @benefitsAndCoverage7 @primarycareproviderspecialist @thepredators @regressionprimarycareprovider @prod_BnC_Part1 
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
      | TID   | username  | password | MemUserName | planType| memberType  |
      | 15085 |ashah120 | Mnrqa002 |JUDYSTOKES7@GMAIL.COM	| MAPD| COSMOSOfficevisit_BnC |
 

  #TC04_OutpatientSurgeryCentervisits_withoutprovidertiering
  @memAuth_benefitsAndCoverage8 @outpatientcenterwithoutprovidertier @thepredators @regressionoutpatientwithoutprovider @outpatientcenterMapd 
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
      | 15087 | ashah120 | Mnrqa002 | JUDYSTOKES7@GMAIL.COM | MAPD      | Individual_BnC |  NON LIS      |


   #TC05_Primarycareprovider_specialist_withoutprovidertiering
  @benefitsAndCoverage4 @OfficeVisitswithoutprovidertiering @regression @prod_BnC_Part2 
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
      | TID   |username  | password  | MemUserName | planType | memberType |
      | 15088 |ashah120 | Mnrqa002 |jan06450 | MAPD   | memberWithoutProviderTiering_BnC |
      
       #TC07_Copay_Coinsurance_in_DrugCostsTable 
  @benefitsAndCoverage11 @CopayCoinsuranceInDrugCostTable @regression @prod_BnC_Part2     
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
    
    @devRegression
    Examples: 
      | TID   |username  | password  | MemUserName  |  planType | memberType     | copayCategory     |
      | 15090 |ashah120 | Mnrqa002 |JUDYSTOKES7@GMAIL.COM| MAPD     | Individual_BnC | NON LIS          |
      
   #TC08_BenefitsFor_ComboMembers                                          
  @benefitsAndCoverage12 @BenefitsForCombo @regression @combo_Benefits
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

    Examples: #81aleanjackson
      | TID   |username  | password  | MemUserName | planType | memberType |
      | 15091 |ashah120  |Mnrqa002 | 81aleanjackson|SHIP_HIP    | ComboFEDShip_BnC |
      
  #TC10_Benefits_for_TexasERSMember
  @benefitsAndCoverage3 @BenefitsforTexasERSMember @regression @Pdp_TexasersGroup
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

    @devRegression
    Examples: 
      | TID   |username  | password  | MemUserName | planType | memberType    |
      | 15093 |ashah120 | Mnrqa002|HARRELLM2000| PDP      | TEXASERSGroup_BnC |
        
  #TC11_Benefits_for_Ship_member
  #note: this scenario covers multiple testcases TID 15094,15240
  @memAuth_benefitsAndCoverage22 @CMShip @prod_BnC_Part3
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
    And the user verifies that the correct pdfs are coming in the plan material section
      | Plan Benefits Table | <PlanBenefitsTable> |
    And the user validates for ship see more ways to contact us section
    And the user validates for ship member on clicking contact us link it should route to contact us page
    And the user clicks on More Information link for ship
    Then the user validate Value Add Service page comes on clicking additional info button
    And the user validate vas tiles on vas page

    Examples: 
      |TID |username |password |MemUserName|planType|memberType|language|PlanBenefitsTable |numberOfBenefitCards|Identifier| count| rider   |
      |15094|ashah120|Mnrqa002|Gcdurant3| HIP |SHIP_BnC  | ENGLISH|Plan Benefits Table| 7 |EffectiveShipMedSupp|3| NoRider |
      
 #TC12_Benefits_for_MedicaMember
  @memAuth_benefitsAndCoverage12_1 @CMFedDrugNonLis  @Medica_Nonlis
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
      | TID   |username |password |MemUserName| planType|memberType|copayCategory|language|SummaryofBenefits  | EvidenceofCoverage  |ComprehensiveFormularyDrug List    |AlternativeDrug List |language1| SummaryofBenefitsSpanish | EvidenceofCoverageSpanish  | ComprehensiveFormularyDrug ListSpanish | AlternativeDrug ListSpanish 	| language2 | SummaryofBenefitsChinies | EvidenceofCoverageChinies | ComprehensiveFormularyDrug ListChinies | AlternativeDrug ListChinies | name        | memberid     | effectivedate| monthlypremium|UpdatedLanguage| DisplayFlag|Identifier | count| rider|
      | 15095 |ashah120|Mnrqa002|SUSICHAPMAN@GMAIL.COM| Medica  |Individual_BnC|NON LIS      |ENGLISH |Summary of Benefits| Evidence of Coverage|Comprehensive Formulary - Drug List|Alternative Drug List| 1  | Resumen de Beneficios    | Comprobante de Cobertura  | Formulario Completo                    | Lista de Medicamentos Alternativos | 2   |                          |                           |                                      |       | AADECDC FEDFACEDBACBB | 954283936-00 | 04/01/2018 | Not Available | Tier 2        | true       |IndEffectiveMedica| 6| NoRider |

#TC13_Benefits_for_MA_SSUP_MEDSUPMember
  @memAuth_benefitsAndCoverage10 @BenefitsForMAMedsupSSUPMember @regression @Links_Validation_MA
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Benefits for a  MA Member
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
      | TID   |username |password|MemUserName| planType | memberType|Identifier| count | rider  |
      | 15096 |ashah120|Mnrqa002| ESCHU585@GMAIL.COM |MA | Individual_BnC |IndEffectiveUHC| 5  | Rider   |
      
  #TC13_Benefits_for_MA_SSUP_MEDSUPMember
  @memAuth_benefitsAndCoverage10 @BenefitsForMAMedsupSSUPMember @regression @Links_Validation_SSUP
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Benefits for a  MA Member
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
      | TID   |username |password|MemUserName| planType | memberType|Identifier| count | rider  |
      | 15098 | ashah120|Mnrqa002|1sirsteven@gmail.com |SSUP  | COMBO_Group_BnC      |GrpEffectiveSSUP| 4     | NoRider |

  #TC14_Benefits_for_PCPMember
  @memAuth_benefitsAndCoverage14_2 @CMFedDrugNonLis  @Pcp_Medica_Nonlis
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
    #note: moved to footer feature
    #And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section
    Examples: 
      
    | TID   |username |password  |MemUserName   | planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   |  ComprehensiveFormularyDrug List     | AlternativeDrug List  | language1 | SummaryofBenefitsSpanish | EvidenceofCoverageSpanish | ComprehensiveFormularyDrug ListSpanish | AlternativeDrug ListSpanish        | language2 | SummaryofBenefitsChinies | EvidenceofCoverageChinies |  ComprehensiveFormularyDrug ListChinies | AlternativeDrug ListChinies | name        | memberid     | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |Identifier      | count | rider   |
    | 15097 |ashah120| Mnrqa002|BATLLOT@AOL.COM| PCP      | Individual_BnC | NON LIS      | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List  | Alternative Drug List | 1  | Resumen de Beneficios    | Comprobante de Cobertura   | Formulario Completo                    | Lista de Medicamentos Alternativos       | 2      |                          |                           |                                        |                           | BDFAEC CBADEADF | 945007888-00 | 01/01/2018    | Not Available  | Tier 2          | true  |IndEffectivePCP | 6     | NoRider |
 
  #TC15_Ancilliary Benefits for Group member(MA,MAPD)
  @memAuth_benefitsAndCoverage21 @CMAncillarysection2  @prod_BnC_Part4 
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
      | TID   |username |password  |MemUserName |  planType | memberType| copayCategory |
      | 15238 |ashah120| Mnrqa002| dhcbhansen7 |MAPD| Group_BnC_Ancillary | NON LIS    |
 
 #TC16-Part1_Ancilliary Benefits for Group member(PDP and other than Group members)
  @memAuth_benefitsAndCoverage32_1 @ancillarybenefitnegativescenarioscodemonkeys @AncillaryBenefit_Negative 
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
     | 15239 | ashah120| Mnrqa002|BIGDADDY0808|PDP  | Group_BnC  | NON LIS     |GrpEffectiveUHC | 3     | NoRider |
      | 15238 | ashah120| Mnrqa002|APRILSSPACE1 |MAPD| Individual_BnC | NON LIS |IndEffectiveAARP | 7   | Rider |
      
  #TC19_Ways To Save should come only for PDP members (Saver,Walgreen,Preferred, Symphonix)
  @benefitsAndCoverage5 @WaystoSaveforPdp @regression @SavePdpWidget
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
      | TID   |username |password|MemUserName       | planType | memberType  |
      | 15242 |ashah120| Mnrqa002| bluefury1502@gmail.com|PDP       | Wallgreens_BnC  |
      | 15243 |ashah120| Mnrqa002|BHTRUE1           |PDP       | MailOrderPharamacy_BnC |
      
    #TC19_Ways To Save should come only for PDP members (Saver,Walgreen,Preferred, Symphonix)
  @benefitsAndCoverage5 @WaystoSaveforPdp @regression @SavePdpWidgetMapd
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
      | TID   |username |password|MemUserName       | planType | memberType  |
      | 15249 |ashah120| Mnrqa002| mwsotak1963      |MAPD      | withoutWaysToSave_BnC  |  
      
#TC21_PDP_LIS(3,4)- Retail Drug Cost Table
  @memAuth_benefitsAndCoverage1  @PDPLIS3member @prod_BnC_Part5
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
      | 15248 |ashah120|  Mnrqa002|Melw4344|PDP | PDPLIS_Bnc | LIS 3  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary         | Alternative Drug List |
            
   #TC25_Group members_MAPD_LIS(3,4)
  @memAuth_benefitsAndCoverage1  @CMGroupmembersTC25  @prod_BnC_Part6 
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
      | 15247 |ashah120| Mnrqa002|GLORIA9494| MAPD|Group_BnC| LIS 4|Summary Of Benefits|Evidence of Coverage| Comprehensive Formulary         |
      
 #TC26_Group members_PDP_LIS(1,2)
  @memAuth_benefitsAndCoverage2  @CMGroupmembersPDPLIS_TC26 @prod_BnC_Part6 
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
    
    @devRegression
    Examples: 
      | TID   |username |password  |MemUserName| planType | memberType| copayCategory | SummaryofBenefits | EvidenceofCoverage   | ComprehensiveFormularyDrug List |
      | 15369 | ashah120| Mnrqa002|lilliebell|PDP | Group_BnC | LIS 1 | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary |
     
#TC23_Group NON LIS_MAPD
  @memAuth_benefitsAndCoverage23 @CMMapdGroupNonLis @Group_Mapd_NonLis 
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
      | TID|username |password  |MemUserName| planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | UpdatedLanguage | DisplayFlag |
     |15246|ashah120| Mnrqa002|bcatal01 |MAPD | Group_BnC | NON LIS | ENGLISH| Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary | Tier 2  | true |
      
 #TC24_Group NON LIS_PDP
  @memAuth_benefitsAndCoverage27 @CMPDPGroupNonLis @prod_BnC_Part7 
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
      | 15366 |ashah120| Mnrqa002|BIGDADDY0808 |PDP| Group_BnC| NON LIS | ENGLISH | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         | BBBCCB FFAAFAD | 0191976081 | 01/01/2019    | Not Available  | Tier 2          | true        |     
      
 #TC21_MAPD_LIS(1,2)- Retail Drug Cost Table
 @memAuth_benefitsAndCoverage23Indi @CMmapdindlis @pdf_Verification_Lis_Mapd
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
      | TID   |username |password  |MemUserName| planType | memberType| copayCategory | language | SummaryofBenefits   | EvidenceofCoverage | ComprehensiveFormularyDrug List| AlternativeDrugList| name| memberid| effectivedate| monthlypremium | extrahelp|Identifier | count | rider   |
      | 15245 |ashah120| Mnrqa002|JamesRShuler1| MAPD| Individual_BnC | LIS 1| ENGLISH | Summary of Benefits | Evidence of Coverage |Comprehensive Formulary - Drug List | Alternative Drug List | DBAD ADFED | 919744565-00 | 01/01/2019| Not Available| Extra Help Level : 1 |IndEffectiveAARP |7|Rider |     
      
  #TC22_NON LIS Ind plan member(MAPD)- Drug Cost table
  @memAuth_benefitsAndCoverage14 @CMFedDrugNonLis  @Nonlis
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
    
   @devRegression
    Examples: 
      | TID   |username |password  |MemUserName| planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | UnitedHealth Passport Program | ComprehensiveFormularyDrug List     | AlternativeDrug List  | language1 | SummaryofBenefitsSpanish | EvidenceofCoverageSpanish | UnitedHealth Passport ProgramSpanish | ComprehensiveFormularyDrug ListSpanish | AlternativeDrug ListSpanish        | language2 | SummaryofBenefitsChinies | EvidenceofCoverageChinies | UnitedHealth Passport ProgramChinies | ComprehensiveFormularyDrug ListChinies | AlternativeDrug ListChinies | name        | memberid     | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |
      | 15378 |ashah120| Mnrqa002|K7BY@YAHOO.COM| MAPD| Individual_BnC | NON LIS       | ENGLISH  | Summary of Benefits | Evidence of Coverage | UnitedHealth Passport Program | Comprehensive Formulary - Drug List | Alternative Drug List | 1  | Resumen de Beneficios    | Comprobante de Cobertura  | Programa UnitedHealth Passport       | Formulario Completo                    | Lista de Medicamentos Alternativos | 2      |                          |                           |                                      |                                        |                             | DDCEE DAADF | 954016383-00 | 01/01/2018    | Not Available  | Tier 2          | true        |
      
 #TC22_NON LIS Ind plan member(PDP)- Drug Cost table
  @memAuth_benefitsAndCoverage15 @CMFedPDPNonLis  @Nonlis_Pdp
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
      | TID   |username |password  |MemUserName| planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | AlternativeDrugList   | name        | memberid   | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag | Identifier       | count | rider   |
      | 15377 |ashah120| Mnrqa002|cmc29501 | PDP      | Individual_BnC | NON LIS       | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | Alternative Drug List | ECADEA DCAA | 0197331001 | 05/01/2018    | Not Available  | Tier 2          | true |EffectivePDPAARP | 4     | NoRider |
      
   @memAuth_benefitsAndCoverage30  @hartfordprescriptionDrugBenefit @Greenwich_Hartford_Drugtable
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
      | 15367 |ashah120| Mnrqa002| MHAB57 | MAPD     | Hartford_BnC |   
      
  @benefitsAndCoverage31 @TownOfGreenwichprescriptionDrugBenefit @Greenwich_Hartford_Drugtable
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
      | TID   |username |password |MemUserName| planType | memberType    |
      | 15367 |ashah120| Mnrqa002 | Riverside43 | MAPD   | Greenwich_BnC |    
      
 @memAuth_benefitsAndCoverage24 @CMpdpindlis @prod_BnC_Part8 
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
      | 15244 |ashah120| Mnrqa002|jfesig1@comcast.net| PDP | Individual_BnC | LIS 1         | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | Alternative Drug List | ECADEA DCAA | 0197331001 | 05/01/2018    | Not Available  | Extra Help Level : 1 |
         
 #TC22_NON LIS Ind Village_member_ Drug Cost table
  @memAuth_benefitsAndCoverage18 @CMFedNonLisVillage  @prod_BnC_Part8
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
      | 15367 |ashah120| Mnrqa002|AFUHC2017|MAPDVill | Individual_BnC | NON LIS | FDABEAAA  EAFDBEAAA | 973055947-00 | 01/01/2019    | Not Available  |  
           
      
 ###############################Regression Scenarios END Here ####################################### 
 