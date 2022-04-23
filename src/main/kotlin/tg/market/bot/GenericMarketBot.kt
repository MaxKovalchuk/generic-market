package tg.market.bot

import org.telegram.telegrambots.bots.DefaultBotOptions
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow
import org.telegram.telegrambots.meta.api.objects.webapp.WebAppInfo
import org.telegram.telegrambots.meta.exceptions.TelegramApiException
import java.util.*

class GenericMarketBot(
    private val token: String,
    private val botName: String,
    private val menuUrl: String
) : TelegramLongPollingBot(DefaultBotOptions()) {

    override fun getBotToken() = token

    override fun getBotUsername() = botName

    override fun onUpdateReceived(update: Update) {
        if (update.hasMessage() && update.message.hasText()) {
            val message = SendMessage() // Create a SendMessage object with mandatory fields
            message.chatId = update.message.chatId.toString()
            message.text = update.message.text
//            inlineKeyboard(message)
            message.replyMarkup = replyKeyboard(message)
            try {
                execute(message) // Call method to send the message
            } catch (e: TelegramApiException) {
                e.printStackTrace()
            }
        }
    }

    //button under message
    private fun inlineKeyboard(message: SendMessage): InlineKeyboardMarkup {
        val button = InlineKeyboardButton()
        button.text = "Menu"
        button.url = "https://core.telegram.org/bots/webapps"

        val row = ArrayList<InlineKeyboardButton>()
        row.add(button)

        val rows = ArrayList<List<InlineKeyboardButton>>()
        rows.add(row)

        val inlineKeyboardMarkup = InlineKeyboardMarkup()
        inlineKeyboardMarkup.keyboard = rows
        return inlineKeyboardMarkup
    }

    //keyboard instead of default one under text input row
    private fun replyKeyboard(message: SendMessage): ReplyKeyboardMarkup {
        val webAppInfo = WebAppInfo()
        webAppInfo.url = "http://localhost:8080/front/menu"

        val keyboardButton = KeyboardButton()
        keyboardButton.text = "Menu"
        keyboardButton.webApp = webAppInfo

        val keyboardRow = KeyboardRow()
        keyboardRow.add(keyboardButton)

        val keyboard = ArrayList<KeyboardRow>()
        keyboard.add(keyboardRow)

        val keyboardMarkup = ReplyKeyboardMarkup()
        keyboardMarkup.keyboard = keyboard
        return keyboardMarkup
    }
}