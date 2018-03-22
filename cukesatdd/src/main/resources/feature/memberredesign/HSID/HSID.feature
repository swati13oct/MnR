

Feature:To test HSID functionality on Medicare site

    @CMUS968323
    Scenario Outline: Verify HSID login page
    Given register with following details logins in the member portal and validate elements 
      | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
      | Copay Category | <copayCategory>|
    When the user validate username autofill
    And the user enters password and confirm password field
    And the user enters email and confirm email field
    And the user clicks submit button
    When the user validate all fields on this page
    And  the user validate security questions option and user answer all security questions
      | Option  | <option>  |
      | Option1 | <option1> |
      | Option2 | <option2> |
      | Option3 | <option3> |
    And the user check checkboxes
    And the user clicks submit button
    
    
      Examples:
      
       | planType|  memberType  | copayCategory | option              | option1                          | option2                      | option3                          |
       | MAPD    |  Individual  |  NON LIS      | Security questions  | What was your first phone number?| What is your favorite color? | What is your best friend's name? |
       
      
 