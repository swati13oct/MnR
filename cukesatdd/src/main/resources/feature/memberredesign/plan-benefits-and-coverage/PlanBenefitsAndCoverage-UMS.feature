@codeMonkeys
Feature:C1.1 To test plan benefits and Coverage on UMS site


    @CMFedDrugNonLis
    Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates Ind plan overview
      | Name           | <name>  |
      | Member ID      | <memberid>|
      | Effective Date | <effectivedate>|
      | Monthly premium| <monthlypremium>|
    And the user validates headers on Bnc page for indi members
    And the user validates the Primarycare Provider section
    And the user validates the Out of Pocket Max section 
    And the user view the Drug Copays & Discounts header 
    And the user validates the Learn More section for stage and tier
    And the user validates dropdown selection functionality
    And the user validates Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates Look Up Drugs button should be visible
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
    And the user should see drug copay and discount table
       | Updated Language | <UpdatedLanguage> |
       | Display Flag     | <DisplayFlag>     | 
    And the user validates the user click on the link it expands and when user clicks it again it should collapse
    And the user validates view and document label
    And the user validates static links
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
       | Language | <language> |
    And the user verifies that the correct pdfs are coming in the plan material section
       |Summary of Benefits | <SummaryofBenefits> |
       |Evidence of Coverage| <EvidenceofCoverage> |
       |Comprehensive Formulary - Drug List| <ComprehensiveFormularyDrug List>|
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section
    
    Examples: 
       | planType|  memberType  | copayCategory | language | SummaryofBenefits    | EvidenceofCoverage       | ComprehensiveFormularyDrug List     | name    | memberid    | effectivedate | monthlypremium |   UpdatedLanguage | DisplayFlag|
       | MAPD    |  Individual  |  NON LIS      | ENGLISH  | Summary of Benefits  | Evidence of Coverage     | Comprehensive Formulary - Drug List | DDE BCBF| 006798725-01| 01/01/2018    | Not Available  | Tier 2            | true       |
      #| MAPD    |  Individual  |  NON LIS      | SPANISH  | Resumen de Beneficios| Comprobante de Cobertura | Formulario Completo                 | DDE BCBF| 006798725-01| 01/01/2018    | Not Available  | Tier 2            | true       |
      #| MAPD    |  Individual  |  NON LIS      | CHINESE  |                      |                          |                                     | DDE BCBF| 006798725-01| 01/01/2018    | Not Available  | Tier 2            | true       |
      #| Medica  |  Individual  |  NON LIS      | ENGLISH  | Summary of Benefits  | Evidence of Coverage     | Comprehensive Formulary - Drug List |
      #| Medica  |  Individual  |  NON LIS      | SPANISH  | Resumen de Beneficios| Comprobante de Cobertura | Formulario Completo                 |
      #| PCP     |  Individual  |  NON LIS      | ENGLISH  | Summary of Benefits  | Evidence of Coverage     | Comprehensive Formulary - Drug List |
      #| PCP     |  Individual  |  NON LIS      | SPANISH  | Resumen de Beneficios| Comprobante de Cobertura | Formulario Completo                 |
      
      
      @CMFedPDPNonLis
      Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates Ind plan overview
      | Name           | <name>  |
      | Member ID      | <memberid>|
      | Effective Date | <effectivedate>|
      | Monthly premium| <monthlypremium>|
    And the user view the Drug Copays & Discounts header 
    And the user validates the Learn More section for stage and tier
    And the user validates dropdown selection functionality
    And the user validates Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates Look Up Drugs button should be visible
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
    And the user should see drug copay and discount table
       | Updated Language | <UpdatedLanguage> |
       | Display Flag     | <DisplayFlag>     | 
    And the user validates the user click on the link it expands and when user clicks it again it should collapse
    And the user validates view and document label
    And the user validates links for pdp in pdf section
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
       | Language | <language> |
    And the user verifies that the correct pdfs are coming in the plan material section
       |Summary of Benefits | <SummaryofBenefits> |
       |Evidence of Coverage| <EvidenceofCoverage> |
       |Comprehensive Formulary - Drug List| <ComprehensiveFormularyDrug List>|
    And the user validates Needhelp section
    And the user clicks on More Information link
    And the user validates contactus section
    
    Examples: 
       | planType|  memberType  | copayCategory | language | SummaryofBenefits    | EvidenceofCoverage       | ComprehensiveFormularyDrug List     | name          | memberid | effectivedate | monthlypremium | UpdatedLanguage   | DisplayFlag|
       | PDP     |  Individual  |  NON LIS      | ENGLISH  | Summary of Benefits  | Evidence of Coverage     | Comprehensive Formulary - Drug List | FBFFABB AAFBCB|0131768761|03/01/2018     |Not Available   |Tier 2             |true        |
      #| PDP     |  Individual  |  NON LIS      | SPANISH  | Resumen de Beneficios| Comprobante de Cobertura | Formulario Completo                 | FBFFABB AAFBCB|0131768761|03/01/2018     |Not Available   |Tier 2             |true        |
      #| PDP     |  Individual  |  NON LIS      | CHINESE  |                      |                          |                                     | FBFFABB AAFBCB|0131768761|03/01/2018     |Not Available   |Tier 2             |true        |
      
      
    @CMFedNonLisVillage
    Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    Then the user validates text in table "no more than 44% for generic drugs or 35% for brand name drugs"
    
    Examples: 
      | planType|  memberType  | copayCategory |
      | MAPD    |  Individual  |  NON LIS      |
       
 @CMvalidatePdfsectiongroupenglish
      Scenario Outline: Verify PDF section is in place on Benefits and     Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates view and document label
    And the user validates the language dropdown and the value displayed by default should be English
   
     Examples: 
       | planType|  memberType  | copayCategory |
        | PDP     |  Group       |  NON LIS      | 
        | MAPD    |  Group       |  NON LIS      |
        | MA      |  Group       |  HMO          |
  


 @CMvalidatePdfsectiongroupspanishchinese
    Scenario Outline: Verify PDF section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates view and document label
    And the user validates spanish and chinese should not display in dropdown
 
     Examples: 
       | planType|  memberType  | copayCategory |
       | PDP     |  Group       |  NON LIS      |
       | MAPD    |  Group       |  NON LIS      |
       | MA      |  Group       |  HMO          |    

    @CMvalidatePdfsectionindividual
    Scenario Outline: Verify PDF section is in place on Benefits and     Coverage page
     Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates static links
   
            
   Examples: 
       | planType|  memberType  | copayCategory | language | 
       | PDP     |  Individual  |  NON LIS      | ENGLISH  |
      #| MAPD    |  Individual  |  NON LIS      | SPANISH  | 
      #| MAPD    |  Individual  |  NON LIS      | CHINESE  | 
   
     @CMAncillarysection1
    Scenario Outline: Verify Ancilliary section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    Then the user validates Header section
    Then the user validates Hearing section
    Then the user validates the Hearing Aid section
    Then the user validates the Vision section
    Then the user validates the Dental section
    Then the user validates chiropractic section
    
     Examples: 
       | planType|  memberType  | copayCategory |
      #| PDP     |  Group       |  NON LIS      |
       | MAPD    |  Group       |  NON LIS      |
       | MA      |  Group       |  HMO          | 
      
      
   @CMAncillarysection2
   Scenario Outline: Verify Ancilliary section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    When the user navigates to Benefits and coverage page
    Then user validates and clicks on Disclaimers link under Exclusive hearing
    Then user validates and clicks on Learn More button under Exclusive hearing section
    And user validates the Leaving  popup
    Then user validates and click on Cancel button
    Then user validates and clicks on Proceed button and navigate to heathnavigationpage
     
     Examples: 
       | planType|  memberType  | copayCategory |
       | MA      |  Group       |  HMO          |
      #| PDP     |  Group       |  NON LIS      |
       | MAPD    |  Group       |  NON LIS      |
            
     
      
   @CMdrugcopaysectionnonlis
   Scenario Outline: Verify Drug Cost section is in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    When the user navigates to Benefits coverage page
    #And the user validates Drug coverage header and text under the section 
    #And the user validates the Learn More section link for stage
    And the user should see drug copay and discount table
       | Updated Language | <UpdatedLanguage> |
       | Display Flag     | <DisplayFlag>     |
    
    Examples: 
       | planType|  memberType  | copayCategory |  UpdatedLanguage                   | DisplayFlag|
       | MAPD    |  Individual  |  NON LIS      | Tier 1                             | true       |
      

      
    @CMdrugcopaysectionlis
    Scenario Outline: Verify PDF section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
       | Plan Type      | <planType>     |
       | Member Type    | <memberType>|
       | Copay Category | <copayCategory>|
    Then the user navigates to Benefits coverage page
    And the user view the LIS Drug Copays & Discounts header
    And the drugcost dropdown should not display
    And the user validates the Learn More section link for stage
    And the user validates tier link should not display 
    #And the user validates the user click on the link it expands and when user clicks it again it should collapse

    Examples: 
      | planType|  memberType  | copayCategory |
      | MAPD    |  Ind         |   LIS 1       | 
     #| MA      |  Individual  |   LIS 1       |
      | PDP     |  Individual  |   LIS 4       |
           
      
      
    @CMPlanOverviewGroup
    Scenario Outline: Verify that drug cost table  is in place on Benefits and Coverage page for LIS Members
    Scenario Outline: Verify PDF section is in place on Benefits and     Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
     And the user validates plan overview section 

    Examples:
      
      | planType|  memberType  | copayCategory | 
      | MA      |  Group       |  HMO          |
      | PDP     |  Group       |  NON LIS      |
      | MAPD    |  Group       |  NON LIS      |
      
      
    
    @CMBncHeadersIndividual
    Scenario Outline: Verify that Page Headers are in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates headers on Bnc page for indi members
     Examples: 
      | planType|  memberType  | copayCategory |
      | MAPD    |  Individual  |  NON LIS      | 
      
    
     
     @CMBncHeadersGroup
     Scenario Outline: Verify that Page Headers are in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
        | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates headers on Bnc page for group members
    
     Examples: 
     | planType|  memberType  | copayCategory |
     | MA      |  Group       |  HMO          |
     | PDP     |  Group       |  NON LIS      |
     | MAPD    |  Group       |  NON LIS      | 
      
      
    @CMPlanOverviewNonLis
    Scenario Outline: Verify that Plan Overview  is in place on Benefits and Coverage page for Non LIS Members
     Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates Ind plan overview 
      | Name           | <name>  |
      | Member ID      | <memberid>|
      | Effective Date | <effectivedate>|
      | Monthly premium| <monthlypremium>|  

    Examples: 
      
      | planType|  memberType  | copayCategory | name    | memberid    | effectivedate | monthlypremium |
      | MAPD    |  Individual  |  NON LIS      | DDE BCBF| 006798725-01| 01/01/2018    | Not Available  |
   
      
    @CMPlanOverviewLis
    Scenario Outline: Verify that Plan Overview is in place on Benefits and Coverage page for LIS Members
    Given registered member with following details logins in the member portal 
       | Plan Type      | <planType>     |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates Lis member plan overview section

    Examples: 
      | planType|  memberType  | copayCategory |
      | MAPD    |  Ind         |   LIS 1       | 
      | MA      |  Individual  |   LIS 1       | 
      | PDP     |  Individual  |   LIS 4       | 
      | MA      |  Group       |   LIS 1       |
      
    
    

   @CMPrimaryCareProviderIndi
    Scenario Outline: Verify the Promary Care provider  is in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page    
    And the user validates the Primarycare Provider section
    
    Examples: 
      | planType|  memberType  | copayCategory | 
      | MAPD    |  Individual  |  NON LIS      |
     
     
     
    
    
   @CMPrimaryCareProviderGroup
    Scenario Outline: Verify the Promary Care provider  is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page        
    And the user validates the Primarycare Provider section for Group
    Examples: 
       | planType|  memberType  | copayCategory |
       | MA      |  Group       |  HMO          |
       | PDP     |  Group       |  NON LIS      |
       | MAPD    |  Group       |  NON LIS      |
    
   
    @CMOutOfPocketMax
    Scenario Outline: Verify the out of pocket section is in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page    
    And the user validates the Out of Pocket Max section
    
      Examples: 
      | planType|  memberType  | copayCategory | 
      | MAPD    |  Individual  |  NON LIS      | 
      
      
      
    @CMShip
    Scenario Outline: Verify that Page Headers are in place on Benefits and Coverage page
    Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
    Then the user navigates to Benefits and coverage page
    And the user validates plan overview and summary on Bnc page for ship members
    And the user validates hand image under discount and services section
    And the user validates the Vas section on benefits and coverage page
    And the user validates additional information on Bnc page for ship members 
    And the user validate Value Add Service page on clicking additional info button
    And the user validates view and document label
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
       | Language | <language> |
    #And the user validates pdfs and link for ship
    And the user validates ship the need help section
    And the user validates for ship see more ways to contact us section
    And the user validates for ship member on clicking contact us link it should route to contact us page 
    And the user clicks on More Information link for ship
    
   Examples: 
      | planType|  memberType  | language | 
      | HIP     |  SHIP        | ENGLISH  |
      | PHIP    |  SHIP        | SPANISH  |
      | PHIP    |  SHIP        | CHINESE  |
      
      
    @CMneedHelpFederal
    Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
     Given login with following details logins in the member portal and validate elements
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
    When the user navigates to Benefits and coverage page
    And the user validates Needhelp header
    And the user clicks on More Information link
    And the user validates contactus section
    
    Examples: 
      | planType|  memberType  | copayCategory |
      | MAPD    |  Individual  |  NON LIS      | 
      

      
      

      
    @aprilRelease2018Fnf @regressiontestcase-ATDDtags
    Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    When the user navigates to Benefits and coverage page
    And the user can see the values for catastrophic values
    Examples: 
      | planType |  memberType  |  copayCategory    |
      | MAPD     |  Group   		|  wotCMSValue      | 
   

@fastandfurious @regressiontestcase-ATDDtags
@aprilRelease2018 @CatastrophicStageLanguage
  Scenario Outline: Verify Updated Language in Catastrophic Coverage Stage for Drug Copays and Discounts in Redesign site
Given registered Redesign member for EOB with following attributes
      | Plan Type | <planType> |
      | Member Type  | <memberType> |
 And the user navigates to Benefits and Coverage page
 Then the user validates Catastrophic Stage language for the member
 
  | Updated Language | <UpdatedLanguage> |
  | Display Flag | <DisplayFlag> |
  
 	Examples:
	| planType    | memberType    |UpdatedLanguage     | DisplayFlag       |
	| PDP          | Group_LIS 			|  -either- coinsurance of 5% of the cost of the drug   |  	  false       |
	| MAPD          | Group_Non_LIS 			|  -either- coinsurance of 5% of the cost of the drug   |  	  true       |
	| PDP          | Group_Non_LIS 			|  -either- coinsurance of 5% of the cost of the drug   |  	  false       |


    
    

