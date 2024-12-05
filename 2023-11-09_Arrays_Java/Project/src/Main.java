import java.util.Scanner;

public class Main
{
    public static final int QUIT = 999;
    public static int[] counts = new int[6];
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
    {
        int depMain;
        depMain = getReady();
        while(depMain!=QUIT)
        {
         countDependents(depMain);
         depMain = getReady();
        }
        finishUp();
    }
    public static int getReady()
    {
        int dep;
        int[] acceptableAnswers = {0,1,2,3,4,5,QUIT};
        boolean bln = false;
        System.out.print("Enter dependents or type " + QUIT + " to quit: ");
        dep = input.nextInt();
        input.nextLine();

        do
        {
            for(int i = 0; i < acceptableAnswers.length; i++)
            {
                if(acceptableAnswers[i] == dep)
                {
                    bln = true;
                    break;
                }
            }


            if(!bln)
            {
                System.out.print("Invalid response, follow directions better.\nEnter dependents or type " + QUIT + " to quit: ");
                dep = input.nextInt();
                input.nextLine();
            }

        }
        while(!bln);
        System.out.println("Thanks, we have added you to the " + dep + " dependent category.");

        return dep;

    }
    public static void countDependents(int depChoice)
    {
        counts[depChoice] ++;
    }
    public static void finishUp()
    {
        System.out.println("Dependents Count:");
        for(int i = 0; i<counts.length; i++)
        {
            System.out.println(i + " " + counts[i]);
        }
    }
}