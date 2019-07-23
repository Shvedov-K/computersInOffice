package com.netcracker.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.LinkedList;

public class Office {
    @Id
    public ObjectId id;

    public String name;
    public int countOfEmployee;
    public LinkedList<Computer> computerList;

    public Office(ObjectId _id, String name, int countOfemployee, LinkedList<Computer> computerList) {
        this.id = _id;
        this.name = name;
        this.countOfEmployee = countOfemployee;
        this.computerList = computerList;
    }

    public String getId() {
        return id.toString();
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getCountOfEmployee() {
        return countOfEmployee;
    }

    public LinkedList<Computer> getComputerList() {
        return computerList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountOfEmployee(int countOfEmployee) {
        this.countOfEmployee = countOfEmployee;
    }

    public void setComputerList(LinkedList<Computer> computerList) {
        this.computerList = computerList;
    }

    public void addComputer(Computer computer) {
        computerList.add(computer);
    }

    /*public void delComputerOfId(ObjectId _id) {
        for (Computer computer :
                computerList) {
            if (computer.getId() == _id.toHexString()) {
                computerList.remove(computer);
                break;
            }
        }
    }*/
}
