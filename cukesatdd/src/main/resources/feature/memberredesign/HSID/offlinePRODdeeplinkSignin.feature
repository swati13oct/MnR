@regressionMemberPROD @OfflinePRODVanityURLdeeplinkSignin
Feature: To test URL formation on offline PROD Signin from various Deeplinks on offlinePROD

  @regressionMemberPROD @codeWarriors @F477221
  Scenario Outline: Verify members lands on the offline PROD virtual visit page after signing in from virtual visit Vanity URL.
    Given member lands on the offline PROD virtual visit deeplink page
      | <brand> |
    And the offline PROD virtual visit deeplink login page is displayed with all the fields

    Examples: 
      | brand  |
      | PCP    |
      | Medica |
      | AARP   |
      | UHC    |

  #offline.myaarpmedicare.com/virtualvisits
  #offline.myuhcmedicare.com/virtualvisits
  #offline.mypcpmedicare.com/virtualvisits
  #offline.mymedicamedicare.com/virtualvisits
  
 #F514599 preadtors  
  @codeWarriors @F477221 @F514599predators
  Scenario Outline: Verify members lands on the offline PROD solutran deeplink HWP Vanity URL.
    Given member lands on the offline PROD HWP deeplink page
      | <brand> |
    And the offline PROD HWP deeplink login page is displayed with all the fields

    Examples: 
      | brand  |
      | PCP    |
      | Medica |
      | AARP   |
      | UHC    |
      
#offline.myaarpmedicare.com/hwp
#offline.myuhcmedicare.com/hwp
#offline.mypcpmedicare.com/hwp
#offline.mymedicamedicare.com/hwp

@regressionMemberPROD @codeWarriors @F477221
 Scenario Outline: Verify SHIP members lands on the offline PROD health & wellness deeplink from Vanity URL.
    Given member lands on the offline PROD health & wellness deeplink page
      | <brand> |
    And the offline PROD health & wellness deeplink login page is displayed with all the fields

    Examples: 
      | brand  |
      | SHIP   |
       
     #offline.myaarpmedicare.com/Extras  
     
         @regressionMemberPROD @codeWarriors @F392073
  Scenario Outline: Verify Member lands on the documents page after signing in from edelivery deeplink.
   Given member lands on the PROD /offline edelivery deeplink page
      | <brand> |
    And the offline PROD edelivery deeplink login page is displayed with all the fields

    Examples: 
      | brand  |
      | PCP    |
    