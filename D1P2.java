import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.io.FileNotFoundException;

public class D1P2{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("Enter file name: ");
    String fileName = in.nextLine();

    try{
      File file = new File(fileName);
      Scanner fileReader = new Scanner(file);
      List<Integer> left = new ArrayList<>();
      List<Integer> right = new ArrayList<>();

      while (fileReader.hasNextLine()){
        left.add(fileReader.nextInt());
        right.add(fileReader.nextInt());
      }

      Map<Integer, Integer> frequencyByLocation = new HashMap<>();
      for (Integer num : right){
        if (!frequencyByLocation.containsKey(num)){
          frequencyByLocation.putIfAbsent(num, 1);
        }
        else{
          frequencyByLocation.computeIfPresent(num, (key, val) -> val + 1);
        }
      }

      int totalSimilarityScore = 0;
      for (Integer location : left){
        totalSimilarityScore += (location * frequencyByLocation.getOrDefault(location, 0));
      }

      System.out.println("Total similarity score: " + totalSimilarityScore);
    }
    catch (FileNotFoundException e){
      System.out.println("File not found!");
    }

  }
}