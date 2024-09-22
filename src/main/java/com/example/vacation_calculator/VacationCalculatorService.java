package com.example.vacation_calculator;

import org.springframework.stereotype.Service;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class VacationCalculatorService {

    private final List<LocalDate> holidays = List.of(
            LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 5, 1)
    );

    public double calculateVacationPay(double averageSalary, int vacationDays) {
        double dailyPay = averageSalary / 12 / 29.3;
        return dailyPay * vacationDays;
    }

    public double calculateVacationPayWithDates(double averageSalary, LocalDate startDate, int vacationDays) {
        double dailyPay = averageSalary / 12 / 29.3;
        int payableDays = 0;
        LocalDate currentDate = startDate;

        for (int i = 0; i < vacationDays; i++) {
            if (!isHolidayOrWeekend(currentDate)) {
                payableDays++;
            }
            currentDate = currentDate.plusDays(1);
        }

        return dailyPay * payableDays;
    }

    private boolean isHolidayOrWeekend(LocalDate date) {
        return holidays.contains(date) || date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
    }
}
