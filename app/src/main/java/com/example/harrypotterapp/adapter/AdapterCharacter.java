package com.example.harrypotterapp.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.harrypotterapp.DetailActivity;
import com.example.harrypotterapp.R;
import com.example.harrypotterapp.model.Character;

import java.util.List;

public class AdapterCharacter extends RecyclerView.Adapter<AdapterCharacter.CharacterHolder> {

    public Activity activity;
    public List<Character> list;
    public int item_character;

    public AdapterCharacter(Activity activity, List<Character> list, int item_character) {
        this.activity = activity;
        this.list = list;
        this.item_character = item_character;
    }

    @NonNull
    @Override
    public CharacterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(item_character,parent,false);

        return new CharacterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterHolder holder, int position) {

        Character character = list.get(position);
        holder.item_name.setText(character.name);
        //variables new detail
        holder.item_gender.setText(character.gender);
        holder.item_species.setText(character.species);
        holder.item_date.setText(character.dateOfBirth);
        holder.item_patronus.setText(character.patronus);
        holder.item_howarts.setText(character.hogwartsStudent);
        holder.item_actor.setText(character.actor);
        holder.item_alive.setText(character.alive);
        //end variables new

        Glide.with(activity).load(character.image).into(holder.item_image);
        holder.item_house.setText(character.house);
        //esto es para que me pase el url de la imagen
        holder.urlImage = character.image;


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CharacterHolder extends RecyclerView.ViewHolder {

        ImageView item_image;
        TextView item_name,item_house;
        //var new
        TextView item_species,item_gender,item_date,item_patronus,item_howarts,item_actor,item_alive ;
        //
        RelativeLayout item_character;

        String urlImage;

        public CharacterHolder(@NonNull View itemView) {
            super(itemView);

            item_name = itemView.findViewById(R.id.item_name);
            item_image = itemView.findViewById(R.id.item_image);
            item_house = itemView.findViewById(R.id.item_house);
            item_character = itemView.findViewById(R.id.item_character);
            //esto es por seguridad por si va por id la imagen
            item_species = itemView.findViewById(R.id.item_species);
            item_gender = itemView.findViewById(R.id.item_gender);
            item_date = itemView.findViewById(R.id.item_date);
            item_patronus = itemView.findViewById(R.id.item_patronus);
            item_howarts = itemView.findViewById(R.id.item_howarts);
            item_actor = itemView.findViewById(R.id.item_actor);
            item_alive = itemView.findViewById(R.id.item_aliver);

            item_character.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(activity, DetailActivity.class);
                    intent.putExtra("NAME",item_name.getText().toString());
                    intent.putExtra("HOUSE",item_name.getText().toString());
                    //
                    intent.putExtra("IMAGE", urlImage);
                    intent.putExtra("SPECIES",item_species.getText().toString());
                    intent.putExtra("GENDER",item_gender.getText().toString());
                    intent.putExtra("DATE",item_date.getText().toString());
                    intent.putExtra("PATRONUS",item_patronus.getText().toString());
                    intent.putExtra("HOWARTS",item_howarts.getText().toString());
                    intent.putExtra("ACTOR",item_actor.getText().toString());
                    intent.putExtra("ALIVE",item_alive.getText().toString());
                    //
                    activity.startActivity(intent);
                }
            });

        }
    }


}
