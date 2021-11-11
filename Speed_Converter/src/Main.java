public class Main {

    public static void main(String[] args){

        long miles = SpeedConverter.toMilesPerHour(10.5);
        System.out.println("Miles = " + miles);

        SpeedConverter.printConversion(10.5);
        String time = Seconds_and_minutes.getDurationString(34653);
        System.out.println(time);
    }
}
