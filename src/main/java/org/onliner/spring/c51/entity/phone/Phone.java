package org.onliner.spring.c51.entity.phone;
import org.onliner.spring.c51.entity.Product;
import org.onliner.spring.c51.enums.Brand;
import org.onliner.spring.c51.enums.Color;
import org.onliner.spring.c51.enums.Material;

import javax.persistence.MappedSuperclass;
import java.util.Objects;

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


    public Phone() {

    }
    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Material getPhoneCaseMaterial() {
        return phoneCaseMaterial;
    }

    public void setPhoneCaseMaterial(Material phoneCaseMaterial) {
        this.phoneCaseMaterial = phoneCaseMaterial;
    }

    public Color getPhoneCaseColor() {
        return phoneCaseColor;
    }

    public void setPhoneCaseColor(Color phoneCaseColor) {
        this.phoneCaseColor = phoneCaseColor;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Phone phone = (Phone) o;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), modelName, phoneCaseMaterial, phoneCaseColor, brand);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "name" + getName() +
                ", modelName='" + modelName + '\'' +
                ", phoneCaseMaterial=" + phoneCaseMaterial +
                ", phoneCaseColor=" + phoneCaseColor +
                ", brand=" + brand +
                '}';
    }

}