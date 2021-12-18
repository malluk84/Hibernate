package org.example.dao;

import org.example.HibernateFactory;
import org.example.model.Actor;

public class ActroDao extends EntityDao<Actor>{
    public ActroDao(HibernateFactory hibernateFactory) {
        super(hibernateFactory, Actor.class);

    }
}
