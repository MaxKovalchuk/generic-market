package tg.market.service

import dev.inmo.tgbotapi.bot.Ktor.telegramBot
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class BotService(
    @Value("\${tg.bot.token}")
    private val accessToken: String
) {

    fun startPolling(){
        val bot = telegramBot(accessToken)
    }

}
