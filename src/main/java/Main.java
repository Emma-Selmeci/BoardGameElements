public class Main {
    public static void main(String[] args) {
        Integer[] numbers = new Integer[] {0,1,2,3,4,5,6,7,8,9};
        Integer[] numbers2 = new Integer[numbers.length-1];
        ArrayOperations.leaveOneOut(numbers,numbers2,3);
        //for(int i : numbers2) System.out.println(i+"");

        Integer[] numbers3 = new Integer[] {0,1,2,3,4,5,6,7,8,9};
        Integer[] numbers4 = new Integer[numbers3.length];
        ArrayOperations.shuffle(numbers3,numbers4);
        for(int i : numbers4) System.out.println(i+"");
    }
}
