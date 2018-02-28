@dashBoardFormsAndResourcespdfs @gladiators
Feature: To validate plan materials section on forms and resources page in dashboard site

  @planMaterialsSectionValidation
  
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
      | q1_aarp_feb012 | Password@1 |
  
  
  @terminatedmembervalidation
  Scenario Outline: 
    Given details of user to sign in on member redesign site to see forms and resources page
          | userId   | <userId>  |
      | password | <password> |
    And click on the forms and resource link and navigate to forms and resource page for terminated member
    Then validate plan materials section
    And for terminated member order plan materials link is not displayed
    And clicking on the view temporary id card link user is navigated to rallydashboard page
    Examples: 
      | userId         | password   |
   # uhc
      | q1_feb_uhc085 | Password@1 |
  
  @anocsectionValidation  
    Scenario Outline:
    Given details of user to sign in on member redesign site to see forms and resources page
          | userId   | <userId>  |
      | password | <password> |
    And click on the forms and resource link and navigate to forms and resource page for active member 
    Then validate that english is default language in dropdown 
    And change the language in the language dropdown
    Then validate the anoc section
    | ANOC_SECTION | <Anoc_section> | 
    Then validate the annual directories section
     | ANNUAL_DIRECTORIES_SECTION | <AnnualDirectoriesSection> |
     | PROVIDER_SEARCHLINK | <Provider_Searchlink> |
     | PHARMACY_SEARCHLINK | <Pharmacy_Searchlink> |
    And validate that the forms and resources section is displayed 
    
    
     
    #u Layer Members
    Examples: 
      | userId         | password   | Anoc_section  | AnnualDirectoriesSection  |  Provider_Searchlink| Pharmacy_Searchlink|
   # uhc
      | q1_feb_uhc085 | Password@1 |  NO   | NO       | NO     | NO       |         
   # aarp
    #  | q1_aarp_feb010 | Password@1 |   YES  | YES       | YES     | YES        |                
   
      
       
   
   
                       
  
