package com.example.vacation_calculator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class VacationCalculatorServiceTest {

    private final VacationCalculatorService service = new VacationCalculatorService();

    @Test
    public void testCalculateVacationPay() {
        double averageSalary = 50000;
        int vacationDays = 10;
        double result = service.calculateVacationPay(averageSalary, vacationDays);
        assertEquals(1422.07, result, 0.01);
    }

    @Test
    public void testCalculateVacationPayWithDates() {
        double averageSalary = 50000;
        LocalDate startDate = LocalDate.of(2024, 5, 1);
        int vacationDays = 10;
        double result = service.calculateVacationPayWithDates(averageSalary, startDate, vacationDays);
        assertEquals(995.44, result, 0.01);
    }
}
