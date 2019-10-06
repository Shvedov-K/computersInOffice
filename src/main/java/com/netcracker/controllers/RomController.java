package com.netcracker.controllers;

import com.netcracker.model.components.Rom;
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
@RequestMapping("/rom")
@EnableAutoConfiguration
public class RomController {


    private final RomService romService;

    public RomController(RomService romService) {
        this.romService = romService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Rom getRomById(@PathVariable("id") ObjectId id) {
        return romService.getRomById(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public List<Rom> getAllRom() {
        return romService.getAllRom();
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public Rom addRom(@Valid @RequestBody Rom rom) {
        return romService.addRom(rom);
    }

    @RequestMapping(value = "/{id}/updateRom", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> updateRom(@PathVariable("id") ObjectId id, @Valid @RequestBody Rom rom) {
        romService.updateRom(id, rom);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/increment", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> incrementRom(@PathVariable("id") ObjectId id) {
        romService.incrementLeftInStock(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}/decrement", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<?> decrementRom(@PathVariable("id") ObjectId id) {
        romService.decrementLeftInStock(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<?> deleteRom(@PathVariable ObjectId id) {
        romService.deleteRomById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
