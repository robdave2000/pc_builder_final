package com.davis.pcbuilderserver.entities;

import com.davis.pcbuilderserver.dtos.RamDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "rams")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "Ram_sequence", initialValue = 84)
public class Ram {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Ram_sequence")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "name")
    private String name;

    @Column(name = "speed")
    private String speed;

    @Column(name = "modules")
    private int modules;

    @Column(name = "modulesSize")
    private String modulesSize;

    @Column(name = "cas")
    private String cas;

    @Column(name = "price")
    private String price;

    @Column(name = "amazon_link")
    private String amazonLink;

    @Override
    public String toString() {
        return "RAM{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", speed='" + speed + '\'' +
                ", modules=" + modules +
                ", modulesSize='" + modulesSize + '\'' +
                ", cas='" + cas + '\'' +
                ", price='" + price + '\'' +
                ", amazonLink='" + amazonLink + '\'' +
                '}';
    }

    public Ram (RamDto ramDto)
    {
        this.id = ramDto.getId();
        this.brand = ramDto.getBrand();
        this.name = ramDto.getName();
        this.speed = ramDto.getSpeed();
        this.modules = ramDto.getModules();
        this.modulesSize = ramDto.getModulesSize();
        this.cas = ramDto.getCas();
        this.price = ramDto.getPrice();
        this.amazonLink = ramDto.getAmazonLink();
    }
}
