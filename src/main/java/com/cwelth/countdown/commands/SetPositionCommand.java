package com.cwelth.countdown.commands;

import com.cwelth.countdown.CountdownOverlay;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class SetPositionCommand {
    public static ArgumentBuilder<CommandSourceStack, ?> register(CommandDispatcher<CommandSourceStack> dispatcher) {
        return Commands.literal("setposition")
                .then(Commands.argument("left", IntegerArgumentType.integer())
                        .then(Commands.argument("top", IntegerArgumentType.integer())
                                .executes( cs -> {
                                    int left = IntegerArgumentType.getInteger(cs,"left");
                                    int top = IntegerArgumentType.getInteger(cs,"top");
                                    CountdownOverlay.left = left;
                                    CountdownOverlay.top = top;
                                    CountdownOverlay.Update();
                                    return 0;
                                })));
    }
}
