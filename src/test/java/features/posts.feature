Feature: Posts API Tests

  Background:
    * url baseUrl

  Scenario: Get all posts
    Given path '/posts'
    When method GET
    Then status 200
    And match response[0].userId == '#number'
    And match response[0].title == '#string'

  Scenario: Get post by ID
    Given path '/posts/1'
    When method GET
    Then status 200
    And match response.id == 1
    And match response.userId == 1
    And match response.title == '#string'

  Scenario: Create a new post
    Given path '/posts'
    And request { userId: 1, title: 'Test Post', body: 'This is a test post' }
    When method POST
    Then status 201
    And match response.title == 'Test Post'
    And match response.id == '#number'
