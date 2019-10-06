package com.netcracker.services.interfaces;

import com.netcracker.model.components.Ram;
import org.bson.types.ObjectId;

import java.util.List;

public interface RamService {
    Ram getRamById(ObjectId id);

    List<Ram> getAllRam();

    Ram addRam(Ram newRam);

    void updateRam(ObjectId id, Ram newRam);

    void incrementLeftInStock(ObjectId id);

    void decrementLeftInStock(ObjectId id);

    void deleteRamById(ObjectId id);
}
