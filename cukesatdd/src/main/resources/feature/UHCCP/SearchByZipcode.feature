#Author: your.email@your.domain.com
@tag
Feature: Search by Zip Code

    @tagUHCCP-SZ @tagCP
    Scenario Outline: Search by Zip Code Validation - <zipcode>
    Given User loads the driver and User opens Community Portal Website for Search by Zip Code
    Then User clicks on find plans button for Search by Zip Code
    And User enters "<zipcode>" click on find plan button for Search by Zip Code
    When User should validate page heading for "<zipcode>" Health Plans for Search by Zip Code
    And close browser for Search by Zip Code
    
    Examples: 
      | zipcode  |
      | 35057    |
      | 85925    |
      #| 71601    |
      #| 94501    |
      #| 93650    |
      #| 81416    |
      | 80601    |
      | 06824    |
      #| 19904    |
      #| 20001    |
      #| 32935    |
      #| 33330    |
      #| 33407    |
      #| 30510    |
      #| 30802    |
      #| 96795    |
      #| 46733    |
      | 50002    |
      | 66041    |
      #| 66748    |
      #| 42715    |
      #| 70526    |
      #| 70638    |
      #| 04746    |
      #| 04236    |
      #| 20854    |
      #| 02740    |
      | 02741    |
      #| 49311    |
      | 48101    |
      #| 38834    |
      #| 63544    |
      #| 68901    |
      #| 89004    |
      #| 08037    |
      #| 12084    |
      | 14215    |
      | 27349    |
      #| 45693    |
      | 45011    |
      #| 74960    |
      #| 17325    |
      #| 02809    |
      #| 29620    |
      | 37705    |
      | 78520    |
      #| 79835    |
      #| 78640    |
      | 75070    |
      #| 78065    |
      #| 75801    |
      #| 22042    |
      #| 99352    |
      | 26250    |
      #| 53910    |
      | 54302    |
      
    
    
 