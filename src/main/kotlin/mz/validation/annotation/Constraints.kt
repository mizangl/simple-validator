package mz.validation.annotation

import mz.validation.validator.Validator
import kotlin.reflect.KClass

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.CLASS)
@MustBeDocumented
annotation class Constraints(
    val validator: KClass<out Validator>,
)
