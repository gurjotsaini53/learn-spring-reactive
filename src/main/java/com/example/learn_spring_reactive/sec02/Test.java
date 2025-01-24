package com.example.learn_spring_reactive.sec02;

public class Test {

    public static void main(String[] args) {
        Integer a = 128;
        Integer b = 128;
        System.out.println(a == b); // false

        Integer x = 1;
        Integer y = 1;
        System.out.println(x == y); // true
    }
}


🚀 Java Developers: Have You Noticed This Integer Quirk?



        🤔 Why does this happen?

Java uses a concept called Integer Caching to optimize memory for frequently used values.

For integers between -128 and 127, Java maintains a cache, and variables within this range point to the same object in memory. Hence, x == y is true.

For integers outside this range (e.g., 128), new objects are created, so a == b is false as they reference different objects.

💡 Key takeaway:

When comparing wrapper types like Integer, always use .equals() for value comparison instead of ==, unless you're certain about the caching behavior.

Have you ever encountered this in your code? Share your thoughts or experiences in the comments! 👇

        #Java #ProgrammingTips #SoftwareDevelopment #CodeOptimization