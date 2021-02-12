package week3;

import java.util.Scanner;

public class CrossCountryAssignment {
    public static void main(String[] args) {
        //Runner One
        String runnerOneName = setup();
        double runnerOneSplit1 = getSplit1();
        double runnerOneSplit2 = getSplit2();
        double runnerOneSplit3 = getSplit3();
        String runnerOneFinalTime = getFinalTime(runnerOneSplit1, runnerOneSplit2, runnerOneSplit3);
        System.out.println("\n****** Race Summary For: "+runnerOneName+" (Runner 1) ******");
        System.out.println("----------------------------------------------------");
        System.out.println("| Time at mile marker 1 (Split 1): "+secondsToMinutes(runnerOneSplit1)+"        |");
        System.out.println("| Time at mile marker 2 (Split 2): "+secondsToMinutes(runnerOneSplit2)+"        |");
        System.out.println("| Time at the end of the race (Split 3): "+secondsToMinutes(runnerOneSplit3)+"  |");
        System.out.println("----------------------------------------------------");
        System.out.println("Total time to finish the race for "+runnerOneName+": "+runnerOneFinalTime);
        
        //Runner Two
        String runnerTwoName = newRunner();
        double runnerTwoSplit1 = getSplit1();
        double runnerTwoSplit2 = getSplit2();
        double runnerTwoSplit3 = getSplit3();
        String runnerTwoFinalTime = getFinalTime(runnerTwoSplit1, runnerTwoSplit2, runnerTwoSplit3);
        System.out.println("\n****** Race Summary For: "+runnerTwoName+" (Runner 2) ******");
        System.out.println("----------------------------------------------------");
        System.out.println("| Time at mile marker 1 (Split 1): "+secondsToMinutes(runnerTwoSplit1)+"        |");
        System.out.println("| Time at mile marker 2 (Split 2): "+secondsToMinutes(runnerTwoSplit2)+"        |");
        System.out.println("| Time at the end of the race (Split 3): "+secondsToMinutes(runnerTwoSplit3)+"  |");
        System.out.println("----------------------------------------------------");
        System.out.println("Total time to finish the race for "+runnerTwoName+": "+runnerTwoFinalTime);
        
        //Runner Three
        String runnerThreeName = newRunner();
        double runnerThreeSplit1 = getSplit1();
        double runnerThreeSplit2 = getSplit2();
        double runnerThreeSplit3 = getSplit3();
        String runnerThreeFinalTime = getFinalTime(runnerThreeSplit1, runnerThreeSplit2, runnerThreeSplit3);
        System.out.println("\n****** Race Summary For: "+runnerThreeName+" (Runner 3) ******");
        System.out.println("----------------------------------------------------");
        System.out.println("| Time at mile marker 1 (Split 1): "+secondsToMinutes(runnerThreeSplit1)+"        |");
        System.out.println("| Time at mile marker 2 (Split 2): "+secondsToMinutes(runnerThreeSplit2)+"        |");
        System.out.println("| Time at the end of the race (Split 3): "+secondsToMinutes(runnerThreeSplit3)+"  |");
        System.out.println("----------------------------------------------------");
        System.out.println("Total time to finish the race for "+runnerThreeName+": "+runnerThreeFinalTime);
        System.out.println("\nThank you for using Race Split Calculator, goodbye!");
    }

    /**
     * Allows the user to input the name of another runner 
     * @return
     */
    private static String newRunner() {
        System.out.println("\n------ Add Another Runner ------ ");
        System.out.print("What is the name of the new runner?: ");
        Scanner in = new Scanner(System.in);
        String name = (in.nextLine());
        return name;
    }

    /**
     * Converts seconds into minutes, useful for displaying the runner's split time at every checkpoint
     * @param numOfSeconds is the number of seconds that needs to be converted to minutes 
     * @return
     */
    private static String secondsToMinutes(double numOfSeconds) {
        int milliseconds = (int)(numOfSeconds*1000)%1000;
        String newMilliseconds = ""+milliseconds;
        String formattedNewMilliseconds = ("000" + newMilliseconds).substring(newMilliseconds.length());
        int minutes = (int)(numOfSeconds % 3600)/60;
        int seconds = (int)numOfSeconds % 60;
        String newSeconds = ""+seconds;
        String formattedNewSeconds = ("00" + newSeconds).substring(newSeconds.length());
        return minutes+":"+formattedNewSeconds+"."+formattedNewMilliseconds;
    }

    /**
     * Calculates the final time, adds the split times in seconds and converts answer into minutes
     * @param split1 Split time 1
     * @param split2 Split time 2
     * @param split3 Split time 3
     * @return
     */
    private static String getFinalTime(double split1, double split2, double split3) {
        double numOfSeconds = split1+split2+split3;
        int milliseconds = (int)(numOfSeconds*1000)%1000;
        String newMilliseconds = ""+milliseconds;
        String formattedNewMilliseconds = ("000" + newMilliseconds).substring(newMilliseconds.length());
        int minutes = (int)(numOfSeconds % 3600)/60;
        int seconds = (int)numOfSeconds % 60;
        String newSeconds = ""+seconds;
        String formattedNewSeconds = ("00" + newSeconds).substring(newSeconds.length());
        return minutes+":"+formattedNewSeconds+"."+formattedNewMilliseconds;
    }

    /**
     * Allows the user to input their third split time then converts to seconds using convertToSeconds()
     * @return split3 in seconds 
     */
    private static double getSplit3() {
        System.out.print("What was the runner's third split time at the end of the race?: ");
        Scanner in = new Scanner(System.in);
        String baseSplit = (in.nextLine());
        double finalSplit3 = convertToSeconds(baseSplit);
        return finalSplit3;
    }

    /**
     * Allows the user to input their second split time then converts to seconds using convertToSeconds()
     * @return split2 in seconds 
     */
    private static double getSplit2() {
        System.out.print("What was the runner's second split time at mile 2?: ");
        Scanner in = new Scanner(System.in);
        String baseSplit = (in.nextLine());
        double finalSplit2 = convertToSeconds(baseSplit);
        return finalSplit2;
    }

    /**
     * Allows the user to input their first split time then converts to seconds using convertToSeconds()
     * @return split1 in seconds 
     */
    private static double getSplit1() {
        System.out.print("What was the runner's first split time at mile 1?: ");
        Scanner in = new Scanner(System.in);
        String baseSplit = (in.nextLine());
        double finalSplit1 = convertToSeconds(baseSplit);
        return finalSplit1;
    }

    /**
     * Startup of the program 
     * Allows the user to input the first runner's name
     * @return the name of the runner
     */
    private static String setup() {
        System.out.println("---------- Race Split Calculator ----------");
        System.out.println("With this program you can enter the running\ndata for 3 different runners in a 5km race. \n");
        System.out.print("What is the name of the runner?: ");
        Scanner in = new Scanner(System.in);
        String name = (in.nextLine());
        return name;
    }

    /**
     * Takes a string of the split time and converts the value to seconds
     * @param timeString
     * @return time in seconds 
     */
    private static double convertToSeconds(String timeString) {
        int colon = timeString.indexOf(":");
        double minutesAsSeconds = Double.parseDouble(timeString.substring(0, colon))*60;
        double seconds = Double.parseDouble(timeString.substring(colon+1));
        return minutesAsSeconds + seconds;
    }
    
}
