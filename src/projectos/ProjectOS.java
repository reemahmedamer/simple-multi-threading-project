
package projectos;

import java.util.*;

public class ProjectOS {

   

    public static int[] asign(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            Random r = new Random();
            int random = r.nextInt();
            array[i] = random;
        }
        return array;
    }

    public static ArrayList<Integer> sumArray() throws InterruptedException {
        int size = 9000000;
        int[] array = asign(size);
        ArrayList<Integer> sumArray = new ArrayList<>();
        int old_i = 0;
        for (int i = 5000; i < size; i = i + 5000) {
            int[] arr = Arrays.copyOfRange(array, old_i, i);
            sum sumthread = new sum(arr);
            Thread thread = new Thread (sumthread);
            thread.start();
            thread.join();
            int sum = sumthread.getSum();
            sumArray.add(sum);

            old_i = i;
        }
        return sumArray;

    }
    
    public static ArrayList<Integer> maxArray() throws InterruptedException {
        int size = 9000000;
        int[] array = asign(size);
        ArrayList<Integer> maxArray = new ArrayList<>();
        int old_i = 0;
        for (int i = 5000; i < size; i = i + 5000) {
            int[] arr = Arrays.copyOfRange(array, old_i, i);
            maxThread maxthread = new maxThread(arr);
            Thread thread = new Thread(maxthread);
            thread.start();
            thread.join();
            int max = maxthread.returnmax();
            maxArray.add(max);

            old_i = i;
        }
        return maxArray;

    }

    public static ArrayList<Integer> minArray() throws InterruptedException {
        int size = 9000000;
        int[] array = asign(size);
        ArrayList<Integer> minArray = new ArrayList<>();
        int old_i = 0;
        for (int i = 5000; i <= size; i = i + 5000) {
            int[] arr = Arrays.copyOfRange(array, old_i, i);
            minThread minthread = new minThread(arr);
            Thread thread = new Thread(minthread);
            thread.start();
            thread.join();
            int min = minthread.returnmin();
            minArray.add(min);

            old_i = i;
        }

        return minArray;

    }

    public static void main(String[] args) throws InterruptedException {
        int size = 9000000;
        int[] array = asign(size);
        Arrays.parallelSort(array);
        
        long sumstart = System.nanoTime();
        sumArray();
        long sumend = System.nanoTime();
        long executionSumTime = sumend - sumstart;
        System.out.println("execution Time of Sum in Second = " + executionSumTime / 1000000000 + " sec");
        
        long maxstart = System.nanoTime();
        maxArray();
        long maxend = System.nanoTime();
        long executionmaxTime = maxend - maxstart;
        System.out.println("execution Time of Maximum in Second = " + executionmaxTime / 1000000000 + " sec");
        
        long minstart = System.nanoTime();
        minArray();
        long minend = System.nanoTime();
        long executionminiTime = minend - minstart;
        System.out.println("execution Time of Minimum in Second = " + executionminiTime / 1000000000 + " sec");
        
        
        ArrayList <Integer> sum=sumArray();
        long totalSum=0;
        for(int i:sum){
            totalSum=i;
        }
        System.out.println("Sum: " + totalSum);
        System.out.println("Maximum: " + Collections.max(maxArray()));
        System.out.println("Minimum: " + Collections.min(minArray()));

    }
}
