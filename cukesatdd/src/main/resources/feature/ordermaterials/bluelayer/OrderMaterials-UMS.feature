@ordermaterials
Feature:To test order plan materials flow in UHC site
Scenario Outline:Verify order plan materials in UHC site for federal members
Given registered UHC member for order plan materials with following attributes 
	| Plan Type | <planType> |
	| Category  | <category> | 
When the user navigates to order plan materials through mymenu tab in UHC site
And the user selects an option from the order plan material list in UHC site
	| Option | <option> |
Then the user validates the plan materials under plan document section in UHC site
Examples:
     | planType   | category       | option              |
   # | MA         |  Individual    | Member Materials    | 
   # | MAPD       |  Individual    | Replacement ID card |
   # | MA         | Group          | Replacement ID card |   
   # | MAPD       | Group          | Member Materials    |
   # | SSUP       | Group          | Replacement ID card |
     | PDP        | Group          | Member Materials    |

 
 
Scenario Outline:Verify order plan materials in UHC site for combo type member
Given registered UHC member with following attributes
	| Plan Type1 | <planType1> | 
	| Plan Type2 | <planType2> |
	| Category  | <category> |
When the user views order materials in UHC site
And the user selects member plan from the list in UHC site
	|Plan|<plan> | 
And the user selects an option from the order list in UHC site
| Option | <option> |                  |   	
Then the user validate confirmation message for selected order in order plan materials    
Examples:
    | planType1   | planType2      | category |         option   |
 #   | PDP         | SSUP           |          | Member Materials |  
