package br.com.angelcomp.network

import retrofit2.Response
import javax.net.ssl.HttpsURLConnection

sealed class Output<out Response> {
    data class Success<Response> (val value: Response): Output<Response>()
    data class Failure(val statusCode: Int): Output<Nothing>()
}

fun <R: Any> Response<R>.paseResponse(): Output<R> {
    if (isSuccessful) {
        val body = body()

        if (body != null) {
            return Output.Success(body)
        }
    } else {
        return Output.Failure(code())
    }

    return Output.Failure(HttpsURLConnection.HTTP_INTERNAL_ERROR)
}