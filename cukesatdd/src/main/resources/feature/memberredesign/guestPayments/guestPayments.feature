@guestPayment
Feature: 1.06.7 Member Guest Payments Page

  @guestPayment01 @indUHC
  Scenario Outline: TID: <TID> - To validate the Guest Payment page E2E Scenario
    Given I am an M&R member in a Federal Individual UHC plan
    Then I will use the link PaymyUHCpremium.com (medicare.uhc.com/premium-payment)
    And I will land on the Welcome Screen of M&R Guest Premium Payment portal
    Then I can see Header and body content
    When I clicked on link Help me find my id and my id card displayed
    And I can see Member ID & Birth date text box 
    Then I will enter my Member ID and Date of birth
    And I will click next to proceed to the Make a One-time payment page

    Examples:
      | TID   | planType | Member ID | Birth date |

  @guestPayment02 @indAARP
  Scenario Outline: TID: <TID> - To validate the Guest Payment page E2E Scenario
    Given I am an M&R member in a Federal Individual AARP  plan
    Then I will use the link PaymyAARPpremium.com (medicare.uhc.com/aarp/premium-payment)
    And I will land on the Welcome Screen of M&R Guest Premium Payment portal
    Then I can see Header and body content
    When I clicked on link Help me find my id and my id card displayed
    And I can see Member ID & Birth date text box 
    Then I will enter my Member ID and Date of birth
    And I will click next to proceed to the Make a One-time payment page

    Examples:
      | TID   | planType | Member ID | Birth date |

  @guestPayment03 @indMedica 
  Scenario Outline: TID: <TID> - To validate the Guest Payment page E2E Scenario
    Given I am an M&R member in a Federal Individual Medica plan (South Florida)
    Then I will use the link PaymyMedicapremium.com (mymedicareaccrount.uhc.com/medica/premium-payment)
    And I will land on the Welcome Screen of M&R Guest Premium Payment portal
    Then I can see Header and body content
    When I clicked on link Help me find my id and my id card displayed
    And I can see Member ID & Birth date text box 
    Then I will enter my Member ID and Date of birth
    And I will click next to proceed to the Make a One-time payment page

    Examples:
      | TID   | planType | Member ID | Birth date |

  @guestPayment04 @indPCP 
  Scenario Outline: TID: <TID> - To validate the Guest Payment page E2E Scenario
    Given I am an M&R member in a Federal Individual Preferred Care Partners (PCP)  plan
    Then I will use the link PaymyPCPpremium.com (mymedicareaccrount.uhc.com/pcp/premium-payment)
    And I will land on the Welcome Screen of M&R Guest Premium Payment portal
    Then I can see Header and body content
    When I clicked on link Help me find my id and my id card displayed
    And I can see Member ID & Birth date text box 
    Then I will enter my Member ID and Date of birth
    And I will click next to proceed to the Make a One-time payment page

    Examples:
      | TID   | planType | Member ID | Birth date |

  @guestPayment05 @retiree
  Scenario Outline: TID: <TID> - To validate the Guest Payment page E2E Scenario
    Given I am an M&R member in a Employer Group plan
    Then I will use the link PaymyUHCpremium/retiree.com (medicare.uhc.com/retiree/premium-payment)
    And I will land on the Welcome Screen of M&R Guest Premium Payment portal
    Then I can see Header and body content
    When I clicked on link Help me find my id and my id card displayed
    And I can see Member ID & Birth date text box 
    Then I will enter my Member ID and Date of birth
    And I will click next to proceed to the Make a One-time payment page

    Examples:
      | TID   | planType | Member ID | Birth date |

  @guestPayment06 @ErrorLandingPage01
  Scenario Outline: TID: <TID> - To validate the Guest Payment page E2E Scenario
    Given I am on the Welcome Page of M&R Guest Premium Payment portal
    Then I can see Header and body content
    When I clicked on link Help me find my id and my id card displayed
    And I can see Member ID & Birth date text box 
    Then I will enter my Member ID and Date of birth
    And the member ID information is missing or not in the correct format (ID card format or format recognized in GPS)
    Then I will get an error message

    Examples:
      | TID   | planType | Member ID | Birth date |

  @guestPayment07 @ErrorLandingPage02
  Scenario Outline: TID: <TID> - To validate the Guest Payment page E2E Scenario
    Given I am on the Welcome Page of M&R Guest Premium Payment portal
    Then I can see Header and body content
    When I clicked on link Help me find my id and my id card displayed
    And I can see Member ID & Birth date text box 
    Then I will enter my Member ID and Date of birth
    And the Date of Birth is missing or not in the correct format (MM/DD/YYYY)
    Then I will get an error message

    Examples:
      | TID   | planType | Member ID | Birth date |

  @guestPayment08 @ErrorLandingPage03
  Scenario Outline: TID: <TID> - To validate the Guest Payment page E2E Scenario
    Given I am on the Welcome Page of M&R Guest Premium Payment portal
    Then I can see Header and body content
    When I clicked on link Help me find my id and my id card displayed
    And I can see Member ID & Birth date text box 
    Then I will enter my Member ID and Date of birth
    And I will click next to proceed to the Make a One-time payment page
    Then Error match cannot be found in GPS
    Then I will get an error message by the input field and the top of the page

    Examples:
      | TID   | planType | Member ID | Birth date |

  @guestPayment09 @Blockeduser @SHIPBlocked @Terminated @100%Subsidy @PremiumtoaBank
  Scenario Outline: TID: <TID> - To validate the Guest Payment page E2E Scenario
    Given I am on the Welcome Page of M&R Guest Premium Payment portal
    Then I can see Header and body content
    When I clicked on link Help me find my id and my id card displayed
    And I can see Member ID & Birth date text box 
    Then I will enter my Member ID and Date of birth
    And I will click next to proceed to the Make a One-time payment page
    Then I will get an error message
    And I will be instructed to call the number on the back of my ID
    And I will see the link to the authenticated M&R member site
    Then I clicked on the M&R member site link and navigated to Member Portal sign in page
    And the Logo will be displayed for my Brand & URL
    Then I will see the Logo specific to my plan and the Sign in button

    Examples:
      | TID   | planType | Member ID | Birth date |

  @guestPayment10 @C&SplanBLOCKED
  Scenario Outline: TID: <TID> - To validate the Guest Payment page E2E Scenario
    Given I am on the Welcome Page of M&R Guest Premium Payment portal
    Then I can see Header and body content
    When I clicked on link Help me find my id and my id card displayed
    And I can see Member ID & Birth date text box 
    Then I will enter my Member ID and Date of birth
    And I will click next to proceed to the Make a One-time payment page
    Then I will get an error message
    And I will be instructed to call the number on the back of my ID
    And I will not see the link to the authenticated M&R member site

    Examples:
      | TID   | planType | Member ID | Birth date |


