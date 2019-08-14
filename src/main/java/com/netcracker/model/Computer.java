package com.netcracker.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class Computer {
    @Id
    private ObjectId id;

    private int RAM;
    private String CPU;

    public String getId() {
        return id.toHexString();
    }

    public ObjectId copyId() {
        return id;
    }
}
