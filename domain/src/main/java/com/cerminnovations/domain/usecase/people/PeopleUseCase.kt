package com.cerminnovations.domain.usecase.people

import androidx.paging.PagingData
import com.cerminnovations.domain.model.people.Person
import com.cerminnovations.domain.repository.people.PeopleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class PeopleUseCase @Inject constructor(
    private val peopleRepository: PeopleRepository
) {
    operator fun invoke(): Flow<PagingData<Person>> =
        peopleRepository.getPeople()
}
