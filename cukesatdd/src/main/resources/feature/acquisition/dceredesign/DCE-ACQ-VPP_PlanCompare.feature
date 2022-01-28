@dce @dce_Redesign_VPP_Compare
Feature: 1.10.3 DCE-Redesign-VPP_PlanCompare - To test DCE - VPP Plan Compare Integration

  @dce_Redesign_VPP_PlanCompare
  Scenario Outline: 1.10.3.1 To test the DCE Redesignflow for PlanType :  <plantype> from vpp Plan Compare
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And the user selects plan year
      | Plan Year | <planyear> |
    And I select "<plantype>" plans to compare and click on compare plan link
    And I access the DCE Redesign from Plan compare page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user clicks on return to compare link on build drug list page to returns to plan compare
    Then the user validates drug is displayed on the plan compare page
      | DrugName | <drug1> |

    @dce_Redesign_VPP_PlanCompare_AARP @regressionAARP 
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | planname                                           |
      | AARP |   90210 | MAPD     | future   | none   | no              | febuxostat | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @dce_Redesign_VPP_PlanCompare_UHC @regressionUHC @prodRegression @vbfGate
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                                           |
      | UHC  |   90210 | MAPD     | future   | none   | no              | febuxostat | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @dce_Redesign_VPP_PlanCompare_AARP @regressionAARP @vbfGate
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      | AARP |   80002 | PDP      | future   | Adams County | yes             | febuxostat | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |

    @dce_Redesign_VPP_PlanCompare_UHC @regressionUHC
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1     | drug2                | drug3      | drug4         | drug5            | drug6   | planname                        |
      | UHC  |   80002 | PDP      | future   | Adams County | yes             | febuxostat | diclofenac potassium | febuxostat | buprenorphine | fentanyl citrate | Lipitor | AARP MedicareRx Walgreens (PDP) |

  ############ DCE Plan Compare Regression scenarios  ##############
  ############ - Add Drug, edit Drug, View Drug Info Modal - DCE - Return
  ############ - Validate Drug list on Plan Compare and Drug Info Modal.
  ############ - Compare drug costs View Drug info and DCE details page
  @dce_Redesign_VPP_PlanCompare1
  Scenario Outline: 1.10.3.1 To test the DCE Redesignflow for PlanType :  <plantype> from vpp Plan Compare from vpp Plan Compare View Drug Info Modal
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And I select "<plantype>" plans to compare and click on compare plan link
    And I access the DCE Redesign from Plan compare page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user clicks on return to compare link on build drug list page to returns to plan compare
    Then the user validates all added Drugs on Plan Compare
    Then the user clicks on View Drug Information link for the following Plan and lands on DCE details
      | PlanName | <planname> |
    Then the user validates planName matches plan Name in VPP
    Then the user clicks on Back to Compare link and validates Plan Compare page, Drug Info Modal
    Then the user closes the Drug Info Modal on Plan Compare page
    Then the user clicks on Edit Drug link and validates user lands on DCE Build Drug List Page
    Then the user deletes the following drug from Drug list
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug3> |
    Then the user clicks on return to compare link on build drug list page to returns to plan compare
    Then the user validates all added Drugs on Plan Compare
    Then the user clicks on View Drug Information link for the following Plan and lands on DCE details
      | PlanName | <planname> |
    Then the user validates planName matches plan Name in VPP
    Then the user Validates Drug you pay on DCE details page to Compare page Drug Info Modal
    Then the user clicks on Back to Compare link and validates Plan Compare page, Drug Info Modal

    @dce_Redesign_VPP_PlanCompare1_AARP @regressionAARP
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1  | drug2                | drug3   | planname                                           |
      | AARP |   90210 | MAPD     | future   | none   | no              | Ativan | diclofenac potassium | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @dce_Redesign_VPP_PlanCompare1_UHC @regressionUHC
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | drug2                | drug3   | planname                                           |
      | UHC  |   90210 | MAPD     | future   | none   | no              | febuxostat | diclofenac potassium | Lipitor | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @dce_Redesign_VPP_PlanCompare1_AARP @regressionAARP
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1     | drug2                | drug3   | planname                        |
      | AARP |   80002 | PDP      | future   | Adams County | yes             | febuxostat | diclofenac potassium | Lipitor | AARP MedicareRx Walgreens (PDP) |

    @dce_Redesign_VPP_PlanCompare1_UHC @regressionUHC @prodRegression
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1  | drug2                | drug3   | planname                        |
      | UHC  |   80002 | PDP      | future   | Adams County | yes             | Ativan | diclofenac potassium | Lipitor | AARP MedicareRx Walgreens (PDP) |

  ############ END - DCE Plan Compare Regression scenarios  ##############
  @dce_Redesign_VPP_PlanCompare3
  Scenario Outline: 1.10.3.1 To test the DCE Redesignflow for PlanType :  <plantype> from vpp Plan Compare View Drug Info Modal
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When the user performs plan search using following information
      | Zip Code        | <zipcode>         |
      | County Name     | <county>          |
      | Is Multi County | <isMultutiCounty> |
    And the user views the plans of the below plan type
      | Plan Type | <plantype> |
    And I select "<plantype>" plans to compare and click on compare plan link
    And I access the DCE Redesign from Plan compare page
    Then the user clicks on Build Drug List to navigate to Build Drug List Page
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug1> |
    Then the user searches and adds the following Drug to Drug List
      | DrugName | <drug2> |
    Then the user clicks on return to compare link on build drug list page to returns to plan compare
    Then the user validates all added Drugs on Plan Compare
    Then the user clicks on View Drug Information link for the following Plan and lands on DCE details
      | PlanName | <planname> |
    Then the user validates planName matches plan Name in VPP
    Then the user clicks on Back to Compare link and validates Plan Compare page, Drug Info Modal

    @dce_Redesign_VPP_PlanCompare3_AARP @regressionAARP @prodRegression
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | drug2                | planname                                           |
      | AARP |   90210 | MAPD     | future   | none   | no              | febuxostat | diclofenac potassium | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @dce_Redesign_VPP_PlanCompare3_UHC @regressionUHC
    Examples: 
      | site | zipcode | plantype | planyear | county | isMultutiCounty | drug1     | drug2                | planname                                           |
      | UHC  |   90210 | MAPD     | future   | none   | no              | febuxostat | diclofenac potassium | AARP Medicare Advantage SecureHorizons Focus (HMO) |

    @dce_Redesign_VPP_PlanCompare3_AARP @regressionAARP
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1     | drug2                | planname                        |
      | AARP |   80002 | PDP      | future   | Adams County | yes             | febuxostat | diclofenac potassium | AARP MedicareRx Walgreens (PDP) |

    @dce_Redesign_VPP_PlanCompare3_UHC @regressionUHC
    Examples: 
      | site | zipcode | plantype | planyear | county       | isMultutiCounty | drug1     | drug2                | planname                        |
      | UHC  |   80002 | PDP      | future   | Adams County | yes             | febuxostat | diclofenac potassium | AARP MedicareRx Walgreens (PDP) |
