package com.vinni.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "STATE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "STATE_NO", unique = true)
    private Long stateNo;

    @Column(name = "STATE_NAME")
    private String stateName;

    @OneToMany(mappedBy = "state", cascade = CascadeType.ALL)
    private Set<City> cities;

    public Set<City> getCities() {
        return cities;
    }
}
