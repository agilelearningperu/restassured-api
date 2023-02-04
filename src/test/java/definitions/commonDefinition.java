package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import steps.commonStep;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class commonDefinition {
    commonStep common;
    public static Response response;
    public Map<String,Object> map;
    public File file;
    public String token;

    public commonDefinition() {
        common = new commonStep();
        map = new HashMap<String, Object>();
    }

    @Dado("^que se envia la petición (.*) al path (.*)$")
    public void queSeEnviaLaPeticionGETAlPathBooking(String method, String path) throws IOException {
        switch(method){
            case "GET":{
                response = common.Request().get(path);
                break;
            }
            case "POST":{
                response = common.Request().headers(map).body(file).post(path);
                break;
            }
            case "PUT":{
                response = common.Request().headers(map).body(file).put(path);
                break;
            }
            case "PATCH":{
                response = common.Request().headers(map).body(file).patch(path);
                break;
            }
            case "DELETE":{
                response = common.Request().headers(map).body(file).delete(path);
                break;
            }
        }
    }

    @Cuando("se envia la petición recibo un código {int}")
    public void seEnviaLaPeticionReciboUnCodigo(int codigo) {
        response.then().statusCode(codigo).log().all();
    }

    @Entonces("se valida el esquema de la respuesta con el archivo {string}")
    public void seValidaElEsquemaDeLaRespuestaConElArchivoGetbookingSchema(String archivo) {
        assertThat(response.getBody().asString(), matchesJsonSchemaInClasspath("json-schema/"+archivo+".json"));
    }

    @Dado("que se envia headers")
    public void queSeEnviaHeaders(DataTable header) {
        List<Map<String, String>> data = header.asMaps(String.class, String.class);
        for (int i=0; i < data.size(); i++){
            map.put(data.get(i).get("atributo"), data.get(i).get("valor"));
        }
    }

    @Y("que se envia un body {string}")
    public void queSeEnviaUnBodyToken(String archivo) {
        file = new File("src/test/resources/json-data/"+archivo+".json");
    }

    @Y("guardar el token")
    public void guardarElToken() {
        ResponseBody body = response;
        JsonPath json = new JsonPath(body.asString()).setRootPath("");
        token = json.getString("token");
        System.out.println(token);
    }

    @Y("agregar la sesión al header")
    public void agregarLaSesiónAlHeader() {
        map.put("Cookie", "token="+token);
    }
}
