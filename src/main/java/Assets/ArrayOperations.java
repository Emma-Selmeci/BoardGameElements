/**
 * Various methods to manipulate arrays wrapped in a class
 */

package Assets;

import java.util.Random;

public class ArrayOperations {

    //leaveOneOut copies the content of array to temporal (array.length-1) leaving the selected element out
    public static <T> T[] leaveOneOut(T[] array, T[] temporal, int selectedNumber) {
        int j;
        if(temporal.length == array.length) j = temporal.length-1; else j = temporal.length;
        for(int i = 0; i < j; i++) {
            if(i < selectedNumber) {
                temporal[i] = array[i];
            } else temporal[i] = array[i+1];
        }
        return temporal;
    }
    //addToArray adds a new element to the array and copies the results to destArray
    public static <T> T[] addToArray(T[] array, T toAdd, T[] destArray) {
        for(int i = 0; i < array.length; i++) {
            destArray[i] = array[i];
        }
        destArray[destArray.length-1] = toAdd;
        return destArray;
    }
    //shuffle shuffles array and copies result to temporal
    public static <T> T[] shuffle(T[] array, T[] temporal) {
        int randPos;
        int range = array.length;
        for(int i = 0; i < array.length; i++) {
            Random rand = new Random();
            randPos = rand.nextInt(range--);
            temporal[i] = array[randPos];
            for(int j = randPos; j < range; j++) {
                array[j] = array[j + 1];
            }
        }
        return temporal;
    }

}

