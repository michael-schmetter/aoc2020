package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 08")
class Day08Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day8.txt",",")

            // When
            val answer = Day08(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(5)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day8.txt",",")

            // When
            val answer = Day08(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(1087)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day8.txt",",")

            // When
            val answer = Day08(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(8)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day8.txt",",")

            // When
            val answer = Day08(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(780)
        }
    }
}