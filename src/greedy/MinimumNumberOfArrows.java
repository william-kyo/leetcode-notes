package greedy;

import org.junit.Assert;

import java.util.Arrays;

public class MinimumNumberOfArrows {
    public int findMinArrowShots(int[][] points) {
        if(points.length<1){
            return 0;
        }

        Arrays.sort(points,(int[] o1, int[] o2)->{
            if(o1[1]==o2[1]){
                return 0;
            }
            if(o1[1]>o2[1]){
                return 1;
            }
            return -1;
        });
        int count = 1;
        int pre = points[0][1];
        for(int i=1; i<points.length; i++){
            if(points[i][0]<=pre){
                continue;
            }
            count++;
            pre = points[i][1];
        }
        return count;
    }


    public static void main(String[] args) {
        MinimumNumberOfArrows mnoa = new MinimumNumberOfArrows();
        int[][] points;
        int expected, actual;

        points = new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        expected = 2;
        actual = mnoa.findMinArrowShots(points);
        Assert.assertEquals(expected, actual);


        points = new int[][]{{-2147483648, 2147483647}};
        expected = 1;
        actual = mnoa.findMinArrowShots(points);
        Assert.assertEquals(expected, actual);

        points = new int[][]{{1,2},{2,3},{3,4},{4,5}};
        expected = 2;
        actual = mnoa.findMinArrowShots(points);
        Assert.assertEquals(expected, actual);

        points = new int[][]{{-2147483646, -2147483645}, {2147483646, 2147483647}};
        expected = 2;
        actual = mnoa.findMinArrowShots(points);
        Assert.assertEquals(expected, actual);

    }
}
