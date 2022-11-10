package com.example.test

import junit.framework.TestCase.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

class MathTest {

    var math: Math? =null

    @Before
    fun setup() {
        math = Math()
    }

    @Test
    fun addSimpleTest(){
        assertEquals("4",math?.add("2","2"))
    }

    @Test
    fun addEmptyTest(){
        assertEquals("Вы не заполнили поля", math?.add("2", ""))

    }

    @Test
    fun addDoubleTest(){
        assertEquals("7", math?.add("5.0", "2.0"))

    }


    @Test
    fun addInitDoubleTest(){
        assertEquals("5.0", math?.add("2", "0.3"))
    }


    @Test
    fun simpleDivide(){
        assertEquals("2", math?.divide("6", "3"))
    }

    @Test
    fun divideOnZero(){
        assertEquals("Делить на ноль нельзя",math?.divide("6","0"))
    }

    @Test
    fun addNegativeTest(){
        assertEquals("3", math?.add("6", "-3"))
    }

    @Test
    fun symbolAddTest(){
        assertEquals("Символы не складываются", math?.add("two", "cuphead"))
    }


    @After
    fun detach() {
        math = null
    }

}