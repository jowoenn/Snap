import android.app.Application
import com.jowoen.snap.data.model.User
import dagger.hilt.android.HiltAndroidApp
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

@HiltAndroidApp
class SnapApplication : Application() {
    lateinit var realm: Realm
        private set

    override fun onCreate() {
        super.onCreate()

        val config = RealmConfiguration.Builder(
            schema = setOf(
                User::class
            )
        )
            .name("@string/appNameDb")
            .schemaVersion(1)
            .build()

        realm = Realm.open(config)
    }
}