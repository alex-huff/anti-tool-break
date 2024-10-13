package blazingtwist.antitoolbreak.mixin;

import blazingtwist.antitoolbreak.AntiToolBreak;
import net.minecraft.client.network.message.MessageHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MessageHandler.class)
public
class MessageHandler_mixin
{
    @Inject(at = @At("HEAD"), method = "onGameMessage(Lnet/minecraft/text/Text;Z)V")
    public
    void onGameMessage(Text message, boolean overlay, CallbackInfo ci)
    {
        String messageString = Formatting.strip(message.getString());
        if (messageString == null)
        {
            return;
        }
        AntiToolBreak.onMessage(messageString);
    }
}