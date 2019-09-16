package com.netcracker.controllers;


import com.netcracker.model.Office;
import com.netcracker.services.interfaces.ComputerService;
import com.netcracker.services.interfaces.OfficeService;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/office")
@EnableAutoConfiguration
public class OfficeController {

    private final OfficeService officeService;
    private final ComputerService computerService;

    public OfficeController(OfficeService officeService, ComputerService computerService) {
        this.officeService = officeService;
        this.computerService = computerService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Office> getAllOffice() {
        return officeService.getAllOffices();
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
    public String addComputerToOfficeById(@PathVariable("id") ObjectId id, @Valid @RequestBody String newComputerId) {
        if (computerService.usesCheck(new ObjectId(newComputerId))) return "error";
        Office office = officeService.getOfficeById(id);
        officeService.addComputer(office, newComputerId);
        computerService.stateChange(new ObjectId(newComputerId));
        return "complete";
    }

    @RequestMapping(value = "/{id}/removeComputerFromOfficeById", method = RequestMethod.PUT)
    @ResponseBody
    public String removeComputerFromOfficeById(@PathVariable("id") ObjectId id, @Valid @RequestBody String computerId) {
        if (!officeService.getOfficeById(id).getComputerList().contains(computerId)) return "error";
        officeService.deleteComputer(officeService.getOfficeById(id), computerId);
        computerService.stateChange(new ObjectId(computerId));
        return "complete";
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
