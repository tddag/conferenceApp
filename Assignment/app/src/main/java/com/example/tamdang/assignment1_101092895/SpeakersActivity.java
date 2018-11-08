package com.example.tamdang.assignment1_101092895;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class SpeakersActivity extends AppCompatActivity {


    int[] IMAGES = {R.drawable.ic_record_voice_over_black_24dp, R.drawable.ic_record_voice_over_black_24dp, R.drawable.ic_record_voice_over_black_24dp,
            R.drawable.ic_record_voice_over_black_24dp, R.drawable.ic_record_voice_over_black_24dp};

    String[] NAMES = {"Speaker 1", "Speaker 2", "Speaker 3", "Speaker 4", "Speaker 5"};

    String[] DESCRIPTIONS = {"Description", "Description", "Description", "Description", "Description"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speakers);

        ListView lv = findViewById(R.id.lvSpeakers);

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
            TextView tvDescription = convertView.findViewById(R.id.textView2);

            imageView.setImageResource(IMAGES[position]);
            tvName.setText(NAMES[position]);
            tvDescription.setText(DESCRIPTIONS[position]);

            return convertView;
        }
    }
}
