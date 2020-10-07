package com.example.harrypotterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {

    String name,house,image,species,gender,date,patronus,howarts,actor,alive;
    TextView txtname,txtspecies,txtgender,txthouse,txtbirth,txtpatronus,txthoward,txtactor,txtalive;
    CircleImageView txtperfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        name = getIntent().getStringExtra("NAME");
        house = getIntent().getStringExtra("HOUSE");
        image = getIntent().getStringExtra("IMAGE");
        species = getIntent().getStringExtra("SPECIES");
        gender = getIntent().getStringExtra("GENDER");
        date = getIntent().getStringExtra("DATE");
        patronus = getIntent().getStringExtra("PATRONUS");
        howarts = getIntent().getStringExtra("HOWARTS");
        actor = getIntent().getStringExtra("ACTOR");
        alive = getIntent().getStringExtra("ALIVE");
        //cargar los controles
        txtname = findViewById(R.id.item_name);
        txtspecies = findViewById(R.id.item_species);
        txtgender = findViewById(R.id.item_gender);
        txthouse = findViewById(R.id.item_house);
        txtbirth = findViewById(R.id.item_date);
        txtpatronus = findViewById(R.id.item_patronus);
        txthoward = findViewById(R.id.item_howarts);
        txtactor = findViewById(R.id.item_actor);
        txtalive = findViewById(R.id.item_aliver);

        txtperfil = findViewById(R.id.item_image);

        txtname.setText(name);
        txtspecies.setText(species);
        txtgender.setText(gender);
        txthouse.setText(house);
        txtbirth.setText(date);
        txtpatronus.setText(patronus);
        txthoward.setText(howarts);
        txtactor.setText(actor);
        txtalive.setText(alive);

        Glide.with(this).load(image).into(txtperfil);


        Log.d("INFO",name+""+house+""+image+""+species+""+gender+""+date+""+patronus+""+howarts+""+actor+""+actor);
    }
}