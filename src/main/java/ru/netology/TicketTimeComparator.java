package ru.netology;

import java.util.Comparator;

// Компаратор для сравнения билетов по времени в пути
public class TicketTimeComparator implements Comparator<Ticket> {

    @Override
    public int compare(Ticket t1, Ticket t2) {

        // вычисляем длительность полёта для первого билета
        int duration1 = t1.getTimeTo() - t1.getTimeFrom();

        // вычисляем длительность полёта для второго билета
        int duration2 = t2.getTimeTo() - t2.getTimeFrom();

        // если первый летит быстрее → отрицательное число
        // если медленнее → положительное
        // если одинаково → 0
        return duration1 - duration2;
    }
}