#@dce_redesign_zipcode_planyear_capture_AEP_Mobile
#Feature: 1.10.1 DCE-REDESIGN AARP - To test ZipCode and Plan Year capture page in New DCE flow during AEP
#
  #@DCE_ZipCodePlanYear_AEP_Mobile @test
  #Scenario Outline:  Test to verify the new DCE redesign page displayed for ZipCode and Plan year capture page for AEP on Mobile
    #Given the user is on AARP medicare acquisition site landing page in mobile
    #When the user navigates to following AARP medicare acquisition site page in mobile
      #| PageName | <pageName> |
      #| PagePath | <path>     |
    #Then the user validates Get Started Page in mobile
    #When the user clicks on Add drugs button in mobile
    #Then user should be navigated to zipcode and plan year capture page for NonAEP in mobile
#		And plan year dropdown should be not displayed during NonAEP in mobile
    #Examples: 
      #| path                     | pageName                   |
      #| drug-cost-estimator.html | DCE Redesign - Get Started |