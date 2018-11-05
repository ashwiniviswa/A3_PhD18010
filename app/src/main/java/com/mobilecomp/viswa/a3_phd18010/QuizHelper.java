package com.mobilecomp.viswa.a3_phd18010;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class QuizHelper extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "QuizDB";
    // tasks table name
    private static final String TABLE_NAME = "QUESTIONS";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer";
    private static final String KEY_CHOICE = "choice";
    private SQLiteDatabase SQLitedb;
    public QuizHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        SQLitedb=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ KEY_QUES
                + " TEXT, "  + KEY_ANSWER
                +  " INTEGER , " + KEY_CHOICE+ " INTEGER)";
        SQLitedb.execSQL(sql);
        addQuestions();
        //SQLitedb.close();
    }
    private void addQuestions()
    {
        Questions q1=new Questions("The Language that the computer can understand is called Machine Language", 1);
        this.addQuestion(q1);
        Questions q2=new Questions("Magnetic Tape used random access method.", 0);
        this.addQuestion(q2);
        Questions q3=new Questions("Chennai is the Capital of India", 0);
        this.addQuestion(q3);
        Questions q4=new Questions("Twitter is an online social networking and blogging service.", 1);
        this.addQuestion(q4);
        Questions q5=new Questions("Worms and trojan horses are easily detected and eliminated by antivirus software.", 1);
        this.addQuestion(q5);
        Questions q6=new Questions("Dot-matrix, Deskjet, Inkjet and Laser are all types of Printers.", 1);
        this.addQuestion(q6);
        Questions q7=new Questions("Freeware is software that is available for use at no monetary cost.", 1);
        this.addQuestion(q7);
        Questions q8=new Questions("IPv6 Internet Protocol address is represented as eight groups of four Octal digits.",0);
        this.addQuestion(q8);
        Questions q9=new Questions("The hexadecimal number system contains digits from 1 - 15.",0);
        this.addQuestion(q9);
        Questions q10=new Questions("Octal number system contains digits from 0 - 7.", 1);
        this.addQuestion(q10);

        Questions q11=new Questions("MS Word is a hardware.",0);
        this.addQuestion(q11);
        Questions q12=new Questions("CPU controls only input data of computer.",0);
        this.addQuestion(q12);
        Questions q13=new Questions("CPU stands for Central Performance Unit.",0);
        this.addQuestion(q13);
        Questions q14=new Questions("GNU / Linux is a open source operating system.",1);
        this.addQuestion(q14);
        Questions q15=new Questions("C is a programming language", 1);
        this.addQuestion(q15);
        Questions q16=new Questions("India won 2018 Football World Cup", 0);
        this.addQuestion(q16);
        Questions q17=new Questions("IAS stands for Indian Administrative Service",1);
        this.addQuestion(q17);
        Questions q18=new Questions("Mahatma Gandhi is the Father of our Nation", 1);
        this.addQuestion(q18);
        Questions q19=new Questions("ARP stands for Address Resolution Protocol", 1);
        this.addQuestion(q19);
        Questions q20=new Questions("HTTP is transport layer protocol", 0);
        this.addQuestion(q20);

        Questions q21=new Questions("HTTP is Hyper Text Transfer Programming", 0);
        this.addQuestion(q21);
        Questions q22=new Questions("127.0.0.1 is loop back address", 1);
        this.addQuestion(q22);
        Questions q23=new Questions("WiFi is a wireless protocol", 1);
        this.addQuestion(q23);
        Questions q24=new Questions("SQLite is equivalent to SQL",0);
        this.addQuestion(q24);
        Questions q25=new Questions("Barack Obama is the 44th President of the United States", 1);
        this.addQuestion(q25);
        Questions q26=new Questions("Nile is the longest river in the world",1);
        this.addQuestion(q26);
        Questions q27=new Questions("Iceland is the biggest island in the world",0);
        this.addQuestion(q27);
        Questions q28=new Questions("World Environment Day is on 11/10", 0);
        this.addQuestion(q28);
        Questions q29=new Questions("Lotus is the national flower of India", 1);
        this.addQuestion(q29);
        Questions q30=new Questions("Kerala is the state with highest literacy rate in India", 1);
        this.addQuestion(q30);



    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
// Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
// Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Questions quest) {
//SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQuestion());
        values.put(KEY_ANSWER, quest.getqAnswer());
        values.put(KEY_CHOICE, quest.getqChoice());
// Inserting Row
        SQLitedb.insert(TABLE_NAME, null, values);
    }


    public List<Questions> getAllQuestions() {
        List<Questions> quesList = new ArrayList<Questions>();
// Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLitedb=this.getReadableDatabase();
        Cursor cursor = SQLitedb.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Questions quest = new Questions();
                quest.setID(cursor.getInt(0));
                quest.setQuestion(cursor.getString(1));
                quest.setqAnswer(cursor.getInt(2));
                quest.setqChoice(cursor.getInt(3));
                quesList.add(quest);




            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }

    public void setChoice(int questionID, int choice) {
        // Update Query
        String updateQuery = "UPDATE " + TABLE_NAME +" SET CHOICE = " + choice +" WHERE ID = " + questionID;
        Log.i("UPDATE_QUERY",updateQuery );
        SQLitedb=this.getWritableDatabase();
        SQLitedb.execSQL(updateQuery);
    }





}
