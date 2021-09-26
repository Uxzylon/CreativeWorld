package com.gmail.anthony17j.creativeworld.command;

import com.gmail.anthony17j.creativeworld.Main;
import com.gmail.anthony17j.creativeworld.Utils;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.tree.LiteralCommandNode;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;

import static net.minecraft.server.command.CommandManager.literal;

public class creatifCommand {
    public static LiteralCommandNode<ServerCommandSource> commandNode;
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher, boolean dedicated) {
        commandNode = dispatcher.register(literal("creatif").executes(creatifCommand::creatif));
    }

    static int creatif(CommandContext<ServerCommandSource> context) throws CommandSyntaxException {
        ServerPlayerEntity player = context.getSource().getPlayer();

        if (player.getServerWorld().getRegistryKey() != Main.CREATIVE_KEY) {
            Utils.saveInv(player,"survival");
            Utils.loadInv(player,"creative");
            //player.sendMessage(new LiteralText("Bienvenue dans le monde créatif"), false);
        } else {
            Utils.saveInv(player,"creative");
            Utils.loadInv(player,"survival");
        }
        return 0;
    }
}
