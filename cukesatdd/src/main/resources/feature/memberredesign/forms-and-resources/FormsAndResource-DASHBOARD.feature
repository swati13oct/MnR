@dashBoardFormsAndResources @gladiators
Feature:G1.1 To validate forms and resources page in dashboard site


     @mauhcscenario
  Scenario Outline: 
    Given details of user to sign in on member redesign site to see forms and resources page
          | userId   | <userId>  |
      | password | <password> |
    And click on the forms and resource link and navigate to forms and resource page for active member
    Then validate plan materials section
    And for active member both the links are displayed
    Then validate the anoc section
    | ANOC_SECTION | <Anoc_section> | 
    Then validate the annual directories section
     | ANNUAL_DIRECTORIES_SECTION | <AnnualDirectoriesSection> |
     | PROVIDER_SEARCHLINK | <Provider_Searchlink> |
     | PHARMACY_SEARCHLINK | <Pharmacy_Searchlink> |
    Then validate EOB section
      | EOB_MEDICAL_LINK | <EOBMedicalLinkVisible> |
      | EOB_DRUG_LINK    | <EOBDrugLinkVisible>    |
    And validate my document section
      | MY_DOCUMENT_SECTION | <MyDocumentVisible> | 
      And validate that the forms and resources section is displayed
    And validate renew magazine section
      | RENEW_MAGAZINE_SECTION | <RenewMagazineVisible> |
      

    #Blue Layer Members
    Examples: 
      | userId         | password   | Anoc_section  |AnnualDirectoriesSection  |Provider_Searchlink|  Pharmacy_Searchlink| EOBMedicalLinkVisible | EOBDrugLinkVisible | MyDocumentVisible | RenewMagazineVisible |
      # uhc
      | q1_feb_uhc153  | Password@1 | NO|NO|NO|NO|YES                   | NO                | YES               | YES                  |
      # aarp
    #  | q1_feb_aarp008 | Password@1 | YES|YES|YES|YES                  | YES                | YES               | YES                  |YES|
      
       @activememberscenario
  Scenario Outline: 
    Given details of user to sign in on member redesign site to see forms and resources page
          | userId   | <userId>  |
      | password | <password> |
    And click on the forms and resource link and navigate to forms and resource page for active member
    Then validate plan materials section
    And for active member both the links are displayed
    And clicking on the order plan materials link the user is navigated back to the forms and resources page
    And clicking on the view temporary id card link user is navigated to rallydashboard page

   
    Examples: 
      | userId         | password   |  
   # uhc
      | q1_aarp_feb174 | Password@1 |   
  
  
  @terminatedmembervalidation
  Scenario Outline: 
    Given details of user to sign in on member redesign site to see forms and resources page
          | userId   | <userId>  |
      | password | <password> |
    And click on the forms and resource link and navigate to forms and resource page for active member
    Then validate plan materials section
    And for terminated member order plan materials link is not displayed
    And clicking on the view temporary id card link user is navigated to rallydashboard page
  
   
    Examples: 
      | userId         | password   |
   # uhc
      | q1_aarp_feb140 | Password@1 |    
  
 
      
       
   
   
                       
  

      
