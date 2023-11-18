package com.cwelth.countdown;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import org.joml.Vector2i;

public class CountdownOverlay {
    public static int totalSeconds = 0;
    private static String displayTimer = "00:00:00";
    private static String lastTimer = "00:00:00";
    private static boolean isMoving = false;
    public static boolean isRunning = false;
    public static int top = 30;
    public static int left = 30;
    private static float Yoffset = 0;
    private static final ResourceLocation DIGITS_TEXTURE = new ResourceLocation(Countdown.MODID, "textures/gui/digits.png");
    public static void Tick()
    {
        if(!isRunning) return;
        if(totalSeconds == 0) return;
        totalSeconds--;
        if(totalSeconds != 0 && totalSeconds % 3600 == 0)
            Sounds.PlaySoundOnClient("hour_passed");
        if(totalSeconds == 1800)
            Sounds.PlaySoundOnClient("last_thirty");
        if(totalSeconds == 600)
            Sounds.PlaySoundOnClient("last_ten");
        if(totalSeconds == 0)
            Sounds.PlaySoundOnClient("zeroes");
        displayTimer = Prettyfier.SecondsToTime(totalSeconds);
        Config.TIMER_VALUE.set(totalSeconds);
    }

    public static void Update()
    {
        displayTimer = Prettyfier.SecondsToTime(totalSeconds);
        Config.TIMER_VALUE.set(totalSeconds);
        Config.SCREEN_LEFT_OFFSET.set(left);
        Config.SCREEN_TOP_OFFSET.set(top);
    }

    public static final IGuiOverlay COUNTDOWN_OVERLAY = (gui, guiGraphics, partialTicks, width, height) -> {
        guiGraphics.pose().pushPose();
        guiGraphics.pose().scale(0.2f, 0.2f, 1f);
        RenderSystem.enableBlend();
        int l_left = left;
        int l_top = top;
        if (l_left < 0) l_left = (width * 5 - 512) + left;
        if (l_top < 0) l_top = (height * 5 - 80) + top;
        for(int i = 0; i < displayTimer.length(); i++)
        {
            if(Yoffset > 0)
                Yoffset -= partialTicks;

            char currentChar = displayTimer.charAt(i);
            char lastChar = lastTimer.charAt(i);
            Vector2i pos = Prettyfier.GetTopLeft(currentChar);
            Vector2i last_pos = Prettyfier.GetTopLeft(lastChar);
            if(currentChar == lastChar)
            {
                guiGraphics.blit(DIGITS_TEXTURE, l_left, l_top, pos.x, pos.y, 64, 80);
            }
            else
            {
                if(!isMoving)
                {
                    isMoving = true;
                    Yoffset = 80;
                }
                if(Yoffset <= 0)
                {
                    isMoving = false;
                    Yoffset = 0;
                    lastTimer = displayTimer;
                }
                guiGraphics.blit(DIGITS_TEXTURE, l_left, l_top, pos.x, (int)(pos.y + Yoffset), 64, (int)(80 - Yoffset));
                guiGraphics.blit(DIGITS_TEXTURE, l_left, (int)(l_top + 80 - Yoffset), last_pos.x, last_pos.y, 64, (int)(Yoffset));
            }
            l_left += 64;
        }
        guiGraphics.pose().popPose();

    };
}
