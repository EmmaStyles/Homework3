package com.infs3634.homework3;
import com.infs3634.homework3.Quote;
import retrofit2.Call;
import retrofit2.http.GET;

public interface QuoteService {
    //To get the developer category jokes only
    @GET("jokes/random?category=dev")
    Call<Quote> getQuotes();
}
