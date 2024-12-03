import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class D2{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    System.out.print("Enter file name: ");
    String fileName = in.nextLine();

    try{
      File file = new File(fileName);
      Scanner fileReader = new Scanner(file);

      int count = 0;
      while (fileReader.hasNextLine()){
        String line = fileReader.nextLine();
        ArrayList<Integer> report = createReport(line);
        if (isStrictlyMonotonic(report) && hasSafeVariance(report)){
          count++;
        }
      }

      System.out.println("Number of safe reports: " + count);
    }
    catch (FileNotFoundException e){
      System.out.println("File not found!");
    }
  }

  private static ArrayList<Integer> createReport(String line){
    // from https://stackoverflow.com/questions/225337/how-to-split-a-string-with-any-whitespace-chars-as-delimiters
    String[] report = line.split("\\s+");
    ArrayList<Integer> reportList = new ArrayList<>();

    for (String level : report){
      reportList.add(Integer.parseInt(level));
    }

    return reportList;
  }

  private static boolean isStrictlyMonotonic(ArrayList<Integer> report){
    // check trend using first two values in the report
    int diff = report.get(1) - report.get(0);

    if (diff == 0){
      return false;
    }

    for (int i = 2; i < report.size(); i++){
      int currDiff = report.get(i) - report.get(i - 1);

      if (diff > 0 && currDiff <= 0){
        return false;
      }
      else if (diff < 0 && currDiff >= 0){
        return false;
      }
    }
    return true;
  }

  private static boolean hasSafeVariance(ArrayList<Integer> report){
    for (int i = 1; i < report.size(); i++){
      int diff = Math.abs(report.get(i) - report.get(i - 1));

      if (!(diff >= 1 && diff <= 3)){
        return false;
      }
    }
    return true;
  }
}