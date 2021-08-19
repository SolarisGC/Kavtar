package com.example

import com.jessecorbett.diskord.bot.bot
import com.jessecorbett.diskord.bot.classicCommands


/*
* Isso pode ser substituído por qualquer método para carregar o token do bot. Este método específico é fornecido apenas por conveniência
 * e como uma forma de prevenir a divulgação acidental de tokens de bot.
 *
 * Os métodos alternativos podem incluir a leitura do ambiente, o uso de uma propriedade do sistema ou a leitura da CLI.
 */
private val BOT_TOKEN = try {
    ClassLoader.getSystemResource("bot-token.txt").readText().trim()
} catch (error: Exception) {
    throw RuntimeException("Failed to load bot token. Make sure to create a file named bot-token.txt in" +
            " src/main/resources and paste the bot token into that file.", error)
}

suspend fun main(args: Array<String>) {
    bot(BOT_TOKEN) {
        classicCommands {
            command("ping") { message ->
                message.respond("Pong!")
            }
        }
    }
}
