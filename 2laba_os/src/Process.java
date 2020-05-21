import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Process {
	Random rand = new Random();

    public List<Thread> Threads;

    private String id;
    private int maxTime;
    private int currentTime;
    private int threadMaxTime;

    public Process(String id, int maxTime, int priority)
    {	
    	this.currentTime = 0;
        this.id = "Process " + id + " priority: " + priority;

        Threads = new ArrayList<Thread>();
        int threadsNum = rand.nextInt(4) + 1;
        threadMaxTime = this.maxTime / threadsNum;

        for (int i = 0; i < threadsNum; i++)
        {
            Threads.add(new Thread("" + i, rand.nextInt(10) + 1, threadMaxTime));
        }
    }

    public String getId() {
		return id;
	}
    
    public int getMaxTime() {
		return maxTime;
	}
    
    public void getCurrentTime() {
		currentTime++;
	}
    
    public int getThreadMaxTime() {
		return threadMaxTime;
	}
    
    public int getCount()
    {
        return Threads.size();
    }

    public boolean isEmpty()
    {
        return Threads.isEmpty();
    }

    public boolean haveTime()
    {
        return maxTime > currentTime;
    }
}
