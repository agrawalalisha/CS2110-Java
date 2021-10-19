import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Homework 4 PrintQueue 
 * Implement the class below as specified in the homework 5 document.
 * 
 * @author Alisha Agrawal ( aa3se )
 */

// Don't forget to include the appropriate import statements

public class PrintQueue {
    
    /**
     * Printer's list of documents
     */
    private LinkedList<String> toPrint;    
    
    /**
     * A Reentrant lock
     */
    private Lock documentChangeLock;  
    
    /**
     * A Condition object
     */
    private Condition hasPrintTask;   
    
    /**
     * Describes if the queue is on (accepting jobs)
     */
    private static boolean isOn;

    /**
     * Constructor
     */
    public PrintQueue() {
        toPrint = new LinkedList<String>(); // create the list of documents
        isOn = true; // turn on the print queue
        documentChangeLock = new ReentrantLock();
        documentChangeLock.lock();
        hasPrintTask = documentChangeLock.newCondition();
        documentChangeLock.unlock();
    }

    /**
     * Removes the head element off the queue and returns it. Returns a String.
     * 
     * @return The head element off the queue
     */
    public String dequeue() {
        try {
            documentChangeLock.lock();
            while (toPrint.isEmpty() && isOn) { // do not dequeue if the queue is empty and on
                hasPrintTask.await(); // wait for queue to be not empty
            }
            if(toPrint.isEmpty()) { // queue is off and empty
                return null;
            }
            return toPrint.remove(); // queue is on and not empty, so remove 
        } 
        catch (InterruptedException e) {
            return null;
        }
        finally {
            documentChangeLock.unlock();
        }

    }

    /**
     * Adds the greeting given by String s onto the end of the print queue.
     * 
     * @param s The string to be added onto the end of the print queue.
     */
    public void enqueue(String s) {
        try {
            documentChangeLock.lock();
            toPrint.add(s); // add to the list of documents
            hasPrintTask.signalAll(); // queue is no empty anymore
        } finally {
            documentChangeLock.unlock();
        }
    }

    /**
     * Turns off the print queue.
     */
    public void turnOff() {
        isOn = false;
        documentChangeLock.lock();
        hasPrintTask.signalAll();
        documentChangeLock.unlock();

    }

    /**
     * Checks if the printQueue is still accepting jobs. Returns true if it is accepting jobs.
     * 
     * @return Whether or not the printQueue is still accepting jobs
     */
    public boolean isOn() {
        return isOn;
    }

}
