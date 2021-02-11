@benefitsAndCoverage @thePredators @codeMonkeys
Feature: 1.01 Member  benefits and Coverage page  - Member Auth Prod

  Background: If run on stage then feature security flag needs to be true
     Given feature security flag must set to true when testing on test env
      | Feature           | UCPBenefits |

  #TO BE DEPRECATED
  #TC05_Primarycareprovider_specialist_withoutprovidertiering
  #@prod_benefitsAndCoverage4 @OfficeVisitswithoutprovidertiering @regression @prod_BnC_Part2 
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Office visits widget for a member withoutprovidertiering
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> | 
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigate to Benefits and Coverage page
    And the user validates the Office Visits section

    Examples: 
      | index | TID   |username  | password  | MemUserName | planType | memberType |
      | 01    | 15088 |kkumard | mnrs786@ |jan06450 | MAPD   | memberWithoutProviderTiering_BnC |
      
      
  #TC10_Benefits_for_TexasERSMember
  @prod_benefitsAndCoverage3 @BenefitsforTexasERSMember @regression @Pdp_TexasersGroup
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Benefits for TexasERSMember
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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
      | index | TID   |username  | password  | MemUserName | planType | memberType    |

      | 02    | 15093 |kkumard | tnps459#|HARRELLM2000| PDP      | COMBO_TEXASERSGroup_BnC |

        
  #TC11_Benefits_for_Ship_member
  #note: this scenario covers multiple testcases TID 15094,15240

  @prod_benefitsAndCoverage22 @CMShip @prod_BnC_Part3  @bnc_sanity_ship
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify that Page Headers are in place on Benefits and Coverage page

    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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
        | Plan Code | <planCode> | 
	   | State Code | <stateCode> |

    Examples: 

      | index |TID |username |password |MemUserName|planType|memberType|language|PlanBenefitsTable|numberOfBenefitCards|Identifier| count| rider   | planCode | stateCode |
      | 03    |15094|kkumard|tnps459#|Gcdurant3| SHIP |SHIP_BnC  | ENGLISH|Plan Benefits Table| 7 |EffectiveShipMedSupp|3| NoRider | G01 | LA |

      
  #TC13_Benefits_for_MA_SSUP_MEDSUPMember
  @prod__benefitsAndCoverage10 @BenefitsForMAMedsupSSUPMember @regression @Links_Validation_SSUP
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the Benefits for a  MA Member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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
      | index | TID   |username |password|MemUserName| planType | memberType|Identifier| count | rider  |
      | 04    | 15098 | kkumard|mnrs786@|1sirsteven@gmail.com |SSUP  | COMBO_Group_BnC      |GrpEffectiveSSUP| 4     | NoRider |

  #TC15_Ancilliary Benefits for Group member(MA,MAPD)
  @prod__benefitsAndCoverage21 @CMAncillarysection2  @prod_BnC_Part4 
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify CMAncillarysection2 section is in place on Benefits and Coverage page for nonLis member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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

    Examples:  
      | index | TID   |username |password  |MemUserName |  planType | memberType| copayCategory |
      | 05    | 15238 |kkumard| mnrs786@| dhcbhansen7 |MAPD| Group_Ancillary_BnC | NON LIS    |
 
  #TC16-Part1_Ancilliary Benefits for Group member(PDP and other than Group members)
  @prod__benefitsAndCoverage32_1 @ancillarybenefitnegativescenarioscodemonkeys @AncillaryBenefit_Negative 
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify ancillary benefits are not displayed other than Group nonLis memnbers
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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

      | index | TID   |username |password  |MemUserName | planType| memberType| copayCategory |Identifier      | count | rider   |
      | 06    | 15239 | kkumard | tnps459# |LeanoraF|PDP      | Group_BnC | NON LIS       |GrpEffectiveUHC | 3     | NoRider |
     #switched user to match the one on stage
     # | 06    | 15239 | kkumard | tnps459# |padawson|PDP      | Group_BnC | NON LIS       |GrpEffectiveUHC | 3     | NoRider |

    
     #15238 is deprecated 
     # | 15238 | kkumard| mnrs786@|APRILSSPACE1 |MAPD| Individual_BnC | NON LIS |IndEffectiveAARP | 7   | Rider |

      | index | TID   |username |password  |MemUserName | planType| memberType| copayCategory |Identifier      | count | rider   |
      | 06    | 15239 | kkumard | mnrs786@ |padawson|PDP      | Group_BnC | NON LIS       |GrpEffectiveUHC | 3     | NoRider |
    
     #15238 is deprecated 
     # | xx    | 15238 | kkumard| mnrs786@|APRILSSPACE1 |MAPD| Individual_BnC | NON LIS |IndEffectiveAARP | 7   | Rider |

      
  #TC19_Ways To Save should come only for PDP members (Saver,Walgreen,Preferred, Symphonix)
  @prod_benefitsAndCoverage5 @WaystoSaveforPdp @regression @SavePdpWidget
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify the ways to save  widget for a PDP member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigate to Benefits and Coverage page
    And the user validates the ways to save section
  
    Examples: 
      | index | TID   |username |password|MemUserName       | planType | memberType  |
      | 07    | 15242 |kkumard| mnrs786@| bluefury1502@gmail.com|PDP       | Wallgreens_BnC  |
      | 08    | 15243 |kkumard| mnrs786@|BHTRUE1           |PDP       | MailOrderPharamacy_BnC |
      

    #TC19_Ways To Save should come only for PDP members (Saver,Walgreen,Preferred, Symphonix)
  @benefitsAndCoverage5 @WaystoSaveforPdp @regression @deprecated
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
      | 15249 |kkumard| mnrs786@| mwsotak1963      |MAPD      | withoutWaysToSave_BnC  |  
      

  #TC21_PDP_LIS(3,4)- Retail Drug Cost Table
  @prod__benefitsAndCoverage1  @PDPLIS3member @prod_BnC_Part5 @bnc_sanity_pdp
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Group LIS 3/4 on Benefits and Coverage page

    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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
   # And the user validated the Look up Drugs link
    And the user validates Look Up Drugs button should be visible
      | Plan Type | <planType> |
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
      | index | TID   |username |password  |MemUserName| planType| memberType| copayCategory | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | AlternativeDrugList   |
      | 09    | 15248 |kkumard|  mnrs786@|Melw4344|PDP | PDPLIS_BnC | LIS 3  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary         | Alternative Drug List |
            

  #TC25_Group members_MAPD_LIS(3,4)
  @prod__benefitsAndCoverage1  @CMGroupmembersTC25  @prod_BnC_Part6 @bnc_sanity_mapd
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Group LIS 3/4 on Benefits and Coverage page

    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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

      | index | TID   | username |password  | MemUserName|planType|memberType | copayCategory | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List |

      | 10    | 15247 |kkumard| tnps459#|jstobbie1| MAPD|Group_BnC| LIS 3|Summary Of Benefits|Evidence of Coverage| Comprehensive Formulary         |

      
  #TC26_Group members_PDP_LIS(1,2)
  @prod__benefitsAndCoverage2  @CMGroupmembersPDPLIS_TC26 @prod_BnC_Part6 
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify Group LIS 1/2 values on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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
      | index | TID   |username |password  |MemUserName| planType | memberType| copayCategory | SummaryofBenefits | EvidenceofCoverage   | ComprehensiveFormularyDrug List |
      | 11    | 15369 | kkumard| mnrs786@|lilliebell|PDP | Group_BnC | LIS 1 | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary |
     
  #TC23_Group NON LIS_MAPD
  @prod__benefitsAndCoverage23 @CMMapdGroupNonLis @Group_Mapd_NonLis 
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify all sections for Group NonLIS member on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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
     | index  | TID|username |password  |MemUserName| planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | UpdatedLanguage | DisplayFlag |
     | 12    |15246|kkumard| mnrs786@|bcatal01 |MAPD | Group_BnC | NON LIS | ENGLISH| Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary | Tier 2  | true |
      
  #TC24_Group NON LIS_PDP
  @prod__benefitsAndCoverage27 @CMPDPGroupNonLis @prod_BnC_Part7 
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify all sections for PDP Group NonLIS member on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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
    And the NON-LIS PDP group user should see drug cost table for non Lis members
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
      | index | TID   |username |password  |MemUserName| planType | memberType | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List | name           | memberid   | effectivedate | monthlypremium | UpdatedLanguage | DisplayFlag |

  #TC21_MAPD_LIS(1,2)- Retail Drug Cost Table
  @bnc_sanityMapd_Individual
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify PDF section is in place on Benefits and Coverage page for Lis user

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
     # | Plan Type | <planType> |
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
    And the user clicks on More Information link
    And the user validates contactus section

    Examples: 
      | index | TID   |username |password  |MemUserName  | planType | memberType     | copayCategory |  name        |memberid      | effectivedate| monthlypremium | extrahelp            |Identifier       | count | rider   |

      | 13    | 15366 |kkumard| tnps459#|LeanoraF |PDP| Group_BnC| NON LIS | ENGLISH | Summary Of Benefits | Evidence of Coverage | Comprehensive Formulary         | PETER DAWSON | 0108537701 | 01/01/2013    | Not Available  | Tier 2          | true        |     

      
  #TC22_NON LIS Ind plan member(PDP)- Drug Cost table
  @prod_benefitsAndCoverage15 @CMFedPDPNonLis @Nonlis_Pdp
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify all sections for PDP Ind NonLIS member on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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
    And the user validates Ind plan overview
      | Name            | ECADEA DCAA   |
      | Member ID       | 0197331001    |
      | Effective Date  | 05/01/2018    |
      | Monthly premium | Not Available |
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

      | index | TID   | username | password  | MemUserName| planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | AlternativeDrugList   | UpdatedLanguage | DisplayFlag | Identifier       | count | rider   |
      | 16    | 15377 | kkumard  | tnps459#  | cmc29501   | PDP      | Individual_BnC | NON LIS       | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | Alternative Drug List | Tier 2          | true        | EffectivePDPAARP | 4     | NoRider |

      
   @prod__benefitsAndCoverage30  @hartfordprescriptionDrugBenefit @Greenwich_Hartford_Drugtable
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify city of Hartford Prescription Drug Benefits
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates City of Hartford prescription Drug Benefits table

    Examples: 
      | index | TID   |username |password  |MemUserName| planType | memberType   |
      | 17    | 15367 |kkumard| mnrs786@| MHAB57 | MAPD     | Hartford_BnC |   
      
  @prod_benefitsAndCoverage31 @TownOfGreenwichprescriptionDrugBenefit @Greenwich_Hartford_Drugtable
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify town of greenwich Prescription Drug Benefits
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
    And the user validates Town Of Greenwich table

    Examples: 
      | index | TID   |username |password |MemUserName| planType | memberType    |
      | 18    | 15367 |kkumard| mnrs786@ | Riverside43 | MAPD   | Greenwich_BnC |    
      
 @prod__benefitsAndCoverage24 @CMpdpindlis @prod_BnC_Part8 
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify all sections for Ind LIS1 member on Benefits and Coverage page
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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
      | index | TID   |username |password  |MemUserName| planType | memberType     | copayCategory | language | SummaryofBenefits   | EvidenceofCoverage   | ComprehensiveFormularyDrug List     | AlternativeDrugList   | name        | memberid   | effectivedate | monthlypremium | extrahelp            |
      | 19    | 15244 |kkumard| mnrs786@|jfesig1@comcast.net| PDP | Individual_BnC | LIS 1         | ENGLISH  | Summary of Benefits | Evidence of Coverage | Comprehensive Formulary - Drug List | Alternative Drug List | ECADEA DCAA | 0197331001 | 05/01/2018    | Not Available  | Extra Help Level : 1 |

  @prod_benefitsAndCoverage18 @DSNP_CnS
  Scenario Outline: Index: <index> -FID: <FID> -plan: <planType> -memberType: <memberType> - Verify  Medical copays or coinsurance section and Out-of-pocket maximum section for DSNP members
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
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
    And the user validates headers on Bnc page for Dsnp indi members
      | Plan Type | <planType> |
    And the user validates the Out of Pocket Max section for Dsnp indi member
    	 | Plan Type | <planType> |
    And the user view the LIS Drug Copays & Discounts header
    And the user validates Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates Look Up Drugs button should be visible
      | Plan Type | <planType> |
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
      | Plan Type | <planType> |
    And the user validates the Learn More section link for stage
    And the user validates tier link should not display
    And the user validates view and document label
    And the user validates static links
      | Plan Type | <planType> |
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
      | Language | <language> |
    And the user clicks on More Information link
    And the user validates contactus section
	
    @prod_DSNP_CnS01
    Examples: 
      | index | FID             |username |password  |MemUserName| planType   | memberType           | copayCategory | language | name         | memberid     | effectivedate | monthlypremium | extrahelp            | Identifier       | count | H-PBP    | rider  |
      | 20-c1 | F494433,F506320 |kkumard  | mnrs786@ |testUserName| DSNP_MAPD  | Individual_CnS01_BnC | LIS 2         | ENGLISH  | DREENA KIMURA| 971949191-00 | 01/01/2020    | Not Available  | Extra Help Level : 2 | IndEffectiveAARP |     6 | H0624-001| NoRider|
      | 21-c2 | F494433,F506320 |kkumard  | mnrs786@ |testUserName| DSNP_MAPD  | Individual_CnS02_BnC | LIS 3         | ENGLISH  | EBER KRYSTEK| 903010063-00 | 01/01/2020    | Not Available  | Extra Help Level : 3 | IndEffectiveAARP |     6 | H2228-045| NoRider|
    
    @prod_DSNP_CnS02
    Examples:       
      | index | FID             |username |password  |MemUserName| planType   | memberType           | copayCategory | language | name         | memberid     | effectivedate | monthlypremium | extrahelp            | Identifier       | count | H-PBP    | rider  |
      | 22-c3 | F494433,F506320 |kkumard  | mnrs786@ |testUserName| DSNP_MAPD  | Individual_CnS03_BnC | LIS 1         | ENGLISH  | HULDIBERAH KINIRY | 967076552-1 | 01/01/2020 | Not Available  | Extra Help Level : 1 | IndEffectiveAARP |     6 | H3113-110| NoRider|
      | 23-c4 | F494433,F506320 |kkumard  | mnrs786@ |testUserName| DSNP_MAPD  | Individual_CnS04_BnC | LIS 1         | ENGLISH  | BLAIS OWEN        | 912002942-1 | 01/01/2020 | Not Available  | Extra Help Level : 1 | IndEffectiveAARP |     6 | H4527-003| NoRider|
      | 24-c5 | F494433,F506320 |kkumard  | mnrs786@ |testUserName| DSNP_MAPD  | Individual_CnS05_BnC | LIS 2         | ENGLISH  | KUMARI FROEHNER   | 006644986-1 | 01/01/2020 | Not Available  | Extra Help Level : 2 | IndEffectiveAARP |     6 | H4590-033| NoRider|
    
    @prod_DSNP_MnR01
    Examples:       
       | index | FID             |username |password  |MemUserName| planType   | memberType           | copayCategory | language | name         | memberid     | effectivedate | monthlypremium | extrahelp            | Identifier       | count | H-PBP    | rider  |
       | 25-m1 | F494433,F506320 |kkumard  | mnrs786@ |testUserName| DSNP_MAPD  | Individual_MnR01_BnC | LIS 1         | ENGLISH  | OFER MCLEON  | 937024725-1| 01/01/2020    | Not Available  | Extra Help Level : 1 | IndEffectiveAARP |     6 |  H0271-005 |  NoRider|
       | 26-m2 | F494433,F506320 |kkumard  | mnrs786@ |testUserName| DSNP_MAPD  | Individual_MnR02_BnC | LIS 1         | ENGLISH  | DBAD ADFED | 919744565-00 | 01/01/2020    | Not Available  | Extra Help Level : 1 | IndEffectiveAARP |     6 |  H5253-041 | NoRider |

    @prod_DSNP_MnR02
    Examples:      
       | index | FID             |username |password  |MemUserName| planType   | memberType           | copayCategory | language | name         | memberid     | effectivedate | monthlypremium | extrahelp            | Identifier       | count | H-PBP    | rider  |
       | 27-m3 | F494433,F506320 |kkumard  | mnrs786@ |testUserName| DSNP_MAPD  | Individual_MnR03_BnC | LIS 1         | ENGLISH  | DBAD ADFED | 919744565-00 | 01/01/2020   | Not Available   | Extra Help Level : 1 | IndEffectiveAARP |     6 |  R2604-004 | NoRider|
       | 28-m4 | F494433,F506320 |kkumard  | mnrs786@ |testUserName| DSNP_MAPD  | Individual_MnR04_BnC | LIS 3         | ENGLISH  | DBAD ADFED | 919744565-00 | 01/01/2020    | Not Available  | Extra Help Level : 3 | IndEffectiveAARP |     6 |  H0271-006 | NoRider|

  @prod_benefitsAndCoverage19 @insulin
  Scenario Outline: Index: <index> -FID: <FID> -plan: <planType> -memberType: <memberType> -copayCategory: <copayCategory> -insulin: <insulin> - Verify Insulin Demo display on drug table for NON-LIS user
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
      | Copay Category | <copayCategory> |
    Then The user navigates to Benefits and Coverage page
      | Plan Type | <planType> |
	And the user validate drug cost table display behavior
      | Plan Type      | <planType>      |
      | Member Type    | <memberType>    |
      | Copay Category | <copayCategory> |
      | Deductible | <deductible> |
      | Insulin | <insulin> |
    Then validates LEARN MORE ABOUT DRUG TIERS link content for user with insulin
	
    #@prod_hasInsulin_mapd_NoD
    #Examples: 
    #  | index  | FID    | username | password  | MemUserName        | planType  | memberType     | copayCategory | deductible   | insulin      | note |
    #  | 31-I01 | 478830 | kkumard  | mnrs786@  | testUserName       | MAPD      | Individual_BnC | NON LIS       | NoD          | hasInsulin   |  H0543-205-000 - new UI|  

    #@prod_hasInsulin_mapd_T12NoD_T345D
    #Examples: 
    #  | index  | FID    | username | password  | MemUserName        | planType  | memberType     | copayCategory | deductible   | insulin      | note |
    #  | 31-I02 | 478830 | kkumard  | mnrs786@  | testUserName       | MAPD      | Individual_BnC | NON LIS       | T12NoD_T345D | hasInsulin   |  H2228-096-000 - new UI|  

    #@prod_hasInsulin_mapd_T123NoD_T45D
    #Examples: 
    #  | index  | FID    | username | password  | MemUserName        | planType  | memberType     | copayCategory | deductible   | insulin      | note |
    #  | 31-I03 | 478830 | kkumard  | mnrs786@  | testUserName       | MAPD      | Individual_BnC | NON LIS       | T123NoD_T45D | hasInsulin   |   H0294-017-000 - new UI| 
     

    #@prod_hasInsulin_pdp_NoD
    #Examples: 
    #  | index  | FID    | username | password  | MemUserName        | planType  | memberType     | copayCategory | deductible   | insulin      | note |
    #  | 31-I04 | 478830 | kkumard  | tnps459#  | DEBBERNARDO@55     | PDP       | Individual_BnC | NON LIS       | NoD          | hasInsulin   |   S5820-002-000| 


    @prod_hasInsulin_csnpPcp_NoD
    Examples: 
      | index  | FID    | username | password  | MemUserName        | planType  | memberType     | copayCategory | deductible   | insulin      | note |

      | 31-I05 | 478830 | kkumard  | tnps459#  | Washington1965     | CSNP_PCP  | Individual_BnC | NON LIS       | NoD          | hasInsulin   | H1045-018-000|


    @prod_hasInsulin_csnpMapd_T123NoD_T45D
    Examples: 
      | index  | FID    | username | password  | MemUserName        | planType  | memberType     | copayCategory | deductible   | insulin      | note |
      | 31-I06 | 478830 | kkumard  | mnrs786@  | Rzwobot            | CSNP_MAPD | Individual_BnC | NON LIS       | T123NoD_T45D | hasInsulin   | H1045-048-004|


    #@prod_hasInsulin_isnpMapd_T123NoD_T45D
    #Examples: 
    #  | index  | FID    | username | password  | MemUserName        | planType  | memberType     | copayCategory | deductible   | insulin      | note |
    #  | 31-I07 | 478830 | kkumard  | tnps459#  | testUserName       | ISNP_MAPD | Individual_BnC | NON LIS       | T123NoD_T45D | hasInsulin   |  H0294-017-000|    


    @prod_nonInsulin_mapd_NoT
    Examples: 

      | index  | FID    | username | password  | MemUserName        | planType  | memberType     | copayCategory | deductible   | insulin      | note |
      | 34-I08 | 478830 | kkumard  | tnps459#  | ecueto1            | CSNP_PCP  | Individual_BnC | LIS 2         | NoTier       | nonInsulin   | H1045-018-000| 


    #@prod_nonInsulin_mapd_T12345
    #Examples: 
    #  | index  | FID    | username | password  | MemUserName        | planType  | memberType     | copayCategory | deductible   | insulin      | note |

    #  | 34-I09 | 478830 | kkumard  | tnps459#  | testUserName       | MAPD      | Individual_BnC | NON LIS       | T12345       | nonInsulin   |   H0271-017-000| 

  @prod_benefitsAndCoverage24 @prod_api
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify UCPBenefits API not having undefined input value
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user navigate to Benefits and Coverage page
    And the users validate Benefits page has combo tabs for combo users
    And the users validate UCPBenefits related API requests are not having undefined input value

	@prod_comboApi
    Examples: 
      | index | TID   | username | password  | MemUserName              | planType | memberType   |
      | 35    | xxxxx | kkumard  | tnps459#  | VirginiaRuth1936         | COMBO    | SHIP_FED_BnC |
      | 36    | xxxxx | kkumard  | tnps459#  | nino2@theciliangroup.com | COMBO    | FED_SHIP_BnC |
      | 37    | xxxxx | kkumard  | tnps459#  | DKELLY27                 | COMBO    | FED_FED_BnC  |

	@prod_singleApi
    Examples: 
      | index | TID   | username | password  | MemUserName              | planType | memberType   |
      | 38    | xxxxx | kkumard  | tnps459#  | ssmhi1                   | MA       | FED_BnC      |
      | 39    | xxxxx | kkumard  | tnps459#  | kirit1976                | MAPD     | FED_BnC      |
      | 40    | xxxxx | kkumard  | tnps459#  | lkd3408                  | PDP      | FED_BnC      |

  @prod_benefitsAndCoverage25 @prod_api
  Scenario Outline: Index: <index> -TID: <TID> -plan: <planType> -memberType: <memberType> - Verify UCPBenefits API not having undefined input value
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
      | Retry | true |
    And user clicks on member to select
    And user stores test input for validations
      | Username | <MemUserName> |
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then The user will not be able to navigate to Benefits and Coverage page

	@prod_singleApi
    Examples: 
      | index | TID   | username | password  | MemUserName              | planType | memberType   |
      | 41    | xxxxx | kkumard  | tnps459#  | Patkeving                | TERM     | FED_BnC      |
      | 42    | xxxxx | kkumard  | tnps459#  | erbenoit56               | TERM     | PDP_FED_BnC  |
     # unable to search user 
     # | 43    | xxxxx | kkumard  | tnps459#  | SWHITE33436              | TERM     | PCP_FED_BnC  |    
     
  @prod_benefitsAndCoverage26 @prod_rider
  Scenario Outline: Index: <index> -FID: <FID> -plan: <planType> -memberType: <memberType> - Verify Rider tile display
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
	And the user validate rider tile is displayed
	
    Examples: 
      | index  | FID    | username | password  | MemUserName        | planType  | memberType           |

      | 44     | xxxxxx | kkumard  | tnps459#  | JohnPrais          | MAPD      | Individual_Rider_BnC |      

