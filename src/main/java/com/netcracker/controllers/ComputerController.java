package com.netcracker.controllers;

import com.netcracker.model.Computer;
import com.netcracker.services.interfaces.ComputerService;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
    public void updateComputerById(@PathVariable("id") ObjectId id, @Valid @RequestBody Computer computer) {
        computerService.updateComputer(id, computer);
    }

    @RequestMapping(value = "/{id}/updateComputersRAMById", method = RequestMethod.PUT)
    @ResponseBody
    public void updateComputersRAMById(@PathVariable("id") ObjectId id, @Valid @RequestBody int newRAM) {
        Computer computer = computerService.getComputerById(id);
        computerService.editRAM(computer, newRAM);
    }

    @RequestMapping(value = "/{id}/updateComputersCPUById", method = RequestMethod.PUT)
    @ResponseBody
    public void updateComputersCPUById(@PathVariable("id") ObjectId id, @Valid @RequestBody String newCPU) {
        Computer computer = computerService.getComputerById(id);
        computerService.editCPU(computer, newCPU);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Computer addComputer(@Valid @RequestBody Computer computer) {
        return computerService.addComputer(computer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public void deleteOffice(@PathVariable ObjectId id) {
        computerService.deleteComputerById(id);
    }
}
