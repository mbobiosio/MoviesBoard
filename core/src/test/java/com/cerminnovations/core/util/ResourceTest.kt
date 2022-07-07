package com.cerminnovations.core.util

import app.cash.turbine.test
import com.cerminnovations.core.error.ErrorMessage
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
class ResourceTest {

    @ExperimentalCoroutinesApi
    @Test
    fun `catch resource errors`() = runTest {
        flow {
            emit(1)
            throw Exception("Test completed")
        }
            .asResult()
            .test {
                assertEquals(Resource.Loading, awaitItem())
                assertEquals(Resource.Success(1), awaitItem())

                when (val errorResult = awaitItem()) {
                    is Resource.Error -> assertEquals(
                        Resource.Error(ErrorMessage("Test completed")),
                        Resource.Error(ErrorMessage("Test completed"))
                    )
                    Resource.Loading,
                    is Resource.Success -> throw IllegalStateException(
                        "The flow should have emitted an error result"
                    )
                }
                awaitComplete()
            }
    }
}
