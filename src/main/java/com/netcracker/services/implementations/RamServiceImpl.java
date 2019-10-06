package com.netcracker.services.implementations;

import com.netcracker.model.components.Ram;
import com.netcracker.repositories.RamRepository;
import com.netcracker.services.interfaces.RamService;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class RamServiceImpl implements RamService {

    private final RamRepository ramRepository;

    @Autowired
    public RamServiceImpl(RamRepository ramRepository) {
        this.ramRepository = ramRepository;
    }

    @Override
    public Ram getRamById(ObjectId id) {
        return ramRepository.findById(id);
    }

    @Override
    public List<Ram> getAllRam() {
        return ramRepository.findAll();
    }

    @Override
    public Ram addRam(Ram newRam) {
        newRam.setId(ObjectId.get());
        ramRepository.save(newRam);
        return newRam;
    }

    @Override
    public void updateRam(ObjectId id, Ram newRam) {
        Ram oldRam = ramRepository.findById(id);
        newRam.setId(oldRam.copyId());
        ramRepository.delete(oldRam);
        ramRepository.save(newRam);
    }

    @Override
    public void incrementLeftInStock(ObjectId id) {
        Ram newRam = ramRepository.findById(id);
        newRam.setLeftInStock(newRam.getLeftInStock() + 1);
        ramRepository.save(newRam);
    }

    @Override
    public void decrementLeftInStock(ObjectId id) {
        Ram newRam = ramRepository.findById(id);
        newRam.setLeftInStock(newRam.getLeftInStock() - 1);
        ramRepository.save(newRam);
    }

    @Override
    public void deleteRamById(ObjectId id) {
        ramRepository.delete(ramRepository.findById(id));
    }
}
