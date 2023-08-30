package mz.validation

import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.shouldBe
import mz.validation.constraint.Constraint
import mz.validation.sample.MaximumConstraint
import mz.validation.sample.MinimumConstraint
import org.junit.jupiter.api.Test

class ValidationsTest {


    private val maximumConstraint = MaximumConstraint()
    private val minimumConstraint = MinimumConstraint(
        5,
        "It needs at least 5"
    )

    @Test
    fun `test validation minimum without error`() {

        val error = Constraint.validate(
            listOf(minimumConstraint),
            6
        )

        error.shouldBeNull()
    }

    @Test
    fun `test validation minimum with error`() {

        val error = Constraint.validate(
            listOf(minimumConstraint),
            4
        )

        error.shouldBe("It needs at least 5")
    }

    @Test
    fun `test validation maximum without error`() {

        val error = Constraint.validate(
            listOf(maximumConstraint),
            6
        )

        error.shouldBeNull()
    }

    @Test
    fun `test validation maximum with error`() {

        val error = Constraint.validate(
            listOf(maximumConstraint),
            14
        )

        error.shouldBe("Maximum value is 11")
    }

    @Test
    fun `test validation minimum and maximum, with maximum error`() {

        val error = Constraint.validate(
            listOf(minimumConstraint, maximumConstraint),
            14
        )

        error.shouldBe("Maximum value is 11")
    }

    @Test
    fun `test validation minimum and maximum, with minimum error`() {

        val error = Constraint.validate(
            listOf(minimumConstraint, maximumConstraint),
            4
        )

        error.shouldBe("It needs at least 5")
    }
}