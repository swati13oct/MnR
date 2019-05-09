@fixedTestCaseTest @pharmacylocatorulayer
Feature: 1.17-VBF-Acq-To test Locate a Pharmacy in acqusition flow AARP site

  @pharmacylocatorulayerSmoke
  Scenario Outline: To verify available pharmacies in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user hovers to Our Plans and select Request More Help and Information for following plan type in AARP Site
      | <plantype> |
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses a plan from dropdown in AARP Site
      | <planName> |
    Then the user validates the available pharmacies page in AARP site

    Examples: 
      | zipcode | distance | county       | planName                                          | plantype |
      |   80002 | 25 miles | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | MA       |
 #	| 80002       | 15 miles     | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | MA |

  @availablePharmAARP
  Scenario Outline: To verify available pharmacies with language in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user hovers to Our Plans and select Request More Help and Information for following plan type in AARP Site
      | <plantype> |
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses a plan from dropdown in AARP Site
      | <planName> |
    Then the user validates the available pharmacies page in AARP site
    When the user selects a language from dropdown in AARP Site
      | <languageName> |
    Then the user should see choose a plan in AARP site

    Examples: 
      | zipcode | distance | county       | planName                                          | plantype | languageName |
      |   80002 | 25 miles | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | MA       | Spanish      |

  #	| 80002       | 15 miles     | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  | MA |Spanish |
  #	| 90210       | 2        |      | AARP MedicareRx Preferred (PDP)                    | PDP |
  @pharmaciesServicesAARP
  Scenario Outline: To verify available pharmacies and Services in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user hovers to Our Plans and select Request More Help and Information for following plan type in AARP Site
      | <plantype> |
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses a plan from dropdown in AARP Site
      | <planName> |
    Then the user validates the available pharmacies page in AARP site
    Then the user chooses the Pharmacy Type
      | <pharmacytype> |
    Then the user chooses the Service Type
      | <servicetype> |
    Then the user validates the available pharmacies page in AARP site

    Examples: 
      | zipcode | distance | county       | planName                                          | plantype | pharmacytype              | servicetype   |
      |   80002 | 25 miles | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO) | MA       | Standard Network Pharmacy | Open 24 hours |

  @pharmaciesSelPharmacyTypesAARP
  Scenario Outline: To verify available pharmacies for particular pharmacy types in AARP site
    Given the user is on the AARP Medicare Site landing page
    When the user hovers to Our Plans and select Request More Help and Information for following plan type in AARP Site
      | <plantype> |
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses a plan from dropdown in AARP Site
      | <planName> |
    And the user searches available pharmacies by selecting "Show pharmacies for these services." in AARP site
      | <pharmacytype> |
    Then the user validates the available pharmacies page in AARP site
    And the user clicks on SearchAgain and navigates to pharmacies search page in the AARP site

    Examples: 
      | zipcode | distance | county | planName | pharmacytype | plantype |

  #	| 80002       | 25        | Adams County      | AARP MedicareComplete SecureHorizons Plan 1 (HMO)  |  Standard Network Pharmacy,Long-term care|MA|
  #	| 90210       | 2        |       | AARP MedicareRx Preferred (PDP)                    |    Standard Network Pharmacy 				|PDP|
  @errorMessageNoPharamcyAARP
  Scenario Outline: To verify error message for no results found for pharmacy type in UMS site
    Given the user is on the AARP Medicare Site landing page
    When the user hovers to Our Plans and select Request More Help and Information for following plan type in AARP Site
      | <plantype> |
    When the user navigates to pharmacy search page in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses a plan from dropdown in AARP Site
      | <planName> |
    And the user validates the error message for no pharmacies found for below pharmacy in the AARP Site
      | <pharmacytype> |

    Examples: 
      | zipcode | distance | county | planName | pharmacytype | plantype |

  #	| 90210       | 2        |       | AARP MedicareRx Preferred (PDP)                    |   Mail Order Pharmacy				|PDP|
@pharmacyLocatorUlayerSmoke
  Scenario Outline: To verify available pharmacies in AARP site for zipcode <zipcode> and county <county>
Given the user is on AARP medicare acquisition site landing page
    When the user hovers to Our Plans and select pharmacy search for following plan type in AARP Site
    And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
    And the user chooses a plan from dropdown in AARP Site
      | planname | <planName> |
      | planyear | <planYear> |
    Then the user validates the available pharmacies page in AARP site
    Then the user chooses the Pharmacy Type
      | <pharmacytype> |
    Then the user chooses the Pharmacy Type
      | <servicetype> |
    Then the user validates the available pharmacies page in AARP site
    When the user selects a language from dropdown in AARP Site
      | <languageName> |
    And the user validates language changes in AARP site
    And the user chooses a plan from dropdown in AARP Site
      | planname | <planName> |
      | planyear | <planYear> |
    Then the user validates the available pharmacies page in AARP site

    Examples: 
      | zipcode | distance | county       | planName                                          | planYear | pharmacytype              | servicetype   | languageName |
      |   80002 | 25 miles | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |     2019 | Standard Network Pharmacy | Open 24 hours | Spanish      |
      |   90210 | 25 miles | None         | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |     2019 | Standard Network Pharmacy | Open 24 hours | Spanish      |

  @F250062 @PharmacySearchMultiCOunty @fastandfurious @Feb_release_2019
  Scenario Outline: Validate Cancel button for Multi Cunty Pop-up on PharmacySearch Page
    Given the user is on the AARP Medicare Site landing page
    When the user hovers to Our Plans and select pharmacy search for following plan type in AARP Site
    And the user enters following Multi County details and  validates the Cancel button for Multi COunty Pop-up clears the Zip code text fields in pharmacy search in AARP Site
      | Zip Code | <zipcode> |
    When the user selects a language from dropdown in AARP Site
      | <languageName1> |
    And the user enters following Multi County details and  validates the Cancel button for Multi COunty Pop-up clears the Zip code text fields in pharmacy search in AARP Site
      | Zip Code | <zipcode> |
    When the user selects a language from dropdown in AARP Site
      | <languageName2> |
    And the user enters following Multi County details and  validates the Cancel button for Multi COunty Pop-up clears the Zip code text fields in pharmacy search in AARP Site
      | Zip Code | <zipcode> |

    Examples: 
      | zipcode | languageName1 | languageName2 |
      |   80002 | Chinese       | Spanish       |

 @pharmacyLocatorPerformanceUlayer
Scenario Outline: To verify available pharmacies in AARP site for zipcode <zipcode> and county <county> for performance
Given the user is on AARP medicare acquisition site landing page
When the user hovers to Our Plans and select pharmacy search for following plan type in AARP Site
And the user enters following details for pharmacy search in AARP Site
      | Zip Code    | <zipcode>  |
      | Distance    | <distance> |
      | County Name | <county>   |
And the user chooses a plan from dropdown in AARP Site
      | planname | <planName> |
      | planyear | <planYear> |
Then the user validates the available pharmacies page in AARP site

Examples: 
      | zipcode | distance | county       | planName                                          | 
      |   80002 | 25 miles | Adams County | AARP MedicareComplete SecureHorizons Plan 1 (HMO) |  