public class NameIncorrectSymbPersonalDataException extends CommonPersonalDataException {

    private final String name;
    public String getName() {
        return name;
    }

    public NameIncorrectSymbPersonalDataException(String message, String name) {
        super(message);
        this.name = name;
    }

}
