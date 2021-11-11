public class Seconds_and_minutes {

    public static String getDurationString(long minutes, long seconds){

        if(minutes < 0 || seconds < 0 || seconds > 59){
            return "Invalid Value";
        }

        long hours = minutes/60;
        long remainingMinutes = minutes%60;
        return hours + "hr " + remainingMinutes + "min " + seconds + "sec";

        //To print along with leading zeros for one digit number

    }

    public static String getDurationString(long seconds){

        if( seconds < 0){
            return "Invalid value";
        }

        long minutes = seconds / 60;
        seconds = seconds % 60;
        return getDurationString(minutes, seconds);
    }
}
