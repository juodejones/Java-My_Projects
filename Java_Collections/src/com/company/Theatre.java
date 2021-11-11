package com.company;

import java.util.ArrayList;
import java.util.List;

public class Theatre {

    private final String theatreName;
    private List<Seat> seats = new ArrayList<Seat>();

    public Theatre(String theatreName, int numberOfRows, int seatsInRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numberOfRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNumber = 1; seatNumber <= seatsInRow; seatNumber++) {
                Seat seat = new Seat(row + String.format("%02d", seatNumber));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public void getSeats() {
        for (Seat seat : seats) {
            System.out.println(seat.getSeatNumber());
        }
    }

    public boolean reserveSeat(String seatNumber) {
//        Seat requestedSeat = new Seat(seatNumber);
//        for (Seat seat : seats) {
//            System.out.print(".");
//            if (seat.getSeatNumber().equals(seatNumber)) {
//                requestedSeat = seat;
//                break;
//            }
//        }
//        if (requestedSeat == null) {
//            System.out.println("This seat cannot be booked.");
//            return false;
//        }
//        return requestedSeat.reserve();

        int low = 0, high = (seats.size()-1), mid;
        while (low <= high) {
            System.out.print(".");
            mid = (low + high) / 2;
            Seat midVal = seats.get(mid);
            int compare = midVal.getSeatNumber().compareTo(seatNumber);

            if (compare < 0)  {
                low = mid + 1;
            } else if (compare > 0) {
                high = mid - 1;
            } else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("This seat cannot be reserved.");
        return false;
    }

    private class Seat implements Comparable<Seat>{

        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean reserve() {
            if (!this.reserved) {
                this.reserved = true;
                System.out.println("The seat " + seatNumber + " has been reserved.");
                return true;
            }
            return false;
        }

        public boolean cancel() {
            if (this.reserved) {
                this.reserved = false;
                System.out.println("The seat " + seatNumber + " reservation has been cancelled.");
                return true;
            }
            return false;
        }

        @Override
        public int compareTo(Seat o) {
            return this.seatNumber.compareToIgnoreCase(o.getSeatNumber());
        }
    }
}
