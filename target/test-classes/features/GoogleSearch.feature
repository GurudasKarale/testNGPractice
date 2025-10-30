Feature: Google Search

  Scenario: Search for Cucumber
    Given I open Google
    When I search for "Cucumber BDD"
    Then I should see results

  Scenario: Search for Selenium
    Given I open Google
    When I search for "Selenium WebDriver"
    Then I should see results