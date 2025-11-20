package com.fedicode.gestionprodback.controller;

import com.fedicode.gestionprodback.entity.Produit;
import com.fedicode.gestionprodback.service.IProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/produits")
@RequiredArgsConstructor
public class ProduitController {

    private final IProduitService produitService;

    @GetMapping
    public ResponseEntity<List<Produit>> getAllProduits() {
        return ResponseEntity.ok(produitService.getAllProduits());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produit> getProduitById(@PathVariable Long id) {
        return produitService.getProduitById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produit> createProduit(@RequestBody Produit produit) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produitService.saveProduit(produit));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Produit produit) {
        return ResponseEntity.ok(produitService.updateProduit(id, produit));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteProduit(@PathVariable Long id) {
        produitService.deleteProduit(id);
        return ResponseEntity.ok(Map.of("message", "Produit supprimé avec succès"));
    }

}
