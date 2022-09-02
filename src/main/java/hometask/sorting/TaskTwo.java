package hometask.sorting;

public class TaskTwo {

    public static void main(String[] args) {

        int[] firstArray = {3, 7, 6, 13, 33, 9, -100, 25};
        int maxvalue = firstArray[0];
        int minvalue = firstArray[0];
        int i = 0;


        //home-task Two
        while (i < firstArray.length) {
            System.out.println(firstArray[i]);
            if (firstArray[i] > maxvalue) {
                maxvalue = firstArray[i];
            }
            if (firstArray[i] < minvalue) {
                minvalue = firstArray[i];
            }
            i++;
        }
        System.out.println("maximum is: " + maxvalue);
        System.out.println("minimum is: " + minvalue);


    }
}
