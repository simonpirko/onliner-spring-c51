package org.onliner.spring.c51.entity;

import lombok.*;

import javax.persistence.*;

@NamedQueries({

        @NamedQuery(name = "Manufacturer.findAll", query = "SELECT m FROM Manufacturer m"),
        @NamedQuery(name = "Manufacturer.findById",
                query = "SELECT m FROM Manufacturer m WHERE m.id = :id")
})

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private long id;

    private String name;
}
