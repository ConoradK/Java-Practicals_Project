package Practical_11;
//class Talk is part of practical 11 package




//this Talk class contains all attributes and actions
//performed by the instances of class Talk
//the Talk inherits the methods from interface Comparable
public class Talk implements Comparable<Talk>  {
    private int talkId;
    //talkid is declared and has a default value of 0
    private String speaker;
    //speaker is declared and has a default value of null
    private String title;
    //title is declared and has a default value of null
    private String startTime;
    //Starttime is declared and has a default value of null


    //this constructor takes in the variables in the
    // parameter when a Talk object is instantiated
    public Talk(int talkId, String speaker, String title, String startTime) {
        //each argument is referred to the attributes of the object/class Talk
        this.talkId = talkId;
        this.speaker = speaker;
        this.title = title;
        this.startTime = startTime;
    }


    //This get method retrieves talkid as it is private
    // and no other class can access it directly. only via this get method.
    public int getTalkId(){
        return talkId;
    }


    //This get method retrieves starttime as it is private
    // and no other class can access it directly. only via this get method.
    public String getStartTime(){
        return startTime;
    }


    //This toString method is overridden as it's by default included in the class
    //this method outputs the information ,that is stored within the object Talk
    //it is required as the memory location of the object Talk
    // is the only information accessible outside this method
    //all the text will be indented (\t) as it will indicate visually
    // which talk object belongs to which session instance
    @Override
    public String toString() {
        return ("\tTalk ID: " + talkId + "\n\tSpeaker: " + speaker +
                "\n\tTitle: " + title + "\n\tStart Time: " + startTime);
    }

    //this overridden method compares the talk objects based on the string starTime
    @Override
    public int compareTo(Talk other) {
        return CharSequence.compare(other.startTime, this.startTime);

    }


}
