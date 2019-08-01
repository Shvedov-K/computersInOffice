package com.netcracker.controllers;


import com.netcracker.model.Computer;
import com.netcracker.model.Office;
import com.netcracker.repositories.IRepository;
import com.netcracker.services.implementations.OfficeServiceImp;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController {
    @Autowired
    private IRepository repository;
    private OfficeServiceImp officeServiceImp;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Office> getAllOffice() {
        return officeServiceImp.getAllOffices();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Office getOfficeById(@PathVariable("id") ObjectId id) {
        return officeServiceImp.getOfficeById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateOfficeById(@PathVariable("id") ObjectId id, @Valid @RequestBody Office office) {
        officeServiceImp.updateOffice(id, office);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateOfficesNameById(@PathVariable("id") ObjectId id, @Valid @RequestBody String newName) {
        Office office = officeServiceImp.getOfficeById(id);
        officeServiceImp.editName(office, newName);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateOfficesCountOfEmployeeById(@PathVariable("id") ObjectId id, @Valid @RequestBody int newCount) {
        Office office = officeServiceImp.getOfficeById(id);
        officeServiceImp.editCountOfEmployee(office, newCount);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void addComputerToOfficeById(@PathVariable("id") ObjectId id, @Valid @RequestBody Computer newComputer) {
        Office office = officeServiceImp.getOfficeById(id);
        officeServiceImp.addComputer(office, newComputer);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Office addOffice(@Valid @RequestBody Office office) {
        return officeServiceImp.addIOffice(office);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOffice(@PathVariable ObjectId id) {
        officeServiceImp.deleteOfficeById(id);
    }
}
