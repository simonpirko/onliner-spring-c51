package org.onliner.spring.c51.entity.phone.mobile;
import org.onliner.spring.c51.entity.phone.Phone;
import org.onliner.spring.c51.entity.phone.mobile.enums.*;

public class MobilePhoneModel extends Phone{

    private String mobilePhoneModelName;
    private Brand brand;
    private DisplayResolution displayResolution;
    private OS os;
    private PhoneCaseMaterial phoneCaseMaterial;
    private Platform platform;
    private RAM[] rams;
    private Storage[] storages;
    private PhoneCaseColor[] phoneCaseColors;

}
