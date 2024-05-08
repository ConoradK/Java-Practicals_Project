package Practical_11;
//class Talk is part of practical 11 package


//this session class contains all attributes and actions
//performed by the instances of class session
public class Session {
    private int sessionId;
    //sessionId is declared and has a default value of 0
    private String location;
    //location is declared and has a default value of null
    private Talk[] talkList;
    //talkList is declared and has a default value of a null/empty table
    private int currentSize;
    //currentSize is declared and has a default value of 0


    //this constructor takes in the variables in the
    // parameter when a Session object is instantiated
    public Session(int sessionId, String location) {
        //each argument is referred to the attributes of the object/class Session
        this.sessionId = sessionId;
        this.location = location;

        //capacity of talks is set to 4 for every Session
        this.talkList = new Talk[4];

        //since each talk list has a capacity of 4 but is still empty
        // it has 0 talk objects stored in it
        this.currentSize = 0;
    }


    //this method is responsible for potentially adding new talks into the talklist
    //this method takes in the variable talk to add to the talklist
    public void scheduleTalk(Talk talk) {
        //if the talk list is already full (has 4 talk objects)
        //then it returns the logical error message and no new talk is added to the list
        if (currentSize > 3){
            System.out.println("talk id "+ talk.getTalkId() +" couldn't be added to session id "+sessionId+" " +
                                "as the talk list was full at the time");
            return;
        }
        else {
            // this for loop goes through all the talks that are in the list
            for (int current_talk_pos = 0; current_talk_pos < currentSize; current_talk_pos++) {

                //if the talk address location matches with the one given via the parameter
                //then it means it has been already added to the list and this method terminates
                //otherwise nothing happens
                if (talkList[current_talk_pos].equals(talk)) {
                    System.out.println("Talk is already scheduled.");
                    return;
                }
            }

            // here if the talk is new and can be added to the list
            //another for loop will be used to add it accordingly
            int current_talk_pos;

            //in this for loop the start position is the last talk in the list
            //and the for loop works towards the beginning of the list
            for (current_talk_pos = currentSize - 1; current_talk_pos >= 0; current_talk_pos--) {

                //if the talk in the list has a later time than the talk that is to be added
                //talk.compareTo(talkList[current_talk_pos]
                if (talk.compareTo(talkList[current_talk_pos])  > 0) {
                    //check here!!!
                    //if (((talkList[current_talk_pos]).getStartTime()).compareTo(talk.getStartTime()) > 0)

                    //then the talk that is in the list will be moved up by one space
                    //every talk in the list that has a later time than the new talk will be shifted up
                    //else nothing happens
                    talkList[current_talk_pos + 1] = talkList[current_talk_pos];
                } else {
                    break;
                }
            }
            //here the new talk will replace the old position of the talk old talk
            //and the number of talks in the list has increased by 1
            talkList[current_talk_pos + 1] = talk;
            currentSize++;
        }
    }


    //this method will delete the desired talk from the session
    //it takes in the id of the talk to be deleted
    public void cancelTalk(int talkId) {

        //this for loop, loops through every talk in the list until it finds the targeted talk
        for (int current_cancellation_pos = 0; current_cancellation_pos < currentSize; current_cancellation_pos++) {

            //if the talk id matches targeted talk
            if (talkList[current_cancellation_pos].getTalkId() == talkId) {
                //then set that talk to null
                talkList[current_cancellation_pos] = null;
                //the number of talks has decreased by 1
                currentSize--;

                //this for loop starts one position above where the previous loop finished,
                // as we know that one position lower has a value of null
                for(int current_shifting_pos = current_cancellation_pos + 1; current_shifting_pos <= currentSize; current_shifting_pos++){

                    //if there is no talk then the for loop ends
                    //as  every other item in te list will be a null
                    if(talkList[current_shifting_pos] == null){
                        break;
                    }
                    //otherwise shift the upper talk down by 1 position to leave no gaps in the list
                    else{
                        talkList[current_shifting_pos-1] = talkList[current_shifting_pos];
                        //also set the the previous position to null so that there are no duplicates in the list
                        talkList[current_shifting_pos] = null;
                    }
                }
                return;
            }
        }
        //if the talk was not found then the following message will be displayed
        System.out.println("Talk not found for cancellation.");
    }


    //This toString method is overridden as it's by default included in the class
    //this method outputs the information about the session's id, location and number of talks in the session

    @Override
    public String toString() {
        String sessionInfo = ("Session ID: " + sessionId + "\nLocation: " + location + "\nNumber of Talks: "
                + currentSize + "\nTalks:\n\n");


        //however in this for loop  the talk's tostring method is called  to output the talk information
        for (int current_talk = 0; current_talk < currentSize; current_talk++) {
            sessionInfo += (talkList[current_talk].toString()) + ("\n\n");
        }
        return sessionInfo;
    }
}
