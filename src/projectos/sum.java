/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectos;

/**
 *
 * @author Reem
 */
public class sum implements Runnable{
     int sum;
    private final int[] array;
    public sum(int[] array) {
        this.array = array;
    }
    
    
    public  void run(){
           
            for (int i = 0; i < array.length; i++) {
                sum += array[i];
            }
        }

    public  int getSum() {
            return sum;
    }
}
