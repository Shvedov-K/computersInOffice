package com.netcracker.controllers;

import com.netcracker.model.Computer;
import com.netcracker.services.interfaces.ComputerService;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/computer")
@EnableAutoConfiguration
public class ComputerController {

    private final ComputerService computerService;

    public ComputerController(ComputerService computerService) {
        this.computerService = computerService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Computer> getAllComputers() {
        return computerService.getAllComputer();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Computer getComputerById(@PathVariable("id") ObjectId id) {
        return computerService.getComputerById(id);
    }

    @RequestMapping(value = "/{id}/updateComputerById", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateComputerById(@PathVariable("id") ObjectId id, @Valid @RequestBody Computer computer) {
        computerService.updateComputer(id, computer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/updateComputersRAMById", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateComputersRAMById(@PathVariable("id") ObjectId id, @Valid @RequestBody int newRAM) {
        Computer computer = computerService.getComputerById(id);
        computerService.editRAM(computer, newRAM);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/updateComputersCPUById", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateComputersCPUById(@PathVariable("id") ObjectId id, @Valid @RequestBody String newCPU) {
        Computer computer = computerService.getComputerById(id);
        computerService.editCPU(computer, newCPU);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Computer addComputer(@Valid @RequestBody Computer computer) {
        return computerService.addComputer(computer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteComputer(@PathVariable ObjectId id) {
        if (computerService.usesCheck(id))
            return new ResponseEntity<>("This Office is not found", HttpStatus.BAD_REQUEST);
        computerService.deleteComputerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
