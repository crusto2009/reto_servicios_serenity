package com.jsonplaceholder.task.CommentsTask;

import com.jsonplaceholder.task.TodosTask.GetServiceTask;
import com.jsonplaceholder.utils.DatosExcelListas;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetCommentTask  implements Task {

    private static ArrayList<Map<String,String>> LeerExcelInformacion = new ArrayList<>();

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            LeerExcelInformacion = DatosExcelListas.readExcel("Datos.xlsx","postId");

            actor.attemptsTo(
                    Get.resource("/comments").with(
                            req -> req
                                    .queryParam(LeerExcelInformacion.get(0).get("Param"),LeerExcelInformacion.get(0).get("Id"))
                                    .log().all()

                    )
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static GetCommentTask on(){
        return instrumented(GetCommentTask.class);
    }
}
