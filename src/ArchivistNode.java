import java.util.LinkedList; //using built in linkedlist as instructed

public class ArchivistNode implements Comparable<Object> {
    String word = " ";
    LinkedList<Integer> linenumbers = new LinkedList<>();

    //hey look it is the constructor for a brand new word...
    public ArchivistNode(String w, Integer linenumber){
        word = w;
        linenumbers.add(linenumber);
    }

    public ArchivistNode(String w){
        word = w;
        linenumbers.add(1);
    }

    public ArchivistNode(){
        word = "";
    }

    //a way to add the spare line number
    public void duplicate(Integer linenumber){
        linenumbers.add(linenumber);
    }

    public Integer getValue(){
        //when getting the value, we are going to treat all words as if they are all uppercase
        int value = 0;
        for(int i = 0; i <= word.length() - 1; i++){
            if(word.charAt(i) >= 97){
                value = value + word.charAt(i) - 32;
            }
            else
                value = value + word.charAt(i);
        }

        //System.out.println(value); used for testing!
        return value;
    }

    public String getWord() {
        return word;
    }

    public void addit(int linenumber) {
        linenumbers.add(linenumber);
    }

    public String getLinkedList(){
        return linenumbers.toString();
    }

    @Override
    public int compareTo(Object o) {
        String s1 = this.word;
        String s2 = ((ArchivistNode) o).word;

        return s1.compareTo(s2);
    }

    @Override
    public String toString(){
        return word + " : " + linenumbers.toString();
    }
}
