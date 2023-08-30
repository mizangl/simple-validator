package mz.validation.sample

import mz.validation.annotation.Constraints
import mz.validation.constraint.Constraint

@Constraints(
    validator = MinimumValidator::class,
)
data class MinimumConstraint(
    val minimum: Int,
    val message: String
) : Constraint<Int> {

    override fun getErrorMessage(): String = message

    override fun getValue(): Int = minimum
}
