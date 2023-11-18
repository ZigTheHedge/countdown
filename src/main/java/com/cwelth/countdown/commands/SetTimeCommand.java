package com.cwelth.countdown.commands;

import com.cwelth.countdown.CountdownOverlay;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class SetTimeCommand {
    public static ArgumentBuilder<CommandSourceStack, ?> register(CommandDispatcher<CommandSourceStack> dispatcher) {
        return Commands.literal("set")
                .then(Commands.argument("seconds", IntegerArgumentType.integer(0))
                        .executes( cs -> {
                            int seconds = IntegerArgumentType.getInteger(cs,"seconds");
                            CountdownOverlay.totalSeconds = seconds;
                            CountdownOverlay.Update();
                            return 0;
                        }));
    }
}
