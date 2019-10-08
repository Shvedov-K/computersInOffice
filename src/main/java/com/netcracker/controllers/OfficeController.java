package com.netcracker.controllers;


import com.netcracker.model.Computer;
import com.netcracker.model.Office;
import com.netcracker.services.interfaces.ComputerService;
import com.netcracker.services.interfaces.OfficeService;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> updateOfficeById(@PathVariable("id") ObjectId id, @Valid @RequestBody Office office) {
        officeService.updateOffice(id, office);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/updateOfficesNameById", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateOfficesNameById(@PathVariable("id") ObjectId id, @Valid @RequestBody String newName) {
        Office office = officeService.getOfficeById(id);
        officeService.editName(office, newName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/updateOfficesCountOfEmployeeById", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateOfficesCountOfEmployeeById(@PathVariable("id") ObjectId id, @Valid @RequestBody int newCount) {
        Office office = officeService.getOfficeById(id);
        officeService.editCountOfEmployee(office, newCount);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/addComputerToOfficeById", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> addComputerToOfficeById(@PathVariable("id") ObjectId id, @Valid @RequestBody String newComputerId) {
        if (officeService.getComputersIdList(id).contains(newComputerId))
            return new ResponseEntity<>("This computer is already added", HttpStatus.BAD_REQUEST);
        Computer newComputer = computerService.getComputerById(new ObjectId(newComputerId));
        if (newComputer == null) return new ResponseEntity<>("This computer is not found", HttpStatus.BAD_REQUEST);
        Office office = officeService.getOfficeById(id);
        officeService.addComputer(office, newComputer);
        computerService.deleteComputerById(new ObjectId(newComputerId));
        //computerService.stateChange(new ObjectId(newComputerId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/removeComputerFromOfficeById", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> removeComputerFromOfficeById(@PathVariable("id") ObjectId id, @Valid @RequestBody String computerId) {
        if (!officeService.getComputersIdList(id).contains(computerId))
            return new ResponseEntity<>("This computer is not found", HttpStatus.BAD_REQUEST);
        Computer computer = officeService.deleteComputer(officeService.getOfficeById(id), computerId);
        computerService.addOldComputer(computer);
        //computerService.stateChange(new ObjectId(computerId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Office addOffice(@Valid @RequestBody Office office) {
        return officeService.addIOffice(office);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteOffice(@PathVariable ObjectId id) {
        officeService.deleteOfficeById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
