package com.netcracker.controllers;

import com.netcracker.model.components.Cpu;
import com.netcracker.services.interfaces.CpuService;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/cpu")
@EnableAutoConfiguration
public class CpuController {

    private final CpuService cpuService;

    public CpuController(CpuService cpuService) {
        this.cpuService = cpuService;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Cpu getCpuById(@PathVariable("id") ObjectId id) {
        return cpuService.getCpuById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Cpu> getAllCpu() {
        return cpuService.getAllCpu();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Cpu addCpu(@Valid @RequestBody Cpu cpu) {
        return cpuService.addCpu(cpu);
    }

    @RequestMapping(value = "/{id}/updateCpu", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateCpu(@PathVariable("id") ObjectId id, @Valid @RequestBody Cpu cpu) {
        cpuService.updateCpu(id, cpu);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/increment", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> incrementRam(@PathVariable("id") ObjectId id) {
        cpuService.incrementLeftInStock(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/decrement", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> decrementRam(@PathVariable("id") ObjectId id) {
        cpuService.decrementLeftInStock(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteCpu(@PathVariable ObjectId id) {
        cpuService.deleteCpuById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
