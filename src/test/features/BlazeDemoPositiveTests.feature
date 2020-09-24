Feature: Blaze Demo site positive scenarios
  @BlazeTest
  Scenario: Register as a new user and login in Blaze and book tickets
    Given A new User is Registered
      |      Name      | Company |         Email                | Password  |
      |      Ron Chan  | Blaze   | ronak.chandwani@gmail.com    | blaze1234 |
    When user chooses departure city
    And user chooses destination city
    And click find flights button
    And user clicks cheapest available flight
    And verify purchase details
    And enter passenger details and click on purchase flight
    Then verify all customer details on confirmation page

  @BlazeTest
  Scenario: Login with existing user and book tickets
    Given Login with existing User
     |         Email                | Password  |
     | ronak.chandwani@gmail.com    | blaze1234 |
    When user chooses departure city
    And user chooses destination city
    And click find flights button
    And user clicks cheapest available flight
    And verify purchase details
    And enter passenger details and click on purchase flight
    Then verify all customer details on confirmation page


  @BlazeTest
  Scenario: continue as guest user and book tickets
    Given blazedemo site is opened in the browser
    When user chooses departure city
    And user chooses destination city
    And click find flights button
    And user clicks cheapest available flight
    And verify purchase details
    And enter passenger details and click on purchase flight
    Then verify all customer details on confirmation page
