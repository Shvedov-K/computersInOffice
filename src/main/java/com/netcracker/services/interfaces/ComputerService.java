package com.netcracker.services.interfaces;

import com.netcracker.model.Computer;
import org.bson.types.ObjectId;

import java.util.List;

public interface ComputerService {
    Computer getComputerById(ObjectId id);

    List<Computer> getAllComputer();

    Computer addComputer(Computer newComputer);

    void editRAM(Computer computer, int newRAM);

    void editCPU(Computer computer, String newCPU);

    void updateComputer(ObjectId id, Computer computer);

    void deleteComputerById(ObjectId id);
}
