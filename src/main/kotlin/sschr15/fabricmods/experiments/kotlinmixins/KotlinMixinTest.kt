package sschr15.fabricmods.experiments.kotlinmixins

import net.fabricmc.api.ClientModInitializer
import net.minecraft.client.MinecraftClient
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import sschr15.fabricmods.experiments.kotlinmixins.mixin.MinecraftClientAccessor

object KotlinMixinTest : ClientModInitializer {
    private val logger: Logger = LogManager.getLogger("kotlin-mixin-test")

    override fun onInitializeClient() {
        logger.info("Kotlin mixin test go brr")

        logger.info((MinecraftClient.getInstance() as MinecraftClientAccessor).windowTitle())
    }
}
