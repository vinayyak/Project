package com.vinni.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "STATE_CITY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StateCity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SC", unique = true)
    private int idSC;

    @Column(name = "STATE")
    @OneToOne
    private States state;

    @Column(name = "CITY")
    @OneToOne
    private Cities city;
}
