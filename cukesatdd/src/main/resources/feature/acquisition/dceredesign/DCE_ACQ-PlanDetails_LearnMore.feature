@DCE
Feature: 1.10.2 ACQ-DCERedesign-VPP_PlanDetails AARP - To test DCE - VPP Plan Details in AARP site

  @DCE_Redesign_VPP_PlanDetailsLearnMore
  Scenario Outline: To verify DCE REDESIGN Details Page for Learn More from <site> home page
    #    Given the user is on AARP medicare acquisition site landing page
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition DCE Redesign from home page
    Then the user validates Get Started Page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user edits supply length to three months for following drug
      | EditDrug | <drug1> |
    #    Then the user validates all added drugs in DrugList
    Then the user clicks on Review Drug Costs to Land on Zip Entry Page
    When user enters valid zipcode and county
      | ZipCode | <zipCode> |
    And user clicks on continue button in Zip Entry Page
    Then the user selects View Drug details for following plantype and PlanName
      | Plan Type | <planType> |
      | Plan Name | <planName> |
    Then the user validates planName matches plan Name in VPP
    Then the user Clicks button to VPP Plan Details Page from Drug Details Page
    Then the user clicks PrescriptionBenifit Tab on Plan Details Page
    Then the user clicks Learn More button on Prescription Drug Costs Tab on Plan Details Page
    Then the user validates planName on LearnMore page matches plan Name in VPP

    @regressionAARP
    Examples: 
      | drug1      | drug2   | zipCode | planType | planName                                      | site | DefaultSelected | MailPharSelected |
      | vigabatrin | Lipitor |   78006 | SNP      | UnitedHealthcare Chronic Complete (HMO C-SNP) | AARP | Standard Retail | Standard Mail    |
