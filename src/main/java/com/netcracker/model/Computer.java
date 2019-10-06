package com.netcracker.model;

import com.netcracker.model.components.Cpu;
import com.netcracker.model.components.Ram;
import com.netcracker.model.components.Rom;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Data
public class Computer {
    @Id
    private ObjectId id;

    @NotNull
    @Valid
    private Ram ram;
    @NotNull
    @Valid
    private Cpu cpu;
    @NotNull
    @Valid
    private Rom rom;
    private boolean isUsed;

    public String getId() {
        return id.toHexString();
    }

    public ObjectId copyId() {
        return id;
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }
}
