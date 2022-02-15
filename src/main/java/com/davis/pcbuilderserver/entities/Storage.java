package com.davis.pcbuilderserver.entities;

import com.davis.pcbuilderserver.dtos.StorageDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "storages")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SequenceGenerator(name = "Storage_sequence", initialValue = 98)
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Storage_sequence")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private String capacity;

    @Column(name = "type")
    private String type;

    @Column(name = "formFactor")
    private String formFactor;

    @Column(name = "price")
    private String price;

    @Column(name = "amazon_link")
    private String amazonLink;

    @Override
    public String toString() {
        return "STORAGE{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", name='" + name + '\'' +
                ", capacity='" + capacity + '\'' +
                ", type='" + type + '\'' +
                ", formFactor='" + formFactor + '\'' +
                ", price='" + price + '\'' +
                ", amazonLink='" + amazonLink + '\'' +
                '}';
    }

    public Storage (StorageDto storageDto)
    {
        this.id = storageDto.getId();
        this.brand = storageDto.getBrand();
        this.name = storageDto.getName();
        this.capacity = storageDto.getCapacity();
        this.type = storageDto.getType();
        this.formFactor = storageDto.getFormFactor();
        this.price = storageDto.getPrice();
        this.amazonLink = storageDto.getAmazonLink();
    }
}
