package com.jsonplaceholder.models.Comments;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
@Getter
public class ResponseArrayCommentsForId {
    @JsonProperty("comments")
    public List<ResponseModelComments> comments;
}
