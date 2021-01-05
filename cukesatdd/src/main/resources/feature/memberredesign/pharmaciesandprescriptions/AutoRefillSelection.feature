Feature: Refill - Auto Refill selection
  I want the ability to enroll in auto refill when I have eligible home delivery medications, so I can receive my refills automatically from OptumRx when they are available to be filled.  

  @AutoRefill @F482464 @US2781896 @US2878348
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify Auto refill display - eligible member
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will view the Refill All Medications CTA on MY Medications Page
    When user select the Refill All Medications CTA
    Then user will be brought to the "Complete Your Refill" page for that medication
    #When user view the medication section
    Then user will see the auto refill line populate for any eligible medications on Refill Checkout Summary Page

    Examples: 
      | FID     | planType | memberType             |
      | F482464 | PDP      | Rx_Refill_AutoRefillOn |

  #3f82e307-f5e0-4dc3-b4aa-072376bcf037/q1_feb_Rx_088/Password@1
  @AutoRefill @F482464 @US2781896 @US2878348
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify Eligible prescription not enrolled in auto refill
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will view the Refill All Medications CTA on MY Medications Page
    When user select the Refill All Medications CTA
    Then user will be brought to the "Complete Your Refill" page for that medication
    #When user view the medication section
    Then user will see the auto refill line populate for any eligible medications on Refill Checkout Summary Page
    Then user will view Auto Refill Off displaying unchecked box 


    Examples: 
      | FID     | planType | memberType              |
      | F482464 | PDP      | Rx_Refill_AutoRefillOff |
	#fe59d207-e320-4885-bb9a-4b1097d96188/EPMP_Enabled_072/Password@1/Rx_Refill_AutoRefillOff

  @AutoRefill @F482464 @US2781896 @US2878348
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify the Prescription not eligible for auto refill
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will view the Refill All Medications CTA on MY Medications Page
    When user select the Refill All Medications CTA
    Then user will be brought to the "Complete Your Refill" page for that medication
    #When user view the medication section
    Then user will not view the Auto Refill display

    Examples: 
      | FID     | planType | memberType             |
      | F482464 | PDP      | Rx_Refill_AutoRefillNE |
  #509d48be-374a-4d86-a5e0-c4ab2e604d32/PDP/Rx_Refill_AutoRefillNE
  #aeccdedd-34f1-4cae-bc16-d40431198164

  
  
  @AutoRefill @F482464 @US2781893 @US2781895 @US2878346 @US2878347
  Scenario Outline: FID: F<FID> -plan: <planType> -memberType: <memberType> - To verify Turn off auto refill
    Given login with following details logins in the member portal and validate elements
      | Plan Type   | <planType>   |
      | Member Type | <memberType> |
    When user navigates to the pharmacies and prescriptions page from testharness page
    And user clicks View all medications link to view the My Medications page
    Then user will view the Refill All Medications CTA on MY Medications Page
    When user select the Refill All Medications CTA
    Then user will be brought to the "Complete Your Refill" page for that medication
    #When user view the medication section
    Then user will view Auto Refill off displaying unchecked box
    When user select the auto refill checkbox
    Then user will view auto refill enrollment page asking for enroll auto refill
    When user select Cancel
    Then user will see "Complete Your Refill" Page
    Then user will view Auto Refill off displaying unchecked box
    When user select the auto refill checkbox
    Then user will view auto refill enrollment page asking for enroll auto refill
    When user select Enroll in auto refill
    Then user will see "Complete Your Refill" Page
    Then user will view Auto Refill On displaying checked box    
    When user deselect the auto refill checkbox
    Then user will view auto refill disenrollment page asking for stop auto refill
    When user select Continue auto refill
    Then user will see "Complete Your Refill" Page
    Then user will view Auto Refill On displaying checked box
    When user deselect the auto refill checkbox    
    Then user will view auto refill disenrollment page asking for stop auto refill
    When user select Stop auto refill
    Then user will see "Complete Your Refill" Page
    Then user will view Auto Refill off displaying unchecked box
    
    
        Examples: 
      | FID     | planType | memberType             |
      | F482464 | PDP      | Rx_Refill_AutoRefillOff |