package com.example.rickmorty;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetDataService {

    @GET("character")
    Call<List<results>> getAllPhotos();
}
