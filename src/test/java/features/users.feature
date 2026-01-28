Feature: User API Tests

  Background:
    * url baseUrl

  Scenario: Get all users
    Given path '/users'
    When method GET
    Then status 200
    And match response[0].id == 1
    And match response[0].name == '#string'
    And match response[0].email == '#string'

  Scenario: Get user by ID
    Given path '/users/1'
    When method GET
    Then status 200
    And match response.id == 1
    And match response.name == 'Leanne Graham'
    And match response.email == 'Sincere@april.biz'

  Scenario: Create a new user
    Given path '/users'
    And request { name: 'John Doe', username: 'johndoe', email: 'john@example.com' }
    When method POST
    Then status 201
    And match response.name == 'John Doe'
    And match response.id == '#number'

  Scenario: Update user
    Given path '/users/1'
    And request { id: 1, name: 'Updated Name', username: 'updated', email: 'updated@example.com' }
    When method PUT
    Then status 200
    And match response.name == 'Updated Name'

  Scenario: Delete user
    Given path '/users/1'
    When method DELETE
    Then status 200
