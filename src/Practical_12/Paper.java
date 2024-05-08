package Practical_12;
//class Talk is part of practical 11 package
import java.util.*;
//all class and methods are imported from the java util package



//this Paper class contains all attributes and actions
//performed by the instances of class Paper,
//and it contains all methods that allows the interaction between the review and the review list
class Paper {
    private int id;
    //Paper id is declared and has a default value of 0
    private String title;
    //title of the paper is declared and has a default value of null
    private List<String> authors;
    //the author list of type String is declared and has a default value of null
    private List<Review> reviewList;
    //the object list review of type Review is declared and has a default value of null


    //this constructor takes in the variables in the
    // parameter when a Paper object is instantiated
    public Paper(int id, String title, List<String> authors) {
        //each argument is referred to the attributes of the object/class Paper
        this.id = id;
        this.title = title;
        this.authors = authors;
        this.reviewList = new LinkedList<Review>();
    }


    //this method is responsible for potentially adding new review into the review list
    //this method takes in the variable review of type Review to add to the review list
    public void submitReview(Review review) {

        //if the review list is already full (has 4 Review objects)
        //then it returns the logical error message and no new review is added to the list
        if (!(reviewList.size() > 3)) {

            //a for loops that goes through every review in the review list
            for(Review current_reviewer:reviewList) {
                //if the current review, reviewer is the same as the new
                //to be submitted reviewer
                if ((current_reviewer.getReviewer()).equals(review.getReviewer())) {
                    //then a message is displayed saying why the review can not be submitted
                    System.out.println("\nCan not submit review, with id of " +review.getId()+", by " + review.getReviewer() +
                            ", as the reviewer already submitted a review");
                    //this method terminates
                    return;
                }
            }
            //the review is added to the list
            reviewList.add(review);

            //then the review  linked list is sorted using the collections library
            Collections.sort(reviewList);

            //then the review list is displayed after adding the review to the list
            printReviewList();
        }

        //here the message tells the user that the submission of the review was not possible
        // due to lack of space left in the review list
        else{
            System.out.println("Paper id " +this.id +
                    " was not able to submit review id" +
                    review.getId()+ " as the paper can't take any more reviews");
        }
    }


    //this method is responsible for changing the score rating of a review that is already in a Paper's review lsit
    //this method takes in the review and its new review score to be
    public void updateReview(Review review, int newScore) {
        //a for loop that loops through every review in the review list
        for (Review current_review : reviewList) {
            //an if statement that checks if the argument review is in the list
            //more specifically is the if of the argument the same as the current index review
            if (current_review.getId() == review.getId()) {
                //if yes then the score is replaced by the new score argument
                review.setScore(newScore);
                //then the review  linked list is sorted using the collections library
                Collections.sort(reviewList);
                //then the review list is displayed after adding the review to the list
                printReviewList();
                //the method is terminated
                return;
            }
        }
        //otherwise the message displayed shows that the given review was not found
        System.out.println("Review with ID " + review.getId() + " not found.");
    }


    //this method is responsible for removing a desired review from the review list
    //also it takes in an argument of the review
    public void retractReview(Review review) {

        //a for loop that loops through every review in the review list
        for (Review current_review : reviewList) {
            //an if statement that checks if the argument review is in the list
            if (current_review == review) {
                //the review is removed from the list
                reviewList.remove(review);
                //the list is ordered based on the review score of the review
                Collections.sort(reviewList);
                //the list information is displayed in descending order
                printReviewList();
                return;
            }
        }
        //otherwise the message displayed shows that the given review was not found
        System.out.println("Review with ID " + review.getId() + " not found.");
    }


    //this method is responsible for displaying the review list of a Paper
    public void printReviewList() {
        //a message shows that the review list shown is after any changes performed on it
        System.out.println("\nReview list for Paper " + id + " after change:");

        //a for loop that loops through every review in the review list
        for (Review review : reviewList) {
            //the toString method of review is used
            System.out.println(review);
        }

        //if the list size is less than 2 then the message displayed tells the user that more reviews are required to be added
        if (reviewList.size() < 2){
            System.out.println("\nPaper id "+ this.id+
                    " needs more review submissions\n");
        }
    }


    //this method is responsible for calculating the average score of each Paper
    public double average_score(){

        double total_score = 0.0d;
        //total score is declared and has a default value of 0.0d

        //the for loop goes through every review in the review list
        for (Review review : reviewList){
            //the sum of the review score is calculated
            total_score += (review.getScore()*(review.getConfidence() /5.0 ));
        }
        //then the average score is returned
        return ((total_score / (reviewList.size())));
    }


}
