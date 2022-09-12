package Homework.Homework7_ReflectionAPI;
/*
Создать класс, который может выполнять «тесты», в качестве тестов выступают классы с наборами методов с аннотациями @Test.
Для этого у него должен быть статический метод start(), которому в качестве параметра передается или объект типа Class, или имя класса.
Из «класса-теста» вначале должен быть запущен метод с аннотацией @BeforeSuite, если такой имеется, далее запущены методы с аннотациями @Test, а по завершению всех тестов – метод с аннотацией @AfterSuite.
К каждому тесту необходимо также добавить приоритеты (int числа от 1 до 10), в соответствии с которыми будет выбираться порядок их выполнения, если приоритет одинаковый, то порядок не имеет значения.
Методы с аннотациями @BeforeSuite и @AfterSuite должны присутствовать в единственном экземпляре, иначе необходимо бросить RuntimeException при запуске «тестирования».
 */

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestsMain {
    public static void main(String[] args) {
        Class Test1 = Homework.Homework7_ReflectionAPI.Test1.class;
        start(Test1);
    }
    public static void start (Class testClass) {
        ArrayList <Method> methods = new ArrayList<>(List.of(testClass.getDeclaredMethods()));
        Method currentMethod;
        //Проверка, есть ли нужное количество методов before & after
        try {
            int beforeSuitCounter = 0;
            int afterSuitCounter = 0;
            for (Method o: methods) {
                currentMethod = o;
                if (currentMethod.getAnnotation(BeforeSuite.class) != null) {
                    beforeSuitCounter++;
                }
                if (currentMethod.getAnnotation(AfterSuite.class) != null) {
                    afterSuitCounter++;
                }
            }
            if (beforeSuitCounter != 1 || afterSuitCounter != 1) {
                throw new RuntimeException("Exceeded amount of beforeSuit and afterSuit methods!");
            }
            //Выполнение Before suit
            for (Method o: methods) {
                currentMethod = o;
                if (currentMethod.getAnnotation(BeforeSuite.class) != null) {
                    currentMethod.invoke(testClass, null);
                }
            }
            //Выполнение Test
            for (int i = 0; i < 11; i++) {
                for (Method o: methods) {
                    currentMethod = o;
                if (currentMethod.getAnnotation(Test.class) != null && currentMethod.getAnnotation(Test.class).priority() == i) {
                    currentMethod.invoke(testClass, null);
                }
            }
            }
            //Выполнение after
            for (Method o: methods) {
                currentMethod = o;
                if (currentMethod.getAnnotation(AfterSuite.class) != null) {
                    currentMethod.invoke(testClass, null);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
