package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 13")
class Day13Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day13.txt","|")

            // When
            val answer = Day13(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(295)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day13.txt","|")

            // When
            val answer = Day13(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(4135)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day13.txt","|")

            // When
            val answer = Day13(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(1068781)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day13.txt","|")

            // When
            val answer = Day13(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(1068781)
        }
    }
}