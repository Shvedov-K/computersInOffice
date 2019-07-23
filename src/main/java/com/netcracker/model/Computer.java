package com.netcracker.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Computer {
    @Id
    public ObjectId id;

    public int RAM;
    public String CPU;

    public Computer(ObjectId _id, int RAM, String CPU) {
        this.id = _id;
        this.RAM = RAM;
        this.CPU = CPU;
    }

    public int getRAM() {
        return RAM;
    }

    public String getCPU() {
        return CPU;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getId() {
        return id.toHexString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
