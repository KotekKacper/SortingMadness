package pl.put.poznan.sorter.logic;

/**
 * This class is used to measure time of sorting
 */
public class MyTimer {
    /**
     * Stores the start time of sorting
     */
    long start;
    /**
     * Stores the end time of sorting
     */
    long end;

    /**
     * Starts the timer
     */
    public void go(){
        this.start = System.nanoTime();
    }
    /**
     * Stops the timer
     */
    public void stop(){
        this.end = System.nanoTime();
    }
    /**
     * Returns the time of sorting in milliseconds
     * @return Time of sorting
     */
    public long getTimeMilli(){
        return getTimeNano() / 1_000_000;
    }
    /**
     * Returns the time of sorting in microseconds
     * @return Time of sorting
     */
    public long getTimeMicro() {
        return getTimeNano() / 1_000;
    }
    /**
     * Returns the time of sorting in nanoseconds
     * @return Time of sorting
     */
    public long getTimeNano(){
        return (this.end - this.start);
    }
}
