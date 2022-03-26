package org.onliner.spring.c51.entity.phone.mobile;
import org.onliner.spring.c51.entity.phone.Phone;

import org.onliner.spring.c51.enums.*;

import javax.persistence.Entity;

@Entity
public class Smartphone extends Phone{

    private String modelName;
    private RAM ram;
    private Storage storage;
    private DisplayResolution displayResolution;
    private OS os;
    private Platform platform;

    public Smartphone(Material phoneCaseMaterial, Color phoneCaseColor, Brand brand, String modelName, RAM ram, Storage storage, DisplayResolution displayResolution, OS os, Platform platform) {
        super(phoneCaseMaterial, phoneCaseColor, brand);
        this.modelName = modelName;
        this.ram = ram;
        this.storage = storage;
        this.displayResolution = displayResolution;
        this.os = os;
        this.platform = platform;
    }

    public Smartphone(String modelName, RAM ram, Storage storage, DisplayResolution displayResolution, OS os, Platform platform) {
        this.modelName = modelName;
        this.ram = ram;
        this.storage = storage;
        this.displayResolution = displayResolution;
        this.os = os;
        this.platform = platform;
    }

    public Smartphone() {

    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public DisplayResolution getDisplayResolution() {
        return displayResolution;
    }

    public void setDisplayResolution(DisplayResolution displayResolution) {
        this.displayResolution = displayResolution;
    }

    public OS getOs() {
        return os;
    }

    public void setOs(OS os) {
        this.os = os;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    @Override
    public String toString() {
        return "Smartphone{" +
                "name" + getName() +
                ", modelName='" + modelName + '\'' +
                ", phoneCaseMaterial=" + getPhoneCaseMaterial() +
                ", phoneCaseColor=" + getPhoneCaseColor() +
                ", brand=" + getBrand() +
                ", ram=" + ram +
                ", storage=" + storage +
                ", displayResolution=" + displayResolution +
                ", os=" + os +
                ", platform=" + platform +
                '}';
    }
}
