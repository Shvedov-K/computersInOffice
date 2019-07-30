package com.netcracker.services;

import com.netcracker.controllers.OfficeController;
import com.netcracker.model.Computer;
import com.netcracker.model.Office;
import org.bson.types.ObjectId;

import java.util.LinkedList;

public class OfficeService {
    OfficeController officeController;

    public void addComputer(ObjectId id, Computer newComputer) {
        Office office = officeController.getOfficeById(id);
        LinkedList computerList = office.getComputerList();
        computerList.add(newComputer);
        office.setComputerList(computerList);
        officeController.updateOfficeById(id, office);
    }

    public void editCountOfEmployee(ObjectId id, int newCount) {
        Office office = officeController.getOfficeById(id);
        office.setCountOfEmployee(newCount);
        officeController.updateOfficeById(id, office);
    }

    public void editName(ObjectId id, String newName) {
        Office office = officeController.getOfficeById(id);
        office.setName(newName);
        officeController.updateOfficeById(id, office);
    }



}
