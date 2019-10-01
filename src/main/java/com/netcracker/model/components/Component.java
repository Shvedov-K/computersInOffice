package com.netcracker.model.components;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class Component {
    @Id
    private ObjectId id;

    private String type;
    private int leftInStock;
}
