@ordermaterials
Feature:To test order materials in AARP site

@MAPSOrdermaterials
Scenario Outline:Verify order materials in AARP site for federal type plan members
Given registered AMP member with following attributes
	| Plan Type | <planType> |
When the user views order materials in AARP site
And the user selects an option from the orderp list in AARP site
	| Option | <option> |
		| Plan Type | <planType> |
	
Then the user validates the plan materials under plan document section in AARP site
Examples:   
        | planType      |  option          |
       | MA            | Member Materials | 
			| MAPD          |   Welcome kit    | 	    
        | PDP           |  Welcome Guide   |
 
 @SHIPOrderMaterials
Scenario Outline:Verify order materials in AARP site for ship type plan members
Given registered AMP member with following attributes
	| Plan Type | <planType> |
When the user views order materials in AARP site
And the user selects an option from the orderp list in AARP site
| Option | <option> |
	| Plan Type | <planType> |

Then the user validates the plan materials under plan document section in AARP site
Examples:   
            | planType      |  option    |  
            | SHIP          |Coupon Book  | 


# Already covered in @MAPSOrdermaterials
#@radiobuttonpdpind
#Scenario Outline:Verify order materials in AARP site for federal type plan members
#Given registered AMP member with following attributes
#	| Plan Type | <planType> |
#When the user views order plan materials in AARP site
#And the user validate radio button for Federal member in AARP site

#Examples:   
#        | planType      |  
#        | MA           | 
        
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
        
        
@comboConfirmationPage
Scenario Outline:Verify order materials confirmation page in AARP site
Given registered AMP member with following attributes
	| Plan Type | <planType> |
When the user views order plan materials in AARP site
Then the user validate radio button and click on submit button for PDP member in AARP site
And the user validate order additional material and click to add other order additional material in AARP site      


Examples:   
         | planType      |  
        | PDP           |  
        
        
@needhelpcomponent
Scenario Outline: Verify need help component in AARP site
Given registered AMP member with following attributes
	| Plan Type | <planType> |
When the user views order materials in AARP site
Then the user verify need help component in AARP site

Examples:   
        | planType      |  
        | MA            | 
        
@headertextandsubtext
Scenario Outline: Verify header and sub text in order materials page in AARP site for ship only combo plan
Given registered AMP member with following attributes
	| Plan Type | <planType> |
When the user views order materials in AARP site
Then the user verify header and sub text in order materials page in AARP site

Examples:   
        | planType      |  
        | SHIP          | 
        
   
 @ValidateHeaderTabs
 Scenario Outline: Verify Aarp Order Materials Page Header - All Combo Plan Types
    Given registered AMP member with following attributes
      | Plan Type   | <planType>   |
    When the user views order materials in AARP site
    Then user navigates to Order Materials page for all Plans
      | Combo Plans | <comboPlans> |
    And user Validates Page Header and Sub-Header text

    Examples: 
      	| planType | comboPlans |
     		| MA       | MA,HIP     |
     		| MAPD		 | MAPD,HIP		|
      	| PDP			 | PDP,MedSupp|
 
 @ValidateOrderMaterialOptions
 Scenario Outline: Verify Order Plan Material Options - All Combo Plan Types
    Given registered AMP member with following attributes
      | Plan Type   | <planType>   |
    When the user views order materials in AARP site
    Then user navigates to Order Materials page for all Plans
      | Combo Plans | <comboPlans> |
    And user validates all Order material Options for the plantype
      | Combo Plans | <comboPlans> |

    Examples: 
      	| planType | comboPlans |
     		| MA       | MA,HIP     |
     		| MAPD		 | MAPD,HIP		|
      	| PDP			 | PDP,MedSupp|
      	
@ValidateErrorMessage
 Scenario Outline: Verify Aarp Order Materials Page Error Message
    Given registered AMP member with following attributes
      | Plan Type   | <planType>   |
    When the user views order materials in AARP site
    And the user click Submit without any selection
    Then the user validates error message in Order Materials page
    
    Examples: 
      	| planType | comboPlans |
     		| MA       | MA,HIP     |

@ValidateSHIPErrorMessage
 Scenario Outline: Verify SHIP Invalid selection Order Materials Page Error Message
    Given registered AMP member with following attributes
      | Plan Type   | <planType>   |
    When the user views order materials in AARP site
    And the user selects an option from the orderp list in AARP site
	| Option | <option> |
	| Plan Type | <planType> |
    Then the user validates error message for SHIP invalid selection in Order Materials page
    
    Examples: 
      	| planType | option 			|
     		| SHIP     | Coupon Book  |