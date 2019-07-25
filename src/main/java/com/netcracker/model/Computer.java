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
}
