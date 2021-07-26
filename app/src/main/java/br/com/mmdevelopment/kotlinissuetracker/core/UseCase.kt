package br.com.mmdevelopment.kotlinissuetracker.core

import kotlinx.coroutines.flow.Flow

abstract class UseCase<Param, Param2, Source> {
    abstract suspend fun execute(param: Param, param2: Param2): Flow<Source>

    open suspend operator fun invoke(param: Param, param2: Param2) = execute(param, param2)

    abstract class NoParam<Source> : UseCase<None, None, Flow<Source>>() {
        abstract suspend fun execute(): Flow<Source>

        final override suspend fun execute(param: None, param2: None) =
            throw UnsupportedOperationException()

        suspend operator fun invoke(): Flow<Source> = execute()
    }

    abstract class NoSource<Params, Params2> : UseCase<Params, Params2, Unit>() {
        override suspend operator fun invoke(param: Params, param2: Params2) = execute(param, param2)
    }

    object None
}