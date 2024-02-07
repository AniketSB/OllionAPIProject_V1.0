@BadgesAPI
Feature: Returns result for stackExchange badges API

  @HappyPath
  Scenario Outline: Get the badges identified by ids.
    Given user call the get endpoint to get badges "<badge>" for 'id'
    Then user receive a 200 HTTP response
    Examples:
      | badge |
      | ALL   |
      | 262   |
      |       |

  @UnhappyPath
  Scenario Outline: To verify get badges endpoint returns error response for incorrect badge id
    Given user call the get endpoint to get badges "<badge>" for 'id'
    Then user receive a 400 HTTP response
    Examples:
      | badge |
      | 605tw |

  @UnhappyPath
  Scenario Outline: To verify get badges endpoint returns correct error message for incorrect badge id
    Given user call the get endpoint to get badges "<badge>" for 'id'
    Then user receive a 400 HTTP response
    And verify response parameters are available
      | error_message                  | error_id |
      | no method found with this name | 404      |
    Examples:
      | badge |
      | 635tw |