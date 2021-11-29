package com.trp.coingecko.model.coins.data

//import upickle.default._
import com.trp.coingecko.utils.OptionPickler._

case class CommunityData(
                          facebook_likes: String,
                          twitter_followers: Long,
                          reddit_average_posts_48h: Double,
                          reddit_average_comments_48h: Double,
                          reddit_subscribers: Long,
                          reddit_accounts_active_48h: Double
                        )

object CommunityData {
implicit val readsCommunityData: ReadWriter[CommunityData] = macroRW[CommunityData]
}


