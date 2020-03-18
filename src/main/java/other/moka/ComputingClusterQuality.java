package other.moka;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ComputingClusterQuality {

  /*
   * Complete the 'maximumClusterQuality' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER_ARRAY speed
   *  2. INTEGER_ARRAY reliability
   *  3. INTEGER maxMachines
   */

  public static long maximumClusterQuality(List<Integer> speeds, List<Integer> reliabilities, int maxMachines) {
    // Write your code here
    PriorityQueue<SpeedReliable> speedReliablePriorityQueue = new PriorityQueue<>();
    int maxQuality = 0;
    for (int i = 0; i < speeds.size(); i++) {
      int speed = speeds.get(i);
      int reliable = reliabilities.get(i);
      int quality = speed * reliable;
      if (maxQuality < quality) {
        maxQuality = quality;
      }
      SpeedReliable speedReliable = new SpeedReliable(speed, reliable);
      speedReliablePriorityQueue.add(speedReliable);
    }

    int totalSpeed = 0;
    PriorityQueue<Integer> chosenSpeedPriorityQueue = new PriorityQueue<>();
    while (!speedReliablePriorityQueue.isEmpty()) {
      SpeedReliable speedReliable = speedReliablePriorityQueue.poll();
      if (chosenSpeedPriorityQueue.size() < maxMachines) {
        totalSpeed += speedReliable.speed;
        int quality = totalSpeed * speedReliable.reliability;
        chosenSpeedPriorityQueue.add(speedReliable.speed);
        if (quality > maxQuality) {
          maxQuality = quality;
        }
      } else {
        int leastSpeed = chosenSpeedPriorityQueue.peek();
        int newTotalSpeed = totalSpeed - leastSpeed + speedReliable.speed;
        int quality = newTotalSpeed * speedReliable.reliability;
        if (quality > maxQuality) {
          maxQuality = quality;
          chosenSpeedPriorityQueue.poll();
          chosenSpeedPriorityQueue.add(speedReliable.speed);
          totalSpeed = newTotalSpeed;
        }
      }
    }
    return maxQuality;
  }

  static class SpeedReliable implements Comparable<SpeedReliable> {
    public int speed;
    public int reliability;

    public SpeedReliable(int speed, int reliability) {
      this.speed = speed;
      this.reliability = reliability;
    }

    @Override
    public int compareTo(SpeedReliable o) {
      return o.reliability - this.reliability;
    }
  }

  public static void main(String[] args) {
    ComputingClusterQuality computingClusterQuality = new ComputingClusterQuality();
    List<Integer> speeds = Arrays.asList(743,962,460,732,194,954,9,205,65,175,257,722,913,846,481,384,464,357,358,
        827,586,809,860,34,964,287,426,761,891,874,563,365,781,858,397,188,991,690,852,369,364,272,495,570,723,904,
        985,957,384,304,105,869,785,740,666,873,146,490,770,196,872,31,845,85,584,319,354,56,72,904,964,258,124,598,
        2,816,546,527,343,415,222,975,793,708,93,940,428,204,956,139,495,708,409,296,653,482,608,577,932,393,831,154
        ,105,136,194,225,713,922,438,435,577,734,160,796,813,272,326,921,36,316,76,921,177,313,376,646,258,803,421,
        48,340,607,226,746,699,459,972,9,462,74,119,523,912,458,424,997,527,272,188,355,960,346,993,947,472,571,739,
        434,164,434,207,324,472,795,251,878,842,258,499,814,511,758,213,273,20,331,52,916,630,446,495,946,18,116,899
        ,267,772,90,515,562,970,46,502,797,249,923,865,528,830,15,703,585,734,808,487,60,462,513,358,143,810,809,887
        ,799,440,548,393,848,981,686,353,647,454,886,490,851,16,352,115,694,503,225,865,832,122,646,567,820,668,356,
        948,951,235,329,717,552,44,176,333,529,155,607,475,466,991,596,395,197,363,746,411,938,837,984,863,732,810,
        786,828,49,935,852,464,413,961);
     List<Integer> reliabilities = Arrays.asList(495,61,1000,418,220,603,645,662,992,915,970,15,640,354,677,457,80,
        620,19,929,373,447,729,868,541,224,940,8,453,52,833,496,560,375,389,619,310,455,173,5,49,792,54,100,400,793,
        404,379,16,573,318,513,917,161,768,434,165,660,294,163,652,849,783,817,927,870,622,90,932,399,378,850,647,
        946,918,550,542,652,961,531,653,362,934,94,810,1000,699,93,289,724,534,691,88,883,122,903,315,689,805,910,
        879,221,612,187,50,625,660,581,545,397,426,151,615,308,891,416,212,444,948,588,842,562,538,153,201,562,266,
        50,187,18,136,574,823,655,483,169,314,541,887,680,904,923,768,297,623,532,861,967,762,141,794,257,961,908,
        771,811,887,566,966,434,913,232,217,900,5,470,695,940,199,127,951,889,989,789,4,839,819,944,828,652,54,347,
        780,531,108,516,841,995,58,472,752,215,444,643,366,303,279,467,880,677,9,213,915,79,326,285,796,107,588,897,
        192,597,135,614,68,418,757,297,356,447,626,646,975,873,131,619,377,790,878,908,390,906,200,328,805,914,85,
        786,121,235,154,832,305,539,925,254,368,174,82,938,901,128,719,625,379,376,784,320,568,723,699,307,410,684,
        180,192,652,218,896,75,788,289,741,603,855);

//    List<Integer> speeds = Arrays.asList(1, 1, 1, 1, 100000, 15);
//    List<Integer> reliabilities = Arrays.asList(8, 7, 6, 5, 2, 1);
//    List<Integer> speeds = Arrays.asList(12, 112, 100, 13, 55);
//    List<Integer> reliabilities = Arrays.asList(31, 4, 100, 55, 50);

//    List<Integer> speeds = Arrays.asList(4, 3, 15, 5, 6);
//    List<Integer> reliabilities = Arrays.asList(7, 6 , 1, 2, 8);
    System.out.println(computingClusterQuality.maximumClusterQuality(speeds, reliabilities, 131));
  }
}
