package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class StudentSteps {
    Response response;

        @Given("base url is set")
        public void base_url_is_set() {
            RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        }

        //Get all students
        @When("user sends GET request for all students")
        public void user_sends_get_request_for_all_students() {
            response = given()
                    .when()
                    .get("/posts")
                    .then().log().all().extract().response();
        }

        // get student by id
        @When("user sends GET request for student id {int}")
        public void user_sends_get_request_for_student_id(int studentId) {
            response = given()
                    .when()
                    .get("/posts" + studentId)
                    .then().log().all()
                    .extract().response();

        }

        //post create student
        @When("user sends POST request with {string} and course {string}")
        public void user_sends_post_request_with_and_course(String name, String course) {
            String body = """
                {
                  "name": "%s",
                  "course": "%s"
                }
                """.formatted(name, course);

            given().header("content-type", "application/json").body(body)
                    .when().post("/posts")
                    .then().log().all()
                    .body("name", equalTo(name))
                    .extract().response();
        }

        @When("user sends PUT request for student id {int} with name {string} and course {string}")
        public void update_student(Integer studentId, String name, String course) {

            String body = """
                {
                  "id": %d,
                  "name": "%s",
                  "course": "%s"
                }
                """.formatted(studentId, name, course);

            response =
                    given()
                            .header("Content-Type", "application/json")
                            .body(body)
                            .when()
                            .put("/posts/" + studentId)
                            .then()
                            .log().all()
                            .body("name", equalTo(name))
                            .extract().response();
        }


        @When("user sends DELETE request for student id1")
        public void user_sends_delete_request_for_student_id1() {
            response = given().when().delete("/posts/1")
                    .then().log().all()
                    .extract().response();

        }

        @Then("status code should be {int}")
        public void status_code_should_be(int code) {
            response.then().statusCode(code);

        }


}
