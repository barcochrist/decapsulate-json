package co.com.programacionmaster.retrofitpractice.source.remote.config

import com.google.gson.*
import com.google.gson.reflect.TypeToken
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter

private const val DATA = "content"

class CustomTypeAdapterFactory : TypeAdapterFactory {

    override fun <T : Any?> create(gson: Gson?, type: TypeToken<T>?): TypeAdapter<T> {
        val delegate: TypeAdapter<T> = gson!!.getDelegateAdapter(this, type)
        val elementAdapter: TypeAdapter<JsonElement> = gson!!.getAdapter(JsonElement::class.java)

        return object : TypeAdapter<T>() {
            override fun write(out: JsonWriter?, value: T) {
                delegate.write(out, value)
            }

            override fun read(`in`: JsonReader?): T {
                var jsonElement: JsonElement = elementAdapter.read(`in`)

                if (jsonElement.isJsonObject) {
                    val jsonObject: JsonObject = jsonElement.asJsonObject
                    if (jsonObject.has(DATA)) {
                        jsonElement = jsonObject.get(DATA)
                    }
                }
                return delegate.fromJsonTree(jsonElement)
            }
        }.nullSafe()
    }
}