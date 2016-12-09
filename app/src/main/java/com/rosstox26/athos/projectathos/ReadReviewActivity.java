package com.rosstox26.athos.projectathos;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.

public class ReadReviewActivity extends Activity implements View.OnClickListener{

    private Button buttonUpdate;
    private TextView textViewLatest;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_review);

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        textViewLatest = (TextView) findViewById(R.id.textViewLatest);
        buttonUpdate.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Toast.makeText(ReviewActivity.this, "User signed in: " + user.getEmail(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ReviewActivity.this, "Nobody Logged In", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(ReviewActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        };
    }

        @Override
        public void onStart() {
            super.onStart();
            mAuth.addAuthStateListener(mAuthListener);
        }

        @Override
        public void onStop() {
            super.onStop();
            if (mAuthListener != null) {
                mAuth.removeAuthStateListener(mAuthListener);
            }
        }

        @Override
        public void onClick(View view) {

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference dataPurchases = database.getReference();
            dataPurchases.child("purchases").orderByKey().limitToLast(2).addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                    Review review = dataSnapshot.getValue(Review.class);
                    String val = textViewLatest.getText().toString();
                    val = val + "\n \n Rating: " + review.rating + "\n Title: " + review.title + "\n Review: " + purchase.review + "\n";
                    textViewLatest.setText(val);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {

//        Intent intentMonitor = new Intent(MonitorActivity.this, MonitorActivity.class);
            Intent intentPurchase = new Intent(ReadReviewActivity.this, SalesActivity.class);
            if (mAuth.getCurrentUser() != null ) {
                if (item.getItemId() == R.id.menuLogout) {
                    mAuth.signOut();

                } else if (item.getItemId() == R.id.menuMonitor) {
                    Toast.makeText(this, "You are in Read Review Page Already", Toast.LENGTH_SHORT).show();

                } else if (item.getItemId() == R.id.menuPurchase) {
                    startActivity(intentPurchase);

                }
            } else {
                Toast.makeText(this, "Nobody Logged In", Toast.LENGTH_SHORT).show();
            }


            return super.onOptionsItemSelected(item);
        }

    }


