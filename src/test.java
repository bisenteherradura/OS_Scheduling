import java.util.Scanner;

public class test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("[1] FCFS");
        System.out.println("[2] SJF");
        System.out.println("[3] SRTF");
        System.out.print("Choose an algorithm: ");
        int alg = sc.nextInt();

        switch (alg) {
            case 1:
                System.out.print("Enter number of processes: ");
                int pr = sc.nextInt();

                String[] pn = new String[pr];
                int[] at = new int[pr];
                int[] bt = new int[pr];
                int[] st = new int[pr];
                int[] et = new int[pr];
                int[] wt = new int[pr];
                int[] tat = new int[pr];

                for (int i = 0; i < pr; i++) {
                    System.out.print("Enter process name: ");
                    pn[i] = sc.next();
                    System.out.print("Enter arrival time: ");
                    at[i] = sc.nextInt();
                    System.out.print("Enter burst time: ");
                    bt[i] = sc.nextInt();
                }
                for(int i = 0; i < pr; i++){
                    if(i == 0){
                        st[i] = at[i];
                    } else {
                        st[i] = et[i - 1];
                    }

                    et[i] = st[i] + bt[i];
                    wt[i] = st[i] - at[i];
                    tat[i] = et[i] - at[i];

                }

                double awt = 0;
                double att = 0;
                int trp;

                for(int i = 0; i < pr; i++){
                    awt += wt[i];
                    att += tat[i];
                }

                int ttime = 0;
                for(int val : bt){
                    ttime += val;
                }

                awt /= pr;
                att /= pr;
                trp = (int) ((double) pr / ttime * 100);

                System.out.println("");

                System.out.println("AWT = "+awt);
                System.out.println("ATT = "+att);
                System.out.println("Throughput = "+trp+ "%");


                    break;
            case 2:

                break;
                }

    }
}
