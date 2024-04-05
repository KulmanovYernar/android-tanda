package tandapp.domain.event

data class Event<out T>(
    val status: Status,
    val data: T? = null,
    val message: String? = null,
    val error: Error? = null,
    val statusCode:Int? = null
) {

    suspend fun onSuccess(callback: suspend (T?) -> Unit) {
        if (status == Status.SUCCESS) callback(data)
    }

    suspend fun onLoading(callback: suspend (T?) -> Unit) {
        if (status == Status.LOADING) callback(data)
    }

    fun onError(callback: (String?) -> Unit) {
        if (status == Status.ERROR) callback(message)
    }

    fun isLoading(): Boolean = status == Status.LOADING

    fun isSuccess(): Boolean = status == Status.SUCCESS

    fun isError(): Boolean = status == Status.ERROR

    companion object {
        fun <T> loading(): Event<T> {
            return Event(Status.LOADING, null, null)
        }

        fun <T> success(data: T?, message: String? = null, statusCode: Int? = null): Event<T> {
            return Event(Status.SUCCESS, data, message, statusCode = statusCode)
        }

        fun <T> error(message: String?, data: T? = null): Event<T> {
            return Event(Status.ERROR, data, message)
        }
        fun <T> error(message: String?, data: T? = null, statusCode:Int? = null): Event<T> {
            return Event(Status.ERROR, data, message, statusCode = statusCode)
        }

        fun <T> error(error: Error?, message: String? = null, data: T? = null, statusCode: Int? = null): Event<T> {
            return Event(Status.ERROR, data, message, error, statusCode = statusCode)
        }
    }
}