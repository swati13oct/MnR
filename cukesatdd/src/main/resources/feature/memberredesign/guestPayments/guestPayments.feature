@guestPayment
Feature: 1.06.7 Member Guest Payments Page

 @guestPayment01 @indUHC @indAARP @indMedica @indPCP @retiree
  Scenario Outline: TID: <TID> - To validate the Guest Payment page E2E Scenario
  
    Given I am on the Welcome Page of M&R Guest Premium Payment portal
         | Site Name | <siteName> |
    Then I validate all the header and page elements
    When I click on link Help me find my id link
    Then I will enter my Member ID and Date of birth
    And I will click next to proceed to the Make a One-time payment page

    Examples:
      | TID   | planType | Member ID | Birth date | Site Name |


  @guestPayment02 @ErrorsAndContent
  Scenario Outline: TID: <TID> - To validate the Guest Payment page E2E Scenario
    Given I am on the Welcome Page of M&R Guest Premium Payment portal
    Then I validate all the header and page elements
    When I click on link Help me find my id link

    And the member ID information is missing or not in the correct format (ID card format or format recognized in GPS)
    Then I will get an error message
    Then I will enter my Member ID and Date of birth
    And the Date of Birth is missing or not in the correct format (MM/DD/YYYY)
    Then I will get an error message
    Then I will enter my Member ID and Date of birth
    And I will click next to proceed to the Make a One-time payment page
    Then Error match cannot be found in GPS
    Then I will get an error message by the input field and the top of the page
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


  @guestPayment03 @Blockeduser @SHIPBlocked @Terminated @100%Subsidy @PremiumtoaBank
  Scenario Outline: TID: <TID> - To validate the Guest Payment page E2E Scenario
    Given I am on the Welcome Page of M&R Guest Premium Payment portal
    Then I validate all the header and page elements
    When I click on link Help me find my id link
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

  @guestPayment04 @C&SplanBLOCKED
  Scenario Outline: TID: <TID> - To validate the Guest Payment page E2E Scenario
    Given I am on the Welcome Page of M&R Guest Premium Payment portal
    Then I validate all the header and page elements
    When I click on link Help me find my id link
    Then I will enter my Member ID and Date of birth
    And I will click next to proceed to the Make a One-time payment page
    Then I will get an error message
    And I will be instructed to call the number on the back of my ID
    And I will not see the link to the authenticated M&R member site

    Examples:
      | TID   | planType | Member ID | Birth date |