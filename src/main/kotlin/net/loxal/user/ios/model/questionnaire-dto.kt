/*
 * Copyright 2015 Alexander Orlov <alexander.orlov@loxal.net>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.loxal.user.ios.model

import javax.validation.constraints.Min
import javax.validation.constraints.NotNull

data class Poll(NotNull var question: String = "", NotNull var answers: List<String> = listOf())

data class Vote(
        NotNull var referenceQuestion: String = "",
        NotNull Min(value = 0) var answerOptionIndex: Int = 0
) {
    var user: String = "anonymous"

    companion object {
        fun asUser(referenceQuestion: String, answerOptionIndex: Int, user: String): Vote {
            val vote = Vote(referenceQuestion = referenceQuestion, answerOptionIndex = answerOptionIndex)
            vote.user = user

            return vote
        }
    }
}