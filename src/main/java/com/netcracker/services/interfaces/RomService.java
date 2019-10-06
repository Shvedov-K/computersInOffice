package com.netcracker.services.interfaces;

import com.netcracker.model.components.Rom;
import org.bson.types.ObjectId;

import java.util.List;

public interface RomService {
    Rom getRomById(ObjectId id);

    List<Rom> getAllRom();

    Rom addRom(Rom newRom);

    void updateRom(ObjectId id, Rom newRom);

    void incrementLeftInStock(ObjectId id);

    void decrementLeftInStock(ObjectId id);

    void deleteRomById(ObjectId id);
}
