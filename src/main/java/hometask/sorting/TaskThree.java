package hometask.sorting;

public class TaskThree {
    public static void main(String[] args) {

        int[] firstArray = {3, 7, 6, 13, 33, 9, -100, 25};
        int i;
        int j;
        int position;
        int aux;

        //home-task Three
        for (j = 0; j < firstArray.length; j++) {
            position = j; //current position
            aux = firstArray[j];// current integer

            while (position > 0 && firstArray[position - 1] > aux) { //position 0 must not be considered
                firstArray[position] = firstArray[position - 1]; // swap previous element to the right
                position = position - 1; //decrement for the next iteration
            }
            firstArray[position] = aux; //swap current element to the left
        }

        for (i = 0; i < firstArray.length; i++) {
            System.out.println(firstArray[i]); //print out the elements of the sorted array


        }
    }
}
