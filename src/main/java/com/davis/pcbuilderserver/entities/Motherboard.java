package com.davis.pcbuilderserver.entities;

import com.davis.pcbuilderserver.dtos.MotherboardDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "motherboards")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "Motherboard_sequence", initialValue = 67)
public class Motherboard {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Motherboard_sequence")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "name")
    private String name;

    @Column(name = "socket")
    private String socket;

    @Column(name = "ramSlots")
    private Integer ramSlots;

    @Column(name = "price")
    private String price;

    @Column(name = "amazon_link")
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

    public Motherboard (MotherboardDto motherboardDto)
    {
        this.id = motherboardDto.getId();
        this.brand = motherboardDto.getBrand();
        this.name = motherboardDto.getName();
        this.socket = motherboardDto.getSocket();
        this.ramSlots = motherboardDto.getRamSlots();
        this.price = motherboardDto.getPrice();
        this.amazonLink = motherboardDto.getAmazonLink();
    }
}
