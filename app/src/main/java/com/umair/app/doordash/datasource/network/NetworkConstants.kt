package com.umair.app.doordash.datasource.network

class NetworkConstants {
    companion object {
        const val DEFAULT_TIMEOUT = 10L

        // Query Params
        const val QUERY_LATITUDE = "lat"
        const val QUERY_LONGITUDE = "lng"
        const val QUERY_LIMIT = "limit"
        const val QUERY_OFFSET = "offset"

        // URLs
        const val BASE_URL = "https://api.doordash.com"
        const val ENDPOINT_VERSION = "v2"
        const val ENDPOINT_RESTAURANT = "restaurant"
        const val DELIMITER = "/"
    }
}