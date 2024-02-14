public class GenderIncorrectSymbPersonalDataException extends CommonPersonalDataException{

    private final String gender;
    public String getGender() {
        return gender;
    }
    public GenderIncorrectSymbPersonalDataException(String message, String gender) {
        super(message);
        this.gender = gender;
    }

}
