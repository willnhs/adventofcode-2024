import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;

public class D1P1{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("Please enter file name: ");
    String fileName = in.nextLine();

    List<Integer> left = new ArrayList<>();
    List<Integer> right = new ArrayList<>();

    try{
      File file = new File(fileName);
      Scanner fileReader = new Scanner(file);

      while (fileReader.hasNextLine()){
        left.add(fileReader.nextInt());
        right.add(fileReader.nextInt());
      }

      left.sort(null);
      right.sort(null);

      int sum = 0;
      for (int i = 0; i < left.size(); i++){
        int diff = Math.abs(left.get(i) - right.get(i));
        sum += diff;
      }

      System.out.println("Total distance: " + sum);
    }
    catch (FileNotFoundException e){
      System.out.println("File not found!");
    }

  }
}