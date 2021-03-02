package com.trp.coingecko.model.coins

import com.trp.coingecko.client.CoinGeckoClientImpl
import com.trp.coingecko.{CoinGeckoAPI, CoinGeckoClient}
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class PingTest extends AnyWordSpec with Matchers {
  val pingTest = new CoinGeckoClientImpl(new CoinGeckoAPI()).ping

//  assert(pingTest.geckoSays == ""
}
