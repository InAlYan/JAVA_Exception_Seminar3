public class PhoneNumberLengthPersonalDataException extends CommonPersonalDataException {

    private final long phoneLength;
    public long getPhoneLength() {
        return this.phoneLength;
    }
    public PhoneNumberLengthPersonalDataException(String message, String phone) {
        super(message);
        this.phoneLength = phone.length();
    }

}
