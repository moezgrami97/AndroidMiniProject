package tn.moez.multitp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    RecyclerView recyclerView2;

    MyDatabaseHelper myDB;
    ArrayList<String> book_id, book_title, book_author, book_pages;
    CustomAdapter2 customAdapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        mToolbar = findViewById(R.id.main_toolbar2);
        setSupportActionBar(mToolbar);

        recyclerView2 = findViewById(R.id.recyclerView2);

        myDB = new MyDatabaseHelper(UserActivity.this);
        book_id = new ArrayList<>();
        book_title = new ArrayList<>();
        book_author = new ArrayList<>();
        book_pages = new ArrayList<>();

        storeDataInArrays();

        customAdapter2 = new CustomAdapter2(UserActivity.this,this, book_id, book_title, book_author, book_pages);
        recyclerView2.setAdapter(customAdapter2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(UserActivity.this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main_menu2,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.logout:{
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(UserActivity.this,LoginActivity.class);
                startActivity(intToMain);
            }

            case R.id.hello:{
                Toast.makeText(UserActivity.this, "No help needed <3", Toast.LENGTH_SHORT).show();
            }
        }
        return super.onOptionsItemSelected(item);
    }


    void storeDataInArrays(){
        Cursor cursor = myDB.readAllData();
        if(cursor.getCount()==0){
            Toast.makeText(UserActivity.this, "No Data!", Toast.LENGTH_SHORT).show();
        }else{
            while (cursor.moveToNext()){
                book_id.add(cursor.getString(0));
                book_title.add(cursor.getString(1));
                book_author.add(cursor.getString(2));
                book_pages.add(cursor.getString(3));
            }
        }
    }
}
