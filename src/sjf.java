import java.util.*;

public class SJF {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes:");
        int n = sc.nextInt();
        int pid[] = new int[n];
        int at[] = new int[n]; // at means arrival time
        int bt[] = new int[n]; // bt means burst time
        int ct[] = new int[n]; // ct means complete time
        int ta[] = new int[n]; // ta means turn around time
        int wt[] = new int[n]; // wt means waiting time
        int st = 0, completedProcesses = 0;
        float avgwt = 0, avgta = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter process " + (i + 1) + " arrival time:");
            at[i] = sc.nextInt();
            System.out.println("Enter process " + (i + 1) + " burst time:");
            bt[i] = sc.nextInt();
            pid[i] = i + 1;
        }
        
        while (completedProcesses < n) {
            int c = n, min = 999;
            for (int i = 0; i < n; i++) {
                if (at[i] <= st && bt[i] < min && bt[i] > 0) {
                    min = bt[i];
                    c = i;
                }
            }
            if (c == n)
                st++;
            else {
                ct[c] = st + bt[c];
                st += bt[c];
                ta[c] = ct[c] - at[c];
                wt[c] = ta[c] - bt[c];
                bt[c] = 0; // Mark the process as completed
                completedProcesses++;
            }
        }

        System.out.println("\npid  arrival burst  complete turn waiting");
        for (int i = 0; i < n; i++) {
            avgwt += wt[i];
            avgta += ta[i];
            System.out.println(pid[i] + "\t" + at[i] + "\t" + bt[i] + "\t" + ct[i] + "\t" + ta[i] + "\t" + wt[i]);
        }
        System.out.println("\nAverage turn around time is " + (float) (avgta / n));
        System.out.println("Average waiting time is " + (float) (avgwt / n));
        sc.close();
    }
}
