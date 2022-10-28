package in.reqres;

import in.reqres.model.ResponseModel;
import in.reqres.specs.Specs;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.Specs.negativeResponseSpec;
import static in.reqres.specs.Specs.positiveResponseSpec;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class MainTests extends BaseTest {


    @Test
    public void registrationPositiveTest() {
        ResponseModel response = given ()
                .spec (Specs.registrationRequestSpec)
                .body (body)
                .when ()
                .post ()
                .then ()
                .spec (positiveResponseSpec)
                .extract ()
                .as (ResponseModel.class);

        assertThat (response.getToken ()).isEqualTo ("QpwL5tke4Pnpja7X4");
    }

    @Test
    public void registrationNegativeTest() {
        given ()
                .spec (Specs.registrationRequestSpec)
                .body (bodyWrong)
                .when ()
                .post ()
                .then ()
                .spec (negativeResponseSpec)
                .extract ()
                .as (ResponseModel.class);
    }

    @Test
    public void loginPositiveTest() {
        ResponseModel response = given ()
                .spec (Specs.loginRequestSpec)
                .body (body)
                .when ()
                .post ()
                .then ()
                .spec (positiveResponseSpec)
                .extract ()
                .as (ResponseModel.class);

        assertThat (response.getToken ()).isEqualTo ("QpwL5tke4Pnpja7X4");
    }


    @Test
    public void loginNegativeTest() {
        given ()
                .spec (Specs.loginRequestSpec)
                .body (bodyWrong)
                .when ()
                .post ()
                .then ()
                .spec (negativeResponseSpec)
                .extract ()
                .as (ResponseModel.class);
    }
}
