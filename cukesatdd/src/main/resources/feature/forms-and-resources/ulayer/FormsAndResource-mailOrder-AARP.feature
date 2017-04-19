@formsandresources-mailOrder
  Feature: Test AARP forms and resources mail order pdf link based on pharmacy
    Scenario Outline: Member should see mail order pdf link if preferred network is present
      Given registered member for forms and resources in AARP Site
          | <planType> |
      When the user view forms and resources in AARP site
      Then i should see the mail order pdf link

      Examples:

      | planType |
      | PDP      |