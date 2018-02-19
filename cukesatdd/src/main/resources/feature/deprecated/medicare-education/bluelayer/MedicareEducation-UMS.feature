@medicareEducation
Feature:To test Our Plans Drop Down links in UMS site
Scenario:To verify links displayed in Our Plans Drop Down in UMS site
Given user is on the UHC Medicare Solutions home page
When user accesses Medicare Education section UHC Medicare Solutions Site
And user clicks on LearnAboutMedicare link by hovering on Medicare Education of the UHC Medicare Solutions home page
And user clicks on ExploreChangingPlans link by hovering on Medicare Education of the UHC Medicare Solutions home page
And user clicks on PrepareForInitialEnrollment link by hovering on Medicare Education of the UHC Medicare Solutions home page
And user clicks on DiscoverMoreResources link by hovering on Medicare Education of the UHC Medicare Solutions home page
Then the user validates all links in the medicare education drop down of UMS site
