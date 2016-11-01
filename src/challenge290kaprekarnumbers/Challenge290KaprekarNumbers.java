package challenge290kaprekarnumbers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Challenge290KaprekarNumbers {

    public static void main(String[] args) {
        
        // Scanner
        Scanner in = new Scanner(System.in);
        
        // Range Values
        System.out.print("The beginning of your Range: ");
        int bottomRange = in.nextInt();
        System.out.print("The end of the Range: ");
        int topRange = in.nextInt();
        
        // Create a list of numbers in the defined range
        ArrayList<Integer> range = new ArrayList();
        for(int i = bottomRange; i <= topRange; i++){
            range.add(i);
        }
        
        // A for each loop for each item
        for(int item : range){
            int squaredItem = (int) Math.pow(item, 2);
            
            // Checks if the squaredlist has an even amount of digits
            LinkedList<Integer> digits = digitSplitter(squaredItem);
            if(digits.size() % 2 == 0){
                if(CheckNumber(digits) == item){
                    System.out.println(item + " is a Kaprekar Number");
                }
            }
        }
        System.out.println(range.toString());
    }
    
    /**
     * Gets the digits of the squared number and adds it to a Stack
     * @param number
     * @return 
     */
    public static LinkedList<Integer> digitSplitter(int number){
        LinkedList<Integer> digits = new LinkedList();
        
        // Gets the value and changes the number
        while(number > 0){
            digits.push(number % 10);
            number = number / 10;
        }
        return digits;
    }
    
    /**
     * Checks the Number if it is a Kaprekar number
     * @param digits
     * @return 
     */
    public static int CheckNumber(List<Integer> digits){
        int divisor = digits.size() / 2;
        List<Integer> number1 = digits.subList(0, divisor);
        List<Integer> number2 = digits.subList(divisor, digits.size());
        
        int num1 = CreateNumber(number1);
        int num2 = CreateNumber(number2);
        
        return num1 + num2;
    }
    
    /**
     * Creates a Number based off a list of numbers given
     * @param number1
     * @return 
     */
    public static int CreateNumber(List<Integer> number1){
        ArrayList<Integer> list = new ArrayList<Integer>(number1);
        int num1 = 0;
        int count = 0;
        for (int i = number1.size(); i > 0; i--){
            num1 = num1 + (list.get(count) * (int)Math.pow(10, i));
            count++;
        }
        num1 = num1 / 10;
        return num1;
    }
}
