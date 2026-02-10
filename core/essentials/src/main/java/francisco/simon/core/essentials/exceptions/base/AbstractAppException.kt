package francisco.simon.core.essentials.exceptions.base

abstract class AppException(
    message: String,
    cause: Throwable? = null
) : Exception(message, cause)