package com.netcracker.services.implementations;

import com.netcracker.model.Computer;
import com.netcracker.model.Office;
import com.netcracker.repositories.IRepository;
import com.netcracker.services.interfaces.OfficeService;
import org.bson.types.ObjectId;

import java.util.LinkedList;
import java.util.List;

public class OfficeServiceImp implements OfficeService {
    static String dbName = "mydb", dbCollection = "mycollection";
    private IRepository repository;

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
    public void addComputer(Office office, Computer newComputer) {
        List computerList = office.getComputerList();
        computerList.add(newComputer);
        office.setComputerList((LinkedList<Computer>) computerList);
        repository.save(office);
    }

    @Override
    public void deleteOfficeById(ObjectId id) {
        repository.delete(repository.findById(id));
    }

    @Override
    public void updateOffice(ObjectId id, Office office) {
        Office oldOffice = repository.findById(id);
        office.setId(oldOffice.getId());
        repository.delete(oldOffice);
        repository.save(office);
    }
}
