package Practical_12;
//class Talk is part of practical 12 package
import java.util.*;
//all class and methods are imported from the java util package
import java.text.DecimalFormat;
//the Decimal format library is imported


//this class behaves like a publication system
//within this class the user can interact with the system and perform certain functions
//like creating reviews, adding reviews to papers or retracting them
class PublicationSystem {



    public static void main(String[] args) {

        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        //decimal format object is created, and it has a format of 2dp

        //the 3 papers are instantiated
        Paper paper1 = new Paper(1, "Title 1", Arrays.asList("Author1", "Author2"));
        Paper paper2 = new Paper(2, "Title 2", Arrays.asList("Author3", "Author4"));
        Paper paper3 = new Paper(3, "Title 3", Arrays.asList("Author5", "Author6"));

        //all the reviews that are to be interacted with should be created here
        Review review_1 = new Review(1,"reviewer 1",7,3,"Good paper");
        Review review_2 = new Review(2,"reviewer 2",2,1,"Many improvements to be done");
        Review review_3 = new Review(3,"reviewer 3",8,4,"Vey insightful");
        Review review_4 = new Review(4,"reviewer 4",6,5,"Interesting");
        Review review_5 = new Review(5,"reviewer 5",1,5,"Poor paper");
        Review review_6 = new Review(6,"reviewer 6",10,2,"Absolutely perfect");
        Review review_7 = new Review(7,"reviewer 7",9,4,"Amazing");
        Review review_8 = new Review(8,"reviewer 8",3,5,"Boring");
        Review review_9 = new Review(9,"reviewer 9",4,1,"Very similar to another paper");
        Review review_10 = new Review(10,"reviewer 10",5,2,"Average");




        //
        //all actions that can happen to the reviews are performed below
        //
        paper1.submitReview(review_1);
        paper1.submitReview(review_2);
        paper1.submitReview(review_3);
        paper1.updateReview(review_2,10);
        paper1.submitReview(review_4);
        paper1.retractReview(review_1);
        paper1.submitReview(review_3);

        paper2.submitReview(review_9);
        paper2.retractReview(review_9);
        paper2.submitReview(review_8);
        paper2.submitReview(review_10);

        paper3.submitReview(review_6);
        paper3.updateReview(review_6,9);
        paper3.submitReview(review_9);
        paper3.submitReview(review_1);
        paper3.submitReview(review_5);
        paper3.submitReview(review_7);
        //
        //
        //


        //below the 3 paper reviews are displayed one last time
        paper1.printReviewList();
        paper2.printReviewList();
        paper3.printReviewList();


        //below the if statements are required to determine the best average score between the 3 papers

        //if paper 1 score is greater than that of paper 2 and 3
        //then paper 1 has the best average score as shown by the output of the print statement
        if(paper1.average_score() >  paper2.average_score()
        && paper1.average_score() > paper3.average_score()){
            System.out.println("\npaper 1 has the best average score of "+ decimalFormat.format(paper1.average_score()));

        }

        //otherwise if paper 2 score is greater than that of paper 1 and 3
        //then paper 2 has the best average score as shown by the output of the print statement
        else if (paper2.average_score() > paper1.average_score()
        && paper2.average_score() > paper3.average_score()) {
            System.out.println("\npaper 2 has the best average score of "+ decimalFormat.format(paper2.average_score()));

        }

        //otherwise if paper 3 score is greater than that of paper 2 and 1
        //then paper 3 has the best average score as shown by the output of the print statement
        else if (paper3.average_score() > paper1.average_score()
        && paper3.average_score() > paper2.average_score()) {
            System.out.println("\npaper 3 has the best average score of "+ decimalFormat.format(paper3.average_score()));

        }

        //however if both paper 1 and 2 have the highest best average score then
        //the output print statement calls a draw between paper 1 and 2
        else if (paper1.average_score() == paper2.average_score()) {
            System.out.println("\nboth paper 1 and 2 have the best average score of " +decimalFormat.format(paper1.average_score()));
        }

        //however if both paper 1 and 3 have the highest best average score then
        //the output print statement calls a draw between paper 1 and 3
        else if(paper1.average_score() == paper3.average_score()){
            System.out.println("\nboth paper 1 and 3 have the best average score of " +decimalFormat.format(paper1.average_score()));

        }

        //however if both paper 2 and 3 have the highest best average score then
        //the output print statement calls a draw between paper 2 and 3
        else if (paper2.average_score() == paper3.average_score()) {
            System.out.println("\nboth paper 2 and 3 have the best average score of " +decimalFormat.format(paper2.average_score()));
        }

    }


}
