Feature: 1.15 Member pre-effective functionality

  @regressionMemberPROD1
  Scenario Outline: -planType: <planType> - Member Type: - <memberType> - Verify that correct links and messages are displayed on Dashboard and Secondary Page.
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And verify that preeffective message is displayed on the home page or test harness page
    And verify that payment tab is displayed to Preeffective member on dashboard or test harness page
      | Member Type | <memberType> |
      | PlanType    | <planType>   |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that subnavigation is supressed on the coverage and benefits page
    #And verify that correct preeffective message is displayed on coverage and benefits page
    #And verify that correct phone number is displayed in technical support section of coverage and benefits page
    #  | Technical TFN | <technicalTFN> |
    And verify that claim support header with phone number in Need Help is not displayed to SHIP Pre-effective members on coverage and benefits page
      | Member Type | <memberType> |
    And user click on the plan documents button
    And user is navigated to Forms and Resource page
    And verify that payment tab is displayed to Preeffective member from secondary pages
      | Member Type | <memberType> |
    And user clicks on the Premium Payment tab from Forms and Resources Page
      | Member Type | <memberType> |
    And verify that correct phone number is displayed in technical support section of Payments page
      | Member Type   | <memberType>   |
      | Technical TFN | <technicalTFN> |

    Examples: 
      | planType | memberType          | copayCategory | technicalTFN   | segmentId | username | password | member                  | planstartdate |
      # | IndMA    | preeffectiveIndMA   | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@04 | Ranch1955            | 10/01/2020    |
      | IndMAPD  | preeffectiveIndMAPD | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@04 | Mino77003               | 01/01/2021    |
      | IndPDP   | preeffectiveIndMA   | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@04 | Cindyrose1218@Gmail.Com | 12/01/2020    |

  @regressionMemberPROD2
  Scenario Outline: -planType: <planType> - Member Type: - <memberType> - Verify that correct links and messages are displayed on Dashboard and Secondary Page.
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And verify that preeffective message is displayed on the home page or test harness page
    And verify that payment tab is displayed to Preeffective member on dashboard or test harness page
      | Member Type | <memberType> |
      | PlanType    | <planType>   |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that subnavigation is supressed on the coverage and benefits page
    And verify that correct preeffective message is displayed on coverage and benefits page
    And verify that correct phone number is displayed in technical support section of coverage and benefits page
      | Technical TFN | <technicalTFN> |
    And verify that claim support header with phone number in Need Help is not displayed to SHIP Pre-effective members on coverage and benefits page
      | Member Type | <memberType> |
    And user click on the plan documents button
    And user is navigated to Forms and Resource page
    And verify that payment tab is displayed to Preeffective member from secondary pages
      | Member Type | <memberType> |
    And user clicks on the Premium Payment tab from Forms and Resources Page
      | Member Type | <memberType> |
    And verify that correct phone number is displayed in technical support section of Payments page
      | Member Type   | <memberType>   |
      | Technical TFN | <technicalTFN> |

    Examples: 
      | planType | memberType          | copayCategory | technicalTFN   | segmentId | username | password | member     | planstartdate |
      | IndPDP   | preeffectiveIndPDP  | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@04 | wahdey     | 11/01/2020    |
      | GroupMA  | preeffectiveGroupMA | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@04 | marklflynn | 11/01/2020    |

  @regressionMemberPROD3
  Scenario Outline: -planType: <planType> - Member Type: - <memberType> - Verify that correct links and messages are displayed on Dashboard and Secondary Page.
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And verify that preeffective message is displayed on the home page or test harness page
    And verify that payment tab is displayed to Preeffective member on dashboard or test harness page
      | Member Type | <memberType> |
      | PlanType    | <planType>   |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that subnavigation is supressed on the coverage and benefits page
    And verify that correct preeffective message is displayed on coverage and benefits page
    And verify that correct phone number is displayed in technical support section of coverage and benefits page
      | Technical TFN | <technicalTFN> |
    And verify that claim support header with phone number in Need Help is not displayed to SHIP Pre-effective members on coverage and benefits page
      | Member Type | <memberType> |
    And user click on the plan documents button
    And user is navigated to Forms and Resource page
    And verify that payment tab is displayed to Preeffective member from secondary pages
      | Member Type | <memberType> |
    And user clicks on the Premium Payment tab from Forms and Resources Page
      | Member Type | <memberType> |
    And verify that correct phone number is displayed in technical support section of Payments page
      | Member Type   | <memberType>   |
      | Technical TFN | <technicalTFN> |

    Examples: 
      | planType  | memberType            | copayCategory | technicalTFN   | segmentId | username | password | member       | planstartdate |
      | GroupMAPD | preeffectiveGroupMAPD | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@04 | CatnJack     | 12/01/2020    |
      | SHIP      | preeffectiveSHIPOnly  | NON LIS       | 1-866-254-3132 |       000 | jkuma14  | Brock@04 | ludstevens91 | 11/01/2020    |

  @regressionMemberPROD4 @sanityMemberPROD1
  Scenario Outline: -planType: <planType> - Member Type: - <memberType> - Verify that correct links and messages are displayed on Dashboard and Secondary Page.
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And verify that preeffective message is displayed on the home page or test harness page
    And verify that payment tab is displayed to Preeffective member on dashboard or test harness page
      | Member Type | <memberType> |
      | PlanType    | <planType>   |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that subnavigation is supressed on the coverage and benefits page
    And verify that correct preeffective message is displayed on coverage and benefits page
    And verify that correct phone number is displayed in technical support section of coverage and benefits page
      | Technical TFN | <technicalTFN> |
    And user clicks on SHIP Plan Tab on Benefits and Coverage tab
    And verify that correct SHIP phone number is displayed in technical support section of coverage and benefits page
      | Technical TFN SHIP | <technicalTFNSHIP> |
    And verify that claim support header with phone number in Need Help is not displayed to SHIP Pre-effective members on coverage and benefits page
      | Member Type | <memberType> |
    And user click on the plan documents button
    And user is navigated to Forms and Resource page
    And verify that payment tab is displayed to Preeffective member from secondary pages
      | Member Type | <memberType> |
    And user clicks on the Premium Payment tab from Forms and Resources Page
      | Member Type | <memberType> |

    # And verify that correct phone number is displayed in technical support section of Payments page
    #    | Member Type   | <memberType>   |
    #   | Technical TFN | <technicalTFN> |
    #   And user clicks on SHIP Plan Tab on Payments page
    #   And verify that correct SHIP phone number is displayed in technical support section of payments page
    #    | Technical TFN SHIP | <technicalTFNSHIP> |
    Examples: 
      | planType | memberType               | copayCategory | technicalTFN   | segmentId | username | password | member         | planstartdate | technicalTFNSHIP |
      | IndPDP   | preeffectivePDPSHIPCOMBO | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@04 | daleandnancy20 | 12/01/2020    | 1-866-254-3132   |

  @regressionMemberPROD4 @sanityMemberPROD2
  Scenario Outline: -planType: <planType> - Member Type - <memberType> - Verify that correct links and messages are displayed on Dashboard and Secondary Page.
    Given the user is on member auth login flow page
    When the member is able to login with correct username and password
      | Username | <username> |
      | Password | <password> |
    And Member Enters the Username he wants to search
      | MemUsername | <member> |
    And user clicks on member to select
    And verify that preeffective message is displayed on the home page or test harness page
    And verify that payment tab is displayed to Preeffective member on dashboard or test harness page
      | Member Type | <memberType> |
      | PlanType    | <planType>   |
    And user clicks on benefits and coverage tab on home page or test harness page
      | PlanType | <planType> |
    And verify that subnavigation is supressed on the coverage and benefits page
    And verify that correct preeffective message is displayed on coverage and benefits page
    And verify that correct phone number is displayed in technical support section of coverage and benefits page
      | Technical TFN | <technicalTFN> |
    And user clicks on SSUP Plan Tab on Benefits and Coverage tab
    And verify that correct phone number is displayed in technical support section of coverage and benefits page
      | Technical TFN | <technicalTFN> |
    And verify that claim support header with phone number in Need Help is not displayed to SHIP Pre-effective members on coverage and benefits page
      | Member Type | <memberType> |
    And user click on the plan documents button
    And user is navigated to Forms and Resource page
    And verify that correct phone number is displayed in technical support section of forms and resources page
      | Technical TFN | <technicalTFN> |
    And user clicks on SSUP Plan Tab on forms and resources tab
    And verify that correct phone number is displayed in technical support section of forms and resources page
      | Technical TFN | <technicalTFN> |

    Examples: 
      | planType     | memberType                    | copayCategory | technicalTFN   | segmentId | username | password | member    | planstartdate |
      | GroupPDPSSUP | preeffectiveGROUPPDPSSUPCOMBO | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@04 | Be7779311 | 11/01/2020    |
