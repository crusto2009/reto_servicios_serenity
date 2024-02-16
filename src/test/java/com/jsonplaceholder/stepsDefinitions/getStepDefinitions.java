package com.jsonplaceholder.stepsDefinitions;


import com.jsonplaceholder.models.Todos.ResponseArrayTodos;
import com.jsonplaceholder.models.Todos.ResponseModelTodos;
import com.jsonplaceholder.questions.ResponseServerCode;
import com.jsonplaceholder.task.CommentsTask.GetCommentTask;
import com.jsonplaceholder.task.TodosTask.GetServiceTask;
import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;

public class getStepDefinitions {
    Actor supervisor= Actor.named("supervisor")
            .whoCan(CallAnApi.at("https://jsonplaceholder.typicode.com/"));

    @Cuando("accedo al titulo de publicacion atraves del endpoint")
    public void accedoAlTituloDePublicacionAtravesDelEndpoint() {
        supervisor.attemptsTo(
                GetServiceTask.on()
        );

    }
    @Entonces("valido que el texto del titulo no este vacio")
    public void validoQueElTextoDelTituloNoEsteVacio() {
        supervisor.should(
                seeThat(
                        ResponseServerCode.was(),
                        equalTo(200)
                )
        );
    }

}
