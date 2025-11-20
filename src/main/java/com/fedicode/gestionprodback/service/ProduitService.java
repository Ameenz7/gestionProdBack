package com.fedicode.gestionprodback.service;

import com.fedicode.gestionprodback.entity.Produit;
import com.fedicode.gestionprodback.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProduitService implements IProduitService {

    private final ProduitRepository produitRepository;

    @Override
    public List<Produit> getAllProduits() {
        return produitRepository.findAll();
    }

    @Override
    public Optional<Produit> getProduitById(Long id) {
        return produitRepository.findById(id);
    }

    @Override
    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public void deleteProduit(Long id) {
        produitRepository.deleteById(id);
    }

    @Override
    public Produit updateProduit(Long id, Produit produit) {
        return produitRepository.findById(id)
                .map(existing -> {
                    existing.setNom(produit.getNom());
                    existing.setPrix(produit.getPrix());
                    existing.setQuantite(produit.getQuantite());
                    return produitRepository.save(existing);
                })
                .orElseThrow(() -> new RuntimeException("Produit not found with id: " + id));
    }

}
