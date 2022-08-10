import com.everis.base.ApiGameService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.eclipse.jetty.websocket.api.StatusCode;

public class ApiGameSD {

    @Steps
    public ApiGameService apigame;

    @Given("que la aplicacion esta operativa")
    public void queLaAplicacionEstaOperativa() {
    }

    @When("obtiene la lista: {int} de juegos suscritos")
    public void obtieneLaListaDeJuegosSuscritos(int i) {
        apigame.listUser(i);

    }

    @Then("valida que la respuesta es {int}")
    public void validaQueLaRespuestaEs(int i) {
        apigame.validateStatusCode(i);


    }


    @When("obtiene al juego: {int} suscrito")
    public void obtieneAlJuegoSuscrito(String genre) {
        apigame.getUser(genre);
    }

   @Then("valida la respuesta es {int}")
    public void validaLaRespuestaEs(int i) {
        apigame.validateStatusCode(i);

    }
}
