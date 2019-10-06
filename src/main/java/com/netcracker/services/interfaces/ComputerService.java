package com.netcracker.services.interfaces;

import com.netcracker.model.Computer;
import com.netcracker.model.components.Cpu;
import com.netcracker.model.components.Ram;
import com.netcracker.model.components.Rom;
import org.bson.types.ObjectId;

import java.util.List;

public interface ComputerService {
    Computer getComputerById(ObjectId id);

    List<Computer> getAllComputer();

    Computer addComputer(Computer newComputer);

    void addOldComputer(Computer oldComputer);

    void editRam(Computer computer, Ram newRam);

    void editCpu(Computer computer, Cpu newCpu);

    void editRom(Computer computer, Rom newRrom);

    void updateComputer(ObjectId id, Computer computer);

    void stateChange(ObjectId id);

    void deleteComputerById(ObjectId id);

    boolean usesCheck(ObjectId id);
}
