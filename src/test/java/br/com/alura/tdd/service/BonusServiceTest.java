package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {

/** Forma para capturar a exception para comparar se a mensagem foi lançada corretamente
//        try {
//            service.calcularBonus(new Funcionario("Elayne", LocalDate.now(), new BigDecimal("25000")));
//            fail("Não deu a exception!");
//        } catch (Exception e) {
//            assertEquals("Funcionário com salário maior que R$10.000,00 reais não pode receber bônus!", e.getMessage());
//      }
 */
        BonusService service = new BonusService();
        assertThrows(IllegalArgumentException.class,
                () -> service.calcularBonus(new Funcionario("Elayne", LocalDate.now(), new BigDecimal("25000"))));

    }

    @Test
    void bonusDeveriaSer10PorCentoDoSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Elayne", LocalDate.now(), new BigDecimal("2500.00")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSer10PorCentoParaSalarioDeExatamente10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Elayne", LocalDate.now(), new BigDecimal("10000.00")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }

}