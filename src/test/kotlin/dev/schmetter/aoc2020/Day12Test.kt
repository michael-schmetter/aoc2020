package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 12")
class Day12Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day12.txt",",")

            // When
            val answer = Day12(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(25)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day12.txt",",")

            // When
            val answer = Day12(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(1570)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day12.2.txt",",")

            // When
            val answer = Day12(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(286)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day12.txt",",")

            // When
            val answer = Day12(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(2159)
        }
    }
}