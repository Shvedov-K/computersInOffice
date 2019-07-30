package com.netcracker.services;

import com.netcracker.controllers.OfficeController;
import com.netcracker.model.Computer;
import com.netcracker.model.Office;
import org.bson.types.ObjectId;

import java.util.LinkedList;

public class OfficeService {
    OfficeController officeController;

    public void addComputer(Computer newComputer, ObjectId id) {
        Office office = officeController.getOfficeById(id);
        LinkedList computerList = office.getComputerList();
        computerList.add(newComputer);
        office.setComputerList(computerList);
        officeController.updateOfficeById(id, office);
    }

}
