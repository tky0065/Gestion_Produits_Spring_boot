package com.example.produits.entities;

import org.springframework.data.rest.core.config.Projection;


/*
 * Les projection permet de limiter affichages des donnees
 * par exemple si l'on veut afficher seulement le nom des produits uniquement d'un table (Entiter )
 */
@Projection(name = "nomProd", types = {Produit.class})
public interface ProduitProjection {

	public String getNomProduit();
}
