package com.boardgameassets;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[] {1,2,3,4,5,6,7,8,9};
        int[] temp = new int[array.length];
        shuffle[]

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



