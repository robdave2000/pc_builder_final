package com.davis.pcbuilderserver.dtos;

import com.davis.pcbuilderserver.entities.Gpu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GpuDto implements Serializable {
    private Long id;

    private String brand;

    private String name;

    private String chipset;

    private String memory;

    private String baseClock;

    private String boostClock;

    private String price;

    private String amazonLink;

    public GpuDto(Gpu gpu)
    {
        this.id = gpu.getId();
        this.brand = gpu.getBrand();
        this.name = gpu.getName();
        this.chipset = gpu.getChipset();
        this.memory = gpu.getMemory();
        this.baseClock = gpu.getBaseClock();
        this.boostClock = gpu.getBoostClock();
        this.price = gpu.getPrice();
        this.amazonLink = gpu.getAmazonLink();
    }
}
