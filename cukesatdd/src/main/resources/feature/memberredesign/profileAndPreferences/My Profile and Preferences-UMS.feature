@codeMonkeys
Feature: To test Profile and Preferences page .


    @CMNeedhelp
  Scenario Outline: To verify the NeedHelp Section On Account Profile page
    Given registered member with following details for Profile and Preferences flow
     | Plan Type      | <planType>  |
    When the user navigates to Profile and Preferences page
    And the user validates the need help section
    And the user validates see more ways to contact us section
    And the user validates on clicking contact us link it should route to contact us page

    Examples: 
         | planType|
         | MAPD     |
         |PDP       |
         


@CMNeedhelpShip
  Scenario Outline: To verify the NeedHelp Section On Account Profile page for ship members
    Given registered member with following details for Profile and Preferences flow
     | Plan Type      | <planType>  |
    When the user navigates to Profile and Preferences page
    And the user validate the need help section for ship member
    And the user validates see more ways to contact us section
    And the user validates on clicking contact us link it should route to contact us page

    Examples: 
         | planType|
         | SHIP    |

  @CMValidatePlanNamemembernameIDAccountSectionUMS
  Scenario Outline: To verify Plan Name, Member name, Member ID and account section in UMS site
    Given registered member with following details for Profile and Preferences flow
       | Plan Type      | <planType>  |
    Then the user navigates to Profile and Preferences page
    Then the user validates the Plan Name, Member name, Member ID and account section in UMS site

    Examples: 
         | planType|
         |MAPD     |
         |MA       |
         |PDP      |
         |SHIP     |


  @CMPasswordEdit
  Scenario Outline: To verify the edit functionality in Account Profile section in UMS site
    Given registered member with following details for Profile and Preferences flow
        | Plan Type      | <planType>  |
    When the user navigates to Profile and Preferences page
    Then the user validates the elements on clicking the edit link
    #Then the user validates the functionality of save Button
    Then the user validates the functionality of Cancel Button

      Examples: 
         | planType|
         | MAPD     |
          | MA       |
         |PDP       |
         |SHIP      |
          
           @CMPasswordEdit1
  Scenario Outline: To verify the edit functionality in Account Profile section in UMS site without entering the mandatory fields
    Given registered member with following details for Profile and Preferences flow
        | Plan Type      | <planType>  |
    When the user navigates to Profile and Preferences page
    Then the user validates the elements on clicking the edit link
    Then the user clicks on save button without filling current and new password and the red mandatory message should come

   Examples: 
         | planType|
         | MAPD     |
          | MA       |
          |PDP       |
          |SHIP      |
          


   @CMPasswordEdit3
  Scenario Outline: To verify the edit functionality in Account Profile section in UMS site when user enters different password in confirm new password field
    Given registered member with following details for Profile and Preferences flow
       | Plan Type      | <planType>  |
    When the user navigates to Profile and Preferences page
    Then the user validates the elements on clicking the edit link
    Then the user enters different password in confirm password field and clicks save button and the user should see expected error message - Please enter the same value again

   Examples: 
         | planType|
         | MAPD     |
         | MA       |
         |PDP       |
         |SHIP      |


@CMTemporaryaddress
    Scenario Outline: To verify Temporary address section
    Given registered member with following details for Profile and Preferences flow
       | Plan Type      | <planType>  |
    Then the user navigates to Profile and Preferences page
    Then the user validates the temporary address section
    Then the user validates the fields and Buttons of temp address section
    Then the user checks the Edit Button on the top changes to Cancel Button
    #Then the user validates the functionality of save Button in Temporary adrress section
    Then the user validates the functionality of Cancel Button In Temporary adrress section

    Examples: 
       | planType |
       | MAPD     |
       | MA       |

       
        @CMTemporaryaddressShip
    Scenario Outline: To verify Temporary address section
    Given registered member with following details for Profile and Preferences flow
        | Plan Type      | <planType>  |
    Then the user navigates to Profile and Preferences page
    Then the user validates the temporary address section for ship member


    Examples: 
       | planType |
       | SHIP       |
      

