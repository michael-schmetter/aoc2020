package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 10")
class Day10Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day10.txt",",")

            // When
            val answer = Day10(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(220)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day10.txt",",")

            // When
            val answer = Day10(input).solvePart1()

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
            val input = Resources.resourceAsString("examples/day10.txt",",")

            // When
            val answer = Day10(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(19208)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day10.txt",",")

            // When
            val answer = Day10(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(18512297918464)
        }
    }
}