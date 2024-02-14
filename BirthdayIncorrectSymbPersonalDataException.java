public class BirthdayIncorrectSymbPersonalDataException extends CommonPersonalDataException {

    private final String birthday;
    public String getBirthday() {
        return this.birthday;
    }
    public BirthdayIncorrectSymbPersonalDataException(String message, String birthday) {
        super(message);
        this.birthday = birthday;
    }

}
