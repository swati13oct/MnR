@profileandpreferences
Feature: To test My Profile & Preferences in AARP site

  Scenario Outline: To verify My Profile in AARP site
    Given registered member for My Profile & Preferences in AARP Site
      | <planType> |
    When the user view My Profile & Preferences in AARP Site
    Then the user validates my profile and preferences in AARP Site
    And the user navigates to My Preferences in AARP site
    Then the user validates displayed document name and delivery preferences for a plan in AARP site

    Examples: 
      | planType |

  ##	| PDP      |
  #	| MAPD     |
  #	| MA       |
  #	| MS       |
  #	| HIP      |
  Scenario Outline: To verify My Profile and edit profile in AARP site
    Given registered member for My Profile & Preferences in AARP Site
      | Plan Type | <plantype> |
    When the user view My Profile & Preferences in AARP Site
    Then the user edits and saves account profile information in AARP Site
      | Current password      | <currentpassword>     |
      | New password          | <newpassword>         |
      | Confirm password      | <confirmpassword>     |
      | New email address     | <newemailaddress>     |
      | Confirm email address | <confirmemailaddress> |
    And the user edits and saves plan profile in AARP Site
      | Street address  | <streetaddress>  |
      | Street address2 | <streetaddress2> |
      | Daytime phone   | <daytimephone>   |
      | Evening phone   | <eveningphone>   |
    And the user edits and saves alternate address in plan profile in AARP Site
      | Street address  | <streetaddress>  |
      | Street address2 | <streetaddress2> |
      | City            | <city>           |
      | State           | <state>          |
      | Zip Code        | <zipcode>        |
      | Country         | <country>        |
      | Start Date      | <startdate>      |
      | End Date        | <enddate>        |
    And the user edits and saves mailing address in plan profile in AARP Site
      | Street address  | <streetaddress>  |
      | Street address2 | <streetaddress2> |
      | City            | <city>           |
      | State           | <state>          |
      | Zip Code        | <zipcode>        |
      | Country         | <country>        |
      | Start Date      | <startdate>      |
      | End Date        | <enddate>        |

    Examples: 
      | plantype | currentpassword | newpassword | confirmpassword | newemailaddress | confirmemailaddress | daytimephone | eveningphone | streetaddress | streetaddress2 | city | state | zipcode | country | startdate | enddate |

  #	| PDP      | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com      | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|CALIFORNIA| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|
  #        | MAPD     | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com    | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|CALIFORNIA| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|
  #        | MA       | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com    | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|CALIFORNIA| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|
  #        | MS       | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com    | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|CALIFORNIA| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|
  #        | HIP      | Password@1      | Password@2  | Password@2      | test@optum.com  | test@optum.com    | 902-955-8321 | 902-955-8456 | abcd          | efgh           |california|CALIFORNIA| 80001   | UNITED STATES | 11-11-2014 | 12-12-2015|
  Scenario Outline: To verify My Preferences in AARP site
    Given registered member for My Profile & Preferences in AARP Site
      | Plan Type | <plantype> |
    When the user view My Profile & Preferences in AARP Site
    And the user navigates to My Preferences in AARP Site
    Then the user validates displayed document name and delivery preferences for a plan in AARP Site
      | Document Name        |
      | Delivery Preferences |

    Examples: 
      | plantype |

  #	| PDP      |
  #	| MAPD     |
  #	| MA       |
  #       | MS       |
  #       | HIP      |
  Scenario Outline: To verify My Preferences and edit preferences in AARP site
    Given registered member for My Profile & Preferences in AARP Site
      | <planType> |
    When the user view My Profile & Preferences in AARP Site
    Then the user validates my profile and preferences in AARP Site
    And the user navigates to My Preferences in AARP Site
    And the user updates preferences by changing delivery preferences for corresponding document name in AARP Site
      | <documentname:preferences> |
    Then the user validates the updated preferences in AARP site

    Examples: 
      | planType | documentname:preferences                                                      |
      | PDP      | Annual Notice Of Changes Documents:Online,Annual Pharmacy Directory:U.S. Mail |

  #	| MAPD     | Prescription Drug Explanation of Benefits (EOB):Online				|
  #	| MA       | Claims-Online									|
  #       | MS       | Claims-Online									|
  #       | HIP      | Claims-Online									|
  ##- working examples
  
  #@@@@@@@@@@@@@@@@@@memberRedesignPage@@@@@@@@@@@@@@@@@@@@@
  
  @ValidatePlanNamemembernameIDAccountSectionAARP
  Scenario Outline: To verify Plan Name, Member name, Member ID section in AARP site
    Given registered member with following details for Profile and Preferences flow
      | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user validates the Plan Name, Member name, Member ID section in AARP site

       Examples: 
      | planType |
      | PDP     |
      | MAPD     |
      | MA       |
     #|SHIP      |
      
      
      
  @ValidateEmail
  Scenario Outline: To verify Email section in AARP site
    Given registered member with following details for Profile and Preferences flow
      | <planType> |
    When the user navigates to Profile and Preferences page
    And the user validates the Email section in AARP site

       Examples: 
      | planType |
      | PDP      |
      | MAPD     |
      | MA       |
      
   @PasswordEdit
  Scenario Outline: To verify the edit functionality in Account Profile section in AARP site
    Given registered member with following details for Profile and Preferences flow
      | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user validates the elements on clicking the edit link
    Then the user validates the functionality of save Button
    Then the user validates the functionality of Cancel Button

       Examples: 
      | planType |
     #| PDP      |
      | MAPD     |
      | MA       |
     
    @PasswordEdit1
     Scenario Outline: To verify the edit functionality in Account Profile section in AARP site
    Given registered member with following details for Profile and Preferences flow
      | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user validates the elements on clicking the edit link
    Then the user clicks on save button without filling current and new password and the red mandatory message should come
    
    Examples: 
      | planType |
     #| PDP      |
      | MAPD     |
     #| MA       |
    
    @EmailEdit1
      Scenario Outline: To verify Email section in AARP site
    Given registered member with following details for Profile and Preferences flow
      | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user clicks on edit button
    Then the user clicks on save without filling both fields then the user should see red mandatory message
    Then the user fill new email address and click save then user should see new updated email on page
    
      Examples: 
      | planType |
     #| PDP      |
      | MAPD     |
     #| MA       |
      
     @EmailEdit2
     Scenario Outline: To verify Email section in AARP site
    Given registered member with following details for Profile and Preferences flow
      | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user clicks on edit button
    Then the user fill invalid email and clicks on save button then the user should see error message for invalid email
    Then the user fill different email id in confirm email box from new email address then error message should come
    
         Examples: 
      | planType |
     #| PDP      |
      | MAPD     |
     #| MA       |
      
      
     @Needhelp
     Scenario Outline: To verify the edit functionality in Account Profile section in AARP site
    Given registered member with following details for Profile and Preferences flow
      | <planType> |
    When the user navigates to Profile and Preferences page
    And the user validates the need help section
    And the user validates see more ways to contact us section 
    #And the user validates on clicking contact us link it should route to contact us page
    
     Examples: 
      | planType |
     #| PDP      |
     #| MAPD     |
      | MA       |
      
    @PermanentAddress
    Scenario Outline: To verify the edit functionality in Account Profile section in AARP site
    Given registered member with following details for Profile and Preferences flow
      | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user validates permanent address section
    #And the user clicks on contact us then contact us page should come
    
    Examples: 
      | planType |
      | MAPD     |
     #| MA       |
      
    @PermanentAddressPDP
    Scenario Outline: To verify the edit functionality in Account Profile section in AARP site
    Given registered member with following details for Profile and Preferences flow
      | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user validates permanent address section pdp
    #And the user clicks on contact us then contact us page should come
    
    Examples: 
      | planType |
      | PDP      |
      
      
      @PhoneEdit
      Scenario Outline: To verify Phone in Aarp site
      Given registered member with following details for Profile and Preferences flow
      | <planType> |
      Then the user navigates to Profile and Preferences page
      Then the user validates the Phone section
      #Then the user Clicks on the the Edit Link and validates the elements
      #Then the user checks the Edit Button changes to Cancel Button
      #Then the user validates the functionality of save Button in Phoneeditsection 
      #Then the user validates the functionality of Cancel Button In phoneeditSection
      

    Examples: 
      | planType |
      #| MAPD     |
       | MA       |
       
    @CommunicationPreferences
     Scenario Outline: To verify Go green in AARP site
      Given registered member with following details for Profile and Preferences flow
      | <planType> |
      Then the user navigates to Profile and Preferences page
    Then the user validates Communication Preferences section
    And the user validates Go paperless button and on clicking button go green page should come
    And the user validates on clicking Profilenpreferences arrow user should route to Profile and Preferences page
      Examples: 
      | planType |
     #| PDP      |
     #| MAPD     |
      | MA       |
      
      
    @GoGreen
    Scenario Outline: To verify Go Green page
    Given registered member with following details for Profile and Preferences flow
      | <planType> |
    Then the user navigates to Profile and Preferences page
    Then the user validates the presence of Go Paperless button
    Then the user validates the presence of Plan Name
    Then the user validates the presence of Communication preferences header
    Then the user validates the presence of Back to Profile and Preferences links
    Then the user validates the Note section
    Then the user validates the I have read checkbox and check it
    Then the user validates the Save Preferences Button
    Then the user validates the Go Green Header
    
    
    
     Examples: 
      | planType |
      | MAPD     |
      | MA       |
      |PDP       |
     #|SHIP      |
      
      
   @NeedhelpShip
  Scenario Outline: To verify the needhelp functionality in Account Profile section in AARP site
    Given registered member with following details for Profile and Preferences flow
      | <planType> |
    When the user navigates to Profile and Preferences page
    Then the user validates the need help section for ship
    And the user validates see more ways to contact us section for ship
    And the user validates on clicking contact us link it should route to contact us page for ship member

    Examples: 
      | planType |
      #| PDP      |
      #| MAPD     |
       | MA       |
      
      
  @Temporaryaddress
  Scenario Outline: To verify Temporary adrress and Edit Functionality
    Given registered member with following details for Profile and Preferences flow
      | <planType> |
    Then the user navigates to Profile and Preferences page
    Then the user validates the temporary address section
    Then the user validates the fields and Buttons of temp address section
    Then the user checks the Edit Button on the top changes to Cancel Button
    Then the user validates the functionality of save Button in Temporary adrress section
    Then the user validates the functionality of Cancel Button In Temporary adrress section

    Examples: 
       | planType |
      # | MAPD     |
      | MA       |
     
      
      