package com.rosstox26.athos.projectathos;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ReviewActivity extends Activity implements RatingBar.OnRatingBarChangeListener, Button.OnClickListener{
    private RatingBar ratingBarOverall;
    private RatingBar ratingBarQuality;
    private RatingBar ratingBarComfort;
    private RatingBar ratingBarService;
    private Button buttonSubmitReview;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return super.onCreateOptionsMenu(menu);
    }

        @Override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        ratingBarOverall = (RatingBar) findViewById(R.id.ratingBarOverall);
        ratingBarQuality = (RatingBar) findViewById(R.id.ratingBarQuality);
        ratingBarComfort = (RatingBar) findViewById(R.id.ratingBarComfort);
        ratingBarService = (RatingBar) findViewById(R.id.ratingBarOverall);
        buttonSubmitReview = (Button)  findViewById(R.id.buttonSubmitReview);

        ratingBarOverall.setOnRatingBarChangeListener(this);
        ratingBarQuality.setOnRatingBarChangeListener(this);
        ratingBarComfort.setOnRatingBarChangeListener(this);
        ratingBarService.setOnRatingBarChangeListener(this);
        buttonSubmitReview.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {


    }
}

        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

        }

        @Override
        public void onClick(View v) {@Override
public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if (user != null) {
        Toast.makeText(SalesActivity.this, "User signed in: " + user.getEmail(), Toast.LENGTH_SHORT).show();
        } else {
        Toast.makeText(SalesActivity.this, "Nobody Logged In", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(SalesActivity.this, MainActivity.class);
        startActivity(intent);
        }
        }
        };
        }
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

        String product = editTextProduct.getText().toString();
        String price = editTextPrice.getText().toString();
        String quantity = editTextQuantity.getText().toString();

        Purchase purchase = new Purchase(product, price, quantity);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference dataPurchases = database.getReference("purchases");
        DatabaseReference dataNewPurchase = dataPurchases.push();
        dataNewPurchase.setValue(purchase);
        }

@Override
public boolean onOptionsItemSelected(MenuItem item) {

        Intent intentMonitor = new Intent(SalesActivity.this, MonitorActivity.class);
        //Intent intentPurchase = new Intent(MonitorActivity.this, SalesActivity.class);
        if (mAuth.getCurrentUser() != null ) {
        if (item.getItemId() == R.id.menuLogout) {
        mAuth.signOut();

        } else if (item.getItemId() == R.id.menuMonitor) {
        startActivity(intentMonitor);

        } else if (item.getItemId() == R.id.menuPurchase) {

        Toast.makeText(this, "You are in Purchase Page Already", Toast.LENGTH_SHORT).show();

        }
        } else {
        Toast.makeText(this, "Nobody Logged In", Toast.LENGTH_SHORT).show();
        }


        return super.onOptionsItemSelected(item);
        }

@Override
public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu, menu);
        return super.onCreateOptionsMenu(menu);
        }
        }
