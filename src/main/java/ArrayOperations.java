import java.util.Random;

public class ArrayOperations {

    public static <T> T[] leaveOneOut(T[] array, T[] temporal, int selectednumber) {
        for(int i = 0; i < temporal.length; i++) {
            if(i < selectednumber) {
                temporal[i] = array[i];
            } else temporal[i] = array[i+1];
        }
        return temporal;
    }

    public static <T> T[] addToArray(T[] array, T toAdd, T[] destArray) {
        for(int i = 0; i < array.length; i++) {
            destArray[i] = array[i];
        }
        destArray[destArray.length-1] = toAdd;
        return destArray;
    }
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
