import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.is;


public class RegresTests extends TestBase {

    @Test
    void getUserTest() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .when()
                .get("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("data.first_name", is("Janet"), "data.id", is(2));
    }

    @Test
    void createUserTest() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .body("{\"name\": \"morpheus\",\"job\": \"leader\"}")
                .contentType(JSON)
                .when()
                .post("/users")
                .then()
                .log().status()
                .log().body()
                .statusCode(201)
                .body("name", is("morpheus"), "job", is("leader"));


    }

    @Test
    void updateUserTest() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .body("{\"name\": \"morpheus\",\"job\": \"zion resident\"}")
                .contentType(JSON)
                .when()
                .put("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(200)
                .body("name", is("morpheus"), "job", is("zion resident"));


    }

    @Test
    void deleteUserTest() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .when()
                .delete("/users/2")
                .then()
                .log().status()
                .log().body()
                .statusCode(204);


    }

    @Test
    void UnknownResourseTest() {
        given()
                .log().uri()
                .log().method()
                .log().body()
                .when()
                .get("/unknown/23")
                .then()
                .log().status()
                .log().body()
                .statusCode(404)
                .body(is("{}"));


    }
}
