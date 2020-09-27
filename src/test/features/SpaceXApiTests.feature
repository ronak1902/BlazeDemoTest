Feature: Space X 3 Critical business scenarios
  @SpaceXTest @ApiTests
  Scenario: get and verify Space X Rocket Data
    Given call Space X Latest get Api
    When Api returns a correct response with status code 200
    Then verify rocket details from the space X Api

  @SpaceXTest @ApiTests
  Scenario: get and verify Space X Capsule Data
    Given call Space X Latest get Api
    When Api returns a correct response with status code 200
    Then verify capsule details from the space X Api

  @SpaceXTest @ApiTests
  Scenario: get and verify Space X launch pad and flight details
    Given call Space X Latest get Api
    When Api returns a correct response with status code 200
    Then verify launch pad Id and latest flight details

  @SpaceXTest @ApiTests
  Scenario: get and verify core details
    Given call Space X Latest get Api
    When Api returns a correct response with status code 200
    Then verify core details for Space X



