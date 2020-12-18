package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 18")
class Day18Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day18.txt",",")

            // When
            val answer = Day18(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(13709)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day18.txt",",")

            // When
            val answer = Day18(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(1568258264)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsString("examples/day18.txt",",")

            // When
            val answer = Day18(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(23437)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day18.txt",",")

            // When
            val answer = Day18(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(158183007916215)
        }
    }
}