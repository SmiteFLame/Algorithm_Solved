import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String line;
    while (!(line = scanner.nextLine()).equals("#")) {
      int aPoints = 0, bPoints = 0;
      int aGames = 0, bGames = 0;
      for (int i = 0; i < line.length(); i++) {
        char point = line.charAt(i);
        if (point == 'A') {
          aPoints++;
        } else {
          bPoints++;
        }
        if ((aPoints >= 4 || bPoints >= 4) && Math.abs(aPoints - bPoints) >= 2) {
          if (aPoints > bPoints) {
            aGames++;
          } else {
            bGames++;
          }
          aPoints = 0;
          bPoints = 0;
        }
      }
      System.out.println("A " + aGames + " B " + bGames);
    }
  }
}