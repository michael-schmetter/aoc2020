package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 03")
class Day03Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day3.txt",",")

            // When
            val answer = Day03(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(7)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day3.txt",",")

            // When
            val answer = Day03(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(171)
        }
    }

    @Nested
    @DisplayName("Part 3")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day3.txt",",")

            // When
            val answer = Day03(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(336)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day3.txt",",")

            // When
            val answer = Day03(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(1206576000)
        }
    }
}