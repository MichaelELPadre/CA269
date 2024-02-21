import java.util.Scanner;


public class AlarmClock
{
    public static void main(String[] args) 
    {
     Scanner input = new Scanner(System.in);

    String first_line = input.nextLine();
    int hours = Integer.parseInt(first_line.substring(0, 2));
    int minutes = Integer.parseInt(first_line.substring(3, 5));


    String second_line = input.nextLine();
    int second_hours = Integer.parseInt(second_line.substring(0, 2));
    int second_minutes = Integer.parseInt(second_line.substring(3, 5));
    int false_alarms = 0;
    while(hours >= second_hours)
    {
     if(hours == second_hours && minutes < second_minutes)
      {
       break;
      }
     else{
     String recursive_line = input.nextLine();
     second_hours = Integer.parseInt(recursive_line.substring(0,2));
     second_minutes = Integer.parseInt(recursive_line.substring(3, 5));
     false_alarms += 1;
     }
    }
    System.out.println("false alarms: " + false_alarms);
}
}
