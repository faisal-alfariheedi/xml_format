package com.example.xmlformat

import org.xmlpull.v1.XmlPullParser
import org.xmlpull.v1.XmlPullParserException
import org.xmlpull.v1.XmlPullParserFactory
import java.io.IOException
import java.io.InputStream

class xmlparser {
    private val games = ArrayList<dat.Student>()
    private var text: String? = null

    private var id =0
    private var Name = ""
    private var marks = 0

    fun parse(inputStream: InputStream): List<dat.Student> {
        try {
            val xmlp = XmlPullParserFactory.newInstance()
            val parser = xmlp.newPullParser()
            parser.setInput(inputStream, null)
            var eventType = parser.eventType
            while (eventType != XmlPullParser.END_DOCUMENT) {
                val tagName = parser.name
                when (eventType) {
                    XmlPullParser.TEXT -> text = parser.text
                    XmlPullParser.END_TAG -> when {
                        tagName.equals("id",ignoreCase = true)->{
                            id = text!!.toInt()
                        }
                        tagName.equals("name", ignoreCase = true) -> {
                            Name = text.toString()
                        }
                        tagName.equals("marks", ignoreCase = true) -> {
                            marks = text!!.toInt()
                        }
                        else -> games.add(dat.Student(id, Name, marks))
                    }

                    else -> {
                    }
                }
                eventType = parser.next()
            }

        } catch (e: XmlPullParserException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return games
    }
}