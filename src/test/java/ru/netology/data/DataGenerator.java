package ru.netology.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.lang.String;

public class DataGenerator {

    private static Faker faker = new Faker(new Locale("ru"));

    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        int random = (int) (shift + Math.floor(Math.random() * 30));
        String date = LocalDate.now().plusDays(random).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        String[] cities = {"Москва", "Краснодар", "Санкт-Петербург", "Казань", "Челябинск"};
        int n = (int) Math.floor(Math.random() * cities.length);
        String city = cities[n];
        return city;
    }

    public static String generateName(String locale) {
       String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        String phone = faker.numerify("+7##########");
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}