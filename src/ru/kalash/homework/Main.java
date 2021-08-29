package ru.kalash.homework;

import java.util.*;

/*
        Задание 9.1. Один день из жизни автобуса

        Автобус собирает и высаживает пассажиров на каждой остановке.
        Остановки представлены списком массивов - List<int[]>,
        где каждый из массивов представляет остановку, и состоит из 2 элементов:
        1) количество зашедших в автобус человек
        2) количество вышедших из автобуса человек
        Задача - подсчитать количество людей в автобусе,
        после того как автобус объедет все остановки (т.е. прибудет на конечную).
        Количество не должно оказаться отрицательным.
        Написать решение в функциональном стиле (стримы, лямбды, ...)

 */

public class Main {

    public static void main(String[] args) {
        List<int[]> stops = generateListStops(32, 9);
        System.out.println("Оставшееся количество людей в автобусе:\n" + getCurrentCountInBus(stops));

        //Раскомментировать для просмотра списка остановок
//        System.out.println("Список остановок:");
//        for (int[] s: stops) {
//            System.out.println(Arrays.toString(s));
//        }
    }


    public static int getCurrentCountInBus(List<int[]> stops) {
        return stops.stream().mapToInt(s -> s[0] - s[1]).sum();
    }


    public static ArrayList<int[]> generateListStops(int maxCountInBus, int countStops) {
        ArrayList<int[]> stops = new ArrayList<>();
        Random random = new Random();
        stops.add(new int[]{random.nextInt(maxCountInBus), 0});

        for (int i = 0; i < countStops - 1; i++) {
            int currCountInBus = getCurrentCountInBus(stops);
            int countOut = 0;
            int countIn = 0;

            if (currCountInBus != 0)
                countOut = random.nextInt(currCountInBus);

            if (maxCountInBus - (currCountInBus - countOut) != 0)
                countIn = random.nextInt(maxCountInBus - (currCountInBus - countOut));

            stops.add(new int[]{countIn, countOut});
        }
        return stops;
    }
}

