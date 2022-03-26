package org.onliner.spring.c51.entity.phone;

import org.onliner.spring.c51.entity.phone.Phone;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Radiotelephones extends Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
