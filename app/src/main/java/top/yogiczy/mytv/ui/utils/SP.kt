package top.yogiczy.mytv.ui.utils

import android.content.Context
import android.content.SharedPreferences
import top.yogiczy.mytv.data.utils.Constants

/**
 * 应用配置存储
 */
object SP {
    private const val SP_NAME = "mytv"
    private const val SP_MODE = Context.MODE_PRIVATE
    private lateinit var sp: SharedPreferences

    fun getInstance(context: Context): SharedPreferences =
        context.getSharedPreferences(SP_NAME, SP_MODE)

    fun init(context: Context) {
        sp = getInstance(context)
    }

    // ---- Property Delegates ----
    private fun boolPref(key: String, default: Boolean) = object {
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): Boolean =
            sp.getBoolean(key, default)
        operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: Boolean) =
            sp.edit().putBoolean(key, value).apply()
    }

    private fun intPref(key: String, default: Int) = object {
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): Int =
            sp.getInt(key, default)
        operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: Int) =
            sp.edit().putInt(key, value).apply()
    }

    private fun longPref(key: String, default: Long) = object {
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): Long =
            sp.getLong(key, default)
        operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: Long) =
            sp.edit().putLong(key, value).apply()
    }

    private fun floatPref(key: String, default: Float) = object {
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): Float =
            sp.getFloat(key, default)
        operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: Float) =
            sp.edit().putFloat(key, value).apply()
    }

    private fun stringPref(key: String, default: String) = object {
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): String =
            sp.getString(key, default) ?: default
        operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: String) =
            sp.edit().putString(key, value).apply()
    }

    private fun stringSetPref(key: String, default: Set<String>) = object {
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): Set<String> =
            sp.getStringSet(key, default) ?: default
        operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: Set<String>) =
            sp.edit().putStringSet(key, value).apply()
    }

    // ---- Keys ----
    private const val K_APP_BOOT_LAUNCH = "APP_BOOT_LAUNCH"
    private const val K_APP_LAST_LATEST_VERSION = "APP_LAST_LATEST_VERSION"
    private const val K_APP_DEVICE_DISPLAY_TYPE = "APP_DEVICE_DISPLAY_TYPE"
    private const val K_DEBUG_SHOW_FPS = "DEBUG_SHOW_FPS"
    private const val K_DEBUG_SHOW_VIDEO_PLAYER_METADATA = "DEBUG_SHOW_VIDEO_PLAYER_METADATA"
    private const val K_IPTV_LAST_IPTV_IDX = "IPTV_LAST_IPTV_IDX"
    private const val K_IPTV_CHANNEL_CHANGE_FLIP = "IPTV_CHANNEL_CHANGE_FLIP"
    private const val K_IPTV_SOURCE_SIMPLIFY = "IPTV_SOURCE_SIMPLIFY"
    private const val K_IPTV_SOURCE_URL = "IPTV_SOURCE_URL"
    private const val K_IPTV_SOURCE_CACHE_TIME = "IPTV_SOURCE_CACHE_TIME"
    private const val K_IPTV_PLAYABLE_HOST_LIST = "IPTV_PLAYABLE_HOST_LIST"
    private const val K_IPTV_SOURCE_URL_HISTORY_LIST = "IPTV_SOURCE_URL_HISTORY_LIST"
    private const val K_IPTV_CHANNEL_NO_SELECT_ENABLE = "IPTV_CHANNEL_NO_SELECT_ENABLE"
    private const val K_IPTV_CHANNEL_FAVORITE_ENABLE = "IPTV_CHANNEL_FAVORITE_ENABLE"
    private const val K_IPTV_CHANNEL_FAVORITE_LIST_VISIBLE = "IPTV_CHANNEL_FAVORITE_LIST_VISIBLE"
    private const val K_IPTV_CHANNEL_FAVORITE_LIST = "IPTV_CHANNEL_FAVORITE_LIST"
    private const val K_EPG_ENABLE = "EPG_ENABLE"
    private const val K_EPG_XML_URL = "EPG_XML_URL"
    private const val K_EPG_REFRESH_TIME_THRESHOLD = "EPG_REFRESH_TIME_THRESHOLD"
    private const val K_EPG_XML_URL_HISTORY_LIST = "EPG_XML_URL_HISTORY_LIST"
    private const val K_UI_SHOW_EPG_PROGRAMME_PROGRESS = "UI_SHOW_EPG_PROGRAMME_PROGRESS"
    private const val K_UI_USE_CLASSIC_PANEL_SCREEN = "UI_USE_CLASSIC_PANEL_SCREEN"
    private const val K_UI_DENSITY_SCALE_RATIO = "UI_DENSITY_SCALE_RATIO"
    private const val K_UI_FONT_SCALE_RATIO = "UI_FONT_SCALE_RATIO"
    private const val K_UI_TIME_SHOW_MODE = "UI_TIME_SHOW_MODE"
    private const val K_UI_PIP_MODE = "UI_PIP_MODE"
    private const val K_UPDATE_FORCE_REMIND = "UPDATE_FORCE_REMIND"
    private const val K_VIDEO_PLAYER_USER_AGENT = "VIDEO_PLAYER_USER_AGENT"
    private const val K_VIDEO_PLAYER_LOAD_TIMEOUT = "VIDEO_PLAYER_LOAD_TIMEOUT"
    private const val K_VIDEO_PLAYER_ASPECT_RATIO = "VIDEO_PLAYER_ASPECT_RATIO"

    // ---- Properties ----
    var appBootLaunch: Boolean by boolPref(K_APP_BOOT_LAUNCH, false)
    var appLastLatestVersion: String by stringPref(K_APP_LAST_LATEST_VERSION, "")
    var appDeviceDisplayType: AppDeviceDisplayType by intEnumPref(K_APP_DEVICE_DISPLAY_TYPE, AppDeviceDisplayType.LEANBACK)
    var debugShowFps: Boolean by boolPref(K_DEBUG_SHOW_FPS, false)
    var debugShowVideoPlayerMetadata: Boolean by boolPref(K_DEBUG_SHOW_VIDEO_PLAYER_METADATA, false)
    var iptvLastIptvIdx: Int by intPref(K_IPTV_LAST_IPTV_IDX, 0)
    var iptvChannelChangeFlip: Boolean by boolPref(K_IPTV_CHANNEL_CHANGE_FLIP, false)
    var iptvSourceSimplify: Boolean by boolPref(K_IPTV_SOURCE_SIMPLIFY, false)
    var iptvSourceUrl: String by stringPref(K_IPTV_SOURCE_URL, Constants.IPTV_SOURCE_URL)
    var iptvSourceCacheTime: Long by longPref(K_IPTV_SOURCE_CACHE_TIME, Constants.IPTV_SOURCE_CACHE_TIME)
    var iptvPlayableHostList: Set<String> by stringSetPref(K_IPTV_PLAYABLE_HOST_LIST, emptySet())
    var iptvSourceUrlHistoryList: Set<String> by stringSetPref(K_IPTV_SOURCE_URL_HISTORY_LIST, emptySet())
    var iptvChannelNoSelectEnable: Boolean by boolPref(K_IPTV_CHANNEL_NO_SELECT_ENABLE, true)
    var iptvChannelFavoriteEnable: Boolean by boolPref(K_IPTV_CHANNEL_FAVORITE_ENABLE, true)
    var iptvChannelFavoriteListVisible: Boolean by boolPref(K_IPTV_CHANNEL_FAVORITE_LIST_VISIBLE, false)
    var iptvChannelFavoriteList: Set<String> by stringSetPref(K_IPTV_CHANNEL_FAVORITE_LIST, emptySet())
    var epgEnable: Boolean by boolPref(K_EPG_ENABLE, true)
    var epgXmlUrl: String by stringPref(K_EPG_XML_URL, Constants.EPG_XML_URL)
    var epgRefreshTimeThreshold: Int by intPref(K_EPG_REFRESH_TIME_THRESHOLD, Constants.EPG_REFRESH_TIME_THRESHOLD)
    var epgXmlUrlHistoryList: Set<String> by stringSetPref(K_EPG_XML_URL_HISTORY_LIST, emptySet())
    var uiShowEpgProgrammeProgress: Boolean by boolPref(K_UI_SHOW_EPG_PROGRAMME_PROGRESS, true)
    var uiUseClassicPanelScreen: Boolean by boolPref(K_UI_USE_CLASSIC_PANEL_SCREEN, false)
    var uiDensityScaleRatio: Float by floatPref(K_UI_DENSITY_SCALE_RATIO, 1f)
    var uiFontScaleRatio: Float by floatPref(K_UI_FONT_SCALE_RATIO, 1f)
    var uiTimeShowMode: UiTimeShowMode by intEnumPref(K_UI_TIME_SHOW_MODE, UiTimeShowMode.ALWAYS)
    var uiPipMode: Boolean by boolPref(K_UI_PIP_MODE, false)
    var updateForceRemind: Boolean by boolPref(K_UPDATE_FORCE_REMIND, false)
    var videoPlayerUserAgent: String by stringPref(K_VIDEO_PLAYER_USER_AGENT, Constants.VIDEO_PLAYER_USER_AGENT)
    var videoPlayerLoadTimeout: Long by longPref(K_VIDEO_PLAYER_LOAD_TIMEOUT, Constants.VIDEO_PLAYER_LOAD_TIMEOUT)
    var videoPlayerAspectRatio: VideoPlayerAspectRatio by intEnumPref(K_VIDEO_PLAYER_ASPECT_RATIO, VideoPlayerAspectRatio.ORIGINAL)

    // ---- Enum helpers ----
    private inline fun <reified T : Enum<T>> intEnumPref(key: String, default: T) = object {
        operator fun getValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>): T {
            val value = sp.getInt(key, default.value)
            return enumValues<T>().firstOrNull { (it as? EnumWithValue)?.value == value } ?: default
        }
        operator fun setValue(thisRef: Any?, property: kotlin.reflect.KProperty<*>, value: T) =
            sp.edit().putInt(key, (value as EnumWithValue).value).apply()
    }

    interface EnumWithValue {
        val value: Int
    }

    enum class UiTimeShowMode(override val value: Int) : EnumWithValue {
        HIDDEN(0), ALWAYS(1), EVERY_HOUR(2), HALF_HOUR(3);
    }

    enum class AppDeviceDisplayType(override val value: Int) : EnumWithValue {
        LEANBACK(0), MOBILE(1), PAD(2);
    }

    enum class VideoPlayerAspectRatio(override val value: Int) : EnumWithValue {
        ORIGINAL(0), SIXTEEN_NINE(1), FOUR_THREE(2), AUTO(3);
    }
}