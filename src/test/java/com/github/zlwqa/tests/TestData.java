package com.github.zlwqa.tests;

import com.github.javafaker.Faker;

public class TestData {

    public static final String MVIDEO_URL = "https://www.mvideo.ru/";
    public static String
            studentNameResultField = "Student Name",
            studentEmailResultField = "Student Email",
            genderResultField = "Gender",
            mobileResultField = "Mobile",
            dateOfBirthResultField = "Date of Birth",
            subjectsResultField = "Subjects",
            hobbiesResultField = "Hobbies",
            pictureResultField = "Picture",
            addressResultField = "Address",
            stateAndCityResultField = "State and City",
            gender = "Male",
            day = "29",
            month = "July",
            year = "1997",
            subject = "computer science",
            hobbie = "Reading",
            pictureName = "z.jpg",
            state = "haryana",
            city = "panipat";


    public static Faker faker = new Faker();

    public static String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.name().username() + "@gmail.com",
            numberPhone = faker.phoneNumber().subscriberNumber(10),
            address = faker.address().fullAddress();

}
