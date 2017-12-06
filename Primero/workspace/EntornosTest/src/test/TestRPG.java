package test;

import static org.junit.Assert.*;
import org.junit.Test;

import arena.Arena;
import personajes.*;

public class TestRPG {

	@Test
	public void testCombate() {
		Personaje guerreroFuerte = new Guerrero("GerreroCachas", 50, 30);
		Personaje guerreroDebil = new Guerrero("Guerrero", 10, 10);
		Arena arena = new Arena();
		assertEquals(guerreroFuerte, arena.combate(guerreroFuerte, guerreroDebil));
	}
	
	@Test
	public void testGolpe() {
		Personaje guerreroFuerte = new Guerrero("GerreroCachas", 50, 30);
		Personaje guerreroDebil = new Guerrero("Guerrero", 10, 10);
		guerreroFuerte.atacar(guerreroDebil);
		assertEquals(100 - guerreroFuerte.getFuerzaAtaque() * 2 + guerreroDebil.getFuerzaDefensa(), guerreroDebil.getVida());
	}
	
	@Test
	public void testCuracion() {
		Sanador sanador = new Sanador("Botiquín 2.0", 5, 30);
		sanador.setVida(10);
		sanador.sanar(sanador);
		assertEquals(100, sanador.getVida());
	}

}
