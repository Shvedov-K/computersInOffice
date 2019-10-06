package com.netcracker.services.interfaces;

import com.netcracker.model.components.Cpu;
import org.bson.types.ObjectId;

import java.util.List;

public interface CpuService {
    Cpu getCpuById(ObjectId id);

    List<Cpu> getAllCpu();

    Cpu addCpu(Cpu newCpu);

    void updateCpu(ObjectId id, Cpu newCpu);

    void incrementLeftInStock(ObjectId id);

    void decrementLeftInStock(ObjectId id);

    void deleteCpuById(ObjectId id);
}

