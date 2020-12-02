package dev.schmetter.aoc2020

import dev.schmetter.aoc2020.util.Resources
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

@DisplayName("Day 02")
class Day02Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `Matches example`() {
            // Given
            val input = "1-3 a: abcde,1-3 b: cdefg,2-9 c: ccccccccc"

            // When
            val answer = Day02(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(2)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day2.txt",",")

            // When
            val answer = Day02(input).solvePart1()

            // Then
            assertThat(answer).isEqualTo(456)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `Matches example`() {
            // Given
            val input = "1-3 a: abcde,1-3 b: cdefg,2-9 c: ccccccccc"

            // When
            val answer = Day02(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(1)
        }

        @Test
        fun `Actual answer`() {
            // Given
            val input = Resources.resourceAsString("day2.txt",",")

            // When
            val answer = Day02(input).solvePart2()

            // Then
            assertThat(answer).isEqualTo(308)
        }
    }
}