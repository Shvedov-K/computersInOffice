package com.netcracker.model;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

@Data
public class Computer {
    @Id
    public ObjectId id;

    public int RAM;
    public String CPU;
}
