package com.example.vacation_calculator;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@RestController
public class VacationCalculatorController {

    private final VacationCalculatorService vacationCalculatorService;

    public VacationCalculatorController(VacationCalculatorService vacationCalculatorService) {
        this.vacationCalculatorService = vacationCalculatorService;
    }
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @GetMapping("/calculate")
    public double calculateVacationPay(
            @RequestParam double averageSalary,
            @RequestParam int vacationDays,
            @RequestParam(required = false) String startDate) {

        if (startDate == null || startDate.isEmpty()) {
            return vacationCalculatorService.calculateVacationPay(averageSalary, vacationDays);
        }
        LocalDate vacationStartDate = LocalDate.parse(startDate, DATE_FORMATTER);
        return vacationCalculatorService.calculateVacationPayWithDates(averageSalary, vacationStartDate, vacationDays);
    }
}
