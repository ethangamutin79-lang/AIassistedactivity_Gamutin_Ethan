/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package livecoding;

import java.util.Scanner;

/**
 *
 * @author ethan
 */
public class Livecoding {

    // PROBLEM 1: Compute Average
    public static double computeAverage(int total, int count) {
        if (count <= 0) {
            return 0.0;
        }

        return (double) total / count;
    }

    // PROBLEM 2 - PART A: Count Passing using a loop
    public static int countPassing(int[] grades, int passingMark) {
        int count = 0;

        for (int i = 0; i < grades.length; i++) {
            if (grades[i] >= passingMark) {
                count++;
            }
        }

        return count;
    }

    // PROBLEM 2 - PART B: Count Passing using recursion
    public static int countPassingRecursive(int[] grades, int passingMark, int index) {
        if (index >= grades.length) {
            return 0;
        }

        if (grades[index] >= passingMark) {
            return 1 + countPassingRecursive(grades, passingMark, index + 1);
        } else {
            return countPassingRecursive(grades, passingMark, index + 1);
        }
    }

    // PROBLEM 3: Factorial using recursion
    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        input.useDelimiter("[^0-9-]+");

        // PROBLEM 1
        System.out.println("PROBLEM 1: COMPUTE AVERAGE");

        int a = input.nextInt();
        int b = input.nextInt();

        double average = computeAverage(a, b);

        System.out.println("Average: " + average);

        // 1. The method needs double or a cast to allow decimal answers  instead of removing the decimal places during division.
        // 2. Without the count <= 0 guard, the program could perform an invalid division, causing an error or an undefined result.


        // PROBLEM 2
        System.out.println("\nPROBLEM 2: COUNT PASSING GRADES");

        int[] grades = new int[5];

        System.out.println("Enter 5 grades:");

        for (int i = 0; i < grades.length; i++) {
            grades[i] = input.nextInt();
        }

        System.out.print("Enter passing mark: ");
        int passingMark = input.nextInt();

        // Part A: Using a loop
        int resultA = countPassing(grades, passingMark);
        System.out.println("Part A: " + resultA);

        // Part B: Using recursion
        int resultB = countPassingRecursive(grades, passingMark, 0);
        System.out.println("Part B: " + resultB);
        //1.Each recursive call increases index by 1 to check the next grade in the array until all grades have been checked.
        //2.Without the base case, the recursion would continue indefinitely, eventually causing a StackOverflowError.

        // PROBLEM 3
        System.out.println("\nPROBLEM 3: FACTORIAL");

        int number = input.nextInt();

        int result = factorial(number);

        System.out.println("Factorial: " + result);
        //1.One wrong return made every result wrong because the base case is used to stop recursion, and returning 0 instead of 1 makes the entire multiplication result zero.
        //2.factorial(-2) causes infinite recursion because the number keeps decreasing and never reaches the base case (n == 0), eventually resulting in a StackOverflowError.
    }
        //I used AI as a guide to help me understand how to write the Java code for each problem. I asked prompts about creating methods, using loops, working with arrays, 
        //and understanding recursion. AI provided hints and examples that helped me figure out how to structure my code. For example, one hint I received was to increase the 
        //index by 1 in every recursive call so the program could move to the next element in the array. It also reminded me to include a base case to stop the recursion once 
        //all elements had been checked. I also asked for explanations when I encountered unfamiliar concepts, such as using double, setting a base case, and increasing the 
        //index in recursive calls. Instead of simply copying the answers, I used the hints to understand the mistakes, trace the code, and make corrections myself.
}