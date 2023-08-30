package mz.validation.sample

import mz.validation.constraint.Constraint
import mz.validation.validator.Validator

class MaximumValidator() : Validator {

    override fun <T> isValid(value: T, constraint: Constraint<T>): Boolean {
        return (constraint.getValue() as Int) < value as Int
    }
}
