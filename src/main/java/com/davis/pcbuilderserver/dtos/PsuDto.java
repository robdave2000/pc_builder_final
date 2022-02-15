package com.davis.pcbuilderserver.dtos;

import com.davis.pcbuilderserver.entities.Psu;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PsuDto implements Serializable {
    private Long id;

    private String brand;

    private String name;

    private String type;

    private String modular;

    private String efficiency;

    private String wattage;

    private String price;

    private String amazonLink;

    public PsuDto(Psu psu)
    {
        this.id = psu.getId();
        this.brand = psu.getBrand();
        this.name = psu.getName();
        this.modular = psu.getModular();
        this.efficiency = psu.getEfficiency();
        this.wattage = psu.getWattage();
        this.price = psu.getPrice();
        this.amazonLink = psu.getAmazonLink();
    }
}
