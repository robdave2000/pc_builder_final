package com.davis.pcbuilderserver.dtos;

import com.davis.pcbuilderserver.entities.Storage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StorageDto implements Serializable {
    private Long id;

    private String brand;

    private String name;

    private String capacity;

    private String type;

    private String formFactor;

    private String price;

    private String amazonLink;

    public StorageDto(Storage storage)
    {
        this.id = storage.getId();
        this.brand = storage.getBrand();
        this.name = storage.getName();
        this.capacity = storage.getCapacity();
        this.type = storage.getType();
        this.formFactor = storage.getFormFactor();
        this.price = storage.getPrice();
        this.amazonLink = storage.getAmazonLink();
    }
}
