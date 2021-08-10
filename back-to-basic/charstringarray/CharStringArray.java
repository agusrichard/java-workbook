package charstringarray;

public class CharStringArray {
  public static void main(String[] args) {
    System.out.println("Sekardayu Hana Pradiani");
    int[] myNums = { 1, 2, 3, 4, 5 };

    printArray(myNums);
  }

  public static int[] doubleme(int[] nums) {
    int[] newnums = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      newnums[i] = nums[i] * 2;
    }

    return newnums;
  }

  public static void printArray(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }
  }
}
