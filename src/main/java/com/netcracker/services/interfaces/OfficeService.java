package com.netcracker.services.interfaces;

import com.netcracker.model.Computer;
import com.netcracker.model.Office;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OfficeService {

    Office getOfficeById(ObjectId id);

    List<Office> getAllOffices();

    Office addIOffice(Office office);

    void editCountOfEmployee(Office office, int newCount);

    void editName(Office office, String newName);

    void addComputer(Office office, Computer computer);

    void deleteOfficeById(ObjectId id);

    void updateOffice(ObjectId id, Office office);
}
