package Practical_12;
//the class Review is part of package Practical_12

//all classes and methods are imported from teh util package
import java.util.*;


//this Review class contains all attributes and actions
//performed by the instances of class Review
//the Review inherits the methods from interface Comparable
class Review implements Comparable<Review> {

    private int id;
    //the review id is declared and has a default value of 0
    private String reviewer;
    //the review  is declared and has a default value of null
    private int score;
    //the score is declared and has a default value of 0
    private int confidence;
    //the confidence is declared and has a default value of 0
    private String summary;
    //the summary is declared and has a default value of null


    //this constructor takes in the variables in the
    // parameter when a Review object is instantiated
    public Review(int id, String reviewer, int score, int confidence, String summary) {
        //each argument is referred to the attributes of the object/class Review
        this.id = id;
        this.reviewer = reviewer;
        this.score = score;
        this.confidence = confidence;
        this.summary = summary;
    }

    //This get method retrieves the reviewer's name as it is private
    // and no other class can access it directly. only via this get method.
    public String getReviewer() {
        return reviewer;
    }

    //This get method retrieves the review id as it is private
    // and no other class can access it directly. only via this get method.
    public int getId() {
        return id;
    }

    //This get method retrieves the reviewer's score as it is private
    // and no other class can access it directly. only via this get method.
    public int getScore() {
        return score;
    }

    //This get method retrieves the reviewer's confidence score as it is private
    // and no other class can access it directly. only via this get method.
    public int getConfidence() {
        return confidence;
    }

    //This set method sets a new value for the reviewer's score as it is private
    // and no other class can access it directly. only via this set method.
    public void setScore(int newScore) {
        this.score = newScore;
    }

    //this overridden method compares the Review objects based on their score values
    @Override
    public int compareTo(Review other) {
        return Integer.compare(other.score, this.score);
    }

    //This toString method is overridden as it's by default included in the class
    //this method outputs the information ,that is stored within the object Review,
    //and teh information is displayed in a  user-friendly fashion
    //it is required as the memory location of the object Review
    // is the only information accessible outside this method
    @Override
    public String toString() {
        return String.format("Review %d by %s: Score=%d, Confidence=%d, Summary=%s",
                id, reviewer, score, confidence, summary);
    }
}
