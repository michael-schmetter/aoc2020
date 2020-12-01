package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 01")
class Day01Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = "1721,979,366,299,675,1456"

            // When
            val answer = Day01(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(514579)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day1.txt",",")

            // When
            val answer = Day01(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(252724)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Given
            val input = "1721,979,366,299,675,1456"

            // When
            val answer = Day01(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(241861950)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day1.txt",",")

            // When
            val answer = Day01(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(276912720)
        }
    }
}