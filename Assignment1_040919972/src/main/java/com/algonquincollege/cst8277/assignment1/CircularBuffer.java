/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: CircularBuffer.java
 * Course materials (19F) CST 8277
 * @author (original) Mike Norman, derived from code by Deitel & Associates, Inc.
 *         (Notes: Fig. 23.18: CircularBuffer.java Synchronizing access to a shared bounded buffer)
 *
 * (C) Copyright 1992-2015 by Deitel & Associates, Inc. and
 * Pearson Education,Inc.
 * All Rights Reserved.
 *
 * DISCLAIMER: The authors and publisher of this book have used their
 * best efforts in preparing the book. These efforts include the
 * development, research, and testing of the theories and programs to determine their
 * effectiveness. The authors and publisher make no warranty of any kind,
 * expressed or implied, with regard to these programs or to the
 * documentation contained in these books. The authors and publisher
 * shall not be liable in any event for incidental or
 * consequential damages in connection with, or arising out of, the
 * furnishing, performance, or use of these programs.
 *
 *************************************************************************/
package com.algonquincollege.cst8277.assignment1;

/**
 *
 * Description: Implements the
 * {@link com.algonquincollege.cst8277.assignment1.Buffer} interface using a
 * CircularBuffer </br>
 *
 * @date (modified) 2019 09 18
 *
 * @author Gloria Omoba Student 040-919-972
 *
 * @param <E> the element type held in the buffer
 */
public class CircularBuffer<E> implements Buffer<E> {
    protected E[] bufArray;
    // TODO additional required member fields

    private int occupiedCells = 0; // count number of buffers used
    private int writeIndex = 0; // index of next element to write to
    private int readIndex = 0; // index of next element to read

    /**
     * Constructor builds a buffer of the specified size
     * 
     * @param capacity
     */
    @SuppressWarnings("unchecked")
    public CircularBuffer(int capacity) {
        bufArray = (E[]) new Object[capacity];

    }

    @Override
    /**
     * Add element to buffer (thread-safe); if no room, block
     * 
     * @param element
     */
    public synchronized void blockingPut(E element) throws InterruptedException {
        // place thread in blocked state while there are no empty locations
        while (occupiedCells == bufArray.length) {
            System.out.print("Buffer is full. Producer is in waiting state.");
            wait();
        }
        bufArray[writeIndex] = element; // new buffer value
        // update circular write index
        writeIndex = (writeIndex + 1) % bufArray.length;
        ++occupiedCells; // increment number of occupied cells;
        displayState("Producer writes " + element);
        notifyAll();
    }

    @Override
    /**
     * Remove element from buffer (thread-safe); if none, block
     *
     * @return element
     */
    public synchronized E blockingGet() throws InterruptedException {
        // place thread in a waiting state while there is no data to read
        while (occupiedCells == 0) {
            System.out.print("Buffer is empty. Consumer is in wait state.");
            wait(); // wait until a buffer cell is filled
        }
        E readElement = bufArray[readIndex]; // read value from buffer

        readIndex = (readIndex + 1) % bufArray.length; // update circular read index
        --occupiedCells; // decrement number of occupied cells
        notifyAll();
        displayState("Consumer reads " + readElement);
        return readElement;
    }

    // display current operation and buffer state
    public synchronized void displayState(String operation) {
        // output operation and number of occupied buffer cells
        System.out.printf("%s%s%d)%n%s", operation, " (buffer cells occupied: ", occupiedCells, "buffer cells:  ");

        for (E element : bufArray) {
            System.out.printf(" %s  ", element); // output values in buffer
        }

        System.out.printf("%n               ");

        for (int i = 0; i < bufArray.length; i++) {
            System.out.print("---- ");
        }

        System.out.printf("%n               ");

        for (int i = 0; i < bufArray.length; i++) {
            if (i == writeIndex && i == readIndex) {
                System.out.print(" WR"); // both write and read index
            } else if (i == writeIndex) {
                System.out.print(" W  "); // just write index
            } else if (i == readIndex) {
                System.out.print("  R  "); // just read index
            } else {
                System.out.print("  "); // neither index
            }
        }

        System.out.printf("%n%n");
    }

}