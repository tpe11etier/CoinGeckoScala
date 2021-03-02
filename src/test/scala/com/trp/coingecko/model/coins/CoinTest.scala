package com.trp.coingecko.model.coins

import com.trp.coingecko.CoinGeckoAPI
import com.trp.coingecko.client.CoinGeckoClientImpl
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec


class CoinTest extends AnyWordSpec with Matchers {

  "A coin" should {
    "have an id" in {
      val bitcoin = Coin(id="bitcoin")
      val b = new CoinGeckoClientImpl(new CoinGeckoAPI()).getPrice(List("bitcoin"), List("eth", "usd"))
      assert(bitcoin.id == "bitcoin")
    }
  }

}
