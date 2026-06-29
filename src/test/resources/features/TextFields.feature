Feature: TestKru Text Fields validation

  Scenario: Validate all text fields on TestKru page
    Given I am on the TestKru text fields page
    When I enter first name as "MEOW"
    And I enter last name as "Meow"
    And I enter text area value as "Meow meow bhow bhow"
    Then Uneditable field should contain value "Codekru"
    And Disabled text field should be disabled
    And Invisible text field should not be displayed
    And Pre-filled text field should be displayed
    And Pre-filled text field should contain value "Codekru"
    Then I close the browser