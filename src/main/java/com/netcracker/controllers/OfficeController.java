package com.netcracker.controllers;


import com.netcracker.model.Office;
import com.netcracker.services.interfaces.OfficeService;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/office")
@EnableAutoConfiguration
public class OfficeController {

    private final OfficeService officeService;

    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Office> getAllOffice() {
        return officeService.getAllOffices();
    }

    @RequestMapping(value = "/t", method = RequestMethod.GET)
    @ResponseBody
    public String test() {
        return "test";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Office getOfficeById(@PathVariable("id") ObjectId id) {
        return officeService.getOfficeById(id);
    }

    @RequestMapping(value = "/{id}/updateOfficeById", method = RequestMethod.PUT)
    @ResponseBody
    public void updateOfficeById(@PathVariable("id") ObjectId id, @Valid @RequestBody Office office) {
        officeService.updateOffice(id, office);
    }

    @RequestMapping(value = "/{id}/updateOfficesNameById", method = RequestMethod.PUT)
    @ResponseBody
    public void updateOfficesNameById(@PathVariable("id") ObjectId id, @Valid @RequestBody String newName) {
        Office office = officeService.getOfficeById(id);
        officeService.editName(office, newName);
    }

    @RequestMapping(value = "/{id}/updateOfficesCountOfEmployeeById", method = RequestMethod.PUT)
    @ResponseBody
    public void updateOfficesCountOfEmployeeById(@PathVariable("id") ObjectId id, @Valid @RequestBody int newCount) {
        Office office = officeService.getOfficeById(id);
        officeService.editCountOfEmployee(office, newCount);
    }

    @RequestMapping(value = "/{id}/addComputerToOfficeById", method = RequestMethod.PUT)
    @ResponseBody
    public void addComputerToOfficeById(@PathVariable("id") ObjectId id, @Valid @RequestBody ObjectId newComputerId) {
        Office office = officeService.getOfficeById(id);
        officeService.addComputer(office, newComputerId);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Office addOffice(@Valid @RequestBody Office office) {
        return officeService.addIOffice(office);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteOffice(@PathVariable ObjectId id) {
        officeService.deleteOfficeById(id);
    }
}
