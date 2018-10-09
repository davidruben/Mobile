package com.henallux.tacheasync.DataAccess;

import com.henallux.tacheasync.Model.Person;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class PersonDAO {

    public ArrayList<Person> getAllPerson()throws Exception{
        URL url = new URL("https://api.androidhive.info/volley/person_array.json");
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder stringBuilder = new StringBuilder();
        String stringJSON ="",line;
        while((line=bufferedReader.readLine())!=null){
            stringBuilder.append(line);
        }
        bufferedReader.close();
        stringJSON=stringBuilder.toString();
        return jsonToPersons(stringJSON);
    }
    private ArrayList<Person>jsonToPersons(String stringJSON)throws Exception
    {
        ArrayList<Person> persons = new ArrayList<>();
        Person person;
        JSONArray jsonArray = new JSONArray(stringJSON);
        for(int i =0;i<jsonArray.length();i++){
            JSONObject jsonPerson = jsonArray.getJSONObject(i);
            person=new Person(jsonPerson.getString("name"),jsonPerson.getString("email"));
            persons.add(person);
        }
        return persons;


    }


}
