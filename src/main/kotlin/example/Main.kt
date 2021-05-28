package example

import org.redisson.Redisson
import org.redisson.api.LocalCachedMapOptions
import org.redisson.api.RMap
import org.redisson.api.map.MapLoader

class Main {

    private val mapLoader = object : MapLoader<Int, String> {
        val data = mapOf(1 to "foo")

        override fun load(key: Int) = data[key]
        override fun loadAllKeys() = data.keys.toMutableList()
    }

    fun run() {
        val redisson = Redisson.create()
        val map: RMap<Int, String> = redisson.getLocalCachedMap(
            "test-map",
            LocalCachedMapOptions.defaults<Int, String>().loader(mapLoader).storeMode(LocalCachedMapOptions.StoreMode.LOCALCACHE)
        )
        requireNotNull(map[1]) { "I'm null!" }
    }


}

fun main() = Main().run()