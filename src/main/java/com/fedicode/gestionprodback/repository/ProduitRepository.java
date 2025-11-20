package com.fedicode.gestionprodback.repository;

import com.fedicode.gestionprodback.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
