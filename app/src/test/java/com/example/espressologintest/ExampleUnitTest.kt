package com.example.espressologintest

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before


class ExampleUnitTest {
    private var exampleModel = ExampleModel()


    @Before
    fun before() {
        exampleModel = ExampleModel()
    }

    @Test
    fun `assert addiction was correct`() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `assert the variable is true`() {
        exampleModel.exampleBoolean = true
        val bool = exampleModel.exampleBoolean == true
        assertTrue(bool)
    }

    @Test
    fun `assert variabe is false`() {
        val bool = exampleModel.exampleBoolean == true
        assertFalse(bool)
    }

    private data class ExampleModel(var exampleBoolean: Boolean? = null)
}
