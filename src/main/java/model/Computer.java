package model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Computer {
    @Id
    public ObjectId _id;

    public int RAM;
    public String CPU;

    public Computer(ObjectId _id, int RAM, String CPU) {
        this._id = _id;
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

    public String get_id() {
        return _id.toString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }
}
