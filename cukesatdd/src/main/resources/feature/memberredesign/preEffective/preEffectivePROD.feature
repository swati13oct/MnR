Feature: 1.15 Member pre-effective functionality

  @regressionMemberPROD
  Scenario Outline: -planType: <planType> -Segment ID: <segmentId> - Member Type - <memberType> - Verify that correct links and messages are displayed on Dashboard and Secondary Page.
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
#    And user clicks on claims tab from Forms and Resources page
#    And verify that subnavigation is supressed on the claims page
#    And verify that correct preeffective message is displayed on claims page
#    And verify segment ID on claims page
#      | Plan Type   | <planType>   |
#      | Member Type | <memberType> |
#      | Segment ID  | <segmentId>  |
#    And verify that correct phone number is displayed in technical support section of claims page
#      | Technical TFN | <technicalTFN> |
#    And verify that claim support header with phone number in Need Help is not displayed to SHIP Pre-effective members on Claims Page
#      | Member Type | <memberType> |
    And verify that payment tab is displayed to Preeffective member from secondary pages
      | Member Type | <memberType> |
   
    Examples: 
      | planType  | memberType            | copayCategory | technicalTFN   | segmentId | username | password | member   |planstartdate|
      | IndMA     | preeffectiveIndMA     | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@02 | FRANZEN6 | 06/01/2020|
      | IndMAPD   | preeffectiveIndMAPD   | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@02 | BUGME99 | 08/01/2020|
      | IndPDP    | preeffectiveIndPDP    | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@02 | dickersonsfarm |07/01/2020|
      | GroupMA   | preeffectiveGroupMA   | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@02 | 55Elaine|06/01/2020|
      | GroupMAPD | preeffectiveGroupMAPD | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@02 | josephwfletcher|06/01/2020|
      | SHIP      | preeffectiveSHIPOnly  | NON LIS       | 1-866-254-3132 |       000 | jkuma14  | Brock@02 | andybaum |06/01/2020|
 #    | GroupSSUP | preeffectiveGroupSSUP | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@02 | FRANZEN6 ||
 #    | GroupPDP  | preeffectiveGroupPDP  | NON LIS       | 1-888-980-8125 |       000 | jkuma14  | Brock@02 | FRANZEN6 ||
    
