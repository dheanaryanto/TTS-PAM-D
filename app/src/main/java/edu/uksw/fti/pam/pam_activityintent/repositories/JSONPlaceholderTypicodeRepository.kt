package edu.uksw.fti.pam.pam_activityintent.repositories

import edu.uksw.fti.pam.pam_activityintent.models.ApparelModel
import edu.uksw.fti.pam.pam_activityintent.models.CartModel
import edu.uksw.fti.pam.pam_activityintent.models.PartsModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface JSONPlaceholderTypicodeRepository {
    @GET("cart")
    suspend fun getCart(): List<CartModel>

    @GET("apparel")
    suspend fun getApparel(): List<ApparelModel>

    @GET("parts")
    suspend fun getParts(): List<PartsModel>


    companion object {
        var _apiClient: JSONPlaceholderTypicodeRepository? = null

        fun getClient(): JSONPlaceholderTypicodeRepository {
            if (_apiClient == null) {
                _apiClient = Retrofit.Builder()
                    .baseUrl("https://santikaw.github.io/nismocart/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(JSONPlaceholderTypicodeRepository::class.java)
            }

            return _apiClient!!
        }
    }
}