@CMValidateEmail
    Scenario Outline: To verify Email section in member Redesign site
    Given registered member with following details for Profile and Preferences flow
       | Plan Type      | <planType>  |
    Then the user navigates to Profile and Preferences page
    Then the user validates the Email section in UMS site

    Examples: 
        | planType|
         | MAPD     |
          | MA       |
         |PDP       |
          |SHIP      |



  @CMEmailEdit1
  Scenario Outline: To verify Email edit functionality in Redesign site 
    Given registered member with following details for Profile and Preferences flow
   | Plan Type      | <planType>  |
    When the user navigates to Profile and Preferences page
    Then the user clicks on edit button
    Then the user clicks on save without filling both fields then the user should see red mandatory message
    Then the user fill new email address and click save then user should see new updated email on page

    Examples: 
        | planType|
         | MAPD     |
          | MA       |
        |PDP       |
         |SHIP      |
          
          
          
@CMEmailEdit2

 Scenario Outline: To verify validations on email secton in member redesign site
    Given registered member with following details for Profile and Preferences flow
        | Plan Type      | <planType>  |
    When the user navigates to Profile and Preferences page
    Then the user clicks on edit button
    Then the user fill invalid email and clicks on save button then the user should see error message for invalid email
    Then the user fill different email id in confirm email box from new email address then error message should come

    Examples: 
         | planType|
         | MAPD     |
          | MA       |
         |PDP       |
         |SHIP      |
          

         
          @CMPermanentAddress
  Scenario Outline: To verify the Permanent Address section
    Given registered member with following details for Profile and Preferences flow
       | Plan Type      | <planType>  |
    When the user navigates to Profile and Preferences page
    Then the user validates permanent address section
    And the user validates contact us statement

    Examples: 
         | planType|
         | MAPD     |
          | MA       |
          |PDP       |
          #|SHIP      |


  @CMCommunicationPreferences
  Scenario Outline: To verify Communication Preferences section
    Given registered member with following details for Profile and Preferences flow
        | Plan Type      | <planType>  |
    When the user navigates to Profile and Preferences page
    Then the user validates Communication Preferences section
    And the user validates Go paperless button and on clicking button go green page should come
    #And the user validates on clicking Profilenpreferences arrow user should route to Profile and Preferences page

    Examples: 
          | planType |
          | MAPD     |
          | MA       |
          |PDP       |
         |SHIP      |
@CMPhone
      Scenario Outline: To verify Phone in Aarp site
      Given registered member with following details for Profile and Preferences flow
      | Plan Type      | <planType>  |
      Then the user navigates to Profile and Preferences page
      Then the user validates the Phone section
      Then the user Clicks on the the Edit Link and validates the elements
      Then the user checks the Edit Button changes to Cancel Button
      Then the user validates the functionality of save Button in Phoneeditsection 
      Then the user validates the functionality of Cancel Button In phoneeditSection
      

    Examples: 
      | planType |
      | MAPD     |
      | MA       |
      |PDP       |
      |SHIP      |
      
        @CMGoGreen
    Scenario Outline: To verify Go Green page
    Given registered member with following details for Profile and Preferences flow
        | Plan Type      | <planType>  |
    Then the user navigates to Profile and Preferences page
    Then the user validates Go paperless button and on clicking button go green page should come
    Then the user validates the presence of Communication preferences header
    Then the user validates headers on green page
    ##Then the user validates the Go Green Header
    Then the user validates the presence of Plan Name
    Then the user validates the Note section
    Then the user validates the I have read checkbox and check it
    Then the user validates the Save Preferences Button
    Then the user validates the presence of Back to Profile and Preferences links
    
    
    
     Examples: 
       | planType |
      | MAPD     |
      | MA       |
      |PDP       |
     #|SHIP      |
     
      @CMNokiaMemberValidateEmailPhoneEdit
    Scenario Outline: To verify Email section in member Redesign site
    Given registered member with following details for Profile and Preferences flow
        | Plan Type      | <planType>  |
      | Member Type    | <memberType>|
    Then the user navigates to Profile and Preferences page
    Then the user validates the Presence of edit button in email section
    Then the user validates the Presence of edit button in Phone section
     Then the user validates the Presence of edit button in Temporary Address section
 Then the user validates the Presence of edit button in Mailing Address section
 
 
    Examples: 
       | planType| memberType  |
       | MA    | NOKIA       | 
       | MAPD    | NOKIA       | 
      
       
         


      
  