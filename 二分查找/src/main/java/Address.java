import java.util.ArrayList;
import java.util.Comparator;

public class Address {

  public static int find(ArrayList<String> array, String aim) {
    return -1;
  }

  public static void main(String[] args) {
    ArrayList<String> array = new ArrayList<>();
    array.add("Allen");
    array.add("Emma");
    array.add("James");
    array.add("Jeanne");
    array.add("Kelly");
    array.add("Kevin");
    array.add("Mary");
    array.add("Natasha");
    array.add("Olivia");
    array.add("Rose");

    int result1 = find(array, "Kelly");
    if (result1 == -1) {
      System.out.println("Kelly 不存在名单中");
    } else {
      System.out.println("Kelly 存在名单中，位置是 " + result1);
    }

    int result2 = find(array, "Edith");
    if (result2 == -1) {
      System.out.println("Edith 不存在名单中");
    } else {
      System.out.println("Edith 存在名单中，位置是 " + result2);
    }
  }
}
