package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 09")
class Day09Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day9.txt",",")

            // When
            val answer = Day09(input).solvePart1(5)

            // Then
            assertThat(answer).isEqualTo(127)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day9.txt",",")

            // When
            val answer = Day09(input).solvePart1(25)

            // Then
            assertThat(answer).isEqualTo(1930745883)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day9.txt",",")

            // When
            val answer = Day09(input).solvePart2(127)

            // Then
            assertThat(answer).isEqualTo(62)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day9.txt",",")

            // When
            val answer = Day09(input).solvePart2(1930745883)

            // Then
            assertThat(answer).isEqualTo(268878261)
        }
    }
}