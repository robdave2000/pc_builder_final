package com.davis.pcbuilderserver.entities;

import com.davis.pcbuilderserver.dtos.PsuDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "psus")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "Psu_sequence", initialValue = 85)
public class Psu {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Psu_sequence")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "modular")
    private String modular;

    @Column(name = "efficiency")
    private String efficiency;

    @Column(name = "wattage")
    private String wattage;

    @Column(name = "price")
    private String price;

    @Column(name = "amazon_link")
    private String amazonLink;

    @Override
    public String toString() {
        return "PSU{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", modular='" + modular + '\'' +
                ", efficiency='" + efficiency + '\'' +
                ", wattage='" + wattage + '\'' +
                ", price='" + price + '\'' +
                ", amazonLink='" + amazonLink + '\'' +
                '}';
    }

    public Psu (PsuDto psuDto)
    {
        this.id = psuDto.getId();
        this.brand = psuDto.getBrand();
        this.name = psuDto.getName();
        this.type = psuDto.getType();
        this.modular = psuDto.getModular();
        this.efficiency = psuDto.getEfficiency();
        this.wattage = psuDto.getWattage();
        this.price = psuDto.getPrice();
        this.amazonLink = psuDto.getAmazonLink();
    }
}
