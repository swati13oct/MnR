@needHelp
Feature: To validate the Need Help section on the member site
# note: for claims details page Need Help validation, it will be handled within the claims regression testing

  @needHelp01 @regressionMember
  Scenario Outline: TID: <TID> -plan: <planType> -memberType: <memberType> - To validate the NeedHelp section on member page
    Given login with following details logins in the member portal and validate elements
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    When I am on dashboard or testharness page
      | Plan Type    | <planType>    |
      | Member Type  | <memberType>  |
    Then I navigate to the Claims Summary page
    And I validate Need Help section on Claims page
    Then I navigate to the Order Plan Materials page
    And I validate Need Help section on Order Plan Materials page
    Then I navigate to pharmacy search page
    And I validate Need Help section on Pharmacy Locator page
    Then I navigate to the Preference page
    And I validate Need Help section on Preference page

    Examples: 
      | TID   | planType | memberType               |
      | xxxxx | MA       | AARP_Individual_needHelp |
      | xxxxx | MAPD     | AARP_Individua_needHelp  |
      | xxxxx | MA       | UHC_Individual_needHelp  |
      | xxxxx | MAPD     | UHC_Individual_needHelp  |
      | xxxxx | PDP      | Individual_needHelp      |
      | xxxxx | PCP      | Individual_needHelp      |
      | xxxxx | MEDICA   | Individual_needHelp      |
      | xxxxx | SHIP     | Individual_needHelp      |
      | xxxxx | SHIP     | COMBO_needHelp           |
      | xxxxx | SSUP     | COMBO_GROUP_needHelp     |
      | xxxxx | PDP      | COMBO_GROUP_needHelp     |
      | xxxxx | MAPD     | GROUP_needHelp           |
      | xxxxx | MA       | GROUP_needHelp           |

