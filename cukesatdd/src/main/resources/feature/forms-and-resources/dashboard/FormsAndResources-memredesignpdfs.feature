@dashBoardFormsAndResourcespdfs
Feature: To validate plan materials section on forms and resources page in dashboard site

  Scenario Outline: 
    Given registered member lands on forms and resources on member redesign Site
    When member click on member sign in link
    And the member enters userId and member enter password
      | USER_ID   | <userId>   |
      | PASSWORD  | <password> |
      |MEMBER_TYPE|  <Membertype>|
    And member click signin button and logs in
    And click on the forms and resource link and navigate to forms and resource page
    Then validate plan materials section
    And click on the order plan materials and view temporary id card link
    Then validate that english is default language in dropdown 
    And change the language in the language dropdown
    Then validate the anoc section
    | ANOC_SECTION | <Anoc_section> | 
    Then validate that english is default language in dropdown 
    And change the language in the language dropdown
    Then validate the annual directories section
     | ANNUAL_DIRECTORIES_SECTION | <AnnualDirectoriesSection> |
     | PROVIDER_SEARCHLINK | <Provider_Searchlink> |
     | PHARMACY_SEARCHLINK | <Pharmacy_Searchlink> |
    And validate that the forms and resources section is displayed 
    | FORMS_N_RESOURCES   |  <Forms_Resources>     |
    
     
    #u Layer Members
    Examples: 
      | userId         | password   | Membertype     | Anoc_section  | AnnualDirectoriesSection  |  Provider_Searchlink| Pharmacy_Searchlink|Forms_Resources|
   # mapd  ulayer
      | q4_dec_aarp214 | Password@1 |MAPD ULAYER     |  YES   | YES       | YES     | YES       | YES|          
   # ma  ulayer
      | q4_dec_aarp150 | Password@1 |MA ULAYER       |   YES  | YES       | YES     | NO        | YES|                
    #pdp ulayer
      | q4_dec_aarp319 | Password@1 |PDP ULAYER      |  YES   | YES       | NO      |  YES      | YES|   
    #mapd blue layer             
      | q4_dec_uhc008  | Password@1 |MAPD BLUE LAYER | YES    |  NO       |   NO    |    NO     | YES|  
    #ma blue layer               
      | q4_dec_uhc153  | Password@1 |MA BLUE LAYER   | YES    |  NO       |   NO    |    NO     | YES|  
    #symphonix          
      |  q4_dec_uhc198 | Password@1 |SYMPHONIX       |  YES   |  NO       |   NO    |    NO     | YES|  
    #ma group  
      |                | Password@1 | MA GROUP       | NO     |  NO       |   NO    |    NO     | YES|  
     #mapd group 
      |                | Password@1| MAPD GROUP      | NO     |  NO       |NO       |    NO     |YES        |
      #pdp group
      
      |                | Password@1 | PDP GROUP      |NO      |  NO       |NO        | NO        |YES         |
      #ship
      |                | Password@1 |SHIP            | NO     |NO         |NO        |NO        |YES           |
      
     
      
       
   
   
                       
  