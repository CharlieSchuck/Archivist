import java.util.Arrays;

//the Archivist manages the collection of nodes, easy enough. The Archivist will do all of the hashing.
public class Archivist  {
    ArchivistNode hashtable[];
    Integer size;
    //so the size of the has table leads to a little ambiguity, I'm going to make it so that the user can specify a size
    //although, the program SHOULD decide on a size... but that is very cumbersome and risks wasting space, not to mention you
    //would have to know the number of unique words in a file BEFOREHAND to make such an assessment... so, after consulting
    //with Eric, I'm going to leave it out. but, let it be known, that if this is an issue... I *Could* implement it, but
    //the implementation would be very poor and rudimentary.
    public Archivist(Integer tablesize){
        hashtable = new ArchivistNode[tablesize];
        size = tablesize;
    }

    public void hashIntoTable(String word, int linenumber){
        ArchivistNode incomingword = new ArchivistNode(word, linenumber);
        boolean flag = false;
        int counter = 0;

        int value = incomingword.getValue();
        if(hashtable[value % size] != null){
            int i;
            for(i = value % size; i <= size - 1 && !flag; i++){

                if(hashtable[i] == null){
                    hashtable[i] = incomingword;
                    flag = true;
                }
                //check if the word in the object in the spot is the same word that we are trying to insert
                else if(hashtable[i].getWord().equals(word)){
                    hashtable[i].addit(linenumber); //adds it to its linked list
                    flag = true;
                }

                //loop back to the beginning
                if(i == size - 1){
                    i = 0;
                }
            }

        }
        else{
            hashtable[value % size] = incomingword;
        }

        for(int j = 0; j <= size - 1; j++){
            if(hashtable[j] != null){
                counter++;
            }
        }
        if(counter == size){
            System.out.println("the hashtable is full.");

        }

    }
    public void testtable(){
        for(int i = 0; i <= size - 1; i++){
            if(hashtable[i] != null) {
                System.out.println(hashtable[i].getWord() + ": " + hashtable[i].getValue() + " : " + hashtable[i].getValue() % size + " : " + hashtable[i].getLinkedList());
            }
            else
                System.out.println("null");
        }
    }

    public void sortTable(){
        int count = 0;

        for(int i = 0; i <= size - 1; i++){
            if(hashtable[i] != null) {
                count++;
            }
            //else
                //System.out.println("null");

        }

        ArchivistNode temp[] = new ArchivistNode[count];
        int count1 = 0;
        for (int i = 0; i <= size - 1; i++) {
            if (hashtable[i] != null) {
                temp[count1] = hashtable[i];
                count1++;
            }
        }


        Arrays.sort(temp);
        System.out.print(Arrays.toString(temp));

    }

}
