package com.fedicode.gestionprodback;

import com.fedicode.gestionprodback.entity.Produit;
import com.fedicode.gestionprodback.repository.ProduitRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GestionProdBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionProdBackApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProduitRepository produitRepository) {
        return args -> {
            // Only add initial data if database is empty
            if (produitRepository.count() == 0) {
                produitRepository.save(new Produit(null, "PC", 1299.99, 3));
                produitRepository.save(Produit.builder()
                        .id(null)
                        .nom("Tablette")
                        .prix(599.99)
                        .quantite(5)
                        .build());
            }
        };
    }

}
