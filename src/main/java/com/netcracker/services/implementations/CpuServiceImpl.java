package com.netcracker.services.implementations;

import com.netcracker.model.components.Cpu;
import com.netcracker.repositories.CpuRepository;
import com.netcracker.services.interfaces.CpuService;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class CpuServiceImpl implements CpuService {

    private final CpuRepository cpuRepository;

    @Autowired
    public CpuServiceImpl(CpuRepository cpuRepository) {
        this.cpuRepository = cpuRepository;
    }

    @Override
    public Cpu getCpuById(ObjectId id) {
        return cpuRepository.findById(id);
    }

    @Override
    public List<Cpu> getAllCpu() {
        return cpuRepository.findAll();
    }

    @Override
    public Cpu addCpu(Cpu newCpu) {
        newCpu.setId(ObjectId.get());
        cpuRepository.save(newCpu);
        return newCpu;
    }

    @Override
    public void updateCpu(ObjectId id, Cpu newCpu) {
        Cpu oldCpu = cpuRepository.findById(id);
        newCpu.setId(oldCpu.copyId());
        cpuRepository.delete(oldCpu);
        cpuRepository.save(newCpu);
    }

    @Override
    public void incrementLeftInStock(ObjectId id) {
        Cpu newCpu = cpuRepository.findById(id);
        newCpu.setLeftInStock(newCpu.getLeftInStock() + 1);
        cpuRepository.save(newCpu);
    }

    @Override
    public void decrementLeftInStock(ObjectId id) {
        Cpu newCpu = cpuRepository.findById(id);
        newCpu.setLeftInStock(newCpu.getLeftInStock() - 1);
        cpuRepository.save(newCpu);
    }

    @Override
    public void deleteCpuById(ObjectId id) {
        cpuRepository.delete(cpuRepository.findById(id));
    }
}
