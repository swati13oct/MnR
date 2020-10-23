@dce_redesign_zipcode_planyear_capture_AEP @F426582
Feature: 1.10.1 DCE-REDESIGN AARP - To test ZipCode and Plan Year capture page in New DCE flow during AEP

  @DCE_ZipCodePlanYear_AEP 
  Scenario Outline: Test to verify the new DCE redesign page displayed for ZipCode and Plan year capture page for AEP on  <site> site
    Given the user is on medicare acquisition site landing page
    	|Site| <site>|
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
    | DrugName | <drugName> |
    And the user validates all added drugs in DrugList
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    And plan year dropdown should be displayed during AEP

		@dce_redesign_zipcode_planyear_capture_AEP_AARP
    Examples: 
       |drugName|site|
       |Lipitor|AARP|
       
    @dce_redesign_zipcode_planyear_capture_AEP_UHC
    Examples: 
       |drugName|site|
       |Lipitor|UHC|

  @DCE_ZipCodePlanYear_ValidateContinueBtn_AEP @F443609
  Scenario Outline: Test to verify the functionality of continue button on ZipCode and Plan year capture page when valid zipcode, county and plan year selected on  <site> site
    Given the user is on medicare acquisition site landing page
   		|Site| <site>|
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
    And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user selects plan year
    And user clicks on continue button in Zip Entry Page
    Then load screen should be displayed
    And user should be navigated to Review drug cost estimate page

		@dce_redesign_zipcode_planyear_capture_AEP_AARP
    Examples: 
      |drugName|zipCode |site|
      |Lipitor|  90210 |AARP|
		
		@dce_redesign_zipcode_planyear_capture_AEP_UHC
		Examples: 
      |drugName|zipCode |site|
      |Lipitor|  90210 |UHC|
      
  @DCE_ZipCodePlanYear_ErrorMessage_NoZipcode_AEP @F443609
  Scenario Outline: Test to verify the error message when user does not enter or enter invalid zipcode and clicks on continue button on <site> site
    Given the user is on medicare acquisition site landing page
        		|Site| <site>|
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Add drugs button
     And adds drugs in drug list page
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    When user enter invalid zipcode
      | inValidzipCode | <invalidzipcode2> |
    Then error message should be displayed
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user selects plan year
    And user clicks on continue button in Zip Entry Page
    Then load screen should be displayed
    And user should be navigated to Review drug cost estimate page
		
		@dce_redesign_zipcode_planyear_capture_AEP_AARP
    Examples: 
      | invalidzipcode | zipCode | invalidzipcode1 | invalidzipcode2 |drugName|site|
      |          78452 |   90210|            1234 |00000 |Lipitor|AARP|
      
    @dce_redesign_zipcode_planyear_capture_AEP_UHC
     Examples: 
      | invalidzipcode | zipCode | invalidzipcode1 | invalidzipcode2 |drugName|site|
      |          78452 |   90210|            1234 |00000 |Lipitor|UHC|

  @DCE_ZipCodePlanYear_SamChatCall_AEP
  Scenario Outline: To verify the SAM icons on DCE Zip code and plan year capture page on <site> site
    Given the user is on medicare acquisition site landing page
    		|Site| <site>|
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    When the user clicks on Build Drug List to navigate to Build Drug List Page
    And the user searches and adds the following Drug to Drug List
    | DrugName | <drugName> |
    And clicks on Review drug cost button
    Then user should be navigated to zipcode and plan year capture page for AEP
    Then the user validates whether call icon is visible
    Then the user validates whether chat icon is visible

		@dce_redesign_zipcode_planyear_capture_AEP_AARP
    Examples: 
      |drugName|site|
      |Lipitor|AARP|
      
     @dce_redesign_zipcode_planyear_capture_AEP_UHC
     Examples: 
      |drugName|site|
      |Lipitor| UHC|
