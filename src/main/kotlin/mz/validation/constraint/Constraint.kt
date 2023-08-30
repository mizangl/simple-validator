package mz.validation.constraint

import mz.validation.annotation.Constraints
import kotlin.reflect.full.createInstance
import kotlin.reflect.full.findAnnotation

interface Constraint<out T> {

    fun getErrorMessage(): String
    fun getValue(): T

    companion object {
        fun validate(constraints: List<Constraint<*>>, value: Int): String? {

            return constraints.map {
                val validator = it::class.findAnnotation<Constraints>()?.validator?.createInstance()
                    ?: throw IllegalStateException()

                it to validator
            }.firstOrNull {
                it.second.isValid(value, it.first)
            }?.first?.getErrorMessage()
        }
    }
}