package com.cerminnovations.domain.repository.people

import androidx.paging.PagingData
import com.cerminnovations.domain.model.people.Person
import kotlinx.coroutines.flow.Flow

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface PeopleRepository {
    fun getPeople(): Flow<PagingData<Person>>
}
