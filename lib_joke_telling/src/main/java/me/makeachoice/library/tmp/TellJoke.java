package me.makeachoice.library.tmp;

public class TellJoke {

/**************************************************************************************************/
/**
 * Class Variables:
 *      String[][] mJokes - an array of jokes
 *      int[] mSequence - order sequence of jokes
 *      int mIndex - current joke index
 *      bool mRandomOrder - status flag if jokes are randomized or ordered
 *
 *      int JOKE_SETUP - first part of the joke string array, the setup
 *      int JOKE_PUNCHLINE - second part of the joke string array, the punchline
 */
/**************************************************************************************************/

    //mJokes - an array of jokes
    private String[] mJokes;

    //mSequence - order sequence of jokes
    private int[] mSequence;

    //mIndex - current joke index
    private int mIndex;

    //mRandomOrder - status flag if jokes are randomized or ordered
    private boolean mRandomOrder;

    //JOKE_SETUP - first part of the joke string array, the setup
    public final static int JOKE_SETUP = 0;

    //JOKE_PUNCHLINE - second part of the joke string array, the punchline
    public final static int JOKE_PUNCHLINE = 1;

/**************************************************************************************************/

/**************************************************************************************************/
/**
 * Constructor TellJoke:
 *      @param isRandom - boolean status flag used to create a ordered or random sequence order
 */
/**************************************************************************************************/
/*
 * Constructor TellJoke - initialize array of jokes and sequence order
 */
    public TellJoke(boolean isRandom){
        //initialize jokes to buffer
        mJokes = initializeJokes();

        //initialize sequence of jokes
        initializeSequence(isRandom);
    }

/**************************************************************************************************/

/**************************************************************************************************/
/**
 * Initialization Methods:
 *      void initializeSequence(boolean) - initialize sequence order of jokes
 *      void initializeJokes() - initializes array of jokes
 */
/**************************************************************************************************/
/*
 * void initializeSequence(boolean) - initialize sequence order of jokes. Depending on random order
 *      status flag, a randomized or ordered sequence of numbers are created and the index
 *      keeping track of the next joke is set to the first joke in the joke array
 */
    private void initializeSequence(boolean isRandom){
        //set random order status flag
        mRandomOrder = isRandom;

        //determine sequence order
        if(mRandomOrder){
            //randomize order
            mSequence = Randomize.randomSequence(mJokes.length);
        }
        else{
            //sequential order
            mSequence = Randomize.orderedSequence((mJokes.length));
        }

        //set index to first joke in buffer
        mIndex = 0;

    }

/*
 * void initializeJokes() - initializes array of Jokes. A joke is a two string array of strings,
 *      Setup and Punchline.
 */
    private String[] initializeJokes(){
        String joke01 = "What is a programmer?" +
        "/n/nA machine that turns coffee into code.";

        String joke02 = "What is a programmer?" +
        "/n/nA person who fixed a problem that you don't know you have, in a way you don't understand";

        String joke03 = "What is an algorithm?" +
        "/n/nWord used by programmers when....they do not want to explain what they did.";

        String joke04 = "What is hardware?" +
        "/n/nThe part of the computer that you can kick.";

        String joke05 = "What is the object-oreinted way to become wealthy?" +
        "/n/nInheritance";

        String joke06 = "What do you call a programmer from Finland?" +
        "/n/nNerdic";

        String joke07 = "Where is a programmers' favorite hangout place?" +
        "/n/nFoo Bar";

        String joke08 = "Why did the programmer quit his job?" +
        "/n/nBecause he didn't get arrays";

        String joke09 = "'0' is false and '1' is true, right?" +
        "1";

        String joke10 = "How do you tell an introverted computer scientist from an extroverted computer scientist?" +
        "/n/nAn extroverted computer scientist looks at your shoes when he talks to you.";

        String joke11 = "What do computers and air conditioners have in common?" +
        "/n/nThey both become useless when you open windows.";

        String joke12 = "Why do Java programmers have to wear glasses?" +
        "/n/nBecause they don't C#";

        String joke13 = "Why do programmers always mix up Halloween and Christmas?" +
        "/n/nBecause Oct 31 == Dec 25";

        String joke14 = "How many programmers does it take to change a light bulb?" +
        "/n/nNone, that's a hardware problem";

        String joke15 = "Why programmers like UNIX:" +
        "/n/nwho && gawk && uname && talk && date && wine && touch && unzip && strip && touch && finger && mount && fsck && more && yes; yes; more; yes; umount && make clean && sleep";

        String joke16 = "Command line Russian roulette:" +
        "/n/n[ $[ $RANDOM % 6 ] == 0 ] && rm -rf / || echo *Click*";

        String joke17 = "Don't anthropomorphize computers." +
        "/n/nThey hate that!";

        String joke18 = "ASCII stupid question: " +
        "/n/nGet a stupid ANSI";

        String joke19 = "Two bytes meet. The first byte ask, 'Are you ill?'" +
        "/n/nThe second byte replies, 'No, just feeling a bit off'";

        return new String[]{joke01, joke02, joke03, joke04, joke05,
                joke06, joke07, joke08, joke09, joke10,
                joke11, joke12, joke13, joke14, joke15,
                joke16, joke17, joke18, joke19};
    }

/**************************************************************************************************/


/**************************************************************************************************/
/**
 * Getters:
 *      String[][] getJokes() - get ordered array of jokes
 *      String[][] getRandomizedJokes - get randomized array of jokes
 *      String[] getNextJoke() - get the next joke from the joke array
 *      String[] getPreviousJoke() - get the previous joke from the joke array
 */
/**************************************************************************************************/
/*
 * String[][] getJokes() - get ordered array of jokes
 */
    public String[] getJokes(){
        return mJokes;
    }

/*
 * String[][] getRandomizedJokes() - get randomized array of jokes
 */
    public String[] getRandomizedJokes(){
        return randomizeJokes();
    }

/*
 * String[] getNextJoke() - get the next joke from the joke array
 */
    public String getNextJoke(){
        //get joke from buffer
        return mJokes[nextJokeIndex()];
    }

/*
 * String[] getPreviousJoke - get the previous joke from the joke array
 */
    public String getPreviousJoke(){
        if(mIndex != 0){
            return mJokes[mIndex-1];
        }
        else{
            return mJokes[mIndex];
        }
    }


/**************************************************************************************************/

/**************************************************************************************************/
/**
 * Getters:
 *      String[][] randomizeJokes() - create a randomized order of jokes from the joke array
 *      int nextJokeIndex() - return the next joke index
 */
/**************************************************************************************************/
/*
 * String[][] randomizeJokes() - create a randomized order of jokes from the joke array
 */
    private String[] randomizeJokes(){
        int count = mJokes.length;

        String[] jokes = new String[count];

        for(int i = 0; i < count; i++){
            int randomIndex = mSequence[i];
            jokes[i] = mJokes[randomIndex];
        }

        return jokes;
    }

/*
 * int nextJokeIndex() - return the next joke index. Check to see if the current index is a
 *      valid index. If not, reset the index and sequence order. Return the index of the next
 *      joke and move the index forward.
 */
    private int nextJokeIndex(){
        //check if index is beyond array of jokes
        if(mIndex >= mJokes.length){
            //initialize sequence order
            initializeSequence(mRandomOrder);
        }

        //get next joke index
        int jokeIndex = mSequence[mIndex];

        //move joke index up one
        mIndex++;

        return jokeIndex;
    }

/**************************************************************************************************/

}
