package org.dkustudy.devears.api.domain.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends AbstractEntity {

    @Column
    private String email;

}
