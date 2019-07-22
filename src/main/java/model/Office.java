package model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import java.util.LinkedList;

public class Office {
    @Id
    public ObjectId _id;

    public String name;
    public int countOfemployee;
    public LinkedList<Computer> computerList;

    public Office(ObjectId _id, String name, int countOfemployee, LinkedList<Computer> computerList) {
        this._id = _id;
        this.name = name;
        this.countOfemployee = countOfemployee;
        this.computerList = computerList;
    }

    public String get_id() {
        return _id.toString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public int getCountOfemployee() {
        return countOfemployee;
    }

    public LinkedList<Computer> getComputerList() {
        return computerList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountOfemployee(int countOfemployee) {
        this.countOfemployee = countOfemployee;
    }

    public void setComputerList(LinkedList<Computer> computerList) {
        this.computerList = computerList;
    }

    public void addComputer(Computer computer) {
        computerList.add(computer);
    }

    public void delComputerOfId(ObjectId _id) {
        for (Computer computer :
                computerList) {
            if (computer.get_id() == _id.toHexString()) {
                computerList.remove(computer);
                break;
            }
        }
    }
}
