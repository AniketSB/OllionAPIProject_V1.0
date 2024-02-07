@BadgesAPI
Feature: Returns result for stackExchange badges API

  @HappyPath
  Scenario Outline: Get badges recently awarded on the site.
    Given user call the get endpoint to get badges "<badge>" for 'recipients'
    Then user receive a 200 HTTP response
    Examples:
      | badge |
      | ALL   |
      | 263   |


  @UnhappyPath
  Scenario Outline: To verify get badges endpoint returns error response for incorrect badge id for recipients
    Given user call the get endpoint to get badges "<badge>" for 'recipients'
    Then user receive a 400 HTTP response
    Examples:
      | badge |
      | 101rf |
      |       |

  @UnhappyPath
  Scenario Outline: To verify get badges endpoint returns error response for incorrect badge id for recipients
    Given user call the get endpoint to get badges "<badge>" for 'recipients'
    Then user receive a 400 HTTP response
    And verify response parameters are available
      | error_message                  | error_id |
      | no method found with this name | 404      |
    Examples:
      | badge  |
      | 109 tr |