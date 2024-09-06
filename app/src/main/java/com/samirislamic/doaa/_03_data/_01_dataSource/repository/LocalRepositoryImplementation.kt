package com.samirislamic.doaa._03_data._01_dataSource.repository

import com.samirislamic.doaa._03_data._01_dataSource.base.PreferencesManager
import com.samirislamic.doaa._04_domain._01_repository.dataSource.LocalRepository

import javax.inject.Inject

class LocalRepositoryImplementation @Inject constructor(
    private val prefManager: PreferencesManager
): LocalRepository
{

}