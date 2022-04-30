package tg.market.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession
import tg.market.bot.GenericMarketBot

@Service
class BotService(
    @Value("\${tg.bot.token}")
    private val accessToken: String,
    @Value("\${tg.bot.name}")
    private val botName: String,
    @Value("\${tg.bot.menu-url}")
    private val menuUrl: String
) {

    fun startPolling() {
        try {
            val botsApi = TelegramBotsApi(DefaultBotSession::class.java)
            botsApi.registerBot(GenericMarketBot(accessToken, botName, menuUrl))
        } catch (e: TelegramApiException) {
            e.printStackTrace()
        }
    }

}