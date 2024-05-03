import androidx.lifecycle.ViewModelStore
import androidx.lifecycle.ViewModelStoreOwner

class DesktopViewModelStoreOwner(private val store: ViewModelStore) : ViewModelStoreOwner {
    override val viewModelStore: ViewModelStore = store
}