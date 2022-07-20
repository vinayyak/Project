package com.vinni.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "STATES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class States {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private int ids;

    @Column(name = "STATE")
    private String state;
}
