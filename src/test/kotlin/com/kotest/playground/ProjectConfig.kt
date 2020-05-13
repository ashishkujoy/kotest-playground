package com.kotest.playground

import io.kotest.core.config.AbstractProjectConfig
import io.kotest.core.listeners.Listener
import io.kotest.core.listeners.TestListener
import io.kotest.core.spec.Spec
import org.mockito.exceptions.misusing.InjectMocksException

object ProjectConfig : AbstractProjectConfig() {
    override fun listeners(): List<Listener>  = listOf(ABeforeSpecFailingListener)
}

object ABeforeSpecFailingListener : TestListener {
    override suspend fun beforeSpec(spec: Spec) {
        throw InjectMocksException("Boom", Throwable("Bean not found"))
    }
}