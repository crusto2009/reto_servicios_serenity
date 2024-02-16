package com.jsonplaceholder.questions.CommentsQuestion;

import com.jsonplaceholder.models.Comments.ResponseModelComments;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.ArrayList;

public class ResponseGetComments implements Question<Object> {
    @Override
    public Object answeredBy(Actor actor) {
        ArrayList<ResponseModelComments> comments =new ArrayList<ResponseModelComments>();
        return SerenityRest.lastResponse().as(comments.getClass());
    }

    public static ResponseGetComments was(){
        return new ResponseGetComments();
    }
}
