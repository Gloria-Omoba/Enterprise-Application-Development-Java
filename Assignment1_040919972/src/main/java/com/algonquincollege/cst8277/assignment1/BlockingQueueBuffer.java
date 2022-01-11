/**************************************************************G*********o****o****g**o****og**joob*********************
 * File: BlockingQueueBuffer.java
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

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Description: Implements the
 * {@link com.algonquincollege.cst8277.assignment1.Buffer} interface using
 * {@link ArrayBlockingQueue}
 *
 * @date (modified) 2019 09 18
 *
 * @author Gloria Omoba Student 040-919-972
 *
 * @param <E> the element type held in the buffer
 */
public class BlockingQueueBuffer<E> implements Buffer<E> {

    // TODO - member fields
    private final ArrayBlockingQueue<E> blockingArray; // shared buffer

    /**
     * Constructor builds a buffer of the specified size
     * 
     * @param capacity
     */

    public BlockingQueueBuffer(int capacity) {
        blockingArray = new ArrayBlockingQueue<E>(capacity);
    }

    /**
     * Add element to buffer (thread-safe); if no room, block
     * 
     * @param element
     */
    public void blockingPut(E element) throws InterruptedException {
        blockingArray.put(element); // place value in buffer
        System.out.printf("Producer writes: %s. Buffer cells Occupied: %d ", element, blockingArray.size());
    }

    /**
     * Remove element from buffer (thread-safe); if none, block
     *
     * @return element
     */
    public E blockingGet() throws InterruptedException {
        E readValue = blockingArray.take(); // remove element from buffer
        System.out.printf("Consumer reads: %s. Buffer cells occupied: %d ", readValue.toString(), blockingArray.size());
        return readValue;

    }
}
