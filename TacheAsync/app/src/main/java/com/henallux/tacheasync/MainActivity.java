package com.henallux.tacheasync;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.henallux.tacheasync.DataAccess.PersonDAO;
import com.henallux.tacheasync.Model.Person;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Button button;

    private LoadPerson loadPersonsTask;
    private AllPersonsAdapter allPersonsAdapter;
    private RecyclerView.LayoutManager layoutManager;

    private ArrayList<Person> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView= findViewById(R.id.recycler);



        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Person> listeVide=new ArrayList<>();
        allPersonsAdapter = new AllPersonsAdapter(listeVide);
        recyclerView.setAdapter(allPersonsAdapter);

        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPersonsTask = (LoadPerson) new LoadPerson().execute();
            }
        });




    }
    private class LoadPerson extends AsyncTask<ArrayList<Person>,Void,ArrayList<Person>>{

        @Override
        protected ArrayList<Person> doInBackground(ArrayList<Person>... params) {
            PersonDAO personDAO = new PersonDAO();
            ArrayList<Person>persons= new ArrayList<>();
            try{
                persons=personDAO.getAllPerson();
            }catch (Exception e){

            }
            return persons;
        }

        @Override
        protected void onPostExecute(ArrayList<Person> s) {
            super.onPostExecute(s);
            allPersonsAdapter.setDataSet(s);
            allPersonsAdapter.notifyDataSetChanged();
        }

        @Override
        protected void onCancelled(ArrayList<Person> people) {
            super.onCancelled(people);
            Log.i("End of task","END OF MAIN TASK");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(loadPersonsTask!=null){
            loadPersonsTask.isCancelled();
        }
        Log.i("End","End of async task");

    }
}
