package com.example.produits;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.produits.entities.Categorie;
import com.example.produits.entities.Produit;
import com.example.produits.repos.ProduitRepository;

@SpringBootTest
class ProduitsApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	
	@Test 
	public  void testCreateProduit() {
		Produit prod = new Produit(null, "Dell",125000.00,new Date());
		produitRepository.save(prod);
	}

	@Test 
	public void testFindProduit() {
		
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p);
	}
	
	@Test 
	public void testUpdateProduit() {
		 
		Produit p = produitRepository.findById(1L).get();
		p.setPrixProduit(800000.00);
		produitRepository.save(p);
		System.out.println(p);
	}
	@Test 
	public void testDeleteProduit() {
		
		produitRepository.deleteById(1L);;
	}
	@Test 
	public void testFindAllProduitS() {
		
		List <Produit> prod = produitRepository.findAll();
		
		for(Produit p:prod)
			System.out.println(p);
		
	}
	
	@Test 
	public void testFindProduitByNom() {
		
		List<Produit> prods = produitRepository.findByNomProduit("IPHONE");
		
		for(Produit p:prods)
			System.out.println(p);
	}
	
	@Test 
	public void testFindProduitByNomContains() {
		
		List<Produit> prods = produitRepository.findByNomProduitContains("H");
		
		for(Produit p:prods)
			System.out.println(p);
	}
	
	@Test 
	public void testFindProduitByNomPrix() {
		
		List<Produit> prods = produitRepository.findByNomPrix("IPHONE",135000.00 );
		
		for(Produit p:prods)
			System.out.println(p);
	}

	 @Test
	 public void testFindByCategorie() {
		 Categorie cat = new Categorie();
		 cat.setIdCat(1L);
		 
		 List<Produit> prods = produitRepository.findByCategorie(cat);
		 
		 for(Produit p:prods)
			 System.out.println(p);
		 
	 }
	 
	 @Test
	 public void testFindByOrderByNomProduitAsc() {
		
		 List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		 
		 for(Produit p:prods)
			 System.out.println(p);
		 
	 }
	 
	 @Test
	 public void testTrierNomProduit() {
		
		 List<Produit> prods = produitRepository.trierNomPrix();
		 
		 for(Produit p:prods)
			 System.out.println(p);
		 
	 }
}
