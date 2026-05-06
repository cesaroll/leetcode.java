import java.util.ArrayDeque;
import java.util.Queue;

class MovingAverage {

    private final Queue<Integer> window;
    private final int maxSize;
    private double sum = 0.0;

    public static void main(String[] args) {
        var nums = new int[] {1, 10, 3, 5};
        
        var movAvg = new MovingAverage(3);

        for (int i=0; i< nums.length; i++) {
            System.out.printf("%.1f ", movAvg.Next(nums[i]));
        }
        System.out.println();
    }

    public MovingAverage(int maxSize) {
        this.maxSize = maxSize;
        this.window = new ArrayDeque<Integer>(maxSize);
    }

    public double Next(int val) {
        window.add(val);
        sum += val;

        if (window.size() > maxSize) {
            sum -= window.poll();
        }

        return sum / window.size();
    }

}