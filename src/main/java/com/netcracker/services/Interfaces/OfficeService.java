package com.netcracker.services.Interfaces;

import com.netcracker.model.Office;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.LinkedList;

@Service
public interface OfficeService {

    Office getOfficeById(ObjectId id);

    LinkedList<Office> getAllOffices();

    void addIOffice(Office office);

    void editCountOfEmployee(Office office);

    void editName(Office office);

    void addComputer(Office office);

    void deleteOffice(Office office);
}
