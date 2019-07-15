package com.javarush.task.task19.task1903;

/*
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA","Ukraine");
        countries.put("RU","Russia");
        countries.put("CA","Canada");
    }

    public static void main(String[] args) {
        String correctFhoneNumber = "+" + Integer.toString(38);
        String phoneNumber = Integer.toString(7);
        while (phoneNumber.length()<10) {
            phoneNumber="0"+phoneNumber;
            System.out.println(phoneNumber);
        }

        StringBuilder stringBuilder = new StringBuilder(phoneNumber);
        correctFhoneNumber= correctFhoneNumber + stringBuilder.insert(0,"(").insert(4,")").insert(8,"-").insert(11,"-");
        System.out.println(correctFhoneNumber);
        System.out.println("+38(050)123-45-67");


    }

    public static class IncomeDataAdapter implements Customer, Contact{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName()+", "+data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String correctFhoneNumber = "+" + Integer.toString(data.getCountryPhoneCode());
            String phoneNumber = Integer.toString(data.getPhoneNumber());
            while (phoneNumber.length()<10) {
                phoneNumber="0"+phoneNumber;
            }
            StringBuilder stringBuilder = new StringBuilder(phoneNumber);
            correctFhoneNumber= correctFhoneNumber + stringBuilder.insert(0,"(").insert(4,")").insert(8,"-").insert(11,"-");
            return correctFhoneNumber;
            /*
            пример взят из обсуждения
            return "+" + data.getCountryPhoneCode() + String.format(
                "%010d",
                data.getPhoneNumber()
            ).replaceFirst(
                "(\\d{3})(\\d{3})(\\d{2})(\\d{2})",
                "($1)$2-$3-$4"
            );
            */
        }
    }


    public static interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example: 501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67
    }
}