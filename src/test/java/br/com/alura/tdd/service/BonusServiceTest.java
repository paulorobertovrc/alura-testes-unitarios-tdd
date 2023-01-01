package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusServiceTest {

	@Test
	public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService serv = new BonusService();
		assertThrows(IllegalArgumentException.class, 
			() -> serv.calcularBonus(new Funcionario("Paulo", LocalDate.now(), new BigDecimal("25000"))));
	}

	@Test
	public void bonusDeveriaSerDezPorCentoDoSalario() {
		BonusService serv = new BonusService();
		BigDecimal bonus = serv.calcularBonus(new Funcionario("Paulo", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.0"), bonus);
	}

	@Test
	public void bonusDeveriaSerDezPorCentoParaSalarioDeExatamenteDezMil() {
		BonusService serv = new BonusService();
		BigDecimal bonus = serv.calcularBonus(new Funcionario("Paulo", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.0"), bonus);
	}
}
