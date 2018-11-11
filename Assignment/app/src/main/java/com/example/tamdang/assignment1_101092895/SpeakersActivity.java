package com.example.tamdang.assignment1_101092895;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SpeakersActivity extends AppCompatActivity {
    private SQLiteDatabase db;
    private SpeakerDBHelper myDB;

    int[] IMAGES = {R.drawable.ic_record_voice_over_black_24dp, R.drawable.ic_record_voice_over_black_24dp, R.drawable.ic_record_voice_over_black_24dp,
            R.drawable.ic_record_voice_over_black_24dp, R.drawable.ic_record_voice_over_black_24dp};

    String[] NAMES = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);

        myDB = new SpeakerDBHelper(this);
        db = myDB.getWritableDatabase();

        Speaker p1 = myDB.getPresenter(db, 1);
        Speaker p2 = myDB.getPresenter(db, 2);
        Speaker p3 = myDB.getPresenter(db, 3);
        Speaker p4 = myDB.getPresenter(db, 4);
        Speaker p5 = myDB.getPresenter(db, 5);

        NAMES = new String[]{p1.getFirstname() +" "+ p1.getLastname(),
                                    p2.getFirstname() +" "+ p2.getLastname(),
                                    p3.getFirstname() +" "+ p3.getLastname(),
                                    p4.getFirstname() +" "+ p4.getLastname(),
                                    p5.getFirstname() +" "+ p5.getLastname()};

        final ListView lv = findViewById(R.id.lvSpeakers);

        CustomAdapter customAdapter = new CustomAdapter();
        lv.setAdapter(customAdapter);

        Button btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                i.setFlags(i.getFlags() | Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
                finish();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                position+=1;
                Intent myIntent = new Intent(view.getContext(), SpeakerProfile.class);
                myIntent.putExtra("ID", position+"");
                startActivityForResult(myIntent, 0);
            }
        });

    }

    class CustomAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            convertView = getLayoutInflater().inflate(R.layout.custom_layout, null);

            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView tvName = convertView.findViewById(R.id.textView);

            imageView.setImageResource(IMAGES[position]);
            tvName.setText(NAMES[position]);

            return convertView;
        }
    }
}
