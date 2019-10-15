package com.netcracker.services.implementations;

import com.netcracker.model.Computer;
import com.netcracker.model.Office;
import com.netcracker.model.components.Cpu;
import com.netcracker.model.components.Ram;
import com.netcracker.model.components.Rom;
import com.netcracker.repositories.ComputerRepository;
import com.netcracker.repositories.OfficeRepository;
import com.netcracker.services.interfaces.ComputerService;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ComputerServiceImpl implements ComputerService {

    private final ComputerRepository computerRepository;
    private final OfficeRepository officeRepository;

    @Autowired
    public ComputerServiceImpl(ComputerRepository repository, OfficeRepository officeRepository) {
        this.computerRepository = repository;
        this.officeRepository = officeRepository;
    }

    @Override
    public Computer getComputerById(ObjectId id) {
        return computerRepository.findById(id);
    }

    @Override
    public List<Computer> getAllComputer() {
        List<Office> officeList = officeRepository.findAll();
        List<Computer> computerList = computerRepository.findAll();
        for (Office office : officeList) {
            computerList.addAll(office.getComputerList());
        }
        return computerList;
    }

    @Override
    public Computer addComputer(Computer newComputer) {
        computerRepository.save(newComputer);
        return newComputer;
    }

    @Override
    public void addOldComputer(Computer oldComputer) {
        computerRepository.save(oldComputer);
    }

    @Override
    public void editRam(Computer computer, Ram newRam) {
        computer.setRam(newRam);
        computerRepository.save(computer);
    }

    @Override
    public void editCpu(Computer computer, Cpu newCpu) {
        computer.setCpu(newCpu);
        computerRepository.save(computer);
    }

    @Override
    public void editRom(Computer computer, Rom newRom) {
        computer.setRom(newRom);
        computerRepository.save(computer);
    }

    @Override
    public void updateComputer(ObjectId id, Computer computer) {
        Computer oldComputer = computerRepository.findById(id);
        computer.setId(oldComputer.copyId());
        computerRepository.delete(oldComputer);
        computerRepository.save(computer);
    }

    @Override
    public void deleteComputerById(ObjectId id) {
        computerRepository.delete(computerRepository.findById(id));
    }

    @Override
    public void stateChange(ObjectId id) {
        Computer computer = computerRepository.findById(id);
        if (computer.getIsUsed()) computer.setIsUsed(false);
        else computer.setIsUsed(true);
        computerRepository.save(computer);
    }

    @Override
    public boolean usesCheck(ObjectId id) {
        return computerRepository.findById(id).getIsUsed();
    }
}
