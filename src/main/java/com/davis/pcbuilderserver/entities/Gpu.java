package com.davis.pcbuilderserver.entities;

import com.davis.pcbuilderserver.dtos.GpuDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "gpus")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "Gpu_sequence", initialValue = 72)
public class Gpu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Gpu_sequence")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "name")
    private String name;

    @Column(name = "chipset")
    private String chipset;

    @Column(name = "memory")
    private String memory;

    @Column(name = "baseClock")
    private String baseClock;

    @Column(name = "boostClock")
    private String boostClock;

    @Column(name = "price")
    private String price;

    @Column(name = "amazon_link")
    private String amazonLink;

    @Override
    public String toString() {
        return "pcbuilder.GPU{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", chipset='" + chipset + '\'' +
                ", memory='" + memory + '\'' +
                ", baseClock='" + baseClock + '\'' +
                ", boostClock='" + boostClock + '\'' +
                ", price='" + price + '\'' +
                ", amazonLink='" + amazonLink + '\'' +
                '}';
    }

    public Gpu (GpuDto gpuDto)
    {
        this.id = gpuDto.getId();
        this.brand = gpuDto.getBrand();
        this.name = gpuDto.getName();
        this.chipset = gpuDto.getChipset();
        this.memory = gpuDto.getMemory();
        this.baseClock = gpuDto.getBaseClock();
        this.boostClock = gpuDto.getBoostClock();
        this.price = gpuDto.getPrice();
        this.amazonLink = gpuDto.getAmazonLink();
    }
}
