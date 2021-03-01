package com.trp.coingecko.client

import com.trp.coingecko.model.PingResponse
import com.trp.coingecko.{CoinGeckoAPI, CoinGeckoAPIError, CoinGeckoClient}
import requests.Response
import upickle.default.{macroRW, ReadWriter => RW}
import upickle.default._
import ujson._
import java.lang.Error
import scala.util.{Failure, Success}

class CoinGeckoClientImpl(api: CoinGeckoAPI) extends CoinGeckoClient {
  override def ping: Either[CoinGeckoAPIError, PingResponse] =
    get[PingResponse](endpoint = "ping")

//  def json: Readable = ???

  def get[T](endpoint: String)(implicit reads: Reader[T]) = {
    api.get(endpoint) match {
      case value: Reader[T] =>
        ujson.read(value).transform[T]
      case _ => CoinGeckoAPIError.internalApiError(Some("Internal Api Error"))


//      case Left(json) =>
//        ujson.read(json)
//      case Left(json: Any) =>
//        ujson.read(json).validate[CoinGeckoAPIError] match {
//          case Success(value, _) => Left(value)
//          case Failure(errors) =>
//            Left(CoinGeckoAPIError.internalApiError(Some("Unknown Api Error")))
//        }

//      case Right(json) =>
//        read(json).validate[T] match {
//          case Success(value, _) => Right(value)
//          case Failure(errors) =>
//            Left(
//              CoinGeckoAPIError
//                .internalApiError(Some(s"Invalid Response for $endpoint"))
//            )
//        }
    }
  }
}



