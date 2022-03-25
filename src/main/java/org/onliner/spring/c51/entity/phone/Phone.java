package org.onliner.spring.c51.entity.phone;
import org.onliner.spring.c51.entity.Product;
import org.onliner.spring.c51.entity.phone.mobile.enums.Brand;
import org.onliner.spring.c51.entity.phone.mobile.enums.Color;
import org.onliner.spring.c51.entity.phone.mobile.enums.PhoneCaseMaterial;

public abstract class Phone extends Product {

    private PhoneCaseMaterial phoneCaseMaterial;
    private Color phoneCaseColor;
    private Brand brand;


}
