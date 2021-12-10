package br.com.angelcomp.network

abstract class BaseResponse<Data> {
    abstract val categories: List<Data>
}