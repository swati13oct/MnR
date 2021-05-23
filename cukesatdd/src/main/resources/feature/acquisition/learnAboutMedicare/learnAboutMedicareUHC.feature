#Author: chaurasia_kamal@optum.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
@gladiators @acquisitionRegression @learnAboutMedicare
Feature: 1.01-Acq-To test learn about medicare flow in UHC site

  @learnAboutMedicare1 @regressionMember @uhc
  Scenario Outline: Verify medicare links, redirection to respective pages, page/browser back button,state selection, plan search on u layer
    Given user is on uhcmedicaresolutions site landing page
    And verifies header, links under Learn About Medicare dropList on uhc site
    When user clicks on learn about medicare link on uhc site
    And verifies URL, title of pages navigable from menu on uhc site
    When user clicks on learn about medicare link on uhc site
    #    And verifies navigation to learn about medicare homePage on uhc site
    #    And verifies accessibility of links using tabkey, back button on every page navigable from homepage on uhc site
    And app navigates to medicare eligibility page on uhc site
    And verifies default value of state drop down on uhc site
    And verifies presence of video, sideLinks, back button and next button on medicare eligibility page on uhc site
    And verifies links under Types of UnitedHealthcare Insurance Company Plans on uhc site
    And then user selects Minnesota from the dropDown on uhc site
      | State | Minnesota |
    And verifies links under Types of UnitedHealthcare Insurance Company Plans for minnesota on uhc site
    And then user selects Alabama from the dropDown on uhc site
      | State | Alabama |
    And verifies links under Types of UnitedHealthcare Insurance Company Plans for Alabama on uhc site
    And verifies plan search with a valid zipcode on uhc site
      | ZipCode | <zipcode> |
      | Option  | <option>  |
    And verifies Shop For a Plan Homepage on uhc site
    And views plan of a particular type on uhc site
      | PlanType | <planType> |

    ##MA MS SNP PDP
    #    And verifies plantype on uhc site
    #   |PlanType|<planType>|
    #TestCaseId:15524,15525,15526
    Examples: 
      | zipcode | planType | option |
      |   90002 | MA       | ME     |

  @learnAboutMedicare2 @regressionMember @uhc
  Scenario Outline: Verify medicare advantage flow from learn about medicare menu
    Given user is on uhcmedicaresolutions site landing page
    When user clicks on learn about medicare link on uhc site
    And user selects a plan from the learn about medicare dropList on uhc site
      | PlanType | <planType> |
    And clicks on plans available option on uhc site
      | PlanType | <planType> |

    ##MA MS SNP PDP
    #TestCaseId:15524,15525,15526
    Examples: 
      | zipcode | planType |
      |   90002 | MA       |

  @learnAboutMedicare3 @regressionMember @uhc
  Scenario Outline: Verify precscription drug plan flow from learn about medicare menu
    Given user is on uhcmedicaresolutions site landing page
    When user clicks on learn about medicare link on uhc site
    And user selects a plan from the learn about medicare dropList on uhc site
      | PlanType | <planType> |
    And clicks on plans available option on uhc site
      | PlanType | <planType> |

    #TestCaseId:15524,15525,15526
    Examples: 
      | zipcode | planType |
      |   90002 | PDP      |

  @learnAboutMedicare4 @regressionMember @uhc
  Scenario Outline: Verify medicare advantage flow from learn about medicare homePage
    Given user is on uhcmedicaresolutions site landing page
    When user clicks on learn about medicare link on uhc site
    And user selects a plan from the learn about medicare homePage on uhc site
      | PlanType | <planType> |
    And verifies plan search with a valid zipcode on uhc site
      | ZipCode  | <zipcode>  |
      | PlanType | <planType> |
    And verifies Shop For a Plan Homepage on uhc site
    And verifies plantype on uhc site
      | PlanType | <planType> |

    #TestCaseId:15524,15525,15526
    Examples: 
      | zipcode | planType |
      |   90002 | MA       |

  @learnAboutMedicare5 @regressionMember @uhc
  Scenario Outline: Verify precscription drug plan flow from learn about medicare homePage
    Given user is on uhcmedicaresolutions site landing page
    When user clicks on learn about medicare link on uhc site
    And user selects a plan from the learn about medicare homePage on uhc site
      | PlanType | <planType> |
    And verifies plan search with a valid zipcode on uhc site
      | ZipCode  | <zipcode>  |
      | PlanType | <planType> |
    And verifies Shop For a Plan Homepage on uhc site
    And verifies plantype on uhc site
      | PlanType | <planType> |

    #TestCaseId:15524,15525,15526
    Examples: 
      | zipcode | planType |
      |   90002 | PDP      |
