package com.example.ujikompetensi;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import
        com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.List;
public class LihatData extends AppCompatActivity {
    private ListView listView;
    private FloatingActionButton fab;
    private EditText etSearch;
    private DatabaseHelper dbHelper;
    private List<ListMahasiswa> notesList;
    private ArrayAdapter<String> adapter;
    private List<String> titlesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_data);
        listView = findViewById(R.id.listView);
        fab = findViewById(R.id.fab);
        etSearch = findViewById(R.id.etSearch);
        dbHelper = new DatabaseHelper(this);
        notesList = new ArrayList<>();
        titlesList = new ArrayList<>();
        
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LihatData.this, DialogPilihan.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new
                                                AdapterView.OnItemClickListener() {
                                                    @Override
                                                    public void onItemClick(AdapterView<?> adapterView, View view,
                                                                            int position, long id) {
                                                        Intent intent = new Intent(LihatData.this, DialogPilihan.class);
                                                        intent.putExtra("note_id", notesList.get(position).getId());
                                                        startActivity(intent);
                                                    }
                                                });
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i,
                                          int i1, int i2) {}
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int
                    i1, int i2) {
                searchNotes(charSequence.toString());
            }
            @Override
            public void afterTextChanged(Editable editable) {}
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        loadNotes();
    }
    private void loadNotes() {
        notesList = dbHelper.get();
        titlesList.clear();
        for (Note note : notesList) {
            titlesList.add(note.getTitle()+ "\n" + note.getDate());
        }
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, titlesList);
        listView.setAdapter(adapter);
    }
    private void searchNotes(String keyword) {
        notesList = dbHelper.searchNotes(keyword);
        titlesList.clear();
        for (Note note : notesList) {
            titlesList.add(note.getTitle());
        }
        adapter.notifyDataSetChanged();
    }
}