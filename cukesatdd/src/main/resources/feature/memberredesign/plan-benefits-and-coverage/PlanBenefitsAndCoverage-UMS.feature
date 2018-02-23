@codeMonkeys
Feature:C1.1 To test plan benefits and Coverage on UMS site
@CMneedHelp
    Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates Needhelp header
    And the user clicks on More Information link
    And the user validates contactus section
    
    Examples: 
      | planType|  memberType  | copayCategory |
      | MAPD    |  Individual  |  NON LIS      | 
      | PDP     |  Individual  |  NON LIS      | 

      
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
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates view and document label
    And the user validates the language dropdown and the value displayed by default and selects new value in dropdown successfully
       | Language | <language> |
       
    Examples:
      
       | planType|  memberType  | copayCategory | language |
       | MAPD    |  Individual  |  NON LIS      | SPANISH  |
       | PDP     |  Individual  |  NON LIS      | SPANISH  |
   
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
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>     |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    When the user navigates to Benefits coverage page
    And the user view the Drug Copays & Discounts header 
    And the user validates the Learn More section for stage and tier
    And the user validates dropdown selection functionality
    And the user validates the user click on the link it expands and when user clicks it again it should collapse
    And the user validates Drug coverage header and text under the section
    And the user validates text for the Look Up Drugs section
    And the user validates Look Up Drugs button should be visible
    And the user validates text for the Locate a Pharmacy section
    And the user validates Locate a Pharmacy button should be visible
    And the user should see drug copay and discount table
    Examples: 
       | planType|  memberType  | copayCategory |
       | PDP     |  Group       |  NON LIS      |
       | MAPD    |  Group       |  NON LIS      |
       | MAPD    |  Individual  |  NON LIS      | 
       | PDP     |  Individual  |  NON LIS      |

      
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
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates headers on Bnc page for indi members
     Examples: 
      | planType|  memberType  | copayCategory |
      | MA      |  Individual  |   LIS 1       | 
      | MA      |  Individual  |   NON LIS     |
      | MAPD    |  Individual  |  NON LIS      | 
      | PDP     |  Individual  |  NON LIS      | 
      | PDP     |  Individual  |   LIS 4       |
    
     
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
    #| PDP     |  Group       |  NON LIS      |
     | MAPD    |  Group       |  NON LIS      | 
      
      
    @CMPlanOverviewNonLis
    Scenario Outline: Verify that Plan Overview  is in place on Benefits and Coverage page for Non LIS Members
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates Ind plan overview   

    Examples: 
      
      | planType|  memberType  | copayCategory |
      | MAPD    |  Individual  |  NON LIS      | 
      | PDP     |  Individual  |  NON LIS      | 
      | MA      |  Individual  |  NON LIS      |
      
      
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
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page    
    And the user validates the Primarycare Provider section
    
    Examples: 
      | planType|  memberType  | copayCategory |
      | MAPD    |  Ind         |   LIS 1       | 
      | MA      |  Individual  |   LIS 1       | 
      | PDP     |  Individual  |   LIS 4       | 
      | MA      |  Group       |   LIS 1       | 
     
     
    
    
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
      #| PDP     |  Group       |  NON LIS      |
       | MAPD    |  Group       |  NON LIS      |
    
   
    @CMOutOfPocketMax
    Scenario Outline: Verify the out of pocket section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page    
    And the user validates the Out of Pocket Max section
    
      Examples: 
      | planType|  memberType  | copayCategory |
      | MAPD    |  Individual  |   LIS 1       | 
      | MA      |  Individual  |   LIS 1       | 
      | MAPD    |  Individual  |  NON LIS      | 
      | MA      |  Group       |  HMO          |
      | MAPD    |  Group       |  NON LIS      |
      
      
    @CMBncHeadersShip
    Scenario Outline: Verify that Page Headers are in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    Then the user navigates to Benefits and coverage page
    And the user validates headers on Bnc page for ship members
    
   Examples: 
      | planType|  memberType  | copayCategory |
      | HIP     |  SHIP        |   NON LIS     | 
      | PHIP    |  SHIP        |   NON LIS     |
      
      
    @CMdiscountandservices
    Scenario Outline: Verify that DisocuntServices section is visible on Benefits and coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    When the user navigates to Benefits and coverage page
    And the user validates hand image under discount and services section
    And the user validates the Vas section on benefits and coverage page
    And the user validates learnmorebutton on Bnc page for ship members 

    Examples: 
      | planType|  memberType  | copayCategory |
      | HIP     |  SHIP        |   NON LIS     | 
      | PHIP    |  SHIP        |   NON LIS     |
      
      
    @CMneedHelpFederal
    Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    When the user navigates to Benefits and coverage page
    And the user validates Needhelp header
    And the user clicks on More Information link
    And the user validates contactus section
    
    Examples: 
      | planType|  memberType  | copayCategory |
      | MAPD    |  Ind         |   LIS 1       | 
      | MA      |  Individual  |   LIS 1       | 
      | PDP     |  Individual  |   LIS 4       | 
      
      
   @CMneedHelpShip
  Scenario Outline: Verify Need Help section is in place on Benefits and Coverage page
    Given registered member with following details logins in the member portal 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    When the user navigates to Benefits and coverage page
    And the user validates ship the need help section
    And the user validates for ship see more ways to contact us section
    And the user validates for ship member on clicking contact us link it should route to contact us page 
    
    Examples: 
      | planType|  memberType  | copayCategory |
      | HIP     |  SHIP        |   NON LIS     | 
      | PHIP    |  SHIP        |   NON LIS     |
   
    
    

