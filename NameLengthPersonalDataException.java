public class NameLengthPersonalDataException extends CommonPersonalDataException {

    private final int nameLength;
    public int getNameLength() {
        return nameLength;
    }

    public NameLengthPersonalDataException(String message, String name) {
        super(message);
        this.nameLength = name.length();
    }

}
