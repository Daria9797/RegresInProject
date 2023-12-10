package specs;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.http.ContentType.JSON;

public class RequestSpec {

    public static RequestSpecification requestGetSpec= with()

            .log().uri()
            .log().method()
            .log().body();

    public static RequestSpecification requestPostSpec= with()

            .log().uri()
            .log().method()
            .log().body()
            .contentType(JSON);


}
