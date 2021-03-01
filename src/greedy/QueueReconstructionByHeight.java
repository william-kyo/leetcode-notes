package greedy;

import java.util.Arrays;

public class QueueReconstructionByHeight {
    public int[][] reconstructQueue(int[][] people) {
        if(people==null||people.length==0){
            return people;
        }
        Arrays.sort(people, (int[] o1, int[] o2)->{
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });
        int len = people.length;
        // record whether a position has been occupied
        int[][] newPeople = new int[len][];
        for(int[] p : people){
            int index = p[1] + 1;
            for(int i = 0; i < len; i++){
                if(newPeople[i]==null) {
                    index--;
                    if (index == 0) {
                        newPeople[i] = p;
                        break;
                    }
                }
            }

        }
        return newPeople;
    }

    public static void main(String[] args) {
        QueueReconstructionByHeight queueReconstruction = new QueueReconstructionByHeight();
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        int[][] newPeople = queueReconstruction.reconstructQueue(people);
        System.out.println(newPeople);
    }
}
