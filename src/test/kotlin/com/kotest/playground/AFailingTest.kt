package com.kotest.playground

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe

class AFailingTest : AnnotationSpec(){
    @Test
    fun `one`() {
        1 shouldBe 1
    }
}