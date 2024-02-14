//    Фамилия Имя Отчество дата_рождения номер_телефона пол // СДЕЛАНО
//
//    Форматы данных: // СДЕЛАНО
//      фамилия, имя, отчество - строки // СДЕЛАНО
//      дата_рождения - строка формата dd.mm.yyyy // СДЕЛАНО
//      номер_телефона - целое беззнаковое число без форматирования // СДЕЛАНО
//      пол - символ латиницей f или m. // СДЕЛАНО
//
//    Приложение должно проверить введенные данные по количеству. Если количество не совпадает, // СДЕЛАНО
//    вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется. // СДЕЛАНО
//
//    Приложение должно распарсить полученную строку и выделить из них требуемые значения. // СДЕЛАНО
//    Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. // СДЕЛАНО
//    Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, // СДЕЛАНО
//    пользователю выведено сообщение с информацией, что именно неверно. // СДЕЛАНО
//
//    Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, // СДЕЛАНО
//    в него в одну строку должны записаться полученные данные, вида // СДЕЛАНО
//    <Фамилия> <Имя> <Отчество> <дата _ рождения> <номер _ телефона> <пол> // СДЕЛАНО
//
//    Однофамильцы должны записаться в один и тот же файл, в отдельные строки. // СДЕЛАНО
//    Не забудьте закрыть соединение с файлом. // СДЕЛАНО
//    При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, // СДЕЛАНО
//    пользователь должен увидеть стектрейс ошибки. // СДЕЛАНО

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanInput = new Scanner(System.in);
        String command = "";

        while (!command.equals("q")) {

            try {
                InputPersonalData imd = InputPersonalData.inputData();
                System.out.println("Данные введены корректно!");

                try ( FileWriter fw = new FileWriter(imd.getSurname() + ".txt", true)) {
                    StringBuilder sb = new StringBuilder(imd.getSurname());
                    sb.append(", ").append(imd.getName()).append(", ").append(imd.getPatronymic());
                    sb.append(", ").append(imd.getBirthDay()).append(", ").append(imd.getPhoneNumber());
                    sb.append(", ").append((imd.isGender()) ? "m" : "f").append("\n");
                    fw.write(sb.toString());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }

            } catch (IncorrectPersonalDataException e) {
                System.out.println(e.getMessage() + " :[количество введенных частей: " + e.getNumberPartsOfData() + "]");

            } catch (NameLengthPersonalDataException e) {
                System.out.println(e.getMessage() + " :[" + e.getNameLength() + "]");

            } catch (NameIncorrectSymbPersonalDataException e) {
                System.out.println(e.getMessage() + " :[" + e.getName() + "]");

            } catch (BirthdayLengthPersonalDataException e) {
                System.out.println(e.getMessage() + " :[" + e.getBirthdayLength() + "]");

            } catch (BirthdayIncorrectSymbPersonalDataException e) {
                System.out.println(e.getMessage() + " :[" + e.getBirthday() + "]");

            } catch (PhoneNumberLengthPersonalDataException e) {
                System.out.println(e.getMessage() + " :[" + e.getPhoneLength() + "]");

            } catch (PhoneNumberIncorrectSymbPersonalDataException e) {
                System.out.println(e.getMessage() + " :[" + e.getPhone() + "]");

            } catch (GenderLengthPersonalDataException e) {
                System.out.println(e.getMessage() + " :[" + e.getGenderLength() + "]");

            } catch (GenderIncorrectSymbPersonalDataException e) {
                System.out.println(e.getMessage() + " :[" + e.getGender() + "]");

            } catch (NullPointerException e) {
                System.out.println(e.getMessage());

            } finally {
                System.out.println("Выход - q; Продолжить - любой другой символ");
                command = scanInput.nextLine();
            }

        }
    }

}