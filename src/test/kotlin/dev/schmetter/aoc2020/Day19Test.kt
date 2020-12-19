package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 19")
class Day19Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("examples/day19.txt","~")

            // When
            val answer = Day19(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(2)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("day19.txt","~")

            // When
            val answer = Day19(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(120)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("examples/day19.2.txt","~")

            // When
            val answer = Day19(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(12)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsStringSplitByNewline("day19.txt","~")

            // When
            val answer = Day19(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(350)
        }
    }
}