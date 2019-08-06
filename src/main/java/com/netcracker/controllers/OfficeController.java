package com.netcracker.controllers;


import com.netcracker.model.Computer;
import com.netcracker.model.Office;
import com.netcracker.services.implementations.OfficeServiceImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController {

    @Autowired
    private OfficeServiceImpl officeServiceImpl;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Office> getAllOffice() {
        return officeServiceImpl.getAllOffices();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Office getOfficeById(@PathVariable("id") ObjectId id) {
        return officeServiceImpl.getOfficeById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateOfficeById(@PathVariable("id") ObjectId id, @Valid @RequestBody Office office) {
        officeServiceImpl.updateOffice(id, office);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateOfficesNameById(@PathVariable("id") ObjectId id, @Valid @RequestBody String newName) {
        Office office = officeServiceImpl.getOfficeById(id);
        officeServiceImpl.editName(office, newName);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updateOfficesCountOfEmployeeById(@PathVariable("id") ObjectId id, @Valid @RequestBody int newCount) {
        Office office = officeServiceImpl.getOfficeById(id);
        officeServiceImpl.editCountOfEmployee(office, newCount);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void addComputerToOfficeById(@PathVariable("id") ObjectId id, @Valid @RequestBody Computer newComputer) {
        Office office = officeServiceImpl.getOfficeById(id);
        officeServiceImpl.addComputer(office, newComputer);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Office addOffice(@Valid @RequestBody Office office) {
        return officeServiceImpl.addIOffice(office);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOffice(@PathVariable ObjectId id) {
        officeServiceImpl.deleteOfficeById(id);
    }
}
