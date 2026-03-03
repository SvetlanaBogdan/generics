package ru.netology;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AviaSoulsTest {

    // Тестируем compareTo (сравнение по цене)
    @Test
    public void testCompareTo() {
        Ticket t1 = new Ticket("Moscow", "Sochi", 1000, 10, 20);
        Ticket t2 = new Ticket("Moscow", "Sochi", 2000, 10, 20);

        // t1 дешевле → должен быть меньше
        assertTrue(t1.compareTo(t2) < 0);

        // t2 дороже → должен быть больше
        assertTrue(t2.compareTo(t1) > 0);
    }

    // Тестируем поиск и сортировку по цене
    @Test
    public void testSearchAndSortByPrice() {

        AviaSouls manager = new AviaSouls();

        Ticket t1 = new Ticket("Moscow", "Sochi", 3000, 10, 20);
        Ticket t2 = new Ticket("Moscow", "Sochi", 1000, 10, 20);
        Ticket t3 = new Ticket("Moscow", "Sochi", 2000, 10, 20);
        Ticket t4 = new Ticket("Moscow", "Kazan", 1500, 10, 20);

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);

        Ticket[] expected = {t2, t3, t1};

        Ticket[] actual = manager.search("Moscow", "Sochi");

        assertArrayEquals(expected, actual);
    }

    // Тестируем поиск с использованием компаратора (по времени)
    @Test
    public void testSearchAndSortByTime() {

        AviaSouls manager = new AviaSouls();
        TicketTimeComparator comparator = new TicketTimeComparator();

        Ticket t1 = new Ticket("Moscow", "Sochi", 3000, 10, 50); // 40 минут
        Ticket t2 = new Ticket("Moscow", "Sochi", 1000, 10, 30); // 20 минут
        Ticket t3 = new Ticket("Moscow", "Sochi", 2000, 10, 60); // 50 минут

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);

        Ticket[] expected = {t2, t1, t3};

        Ticket[] actual = manager.search("Moscow", "Sochi", comparator);

        assertArrayEquals(expected, actual);
    }
}