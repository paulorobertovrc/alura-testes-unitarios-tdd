package br.com.alura.tdd.service;

import java.math.BigDecimal;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;

public class ReajusteService {

    public void concederReajuste(Funcionario func, Desempenho desempenho) {
        BigDecimal reajuste = desempenho.percentualReajuste().multiply(func.getSalario());
        func.reajustarSalario(reajuste);
    }
}
