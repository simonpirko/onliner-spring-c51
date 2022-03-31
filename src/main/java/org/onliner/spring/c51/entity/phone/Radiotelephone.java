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

@Data                                                   // ONL-12 : lombok
@NoArgsConstructor                                      // ONL-12 : lombok
@AllArgsConstructor                                     // ONL-12 : lombok
@SuperBuilder                                           // ONL-12 : lombok

@Entity
public class Radiotelephone extends Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private PhoneConnection phoneConnection;
    private PhoneKit phoneKit;
    private BaseType baseType;
    private Screen screen;





}
