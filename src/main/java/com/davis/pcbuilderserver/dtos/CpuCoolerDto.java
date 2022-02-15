package com.davis.pcbuilderserver.dtos;

import com.davis.pcbuilderserver.entities.CpuCooler;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CpuCoolerDto implements Serializable {
    private Long id;

    private String company;

    private String name;

    private String type;

    private String radiator;

    private String price;

    private String amazonLink;

    public CpuCoolerDto(CpuCooler cpuCooler)
    {
        this.id = cpuCooler.getId();
        this.company = cpuCooler.getCompany();
        this.name = cpuCooler.getName();
        this.type = cpuCooler.getType();
        this.radiator = cpuCooler.getRadiator();
        this.price = cpuCooler.getPrice();
        this.amazonLink = cpuCooler.getAmazonLink();
    }
}
