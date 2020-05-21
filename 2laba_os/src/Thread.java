
public class Thread {
	private String id;
	private int maxTime;
	private int currentTime;
	private int requiredTime;

    public Thread(String info, int requiredTime, int maxTime)
    {
        this.maxTime = maxTime;
        this.requiredTime = requiredTime;
        this.currentTime = 0;
        this.id = "Поток " + info;
    }

    public String getId() {
		return id;
	}
    
    public int getMaxTime() {
		return maxTime;
	}
    
    public int getCurrentTime() {
		return currentTime;
	}
    
    public int getRequiredTime() {
		return requiredTime;
	}
    
    public void execute()
    {
        currentTime++;
        System.out.println(getInfo());
    }

    public boolean needTime()
    {
        return requiredTime > currentTime;
    }

    public boolean haveTime()
    {
        return maxTime > currentTime;
    }

    public String getInfo()
    {
        return id + " maxTime:" + maxTime +
            " currentTime:" + currentTime + " requiredTime:" + requiredTime;
    }
}
