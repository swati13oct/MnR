 @PlansAndDocument_Part1 @PlansAndDocuments @VelocityDasher
Feature: 1.06.1 Member Plans and Documents Page part 1

			# This feature File consist of Scenario 1 and 2 only.
 
 @PlansAndDocuments1 @F&RJMPLinks @Feb_release_2019 @gladiators @regressionMember @PD_Part1_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> -Rider: <rider>-To verify quicklinks for a MAPD member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
      | Rider       | <rider>      |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then user verifies presence of jump links on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |

    And user clicks on the jump links and checks respective sections on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And verifies links irrelevant to the plan type are not displayed on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | Count      | <count>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |

    #Membership material comes dynamically based on the logic
    # EOB Header xpath is not working Need to fix it
    Examples: 
      | TID     | planType | memberType                 | Identifier         | language | count | rider   |
      | 15108_1 | MAPD     | Individual_FormsResources  | IndEffectiveAARP   | ENGLISH  |     7 | NoRider |
      | 15108_2 | MAPD     | Individual_FormsResourcesl | IndEffectiveUHC    | ENGLISH  |     6 | Rider   |
      | 15128_1 | PCP      | Individual_FormsResources  | IndEffectivePCP    | ENGLISH  |     6 | NoRider |
      | 15128_2 | MEDICA   | Individual_FormsResourcesl | IndEffectiveMedica | ENGLISH  |     6 | NoRider |
			| 15303   | MAPD     | Group_FormsResources       | GrpEffectiveUHC    | ENGLISH  |     7 | NoRider |
  
  
  @PlansAndDocuments2 @F&RJMPLinks @Feb_release_2019 @gladiators @regressionMember  @PD_Part1_Regression
  Scenario Outline: TID: <TID> -Plan Type: <planType> -Member Type: <memberType> - Verify jump links for individual MA member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
      | identifier  | <Identifier> |
      | Rider       | <rider>      |
    And user clicks on the view document and resources link and navigate to forms and resource page
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    Then user verifies presence of jump links on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And user clicks on the jump links and checks respective sections on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |
    And verifies links irrelevant to the plan type are not displayed on F&R page
      | Plan Type  | <planType>   |
      | Rider      | <rider>      |
      | Count      | <count>      |
      | MemberType | <memberType> |
      | identifier | <Identifier> |

    Examples: 
      | TID   | planType | memberType                 | Identifier          | language | count | rider   |
      | 15130 | MA       | Group_FormsResources       | GrpEffectiveUHC     | ENGLISH  |     7 | NoRider |
      | 00000 | MA       | Individual_FormsResourcesl | IndEffectiveUHC     | ENGLISH  |     7 | Rider   |

