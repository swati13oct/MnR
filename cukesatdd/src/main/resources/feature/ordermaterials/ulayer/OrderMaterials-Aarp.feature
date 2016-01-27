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
