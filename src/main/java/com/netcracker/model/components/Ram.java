package com.netcracker.model.components;

import lombok.Data;

@Data
public class Ram extends Component {
    private DdrTypes ddrType;
    private int memoryClockSpeed;
    private int memoryMegabytes;
}
