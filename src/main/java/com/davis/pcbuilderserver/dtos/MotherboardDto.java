package com.davis.pcbuilderserver.dtos;

import com.davis.pcbuilderserver.entities.Motherboard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MotherboardDto implements Serializable {
    private Long id;

    private String brand;

    private String name;

    private String socket;

    private Integer ramSlots;

    private String price;

    private String amazonLink;

    @Override
    public String toString() {
        return "pcbuilder.Motherboard{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", socket='" + socket + '\'' +
                ", ramSlots=" + ramSlots +
                ", price='" + price + '\'' +
                ", amazonLink='" + amazonLink + '\'' +
                '}';
    }

    public MotherboardDto (Motherboard motherboard)
    {
        this.id = motherboard.getId();
        this.brand = motherboard.getBrand();
        this.name = motherboard.getName();
        this.socket = motherboard.getSocket();
        this.ramSlots = motherboard.getRamSlots();
        this.price = motherboard.getPrice();
        this.amazonLink = motherboard.getAmazonLink();
    }
}
