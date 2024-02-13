package com.jsonplaceholder.questions.TodosQuestion;

import com.jsonplaceholder.models.Todos.ResponseModelTodos;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;

public class ResponseGetTodos implements Question<Object> {
    @Override
    public Object answeredBy(Actor actor) {
        ArrayList<ResponseModelTodos> todos =new ArrayList<ResponseModelTodos>();
        return SerenityRest.lastResponse().as(todos.getClass());
    }

    public static ResponseGetTodos was(){
        return new ResponseGetTodos();
    }
}
