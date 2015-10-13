package com.example.aciolekwaw.retrofitexamplecountry;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;
import retrofit.http.GET;

/**
 * Created by aciolekwaw on 2015-10-13.
 */
public class RestCountriesAPI {

    private String service_url = "https://restcountries.eu/rest/v1";

    public interface GetAllAPI {
        @GET("/all")
        List<Country> getCountries();
    }

    public List<Country> GetAllCountries() {

        Gson gson = new GsonBuilder().create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(service_url)
                .setConverter(new GsonConverter(gson))
                .build();

        GetAllAPI service = restAdapter.create(GetAllAPI.class);

        List<Country> countrylist = service.getCountries();

        return countrylist;
    }
}
