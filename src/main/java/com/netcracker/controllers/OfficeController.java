package com.netcracker.controllers;


import com.netcracker.model.Office;
import com.netcracker.repositories.IRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/office")
public class OfficeController {
    @Autowired
    private IRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Office> getAllOffice() {
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Office getOfficeById(@PathVariable("id") ObjectId id) {
        return repository.findById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyOfficeById(@PathVariable("id") ObjectId id, @Valid @RequestBody Office office) {
        office.setId(id);
        repository.save(office);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Office createOffice(@Valid @RequestBody Office office) {
        office.setId(ObjectId.get());
        repository.save(office);
        return office;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteOffice(@PathVariable ObjectId id) {
        repository.delete(repository.findById(id));
    }
}
