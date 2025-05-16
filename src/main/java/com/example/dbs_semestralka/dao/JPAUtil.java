package com.example.dbs_semestralka.dao;

import jakarta.persistence.*;

public class JPAUtil {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("default");

    public static EntityManager createEntityManager() {
        return emf.createEntityManager();
    }
}
