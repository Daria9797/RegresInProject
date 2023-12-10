import models.*;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static specs.RequestSpec.requestGetSpec;
import static specs.RequestSpec.requestPostSpec;
import static specs.ResponseSpec.responseSpec;



public class RegresTests extends TestBase {

    @Test
    void getUserTest() {
        GetUserResponseModel response= given(requestGetSpec)
                .when()
                .get("/users/2")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().as(GetUserResponseModel.class);
        assertEquals("Janet",response.getData().getFirstName());
        assertEquals(2,response.getData().getId());

    }

    @Test
    void createUserTest() {
        CreateUserRequestModel request=new CreateUserRequestModel();
        request.setName("morpheus");
        request.setJob("leader");
        CreateUserResponseModel response=
        given(requestPostSpec)
                .body(request)
                .when()
                .post("/users")
                .then()
                .spec(responseSpec)
                .statusCode(201)
                .extract().as(CreateUserResponseModel.class);
        assertEquals("morpheus",response.getName());
        assertEquals("leader",response.getJob());



    }

    @Test
    void updateUserTest() {
        UpdateUserRequestModel request=new UpdateUserRequestModel();
        request.setName("morpheus");
        request.setJob("zion resident");
        UpdateUserResponseModel response=
        given(requestPostSpec)
                .body(request)
                .when()
                .put("/users/2")
                .then()
                .spec(responseSpec)
                .statusCode(200)
                .extract().as(UpdateUserResponseModel.class);
        assertEquals("morpheus",response.getName());
        assertEquals("zion resident",response.getJob());



    }

    @Test
    void deleteUserTest() {
        given(requestGetSpec)
                .when()
                .delete("/users/2")
                .then()
                .spec(responseSpec)
                .statusCode(204);


    }

    @Test
    void unknownResourseTest() {
        given(requestGetSpec)
                .when()
                .get("/unknown/23")
                .then()
                .spec(responseSpec)
                .statusCode(404);


    }
}
