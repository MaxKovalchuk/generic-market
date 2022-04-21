package tg.market.web

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import tg.market.service.BotService

@RestController
@RequestMapping("/bot")
class BotController(
    private val botService: BotService
) {

    @PostMapping("/start")
    fun start() = botService.startPolling()
}