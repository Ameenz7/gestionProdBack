package com.fedicode.gestionprodback.service;

import com.fedicode.gestionprodback.entity.Produit;

import java.util.List;
import java.util.Optional;

public interface IProduitService {
    List<Produit> getAllProduits();
    Optional<Produit> getProduitById(Long id);
    Produit saveProduit(Produit produit);
    void deleteProduit(Long id);
    Produit updateProduit(Long id, Produit produit);
}
