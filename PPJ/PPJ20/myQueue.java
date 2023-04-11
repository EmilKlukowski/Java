package PPJ20;

public class MyQueue {
    public String[] queue = new String[16];
    public int counter=0;

    public void put(String nazwaKlubu){
        if(counter == queue.length){
            String[] queue2 = new String[queue.length+1];
            for (int i = 0; i < queue.length; i++) {
                queue2[i]=queue[i];
            }
            queue=queue2;
        }
        queue[counter]=nazwaKlubu;
        counter++;

    }

}

