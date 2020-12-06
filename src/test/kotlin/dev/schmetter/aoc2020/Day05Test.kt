package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 05")
class Day05Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day5.txt",",")

            // When
            val answer = Day05(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(820)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day5.txt",",")

            // When
            val answer = Day05(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(928)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day5.txt",",")

            // When
            val answer = Day05(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(4)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day5.txt",",")

            // When
            val answer = Day05(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(133)
        }
    }
}