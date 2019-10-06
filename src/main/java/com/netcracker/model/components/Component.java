package com.netcracker.model.components;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class Component {
    @Id
    private ObjectId id;

    @NotNull
    private String type;
    @Min(0)
    private int leftInStock;

    public String getId() {
        return id.toHexString();
    }

    public ObjectId copyId() {
        return id;
    }
}
