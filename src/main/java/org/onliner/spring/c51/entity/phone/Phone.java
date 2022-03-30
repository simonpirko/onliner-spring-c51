package org.onliner.spring.c51.entity.phone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.onliner.spring.c51.entity.Product;
import org.onliner.spring.c51.enums.Brand;
import org.onliner.spring.c51.enums.Color;
import org.onliner.spring.c51.enums.Material;

import javax.persistence.MappedSuperclass;
import java.util.Objects;


@Data                                           // ONL-12 : lombok
@NoArgsConstructor                              // ONL-12 : lombok
@AllArgsConstructor                             // ONL-12 : lombok
@SuperBuilder
@MappedSuperclass
public abstract class Phone extends Product {

    private String modelName;
    private Material phoneCaseMaterial;
    private Color phoneCaseColor;
    private Brand brand;

    public Phone(Material phoneCaseMaterial, Color phoneCaseColor, Brand brand) {
        this.phoneCaseMaterial = phoneCaseMaterial;
        this.phoneCaseColor = phoneCaseColor;
        this.brand = brand;
    }


}
