package com.netcracker.model.components;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class Ram extends Component {
    @NotNull
    private DdrTypes ddrType;
    @NotNull
    private int memoryClockSpeed;
    @NotNull
    private int memoryMegabytes;
}
