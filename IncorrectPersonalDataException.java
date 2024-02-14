public class IncorrectPersonalDataException extends CommonPersonalDataException {

    private final int numberPartsOfData;
    public int getNumberPartsOfData() {
        return this.numberPartsOfData;
    }
    public IncorrectPersonalDataException(String message, int numberPartsOfData) {
        super(message);
        this.numberPartsOfData = numberPartsOfData;
    }

}
