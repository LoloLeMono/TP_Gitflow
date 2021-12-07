package ter;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ter.Groupe;
import ter.Sujet;
import ter.cantAddVoeu;

class TestGroupe
{
	
	public Groupe g;
	
	@BeforeEach
	public void init()
	{
		g = new Groupe();
	}
	
	@Test
	void testGroupeIdDeuxGroupes()
	{
		int id = g.getId() + 1;
		Groupe gg = new Groupe();
		assertEquals(id, gg.getId());
	}
	
	/*
	@Test
	void testGroupeVide()
	{
		Groupe gg = new Groupe();
		assertEquals(null, gg.getNom());
	}
	*/
	
	@Test
	void testGroupeToString()
	{
		int id = g.getId();
		assertEquals("(id:"+id+")\n", g.toString());
	}
	/*
	
	@Test
	void testGroupeToStringUnVoeu()
	{
		Sujet s = new Sujet("suj");
		try {
			g.addVoeu(1, s);
		} catch (cantAddVoeu e) {
			e.printStackTrace();
		}
		int id = g.getId();
		assertEquals("(id:"+id+")\n--1: "+s.toString()+"\n", g.toString());
	}
	*/
	
	@Test
	void testGroupeAjouterVoeuOrdreBas()
	{
		cantAddVoeu thrown = assertThrows(cantAddVoeu.class, () -> {g.addVoeu(0, null);});
        assertEquals(thrown.getMessage(),"L'ordre du voeu doit être entre 1 et 5");
	}
	
	@Test
	void testGroupeAjouterVoeuOrdreHaut()
	{
		cantAddVoeu thrown = assertThrows(cantAddVoeu.class, () -> {g.addVoeu(6, null);});
        assertEquals(thrown.getMessage(),"L'ordre du voeu doit être entre 1 et 5");
	}
	
	/*
	
	@Test
	void testGroupeAjouterVoeuCorrect()
	{
		try {
			assertTrue(g.addVoeu(1, null));
		} catch (cantAddVoeu e) {
			assertTrue(false);
			e.printStackTrace();
		}
	}
	
	
	
	@Test
	void testGroupeAjouterVoeuSujetDejaChoisi()
	{
		Sujet s = new Sujet("suj1");
		try {
			assertTrue(g.addVoeu(1, s));
		} catch (cantAddVoeu e) {
			assertTrue(false);
			e.printStackTrace();
		}
		cantAddVoeu thrown = assertThrows(cantAddVoeu.class, () -> {g.addVoeu(2, s);});
        assertEquals(thrown.getMessage(),"Le sujet a déjà été choisi");
	}
	
	
	
	@Test
	void testGroupeAjouterVoeuOrdreDejaRempli()
	{
		Sujet s = new Sujet("suj1");
		Sujet s2 = new Sujet("suj2");
		try {
			assertTrue(g.addVoeu(1, s));
		} catch (cantAddVoeu e) {
			assertTrue(false);
			e.printStackTrace();
		}
		cantAddVoeu thrown = assertThrows(cantAddVoeu.class, () -> {g.addVoeu(1	, s2);});
        assertEquals(thrown.getMessage(),"L'ordre a déjà été rempli");
	}
	
	
	*/
	
	@Test
	void testGroupeSetVoeu()
	{
		HashMap<Integer, Sujet> v = new HashMap<Integer, Sujet>();
		Sujet s = new Sujet("suj1");
		v.put(1, s);
		g.setVoeux(v);
		cantAddVoeu thrown = assertThrows(cantAddVoeu.class, () -> {g.addVoeu(2, s);});
        assertEquals(thrown.getMessage(),"Le sujet a déjà été choisi");
	}
	
}
