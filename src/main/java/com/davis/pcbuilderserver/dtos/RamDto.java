package com.davis.pcbuilderserver.dtos;

import com.davis.pcbuilderserver.entities.Ram;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RamDto implements Serializable {
    private Long id;

    private String brand;

    private String name;

    private String speed;

    private int modules;

    private String modulesSize;

    private String cas;

    private String price;

    private String amazonLink;

    public RamDto(Ram ram)
    {
        this.id = ram.getId();
        this.brand = ram.getBrand();
        this.name = ram.getName();
        this.speed = ram.getSpeed();
        this.modules = ram.getModules();
        this.modulesSize = ram.getModulesSize();
        this.cas = ram.getCas();
        this.price = ram.getPrice();
        this.amazonLink = ram.getAmazonLink();
    }
}
