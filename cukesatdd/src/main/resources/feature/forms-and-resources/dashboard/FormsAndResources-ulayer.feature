@dashBoardFormsAndResourcesulayer
Feature: To validate plan materials section on forms and resources page in dashboard site
#Scenarios written for blue layer - Later will be modified to dashboard once dashboard site is set up
  Scenario Outline: 
    Given registered member lands on forms and resources in member Site
    When member click on member sign in link
    And the member enters userId and member enter password
      | USER_ID   | <userId>   |
      | PASSWORD  | <password> |
      |MEMBER_TYPE|  <Membertype>|
    And member click signin button and logs in
    And open test harnesss page in a new tab
    And click on the forms and resource link and navigate to forms and resource page
    Then validate plan materials section
    And click on the order plan materials and view temporary id card link
    Then validate that english is default language in dropdown 
    And change the language in the language dropdown
    Then validate the anoc section
    | ANOC_SECTION | <Anoc_section> |
    And validate that 2018 PDFS are coming 
    Then validate that english is default language in dropdown 
    And change the language in the language dropdown
    Then validate the annual directories section
     | ANNUAL_DIRECTORIES_SECTION | <AnnualDirectoriesSection> |
    And validate the provider search link
    | PROVIDER_SEARCHLINK | <Provider_Searchlink> |
    And validate the pharmacy search link
    | PHARMACY_SEARCHLINK | <Pharmacy_Searchlink> |
    And validate that the forms and resources section is displayed 
    
    
     
    #u Layer Members
    Examples: 
      | userId  | password | Membertype | Anoc_section  | AnnualDirectoriesSection  |  Provider_Searchlink| Pharmacy_Searchlink|
   # mapd  
      | q4_dec_aarp214 | Password@1 |MAPD ULAYER     |  YES   | YES       | YES     | YES       |           
   # ma  
      | q4_dec_aarp150 | Password@1 |MA ULAYER       |   YES  | YES       | YES     | NO        |              
    #pdp 
      | q4_dec_aarp319 | Password@1 |PDP ULAYER      |  YES   | YES       | NO      |  YES      | 
    #               
      | q4_dec_uhc008  | Password@1 |MAPD BLUE LAYER | YES    |  NO       |   NO    |    NO     |
                    
      | q4_dec_uhc153  | Password@1 |MA BLUE LAYER   | YES    |  NO       |   NO    |    NO     |
               
      |  q4_dec_uhc198 | Password@1 |SYMPHONIX       |  YES   |  NO       |   NO    |    NO     |
      
      |                | Password@1 | MA GROUP       | NO     |  NO       |   NO    |    NO     |
      
      |           | Password@1| MAPD GROUP| NO|NO
      
      
      |     | Password@1 | PDP GROUP|NO|  NO
      
      |    | Password@1| SHIP | 
      
     
      
       
    
    
    Scenario Outline: 
    Given registered member lands on forms and resources in member U Layer Site
    When member click on member sign in link
    And the member enters userId and member enter password
      | USER_ID  | <userId>   |
      | PASSWORD | <password> |
    And member click signin button and logs in
    And open U layer test harnesss page in a new tab
    And click on the forms and resource link and navigate to forms and resource page
    Then validate ANOC section
    And validate that 2018 PDFS are coming 
    Then validate that english is default language in dropdown 
    And change the language in the language dropdown
    
     Scenario Outline: to verify that for PDP member only the pharmacy locator link comes in the annual directories section
    Given registered member lands on forms and resources in member blue Layer Site
    When member click on member sign in link
    And the member enters userId and member enter password
      | USER_ID  | <userId>   |
      | PASSWORD | <password> |
    And member click signin button and logs in
    And open blue layer test harnesss page in a new tab
    And click on the forms and resource link and navigate to forms and resource page
    Then validate that annual directories section is present 
    And the provider search link is not displayed
    And the pharmacy locator link is present and clickable
    
      Scenario Outline: To verify that for non PDP member both the pharmacy locator and provider search link comes in the annual directories section
    Given registered member lands on forms and resources in member blue Layer Site
    When member click on member sign in link
    And the member enters userId and member enter password
      | USER_ID  | <userId>   |
      | PASSWORD | <password> |
    And member click signin button and logs in
    And open blue layer test harnesss page in a new tab
    And click on the forms and resource link and navigate to forms and resource page
    Then validate that annual directories section is present 
    And the provider search link is present and clickable 
    And the pharmacy locator link is present and clickable
    
                       
  