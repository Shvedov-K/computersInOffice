package com.netcracker.model.components;

import lombok.Data;

@Data
public class Rom extends Component {
    private RomTypes romType;
    private int capacity;
    private int speed;
}
