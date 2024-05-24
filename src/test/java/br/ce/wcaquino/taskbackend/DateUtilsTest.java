package br.ce.wcaquino.taskbackend;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.ce.wcaquino.taskbackend.utils.DateUtils;

public class DateUtilsTest {

    // Teste se a data 1 de janeiro de 2000 é reconhecida como uma data no passado
    @Test
    public void isBefore() {
        LocalDate before = LocalDate.of(2000, 1, 1);
        boolean result = DateUtils.isEqualOrFutureDate(before);
        assertFalse(result);
    }

    // Teste se a data 1 de janeiro de 2100 é reconhecida como uma data no futuro
    @Test
    public void isAfter() {
        LocalDate after = LocalDate.of(2100, 1, 1);
        boolean result = DateUtils.isEqualOrFutureDate(after);
        assertTrue(result);
    }

    // Teste se a data atual é reconhecida como uma data válida (igual ou no futuro)
    @Test
    public void isEquals() {
        LocalDate equal = LocalDate.now();
        boolean result = DateUtils.isEqualOrFutureDate(equal);
        assertTrue(result);
    }

    // Teste se um dia antes da data atual é reconhecido como uma data no passado
    @Test
    public void isRecentPast() {
        LocalDate recentPast = LocalDate.now().minusDays(1);
        boolean result = DateUtils.isEqualOrFutureDate(recentPast);
        assertFalse(result);
    }

    // Teste se um dia após a data atual é reconhecido como uma data no futuro
    @Test
    public void isNearFuture() {
        LocalDate nearFuture = LocalDate.now().plusDays(1);
        boolean result = DateUtils.isEqualOrFutureDate(nearFuture);
        assertTrue(result);
    }

    // Teste se uma data muito distante no futuro é reconhecida como válida
    @Test
    public void isDistantFuture() {
        LocalDate distantFuture = LocalDate.of(3000, 1, 1);
        boolean result = DateUtils.isEqualOrFutureDate(distantFuture);
        assertTrue(result);
    }

    // Teste se uma data muito distante no passado é reconhecida como inválida
    @Test
    public void isDistantPast() {
        LocalDate distantPast = LocalDate.of(1900, 1, 1);
        boolean result = DateUtils.isEqualOrFutureDate(distantPast);
        assertFalse(result);
    }

    // Teste se a data mínima representável é reconhecida como inválida
    @Test
    public void isMinDate() {
        LocalDate minDate = LocalDate.MIN;
        boolean result = DateUtils.isEqualOrFutureDate(minDate);
        assertFalse(result);
    }

    // Teste se a data máxima representável é reconhecida como válida
    @Test
    public void isMaxDate() {
        LocalDate maxDate = LocalDate.MAX;
        boolean result = DateUtils.isEqualOrFutureDate(maxDate);
        assertTrue(result);
    }

    // Teste se um valor nulo lança uma exceção (ajustar a exceção conforme necessário)
    @Test
    public void isNull() {
        assertThrows(NullPointerException.class, () -> {
            DateUtils.isEqualOrFutureDate(null);
        });
    }
}
