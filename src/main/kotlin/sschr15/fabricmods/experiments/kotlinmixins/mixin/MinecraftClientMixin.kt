package sschr15.fabricmods.experiments.kotlinmixins.mixin

import net.minecraft.client.MinecraftClient
import net.minecraft.client.RunArgs
import org.apache.logging.log4j.Logger
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.gen.Accessor
import org.spongepowered.asm.mixin.gen.Invoker
import org.spongepowered.asm.mixin.injection.At
import org.spongepowered.asm.mixin.injection.Inject
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo

@Mixin(MinecraftClient::class)
interface MinecraftClientAccessor {
    @Invoker("getWindowTitle") fun windowTitle(): String

    val logger: Logger @Accessor("LOGGER") get
}

@Mixin(MinecraftClient::class)
abstract class MinecraftClientMixin : MinecraftClientAccessor {
    @Inject(method = ["<init>"], at = [At("RETURN")])
    private fun kotlinConcern(args: RunArgs, ci: CallbackInfo) {
        val version = args.game.version
        logger.info("The current version is '$version' and the window title is '${windowTitle()}', I think...")
    }
}
