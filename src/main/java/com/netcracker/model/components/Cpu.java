package com.netcracker.model.components;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class Cpu extends Component {
    @NotNull
    private CpuCompany cpuCompany;
    @NotNull
    private String name;
    @Min(0)
    private int coreSpeed;
    private int l1Cache;
    private int l2Cache;
    @NotNull
    private int numberOfCores;
}
