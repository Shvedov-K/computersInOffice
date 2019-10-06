package com.netcracker.model.components;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Rom extends Component {
    @NotNull
    private RomTypes romType;
    @NotNull
    private int capacity;
    @NotNull
    private int speed;
}
