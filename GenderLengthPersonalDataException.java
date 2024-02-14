public class GenderLengthPersonalDataException extends CommonPersonalDataException{

    private final int genderLength;
    public int getGenderLength() {
        return this.genderLength;
    }
    public GenderLengthPersonalDataException(String message, String gender) {
        super(message);
        this.genderLength = gender.length();
    }

}
