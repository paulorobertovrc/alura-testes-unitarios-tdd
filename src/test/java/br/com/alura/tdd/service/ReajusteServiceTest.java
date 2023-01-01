package br.com.alura.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteServiceTest {
    private ReajusteService serv;
    private Funcionario func;

    @BeforeEach
    public void inicializar() {
        this.serv = new ReajusteService();
        this.func = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    public void reajusteDeveriaSerDeTresPorCentoQuandoDesempenhoForADesejar() {
        serv.concederReajuste(func, Desempenho.A_DESEJAR);
        assertEquals("1030.00", func.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorCentoQuandoDesempenhoForBom() {
        serv.concederReajuste(func, Desempenho.BOM);
        assertEquals("1150.00", func.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorCentoQuandoDesempenhoForOtimo() {
        serv.concederReajuste(func, Desempenho.OTIMO);
        assertEquals("1200.00", func.getSalario());
    }
 }
