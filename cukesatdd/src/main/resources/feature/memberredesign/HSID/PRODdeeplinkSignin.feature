@regressionMemberPROD @OfflinePRODVanityURLdeeplinkSignin
Feature: To test URL formation on PROD Signin from various Deeplinks

  @regressionMemberPROD @codeWarriors @F477221
  Scenario Outline: Verify members lands on the PROD virtual visit page after signing in from virtual visit Vanity URL.
    Given member lands on the PROD virtual visit deeplink page
      | <brand> |
    And the PROD virtual visit deeplink login page is displayed with all the fields

    Examples: 
      | brand  |
      | PCP    |
      | Medica |
      | AARP   |
      | UHC    |

  #myaarpmedicare.com/virtualvisits
  #myuhcmedicare.com/virtualvisits
  #mypcpmedicare.com/virtualvisits
  #mymedicamedicare.com/virtualvisits
  
 #F514599 preadtors 
  @codeWarriors @F477221 @F514599predators
  Scenario Outline: Verify members lands on the PROD solutran deeplink HWP Vanity URL.
    Given member lands on the PROD HWP deeplink page
      | <brand> |
    And the offline PROD HWP deeplink login page is displayed with all the fields

    Examples: 
      | brand  |
      | PCP    |
      | Medica |
      | AARP   |
      | UHC    |
      
#myaarpmedicare.com/hwp
#myuhcmedicare.com/hwp
#mypcpmedicare.com/hwp
#mymedicamedicare.com/hwp

@regressionMemberPROD @codeWarriors @F477221
 Scenario Outline: Verify SHIP members lands on the PROD health & wellness deeplink from Vanity URL.
    Given member lands on the PROD health & wellness deeplink page
      | <brand> |
    And the PROD health & wellness deeplink login page is displayed with all the fields

    Examples: 
      | brand  |
      | SHIP   |
       
     #myaarpmedicare.com/Extras  
     
         @regressionMemberPROD @codeWarriors @F392073
  Scenario Outline: Verify Member lands on the PROD documents page after signing in from edelivery deeplink.
   Given member lands on the PROD edelivery deeplink page
      | <brand> |
    And the offline PROD edelivery deeplink login page is displayed with all the fields

    Examples: 
      | brand  |
      | PCP    |
    