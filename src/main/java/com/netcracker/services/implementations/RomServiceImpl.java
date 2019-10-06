package com.netcracker.services.implementations;

import com.netcracker.model.components.Rom;
import com.netcracker.repositories.RomRepository;
import com.netcracker.services.interfaces.RomService;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class RomServiceImpl implements RomService {

    private final RomRepository romRepository;

    @Autowired
    public RomServiceImpl(RomRepository romRepository) {
        this.romRepository = romRepository;
    }

    @Override
    public Rom getRomById(ObjectId id) {
        return romRepository.findById(id);
    }

    @Override
    public List<Rom> getAllRom() {
        return romRepository.findAll();
    }

    @Override
    public Rom addRom(Rom newRom) {
        newRom.setId(ObjectId.get());
        romRepository.save(newRom);
        return newRom;
    }

    @Override
    public void updateRom(ObjectId id, Rom newRom) {
        Rom oldRom = romRepository.findById(id);
        newRom.setId(oldRom.copyId());
        romRepository.delete(oldRom);
        romRepository.save(newRom);
    }

    @Override
    public void incrementLeftInStock(ObjectId id) {
        Rom newRom = romRepository.findById(id);
        newRom.setLeftInStock(newRom.getLeftInStock() + 1);
        romRepository.save(newRom);
    }

    @Override
    public void decrementLeftInStock(ObjectId id) {
        Rom newRom = romRepository.findById(id);
        newRom.setLeftInStock(newRom.getLeftInStock() - 1);
        romRepository.save(newRom);
    }

    @Override
    public void deleteRomById(ObjectId id) {
        romRepository.delete(romRepository.findById(id));
    }
}
