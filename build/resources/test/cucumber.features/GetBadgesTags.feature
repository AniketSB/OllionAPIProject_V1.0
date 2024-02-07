@BadgesAPI
Feature: Returns result for stackExchange badges API for Tags

  @HappyPath
  Scenario Outline: Get the badges identified by tags.
    Given user call the get endpoint to get badges "<badge>" for 'tags'
    Then user receive a 200 HTTP response
    Examples:
      | badge |
      | ALL   |

  @UnhappyPath
  Scenario Outline: To verify get badges endpoint returns error response for incorrect tags
    Given user call the get endpoint to get badges "<badge>" for 'tags'
    Then user receive a 400 HTTP response
    Examples:
      | badge |
      | 111ee |
      | 269   |
      |       |

  @UnhappyPath
  Scenario Outline: To verify get badges endpoint returns correct error message for incorrect tags
    Given user call the get endpoint to get badges "<badge>" for 'tags'
    Then user receive a 400 HTTP response
    And verify response parameters are available
      | error_message                  | error_id |
      | no method found with this name | 404      |
    Examples:
      | badge |
      | 555yt |