package com.cerminnovations.core.base

/**
 * @Author Mbuodile Obiosio
 * https://linktr.ee/mbobiosio
 */
interface Mapper<I, O> {
    fun map(input: I): O
}

interface ListMapper<I, O> : Mapper<List<I>, List<O>>