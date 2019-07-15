package com.javarush.task.task19.task1905;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/*
Закрепляем адаптер
*/

public class Solution {
    public static Map<String,String> countries = new HashMap<String,String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
       /* String fullName = "Ivanov, Ivan";
        System.out.println(fullName.substring(0,fullName.indexOf(",")));
        System.out.println(fullName.substring(fullName.lastIndexOf(" ")+1,fullName.length()));*/
        String contact_getPhoneNumber="+380(50)123-4567";
        System.out.println("callto://"+ contact_getPhoneNumber.replaceAll("[\\D]", ""));

    }

    public static class DataAdapter implements RowItem{
        private Customer customer;
        private Contact contact;
        public DataAdapter(Customer customer, Contact contact) {
            this.customer=customer;
            this.contact=contact;
        }

        @Override
        public String getCountryCode() {
            String code = "";
            String name = customer.getCountryName();
            Set <Map.Entry<String,String>> set = countries.entrySet();
            for (Map.Entry<String,String> pair : set) {
                if (pair.getValue().equals(name)) code=pair.getKey();
            }
            return code;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String fullName = contact.getName();
            return fullName.substring(fullName.lastIndexOf(" ")+1,fullName.length());
        }

        @Override
        public String getContactLastName() {
            String fullName = contact.getName();
            return fullName.substring(0,fullName.indexOf(","));
        }

        @Override
        public String getDialString() {
            return "callto://+"+ contact.getPhoneNumber().replaceAll("[^0-9]","");
            //.replaceAll("[^\d,+]", ""); - какая-то хрень, не работает
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA
        String getCompany();            //For example: JavaRush Ltd.
        String getContactFirstName();   //For example: Ivan
        String getContactLastName();    //For example: Ivanov
        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.
        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan
        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}