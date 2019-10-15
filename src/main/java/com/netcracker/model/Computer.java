package com.netcracker.model;

import com.netcracker.model.components.Cpu;
import com.netcracker.model.components.Ram;
import com.netcracker.model.components.Rom;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Computer computer = (Computer) o;
        return Objects.equals(id, computer.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }
}
