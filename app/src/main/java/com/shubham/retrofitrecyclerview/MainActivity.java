package com.shubham.retrofitrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sdsmdg.tastytoast.TastyToast;
import com.shubham.retrofitrecyclerview.recyclerView.ContactAdapter;
import com.shubham.retrofitrecyclerview.retrofit.ApiController;
import com.shubham.retrofitrecyclerview.retrofit.ModelApi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_contact);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        showData();
    }

    private void showData() {

//        Call<RetrofitResponseModel> call = ApiController.getInstance().getApi().getRegister(name,email,password);

        Call<ModelApi> call = ApiController.getInstance().getApi().getData();
        call.enqueue(new Callback<ModelApi>() {
            @Override
            public void onResponse(Call<ModelApi> call, Response<ModelApi> response) {
                if(response.isSuccessful()){
                    assert response.body() != null;
                    ContactAdapter contactAdapter = new ContactAdapter(MainActivity.this,response.body().getData());
                    recyclerView.setAdapter(contactAdapter);
                }
            }

            @Override
            public void onFailure(Call<ModelApi> call, Throwable t) {

                TastyToast.makeText(MainActivity.this,"Failed "+ t.toString(),TastyToast.LENGTH_LONG,TastyToast.ERROR);
            }
        });
    }
}