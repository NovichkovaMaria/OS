import java.util.ArrayList;
import java.util.Random;

public class Main {
	  private static ArrayList<Process> Processes = new ArrayList<Process>();
      private static Random rand = new Random();
      private static int quant = 10;

      public static void main (String[] args) {  
          start();
          getInfo();
          realization();
      }

      private static void start()
      {
          for (int i = 0; i < rand.nextInt(5) + 1; i++)
          {
        	  int priority = 1 + (int) (Math.random() * 3);
        	  Processes.add(new Process("" + i, quant * priority, priority));
          }
      }
      
      private static void getInfo()
      {
          for (int i = 0; i < Processes.size(); i++)
          {
        	  System.out.println(Processes.get(i).getId() + " Threads: " + Processes.get(i).getCount());
          }

          System.out.println();
      }
      
      private static void realizationThreads(Process process)
      {
          if (!(process.getMaxTime() > 0))
          {
        	  System.out.println("Quantum of time less than 1");
        	  System.exit(0);
          }
          System.out.println("\n" + process.getId() + "  Max time: " + process.getMaxTime());
          int initialThreadsCount = process.Threads.size();
          int currentThreadsCount = process.Threads.size();
          for (int curThreadNum = 0; curThreadNum < currentThreadsCount;)
          {
              Thread thread = process.Threads.get(curThreadNum);
              while (thread.needTime())
              {
                  if (thread.haveTime())
                  {
                      thread.execute();
                      process.getCurrentTime();
                  }
                  else
                  {
                	  System.out.println("Max time " + 
                          "Поток " + (initialThreadsCount - currentThreadsCount) + " is up");			
                      break;
                  }
              }
              System.out.println(thread.getId() + " completed");
              process.Threads.remove(curThreadNum);
              currentThreadsCount--;
          }
      }
      
      private static void realization()
      {
          if (quant < 1)
          {
        	  System.out.println("Quantum of time less than 1");
              return;
          }
          while (!Processes.isEmpty())
          {
              for (int i = 0; i < Processes.size(); i++)
              {
                  if (Processes.get(i).haveTime())
                  {
                      if (!Processes.get(i).isEmpty())
                      {
                          realizationThreads(Processes.get(i));
                      }
                      else
                      {
                    	  System.out.println("All threads " + Processes.get(i).getId() + " are completed");
                          Processes.remove(i);
                          i--;
                      }
                  }
                  else
                  {
                      Processes.remove(i);
                      i--;
                  }
             }
          }
          System.out.println("All processes are completed");
      }  
}
