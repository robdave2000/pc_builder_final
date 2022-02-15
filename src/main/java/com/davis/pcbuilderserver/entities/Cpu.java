package com.davis.pcbuilderserver.entities;

import com.davis.pcbuilderserver.dtos.CpuDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "cpus")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "Cpu_sequence", initialValue = 63)
public class Cpu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Cpu_sequence")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "level")
    private String level;

    @Column(name = "name")
    private String name;

    @Column(name = "cores")
    private int cores;

    @Column(name = "threads")
    private int threads;

    @Column(name = "coreClock")
    private String coreClock;

    @Column(name = "boostClock")
    private String boostClock;

    @Column(name = "tdp")
    private String tdp;

    @Column(name = "intergratedGraphics")
    private String intergratedGraphics;

    @Column(name = "chipset")
    private String chipset;

    @Column(name = "price")
    private String price;

    @Column(name = "amazon_link")
    private String amazonLink;

    @Override
    public String toString() {
        return "pcbuilder.CPU{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", level='" + level + '\'' +
                ", name='" + name + '\'' +
                ", cores=" + cores +
                ", threads=" + threads +
                ", coreClock='" + coreClock + '\'' +
                ", boostClock='" + boostClock + '\'' +
                ", tdp='" + tdp + '\'' +
                ", intergratedGraphics='" + intergratedGraphics + '\'' +
                ", chipset='" + chipset + '\'' +
                ", price='" + price + '\'' +
                ", amazonLink='" + amazonLink + '\'' +
                '}';
    }

    public Cpu(CpuDto cpuDto)
    {
        this.id = cpuDto.getId();
        this.brand = cpuDto.getBrand();
        this.level = cpuDto.getLevel();
        this.name = cpuDto.getName();
        this.cores = cpuDto.getCores();
        this.threads = cpuDto.getThreads();
        this.coreClock = cpuDto.getCoreClock();
        this.boostClock = cpuDto.getBoostClock();
        this.tdp = cpuDto.getTdp();
        this.intergratedGraphics = cpuDto.getIntergratedGraphics();
        this.chipset = cpuDto.getChipset();
        this.price = cpuDto.getPrice();
        this.amazonLink = cpuDto.getAmazonLink();
    }
}