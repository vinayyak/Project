package com.vinni.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "CITY")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CITY_NO", unique = true)
    private Long cityNo;

    @Column(name = "CITY_NAME")
    private String cityName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "STATE_NO")
    private State state;
}
