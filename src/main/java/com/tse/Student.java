package com.tse;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class Student {

    private String firstName;
    private String lastName;
    private String date;
    private String gender;
    private String id;

    public Student(String firstName, String lastName, String date, String gender, String id) throws DateException, GenderException, IdException {
        setFirstName(firstName);
        setLastName(lastName);
        setDate(date);
        setGender(gender);
        setId(id);
    }

    public void setFirstName(String firstName) throws NullPointerException {
        if(firstName == null || firstName.isEmpty()){
            throw new NullPointerException("First name and last name cannot be null");
        } else {
            this.firstName = firstName;
        }
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.isEmpty()){
            throw new NullPointerException();
        } else {
            this.lastName = lastName;
        }
    }

    public void setDate(String date) throws DateException {
        if(date.matches("\\d{2}\\/\\d{2}\\/\\d{4}")){
            String year = date.substring(date.length()-4);
            if(Integer.parseInt(year) > 1900 && Integer.parseInt(year) <= 2018){
                this.date = date;
                Date dateObj = parseDate(date);
                calculateStudentAge(dateObj);
            }
        } else {
            throw new DateException("The date does not match the correct format: day/month/year");
        }

    }

    public Date parseDate(String date){
        try{
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dateNow = formatter.parse(date);
            return dateNow;
        } catch (ParseException e){
            e.printStackTrace();
        }
        return null;
    }

    public int calculateStudentAge(Date dateObj){
        Date currentTime = new Date();
        Instant t1 = dateObj.toInstant();
        Instant t2 = currentTime.toInstant();
        Duration d = Duration.between(t2, t1);
        long ageToMinutes = d.toMinutes();
        int ageOfStudent = (int) (ageToMinutes/525948.766);
        return Math.abs(ageOfStudent);
    }




    public void setGender(String gender) throws GenderException {
        if(gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female") ||
                gender.equalsIgnoreCase("m") || gender.equalsIgnoreCase("f")){
            this.gender = gender;
        } else {
            throw new GenderException("The gender must be male/female or m/f");
        }
    }


    public void setId(String id) throws IdException {
        if(id.matches("\\d{13}")){
            this.id = id;
        } else {
            throw new IdException("Id must contain exactly 13 characters and ve a valid one.");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDate() {
        return date;
    }

    public String getGender() {
        return gender;
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Student:\n" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", date='" + date + '\'' +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
