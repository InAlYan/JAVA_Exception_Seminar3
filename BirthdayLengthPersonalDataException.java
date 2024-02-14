public class BirthdayLengthPersonalDataException extends CommonPersonalDataException{

    private final int birthdayLength;
    public int getBirthdayLength() {
        return this.birthdayLength;
    }
    public BirthdayLengthPersonalDataException(String message, String birthday) {
        super(message);
        this.birthdayLength = birthday.length();
    }

}
