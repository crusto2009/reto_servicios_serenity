package com.jsonplaceholder.models.Todos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class ResponseArrayTodos {

    @JsonProperty("todos")
    public List<ResponseModelTodos> todos;
}
