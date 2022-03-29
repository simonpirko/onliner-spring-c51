package org.onliner.spring.c51.entity.phone;

import org.onliner.spring.c51.enums.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Radiotelephone extends Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PhoneConnection phoneConnection;
    private PhoneKit phoneKit;
    private BaseType baseType;
    private Screen screen;

    public Radiotelephone(Material phoneCaseMaterial, Color phoneCaseColor, Brand brand, PhoneConnection phoneConnection, PhoneKit phoneKit, BaseType baseType, Screen screen) {
        super(phoneCaseMaterial, phoneCaseColor, brand);
        this.phoneConnection = phoneConnection;
        this.phoneKit = phoneKit;
        this.baseType = baseType;
        this.screen = screen;
    }

    public Radiotelephone(PhoneConnection phoneConnection, PhoneKit phoneKit, BaseType baseType, Screen screen) {
        this.phoneConnection = phoneConnection;
        this.phoneKit = phoneKit;
        this.baseType = baseType;
        this.screen = screen;
    }

    public Radiotelephone() {
    }

    public Long getId() {
        return id;
    }


    public PhoneConnection getPhoneConnection() {
        return phoneConnection;
    }

    public void setPhoneConnection(PhoneConnection phoneConnection) {
        this.phoneConnection = phoneConnection;
    }

    public PhoneKit getPhoneKit() {
        return phoneKit;
    }

    public void setPhoneKit(PhoneKit phoneKit) {
        this.phoneKit = phoneKit;
    }

    public BaseType getBaseType() {
        return baseType;
    }

    public void setBaseType(BaseType baseType) {
        this.baseType = baseType;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Radiotelephone that = (Radiotelephone) o;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, phoneConnection, phoneKit, baseType, screen);
    }

    @Override
    public String toString() {
        return "Radiotelephone{" +
                "name" + getName() +
                ", id= " + id +
                ", phoneCaseMaterial=" + getPhoneCaseMaterial() +
                ", phoneCaseColor=" + getPhoneCaseColor() +
                ", brand=" + getBrand() +
                ", phoneConnection=" + phoneConnection +
                ", phoneKit=" + phoneKit +
                ", baseType=" + baseType +
                ", screen=" + screen +
                '}';
    }
}
