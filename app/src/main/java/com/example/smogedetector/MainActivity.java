package com.example.smogedetector;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    TextView  hvall, mssg, smoke, tem;
    Spinner city;
    Button resultForChack;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city = findViewById(R.id.city);


        hvall = findViewById(R.id.hvall);
        mssg = findViewById(R.id.mssg);
        smoke = findViewById(R.id.smoke);
        tem = findViewById(R.id.tem);

        resultForChack = findViewById(R.id.result);
        databaseReference = FirebaseDatabase.getInstance().getReference();


        resultForChack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String spinner_1 = city.getSelectedItem().toString();
                if (spinner_1.equals("Select City")) {
                    Toast.makeText(MainActivity.this, "Please Select city..", Toast.LENGTH_LONG).show();
                }
                else if (spinner_1.equals("Faisalabad")) {
                    databaseReference.child("Faisalabad").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String b = (dataSnapshot.child("hvall").getValue(double.class)).toString();
                            String c = dataSnapshot.child("mssg").getValue(String.class);
                            String d = (dataSnapshot.child("smoke").getValue(double.class)).toString();
                            String e = (dataSnapshot.child("tem").getValue(double.class)).toString();


                            hvall.setText(b);
                            mssg.setText(c);
                            smoke.setText(d);
                            tem.setText(e);
                            Toast.makeText(MainActivity.this, "Faisalabad Weather", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
                else if (spinner_1.equals("Shahkot")) {


                    databaseReference.child("Shahkot").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String b = (dataSnapshot.child("hvall").getValue(double.class)).toString();
                            String c = dataSnapshot.child("mssg").getValue(String.class);
                            String d = (dataSnapshot.child("smoke").getValue(double.class)).toString();
                            String e = (dataSnapshot.child("tem").getValue(double.class)).toString();


                            hvall.setText(b);
                            mssg.setText(c);
                            smoke.setText(d);
                            tem.setText(e);

                            Toast.makeText(MainActivity.this, "Shahkot Weather", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });


                }
                else if (spinner_1.equals("Lahore")) {
                    databaseReference.child("Lahore").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            String b = (dataSnapshot.child("hvall").getValue(double.class)).toString();
                            String c = dataSnapshot.child("mssg").getValue(String.class);
                            String d = (dataSnapshot.child("smoke").getValue(double.class)).toString();
                            String e = (dataSnapshot.child("tem").getValue(double.class)).toString();


                            hvall.setText(b);
                            mssg.setText(c);
                            smoke.setText(d);
                            tem.setText(e);
                            Toast.makeText(MainActivity.this, "Lahore Weather", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });
    }




}
//  https://console.firebase.google.com/u/3/project/smoge-detector/database/smoge-detector/data
