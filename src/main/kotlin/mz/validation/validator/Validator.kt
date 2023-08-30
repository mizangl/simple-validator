package mz.validation.validator

import mz.validation.constraint.Constraint

interface Validator {

    fun <T> isValid(value: T, constraint: Constraint<T>): Boolean
}