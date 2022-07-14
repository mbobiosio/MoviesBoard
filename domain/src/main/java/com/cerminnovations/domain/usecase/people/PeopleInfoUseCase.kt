package com.cerminnovations.domain.usecase.people

import com.cerminnovations.core.util.Resource
import com.cerminnovations.core.util.network.safeApiCall
import com.cerminnovations.domain.model.people.PersonInfo
import com.cerminnovations.domain.repository.people.PeopleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class PeopleInfoUseCase @Inject constructor(
    private val peopleRepository: PeopleRepository
) {
    operator fun invoke(
        personId: Long,
        apiKey: String?,
        appendToResponse: String?
    ): Flow<Resource<PersonInfo>> = flow {
        emit(
            safeApiCall {
                peopleRepository.getPersonInfo(personId, apiKey, appendToResponse)
            }
        )
    }.flowOn(Dispatchers.IO)
}
