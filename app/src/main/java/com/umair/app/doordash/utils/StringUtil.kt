package com.umair.app.doordash.utils


class StringUtil {
  companion object {
    fun toTitleCase(str: String): String {
      val builder = StringBuilder()
      val splitStr = str.split(" ")
      splitStr.forEachIndexed { index, it ->
        run {
          val c = it[0]
          if (it[0].isLowerCase()) {
            builder.append(it.replaceFirst(c, c.toUpperCase()))
          }
          if (index < splitStr.size - 1)
            builder.append(" ")
        }
      }
      return builder.toString()
    }
  }
}
