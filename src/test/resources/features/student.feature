Feature: Students API automation

  Scenario Outline: Get all students
    Given base url is set
    When user sends GET request for all students
    Then status code should be <statuscode>

    Examples:
    | statuscode|
    |   200     |


    Scenario Outline: Get Student by id
      Given base url is set
      When user sends GET request for student id <studentId>
      Then status code should be <statuscode>

      Examples:
      |studentId| statuscode|
      |2        | 200  |


      Scenario Outline: Create Student
        Given base url is set
        When user sends POST request with "<name>" and course "<course>"
        Then status code should be <statuscode>

        Examples:
        |name | course | statuscode|
        |Rahul|computer sceience | 201|


        Scenario Outline: update Student
          Given base url is set
          When user sends PUT request for student id <studentId> with name "<name>" and course "<course>"
          Then status code should be <statuscode>

          Examples:
          |studentId|name |course |statuscode|
          | 1       |rahul      |IT        |200    |


          Scenario Outline: Delete Student
            Given base url is set
            When user sends DELETE request for student id<studentId>
            Then status code should be <statuscode>

            Examples:
            |studentId|statuscode|
            |1        |200       |