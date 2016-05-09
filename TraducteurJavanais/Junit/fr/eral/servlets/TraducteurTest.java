package fr.eral.servlets;

import static org.junit.Assert.*;

import org.junit.Test;

import fr.eral.javaClasses.FrToJav;
import fr.eral.javaClasses.JavToFr;

public class TraducteurTest {

	
	@Test
	public void tradFrToJav() {
		
		FrToJav frToJav = new FrToJav();
		
		assertEquals("bavonjavour",frToJav.tradFrToJav("bonjour") );
		
		assertEquals("chavantave",frToJav.tradFrToJav("chante") );

		assertEquals("mavoyaven",frToJav.tradFrToJav("moyen") );
		
		assertEquals("avexavemplave",frToJav.tradFrToJav("exemple") );
		
		assertEquals("avau",frToJav.tradFrToJav("au") );
		
		assertEquals("aven avavavant",frToJav.tradFrToJav("en avant") );
		
		assertEquals("AVEN AVAVAVANT",frToJav.tradFrToJav("EN AVANT") );
	}
	
	
	@Test
	public void tradJavToFr() {
		
		JavToFr javToFr = new JavToFr();
		
		assertEquals("bonjour",javToFr.tradJavToFr("bavonjavour") );
		
		assertEquals("chante",javToFr.tradJavToFr("chavantave") );

		assertEquals("moyen",javToFr.tradJavToFr("mavoyaven") );
		
		assertEquals("exemple",javToFr.tradJavToFr("avexavemplave") );
		
		assertEquals("au",javToFr.tradJavToFr("avau") );
		
		assertEquals("en avant",javToFr.tradJavToFr("aven avavavant") );
		
		assertEquals("EN AVANT",javToFr.tradJavToFr("AVEN AVAVAVANT") );
	}

}
