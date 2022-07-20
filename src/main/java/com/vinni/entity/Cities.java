package com.vinni.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "CITIES")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDC", unique = true)
    private int idc;

    @Column(name = "CITY")
    private String city;

}
