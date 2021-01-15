Feature: Member Header validation from secondary page

  @CodeWarriors
  Scenario Outline: plan: <planType> -memberType: <memberType> - To check that the Find Care or Find Care and Costs Tab is not displayed for termed MedSupp
	    Given login with following details logins in the member portal and validate elements
	      | Plan Type   | <planType>   |
	      | Member Type | <memberType> |
	      | Flow		| <flow> 	   |
	    Then The user navigate to Benefits and Coverage page
	    Then I should not be able to see the Find Care & Costs tab Header
	    And I should not be able to see the Find Care tab Header
			
	    Examples: 
	      | planType | memberType 	 | flow   |
	      | SHIP     | TermedMedsupp | header |

  @CodeWarriors
  Scenario Outline: plan: <planType> -memberType: <memberType> - To check that the Find Care Tab is displayed for active MedSupp
	    Given login with following details logins in the member portal and validate elements
	      | Plan Type   | <planType>   |
	      | Member Type | <memberType> |
	      | Flow	| <flow> |
	    When the user clicks on Premium Payments on Header
	    Then I should be able to see and use the Find Care tab Header
			
	    Examples: 
	      | planType | memberType 	  | flow   |
	      | SHIP     | Medsupp    | header |
	      | SHIP 	 | Combo_Medsupp_TermedPDP | header |
	      
  @CodeWarriors
  Scenario Outline: plan: <planType> -memberType: <memberType> - To check that the Find Care and Costs Tab is displayed for combo plan
	    Given login with following details logins in the member portal and validate elements
	      | Plan Type   | <planType>   |
	      | Member Type | <memberType> |
	      | Flow	| <flow> |
	    When the user clicks on Premium Payments on Header
	    Then I should be able to see and use the Find Care & Costs tab Header
			
	    Examples: 
	      | planType | memberType 	  	 	   | flow   |
	      | SHIP     | Combo_PDP_Medsupp	   | header |
	      | SHIP     | Combo_PDP_TermedMedsupp | header |