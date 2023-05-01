package training360.airplanes.exceptions;

public class AirplaneNotFoundException extends RuntimeException {

    public AirplaneNotFoundException(String message) {
        super(message);
    }
}
