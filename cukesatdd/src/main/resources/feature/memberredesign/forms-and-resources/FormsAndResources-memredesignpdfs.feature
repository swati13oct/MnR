@dashBoardFormsAndResourcespdfs @Gladiators
Feature:G1.2 To validate plan materials section on forms and resources page in dashboard site

  @planMaterialsSectionValidation
  Scenario Outline: 
    Given details of user to sign in on member redesign site to see forms and resources page
          | userId   | <userId>  |
      | password | <password> |
    And click on the forms and resource link and navigate to forms and resource page
    Then validate plan materials section
    And click on the order plan materials and view temporary id card link
    Then validate that english is default language in dropdown 
    And change the language in the language dropdown
    Then validate the anoc section
    | ANOC_SECTION | <Anoc_section> | 
    Then validate the annual directories section
     | ANNUAL_DIRECTORIES_SECTION | <AnnualDirectoriesSection> |
     | PROVIDER_SEARCHLINK | <Provider_Searchlink> |
     | PHARMACY_SEARCHLINK | <Pharmacy_Searchlink> |
    And validate that the forms and resources section is displayed 
    | FORMS_N_RESOURCES   |  <Forms_Resources>     |
    
     
    #u Layer Members
    Examples: 
      | userId         | password   | Anoc_section  | AnnualDirectoriesSection  |  Provider_Searchlink| Pharmacy_Searchlink|Forms_Resources|
   # uhc
      | q1_feb_uhc005 | Password@1 |  NO   | NO       | NO     | NO       | YES|          
   # aarp
      | q4_dec_aarp159 | Password@1 |   YES  | YES       | YES     | YES        | YES|                
   
      
       
   
   
                       
  
