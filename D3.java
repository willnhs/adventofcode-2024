import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D3{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("Please enter file name: ");
    String fileName = in.nextLine();

    try{
      File file = new File(fileName);
      BufferedReader fileReader = new BufferedReader(new FileReader(file));

      String line;
      int sum = 0;

      // regex matches were not accurate when using Scanner
      // perhaps due to https://stackoverflow.com/questions/21336425/scanner-reading-only-half-the-no-of-lines-in-a-file
      while ((line = fileReader.readLine()) != null){
        // from https://www.baeldung.com/java-count-regex-matches
        Pattern mul_pattern = Pattern.compile("mul\\(\\d+\\,\\d+\\)");
        Matcher countMulMatches = mul_pattern.matcher(line);
        while (countMulMatches.find()){
          // extract mul expression
          String expression = countMulMatches.group();

          // extract integers from mul expression
          Pattern int_pattern = Pattern.compile("\\d+");
          Matcher numMatches = int_pattern.matcher(expression);
          ArrayList<Integer> nums = new ArrayList<>();
          while (numMatches.find()){
            nums.add(Integer.parseInt(numMatches.group()));
          }

          // calculate product and add to running sum
          int product = nums.get(0) * nums.get(1);
          sum += product;
        }
      }

      System.out.println("Sum of product of mul expressions: " + sum);

    }
    catch (FileNotFoundException e){
      System.out.println("File not found!");
    }
    catch (IOException e){
      System.out.println("An error has occurred. Please contact your administrator");
    }
  }
}