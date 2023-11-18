package com.cwelth.countdown.commands;

import com.cwelth.countdown.CountdownOverlay;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class ResetCommand {
    public static ArgumentBuilder<CommandSourceStack, ?> register(CommandDispatcher<CommandSourceStack> dispatcher) {
        return Commands.literal("reset")
                .executes( cs -> {
                    CountdownOverlay.totalSeconds = 0;
                    CountdownOverlay.Update();
                    return 0;
                });
    }
}
