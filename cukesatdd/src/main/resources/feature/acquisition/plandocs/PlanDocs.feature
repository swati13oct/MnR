@acq_plandocs
Feature: 1.13 ACQ AARP- To test plandocs in AARP and UHC Site

  Scenario Outline: TID: <TID> - To test the plan documents are loading when zipcode county and plan are selected
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition Plan docs tool from home page
    When the user validates the header and the subcontent section
    And the user validates the label for zipcode and county and plan
    And the user enters zipcode and county and plan
      | zipcode | <zipcode> |
      | county  | <county>  |
      | plan    | <plan>    |
      | aepyear | <aepyear> |
    Then the user should be able to see the pdf
      | plan | <plan> |

    @acq_plandocs_AARP
    Examples: 
      | TID | site | zipcode | county             | plan                                               | aepyear |
      |   1 | AARP |   90002 | Los Angeles County | AARP Medicare Advantage SecureHorizons Focus (HMO) | no      |
      |   2 | AARP |   55344 | Hennepin County    | UnitedHealthcare Nursing Home Plan (PPO I-SNP)     | no      |
      |   3 | AARP |   80002 | Jefferson County   | AARP Medicare Advantage Patriot (HMO)              | no      |

    @acq_plandocs_UHC
    Examples: 
      | TID | site | zipcode | county             | plan                                               | aepyear |
      |   1 | UHC  |   90002 | Los Angeles County | AARP Medicare Advantage SecureHorizons Focus (HMO) | no      |
      |   2 | UHC  |   55344 | Hennepin County    | UnitedHealthcare Nursing Home Plan (PPO I-SNP)     | no      |

  Scenario Outline: TID: <TID> - To test the plan documents error message scenario
    Given the user is on medicare acquisition site landing page
      | Site | <site> |
    When I access the acquisition Plan docs tool from home page
    When the form fields are not selected and continue button is clicked
    When verifying error messages for Zip code and county and plan year
    When user enters zipcode with non-multi county and continue button is clicked and county and plan error message is visible
      | zipcode | <zipcode> |
    When user enters zipcode and county and continue button is clicked and plan error message is visible
      | zipcode | <zipcode> |
      | county  | <county>  |

    @acq_plandocs_AARP
    Examples: 
      | TID | site | zipcode | county           | plan                                  | aepyear |
      |   1 | AARP |   80002 | Jefferson County | AARP Medicare Advantage Patriot (HMO) | no      |

    @acq_plandocs_UHC
    Examples: 
      | TID | site | zipcode | county           | plan                                  | aepyear |
      |   1 | UHC  |   80002 | Jefferson County | AARP Medicare Advantage Patriot (HMO) | no      |
