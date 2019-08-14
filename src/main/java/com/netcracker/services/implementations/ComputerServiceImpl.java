package com.netcracker.services.implementations;

import com.netcracker.model.Computer;
import com.netcracker.repositories.ComputerRepository;
import com.netcracker.services.interfaces.ComputerService;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class ComputerServiceImpl implements ComputerService {

    private final ComputerRepository repository;

    @Autowired
    public ComputerServiceImpl(ComputerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Computer getComputerById(ObjectId id) {
        return repository.findById(id);
    }

    @Override
    public List<Computer> getAllComputer() {
        return repository.findAll();
    }

    @Override
    public Computer addComputer(Computer newComputer) {
        newComputer.setId(ObjectId.get());
        repository.save(newComputer);
        return newComputer;
    }

    @Override
    public void editRAM(Computer computer, int newRAM) {
        computer.setRAM(newRAM);
        repository.save(computer);
    }

    @Override
    public void editCPU(Computer computer, String newCPU) {
        computer.setCPU(newCPU);
        repository.save(computer);
    }

    @Override
    public void updateComputer(ObjectId id, Computer computer) {
        Computer oldComputer = repository.findById(id);
        computer.setId(oldComputer.copyId());
        repository.delete(oldComputer);
        repository.save(computer);
    }

    @Override
    public void stateChange(ObjectId id) {
        Computer computer = repository.findById(id);
        if (computer.getIsUsed()) computer.setIsUsed(false);
        else computer.setIsUsed(true);
        repository.save(computer);
    }

    @Override
    public void deleteComputerById(ObjectId id) {
        repository.delete(repository.findById(id));
    }

    @Override
    public boolean usesCheck(ObjectId id) {
        return repository.findById(id).getIsUsed();
    }
}
