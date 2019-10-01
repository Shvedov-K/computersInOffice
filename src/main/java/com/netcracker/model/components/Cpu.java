package com.netcracker.model.components;

import lombok.Data;

@Data
public class Cpu extends Component {
    private CpuCompany cpuCompany;
    private int coreSpeed;
    private int l1Cache;
    private int l2Cache;
    private int numberOfCores;
}
