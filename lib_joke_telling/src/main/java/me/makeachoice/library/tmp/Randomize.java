package me.makeachoice.library.tmp;

import java.util.Random;

/**
 * Randomize - randomly orders the sequence of jokes to be told
 */
public class Randomize {

/**************************************************************************************************/
/**
 * Public methods:
 *      int[] orderedSequence(int) - create an ordered sequence of numbers
 *      int[] randomSequence(int) - create a random sequence of numbers
 */
/**************************************************************************************************/
/*
 * int[] orderedSequence(int) - create an ordered sequence of numbers
 */
    public static int[] orderedSequence(int numOfJokes){
        int[] ordered = new int[numOfJokes];

        for(int i = 0; i < numOfJokes; i++){
            ordered[i] = i;
        }

        return ordered;
    }

/*
 * int[] randomSequence(int) - create a random sequence of numbers
 */
    public static int[] randomSequence(int numOfJokes){
        int[] nums = orderedSequence(numOfJokes);

        Random randomGenerator = new Random();
        int randomIndex;
        int randomValue;

        for(int i = 0; i < numOfJokes; i++) {
            //select a random index
            randomIndex = randomGenerator.nextInt(numOfJokes);

            //swap values
            randomValue = nums[randomIndex];
            nums[randomIndex] = nums[i];
            nums[i] = randomValue;
        }

        return nums;
    }

/**************************************************************************************************/

}
