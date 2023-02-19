package com.gram15inch.data.policy

import com.gram15inch.domain.BuildConfig

object NetworkPolicy {
    const val NAVER_BASE_URL = "https://openapi.naver.com/"

    const val NAVER_HEADER_CLIENT_ID = "X-Naver-Client-Id:${BuildConfig.NAVER_CLIENT_ID}"
    const val NAVER_HEADER_CLIENT_SECRET = "X-Naver-Client-Secret:${BuildConfig.NAVER_CLIENT_SECRET}"
}