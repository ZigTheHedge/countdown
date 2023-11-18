package com.cwelth.countdown.commands;

import com.cwelth.countdown.CountdownOverlay;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class StartCommand {
    public static ArgumentBuilder<CommandSourceStack, ?> register(CommandDispatcher<CommandSourceStack> dispatcher) {
        return Commands.literal("start")
                    .executes( cs -> {
                        CountdownOverlay.isRunning = true;
                        return 0;
                    });
    }
}
