@organicSearchTFN_UHC
Feature: To test Organic Search Campaign TFN on UHC site

  @Scenario6B_GoogleSearch_UHC 
  Scenario Outline: - 6.2 Google and search UHC Medicare Advantage Plan
    Given user is on Google and search UHC Medicare Advantage Plan to navigate to UHC page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |

    Examples: 
      | pscCode | maUrl                                  | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |  
      |  880188 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] | 
      
@Scenario6G_YahooSearch_UHC  
Scenario Outline: - 6.7 Yahoo and search UHC Medicare Advantage Plan 
Given user is on Yahoo and search UHC Medicare Advantage Plan to navigate to UHC page
    And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |


   Examples: 
      | pscCode | maUrl                                  | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |  
      |  880189 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] | 


@Scenario3b_BingSearch_UHC  @Organic_Search_Bing  
Scenario Outline: - 3.2 Bing  search UHC Medicare Advantage Plan 
Given user is on Bing and search UHC Medicare Advantage Plan to navigate to navigate to UHC page
        And the user retrieves TFNSessionCookie and Federal and MedSupp TFN
    Then the user validates PSC code
      | PSC Code | <pscCode> |
    Then the user navigates to following MA Plan Page URL and validate Federal TFN
      | MA URL    | <maUrl> |
      | TFN Xpath | <maTFN> |
    Then the user navigate to following Med Supp Plan URL and validate MedSupp TFN
      | MedSupp URL | <medSuppUrl> |
      | TFN Xpath   | <medSuppTFN> |


   Examples: 
      | pscCode | maUrl                                  | maTFN                                                          | medSuppUrl                                                                | medSuppTFN     |  
      |  880187 | health-plans/enroll/ma-enrollment.html | //*[contains(@class,'callus')]//a[contains(@class, 'tel tfn')] | health-plans/medicare-supplement-plans/medicare-information.html?vpp=true | //*[@id='tfn'] | 
    