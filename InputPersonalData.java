import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class InputPersonalData {
    private String surname; // фамилия
    private String name; // имя
    private String patronymic; // отчество
    private Date birthDay; // дата_рождения - строка формата dd.mm.yyyy
    private long phoneNumber; // номер_телефона - целое беззнаковое число без форматирования
    private boolean gender; // пол - символ латиницей f или m.

    private InputPersonalData(String surname, String name, String patronymic, Date birthDay, long phoneNumber, boolean gender) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDay = birthDay;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getSurname() {
        return surname;
    }
    public String getName() {
        return name;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public Date getBirthDay() {
        return birthDay;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public boolean isGender() {
        return gender;
    }

    public static InputPersonalData inputData () throws IncorrectPersonalDataException, NameLengthPersonalDataException, NameIncorrectSymbPersonalDataException,
                                    BirthdayLengthPersonalDataException, BirthdayIncorrectSymbPersonalDataException,
                                    PhoneNumberLengthPersonalDataException, PhoneNumberIncorrectSymbPersonalDataException,
                                    GenderLengthPersonalDataException, GenderIncorrectSymbPersonalDataException,
                                    NullPointerException
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите через пробел: \"фамилию\" (2-25 русских буквы), \"имя\" (2-16 русских буквы), \"отчество\" (2-16 русских буквы)," +
                           "  \"дату рождения\" (dd.mm.yyyy), \"номер телефона\" (3-11 цифры), \"пол\" (m | f):");

        String data = in.nextLine().replaceAll("\\s+", " "); // Обработать несколько подряд идущих пробелов

        if (data == null) {
            throw new NullPointerException("Введенные данные не соответствуют шаблону NullPointerException is activated...");
        }

        String[] dataArray = data.split(" ");

        if (dataArray.length != 6 ) {
            throw new IncorrectPersonalDataException("Введенные данные не соответствуют шаблону IncorrectPersonalDataException is activated...", dataArray.length);
        }

        //Фамилия: min - 2, max - 25
        if (dataArray[0] == null) {
            throw new NameLengthPersonalDataException("Длина фамилии некорректна NameLengthPersonalDataException is activated...", "");
        } else if (dataArray[0].length() < 2 || dataArray[0].length() > 25) {
            throw new NameLengthPersonalDataException("Длина фамилии некорректна NameLengthPersonalDataException is activated...", dataArray[0]);
        } else if (!dataArray[0].matches("[а-яА-Я]{2,25}")) {
            throw new NameIncorrectSymbPersonalDataException("Некорректные символы в фамилии NameIncorrectSymbPersonalDataException is activated...", dataArray[0]);
        }
        //Имя: min - 2, max - 16
        if (dataArray[1] == null) {
            throw new NameLengthPersonalDataException("Длина имени некорректна NameLengthPersonalDataException is activated...", "");
        } else if (dataArray[1].length() < 2 || dataArray[1].length() > 16) {
            throw new NameLengthPersonalDataException("Длина имени некорректна NameLengthPersonalDataException is activated...", dataArray[1]);
        } else if (!dataArray[1].matches("[а-яА-Я]{2,16}")) {
            throw new NameIncorrectSymbPersonalDataException("Некорректные символы в имени NameIncorrectSymbPersonalDataException is activated...", dataArray[1]);
        }
        //Отчество: min - 5, max - 16
        if (dataArray[2] == null) {
            throw new NameLengthPersonalDataException("Длина отчества некорректна NameLengthPersonalDataException is activated...", "");
        } else if (dataArray[2].length() < 5 || dataArray[2].length() > 16) {
            throw new NameLengthPersonalDataException("Длина отчества некорректна NameLengthPersonalDataException is activated...", dataArray[2]);
        } else if (!dataArray[2].matches("[а-яА-Я]{5,16}")) {
            throw new NameIncorrectSymbPersonalDataException("Некорректные символы в отчестве NameIncorrectSymbPersonalDataException is activated...", dataArray[2]);
        }

        //Дата рождения 01.01.1991
        Date birthday;
        if (dataArray[3] == null) {
            throw new BirthdayLengthPersonalDataException("Некорректное число символов в дате рождения BirthdayIncorrectSymbPersonalDataException is activated...", "");
        } else if (dataArray[3].length() != 10 ) {
            throw new BirthdayLengthPersonalDataException("Некорректное число символов в дате рождения BirthdayIncorrectSymbPersonalDataException is activated...", dataArray[3]);
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
            try {
                birthday = formatter.parse(dataArray[3]);
            } catch (ParseException e) {
                throw new BirthdayIncorrectSymbPersonalDataException("Некорректные символы в дате рождения BirthdayIncorrectSymbPersonalDataException is activated...", dataArray[3]);
            }
        }

        //Номер телефона 123 до 81234567890
        long phoneNumber;
        if (dataArray[4] == null) {
            throw new PhoneNumberLengthPersonalDataException("Некорректное число символов в телефоне PhoneNumberLengthPersonalDataException is activated...", "");
        } else if (dataArray[4].length() < 3 || dataArray[4].length() > 11) {
            throw new PhoneNumberLengthPersonalDataException("Некорректное число символов в телефоне PhoneNumberLengthPersonalDataException is activated...", dataArray[4]);
        } else {
            try {
                phoneNumber = Long.parseLong(dataArray[4]);
            } catch (NumberFormatException e) {
                throw new PhoneNumberIncorrectSymbPersonalDataException("Некорректное символы в телефоне PhoneNumberIncorrectSymbPersonalDataException is activated...", dataArray[4]);
            }
        }

        //Пол m - мужской, f - женский
        boolean gender = false;
        if (dataArray[5] == null) {
            throw new GenderLengthPersonalDataException("Некорректное число символов в описании пола PhoneNumberLengthPersonalDataException is activated...", "");
        } else if (dataArray[5].length() != 1) {
            throw new GenderLengthPersonalDataException("Некорректное число символов в описании пола PhoneNumberLengthPersonalDataException is activated...", dataArray[5]);
        } else if (!"mf".contains(dataArray[5])) {
            throw new GenderIncorrectSymbPersonalDataException("Некорректное символы в описании пола PhoneNumberIncorrectSymbPersonalDataException is activated...", dataArray[5]);
        } else if ("m".contains(dataArray[5])) {
            gender = true;
        }

        InputPersonalData ipd = null;
        try {
            ipd = new InputPersonalData(dataArray[0], dataArray[1], dataArray[2], birthday, phoneNumber, gender);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return ipd;
    }

}