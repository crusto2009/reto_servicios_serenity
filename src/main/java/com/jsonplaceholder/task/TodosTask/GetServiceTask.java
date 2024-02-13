package com.jsonplaceholder.task.TodosTask;

import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetServiceTask implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Get.resource("todos").with(
                        req -> req
                                .contentType(ContentType.JSON)
                                .header("Accept","*/*")
                                .log().all()
                )
        );
    }


    public static GetServiceTask on(){
        return instrumented(GetServiceTask.class);
    }
}
