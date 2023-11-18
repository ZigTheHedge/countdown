package com.cwelth.countdown;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Countdown.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.IntValue SCREEN_LEFT_OFFSET = BUILDER
            .comment("Timer position left")
            .defineInRange("screen_left_offset", 30, Integer.MIN_VALUE, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.IntValue SCREEN_TOP_OFFSET = BUILDER
            .comment("Timer position top")
            .defineInRange("screen_top_offset", 30, Integer.MIN_VALUE, Integer.MAX_VALUE);
    public static final ForgeConfigSpec.IntValue TIMER_VALUE = BUILDER
            .comment("Timer value (in seconds)")
            .defineInRange("timer_value", 0, 0, Integer.MAX_VALUE);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        CountdownOverlay.left = SCREEN_LEFT_OFFSET.get();
        CountdownOverlay.top = SCREEN_TOP_OFFSET.get();
        CountdownOverlay.totalSeconds = TIMER_VALUE.get();
        CountdownOverlay.Update();
    }

}
