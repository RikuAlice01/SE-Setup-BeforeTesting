package com.se.team00.demo.Repository;

import com.se.team00.demo.Entity.Subclas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public
interface SubclasRepository extends JpaRepository<Subclas, Long> {
    
}