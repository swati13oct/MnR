@medicareEducationUlayer
Feature:To test Our Plans Drop Down links in AARP site
Scenario:To verify links displayed in Our Plans Drop Down in AARP site
Given user is on the AARP Medicare Plans home page
When user accesses Medicare Education section AARP Medicareplans Site
And user clicks on LearnAboutMedicare link by hovering on Medicare Education of the AARP Medicare Plans home page
And user clicks on ExploreChangingPlans link by hovering on Medicare Education of the AARP Medicare Plans home page
And user clicks on PrepareForInitialEnrollment link by hovering on Medicare Education of the AARP Medicare Plans home page
And user clicks on DiscoverMoreResources link by hovering on Medicare Education of the AARP Medicare Plans home page
Then the user validates all links in the medicare education drop down of AARP site
