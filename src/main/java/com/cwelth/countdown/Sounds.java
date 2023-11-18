package com.cwelth.countdown;

import com.cwelth.countdown.Countdown;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Sounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Countdown.MODID);
    public static final RegistryObject<SoundEvent> SOUND_HOUR_PASSED = SOUNDS.register("hour_passed", () -> SoundEvent.createFixedRangeEvent(new ResourceLocation(Countdown.MODID,"hour_passed"), 1.0f));
    public static final RegistryObject<SoundEvent> SOUND_LAST_THIRTY = SOUNDS.register("last_thirty", () -> SoundEvent.createFixedRangeEvent(new ResourceLocation(Countdown.MODID,"last_thirty"), 1.0f));
    public static final RegistryObject<SoundEvent> SOUND_LAST_TEN = SOUNDS.register("last_ten", () -> SoundEvent.createFixedRangeEvent(new ResourceLocation(Countdown.MODID,"last_ten"), 1.0f));
    public static final RegistryObject<SoundEvent> SOUND_ZEROES = SOUNDS.register("zeroes", () -> SoundEvent.createFixedRangeEvent(new ResourceLocation(Countdown.MODID,"zeroes"), 1.0f));
    public static void PlaySoundOnClient(String name)
    {
        RandomSource uselessshit = new LegacyRandomSource(123);
        Minecraft minecraft = Minecraft.getInstance();
        LocalPlayer player = minecraft.player;
        SoundInstance snd = new SimpleSoundInstance(
                new ResourceLocation(Countdown.MODID, name),
                SoundSource.RECORDS,
                0.7f,
                1.0f,
                uselessshit,
                false,
                0,
                SoundInstance.Attenuation.LINEAR,
                player.getX(),
                player.getY(),
                player.getZ(),
                false
        );
        minecraft.getSoundManager().play(snd);
    }
}