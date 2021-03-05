package com.example.jetpackpro

import android.os.SystemClock
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response
import java.util.*
import javax.security.auth.callback.Callback

class MainViewModel : ViewModel() {
    private val _restaurant = MutableLiveData<Restaurant>()
    val restaurant: LiveData<Restaurant> = _restaurant

    private val _listReview = MutableLiveData<List<CustomerReviewsItem>>()
    val listReview: LiveData<List<CustomerReviewsItem>> = _listReview

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    companion object{
        private const val TAG = "MainViewModel"
        private const val RESTAURANT_ID = "uewq1zg2zlskfw1e867"
    }

    fun findRestaurant(){
        _isLoading.value = true

        val client = ApiConfing.getApiService().getRestaurant(RESTAURANT_ID)
        client.enqueue(object : retrofit2.Callback<RestaurantResponse> {
            override fun onFailure(call: Call<RestaurantResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<RestaurantResponse>,
                response: Response<RestaurantResponse>
            ) {
                _isLoading.value = false
                if(response.isSuccessful){
                    _restaurant.value = response.body()?.restaurant
                    _listReview.value = response.body()?.restaurant?.customerReviews as List<CustomerReviewsItem>?
                }else{
                    Log.e(TAG, "onFailure: ${response.message()}")
                }
            }

        })
    }

    fun postReview(review: String){
        _isLoading.value = true

        val client = ApiConfing.getApiService().postReview(RESTAURANT_ID,"Dicoding", review)
        client.enqueue(object : retrofit2.Callback<PostReviewResponse> {
            override fun onFailure(call: Call<PostReviewResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }

            override fun onResponse(
                call: Call<PostReviewResponse>,
                response: Response<PostReviewResponse>
            ) {
                _isLoading.value = false
                if(response.isSuccessful){
                    _listReview.value = response.body()?.customerReviews
                } else {
                    Log.e(TAG, "onFailure:  ${response.message()}")
                }
            }

        })
    }
}