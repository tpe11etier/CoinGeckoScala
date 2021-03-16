package com.trp.coingecko.model.coins.data

import upickle.default._

case class DeveloperData(
                          forks: Int,
                          stars: Int,
                          subscribers: Int,
                          total_issues: Int,
                          closed_issues: Int,
                          pull_requests_merged: Int,
                          pull_request_contributors: Int,
                          code_additions_deletions_4_weeks: CodeAdditionsDeletions4Weeks,
                          commit_count_4_weeks: Int
                        )

object DeveloperData {
  implicit val readsDeveloperData: ReadWriter[DeveloperData] = macroRW[DeveloperData]
}