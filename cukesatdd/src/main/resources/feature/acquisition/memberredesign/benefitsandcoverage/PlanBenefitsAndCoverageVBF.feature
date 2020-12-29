@smokeTest @MemberVBF
Feature: 1.01-VBF-MemRedesign-To test plan benefits and Coverage functionality

  @smokeTest_BenefitsAndCoverageInd @vbfGate
  Scenario Outline: Verify multiple sections on Benefits and Coverage page for non-LIS federal members
    Given login with following details logins in the member portal and validate elements
      | Member Type | <memberType> |
       | Plan Type | <planType> |
   Then The user navigate to Benefits and Coverage page
    And section the user validates Ind plan overview
    And the user validates headers on Bnc page for indi members
    	| Plan Type | <planType> |
    And the user validates the Office Visits section
    And the user validates the Out of Pocket Max section
    And the user just validates the fields in Primarycare Provider section
    And the user view the Drug Copays & Discounts header
    And the user validates the Learn More section for stage and tier
    And the user validates dropdown selection functionality
    And the user validates Drug coverage header and text under the section
    And the user validated the Look up Drugs link
    And the user validates the copay coinsurance in drug costs table
    And the user validates text for the Locate a Pharmacy section
    And the user validates Needhelp header and disclaimer link
    And the user clicks on More Information link
    And the user validates view and document label

    Examples: 
      | memberType              | planType |
      # |  BncnonlisUHCIndividual |  | 
      | BncnonlisAARPIndividual | MAPD |

  @smokeTest_BenefitsAndCoverageGrp @vbfGate
  Scenario Outline: Verify multiple sections on Benefits and Coverage page for non-LIS group member
    Given login with following details logins in the member portal and validate elements
      | Member Type | <memberType> |
       | Plan Type | <planType> |
    Then The user navigate to Benefits and Coverage page
    And the NON LIS user validates plan overview section for group
    And the user validates headers on Bnc page for indi members
    | Plan Type | <planType> |
    And the user validates the Out of Pocket Max section
    And the user validates the Group Primarycare Provider section
    And the user view the Drug Copays & Discounts header
    And the user validates the Learn More section for stage and tier
    And the user validates dropdown selection functionality
    And the user validated the Look up Drugs link
    And the user validates text for the Locate a Pharmacy section
    And the user validates Needhelp header and disclaimer link
    And the user clicks on More Information link
    And the user validates view and document label

    Examples: 
      | memberType            | planType | friendname | favcolor | phonenumber |
      | BncnonlisGroupRetiree | MAPD |   name1      | color1   | number1     |