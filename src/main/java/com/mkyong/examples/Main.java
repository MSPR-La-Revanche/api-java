package com.mkyong.examples;

public class Main {

    public static void main(String[] args) {

        XMLParser xmlParser = new XMLParser();
        Database database = new Database();

        //xmlParser.parser("./src/main/resources/test.xml");

        database.DBconnect("sql4403036", "VuH83GZFAM");

    }

}
