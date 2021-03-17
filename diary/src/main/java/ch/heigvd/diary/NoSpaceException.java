package ch.heigvd.diary;

public class NoSpaceException extends Exception {
    public NoSpaceException(int dayNumber) {
        super("No more space in Day " + dayNumber);
    }
}
