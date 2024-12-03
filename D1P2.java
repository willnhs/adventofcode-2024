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
      ArrayList<Integer> left = new ArrayList<>();
      Map<Integer, Integer> frequencyByLocation = new HashMap<>();

      while (fileReader.hasNextLine()){
        // keep a list of locations encountered in the left column for later processing
        int location = fileReader.nextInt();
        left.add(location);

        // initialize hashmap with newly encountered locations in left column
        frequencyByLocation.putIfAbsent(location, 0);

        // count occurrence of locations in right column and update hashmap accordingly
        int instance = fileReader.nextInt();
        if (frequencyByLocation.containsKey(instance)){
          frequencyByLocation.computeIfPresent(instance, (k, v) -> v + 1);
        }
        else{
          frequencyByLocation.put(instance, 1);
        }
      }

      int totalSimilarityScore = 0;
      for (Integer location : left){
        totalSimilarityScore += location * frequencyByLocation.get(location);
      }

      System.out.println("Total similarity score: " + totalSimilarityScore);
    }
    catch (FileNotFoundException e){
      System.out.println("File not found!");
    }

  }
}