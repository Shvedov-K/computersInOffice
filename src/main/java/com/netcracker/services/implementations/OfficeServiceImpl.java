package com.netcracker.services.implementations;

import com.netcracker.model.Office;
import com.netcracker.repositories.OfficeRepository;
import com.netcracker.services.interfaces.OfficeService;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class OfficeServiceImpl implements OfficeService {


    private final OfficeRepository repository;

    @Autowired
    public OfficeServiceImpl(OfficeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Office getOfficeById(ObjectId id) {

        return repository.findById(id);
    }

    @Override
    public List<Office> getAllOffices() {
        return repository.findAll();
    }

    @Override
    public Office addIOffice(Office office) {
        office.setId(ObjectId.get());
        repository.save(office);
        return office;
    }

    @Override
    public void editCountOfEmployee(Office office, int newCount) {
        office.setCountOfEmployee(newCount);
        repository.save(office);
    }

    @Override
    public void editName(Office office, String newName) {
        office.setName(newName);
        repository.save(office);
    }

    @Override
    public void addComputer(Office office, String newComputerId) {
        List computerList = office.getComputerList();
        computerList.add(newComputerId);
        repository.save(office);
    }

    @Override
    public void deleteComputer(Office office, String computerId) {
        List computerList = office.getComputerList();
        computerList.remove(computerId);
        repository.save(office);
    }

    @Override
    public void deleteOfficeById(ObjectId id) {
        repository.delete(repository.findById(id));
    }

    @Override
    public void updateOffice(ObjectId id, Office office) {
        Office oldOffice = repository.findById(id);
        office.setId(oldOffice.copyId());
        repository.delete(oldOffice);
        repository.save(office);
    }
}
