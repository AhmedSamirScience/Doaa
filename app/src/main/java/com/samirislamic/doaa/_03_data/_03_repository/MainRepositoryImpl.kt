package com.samirislamic.doaa._03_data._03_repository

import com.samirislamic.doaa._03_data._02_remote._01_apiService.MainApi
import com.samirislamic.doaa._04_domain._01_repository.remote.MainRepository

import javax.inject.Inject

class MainRepositoryImpl @Inject constructor(
    private val api: MainApi
) : MainRepository {


}