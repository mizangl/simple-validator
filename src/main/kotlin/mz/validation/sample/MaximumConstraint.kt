package mz.validation.sample

import mz.validation.annotation.Constraints
import mz.validation.constraint.Constraint

@Constraints(
    validator = MaximumValidator::class
)
class MaximumConstraint : Constraint<Int> {
    override fun getErrorMessage(): String = "Maximum value is ${getValue()}"

    override fun getValue() = 11
}