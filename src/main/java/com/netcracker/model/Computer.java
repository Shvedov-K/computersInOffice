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
    private boolean isUsed;

    public String getId() {
        return id.toHexString();
    }

    public ObjectId copyId() {
        return id;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }
}
