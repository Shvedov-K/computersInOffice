package com.netcracker.controllers;

import com.netcracker.model.components.Ram;
import com.netcracker.services.interfaces.RamService;
import org.bson.types.ObjectId;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/ram")
@EnableAutoConfiguration
public class RamController {

    private final RamService ramService;

    public RamController(RamService ramService) {
        this.ramService = ramService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Ram getRamById(@PathVariable("id") ObjectId id) {
        return ramService.getRamById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Ram> getAllRam() {
        return ramService.getAllRam();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Ram addRam(@Valid @RequestBody Ram ram) {
        return ramService.addRam(ram);
    }

    @RequestMapping(value = "/{id}/updateRam", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateRam(@PathVariable("id") ObjectId id, @Valid @RequestBody Ram ram) {
        ramService.updateRam(id, ram);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/increment", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> incrementRam(@PathVariable("id") ObjectId id) {
        ramService.incrementLeftInStock(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/decrement", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> decrementRam(@PathVariable("id") ObjectId id) {
        ramService.decrementLeftInStock(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteRam(@PathVariable ObjectId id) {
        ramService.deleteRamById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
