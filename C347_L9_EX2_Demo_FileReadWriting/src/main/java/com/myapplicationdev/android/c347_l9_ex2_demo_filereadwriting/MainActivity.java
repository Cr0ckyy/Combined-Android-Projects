package com.myapplicationdev.android.c347_l9_ex2_demo_filereadwriting;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    Button btnWrite, btnRead;
    TextView statusTextView;
    File folder, textFile;
    String folderLocation, line;
    String[] permission;
    StringBuilder data;
    FileWriter fileWriter;
    UUID myRandomUUID;
    FileReader reader;
    BufferedReader bufferedReader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnWrite = findViewById(R.id.btnWrite);
        btnRead = findViewById(R.id.btnRead);
        statusTextView = findViewById(R.id.tvStatus);

        // TODO: Folders creation
        /* --- Internal app directory path --- */
        folderLocation = getFilesDir().getAbsolutePath() + "/MyFolder";

        /* --- External app directory path --- */
        // This does not mean external as in SD Card, but rather outside of the sandboxed internal app storage.
        //String folderLocation = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyFolder2";

        permission = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE};

        ActivityCompat.requestPermissions(MainActivity.this, permission, 0);

        // A new File object is created by converting the given pathname string into an abstract pathname.
        folder = new File(folderLocation);
        textFile = new File(folderLocation, "data.txt");

        // checks to see if the file/directory specified by this abstract pathname exists.
        if (!folder.exists()) {
            boolean result = folder.mkdir(); // This function creates the directory specified by the abstract pathname.

            if (result) {
                Log.d("File read/write", "Folder Created");
            } else {
                Toast.makeText(this, "The creation of a folder was unsuccessful.", Toast.LENGTH_SHORT).show();
            }
        }


        btnWrite.setOnClickListener(view -> {

            try {

                //  a character file writing object
                fileWriter = new FileWriter(textFile, true);

                // Static factory for obtaining a UUID of type 4 (pseudo-randomly generated).
                myRandomUUID = UUID.randomUUID();

                fileWriter.write("Test Data: " + myRandomUUID + "\n"); // Writes a string.
                fileWriter.flush(); // Flushes the stream.
                fileWriter.close();// Closes the stream by first flushing it.

            } catch (Exception e) {
                Toast.makeText(this, "Failed to read the file.", Toast.LENGTH_SHORT).show();

                // This throwable and its backtrace are printed to the standard error stream.
                e.printStackTrace();
            }
        });

        btnRead.setOnClickListener(view -> {

            // determines whether the file or directory denoted by this abstract pathname exists.
            if (textFile.exists()) {

                // A mutable character sequence object.
                data = new StringBuilder();
                try {
                    reader = new FileReader(textFile); //  a character file writing object

                    // a text-reading object that buffers characters for
                    // efficient reading of characters/arrays/lines from a character-input stream.
                    bufferedReader = new BufferedReader(reader);

                    // A BufferedReader object that reads a single line of text.
                    line = bufferedReader.readLine();

                    while (line != null) {
                        data.append(line).append("\n");
                        line = bufferedReader.readLine();
                    }

                    // Closes the stream and releases any associated system resources
                    bufferedReader.close();
                    reader.close();

                } catch (Exception e) {
                    Toast.makeText(this, "Failed to read the file", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

                statusTextView.setText(data.toString());
            }
        });

    }
}