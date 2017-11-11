package no.ern.game.gamelogic.controller

import com.github.tomakehurst.wiremock.WireMockServer
import com.github.tomakehurst.wiremock.common.ConsoleNotifier
import com.github.tomakehurst.wiremock.core.WireMockConfiguration
import io.restassured.RestAssured
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import java.util.logging.Logger

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@ActiveProfiles("test") //to override properties
abstract class ControllerTestBase{

    private val logger : Logger = Logger.getLogger(ControllerTestBase::class.java.canonicalName)

    companion object {
        private lateinit var wiremockServerUser: WireMockServer
        private lateinit var wiremockServerMatch: WireMockServer
        private lateinit var wiremockServerItem: WireMockServer

        @BeforeClass
        @JvmStatic
        fun initClass() {
            RestAssured.baseURI = "http://localhost"
            RestAssured.port = 9084
            RestAssured.basePath = "/game/api/play"
            RestAssured.enableLoggingOfRequestAndResponseIfValidationFails()

            wiremockServerUser = WireMockServer(WireMockConfiguration.wireMockConfig().port(9081).notifier(ConsoleNotifier(true)))
            wiremockServerMatch = WireMockServer(WireMockConfiguration.wireMockConfig().port(9083).notifier(ConsoleNotifier(true)))
            wiremockServerItem = WireMockServer(WireMockConfiguration.wireMockConfig().port(9082).notifier(ConsoleNotifier(true)))


            wiremockServerUser.start()
            wiremockServerMatch.start()
            wiremockServerItem.start()
        }

        @AfterClass
        @JvmStatic
        fun tearDown() {
            wiremockServerUser.stop()
            wiremockServerMatch.stop()
            wiremockServerItem.stop()
        }
    }
}
