package loopcontrol;

public class LoopControl {
  public static void main(String[] args) {
    int[] nums = { 0, 1, 2, 3, 4, 5 };
    for (int i = 0; i < nums.length; i++) {
      System.out.println(nums[i]);
    }

    for (int i : nums) {
      System.out.println(i);
    }
  }
}