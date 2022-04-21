package tg.market.service

import dev.inmo.tgbotapi.extensions.api.telegramBot
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class BotService(
    @Value("\${tg.bot.token}")
    private val accessToken: String
) {

    fun startPolling(){
        val bot = telegramBot(accessToken) {}
    }

}
