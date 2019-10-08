package com.netcracker.controllers;

import com.netcracker.model.Computer;
import com.netcracker.model.components.ComputerComponent;
import com.netcracker.services.interfaces.ComputerService;
import com.netcracker.services.interfaces.CpuService;
import com.netcracker.services.interfaces.RamService;
import com.netcracker.services.interfaces.RomService;
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
    private final CpuService cpuService;
    private final RamService ramService;
    private final RomService romService;


    public ComputerController(ComputerService computerService, CpuService cpuService, RamService ramService, RomService romService) {
        this.computerService = computerService;
        this.cpuService = cpuService;
        this.ramService = ramService;
        this.romService = romService;
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

    @RequestMapping(value = "/{id}/updateComputersRamById", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateComputersRamById(@PathVariable("id") ObjectId id, @Valid @RequestBody String newRamId) {
        if (!ramService.getAllRam().contains(ramService.getRamById(new ObjectId(newRamId)))) {
            computerService.deleteComputerById(id);
            return new ResponseEntity<>("This Ram not found", HttpStatus.BAD_REQUEST);
        }
        if (ramService.getRamById(new ObjectId(newRamId)).getLeftInStock() == 0) {
            computerService.deleteComputerById(id);
            return new ResponseEntity<>("This Ram not in stock", HttpStatus.BAD_REQUEST);
        }
        Computer computer = computerService.getComputerById(id);
        if (computer.getRam() != null) ramService.incrementLeftInStock(new ObjectId(computer.getRam().getId()));
        computerService.editRam(computer, ramService.getRamById(new ObjectId(newRamId)));
        ramService.decrementLeftInStock(new ObjectId(newRamId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/updateComputersRomById", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateComputersRomById(@PathVariable("id") ObjectId id, @Valid @RequestBody String newRomId) {
        if (!romService.getAllRom().contains(romService.getRomById(new ObjectId(newRomId)))) {
            computerService.deleteComputerById(id);
            return new ResponseEntity<>("This Rom not found", HttpStatus.BAD_REQUEST);
        }
        if (romService.getRomById(new ObjectId(newRomId)).getLeftInStock() == 0) {
            computerService.deleteComputerById(id);
            return new ResponseEntity<>("This Rom not in stock", HttpStatus.BAD_REQUEST);
        }
        Computer computer = computerService.getComputerById(id);
        if (computer.getRom() != null) romService.incrementLeftInStock(new ObjectId(computer.getRom().getId()));
        computerService.editRom(computer, romService.getRomById(new ObjectId(newRomId)));
        romService.decrementLeftInStock(new ObjectId(newRomId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/updateComputersCpuById", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateComputersCpuById(@PathVariable("id") ObjectId id, @Valid @RequestBody String newCpuId) {
        if (!cpuService.getAllCpu().contains(cpuService.getCpuById(new ObjectId(newCpuId)))) {
            computerService.deleteComputerById(id);
            return new ResponseEntity<>("This Cpu not found", HttpStatus.BAD_REQUEST);
        }
        if (cpuService.getCpuById(new ObjectId(newCpuId)).getLeftInStock() == 0) {
            computerService.deleteComputerById(id);
            return new ResponseEntity<>("This Cpu not in stock", HttpStatus.BAD_REQUEST);
        }
        Computer computer = computerService.getComputerById(id);
        if (computer.getCpu() != null) cpuService.incrementLeftInStock(new ObjectId(computer.getCpu().getId()));
        computerService.editCpu(computer, cpuService.getCpuById(new ObjectId(newCpuId)));
        cpuService.decrementLeftInStock(new ObjectId(newCpuId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> addComputer(@Valid @RequestBody ComputerComponent computerComponent) {
        ObjectId newId = ObjectId.get();
        Computer newComputer = new Computer();
        ResponseEntity responseEntity;
        newComputer.setId(newId);
        computerService.addComputer(newComputer);
        responseEntity = updateComputersCpuById(newId, computerComponent.getCpuId());
        if (!responseEntity.equals(new ResponseEntity<>(HttpStatus.OK)))
            return responseEntity;
        responseEntity = updateComputersRamById(newId, computerComponent.getRamId());
        if (!responseEntity.equals(new ResponseEntity<>(HttpStatus.OK)))
            return responseEntity;
        responseEntity = updateComputersRomById(newId, computerComponent.getRomId());
        if (!responseEntity.equals(new ResponseEntity<>(HttpStatus.OK)))
            return responseEntity;
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteComputer(@PathVariable ObjectId id) {
        if (!computerService.getAllComputer().contains(computerService.getComputerById(id)))
            return new ResponseEntity<>("This Computer is not found", HttpStatus.BAD_REQUEST);
        Computer computer = computerService.getComputerById(id);
        if (computer.getRom() != null) romService.incrementLeftInStock(new ObjectId(computer.getRom().getId()));
        if (computer.getCpu() != null) cpuService.incrementLeftInStock(new ObjectId(computer.getCpu().getId()));
        if (computer.getRam() != null) ramService.incrementLeftInStock(new ObjectId(computer.getRam().getId()));
        computerService.deleteComputerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
