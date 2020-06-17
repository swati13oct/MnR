@accountProfileProfile @thePredators @F402311
Feature: 1.02.1 Member Profile page - Prod

  #Background: If run on stage then feature security flag needs to be true
  #   Given feature security flag must set to true when testing on stage env
  #    | Feature           | UCPProfileAndPreferences |

    @prod_accountProfile12
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - To test end to end regression scenario for account profile and preferences for a combo member
    #Removed from Regression as EPMP is still in the pipeline for development
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    When the user navigates to Profile and Preferences page
    And I should see the combo tabs on Account Profile page and user validates the elements on individual tabs

    Examples:
      | TID       | username | password | MemUserName | planType       | memberType              |
      | Unknown_6 | ashah120 | Mnrqa002 | memeterry29 | Combo_PDP_SSUP | EPMPEnabled_ProfilePref |


  @prod_accountProfile13
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -To test end to end regression scenario for account profile and preferences for a Federal member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    Then the user navigates to Profile and Preferences page
    #Then the user validates HEALTHSAFE ID PASSWORD & HEALTHSAFE ID ACCOUNT RECOVERY & SECURITY links
    Then the user validates the Plan Name, Member name, Member ID and account section in UMS site
    #Then the email address section should be verified
    #Then the Phone Numbers section should be validated & all links clicked
    Then the user validates permanent address section
    And the user verifies the Temporary Address Link on the Account settings page
    Then the user validates Communication Preferences section
    #And the user validates sign up today link
    #Then the user validates the presence of Back to Profile and Preferences links
    And the user validates see more ways to contact us section
    And the user validates on clicking contact us link it should route to contact us page

    Examples:
      | TID        | username | password | MemUserName       | planType | memberType         |
      | Unknown_7  | ashah120 | Mnrqa002 | LSLOMSKI777       | PDP      | PDP_AARPIndividual |
      | Unknown_8  | ashah120 | Mnrqa002 | KAYCEE0412        | GrpPDP   | PDP_Group          |
      | Unknown_9  | ashah120 | Mnrqa002 | TOMIKOARMER2      | MA       | MA_UHCIndividual   |
      | Unknown_10 | ashah120 | Mnrqa002 | TOMIKOARMER2      | MA       | MA_UHCGroup        |
      | Unknown_11 | ashah120 | Mnrqa002 | WILLIAMGARRISON48 | MAPD     | MAPD_Group         |


  @prod_accountProfile14
  Scenario Outline: TID: <TID> -Member Type: <memberType> -To test end to end regression scenario for account profile page for PCP medica members
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    Then the user navigates to Profile and Preferences page
    Then the user validates the Plan Name, Member name, Member ID and account section in UMS site
    #Then the email address section should be verified
    #Then the Phone Numbers section should be validated & all links clicked
    Then the user validates permanent address section
    And the user verifies the Temporary Address Link on the Account settings page
    Then the user validates that  Communication Preferences section doesn't come for PCP medica member
    And the user validates see more ways to contact us section
    And the user validates on clicking contact us link it should route to contact us page

    Examples:
      | TID        | username | password | MemUserName | planType | memberType |
      | Unknown_13 | ashah120 | Mnrqa002 | marylamb823 | MA       | PCP        |

  @prod_accountProfile15
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -To test end to end regression scenario for account profile  page for a terminated member
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    Then the user navigates to Profile and Preferences page
    Then the user validates the Plan Name, Member name, Member ID and account section in UMS site
    #And I validate the healthsafe ID links
    #Then the email address section should be verified
    #Then the Phone Numbers section should be validated & all links clicked
    Then the user validates permanent address section
    And the user verifies the Temporary Address Link on the Account settings page
    Then the user validates that  Communication Preferences section doesn't come for terminated members
    And the user validates see more ways to contact us section
    And the user validates on clicking contact us link it should route to contact us page

    Examples:
      | TID        | username | password | MemUserName | planType | memberType        |
      | Unknown_15 | ashah120 | Mnrqa002 | erbenoit56  | MAPD     | Terminated_AccPro |

  @prod_accountProfile019
  Scenario Outline: TID: <TID> -Plan Type: <planType> - To verify Profile page End to End test for Ship Members
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <MemUserName> |
    And user clicks on member to select
    And user stores test input for validations
      | Username    | <MemUserName> |
      | Plan Type   | <planType>    |
      | Member Type | <memberType>  |
    When the user navigates to Profile and Preferences page
    And the user validates the Plan Name, Member name, Member ID and account section
    #note: moved to footer feature
	#And the ship user validates the need help section
    Then the user validates permanent address section
    Then the user validates the Phone section
      | Plan Type   | <memberType> |
#    Then the user Clicks on the the Edit phone Link and validates the elements
      | Plan Type   | <memberType> |
#    Then the Ship user checks the Edit Button changes to Cancel Button
#    Then the user checks the functionality of save Button in Phoneeditsection
      | Member Type | <memberType> |
#    Then the user validate the functionality of Cancel Button In phoneeditSection
    Then the user validate the temporary address section for ship member
    Then the user validates that  Communication Preferences section comes up for Ship Member
    Then the user validates the Go Green page for a ship member
    And the user validates see more ways to contact us section
    And the user validates on clicking contact us link it should route to contact us page

    Examples:
      | TID   | username | password | MemUserName | planType | memberType       |
      | 15103 | ashah120 | Mnrqa002 | Pramila1946 | SHIP     | SHIP_ProfilePref |

