package ru.netology;

import java.util.Objects; // нужен для корректной реализации hashCode и equals


public class Ticket implements Comparable<Ticket> {

    private String from;     // город отправления
    private String to;       // город прибытия
    private int price;       // цена билета
    private int timeFrom;    // время вылета (в минутах)
    private int timeTo;      // время прилёта (в минутах)

    // Конструктор — создаёт новый билет
    public Ticket(String from, String to, int price, int timeFrom, int timeTo) {
        this.from = from;
        this.to = to;
        this.price = price;
        this.timeFrom = timeFrom;
        this.timeTo = timeTo;
    }

    // Геттер для города отправления
    public String getFrom() {
        return from;
    }

    // Геттер для города прибытия
    public String getTo() {
        return to;
    }

    // Геттер для цены
    public int getPrice() {
        return price;
    }

    // Геттер для времени вылета
    public int getTimeFrom() {
        return timeFrom;
    }

    // Геттер для времени прилёта
    public int getTimeTo() {
        return timeTo;
    }

    // Переопределяем equals — чтобы корректно сравнивать билеты
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // если это один и тот же объект
        if (o == null || getClass() != o.getClass()) return false; // если объект другого типа

        Ticket ticket = (Ticket) o;

        return price == ticket.price &&
                timeFrom == ticket.timeFrom &&
                timeTo == ticket.timeTo &&
                Objects.equals(from, ticket.from) &&
                Objects.equals(to, ticket.to);
    }

    // Переопределяем hashCode — обязательно вместе с equals
    @Override
    public int hashCode() {
        return Objects.hash(from, to, price, timeFrom, timeTo);
    }

    // Реализация интерфейса Comparable
// Билеты по умолчанию сравниваются по цене (по возрастанию)
    @Override
    public int compareTo(Ticket other) {

        // this.price - other.price
        // если цена текущего билета меньше — результат будет отрицательный
        // если больше — положительный
        // если равны — 0

        return this.price - other.price;
    }
}