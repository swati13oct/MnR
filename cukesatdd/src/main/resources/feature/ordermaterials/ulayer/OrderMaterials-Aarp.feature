@ordermaterials
Feature:To test order materials in AARP site
Scenario Outline:Verify order materials in AARP site for federal type plan members
Given registered AMP member with following attributes
	| Plan Type | <planType> |
When the user views order materials in AARP site
And the user selects an option from the orderp list in AARP site
	| Option | <option> |
Then the user validates the plan materials under plan document section in AARP site
Examples:   
        | planType      |  option          |
#       | MA            | Member Materials | 
#	| MAPD          |   Welcome kit    | 	    
        | PDP           |  Welcome Guide   |
 
#Scenario Outline:Verify order materials in AARP site for ship type plan members
#Given registered AMP member with following attributes
#	| Plan Type | <planType> |
#When the user views order materials in AARP site
#And the user selects an option from the orderp list in AARP site
#| Option | <option> |
#| State Ccode|<statecode>|
#Then the user validates the plan materials under plan document section in AARP site
#Examples:   
#             | planType      |  option                            | statecode |
#             | MS            |Medicare Select Hospital Directory  | PENNSYLVANIA |

@radiobuttonpdpind
Scenario Outline:Verify order materials in AARP site for federal type plan members
Given registered AMP member with following attributes
	| Plan Type | <planType> |
When the user views order plan materials in AARP site
And the user validate radio button for PDP member in AARP site

Examples:   
        | planType      |  
        | PDP           | 
        
@radiobuttonvalidationpdpindi
Scenario Outline:Verify order materials in AARP site for pdp members
Given registered AMP member with following attributes
	| Plan Type | <planType> |
When the user views order plan materials in AARP site
Then the user validate radio button and click on submit button for PDP member in AARP site
And the user validate order additional material and click to add other order additional material in AARP site

Examples:   
        | planType      |  
        | PDP           |  
        