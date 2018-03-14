

Feature:To test HSID functionality on Medicare site

    @CMHSIDLogin
    Scenario Outline: Verify HSID login page
    Given register with following details logins in the member portal and validate elements 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    When the user validate username autofill
    
    
    Examples: 
      | planType|  memberType  | copayCategory |
      | MAPD    |  Individual  |  NON LIS      |
      
 