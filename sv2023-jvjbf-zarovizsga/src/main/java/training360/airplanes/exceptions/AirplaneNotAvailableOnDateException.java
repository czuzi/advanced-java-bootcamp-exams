package training360.airplanes.exceptions;

public class AirplaneNotAvailableOnDateException extends RuntimeException {

    public AirplaneNotAvailableOnDateException(String message) {
        super(message);
    }
}
