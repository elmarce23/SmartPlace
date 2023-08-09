package com.example.smartplace.remote;

import com.example.smartplace.data.Dispositivo;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {
    @POST("/dispositivos")
    @FormUrlEncoded
    Call<Dispositivo> savePost(@Field("nombre") String nombre,
                               @Field("estado") String estado,
                               @Field("ubicacion") String ubicacion);

    @PUT("/dispositivos/{id}")
    @FormUrlEncoded
    Call<Dispositivo> putDis(@Path("id") String id, @Field("estado") String estado);

}
