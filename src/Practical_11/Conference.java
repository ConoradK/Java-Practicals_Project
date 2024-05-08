package Practical_11;
//class Talk is part of practical 11 package

//this class behaves like a conference planner
public class Conference {

    //this main method will be responsible for containing all interactions with the session and talk objects
    public static void main(String[] args) {
        //four sessions created
        Session session1 = new Session(1, "Room A");
        Session session2 = new Session(2, "Room B");
        Session session3 = new Session(3, "Room C");
        Session session4 = new Session(4, "Room D");

        //all talks are created
        Talk talk1 = new Talk(1, "Speaker 1", "Title 1", "2023-11-08T10:00:00");
        Talk talk2 = new Talk(2, "Speaker 2", "Title 2", "2023-11-08T20:00:00");
        Talk talk3 = new Talk(3, "Speaker 3", "Title 3", "2023-11-08T02:00:00");
        Talk talk4 = new Talk(4, "Speaker 4", "Title 4", "2023-11-08T15:00:00");
        Talk talk5 = new Talk(5, "Speaker 5", "Title 5", "2023-11-08T09:00:00");
        Talk talk6 = new Talk(6, "Speaker 6", "Title 6", "2023-11-08T14:30:00");
        Talk talk7 = new Talk(7, "Speaker 3", "Title 7", "2023-11-08T07:45:00");
        Talk talk8 = new Talk(8, "Speaker 1", "Title 8", "2023-11-08T17:15:00");
        Talk talk9 = new Talk(9, "Speaker 4", "Title 9", "2023-11-08T12:00:00");
        Talk talk10 = new Talk(10, "Speaker 1", "Title 10", "2023-11-08T15:45:00");


////
////        Here the planning happens, talks can be added or deleted from the sessions
////

        session1.scheduleTalk(talk1);
        session1.scheduleTalk(talk2);
        session1.scheduleTalk(talk3);
        session1.scheduleTalk(talk4);
        session1.cancelTalk(3); // Cancel talk with talkId 3
        session1.scheduleTalk(talk6);
        session1.scheduleTalk(talk9);

        session2.scheduleTalk(talk5);
        session2.scheduleTalk(talk3);
        session2.cancelTalk(5);
        session2.cancelTalk(3);
        session2.scheduleTalk(talk7);



        session3.scheduleTalk(talk10);
        session3.scheduleTalk(talk3);
        session3.cancelTalk(2);


        session4.scheduleTalk(talk8);
        session4.scheduleTalk(talk9);
        session4.cancelTalk(8);
        session4.scheduleTalk(talk5);
        session4.scheduleTalk(talk8);

////
////
////



        //the final conference schedule of the sessions will be displayed
        System.out.println("Conference Schedule:\n");
        System.out.println(session1);
        System.out.println(session2);
        System.out.println(session3);
        System.out.println(session4);
    }
}
