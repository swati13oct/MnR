@TeamPredators
@ordermaterials
Feature: To test order plan materials flow in UHC site

# Not needed as covered in next scenario for Option Selection and Confirmation
  #@radiobuttonOptionsFederal
  #Scenario Outline: Verify order plan materials in UHC site for Federal member
  #  Given registered UHC member for order plan materials with following attributes
  #    | Plan Type   | <planType>   |
  #    | Member Type | <memberType> |
  #  When the user views order materials in UHC site
  #  And the user selects an option from the orderp list in Redesign site
  #    | Option    | <option>   |
  #    | Plan Type | <planType> |

Scenario Outline:Verify order plan materials in UHC site for federal members
Given registered UHC member for order plan materials with following attributes 
	| Plan Type    | <planType>   |
	| Member Type  | <memberType> | 
When the user navigates to order plan materials through mymenu tab in UHC site
Examples:
  	 | planType   | memberType     | option              |
   # | MA         |  Individual    | Member Materials    | 
   #  | MAPD       |  Individual    | Replacement ID card |
   # | MA         | Group          | Replacement ID card |   
   # | MAPD       | Group          | Member Materials    |
   # | SSUP       | Group          | Replacement ID card |
   # | PDP        | Group          | Member Materials    |

@ordermaterialsfnf  
Scenario Outline:Verify order plan materials in UHC site for federal members
Given registered UHC member for order plan materials with following attributes 
	| Plan Type    | <planType>   |
	| Member Type  | <memberType> | 
	| Group Type    | <groupType> |
When the user navigates to order plan materials through mymenu tab in UHC site
Then the user validates add plan link on order and beneefits page
 
Examples:
     | planType   | memberType     | groupType              |
     | MAPD       | Group          | ALPEEHIP               |
@ValidateOrderSelectionandConfirmation
  Scenario Outline: Verify order plan materials in UHC site for radio button validation for ma and ssup member
    Given registered UHC member for order plan materials with following attributes
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When the user views order materials in UHC site
    And the user selects an option from the orderp list in Redesign site
      | Option    | <option>   |
      | Plan Type | <planType> |
    And the user validate order additional material and click to add other order additional material in Order Confirmation Page

    Examples: 
      | planType | memberType | option           |
      | MA       | Individual | Member Materials |
      | MAPD     | Individual | Member Materials |
      | MA       | Group      | Member Materials |
      | PDP      | Group      | Welcome Guide |
      | MAPD     | Group      | Member Materials |

