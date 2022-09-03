package Homework.Homework5_Threads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
        public static final int CARS_COUNT = 4;
        public static Car winner;
        static CountDownLatch startLatch;
        static CountDownLatch finishLatch;
        public static void main(String[] args) {
            startLatch = new CountDownLatch(CARS_COUNT);
            finishLatch = new CountDownLatch(CARS_COUNT);
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
            Race race = new Race(new Road(60), new Tunnel(), new Road(40));
            Car[] cars = new Car[CARS_COUNT];
            for (int i = 0; i < cars.length; i++) {
                cars[i] = new Car(race, 20 + (int) (Math.random() * 10));
            }
            for (int i = 0; i < cars.length; i++) {
                new Thread(cars[i]).start();
            }
            try {
                startLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            try {
                finishLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }
    }
