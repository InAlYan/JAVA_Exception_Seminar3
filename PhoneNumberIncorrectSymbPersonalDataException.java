public class PhoneNumberIncorrectSymbPersonalDataException extends CommonPersonalDataException {

    private final String phone;
    public String getPhone() {
        return phone;
    }
    public PhoneNumberIncorrectSymbPersonalDataException(String message, String phone) {
        super(message);
        this.phone = phone;
    }

}
