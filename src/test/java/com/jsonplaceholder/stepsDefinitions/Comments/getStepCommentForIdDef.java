package com.jsonplaceholder.stepsDefinitions.Comments;

import com.jsonplaceholder.task.CommentsTask.GetCommentTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.thucydides.core.util.EnvironmentVariables;

import static com.jsonplaceholder.constains.Constains.baseUrl;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.CoreMatchers.hasItems;


public class getStepCommentForIdDef {

    private String restBaseUrl;
    private EnvironmentVariables environmentVariables;
    private Actor cristian;

    @Before
    public void setUpBaseUrl(){
        restBaseUrl= environmentVariables.optionalProperty("restapi.baseurl")
                .orElse(baseUrl);


        cristian = Actor.named("Usuario Cristian").whoCan(
                CallAnApi.at(restBaseUrl)
        );
    }

    @Cuando("se realiza una solicitud GET al servicio comentarios  con un postId")
    public void seRealizaUnaSolicitudGETAlServicioComentariosConUnPostId() {
        cristian.attemptsTo(
                GetCommentTask.on()
        );
    }

    @Entonces("se debe recibir una respuesta con la información de todos los comentarios relacionados con el postId")
    public void seDebeRecibirUnaRespuestaConLaInformaciónDeTodosLosComentariosRelacionadosConElPostId() {
        cristian.should(
                seeThatResponse(
                        "Retorna el nombre todos los comentarios segun el postId",
                        response -> response.body("name",
                                hasItems("modi ut eos dolores illum nam dolor"
                                ))
                )
        );
    }
}
