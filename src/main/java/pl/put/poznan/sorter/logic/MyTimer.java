package pl.put.poznan.sorter.logic;

public class MyTimer {
    long start;
    long end;

    public void go(){
        this.start = System.nanoTime();
    }

    public void stop(){
        this.end = System.nanoTime();
    }

    public long getTimeMilli(){
        return getTimeNano() / 1_000_000;
    }

    public long getTimeMicro(){
        return  getTimeNano() / 1_000;
    }

    public long getTimeNano(){
        return (this.end - this.start);
    }
}
