package org.onliner.spring.c51.entity.phone;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.onliner.spring.c51.enums.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;


@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity

public class Smartphone extends Phone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private RAM ram;
    private Storage storage;
    private DisplayResolution displayResolution;
    private OS os;
    private Platform platform;


}
