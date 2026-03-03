package ru.netology;

import java.util.Arrays; // нужен для сортировки массива

// Менеджер хранения и поиска авиабилетов
public class AviaSouls {

    // Массив, в котором хранятся билеты
    private Ticket[] tickets = new Ticket[0];

    // Вспомогательный метод для добавления билета в массив
    // current — текущий массив
    // ticket — новый билет
    private Ticket[] addToArray(Ticket[] current, Ticket ticket) {

        // создаём новый массив на 1 элемент больше
        Ticket[] tmp = new Ticket[current.length + 1];

        // копируем старые элементы
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }

        // добавляем новый билет в конец
        tmp[tmp.length - 1] = ticket;

        return tmp;
    }

    // Публичный метод добавления билета
    public void add(Ticket ticket) {
        tickets = addToArray(tickets, ticket);
    }

    // Метод возвращает все билеты
    public Ticket[] findAll() {
        return tickets;
    }

    // Метод поиска билетов по маршруту
    public Ticket[] search(String from, String to) {

        Ticket[] result = new Ticket[0]; // массив для подходящих билетов

        for (Ticket ticket : tickets) {

            // если совпадает город отправления и прибытия
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {

                // добавляем билет в результат
                result = addToArray(result, ticket);
            }
        }

        // сортируем результат по умолчанию (по цене)
        Arrays.sort(result);

        return result;
    }
    // Метод поиска с использованием переданного компаратора
    public Ticket[] search(String from, String to, java.util.Comparator<Ticket> comparator) {

        Ticket[] result = new Ticket[0];

        for (Ticket ticket : tickets) {
            if (ticket.getFrom().equals(from) && ticket.getTo().equals(to)) {
                result = addToArray(result, ticket);
            }
        }

        // сортировка с использованием переданного компаратора
        java.util.Arrays.sort(result, comparator);

        return result;
    }
}