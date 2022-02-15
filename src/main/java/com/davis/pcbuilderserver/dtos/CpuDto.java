package com.davis.pcbuilderserver.dtos;

import com.davis.pcbuilderserver.entities.Cpu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CpuDto implements Serializable {
    private Long id;

    private String brand;

    private String level;

    private String name;

    private int cores;

    private int threads;

    private String coreClock;

    private String boostClock;

    private String tdp;

    private String intergratedGraphics;

    private String chipset;

    private String price;

    private String amazonLink;

    public CpuDto(Cpu cpu)
    {
        this.id = cpu.getId();
        this.brand = cpu.getBrand();
        this.level = cpu.getLevel();
        this.name = cpu.getName();
        this.cores = cpu.getCores();
        this.threads = cpu.getThreads();
        this.coreClock = cpu.getCoreClock();
        this.boostClock = cpu.getBoostClock();
        this.tdp = cpu.getTdp();
        this.intergratedGraphics = cpu.getIntergratedGraphics();
        this.chipset = cpu.getChipset();
        this.price = cpu.getPrice();
        this.amazonLink = cpu.getAmazonLink();
    }
}
