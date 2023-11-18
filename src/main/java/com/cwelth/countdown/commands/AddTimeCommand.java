package com.cwelth.countdown.commands;

import com.cwelth.countdown.CountdownOverlay;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.builder.ArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraftforge.server.command.EnumArgument;

public class AddTimeCommand {
    public enum UnitTypes {
        SECONDS,
        MINUTES,
        HOURS;

        @Override
        public String toString() {
            switch (this) {
                case SECONDS -> { return "Seconds"; }
                case MINUTES -> { return "Minutes"; }
                case HOURS -> { return "Hours"; }
            }
            return "";
        }
    }
    public static ArgumentBuilder<CommandSourceStack, ?> register(CommandDispatcher<CommandSourceStack> dispatcher) {
        return Commands.literal("add")
                .then(Commands.argument("seconds", IntegerArgumentType.integer(0))
                        .executes( cs -> {
                            int seconds = IntegerArgumentType.getInteger(cs,"seconds");
                            CountdownOverlay.totalSeconds += seconds;
                            CountdownOverlay.Update();
                            return 0;
                        })
                        .then(Commands.argument("units", EnumArgument.enumArgument(UnitTypes.class))
                                .executes( cs -> {
                                    int seconds = IntegerArgumentType.getInteger(cs,"seconds");
                                    UnitTypes type = cs.getArgument("units", UnitTypes.class);
                                    int multiplier = 1;
                                    if(type == UnitTypes.MINUTES) multiplier = 60;
                                    if(type == UnitTypes.HOURS) multiplier = 3600;
                                    CountdownOverlay.totalSeconds += seconds * multiplier;
                                    CountdownOverlay.Update();
                                    return 0;
                                })));
    }
}
