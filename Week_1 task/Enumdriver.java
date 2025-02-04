enum DaysOfWeek{
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;
}

public class Enumdriver{
    public static void main(String[] args){
        DaysOfWeek day = DaysOfWeek.SUNDAY;

        if (day == DaysOfWeek.SATURDAY || day == DaysOfWeek.SUNDAY){
            System.out.println("Holiday");
        } 
        else
        {
            System.out.println("Not Holiday");
        }
    }
}