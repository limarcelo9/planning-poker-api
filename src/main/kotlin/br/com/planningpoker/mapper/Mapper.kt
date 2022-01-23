package br.com.planningpoker.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}
