package com.umair.app.doordash.model

import com.google.gson.annotations.SerializedName

data class RestaurantOverview(
        @SerializedName("is_time_surging") val isTimeSurging: Boolean = false,
        @SerializedName("max_order_size") val maxOrderSize: Any? = Any(),
        @SerializedName("delivery_fee") val deliveryFee: Int = 0,
        @SerializedName("max_composite_score") val maxCompositeScore: Int = 0,
        @SerializedName("id") val id: Int = 0,
        @SerializedName("merchant_promotions") val merchantPromotions: List<MerchantPromotion> = listOf(),
        @SerializedName("average_rating") val averageRating: Double = 0.0,
        @SerializedName("menus") val menus: List<OverviewMenu> = listOf(),
        @SerializedName("composite_score") val compositeScore: Int = 0,
        @SerializedName("status_type") val statusType: String = "",
        @SerializedName("is_only_catering") val isOnlyCatering: Boolean = false,
        @SerializedName("status") val status: String = "",
        @SerializedName("number_of_ratings") val numberOfRatings: Int = 0,
        @SerializedName("asap_time") val asapTime: Int = 0,
        @SerializedName("description") val description: String = "",
        @SerializedName("business") val business: OverviewBusiness = OverviewBusiness(),
        @SerializedName("tags") val tags: List<String> = listOf(),
        @SerializedName("yelp_review_count") val yelpReviewCount: Int = 0,
        @SerializedName("business_id") val businessId: Int = 0,
        @SerializedName("extra_sos_delivery_fee") val extraSosDeliveryFee: Int = 0,
        @SerializedName("yelp_rating") val yelpRating: Double = 0.0,
        @SerializedName("cover_img_url") val coverImgUrl: String = "",
        @SerializedName("header_img_url") val headerImgUrl: String = "",
        @SerializedName("address") val address: OverviewAddress = OverviewAddress(),
        @SerializedName("price_range") val priceRange: Int = 0,
        @SerializedName("slug") val slug: String = "",
        @SerializedName("name") val name: String = "",
        @SerializedName("is_newly_added") val isNewlyAdded: Boolean = false,
        @SerializedName("url") val url: String = "",
        @SerializedName("service_rate") val serviceRate: Double = 0.0,
        @SerializedName("promotion") val promotion: Any? = Any(),
        @SerializedName("featured_category_description") val featuredCategoryDescription: String? = ""
)