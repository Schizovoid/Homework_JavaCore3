package Homework.Homework7_ReflectionAPI;

public class Test1 {

    @BeforeSuite
    public static void printIntro () {
        System.out.println("Here are a bunch of numbers:");
    }
    @Test(priority = 1)
    public static void printFirst () {System.out.println(1);}
    @Test(priority = 2)
    public static void printSecondOrThird () {
        System.out.println(2);
    }
    @Test(priority = 2)
    public static void printThirdOrSecond () {
        System.out.println(3);
    }
    @Test(priority = 7)
    public static void printSeventh () {System.out.println(7);}
    @Test(priority = 10)
    public static void printAlmostLast () {
        System.out.println(10);
    }
    @AfterSuite
    public static void printLast () {
        System.out.println("And that's it!");
    }
}
