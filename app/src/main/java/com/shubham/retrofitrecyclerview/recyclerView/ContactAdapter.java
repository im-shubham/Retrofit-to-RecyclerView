package com.shubham.retrofitrecyclerview.recyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shubham.retrofitrecyclerview.R;
import com.shubham.retrofitrecyclerview.retrofit.ModelApi;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    Context context;
    List<ModelApi.Datum> arrContact;

    public  ContactAdapter(Context context, List<ModelApi.Datum> arrContact){
        this.context = context;
        this.arrContact = arrContact;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.contact_row,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        holder.txtName.setText(arrContact.get(position).getFirstName());
        holder.txtLastName.setText(arrContact.get(position).getLastName());
        holder.txtEmail.setText(arrContact.get(position).getEmail());
        Picasso.get().load(arrContact.get(position).getAvatar()).fit().into(holder.imgContact);

    }

    @Override
    public int getItemCount() {
        return arrContact.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtName,txtLastName,txtEmail;
        ImageView imgContact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.ContactName);
            txtLastName = itemView.findViewById(R.id.ContactLastName);
            txtEmail = itemView.findViewById(R.id.ContactMail);
            imgContact = itemView.findViewById(R.id.contactPic);

        }
    }
}
