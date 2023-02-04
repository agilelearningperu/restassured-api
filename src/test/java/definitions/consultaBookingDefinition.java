package definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.es.Y;
import io.restassured.path.json.JsonPath;
import io.restassured.response.ResponseBody;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

import static definitions.commonDefinition.response;

public class consultaBookingDefinition {

    @Y("validar valores de la respuesta de booking")
    public void validarValoresDeLaRespuestaDeBooking(DataTable booking) {
        ResponseBody body = response;
        JsonPath json = new JsonPath(body.asString()).setRootPath("");
        List<Map<String, String>> data = booking.asMaps(String.class, String.class);
        for (int i=0; i < data.size(); i++){
            Assert.assertEquals(data.get(i).get("nombre"), json.getString("firstname"));
        }
    }
}
